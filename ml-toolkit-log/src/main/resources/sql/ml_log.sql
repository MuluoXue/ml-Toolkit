
CREATE TABLE `ml_log`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `logName`         varchar(100) DEFAULT NULL COMMENT '业务名称',
    `log_describe` varchar(255) DEFAULT NULL COMMENT '业务操作描述',
    `operator`     varchar(100) DEFAULT NULL COMMENT '创建人',
    `operate_time`  datetime     DEFAULT NULL COMMENT '创建时间',
    `ip`           varchar(50)  DEFAULT NULL COMMENT '操作来源ip',
    `path`         varchar(100) DEFAULT NULL COMMENT '请求路径',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='业务操作日志'