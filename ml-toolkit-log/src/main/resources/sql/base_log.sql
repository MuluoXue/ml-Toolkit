
CREATE TABLE `base_log`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `type`         varchar(50) DEFAULT NULL COMMENT '操作类型',
    `logName`         varchar(100) DEFAULT NULL COMMENT '业务名称',
    `functionName` varchar(100) DEFAULT NULL COMMENT '方法名称',
    `functionPath` varchar(200) DEFAULT NULL COMMENT '方法路径',
    `operator`     varchar(100) DEFAULT NULL COMMENT '创建人',
    `operate_time`  datetime     DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='业务操作日志'