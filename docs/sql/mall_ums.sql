/*
 Navicat Premium Data Transfer

 Source Server         : VM
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : 192.168.154.129:3306
 Source Schema         : mall_ums

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 22/09/2023 00:14:37
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ums_growth_change_history
-- ----------------------------
DROP TABLE IF EXISTS `ums_growth_change_history`;
CREATE TABLE `ums_growth_change_history`
(
    `id`           bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `member_id`    bigint NULL DEFAULT NULL COMMENT 'member_id',
    `create_time`  datetime NULL DEFAULT NULL COMMENT 'create_time',
    `change_count` int NULL DEFAULT NULL COMMENT '改变的值（正负计数）',
    `note`         varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
    `source_type`  tinyint NULL DEFAULT NULL COMMENT '积分来源[0-购物，1-管理员修改]',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '成长值变化历史记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_growth_change_history
-- ----------------------------

-- ----------------------------
-- Table structure for ums_integration_change_history
-- ----------------------------
DROP TABLE IF EXISTS `ums_integration_change_history`;
CREATE TABLE `ums_integration_change_history`
(
    `id`           bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `member_id`    bigint NULL DEFAULT NULL COMMENT 'member_id',
    `create_time`  datetime NULL DEFAULT NULL COMMENT 'create_time',
    `change_count` int NULL DEFAULT NULL COMMENT '变化的值',
    `note`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
    `source_type`  tinyint NULL DEFAULT NULL COMMENT '来源[0->购物；1->管理员修改;2->活动]',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '积分变化历史记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_integration_change_history
-- ----------------------------

-- ----------------------------
-- Table structure for ums_member
-- ----------------------------
DROP TABLE IF EXISTS `ums_member`;
CREATE TABLE `ums_member`
(
    `id`           bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `level_id`     bigint NULL DEFAULT NULL COMMENT '会员等级id',
    `username`     char(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
    `password`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
    `nickname`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
    `mobile`       varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号码',
    `email`        varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
    `header`       varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
    `gender`       tinyint NULL DEFAULT NULL COMMENT '性别',
    `birth`        date NULL DEFAULT NULL COMMENT '生日',
    `city`         varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所在城市',
    `job`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '职业',
    `sign`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '个性签名',
    `source_type`  tinyint NULL DEFAULT NULL COMMENT '用户来源',
    `integration`  int NULL DEFAULT NULL COMMENT '积分',
    `growth`       int NULL DEFAULT NULL COMMENT '成长值',
    `status`       tinyint NULL DEFAULT NULL COMMENT '启用状态',
    `create_time`  datetime NULL DEFAULT NULL COMMENT '注册时间',
    `social_uid`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `access_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `expires_in`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '会员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_member
-- ----------------------------
INSERT INTO `ums_member`
VALUES (1, NULL, NULL, NULL, '于你心上眉间', NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        '5709671078', '2.00ARM6OG0hAVKh96fef4725dtkhvVB', '157679999');

-- ----------------------------
-- Table structure for ums_member_collect_spu
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_collect_spu`;
CREATE TABLE `ums_member_collect_spu`
(
    `id`          bigint NOT NULL COMMENT 'id',
    `member_id`   bigint NULL DEFAULT NULL COMMENT '会员id',
    `spu_id`      bigint NULL DEFAULT NULL COMMENT 'spu_id',
    `spu_name`    varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'spu_name',
    `spu_img`     varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'spu_img',
    `create_time` datetime NULL DEFAULT NULL COMMENT 'create_time',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '会员收藏的商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_member_collect_spu
-- ----------------------------

-- ----------------------------
-- Table structure for ums_member_collect_subject
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_collect_subject`;
CREATE TABLE `ums_member_collect_subject`
(
    `id`           bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `subject_id`   bigint NULL DEFAULT NULL COMMENT 'subject_id',
    `subject_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'subject_name',
    `subject_img`  varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'subject_img',
    `subject_url`  varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '活动url',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '会员收藏的专题活动' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_member_collect_subject
-- ----------------------------

-- ----------------------------
-- Table structure for ums_member_level
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_level`;
CREATE TABLE `ums_member_level`
(
    `id`                     bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`                   varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '等级名称',
    `growth_point`           int NULL DEFAULT NULL COMMENT '等级需要的成长值',
    `default_status`         tinyint NULL DEFAULT NULL COMMENT '是否为默认等级[0->不是；1->是]',
    `free_freight_point`     decimal(18, 4) NULL DEFAULT NULL COMMENT '免运费标准',
    `comment_growth_point`   int NULL DEFAULT NULL COMMENT '每次评价获取的成长值',
    `privilege_free_freight` tinyint NULL DEFAULT NULL COMMENT '是否有免邮特权',
    `privilege_member_price` tinyint NULL DEFAULT NULL COMMENT '是否有会员价格特权',
    `privilege_birthday`     tinyint NULL DEFAULT NULL COMMENT '是否有生日特权',
    `note`                   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '会员等级' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_member_level
-- ----------------------------
INSERT INTO `ums_member_level`
VALUES (1, '普通会员', 3000, 1, 0.0000, 2, 0, 0, 1, '普通会员');
INSERT INTO `ums_member_level`
VALUES (2, '铜牌会员', 7000, 0, 200.0000, 3, 0, 1, 1, '铜牌会员');
INSERT INTO `ums_member_level`
VALUES (3, '银牌会员', 12000, 0, 180.0000, 5, 0, 1, 1, '银牌会员');
INSERT INTO `ums_member_level`
VALUES (4, '金牌会员', 18000, 0, 150.0000, 10, 1, 1, 1, '金牌会员');
INSERT INTO `ums_member_level`
VALUES (5, '钻石会员', 25000, 0, 120.0000, 15, 1, 1, 1, '钻石会员');

-- ----------------------------
-- Table structure for ums_member_login_log
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_login_log`;
CREATE TABLE `ums_member_login_log`
(
    `id`          bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `member_id`   bigint NULL DEFAULT NULL COMMENT 'member_id',
    `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
    `ip`          varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'ip',
    `city`        varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'city',
    `login_type`  tinyint(1) NULL DEFAULT NULL COMMENT '登录类型[1-web，2-app]',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '会员登录记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_member_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for ums_member_receive_address
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_receive_address`;
CREATE TABLE `ums_member_receive_address`
(
    `id`             bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `member_id`      bigint NULL DEFAULT NULL COMMENT 'member_id',
    `name`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收货人姓名',
    `phone`          varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
    `post_code`      varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮政编码',
    `province`       varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '省份/直辖市',
    `city`           varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '城市',
    `region`         varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '区',
    `detail_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '详细地址(街道)',
    `area_code`      varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '省市区代码',
    `default_status` tinyint(1) NULL DEFAULT NULL COMMENT '是否默认',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '会员收货地址' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_member_receive_address
-- ----------------------------
INSERT INTO `ums_member_receive_address`
VALUES (1, 1, 'raymond', '17888888888', '476600', '河南省', '永城市', '东城区', '河南省永城市东城区', '111111', 1);
INSERT INTO `ums_member_receive_address`
VALUES (2, 1, 'raymond', '17888888888', '116622', '辽宁省', '大连市', '金州区', '大连理工大学', '111111', 0);

-- ----------------------------
-- Table structure for ums_member_statistics_info
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_statistics_info`;
CREATE TABLE `ums_member_statistics_info`
(
    `id`                    bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `member_id`             bigint NULL DEFAULT NULL COMMENT '会员id',
    `consume_amount`        decimal(18, 4) NULL DEFAULT NULL COMMENT '累计消费金额',
    `coupon_amount`         decimal(18, 4) NULL DEFAULT NULL COMMENT '累计优惠金额',
    `order_count`           int NULL DEFAULT NULL COMMENT '订单数量',
    `coupon_count`          int NULL DEFAULT NULL COMMENT '优惠券数量',
    `comment_count`         int NULL DEFAULT NULL COMMENT '评价数',
    `return_order_count`    int NULL DEFAULT NULL COMMENT '退货数量',
    `login_count`           int NULL DEFAULT NULL COMMENT '登录次数',
    `attend_count`          int NULL DEFAULT NULL COMMENT '关注数量',
    `fans_count`            int NULL DEFAULT NULL COMMENT '粉丝数量',
    `collect_product_count` int NULL DEFAULT NULL COMMENT '收藏的商品数量',
    `collect_subject_count` int NULL DEFAULT NULL COMMENT '收藏的专题活动数量',
    `collect_comment_count` int NULL DEFAULT NULL COMMENT '收藏的评论数量',
    `invite_friend_count`   int NULL DEFAULT NULL COMMENT '邀请的朋友数量',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '会员统计信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_member_statistics_info
-- ----------------------------

SET
FOREIGN_KEY_CHECKS = 1;
