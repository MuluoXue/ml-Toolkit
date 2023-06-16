package com.ml.toolkit.log.service.impl;

import com.ml.toolkit.common.generate.LongIdGenerator;
import com.ml.toolkit.common.util.Assert;
import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.log.dao.BaseLogDao;
import com.ml.toolkit.log.domain.BaseLog;
import com.ml.toolkit.log.service.BaseLogService;
import com.ml.toolkit.mybatis.plus.base.BaseServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BaseLogServiceImpl extends BaseServiceImpl<BaseLogDao, BaseLog> implements BaseLogService {

    @Resource
    private BaseLogDao baseLogDao;

    @Override
    public void saveCustomTableName(String tableName, BaseLog baseLog) {
        Assert.notEmpty("params is null", tableName, baseLog);
        if (ObjectUtil.isEmpty(baseLog.getId())) {
            baseLog.setId(LongIdGenerator.generate());
        }
        baseLogDao.insertCustomTableName(tableName, baseLog);
    }
}
