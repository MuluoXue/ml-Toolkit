package com.ml.toolkit.service.sql;

import com.ml.toolkit.dao.sql.SqlExecutionRecordDao;
import com.ml.toolkit.domain.sql.SqlExecutionRecord;
import com.ml.toolkit.mybatis.plus.base.BaseServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class SqlExecutionRecordServiceImpl extends BaseServiceImpl<SqlExecutionRecordDao, SqlExecutionRecord> implements SqlExecutionRecordService {
}
