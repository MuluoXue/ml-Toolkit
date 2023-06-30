
CREATE TABLE `form_field`
(
    `id`          decimal(20, 0) NOT NULL COMMENT '',
    `name`        varchar(50)    DEFAULT NULL COMMENT '',
    `form_id`     decimal(20, 0)   DEFAULT NULL COMMENT '',
    `create_time` datetime       DEFAULT NULL COMMENT '',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT =''

