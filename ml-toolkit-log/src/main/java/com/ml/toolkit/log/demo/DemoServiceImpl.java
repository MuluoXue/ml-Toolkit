package com.ml.toolkit.log.demo;

import com.ml.toolkit.log.BusLog;
import org.springframework.stereotype.Service;

@BusLog(name = "demo操作")
@Service
public class DemoServiceImpl implements DemoService{

    @BusLog(describe = "新增demo")
    @Override
    public void insert(Demo demo) {

    }

    /**
     * 如果要添加操作人，目前默认取的是最后一个参数
     * @param demo demo
     * @param operator 操作人
     */
    @BusLog(describe = "新增demo,添加操作人")
    @Override
    public void insert(Demo demo, String operator) {

    }
}
