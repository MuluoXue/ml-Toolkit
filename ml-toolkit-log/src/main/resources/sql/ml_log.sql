create table if not exists ml_log
(
    id bigint auto_increment comment '自增id'
    primary key,
    name varchar(100) null comment '业务名称',
    log_describe  varchar(255) null comment '业务操作描述',
    operator varchar(100) null comment '操作人',
    operator_time datetime null comment '操作时间',
    ip varchar(50) null comment '操作来源ip',
    path varchar(100) null comment '请求路径'
)comment '业务操作日志' default charset ='utf8';