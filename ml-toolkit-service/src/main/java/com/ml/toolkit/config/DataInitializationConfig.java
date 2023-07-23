package com.ml.toolkit.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.dao.sql.SqlExecutionDao;
import com.ml.toolkit.domain.sql.SqlExecutionRecord;
import com.ml.toolkit.service.sql.SqlExecutionRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.BadSqlGrammarException;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Slf4j
@Configuration
public class DataInitializationConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private SqlExecutionRecordService sqlExecutionRecordService;

    @Autowired
    private SqlExecutionDao sqlExecutionDao;

    @PostConstruct
    public void init() throws IOException {
        System.out.println("DataInitializationConfig sql执行器, 在spring初始化后调用, 报错可拦截启动");
        Resource[] resources = applicationContext.getResources("classpath*:/sql/sqlRecord/*.sql");
        for (Resource resource : resources) {
            File file = resource.getFile();
            String fileName = file.getName();
            QueryWrapper<SqlExecutionRecord> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(SqlExecutionRecord::getExecutionName, fileName);
            List<SqlExecutionRecord> list = sqlExecutionRecordService.list(wrapper);
            if (ObjectUtil.isNotEmpty(list)) {
                return;
            }

            SqlExecutionRecord sqlExecutionRecord = new SqlExecutionRecord();
            sqlExecutionRecord.setState(0);
            sqlExecutionRecord.setCreateTime(new Date());
            String sql = "";
            try {
                List<String> lines = Files.readAllLines(Paths.get(file.getPath()));
                for (String line : lines) {
                    if (ObjectUtil.isNotEmpty(line)) {
                        sql = line;
                        sqlExecutionDao.execute(sql);
                    }
                }
            } catch (Exception e) {
                sqlExecutionRecord.setState(1);
                sqlExecutionRecord.setErrorSql(sql);
                String errorMsg = e.getMessage();
                if (e instanceof  BadSqlGrammarException) {
                    SQLException sqlException = ((BadSqlGrammarException) e).getSQLException();
                    errorMsg = sqlException.getMessage();
                }
                if (errorMsg.length() > 500) {
                    errorMsg = e.getMessage().substring(0, 499);
                }
                sqlExecutionRecord.setErrorMsg(errorMsg);
                log.error("执行sql失败， sql所在文件名称 {}, 错误sql： {}", file.getName(), sql);
                log.error("DataInitializationConfig init error ", e);
            } finally {
                sqlExecutionRecord.setExecutionName(fileName);
                sqlExecutionRecordService.save(sqlExecutionRecord);
            }
        }
    }

}
