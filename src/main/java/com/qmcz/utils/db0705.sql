/*
 Navicat Premium Data Transfer

 Source Server         : mylocal
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : db0705

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 12/07/2022 19:08:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `sex` int(2) NULL DEFAULT NULL,
  `authen_code` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `age` int(3) NULL DEFAULT NULL,
  `teacher_id` int(10) NULL DEFAULT NULL,
  `class_id` int(10) NULL DEFAULT NULL,
  `subject_id` int(10) NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'tiger', 0, NULL, 18, 0, 0, 0, NULL);
INSERT INTO `user` VALUES (2, 'haidai', 0, NULL, 18, 0, 0, 0, NULL);
INSERT INTO `user` VALUES (3, NULL, 0, NULL, 0, 0, 0, 0, NULL);
INSERT INTO `user` VALUES (4, NULL, 0, NULL, 0, 0, 0, 0, NULL);
INSERT INTO `user` VALUES (5, NULL, 0, NULL, 0, 0, 0, 0, NULL);
INSERT INTO `user` VALUES (6, NULL, 0, NULL, 0, 0, 0, 0, NULL);
INSERT INTO `user` VALUES (7, 'sq', 0, NULL, 0, 0, 0, 0, NULL);
INSERT INTO `user` VALUES (8, 'sq2', 0, 'kjkjkjkj', 0, 0, 0, 0, NULL);
INSERT INTO `user` VALUES (9, 'sq2', 0, 'kjkjkjkj', 18, 1, 1, 1, '666666666');
INSERT INTO `user` VALUES (10, 'jqx', 0, NULL, 18, 0, 0, 0, NULL);
INSERT INTO `user` VALUES (11, 'meican', 0, NULL, 0, 0, 0, 0, NULL);

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `psw` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_account
-- ----------------------------
INSERT INTO `user_account` VALUES (1, 1, '123456');
INSERT INTO `user_account` VALUES (2, 2, '123456');

-- ----------------------------
-- Table structure for user_cost
-- ----------------------------
DROP TABLE IF EXISTS `user_cost`;
CREATE TABLE `user_cost`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `cost_money` decimal(65, 0) NULL DEFAULT NULL,
  `desc` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
