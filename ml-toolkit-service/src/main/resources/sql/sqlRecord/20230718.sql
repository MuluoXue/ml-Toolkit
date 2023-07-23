alter table form_field add column type varchar(10) default null comment '字段类型';

update form_field set type = 'TEXT' where type is null;

