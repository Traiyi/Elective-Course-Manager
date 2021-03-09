/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : course

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 09/03/2021 21:31:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'admin' COMMENT '管理员账户',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'admin' COMMENT '管理员密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for category_
-- ----------------------------
DROP TABLE IF EXISTS `category_`;
CREATE TABLE `category_`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category_
-- ----------------------------
INSERT INTO `category_` VALUES (1, 'category1');
INSERT INTO `category_` VALUES (2, 'category2');
INSERT INTO `category_` VALUES (27, '新增加的Category');
INSERT INTO `category_` VALUES (28, 'add');
INSERT INTO `category_` VALUES (29, '111');

-- ----------------------------
-- Table structure for elective
-- ----------------------------
DROP TABLE IF EXISTS `elective`;
CREATE TABLE `elective`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '选修编号',
  `student_id` int(11) NOT NULL DEFAULT 1 COMMENT '学生编号',
  `course_id` int(11) NOT NULL DEFAULT 1 COMMENT '选修课编号',
  `student_credit` double NOT NULL DEFAULT 2 COMMENT '学生所取得的学分',
  `is_pass` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of elective
-- ----------------------------
INSERT INTO `elective` VALUES (1, 1, 1, 2, 1);
INSERT INTO `elective` VALUES (2, 2, 1, 2, 1);
INSERT INTO `elective` VALUES (3, 3, 1, 2, 1);
INSERT INTO `elective` VALUES (4, 4, 1, 2, 1);
INSERT INTO `elective` VALUES (5, 5, 1, 2, 1);
INSERT INTO `elective` VALUES (6, 6, 1, 1.5, 0);
INSERT INTO `elective` VALUES (7, 7, 1, 1.5, 0);
INSERT INTO `elective` VALUES (8, 1, 2, 2, 1);
INSERT INTO `elective` VALUES (9, 2, 2, 2, 1);
INSERT INTO `elective` VALUES (10, 3, 2, 2, 1);
INSERT INTO `elective` VALUES (11, 4, 2, 2, 1);
INSERT INTO `elective` VALUES (12, 5, 2, 1.5, 0);
INSERT INTO `elective` VALUES (13, 6, 2, 1.5, 0);

-- ----------------------------
-- Table structure for elective_course
-- ----------------------------
DROP TABLE IF EXISTS `elective_course`;
CREATE TABLE `elective_course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '选修课编号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '选修课名字' COMMENT '选修课名字',
  `grade_id` int(11) NOT NULL DEFAULT 1 COMMENT '年级编号',
  `specialty_id` int(11) NOT NULL DEFAULT 1 COMMENT '专业编号',
  `credit` double NOT NULL DEFAULT 2 COMMENT '学分',
  `student_quantity` int(11) NOT NULL DEFAULT 30 COMMENT '学生数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of elective_course
-- ----------------------------
INSERT INTO `elective_course` VALUES (1, '选修课名字1', 1, 1, 2, 30);
INSERT INTO `elective_course` VALUES (2, '选修课名字2', 1, 1, 2, 30);
INSERT INTO `elective_course` VALUES (3, '力学', 1, 1, 2, 30);
INSERT INTO `elective_course` VALUES (4, '力学', 1, 1, 2, 30);
INSERT INTO `elective_course` VALUES (5, '11', 1, 1, 2, 30);
INSERT INTO `elective_course` VALUES (6, '11', 1, 1, 2, 30);
INSERT INTO `elective_course` VALUES (7, '1111', 1, 1, 2, 30);
INSERT INTO `elective_course` VALUES (8, '1111', 1, 1, 2, 30);
INSERT INTO `elective_course` VALUES (9, '3333', 1, 1, 2, 30);
INSERT INTO `elective_course` VALUES (10, '3333', 1, 1, 2, 30);
INSERT INTO `elective_course` VALUES (11, '11', 1, 1, 2, 30);
INSERT INTO `elective_course` VALUES (12, '11', 1, 1, 2, 30);

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '年级编号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '年级名' COMMENT '年级名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (1, '哲学系');
INSERT INTO `grade` VALUES (2, '文学系');
INSERT INTO `grade` VALUES (4, '物理系');
INSERT INTO `grade` VALUES (14, '信息工程系');
INSERT INTO `grade` VALUES (15, '通信工程系');
INSERT INTO `grade` VALUES (18, '化学物理系');

-- ----------------------------
-- Table structure for question_answer
-- ----------------------------
DROP TABLE IF EXISTS `question_answer`;
CREATE TABLE `question_answer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题编号',
  `student_id` int(11) NULL DEFAULT 1 COMMENT '学生编号',
  `admin_id` int(11) NULL DEFAULT 1 COMMENT '管理员编号',
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问题',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回答',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_answer
-- ----------------------------
INSERT INTO `question_answer` VALUES (3, 2, 1, '为什么选不到课?', '正在处理222');
INSERT INTO `question_answer` VALUES (4, 1, 1, '为什么选不到课?', '请详细说明选不到课的情况');

-- ----------------------------
-- Table structure for specialty
-- ----------------------------
DROP TABLE IF EXISTS `specialty`;
CREATE TABLE `specialty`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '专业名1' COMMENT '专业名',
  `grade_id` int(11) NOT NULL DEFAULT 1 COMMENT '年级编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of specialty
-- ----------------------------
INSERT INTO `specialty` VALUES (1, '西方哲学', 1);
INSERT INTO `specialty` VALUES (2, '马克思哲学', 1);
INSERT INTO `specialty` VALUES (3, '东方哲学', 1);
INSERT INTO `specialty` VALUES (4, '信号工程专业', 1);
INSERT INTO `specialty` VALUES (5, '信号工程专业', 1);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生编号',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'username' COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'password' COMMENT '密码',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '姓名' COMMENT '姓名',
  `student_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1601010101' COMMENT '学号',
  `grade_id` int(11) NOT NULL DEFAULT 1 COMMENT '年级编号',
  `specialty_id` int(11) NOT NULL DEFAULT 1 COMMENT '专业编号',
  PRIMARY KEY (`id`, `student_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'username', 'password', '姓名1', '1601010101', 1, 1);
INSERT INTO `student` VALUES (2, 'username', 'password', '姓名', '1601010101', 1, 1);
INSERT INTO `student` VALUES (3, 'username', 'password', '姓名', '1601010101', 1, 1);
INSERT INTO `student` VALUES (4, 'username', 'password', '姓名', '1601010101', 1, 1);
INSERT INTO `student` VALUES (5, 'username', 'password', '姓名', '1601010101', 1, 1);
INSERT INTO `student` VALUES (6, 'username', 'password', '姓名', '1601010101', 1, 1);
INSERT INTO `student` VALUES (7, 'username', 'password', '姓名', '1601010101', 1, 1);
INSERT INTO `student` VALUES (8, 'username', 'password', '姓名', '1601010101', 1, 1);
INSERT INTO `student` VALUES (9, 'username', 'password', '姓名', '1601010101', 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
