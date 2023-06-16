package com.ml.toolkit.log.demo;

import com.ml.toolkit.log.annotation.LogTableName;
import lombok.Data;

@Data
@LogTableName(name = "demo_log")
public class Demo {

    private String name;
}
