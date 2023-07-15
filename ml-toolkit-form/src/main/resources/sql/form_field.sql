CREATE TABLE `form_field`
(
    `id`          decimal(20, 0) NOT NULL,
    `name`        varchar(50)    DEFAULT NULL,
    `form_id`     decimal(20, 0) DEFAULT NULL,
    `creator`     decimal(20, 0) NOT NULL,
    `create_time` datetime       DEFAULT NULL,
    `update_time` datetime       DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8