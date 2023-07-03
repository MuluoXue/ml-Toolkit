
CREATE TABLE `form_data_detail`
(
    `id` decimal(20,0) NOT NULL COMMENT '',
    `create_time` datetime DEFAULT NULL COMMENT '',
    `data_id` decimal(20,0) DEFAULT NULL COMMENT '',
    `field_id` decimal(20,0) DEFAULT NULL COMMENT '',
    `content` varchar(50) DEFAULT NULL COMMENT '',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT=''