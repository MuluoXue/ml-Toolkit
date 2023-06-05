package com.ml.toolkit.log.demo;

import com.ml.toolkit.log.MlBusLog;
import org.springframework.stereotype.Service;

@MlBusLog(name = "demo操作")
@Service
public class DemoServiceImpl implements DemoService{

    @MlBusLog(describe = "新增demo")
    @Override
    public void insert(Demo demo) {

    }
}
