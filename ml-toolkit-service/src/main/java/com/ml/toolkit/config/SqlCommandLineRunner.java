package com.ml.toolkit.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SqlCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("sql 执行器SqlCommandLineRunner 在服务启动完成后执行");
    }
}
