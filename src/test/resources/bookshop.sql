/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/5/17 15:20:52                           */
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
   id                   varchar(32) not null comment 'Ψһ��ʶ',
   name                 varchar(50) not null comment '����',
   is_valid             tinyint not null comment '�Ƿ���Ч',
   primary key (id)
);

/*==============================================================*/
/* Table: t_cart                                                */
/*==============================================================*/
create table t_cart
(
   id                   varchar(32) not null comment 'Ψһ��ʶ',
   update_time          timestamp not null comment '�����µ�ʱ��',
   num                  int not null comment '��Ʒ����',
   goods_id             varchar(32) not null comment '��Ʒid',
   user_id              varchar(32) not null comment '���id',
   is_valid             tinyint not null comment '�Ƿ���Ч',
   primary key (id)
);

/*==============================================================*/
/* Table: t_category                                            */
/*==============================================================*/
create table t_category
(
   id                   varchar(32) not null comment 'Ψһ��ʶ',
   name                 varchar(50) not null comment 'Ψһ��ʶ',
   is_valid             tinyint not null comment '�����Ƿ���Ч',
   primary key (id)
);

/*==============================================================*/
/* Table: t_category_goods                                      */
/*==============================================================*/
create table t_category_goods
(
   id                   varchar(32) not null comment 'Ψһ��ʶ',
   category_id          varchar(32) not null comment '��Ʒ���id',
   goods_id             varchar(32) not null comment '��Ʒid',
   is_valid             tinyint not null comment '�����Ƿ���Ч',
   primary key (id)
);

/*==============================================================*/
/* Table: t_goods                                               */
/*==============================================================*/
create table t_goods
(
   id                   varchar(32) not null comment 'Ψһ��ʶ',
   name                 varchar(50) not null comment '��Ʒ����',
   price                double not null comment '��Ʒ����',
   promotinal_price     double not null comment '�����۸�',
   num                  int not null comment '���',
   description          varchar(50) comment '��Ʒ����',
   create_time          timestamp not null comment '��������',
   pictures             varchar(65535) not null comment '��ƷͼƬ',
   postFree             double not null comment '�ʷ�',
   state                tinyint not null comment '(1���ϼܣ�0���¼�)',
   shop_id              varchar(32) not null comment '����id',
   is_valid             tinyint not null comment '�����Ƿ���Ч',
   primary key (id)
);

/*==============================================================*/
/* Table: t_orders                                              */
/*==============================================================*/
create table t_orders
(
   id                   varchar(32) not null comment 'Ψһ��ʶ',
   serial               varchar(15) not null comment '�������',
   create_time          timestamp not null comment '����ʱ��',
   num                  int not null comment '��Ʒ����',
   total_price          double not null comment '�ܼ�',
   goods_id             varchar(32) not null comment '��Ʒid',
   shop_id              varchar(32) not null comment '����id',
   user_id              varchar(32) not null comment '���id',
   state                tinyint not null comment '�Ƿ���(0:δ������1���ѷ���)',
   is_valid             tinyint not null comment '�����Ƿ���Ч',
   primary key (id)
);

/*==============================================================*/
/* Table: t_permission                                          */
/*==============================================================*/
create table t_permission
(
   id                   varchar(32) not null comment 'Ψһ��ʶ',
   name                 varchar(20) not null comment 'Ȩ������',
   description          varchar(50) not null comment 'Ȩ������',
   sign                 varchar(20) not null comment 'Ȩ�ޱ�ʶ',
   is_valid             tinyint not null comment '�����Ƿ���Ч',
   primary key (id)
);

/*==============================================================*/
/* Table: t_person                                              */
/*==============================================================*/
create table t_person
(
   id                   varchar(32) not null comment 'Ψһ��ʶ',
   account              varchar(50) not null comment '��¼�ʺ�',
   email                varchar(50) not null comment '����',
   phone                varchar(13) not null comment '�绰����',
   password             varchar(20) not null comment '��¼����',
   is_valid             tinyint not null comment '�����Ƿ���Ч',
   primary key (id)
);

/*==============================================================*/
/* Table: t_person_role                                         */
/*==============================================================*/
create table t_person_role
(
   id                   varchar(32) not null comment 'Ψһ��ʶ',
   person_id            varchar(32) not null comment '�˵�Ψһ��ʶ',
   role_id              varchar(32) not null comment '��ɫ��Ψһ��ʶ',
   is_valid             tinyint not null comment '�����Ƿ���Ч',
   primary key (id)
);

/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
create table t_role
(
   id                   varchar(32) not null comment 'Ψһ��ʶ',
   name                 varchar(50) not null comment '��ɫ����',
   description          varchar(80) not null comment '��ɫ����',
   sign                 varchar(20) not null comment '��ɫ��ʶ',
   is_valid             tinyint not null comment '�����Ƿ���Ч',
   primary key (id)
);

/*==============================================================*/
/* Table: t_role_permission                                     */
/*==============================================================*/
create table t_role_permission
(
   id                   varchar(32) not null comment 'Ψһ��ʶ',
   role_id              varchar(32) not null comment '��ɫid',
   permission_id        varchar(32) not null comment 'Ȩ��id',
   is_valid             tinyint not null comment '�����Ƿ���Ч',
   primary key (id)
);

/*==============================================================*/
/* Table: t_shop                                                */
/*==============================================================*/
create table t_shop
(
   id                   varchar(32) not null comment 'Ψһ��ʶ',
   shop_name            varchar(50) not null comment '��������',
   own_name             varchar(50) not null comment '��������',
   own_id_card          varchar(18) not null comment '�������֤',
   address              varchar(50) not null comment '��ϵ��ַ',
   create_time          timestamp  comment 'ע��ʱ��',
   authentication_time  timestamp  comment '��֤ʱ��',
   state                int not null comment '(0����1����)',
   is_valid             tinyint not null comment '�����Ƿ���Ч',
   primary key (id)
);

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   varchar(32) not null comment 'Ψһ��ʶ',
   name                 varchar(50) not null comment '����',
   birthday             timestamp not null comment '����������',
   address              varchar(200) comment '�ջ���ַ',
   create_time          timestamp not null comment 'ע��ʱ��',
   is_valid             tinyint not null comment '�����Ƿ���Ч',
   primary key (id)
);

