/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : prodpms

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-11-05 09:55:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for online_plan
-- ----------------------------
DROP TABLE IF EXISTS `online_plan`;
CREATE TABLE `online_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `online_datetime` datetime NOT NULL,
  `req_no` varchar(255) DEFAULT NULL,
  `func_item` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `op_person` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `change_date` datetime DEFAULT NULL,
  `dev_no` varchar(255) DEFAULT NULL,
  `online_plan_desc` varchar(255) DEFAULT NULL,
  `online_plan_name` varchar(255) DEFAULT NULL,
  `online_plan_status` varchar(255) DEFAULT NULL,
  `has_func` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
