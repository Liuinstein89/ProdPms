/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : prodpms

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-11-13 17:48:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for audit_result
-- ----------------------------
DROP TABLE IF EXISTS `audit_result`;
CREATE TABLE `audit_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `req_id` int(11) DEFAULT NULL,
  `req_result` varchar(255) DEFAULT NULL,
  `req_comment` varchar(255) DEFAULT NULL,
  `req_person` varchar(255) DEFAULT NULL,
  `req_time` datetime DEFAULT NULL,
  `desi_result` varchar(255) DEFAULT NULL,
  `desi_comment` varchar(255) DEFAULT NULL,
  `desi_person` varchar(255) DEFAULT NULL,
  `desi_time` datetime DEFAULT NULL,
  `dev_result` varchar(255) DEFAULT NULL,
  `dev_comment` varchar(255) DEFAULT NULL,
  `dev_person` varchar(255) DEFAULT NULL,
  `next_person` varchar(255) DEFAULT NULL,
  `dev_time` datetime DEFAULT NULL,
  `is_deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of audit_result
-- ----------------------------
INSERT INTO `audit_result` VALUES ('1', '1', '审核通过', '请设计审核', '袁蘅', '2018-10-15 15:19:45', null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `audit_result` VALUES ('2', '1', null, null, null, null, '审核通过', null, null, null, null, null, null, null, null, '0');
INSERT INTO `audit_result` VALUES ('3', '1', null, null, null, null, null, null, null, null, '审核通过', null, null, null, null, '0');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dpt_name` varchar(255) DEFAULT NULL,
  `dpt_code` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `change_time` datetime DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  `op_person` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '产品开发团队', '1', '2018-09-17 10:19:19', null, '0', null);

-- ----------------------------
-- Table structure for exec_type
-- ----------------------------
DROP TABLE IF EXISTS `exec_type`;
CREATE TABLE `exec_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modi_date` datetime DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `op_person` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of exec_type
-- ----------------------------
INSERT INTO `exec_type` VALUES ('1', '日常优化', '2018-09-17 10:21:11', null, '0', null);

-- ----------------------------
-- Table structure for func
-- ----------------------------
DROP TABLE IF EXISTS `func`;
CREATE TABLE `func` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `func_name` varchar(255) DEFAULT NULL,
  `func_modi_desc` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `desi_person` varchar(255) DEFAULT NULL,
  `dev_person` varchar(255) DEFAULT NULL,
  `test_person` varchar(255) DEFAULT NULL,
  `online_date` datetime DEFAULT NULL,
  `modi_date` datetime DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `create_user` varchar(255) DEFAULT NULL,
  `func_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of func
-- ----------------------------
INSERT INTO `func` VALUES ('1', '基金认购', null, '2018-10-15 15:12:59', null, null, null, null, null, '0', null, null);
INSERT INTO `func` VALUES ('2', '基金申购', null, '2018-10-15 15:13:33', null, null, null, null, null, '0', null, null);

-- ----------------------------
-- Table structure for online_func
-- ----------------------------
DROP TABLE IF EXISTS `online_func`;
CREATE TABLE `online_func` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `olplan_id` int(11) DEFAULT NULL,
  `func_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `change_time` datetime DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `op_person` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `onlinetime_id` (`olplan_id`),
  KEY `func_id` (`func_id`),
  CONSTRAINT `online_func_ibfk_1` FOREIGN KEY (`olplan_id`) REFERENCES `online_plan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `online_func_ibfk_2` FOREIGN KEY (`func_id`) REFERENCES `func` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of online_func
-- ----------------------------
INSERT INTO `online_func` VALUES ('1', '1', '1', '2018-10-15 15:47:45', null, '0', null);

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
  `req_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of online_plan
-- ----------------------------
INSERT INTO `online_plan` VALUES ('1', '2018-10-31 15:16:58', '1', '基金认购', '0', null, '2018-10-15 15:17:12', null, null, null, null, null, null, 'a req');
INSERT INTO `online_plan` VALUES ('2', '2018-10-31 15:18:01', '1', '基金申购', '0', null, '2018-10-15 15:18:12', null, null, null, null, null, null, 'b req');

-- ----------------------------
-- Table structure for project_team
-- ----------------------------
DROP TABLE IF EXISTS `project_team`;
CREATE TABLE `project_team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(255) DEFAULT NULL,
  `belong_dpt_code` varchar(255) DEFAULT NULL,
  `team_leader` varchar(255) DEFAULT NULL,
  `teammate_num` int(11) DEFAULT NULL,
  `teammate` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `change_time` datetime DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  `op_person` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of project_team
-- ----------------------------
INSERT INTO `project_team` VALUES ('1', '代理基金', '1', null, null, null, '2018-10-15 15:15:25', null, '0', null);

-- ----------------------------
-- Table structure for req
-- ----------------------------
DROP TABLE IF EXISTS `req`;
CREATE TABLE `req` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `req_no` varchar(255) DEFAULT NULL,
  `req_name` varchar(255) DEFAULT NULL,
  `req_source` varchar(255) DEFAULT NULL,
  `dept` varchar(255) DEFAULT NULL,
  `exec_type` varchar(255) DEFAULT NULL,
  `lead_team` varchar(255) DEFAULT NULL,
  `coo_team` varchar(255) DEFAULT NULL,
  `now_user` varchar(255) DEFAULT NULL,
  `next_user` varchar(255) DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modi_date` datetime DEFAULT NULL,
  `req_status` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `req_no` (`req_no`),
  KEY `multi` (`id`,`req_no`,`req_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11112 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of req
-- ----------------------------
INSERT INTO `req` VALUES ('1', '1', '基金龙钱宝开发需求', '任务书', '个人部', '项目', '代理基金', null, null, '邓昌胜', null, '2018-10-15 14:52:52', null, '正在实施', '1');
INSERT INTO `req` VALUES ('2', '2', '事件I1269204非本人操作购买基金，核实购买渠道', 'DCM单', 'DCM', '日常优化', '代理基金', 'ateam', null, '张晓科', null, '2018-10-15 14:54:55', null, 'reqAddStatus', '0');
INSERT INTO `req` VALUES ('3', '3', 'ming', 'lai', 'dept', 'fangshi', 'nwipo', 'wip', 'design', 'good', 'req', '2018-10-22 11:20:10', null, 'qqq', '0');
INSERT INTO `req` VALUES ('4', '4', 'mingzi', 'laiyuan', 'dept', 'fangshi', 'nwipo', 'wip', 'design', 'dev', 'req', '2018-10-31 11:04:21', null, 'reqAddStatus', '0');
INSERT INTO `req` VALUES ('5', '33', 'mingzi', 'laiyuan', 'dept', 'fangshi', 'nwipo', 'wip', 'design', 'dev', 'req', '2018-10-31 15:03:20', null, null, '0');
INSERT INTO `req` VALUES ('7', '5', 'mingzi', 'laiyuan', 'dept', 'fangshi', 'nwipo', 'wip', 'design', 'dev', 'req', '2018-10-31 15:05:29', null, null, '0');
INSERT INTO `req` VALUES ('10004', '333', '333', '333', '333', '333', '333', '333', '333', '333', '333', '2018-11-12 09:32:37', null, 'reqAddStatus', '0');
INSERT INTO `req` VALUES ('10005', '444', '333', '333', '333', '333', '333', '333', '333', '333', '333', '2018-11-12 09:39:37', null, 'reqAddStatus', '0');
INSERT INTO `req` VALUES ('10007', '4444', '333', '333', '333', '333', '333', '333', '333', '333', '333', '2018-11-12 09:43:21', null, 'reqAddStatus', '0');
INSERT INTO `req` VALUES ('10008', '44444', '333', '333', '333', '333', '333', '333', '333', '333', '333', '2018-11-12 09:50:05', null, 'reqAddStatus', '0');
INSERT INTO `req` VALUES ('10009', '444444', '333', '333', '333', '333', '333', '333', '333', '333', '333', '2018-11-12 09:51:28', null, 'reqAddStatus', '0');
INSERT INTO `req` VALUES ('11111', '11111', '333', '33', '33', '33', '33', null, null, null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for reqitem_func
-- ----------------------------
DROP TABLE IF EXISTS `reqitem_func`;
CREATE TABLE `reqitem_func` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reqitem_id` int(11) DEFAULT NULL,
  `func_id` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `change_time` datetime DEFAULT NULL,
  `op_person` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `reqitem_id` (`reqitem_id`),
  KEY `func_id` (`func_id`),
  CONSTRAINT `reqitem_func_ibfk_1` FOREIGN KEY (`reqitem_id`) REFERENCES `req_item` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reqitem_func_ibfk_2` FOREIGN KEY (`func_id`) REFERENCES `func` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reqitem_func
-- ----------------------------
INSERT INTO `reqitem_func` VALUES ('1', '1', '1', '0', '2018-10-15 15:44:14', null, null);
INSERT INTO `reqitem_func` VALUES ('3', '9', '1', '0', '2018-11-01 15:40:25', null, 'YH');
INSERT INTO `reqitem_func` VALUES ('4', '9', '2', '0', '2018-11-01 15:40:25', null, 'YH');
INSERT INTO `reqitem_func` VALUES ('5', '10', '1', '0', '2018-11-05 10:06:01', null, 'YH');
INSERT INTO `reqitem_func` VALUES ('6', '10', '2', '0', '2018-11-05 10:06:01', null, 'YH');

-- ----------------------------
-- Table structure for req_item
-- ----------------------------
DROP TABLE IF EXISTS `req_item`;
CREATE TABLE `req_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `req_no` varchar(255) DEFAULT NULL,
  `req_item_name` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `req_item_desc` varchar(255) DEFAULT NULL,
  `online_datetime` datetime DEFAULT NULL,
  `req_item_dev` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `req_item_status` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `change_time` datetime DEFAULT NULL,
  `op_person` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `has_func` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of req_item
-- ----------------------------
INSERT INTO `req_item` VALUES ('1', '11', '养老目标基金购买阅读须知', '在养老目标基金购买时增加相关客户须知的阅读并后保存结果', '2018-10-27 11:18:54', '养老目标基金1027', '已上线', '2018-05-12 15:11:21', null, 'xq', '0', '0');
INSERT INTO `req_item` VALUES ('2', '22', '养老目标基金购买流程优化', '优化申购交易流程\r\n优化申购交易流程', '2018-11-24 11:20:25', '养老目标基金1124', '未上线', '2018-05-12 15:11:21', null, 'xq', '0', '0');
INSERT INTO `req_item` VALUES ('3', 'PR2018103003', '需求项1', '描述', '1131-11-11 11:11:11', '开发任务1', '未上线', '1131-11-11 11:11:11', '1131-11-11 11:11:11', 'YH', '0', '0');
INSERT INTO `req_item` VALUES ('4', '2323', 'name', 'desc', '2018-10-31 14:36:32', 'dev', 'good', '2018-10-31 14:36:32', '2018-10-31 14:36:32', 'yh', '0', '0');
INSERT INTO `req_item` VALUES ('5', 'PR2018103005', '需求项1', '描述', '2018-10-31 15:48:28', '开发任务1', '未上线', '2018-10-31 15:48:28', null, 'YH', '0', '0');
INSERT INTO `req_item` VALUES ('6', 'PR201811111111111', '需求项1', '描述', '2018-11-24 00:00:00', '开发任务1', '未上线', '2018-11-01 10:53:24', null, 'YH', '0', '0');
INSERT INTO `req_item` VALUES ('7', 'PR20182222222', '需求项1', '描述', '2018-11-24 00:00:00', '开发任务1', '未上线', '2018-11-01 15:15:36', null, 'YH', '0', '0');
INSERT INTO `req_item` VALUES ('8', 'PR20182223333', '需求项1', '描述', '2018-11-24 00:00:00', '开发任务1', '未上线', '2018-11-01 15:26:23', null, 'YH', '0', '0');
INSERT INTO `req_item` VALUES ('9', 'PR201823333', '需求项1', '描述', '2018-11-24 00:00:00', '开发任务1', '未上线', '2018-11-01 15:40:25', null, 'YH', '0', '0');
INSERT INTO `req_item` VALUES ('10', 'PR201823333', '需求项1', '描述', '2018-11-24 00:00:00', '开发任务1', '未上线', '2018-11-05 10:06:01', null, 'YH', '0', '0');

-- ----------------------------
-- Table structure for req_source
-- ----------------------------
DROP TABLE IF EXISTS `req_source`;
CREATE TABLE `req_source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `souce_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `change_time` datetime DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `op_person` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of req_source
-- ----------------------------
INSERT INTO `req_source` VALUES ('1', 'ITDM', '2018-09-17 10:19:50', null, '0', null);

-- ----------------------------
-- Table structure for state
-- ----------------------------
DROP TABLE IF EXISTS `state`;
CREATE TABLE `state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state_type` varchar(255) DEFAULT NULL,
  `state_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `change_time` datetime DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  `op_person` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of state
-- ----------------------------
INSERT INTO `state` VALUES ('1', '需求', '需求待审核', '2018-09-17 10:10:52', null, '0', null);

-- ----------------------------
-- Table structure for upload_file
-- ----------------------------
DROP TABLE IF EXISTS `upload_file`;
CREATE TABLE `upload_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `req_no` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of upload_file
-- ----------------------------
INSERT INTO `upload_file` VALUES ('1', '', '', '', '', '2018-10-24 15:00:44', '0', '');
INSERT INTO `upload_file` VALUES ('2', '321text', 'E:/temp/', 'txt', 'xq', '2018-10-24 15:02:48', '0', '123');
INSERT INTO `upload_file` VALUES ('3', 'Pms分工及开发周期计划表.docx', 'E://temp//', 'application/vnd.openxmlformats-officedocument.wordprocessingml.document', '333', '2018-11-12 09:51:28', '0', '444444');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_dep` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `call` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modi_time` datetime DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '袁蘅', '123456', '产品开发团队', null, null, '2018-10-13 23:32:36', null, 'female');
INSERT INTO `user` VALUES ('2', '张晓科', '123456', '产品开发团队', null, null, '2018-10-15 14:46:14', null, 'male');
INSERT INTO `user` VALUES ('3', '彭积良', '123456', '产品开发团队', null, null, '2018-10-15 14:47:09', null, 'male');

-- ----------------------------
-- Procedure structure for proc_initData
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_initData`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_initData`()
BEGIN

DECLARE i INT DEFAULT 10000 ;
WHILE i <= 100 DO
	INSERT INTO `req` (
		req_no,
		req_name,
		req_source,
		dept,
		exec_type,
		lead_team,
		coo_team,
		now_user,
		next_user,
		req_status,
		create_date,
		create_uesr,
		modi_date,
		is_deleted
	)
VALUES
	(
		i,
		'基金龙钱宝开发需求',
		'任务书',
		'个人部',
		'日常优化',
		'ateam',
		'bteam',
		'yh',
		'zxk',
		'正在实施',
		NOW(),
		'yh',
		NULL,
		0
	) ;
SET i = i + 1 ;
END
WHILE ; COMMIT ;
END
;;
DELIMITER ;
