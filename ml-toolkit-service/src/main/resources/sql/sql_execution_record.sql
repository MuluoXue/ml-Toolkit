CREATE TABLE `sql_execution_record`
(
    `id` decimal(20,0) NOT NULL COMMENT '',
    `create_time` datetime DEFAULT NULL COMMENT '',
    `update_time` datetime DEFAULT NULL COMMENT '',
    `execution_name` varchar(100) DEFAULT NULL COMMENT '',
    `state` char(1) DEFAULT NULL COMMENT '',
    `error_sql` varchar(500) DEFAULT NULL COMMENT '',
    `error_msg` varchar(500) DEFAULT NULL COMMENT '',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT=''
