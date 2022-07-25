/*
 Navicat Premium Data Transfer

 Source Server         : myServer
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : 116.62.113.33:3306
 Source Schema         : db0705

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 24/07/2022 23:26:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `age` int(0) DEFAULT NULL,
  `work_time` date DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sex` int(0) DEFAULT NULL,
  `authen_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int(0) DEFAULT NULL,
  `teacher_id` int(0) DEFAULT 1,
  `class_id` int(0) DEFAULT 1,
  `subject_id` int(0) DEFAULT 1,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'tiger', 1, NULL, 18, 0, 0, 0, NULL);
INSERT INTO `user` VALUES (2, 'haidia', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (3, 'haidia2', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (4, 'haidia3', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (5, 'haidia4', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (6, 'haidia6', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (7, 'haidia7', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (8, 'haidia8', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (9, 'haidia9', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (10, 'haidia10', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (11, 'haidia11', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (12, 'haidia12', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (13, 'haidia13', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (14, 'haidia14', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (15, 'haidia15', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (16, 'haidia16', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (17, 'haidia17', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (18, 'haidia18', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (19, 'haidia19', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (20, 'haidia20', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (21, 'haidia21', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (22, 'haidia22', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (23, 'haidia23', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (24, 'haidia24', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (25, 'haidia25', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (26, 'haidia26', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (27, 'haidia27', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (28, 'haidia28', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (29, 'haidia29', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (30, 'haidia30', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (31, 'haidia31', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (32, 'haidia32', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (33, 'haidia33', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (34, 'haidia34', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (35, 'haidia35', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (36, 'haidia36', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (37, 'haidia37', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (38, 'haidia38', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (39, 'haidia39', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (40, 'haidia40', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (41, 'haidia41', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (42, 'haidia42', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (43, 'haidia43', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (44, 'haidia44', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (45, 'haidia45', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (46, 'haidia46', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (47, 'haidia47', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (48, 'haidia48', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (49, 'haidia49', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (50, 'haidia50', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (51, 'haidia51', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (52, 'haidia52', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (53, 'haidia53', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (54, 'haidia54', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (55, 'haidia55', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (56, 'haidia56', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (57, 'haidia57', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (58, 'haidia58', 1, NULL, 16, 1, 1, 1, NULL);
INSERT INTO `user` VALUES (59, 'haidia59', 1, NULL, 16, 1, 1, 1, NULL);

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL,
  `psw` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_account
-- ----------------------------
INSERT INTO `user_account` VALUES (1, 1, '123456');

-- ----------------------------
-- Table structure for user_cost
-- ----------------------------
DROP TABLE IF EXISTS `user_cost`;
CREATE TABLE `user_cost`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cost_money` decimal(65, 0) DEFAULT NULL,
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
