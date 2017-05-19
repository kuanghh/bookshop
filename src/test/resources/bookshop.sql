/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/5/19 16:21:07                           */
/*==============================================================*/


drop table if exists t_admin;

drop table if exists t_cart;

drop table if exists t_category;

drop table if exists t_category_goods;

drop table if exists t_goods;

drop table if exists t_orders;

drop table if exists t_permission;

drop table if exists t_person;

drop table if exists t_person_role;

drop table if exists t_role;

drop table if exists t_role_permission;

drop table if exists t_shop;

drop table if exists t_user;

/*==============================================================*/
/* Table: t_admin                                               */
/*==============================================================*/
create table t_admin
(
   id                   varchar(32) not null comment '唯一标识',
   name                 varchar(50) not null comment '名字',
   is_valid             tinyint not null comment '是否有效',
   primary key (id)
);

/*==============================================================*/
/* Table: t_cart                                                */
/*==============================================================*/
create table t_cart
(
   id                   varchar(32) not null comment '唯一标识',
   update_time          timestamp not null comment '最后更新的时间',
   num                  int not null comment '商品数量',
   goods_id             varchar(32) not null comment '商品id',
   user_id              varchar(32) not null comment '买家id',
   is_valid             tinyint not null comment '是否有效',
   primary key (id)
);

/*==============================================================*/
/* Table: t_category                                            */
/*==============================================================*/
create table t_category
(
   id                   varchar(32) not null comment '唯一标识',
   name                 varchar(50) not null comment '唯一标识',
   is_valid             tinyint not null comment '数据是否有效',
   primary key (id)
);

/*==============================================================*/
/* Table: t_category_goods                                      */
/*==============================================================*/
create table t_category_goods
(
   id                   varchar(32) not null comment '唯一标识',
   category_id          varchar(32) not null comment '商品类别id',
   goods_id             varchar(32) not null comment '商品id',
   is_valid             tinyint not null comment '数据是否有效',
   primary key (id)
);

/*==============================================================*/
/* Table: t_goods                                               */
/*==============================================================*/
create table t_goods
(
   id                   varchar(32) not null comment '唯一标识',
   name                 varchar(50) not null comment '商品名称',
   price                double not null comment '商品单价',
   promotinal_price     double not null comment '促销价格',
   num                  int not null comment '库存',
   description          varchar(50) comment '商品描述',
   create_time          timestamp not null comment '上线日期',
   pictures             varchar(500) not null comment '商品图片',
   postFree             double not null comment '邮费',
   state                int not null comment '(1：上架，0：下架)',
   shop_id              varchar(32) not null comment '店铺id',
   is_valid             tinyint not null comment '数据是否有效',
   primary key (id)
);

/*==============================================================*/
/* Table: t_orders                                              */
/*==============================================================*/
create table t_orders
(
   id                   varchar(32) not null comment '唯一标识',
   serial               varchar(15) not null comment '订单编号',
   create_time          timestamp not null comment '创建时间',
   num                  int not null comment '商品个数',
   total_price          double not null comment '总价',
   goods_id             varchar(32) not null comment '商品id',
   shop_id              varchar(32) not null comment '店铺id',
   user_id              varchar(32) not null comment '买家id',
   state                tinyint not null comment '是否处理(0:未发货，1：已发货)',
   is_valid             tinyint not null comment '数据是否有效',
   primary key (id)
);

/*==============================================================*/
/* Table: t_permission                                          */
/*==============================================================*/
create table t_permission
(
   id                   varchar(32) not null comment '唯一标识',
   name                 varchar(20) not null comment '权限名称',
   description          varchar(50) not null comment '权限描述',
   sign                 varchar(20) not null comment '权限标识',
   is_valid             tinyint not null comment '数据是否有效',
   primary key (id)
);

/*==============================================================*/
/* Table: t_person                                              */
/*==============================================================*/
create table t_person
(
   id                   varchar(32) not null comment '唯一标识',
   account              varchar(50) not null comment '登录帐号',
   email                varchar(50) not null comment '邮箱',
   phone                varchar(13) not null comment '电话号码',
   password             varchar(20) not null comment '登录密码',
   is_valid             tinyint not null comment '数据是否有效',
   primary key (id)
);

/*==============================================================*/
/* Table: t_person_role                                         */
/*==============================================================*/
create table t_person_role
(
   id                   varchar(32) not null comment '唯一标识',
   person_id            varchar(32) not null comment '人的唯一标识',
   role_id              varchar(32) not null comment '角色的唯一标识',
   is_valid             tinyint not null comment '数据是否有效',
   primary key (id)
);

/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
create table t_role
(
   id                   varchar(32) not null comment '唯一标识',
   name                 varchar(50) not null comment '角色名字',
   description          varchar(80) not null comment '角色描述',
   sign                 varchar(20) not null comment '角色标识',
   is_valid             tinyint not null comment '数据是否有效',
   primary key (id)
);

/*==============================================================*/
/* Table: t_role_permission                                     */
/*==============================================================*/
create table t_role_permission
(
   id                   varchar(32) not null comment '唯一标识',
   role_id              varchar(32) not null comment '角色id',
   permission_id        varchar(32) not null comment '权限id',
   is_valid             tinyint not null comment '数据是否有效',
   primary key (id)
);

/*==============================================================*/
/* Table: t_shop                                                */
/*==============================================================*/
create table t_shop
(
   id                   varchar(32) not null comment '唯一标识',
   shop_name            varchar(50) not null comment '店铺名称',
   own_name             varchar(50) not null comment '店主名字',
   own_id_card          varchar(18) not null comment '店主身份证',
   address              varchar(50) not null comment '联系地址',
   create_time          timestamp not null comment '注册时间',
   authentication_time  timestamp not null comment '认证时间',
   state                int not null comment '(0：否，1：是)',
   is_valid             tinyint not null comment '数据是否有效',
   primary key (id)
);

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   varchar(32) not null comment '唯一标识',
   name                 varchar(50) not null comment '姓名',
   birthday             timestamp not null comment '出生年月日',
   address              varchar(200) comment '收货地址',
   create_time          timestamp not null comment '注册时间',
   is_valid             tinyint not null comment '数据是否有效',
   primary key (id)
);

