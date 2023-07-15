CREATE TABLE `form_data_detail`
(
    `id`          decimal(20, 0) NOT NULL,
    `data_id`     decimal(20, 0) DEFAULT NULL,
    `field_id`    decimal(20, 0) DEFAULT NULL,
    `content`     varchar(50)    DEFAULT NULL,
    `creator`     decimal(20, 0) NOT NULL,
    `create_time` datetime       DEFAULT NULL,
    `update_time` datetime       DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8