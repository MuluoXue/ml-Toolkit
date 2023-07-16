CREATE TABLE `sys_user`
(
    `id`          decimal(20, 0) NOT NULL,
    `name`        varchar(100) DEFAULT NULL COMMENT '名称',
    `account`     varchar(50)  DEFAULT NULL COMMENT '账号',
    `password`    varchar(50)  DEFAULT NULL,
    `status`      char(1)      DEFAULT 0 COMMENT '类型 0正常， 1 禁用',
    `creator`     decimal(20, 0) DEFAULT NULL,
    `create_time` datetime     DEFAULT NULL,
    `update_time` datetime     DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8