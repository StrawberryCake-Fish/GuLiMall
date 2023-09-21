/*
 Navicat Premium Data Transfer

 Source Server         : VM
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : 192.168.154.129:3306
 Source Schema         : mall_wms

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 22/09/2023 00:15:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wms_purchase
-- ----------------------------
DROP TABLE IF EXISTS `wms_purchase`;
CREATE TABLE `wms_purchase`
(
    `id`            bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '采购单id',
    `assignee_id`   bigint                                                        NULL DEFAULT NULL COMMENT '采购人id',
    `assignee_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '采购人名',
    `phone`         char(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci     NULL DEFAULT NULL COMMENT '联系方式',
    `priority`      int                                                           NULL DEFAULT NULL COMMENT '优先级',
    `status`        int                                                           NULL DEFAULT NULL COMMENT '状态',
    `ware_id`       bigint                                                        NULL DEFAULT NULL COMMENT '仓库id',
    `amount`        decimal(18, 4)                                                NULL DEFAULT NULL COMMENT '总金额',
    `create_time`   datetime                                                      NULL DEFAULT NULL COMMENT '创建日期',
    `update_time`   datetime                                                      NULL DEFAULT NULL COMMENT '更新日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '采购信息'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_purchase
-- ----------------------------

-- ----------------------------
-- Table structure for wms_purchase_detail
-- ----------------------------
DROP TABLE IF EXISTS `wms_purchase_detail`;
CREATE TABLE `wms_purchase_detail`
(
    `id`          bigint         NOT NULL AUTO_INCREMENT,
    `purchase_id` bigint         NULL DEFAULT NULL COMMENT '采购单id',
    `sku_id`      bigint         NULL DEFAULT NULL COMMENT '采购商品id',
    `sku_num`     int            NULL DEFAULT NULL COMMENT '采购数量',
    `sku_price`   decimal(18, 4) NULL DEFAULT NULL COMMENT '采购金额',
    `ware_id`     bigint         NULL DEFAULT NULL COMMENT '仓库id',
    `status`      int            NULL DEFAULT NULL COMMENT '状态[0新建，1已分配，2正在采购，3已完成，4采购失败]',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_purchase_detail
-- ----------------------------

-- ----------------------------
-- Table structure for wms_ware_info
-- ----------------------------
DROP TABLE IF EXISTS `wms_ware_info`;
CREATE TABLE `wms_ware_info`
(
    `id`        bigint                                                        NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '仓库名',
    `address`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '仓库地址',
    `area_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL COMMENT '区域编码',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '仓库信息'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_ware_info
-- ----------------------------
INSERT INTO `wms_ware_info`
VALUES (1, '北京仓', '背景', '100000');
INSERT INTO `wms_ware_info`
VALUES (2, '上海仓', '上海仓', '200000');
INSERT INTO `wms_ware_info`
VALUES (3, '广州仓', '广州', '300000');
INSERT INTO `wms_ware_info`
VALUES (4, '深圳仓', '深圳', '400000');

-- ----------------------------
-- Table structure for wms_ware_order_task
-- ----------------------------
DROP TABLE IF EXISTS `wms_ware_order_task`;
CREATE TABLE `wms_ware_order_task`
(
    `id`               bigint                                                        NOT NULL AUTO_INCREMENT COMMENT 'id',
    `order_id`         bigint                                                        NULL DEFAULT NULL COMMENT 'order_id',
    `order_sn`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'order_sn',
    `consignee`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收货人',
    `consignee_tel`    char(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci     NULL DEFAULT NULL COMMENT '收货人电话',
    `delivery_address` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '配送地址',
    `order_comment`    varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单备注',
    `payment_way`      tinyint(1)                                                    NULL DEFAULT NULL COMMENT '付款方式【 1:在线付款 2:货到付款】',
    `task_status`      tinyint                                                       NULL DEFAULT NULL COMMENT '任务状态',
    `order_body`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单描述',
    `tracking_no`      char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci     NULL DEFAULT NULL COMMENT '物流单号',
    `create_time`      datetime                                                      NULL DEFAULT NULL COMMENT 'create_time',
    `ware_id`          bigint                                                        NULL DEFAULT NULL COMMENT '仓库id',
    `task_comment`     varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '工作单备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '库存工作单'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_ware_order_task
-- ----------------------------

-- ----------------------------
-- Table structure for wms_ware_order_task_detail
-- ----------------------------
DROP TABLE IF EXISTS `wms_ware_order_task_detail`;
CREATE TABLE `wms_ware_order_task_detail`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT COMMENT 'id',
    `sku_id`      bigint                                                        NULL DEFAULT NULL COMMENT 'sku_id',
    `sku_name`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'sku_name',
    `sku_num`     int                                                           NULL DEFAULT NULL COMMENT '购买个数',
    `task_id`     bigint                                                        NULL DEFAULT NULL COMMENT '工作单id',
    `ware_id`     bigint                                                        NULL DEFAULT NULL,
    `lock_status` int                                                           NULL DEFAULT NULL COMMENT '1-锁定 2-解锁 3-扣减',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '库存工作单'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_ware_order_task_detail
-- ----------------------------
INSERT INTO `wms_ware_order_task_detail`
VALUES (1, 1, '', 1, NULL, 1, 1);
INSERT INTO `wms_ware_order_task_detail`
VALUES (2, 1, '', 1, NULL, 1, 1);
INSERT INTO `wms_ware_order_task_detail`
VALUES (3, 1, '', 1, NULL, 1, 1);

-- ----------------------------
-- Table structure for wms_ware_sku
-- ----------------------------
DROP TABLE IF EXISTS `wms_ware_sku`;
CREATE TABLE `wms_ware_sku`
(
    `id`           bigint                                                        NOT NULL AUTO_INCREMENT COMMENT 'id',
    `sku_id`       bigint                                                        NULL     DEFAULT NULL COMMENT 'sku_id',
    `ware_id`      bigint                                                        NULL     DEFAULT NULL COMMENT '仓库id',
    `stock`        int                                                           NULL     DEFAULT NULL COMMENT '库存数',
    `sku_name`     varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL     DEFAULT NULL COMMENT 'sku_name',
    `stock_locked` int                                                           NOT NULL DEFAULT 0 COMMENT '锁定库存',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 9
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品库存'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_ware_sku
-- ----------------------------
INSERT INTO `wms_ware_sku`
VALUES (1, 1, 1, 100, '华为 Mate 30 Pro', 13);
INSERT INTO `wms_ware_sku`
VALUES (2, 2, 2, 120, '华为 Mate 30 Pro', 10);
INSERT INTO `wms_ware_sku`
VALUES (3, 20, 3, 220, 'iPhone 11 Pro Max', 20);
INSERT INTO `wms_ware_sku`
VALUES (4, 22, 4, 220, 'iPhone 11 Pro Max', 20);
INSERT INTO `wms_ware_sku`
VALUES (5, 3, 1, 110, '华为 Mate 30 Pro', 20);
INSERT INTO `wms_ware_sku`
VALUES (6, 4, 1, 330, '华为 Mate 30 Pro', 33);
INSERT INTO `wms_ware_sku`
VALUES (7, 23, 1, 330, 'iPhone 11 Pro Max', 0);
INSERT INTO `wms_ware_sku`
VALUES (8, 24, 1, 320, 'iPhone 11 Pro Max', 0);

SET FOREIGN_KEY_CHECKS = 1;
