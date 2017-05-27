/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : bookshop

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-05-27 10:14:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` varchar(32) NOT NULL COMMENT '唯一标识',
  `name` varchar(50) NOT NULL COMMENT '名字',
  `is_valid` tinyint(4) NOT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('c6b5b3df42874e68b3769266c648c2a8', 'kuanghh', '1');

-- ----------------------------
-- Table structure for t_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart` (
  `id` varchar(32) NOT NULL COMMENT '唯一标识',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新的时间',
  `num` int(11) NOT NULL COMMENT '商品数量',
  `goods_id` varchar(32) NOT NULL COMMENT '商品id',
  `user_id` varchar(32) NOT NULL COMMENT '买家id',
  `is_valid` tinyint(4) NOT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cart
-- ----------------------------
INSERT INTO `t_cart` VALUES ('19c5e9ec2a2846d88b7a44a70bcd7179', '2017-05-26 13:34:15', '1', '1f601972aeb449639028650ad78b5b02', '0f56cebe5f6b4437abb99696dc263261', '0');
INSERT INTO `t_cart` VALUES ('3d1a815fdcc74514a4c0de3025180af4', '2017-05-26 13:21:31', '7', 'c77da7519959469997431725c93d1012', '0f56cebe5f6b4437abb99696dc263261', '0');
INSERT INTO `t_cart` VALUES ('486e6d2aeeff459c896b8278ae4dda29', '2017-05-26 13:21:31', '3', '341cb9e5eab743218e893d709737a1bc', '0f56cebe5f6b4437abb99696dc263261', '0');
INSERT INTO `t_cart` VALUES ('a13d4e10974a4266a53c8dbbfe41e4d7', '2017-05-26 13:21:31', '1', 'dc67071c1f0e4150836246f389680740', '0f56cebe5f6b4437abb99696dc263261', '0');
INSERT INTO `t_cart` VALUES ('af0c2c85a708485998c0f7cd87fdd7e4', '2017-05-26 13:34:15', '1', '5f39a023a1e54d8f9368fba264fa12ef', '0f56cebe5f6b4437abb99696dc263261', '0');
INSERT INTO `t_cart` VALUES ('b4002fa3965f4b689627a6ef2629b236', '2017-05-26 13:28:00', '3', '7064ccfd72b84128bc26e237a030bde8', '0f56cebe5f6b4437abb99696dc263261', '0');
INSERT INTO `t_cart` VALUES ('b9287d62caad4f1aab22ca22df4cf332', '2017-05-26 13:28:00', '2', 'c77da7519959469997431725c93d1012', '0f56cebe5f6b4437abb99696dc263261', '0');
INSERT INTO `t_cart` VALUES ('d396bb2080064da5902b2c34de424600', '2017-05-26 17:13:48', '1', 'd8c1ab64944c47d2ac261b4de9a9ad67', '0f56cebe5f6b4437abb99696dc263261', '0');
INSERT INTO `t_cart` VALUES ('e9667f099d8a4dfcaaa6751d2dcf355a', '2017-05-26 17:13:48', '2', '7064ccfd72b84128bc26e237a030bde8', '0f56cebe5f6b4437abb99696dc263261', '0');

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` varchar(32) NOT NULL COMMENT '唯一标识',
  `name` varchar(50) NOT NULL COMMENT '唯一标识',
  `is_valid` tinyint(4) NOT NULL COMMENT '数据是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('1e0f3a01bbc24762bd88a5610b162b51', '分类5', '1');
INSERT INTO `t_category` VALUES ('1fe05c3681894746b0c8296839eb385e', '分类10', '1');
INSERT INTO `t_category` VALUES ('336a69d6e4024231b9f5095f73259afb', '分类11', '1');
INSERT INTO `t_category` VALUES ('35c1a3263cac456f99fc3653a26642fb', '分类9', '1');
INSERT INTO `t_category` VALUES ('36a7d3773bde45dca309dd63ccd6fc7c', '分类8', '1');
INSERT INTO `t_category` VALUES ('49d4c270e2054c59be8b4b35017dc2bc', '分类3', '1');
INSERT INTO `t_category` VALUES ('4a4ab0dced604309ba11c1c1a6a916e7', '分类2', '1');
INSERT INTO `t_category` VALUES ('4ed5923341bc4ccda091f279ede910c8', '分类6', '1');
INSERT INTO `t_category` VALUES ('5efe68ed3e95452dae583356129d0c61', '分类7', '1');
INSERT INTO `t_category` VALUES ('838da19c946f42e99512cb4bd8e0d7bc', '分类1', '1');
INSERT INTO `t_category` VALUES ('92539918e4c6418f947b45b3010eaabf', '分类4', '1');

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` varchar(32) NOT NULL COMMENT '唯一标识',
  `name` varchar(50) NOT NULL COMMENT '商品名称',
  `price` bigint(20) NOT NULL COMMENT '商品单价',
  `promotinal_price` bigint(20) NOT NULL COMMENT '促销价格',
  `num` int(11) NOT NULL COMMENT '库存',
  `description` varchar(50) DEFAULT NULL COMMENT '商品描述',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '上线日期',
  `pictures` varchar(500) NOT NULL COMMENT '商品图片',
  `postFree` bigint(20) NOT NULL COMMENT '邮费',
  `state` int(4) NOT NULL COMMENT '(1：上架，0：下架)',
  `shop_id` varchar(32) NOT NULL COMMENT '店铺id',
  `category_id` varchar(32) NOT NULL,
  `is_valid` tinyint(4) NOT NULL COMMENT '数据是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('006cb265299e44e7a7451781dcee19a7', '书本12', '922', '900', '100', '12', '2017-05-23 00:04:35', '[\"E:/img/1495469074775_logo.png\"]', '0', '1', '4689f3d9dfc04eba9e80cf0fa487981e', '336a69d6e4024231b9f5095f73259afb', '1');
INSERT INTO `t_goods` VALUES ('1ee78c83afee443b8b982669c81146a5', '书本15', '933', '899', '100', '15', '2017-05-23 11:43:06', '[\"E:/img/1495469262205_logo.png\"]', '100', '1', '4689f3d9dfc04eba9e80cf0fa487981e', '4a4ab0dced604309ba11c1c1a6a916e7', '1');
INSERT INTO `t_goods` VALUES ('1f601972aeb449639028650ad78b5b02', '书本10', '1066', '900', '4999', '10', '2017-05-22 23:54:52', '[\"E:/img/1495463595399_logo.png\"]', '100', '1', '4689f3d9dfc04eba9e80cf0fa487981e', '1fe05c3681894746b0c8296839eb385e', '1');
INSERT INTO `t_goods` VALUES ('341cb9e5eab743218e893d709737a1bc', '书本2', '922', '899', '97', '2', '2017-05-23 15:27:24', '[\"E:/img/1495442734277_logo.png\"]', '100', '1', '4689f3d9dfc04eba9e80cf0fa487981e', '49d4c270e2054c59be8b4b35017dc2bc', '1');
INSERT INTO `t_goods` VALUES ('4f214077c56c4749b96643782fc2a263', '书本55', '111', '899', '5000', '55', '2017-05-23 15:49:50', '[\"E:/img/1495525790697_logo.png\"]', '100', '1', '4689f3d9dfc04eba9e80cf0fa487981e', '1e0f3a01bbc24762bd88a5610b162b51', '1');
INSERT INTO `t_goods` VALUES ('5f39a023a1e54d8f9368fba264fa12ef', '书本4', '1055', '1098', '4999', '4', '2017-05-22 21:59:46', '[\"E:/img/1495443792034_logo.png\"]', '250', '1', '4689f3d9dfc04eba9e80cf0fa487981e', '49d4c270e2054c59be8b4b35017dc2bc', '1');
INSERT INTO `t_goods` VALUES ('7064ccfd72b84128bc26e237a030bde8', '书本6', '1066', '899', '4995', '6', '2017-05-22 21:59:46', '[\"E:/img/1495444030620_logo.png\"]', '100', '1', '4689f3d9dfc04eba9e80cf0fa487981e', '49d4c270e2054c59be8b4b35017dc2bc', '1');
INSERT INTO `t_goods` VALUES ('c77da7519959469997431725c93d1012', '书本1', '933', '900', '91', '1', '2017-05-22 21:59:46', '[\"E:/img/1495443792034_logo.png\"]', '0', '1', '4689f3d9dfc04eba9e80cf0fa487981e', '49d4c270e2054c59be8b4b35017dc2bc', '1');
INSERT INTO `t_goods` VALUES ('d8c1ab64944c47d2ac261b4de9a9ad67', '书本11', '922', '899', '99', '11', '2017-05-22 23:55:09', '[\"E:/img/1495463922339_logo.png\"]', '100', '1', '4689f3d9dfc04eba9e80cf0fa487981e', '838da19c946f42e99512cb4bd8e0d7bc', '1');
INSERT INTO `t_goods` VALUES ('dc67071c1f0e4150836246f389680740', '书本3', '1066', '1022', '99', '3', '2017-05-22 21:59:47', '[\"E:/img/1495443381825_logo.png\"]', '100', '1', '4689f3d9dfc04eba9e80cf0fa487981e', '49d4c270e2054c59be8b4b35017dc2bc', '1');
INSERT INTO `t_goods` VALUES ('e226cc303a914f0095aa89719904a9d0', '书本13', '1066', '900', '100', '13', '2017-05-23 00:06:42', '[\"E:/img/1495469201663_logo.png\"]', '100', '1', '4689f3d9dfc04eba9e80cf0fa487981e', '1e0f3a01bbc24762bd88a5610b162b51', '1');
INSERT INTO `t_goods` VALUES ('ee3d274c7d43413280a0dd8029638234', '书本14', '933', '900', '5000', '14', '2017-05-23 09:21:51', '[\"E:/img/1495502511146_logo.png\"]', '0', '1', '4689f3d9dfc04eba9e80cf0fa487981e', '336a69d6e4024231b9f5095f73259afb', '1');
INSERT INTO `t_goods` VALUES ('f8e380644f3f4c498e0bc206dbeb509c', '书本7', '1066', '900', '100', '7', '2017-05-22 21:59:48', '[\"E:/img/1495444478822_logo.png\",\"E:/img/1495444478824_logo.png\"]', '250', '1', '4689f3d9dfc04eba9e80cf0fa487981e', '49d4c270e2054c59be8b4b35017dc2bc', '1');

-- ----------------------------
-- Table structure for t_orders
-- ----------------------------
DROP TABLE IF EXISTS `t_orders`;
CREATE TABLE `t_orders` (
  `id` varchar(32) NOT NULL COMMENT '唯一标识',
  `serial` varchar(15) NOT NULL COMMENT '订单编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `num` int(11) NOT NULL COMMENT '商品个数',
  `total_price` bigint(20) NOT NULL COMMENT '总价',
  `goods_id` varchar(32) NOT NULL COMMENT '商品id',
  `shop_id` varchar(32) NOT NULL COMMENT '店铺id',
  `user_id` varchar(32) NOT NULL COMMENT '买家id',
  `address` varchar(255) NOT NULL,
  `state` int(4) NOT NULL COMMENT '是否处理(0:未发货，1：已发货)',
  `is_valid` tinyint(4) NOT NULL COMMENT '数据是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_orders
-- ----------------------------
INSERT INTO `t_orders` VALUES ('27412da978d34f83861476b5b5742711', '2b747290e67044c', '2017-05-26 17:13:48', '2', '2232', '7064ccfd72b84128bc26e237a030bde8', '4689f3d9dfc04eba9e80cf0fa487981e', '0f56cebe5f6b4437abb99696dc263261', '仲恺路500号', '0', '1');
INSERT INTO `t_orders` VALUES ('4a7fe596f9a14a40b11ef740f70638bc', '7171cd371826432', '2017-05-26 17:13:48', '1', '1022', 'd8c1ab64944c47d2ac261b4de9a9ad67', '4689f3d9dfc04eba9e80cf0fa487981e', '0f56cebe5f6b4437abb99696dc263261', '仲恺路500号', '0', '1');
INSERT INTO `t_orders` VALUES ('7dc236b56e17481dbd56c41d4dfc02ae', '00eb8c3139a445c', '2017-05-26 13:28:38', '3', '3298', '7064ccfd72b84128bc26e237a030bde8', '4689f3d9dfc04eba9e80cf0fa487981e', '0f56cebe5f6b4437abb99696dc263261', '上海', '0', '1');
INSERT INTO `t_orders` VALUES ('96c59a3c891a476da26e439ec866cf67', 'e05113cf31ae4a5', '2017-05-26 13:28:39', '7', '6531', 'c77da7519959469997431725c93d1012', '4689f3d9dfc04eba9e80cf0fa487981e', '0f56cebe5f6b4437abb99696dc263261', '上海', '0', '1');
INSERT INTO `t_orders` VALUES ('a555b9d87006437cad9502f3d3857834', 'c985b90a8adb4a9', '2017-05-26 13:28:41', '2', '1866', 'c77da7519959469997431725c93d1012', '4689f3d9dfc04eba9e80cf0fa487981e', '0f56cebe5f6b4437abb99696dc263261', '上海', '0', '1');
INSERT INTO `t_orders` VALUES ('a72c2819a2d844f98671f1ea7e78a9e3', 'f59ca7929ef647f', '2017-05-26 13:34:15', '1', '1305', '5f39a023a1e54d8f9368fba264fa12ef', '4689f3d9dfc04eba9e80cf0fa487981e', '0f56cebe5f6b4437abb99696dc263261', '广州', '0', '1');
INSERT INTO `t_orders` VALUES ('b323d34c68074a3aa32e981741c00ba0', 'e6b681a7939b49f', '2017-05-26 13:28:46', '1', '1166', 'dc67071c1f0e4150836246f389680740', '4689f3d9dfc04eba9e80cf0fa487981e', '0f56cebe5f6b4437abb99696dc263261', '佛山', '0', '1');
INSERT INTO `t_orders` VALUES ('cf448f6fb2b949079e30962c6610fd70', '9cca662192514db', '2017-05-26 13:34:15', '1', '1166', '1f601972aeb449639028650ad78b5b02', '4689f3d9dfc04eba9e80cf0fa487981e', '0f56cebe5f6b4437abb99696dc263261', '广州', '0', '1');
INSERT INTO `t_orders` VALUES ('fc110ea55095444cbc25e37361cb1d85', '69e3120909f34c0', '2017-05-27 09:46:19', '3', '2866', '341cb9e5eab743218e893d709737a1bc', '4689f3d9dfc04eba9e80cf0fa487981e', '0f56cebe5f6b4437abb99696dc263261', '佛山', '1', '1');

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` varchar(32) NOT NULL COMMENT '唯一标识',
  `name` varchar(20) NOT NULL COMMENT '权限名称',
  `description` varchar(50) NOT NULL COMMENT '权限描述',
  `sign` varchar(20) NOT NULL COMMENT '权限标识',
  `is_valid` tinyint(4) NOT NULL COMMENT '数据是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('60458eaaa3f6486ea159e34e0cb5fee5', '所有管理员权限', '所有管理员权限', 'admin:*', '1');
INSERT INTO `t_permission` VALUES ('6b4241b59c3c40f8a088c65f6230108d', '所有商家权限', '所有商家权限', 'shop:*', '1');
INSERT INTO `t_permission` VALUES ('849228fe9c1f4e0887fb4720e14d1ad0', '所有用户权限', '所有用户权限', 'user:*', '1');

-- ----------------------------
-- Table structure for t_person
-- ----------------------------
DROP TABLE IF EXISTS `t_person`;
CREATE TABLE `t_person` (
  `id` varchar(32) NOT NULL COMMENT '唯一标识',
  `account` varchar(50) NOT NULL COMMENT '登录帐号',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `phone` varchar(13) NOT NULL COMMENT '电话号码',
  `password` varchar(20) NOT NULL COMMENT '登录密码',
  `is_valid` tinyint(4) NOT NULL COMMENT '数据是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_person
-- ----------------------------
INSERT INTO `t_person` VALUES ('0f56cebe5f6b4437abb99696dc263261', 'test1', 'test1@qq.com', '18927766632', '123456', '1');
INSERT INTO `t_person` VALUES ('17eb9c01fbe44a28a33a344a9ca22fc6', 'shop8', 'shop8@qq.com', '10000000008', '123456', '1');
INSERT INTO `t_person` VALUES ('1b6351df9b4a401aad3bee233cc84369', 'shop6', 'shop6@qq.com', '10000000006', '123456', '1');
INSERT INTO `t_person` VALUES ('2639c1c0201c40a2874e17ebde4a5015', 'test9', 'test9@qq.com', '00000000009', '123456', '1');
INSERT INTO `t_person` VALUES ('2d06cb5524bc453383254353355a1968', 'test7', 'test7@qq.com', '00000000007', '123456', '1');
INSERT INTO `t_person` VALUES ('322738f1f1884868bebfdba7f67f6344', 'shop5', 'shop5@qq.com', '10000000005', '123456', '1');
INSERT INTO `t_person` VALUES ('3c4a01231fb14d0581003b05f1c933a5', 'shop7', 'shop7@qq.com', '10000000007', '123456', '1');
INSERT INTO `t_person` VALUES ('3ee68e8657bc4deba15bcc6b5c923822', 'test4', 'test4@qq.com', '00000000001', '123456', '1');
INSERT INTO `t_person` VALUES ('4689f3d9dfc04eba9e80cf0fa487981e', 'shop1', 'shop1@qq.com', '18080808081', '123456', '1');
INSERT INTO `t_person` VALUES ('5313312bc7df4746ae46641cce84b69a', 'test11', 'test11@qq.com', '00000000011', '123456', '1');
INSERT INTO `t_person` VALUES ('5ed7023d5d5e46c49f85b554b402af53', 'test8', 'test8@qq.com', '00000000008', '123456', '1');
INSERT INTO `t_person` VALUES ('87d86af17ebd458193461f29bf490321', 'shop12', 'shop12@qq.com', '10000000012', '123456', '1');
INSERT INTO `t_person` VALUES ('8a6d8a3b4fd54892b1eb552326b81ff9', 'shop9', 'shop9@qq.com', '10000000009', '123456', '1');
INSERT INTO `t_person` VALUES ('92ce023906b84c71a95f38ac8bb09ab7', 'test2', 'test2@qq.com', '18927766633', '123456', '1');
INSERT INTO `t_person` VALUES ('94498560e1334da19da0059826e32af6', 'test10', 'test10@qq.com', '00000000010', '123456', '1');
INSERT INTO `t_person` VALUES ('950a1034f0524acc86570a9273424751', 'shop11', 'shop11@qq.com', '10000000011', '123456', '1');
INSERT INTO `t_person` VALUES ('9f14290a975747239c65dffabd5bbcdb', 'test3', 'test3@qq.com', '18927766634', '123456', '1');
INSERT INTO `t_person` VALUES ('a26dfebd4826452589f0ceb9228eba1d', 'shop10', 'shop10@qq.com', '10000000010', '123456', '1');
INSERT INTO `t_person` VALUES ('c6b5b3df42874e68b3769266c648c2a8', 'haohua', '951087952@qq.com', '18927766631', '123456', '1');
INSERT INTO `t_person` VALUES ('db2abfc7ea984f2daf022100cf9234dd', 'shop3', 'shop3@qq.com', '10000000001', '123456', '1');
INSERT INTO `t_person` VALUES ('e38b751350ba41a38074de548f786c62', 'shop2', 'shop2@qq.com', '18080808020', '123456', '1');
INSERT INTO `t_person` VALUES ('e9faf3d47cbd462a863daf293447748b', 'test5', 'test5@qq.com', '00000000005', '123456', '1');
INSERT INTO `t_person` VALUES ('ef8f7212725e42d08503afcb5be42057', 'shop4', 'shop4@qq.com', '12345678910', '123456', '1');
INSERT INTO `t_person` VALUES ('f3650cb77cc34156a9893dbcc045f88a', 'test6', 'test6@qq.com', '00000000006', '123456', '1');

-- ----------------------------
-- Table structure for t_person_role
-- ----------------------------
DROP TABLE IF EXISTS `t_person_role`;
CREATE TABLE `t_person_role` (
  `id` varchar(32) NOT NULL COMMENT '唯一标识',
  `person_id` varchar(32) NOT NULL COMMENT '人的唯一标识',
  `role_id` varchar(32) NOT NULL COMMENT '角色的唯一标识',
  `is_valid` tinyint(4) NOT NULL COMMENT '数据是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_person_role
-- ----------------------------
INSERT INTO `t_person_role` VALUES ('0144c795f1af45fc99a598d843418cba', 'c6b5b3df42874e68b3769266c648c2a8', '32c308652cf048c3b9dd800ec791f3e7', '1');
INSERT INTO `t_person_role` VALUES ('0268a7c151f546ba85a3659d2317cad9', 'ef8f7212725e42d08503afcb5be42057', 'c1e29b9368d24bf9b9d38e28a4d2e559', '1');
INSERT INTO `t_person_role` VALUES ('04950614e95f4e14a922005aeb0bb0f8', '4689f3d9dfc04eba9e80cf0fa487981e', 'c1e29b9368d24bf9b9d38e28a4d2e559', '1');
INSERT INTO `t_person_role` VALUES ('0eaae23fcb6047f0bcc8a1211669e8c1', 'e38b751350ba41a38074de548f786c62', 'c1e29b9368d24bf9b9d38e28a4d2e559', '1');
INSERT INTO `t_person_role` VALUES ('22465443eb784aa8ae9b510778260277', '1b6351df9b4a401aad3bee233cc84369', 'c1e29b9368d24bf9b9d38e28a4d2e559', '1');
INSERT INTO `t_person_role` VALUES ('231ed5ce590b42d5a6151774bae4086d', 'a26dfebd4826452589f0ceb9228eba1d', 'c1e29b9368d24bf9b9d38e28a4d2e559', '1');
INSERT INTO `t_person_role` VALUES ('2c10d6354c3d46b197cce8af2daf4af4', '9f14290a975747239c65dffabd5bbcdb', 'cb1e60d0ebc349fdb794816646ba0028', '1');
INSERT INTO `t_person_role` VALUES ('3ffc26a923f948de9cd1f5d8860bcef8', '950a1034f0524acc86570a9273424751', 'c1e29b9368d24bf9b9d38e28a4d2e559', '1');
INSERT INTO `t_person_role` VALUES ('4c33178733bc46ad83457f14f378fa7d', '17eb9c01fbe44a28a33a344a9ca22fc6', 'c1e29b9368d24bf9b9d38e28a4d2e559', '1');
INSERT INTO `t_person_role` VALUES ('5e52054573294e759efc185259a9e6d3', '92ce023906b84c71a95f38ac8bb09ab7', 'cb1e60d0ebc349fdb794816646ba0028', '1');
INSERT INTO `t_person_role` VALUES ('62db411514df4a1593f51bf85b13aab0', '5313312bc7df4746ae46641cce84b69a', 'cb1e60d0ebc349fdb794816646ba0028', '1');
INSERT INTO `t_person_role` VALUES ('639c01ab29044315b31f951457a867db', 'e9faf3d47cbd462a863daf293447748b', 'cb1e60d0ebc349fdb794816646ba0028', '1');
INSERT INTO `t_person_role` VALUES ('81cbe539d09240a8aa3086ed45843f63', '94498560e1334da19da0059826e32af6', 'cb1e60d0ebc349fdb794816646ba0028', '1');
INSERT INTO `t_person_role` VALUES ('88b11a9dff6148dd87a59b419b079edb', '8a6d8a3b4fd54892b1eb552326b81ff9', 'c1e29b9368d24bf9b9d38e28a4d2e559', '1');
INSERT INTO `t_person_role` VALUES ('a8db872d7b1348508d9e27f7fd76d883', '2d06cb5524bc453383254353355a1968', 'cb1e60d0ebc349fdb794816646ba0028', '1');
INSERT INTO `t_person_role` VALUES ('adfba6e275124affb00a6bbc00dcd80d', '3ee68e8657bc4deba15bcc6b5c923822', 'cb1e60d0ebc349fdb794816646ba0028', '1');
INSERT INTO `t_person_role` VALUES ('ae589ea4ad464d3695d01d4328d401d9', 'f3650cb77cc34156a9893dbcc045f88a', 'cb1e60d0ebc349fdb794816646ba0028', '1');
INSERT INTO `t_person_role` VALUES ('c0d327f9e82347e7882182fdf12db24e', '5ed7023d5d5e46c49f85b554b402af53', 'cb1e60d0ebc349fdb794816646ba0028', '1');
INSERT INTO `t_person_role` VALUES ('d77c9dbdc94946bc9ef106b1c8f9ef74', '2639c1c0201c40a2874e17ebde4a5015', 'cb1e60d0ebc349fdb794816646ba0028', '1');
INSERT INTO `t_person_role` VALUES ('dbc90122946e45c198299f12e49f178a', 'db2abfc7ea984f2daf022100cf9234dd', 'c1e29b9368d24bf9b9d38e28a4d2e559', '1');
INSERT INTO `t_person_role` VALUES ('f3f5e53df8d44708a3786ed82f0d2c9f', '0f56cebe5f6b4437abb99696dc263261', 'cb1e60d0ebc349fdb794816646ba0028', '1');
INSERT INTO `t_person_role` VALUES ('f5938830f8e048d4818927584e522a0f', '87d86af17ebd458193461f29bf490321', 'c1e29b9368d24bf9b9d38e28a4d2e559', '1');
INSERT INTO `t_person_role` VALUES ('f67c82d9d91241deb1a5748e7f13113e', '322738f1f1884868bebfdba7f67f6344', 'c1e29b9368d24bf9b9d38e28a4d2e559', '1');
INSERT INTO `t_person_role` VALUES ('fef242aca15a42d59f2c092d8332e6c4', '3c4a01231fb14d0581003b05f1c933a5', 'c1e29b9368d24bf9b9d38e28a4d2e559', '1');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` varchar(32) NOT NULL COMMENT '唯一标识',
  `name` varchar(50) NOT NULL COMMENT '角色名字',
  `description` varchar(80) NOT NULL COMMENT '角色描述',
  `sign` varchar(20) NOT NULL COMMENT '角色标识',
  `is_valid` tinyint(4) NOT NULL COMMENT '数据是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('32c308652cf048c3b9dd800ec791f3e7', '超级管理员', '拥有所有权限', 'sys_admin', '1');
INSERT INTO `t_role` VALUES ('c1e29b9368d24bf9b9d38e28a4d2e559', '店铺商家', '拥有所有商家权限', 'shop_user', '1');
INSERT INTO `t_role` VALUES ('cb1e60d0ebc349fdb794816646ba0028', '普通用户', '拥有所有普通用户权限', 'simple_user', '1');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` varchar(32) NOT NULL COMMENT '唯一标识',
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  `permission_id` varchar(32) NOT NULL COMMENT '权限id',
  `is_valid` tinyint(4) NOT NULL COMMENT '数据是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('00a47b3444fb436fa7a8b21ca9c89002', '32c308652cf048c3b9dd800ec791f3e7', '6b4241b59c3c40f8a088c65f6230108d', '1');
INSERT INTO `t_role_permission` VALUES ('270a9f8de10a42118e689fe282bfc81a', 'c1e29b9368d24bf9b9d38e28a4d2e559', '6b4241b59c3c40f8a088c65f6230108d', '1');
INSERT INTO `t_role_permission` VALUES ('450b48215fdd4fb1be6593bf414cbb13', '32c308652cf048c3b9dd800ec791f3e7', '849228fe9c1f4e0887fb4720e14d1ad0', '1');
INSERT INTO `t_role_permission` VALUES ('8522d441ff46413aaddf893b149e2672', '32c308652cf048c3b9dd800ec791f3e7', '60458eaaa3f6486ea159e34e0cb5fee5', '1');
INSERT INTO `t_role_permission` VALUES ('f79a263e3a0348e4870d0ecb095202b0', 'cb1e60d0ebc349fdb794816646ba0028', '849228fe9c1f4e0887fb4720e14d1ad0', '1');

-- ----------------------------
-- Table structure for t_shop
-- ----------------------------
DROP TABLE IF EXISTS `t_shop`;
CREATE TABLE `t_shop` (
  `id` varchar(32) NOT NULL COMMENT '唯一标识',
  `shop_name` varchar(50) NOT NULL COMMENT '店铺名称',
  `own_name` varchar(50) NOT NULL COMMENT '店主名字',
  `own_id_card` varchar(18) NOT NULL COMMENT '店主身份证',
  `address` varchar(50) NOT NULL COMMENT '联系地址',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `authentication_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '认证时间',
  `state` int(4) NOT NULL COMMENT '(0：否，1：是)',
  `is_valid` tinyint(4) NOT NULL COMMENT '数据是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shop
-- ----------------------------
INSERT INTO `t_shop` VALUES ('17eb9c01fbe44a28a33a344a9ca22fc6', 'shop8', 'own8', 'xxxxxxxx', '广州xxx', '2017-05-19 14:01:40', null, '0', '1');
INSERT INTO `t_shop` VALUES ('1b6351df9b4a401aad3bee233cc84369', 'shop6', 'own6', 'xxxxxxxx', '广州xxx', '2017-05-19 14:01:20', null, '0', '1');
INSERT INTO `t_shop` VALUES ('322738f1f1884868bebfdba7f67f6344', 'shop5', 'own5', 'xxxxxxxx', '广州xxx', '2017-05-19 14:01:04', null, '0', '1');
INSERT INTO `t_shop` VALUES ('3c4a01231fb14d0581003b05f1c933a5', 'shop7', 'own7', 'xxxxxxxx', '广州xxx', '2017-05-19 14:01:28', null, '0', '1');
INSERT INTO `t_shop` VALUES ('4689f3d9dfc04eba9e80cf0fa487981e', 'shop1', '老板1', '440602199606292115', '广州1', '2017-05-24 10:02:14', '2017-05-19 14:26:30', '1', '1');
INSERT INTO `t_shop` VALUES ('87d86af17ebd458193461f29bf490321', 'shop12', 'own12', 'xxxxxxxx', '广州xxx', '2017-05-19 14:02:56', null, '0', '1');
INSERT INTO `t_shop` VALUES ('8a6d8a3b4fd54892b1eb552326b81ff9', 'shop9', 'own9', 'xxxxxxxx', '广州xxx', '2017-05-19 14:02:29', null, '0', '1');
INSERT INTO `t_shop` VALUES ('950a1034f0524acc86570a9273424751', 'shop11', 'own11', 'xxxxxxxx', '广州xxx', '2017-05-19 14:02:48', null, '0', '1');
INSERT INTO `t_shop` VALUES ('a26dfebd4826452589f0ceb9228eba1d', 'shop10', 'own10', 'xxxxxxxx', '广州xxx', '2017-05-19 14:02:40', null, '0', '1');
INSERT INTO `t_shop` VALUES ('db2abfc7ea984f2daf022100cf9234dd', 'shop3', 'own3', 'xxxxxxxx', '广州xxx', '2017-05-23 17:19:15', '2017-05-23 17:19:00', '1', '1');
INSERT INTO `t_shop` VALUES ('e38b751350ba41a38074de548f786c62', 'shop2', '老板2', '440602199606292116', '广州xxx', '2017-05-23 17:13:11', '2017-05-23 17:13:12', '1', '1');
INSERT INTO `t_shop` VALUES ('ef8f7212725e42d08503afcb5be42057', 'shop4', 'boss4', '123456489412134', 'guangzhoux', '2017-05-19 13:49:42', null, '0', '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL COMMENT '唯一标识',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `birthday` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '出生年月日',
  `address` varchar(200) DEFAULT NULL COMMENT '收货地址',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '注册时间',
  `is_valid` tinyint(4) NOT NULL COMMENT '数据是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('0f56cebe5f6b4437abb99696dc263261', 'haohua1', '2017-05-20 00:00:00', '[广州,上海,佛山,北京,仲恺路500号]', '2017-05-18 09:09:17', '1');
INSERT INTO `t_user` VALUES ('2639c1c0201c40a2874e17ebde4a5015', 'haohua9', '1996-06-01 00:00:00', null, '2017-05-18 16:56:04', '1');
INSERT INTO `t_user` VALUES ('2d06cb5524bc453383254353355a1968', 'haohua7', '1996-06-01 00:00:00', null, '2017-05-18 16:55:49', '1');
INSERT INTO `t_user` VALUES ('3ee68e8657bc4deba15bcc6b5c923822', 'haohua4', '1996-06-01 00:00:00', null, '2017-05-18 16:55:19', '1');
INSERT INTO `t_user` VALUES ('5313312bc7df4746ae46641cce84b69a', 'haohua11', '2017-05-19 11:16:22', null, '2017-05-18 16:56:26', '1');
INSERT INTO `t_user` VALUES ('5ed7023d5d5e46c49f85b554b402af53', 'haohua8', '1996-06-01 00:00:00', null, '2017-05-18 16:55:57', '1');
INSERT INTO `t_user` VALUES ('92ce023906b84c71a95f38ac8bb09ab7', 'haohua2', '1996-06-01 00:00:00', null, '2017-05-18 09:22:31', '1');
INSERT INTO `t_user` VALUES ('94498560e1334da19da0059826e32af6', 'haohua10', '1996-06-01 00:00:00', null, '2017-05-18 16:56:18', '1');
INSERT INTO `t_user` VALUES ('9f14290a975747239c65dffabd5bbcdb', 'haohua3', '2017-05-09 00:00:00', null, '2017-05-18 11:03:25', '1');
INSERT INTO `t_user` VALUES ('e9faf3d47cbd462a863daf293447748b', 'haohua5', '1996-06-01 00:00:00', null, '2017-05-18 16:55:30', '1');
INSERT INTO `t_user` VALUES ('f3650cb77cc34156a9893dbcc045f88a', 'haohua6', '1996-06-01 00:00:00', null, '2017-05-18 16:55:41', '1');
