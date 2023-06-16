package com.ml.toolkit.log.demo;

import com.ml.toolkit.log.annotation.BusLog;
import com.ml.toolkit.log.domain.LogContext;
import com.ml.toolkit.log.service.LogContextService;
import com.ml.toolkit.log.service.impl.LogContextServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@BusLog(name = "demo操作")
@Service
public class DemoServiceImpl implements DemoService{

    @Resource
    private LogContextService logContextService;

    @BusLog(functionName = "新增demo")
    @Override
    public void insert(Demo demo) {

    }

    /**
     * 如果要添加操作人，目前默认取的是最后一个参数
     * @param demo demo
     * @param operator 操作人
     */
    @BusLog(functionName = "新增demo,添加操作人")
    @Override
    public void insert(Demo demo, String operator) {

    }

    @Override
    public void saveTableName() {
        LogContext logContext = new LogContext();
        logContext.setNewObject(new Demo());
        logContextService.saveLog(logContext);
    }
}
