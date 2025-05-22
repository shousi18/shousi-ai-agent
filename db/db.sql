-- auto-generated definition
create table if not exists merchant2
(
    id          bigint auto_increment comment 'id'
        primary key,
    merchant_id bigint        not null comment '商家id',
    good_id     bigint        not null comment '商品id',
    good_name   varchar(256)  not null comment '商品名字',
    city_name   varchar(256)  not null comment '城市',
    problem     varchar(512)  not null comment '问题',
    good_info   varchar(4096) null comment '其他信息'
);