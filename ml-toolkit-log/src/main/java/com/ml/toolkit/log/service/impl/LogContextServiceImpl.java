package com.ml.toolkit.log.service.impl;

import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.log.annotation.LogTableName;
import com.ml.toolkit.log.domain.BaseLog;
import com.ml.toolkit.log.domain.LogContext;
import com.ml.toolkit.log.service.BaseLogService;
import com.ml.toolkit.log.service.LogContextService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class LogContextServiceImpl implements LogContextService {

    @Resource
    private BaseLogService baseLogService;

    @Override
    public void saveLog(LogContext logContext) {
        BaseLog mlBaseLog = new BaseLog();
        mlBaseLog.setLogName(logContext.getLogName());
        mlBaseLog.setFunctionName(logContext.getFunctionName());
        mlBaseLog.setFunctionPath(logContext.getFunctionPath());
        mlBaseLog.setOperator(logContext.getOperator());
        mlBaseLog.setOperateTime(new Date());

        Object newObject = logContext.getNewObject();
        if (newObject != null) {
            Class<?> aClass = newObject.getClass();
            LogTableName annotation = aClass.getAnnotation(LogTableName.class);
            if (ObjectUtil.isNotEmpty(annotation) && ObjectUtil.isNotEmpty(annotation.name())) {
                baseLogService.saveCustomTableName(annotation.name(), mlBaseLog);
            } else {
                baseLogService.save(mlBaseLog);
            }
        }
    }
}
