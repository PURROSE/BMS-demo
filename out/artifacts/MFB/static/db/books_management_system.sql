/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : books_management_system

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-06-12 23:38:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bms_books
-- ----------------------------
DROP TABLE IF EXISTS `bms_books`;
CREATE TABLE `bms_books` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `writer` varchar(255) NOT NULL,
  `num` int(6) NOT NULL,
  `user_id` int(8) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `addtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bms_books
-- ----------------------------
INSERT INTO `bms_books` VALUES ('1', '西游记', '123', '7', '1', '123', '2020-09-27 00:00:00');
INSERT INTO `bms_books` VALUES ('6', '整合年夏', '无名', '13', '15', '管理员十五号', '2020-04-28 15:55:10');
INSERT INTO `bms_books` VALUES ('7', '高数', '组长', '2', '15', '管理员十五号', '2020-05-06 16:19:59');
INSERT INTO `bms_books` VALUES ('8', '语文', '副组长', '4', '15', '管理员十五号', '2020-05-06 16:34:37');
INSERT INTO `bms_books` VALUES ('9', '小学英语', '副组长', '7', '15', '管理员十五号', '2020-05-06 16:35:03');
INSERT INTO `bms_books` VALUES ('10', '中学英语', '副组长', '8', '15', '管理员十五号', '2020-05-06 16:35:12');
INSERT INTO `bms_books` VALUES ('11', '大学英语', '副组长', '8', '15', '管理员十五号', '2020-05-06 16:35:19');
INSERT INTO `bms_books` VALUES ('12', '大学物理', '副组长', '8', '15', '管理员十五号', '2020-05-06 16:35:31');
INSERT INTO `bms_books` VALUES ('13', '中学物理', '副组长', '8', '15', '管理员十五号', '2020-05-06 16:35:40');
INSERT INTO `bms_books` VALUES ('14', '小学物理', '副组长', '8', '15', '管理员十五号', '2020-05-06 16:35:45');
INSERT INTO `bms_books` VALUES ('15', '小学化学', '副组长', '8', '15', '管理员十五号', '2020-05-06 16:35:59');

-- ----------------------------
-- Table structure for bms_borrow
-- ----------------------------
DROP TABLE IF EXISTS `bms_borrow`;
CREATE TABLE `bms_borrow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) DEFAULT NULL,
  `client_name` varchar(255) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `borrow_time` datetime DEFAULT NULL,
  `borrow_aftertime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bms_borrow
-- ----------------------------
INSERT INTO `bms_borrow` VALUES ('4', '1', '1', '1', '123', '15', '白起', '1', '2020-03-23 17:47:55', '2020-05-03 19:37:18');
INSERT INTO `bms_borrow` VALUES ('5', '1', '王朝', '1', '123', '15', '白起', '1', '2020-04-04 04:01:00', null);
INSERT INTO `bms_borrow` VALUES ('6', '1', '王朝', '1', '123', '15', '白起', '1', '2020-04-17 17:48:05', null);
INSERT INTO `bms_borrow` VALUES ('7', '1', '王朝', '1', '123', '15', '白起', '1', '2020-04-18 17:48:07', null);
INSERT INTO `bms_borrow` VALUES ('8', '1', '王朝', '1', '123', '15', '白起', '1', '2020-04-05 17:48:11', null);
INSERT INTO `bms_borrow` VALUES ('9', '1', '王朝', '1', '123', '15', '白起', '1', '2020-03-20 18:34:11', '2020-05-06 14:59:18');
INSERT INTO `bms_borrow` VALUES ('10', '1', '王朝', '1', '射', '15', '白起', '1', '2020-05-06 15:43:18', null);
INSERT INTO `bms_borrow` VALUES ('11', '1', '王朝', '1', '射', '15', '白起', '1', '2020-05-06 15:44:31', null);
INSERT INTO `bms_borrow` VALUES ('12', '1', '王朝', '1', '西游记', '15', '白起', '1', '2020-05-06 17:42:34', null);
INSERT INTO `bms_borrow` VALUES ('13', '1', '王朝', '1', '西游记', '15', '白起', '1', '2020-05-06 17:43:23', null);
INSERT INTO `bms_borrow` VALUES ('14', '1', '王朝', '6', '整合年夏', '15', '白起', '1', '2020-05-06 18:06:17', null);
INSERT INTO `bms_borrow` VALUES ('15', '2', '辉朝东', '6', '整合年夏', '15', '白起', '1', '2020-05-06 18:21:08', null);
INSERT INTO `bms_borrow` VALUES ('16', '3', '李朝阳', '8', '语文', '15', '白起', '1', '2020-05-06 18:21:23', null);
INSERT INTO `bms_borrow` VALUES ('17', '2', '辉朝东', '7', '高数', '15', '白起', '1', '2020-05-06 18:24:40', null);
INSERT INTO `bms_borrow` VALUES ('18', '2', '辉朝东', '7', '高数', '15', '白起', '1', '2020-05-06 18:24:51', null);
INSERT INTO `bms_borrow` VALUES ('19', '2', '辉朝东', '7', '高数', '15', '白起', '1', '2020-05-06 18:25:00', null);
INSERT INTO `bms_borrow` VALUES ('20', '2', '辉朝东', '7', '高数', '15', '白起', '1', '2020-05-06 18:25:04', null);
INSERT INTO `bms_borrow` VALUES ('21', '1', '王朝', '8', '语文', '15', '白起', '1', '2020-05-06 18:36:44', null);
INSERT INTO `bms_borrow` VALUES ('22', '1', '王朝', '8', '语文', '15', '白起', '1', '2020-05-06 18:36:56', null);
INSERT INTO `bms_borrow` VALUES ('23', '1', '王朝', '8', '语文', '15', '白起', '1', '2020-05-06 18:37:02', null);
INSERT INTO `bms_borrow` VALUES ('24', '1', '王朝', '9', '小学英语', '15', '白起', '1', '2020-05-06 18:54:35', null);

-- ----------------------------
-- Table structure for bms_client
-- ----------------------------
DROP TABLE IF EXISTS `bms_client`;
CREATE TABLE `bms_client` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bms_client
-- ----------------------------
INSERT INTO `bms_client` VALUES ('1', '王朝', '15963569587', '101室');
INSERT INTO `bms_client` VALUES ('2', '辉朝东', '12585465758', '152室');
INSERT INTO `bms_client` VALUES ('3', '李朝阳', '14754854858', '159室');

-- ----------------------------
-- Table structure for bms_news
-- ----------------------------
DROP TABLE IF EXISTS `bms_news`;
CREATE TABLE `bms_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `addtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bms_news
-- ----------------------------

-- ----------------------------
-- Table structure for bms_users
-- ----------------------------
DROP TABLE IF EXISTS `bms_users`;
CREATE TABLE `bms_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bms_users
-- ----------------------------
INSERT INTO `bms_users` VALUES ('15', '456', '项羽', '123', '12325825836');
INSERT INTO `bms_users` VALUES ('16', '123', '123', '123', '123');
INSERT INTO `bms_users` VALUES ('17', '123', '123', '123', '123');
INSERT INTO `bms_users` VALUES ('18', '123', '123', '123', '123');
INSERT INTO `bms_users` VALUES ('19', '234', '234', '234', '234');
INSERT INTO `bms_users` VALUES ('20', '123', '123', '123', '123');
INSERT INTO `bms_users` VALUES ('21', '123', '123', '123', '123');
DROP TRIGGER IF EXISTS `uChange`;
DELIMITER ;;
CREATE TRIGGER `uChange` AFTER UPDATE ON `bms_users` FOR EACH ROW BEGIN

UPDATE bms_borrow
SET user_name = New.name
WHERE
	user_id = 15;
END
;;
DELIMITER ;
