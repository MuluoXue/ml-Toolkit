
CREATE TABLE `base_log`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `operate_type`         varchar(50) DEFAULT NULL COMMENT '操作类型',
    `log_name`         varchar(100) DEFAULT NULL COMMENT '业务名称',
    `function_name` varchar(100) DEFAULT NULL COMMENT '方法名称',
    `function_path` varchar(200) DEFAULT NULL COMMENT '方法路径',
    `operator`     varchar(100) DEFAULT NULL COMMENT '操作人',
    `operate_time`  datetime     DEFAULT NULL COMMENT '操作时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='业务操作日志'