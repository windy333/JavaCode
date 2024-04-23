/*
 Navicat Premium Data Transfer

 Source Server         : SQL of Windy
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : studentinfomanagement

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 09/12/2023 14:13:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `Clno` char(12) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `Clname` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Dno` char(12) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Clno`) USING BTREE,
  INDEX `FK_Class_Department`(`Dno`) USING BTREE,
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`Dno`) REFERENCES `department` (`Dno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('20230101', '计算机1班', '202301');
INSERT INTO `class` VALUES ('20230102', '计算机2班', '202301');
INSERT INTO `class` VALUES ('20230201', '化学1班', '202302');
INSERT INTO `class` VALUES ('20230202', '化学2班', '202302');
INSERT INTO `class` VALUES ('20230301', '数学1班', '202303');
INSERT INTO `class` VALUES ('20230302', '数学2班', '202303');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `Cno` char(12) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `Cname` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Cteacher` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Ccredit` smallint(6) NULL DEFAULT NULL,
  PRIMARY KEY (`Cno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '数学分析', 'TC1', 4);
INSERT INTO `course` VALUES ('2', '数据库原理', 'TC2', 5);
INSERT INTO `course` VALUES ('3', 'Java', 'TC2', 4);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `Dno` char(12) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `Dname` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Dno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('202301', '计算机系');
INSERT INTO `department` VALUES ('202302', '化学系');
INSERT INTO `department` VALUES ('202303', '数学系');

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc`  (
  `Sno` varchar(12) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `Cno` varchar(12) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `Grade` smallint(6) NULL DEFAULT NULL,
  PRIMARY KEY (`Sno`, `Cno`) USING BTREE,
  INDEX `FK_SC_Course`(`Cno`) USING BTREE,
  CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`Sno`) REFERENCES `student` (`Sno`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sc_ibfk_2` FOREIGN KEY (`Cno`) REFERENCES `course` (`Cno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('2023030112', '1', 90);
INSERT INTO `sc` VALUES ('2023030112', '2', 50);
INSERT INTO `sc` VALUES ('2023030112', '3', 70);
INSERT INTO `sc` VALUES ('2023030113', '1', 60);
INSERT INTO `sc` VALUES ('2023030113', '2', NULL);
INSERT INTO `sc` VALUES ('2023030113', '3', 70);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `Sno` char(12) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '序号',
  `Sname` varchar(8) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '姓名',
  `Ssex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `Sage` smallint(6) NULL DEFAULT NULL COMMENT '年龄',
  `Clno` char(12) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属院系',
  PRIMARY KEY (`Sno`) USING BTREE,
  INDEX `FK_Student_Class`(`Clno`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`Clno`) REFERENCES `class` (`Clno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2023030112', 'Bob', '男', 20, '20230301');
INSERT INTO `student` VALUES ('2023030113', 'Aimy', '女', 19, '20230301');
INSERT INTO `student` VALUES ('2023030114', 'Ming', '男', 19, '20230301');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` char(12) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '用户登录名',
  `password` char(12) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '用户登录密码',
  `level` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '权限提醒',
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', '666', 'ADMIN');
INSERT INTO `user` VALUES ('user1', '123', 'USER');
INSERT INTO `user` VALUES ('user2', '123', 'USER');

SET FOREIGN_KEY_CHECKS = 1;
