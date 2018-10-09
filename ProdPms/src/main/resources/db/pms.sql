/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : pms

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-10-08 15:30:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `audit_result`
-- ----------------------------
DROP TABLE IF EXISTS `audit_result`;
CREATE TABLE `audit_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `req_id` int(11) DEFAULT NULL,
  `req_result` int(11) DEFAULT NULL,
  `req_comment` varchar(255) DEFAULT NULL,
  `req_person` int(11) DEFAULT NULL,
  `req_time` datetime DEFAULT NULL,
  `desi_result` int(11) DEFAULT NULL,
  `desi_comment` varchar(255) DEFAULT NULL,
  `desi_person` int(11) DEFAULT NULL,
  `desi_time` datetime DEFAULT NULL,
  `dev_result` int(11) DEFAULT NULL,
  `dev_comment` varchar(255) DEFAULT NULL,
  `dev_person` int(11) DEFAULT NULL,
  `dev_time` datetime DEFAULT NULL,
  `change_time` datetime DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `req_person` (`req_person`),
  KEY `desi_person` (`desi_person`),
  KEY `dev_person` (`dev_person`),
  KEY `req_result` (`req_result`),
  KEY `desi_result` (`desi_result`),
  KEY `dev_result` (`dev_result`),
  KEY `req_id` (`req_id`),
  CONSTRAINT `audit_result_ibfk_1` FOREIGN KEY (`req_person`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `audit_result_ibfk_2` FOREIGN KEY (`desi_person`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `audit_result_ibfk_3` FOREIGN KEY (`dev_person`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `audit_result_ibfk_4` FOREIGN KEY (`req_result`) REFERENCES `state` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `audit_result_ibfk_5` FOREIGN KEY (`desi_result`) REFERENCES `state` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `audit_result_ibfk_6` FOREIGN KEY (`dev_result`) REFERENCES `state` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `audit_result_ibfk_7` FOREIGN KEY (`req_id`) REFERENCES `req` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of audit_result
-- ----------------------------
INSERT INTO `audit_result` VALUES ('1', '1', '2', '该需求具有重要意义，同意纳入开发，请设计团队审核。', '1', '2018-09-17 14:00:40', null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `audit_result` VALUES ('2', '1', null, null, null, null, '12', '需求中关于XXX将对XXX产生影响，建议对需求的XX进行优化。', '3', '2018-09-17 14:02:13', null, null, null, null, null, '0');
INSERT INTO `audit_result` VALUES ('3', '1', '2', '已对需求XXX进行优化，请设计团队审核。', '1', '2018-09-17 14:02:48', null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `audit_result` VALUES ('4', '1', null, null, null, null, '4', '同意。', '3', '2018-09-17 14:03:31', null, null, null, null, null, '0');
INSERT INTO `audit_result` VALUES ('5', '1', null, null, null, null, null, null, null, null, '6', '同意。', '2', '2018-09-17 14:04:13', null, '0');

-- ----------------------------
-- Table structure for `authority`
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `auth_name` varchar(255) DEFAULT NULL,
  `auth_code` varchar(255) DEFAULT NULL,
  `auth_type` varchar(255) DEFAULT NULL,
  `op_person` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modi_time` datetime DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', '需求审核权限', '1', null, null, '2018-09-17 13:58:07', null, '0');
INSERT INTO `authority` VALUES ('2', '设计审核权限', '2', null, null, '2018-09-17 13:58:23', null, '0');
INSERT INTO `authority` VALUES ('3', '开发审核权限', '3', null, null, '2018-09-17 13:58:41', null, '0');
INSERT INTO `authority` VALUES ('4', '测试审核权限', '4', null, null, '2018-09-17 13:58:58', null, '0');
INSERT INTO `authority` VALUES ('5', '创建功能点', '5', null, null, '2018-09-17 14:05:45', null, '0');

-- ----------------------------
-- Table structure for `department`
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '产品开发团队', '1', '2018-09-17 10:19:19', null, '0', null);
INSERT INTO `department` VALUES ('2', '个人部', '2', '2018-09-17 10:19:16', null, '0', null);
INSERT INTO `department` VALUES ('3', '运维', '3', '2018-09-17 10:19:32', null, '0', null);
INSERT INTO `department` VALUES ('4', 'DCM', '4', '2018-09-17 13:56:29', null, '0', null);
INSERT INTO `department` VALUES ('5', '金融科技部', '5', '2018-09-17 13:56:47', null, '0', null);
INSERT INTO `department` VALUES ('6', '托管业务部', '6', '2018-09-17 13:57:03', null, '0', null);
INSERT INTO `department` VALUES ('7', '网络金融部', '7', '2018-09-17 13:57:20', null, '0', null);
INSERT INTO `department` VALUES ('8', '渠道部', '8', '2018-09-17 13:57:34', null, '0', null);

-- ----------------------------
-- Table structure for `dev`
-- ----------------------------
DROP TABLE IF EXISTS `dev`;
CREATE TABLE `dev` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dev_id` int(11) NOT NULL,
  `dev_name` varchar(255) DEFAULT NULL,
  `dev_type` varchar(255) DEFAULT NULL,
  `req_id` int(11) DEFAULT NULL,
  `team` varchar(255) DEFAULT NULL,
  `online` datetime DEFAULT NULL,
  `func_disc` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modi_date` datetime DEFAULT NULL,
  `dev_user` int(11) DEFAULT NULL,
  `test_user` int(11) DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  `workload` varchar(255) DEFAULT NULL,
  `dev_state` int(11) DEFAULT NULL,
  `review_result` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dev_user` (`dev_user`),
  KEY `test_user` (`test_user`),
  KEY `dev_ibfk_4` (`review_result`),
  KEY `dev_state` (`dev_state`),
  KEY `req_id` (`req_id`),
  CONSTRAINT `dev_ibfk_2` FOREIGN KEY (`dev_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `dev_ibfk_3` FOREIGN KEY (`test_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `dev_ibfk_4` FOREIGN KEY (`review_result`) REFERENCES `audit_result` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `dev_ibfk_5` FOREIGN KEY (`dev_state`) REFERENCES `state` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `dev_ibfk_6` FOREIGN KEY (`req_id`) REFERENCES `req` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dev
-- ----------------------------
INSERT INTO `dev` VALUES ('1', '1', '龙财富XXX', '主任务', '1', '龙财富项目组', '2018-09-29 14:37:59', null, '2018-09-17 14:38:04', null, '5', '8', '0', '7', '6', '5');

-- ----------------------------
-- Table structure for `dev_func`
-- ----------------------------
DROP TABLE IF EXISTS `dev_func`;
CREATE TABLE `dev_func` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dev_id` int(11) DEFAULT NULL,
  `func_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modi_date` datetime DEFAULT NULL COMMENT '修改日期',
  `create_user` int(11) DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `dev_id` (`dev_id`),
  KEY `func_id` (`func_id`),
  KEY `create_user` (`create_user`),
  CONSTRAINT `dev_func_ibfk_1` FOREIGN KEY (`dev_id`) REFERENCES `dev` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `dev_func_ibfk_2` FOREIGN KEY (`func_id`) REFERENCES `func` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `dev_func_ibfk_3` FOREIGN KEY (`create_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dev_func
-- ----------------------------
INSERT INTO `dev_func` VALUES ('1', '1', '1', '2018-09-17 14:41:13', null, '1', '0');
INSERT INTO `dev_func` VALUES ('2', '1', '2', '2018-09-17 14:41:31', null, '2', '0');

-- ----------------------------
-- Table structure for `func`
-- ----------------------------
DROP TABLE IF EXISTS `func`;
CREATE TABLE `func` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `func_name` varchar(255) DEFAULT NULL,
  `dev_user` int(11) DEFAULT NULL,
  `test_user` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modi_date` datetime DEFAULT NULL,
  `dev_id` int(11) DEFAULT NULL,
  `test_id` int(11) DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  `create_user` int(11) DEFAULT NULL,
  `upload` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dev_user` (`dev_user`),
  KEY `test_user` (`test_user`),
  KEY `dev_id` (`dev_id`),
  KEY `test_id` (`test_id`),
  KEY `create_user` (`create_user`),
  CONSTRAINT `func_ibfk_1` FOREIGN KEY (`dev_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `func_ibfk_2` FOREIGN KEY (`test_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `func_ibfk_3` FOREIGN KEY (`dev_id`) REFERENCES `dev` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `func_ibfk_4` FOREIGN KEY (`test_id`) REFERENCES `test` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `func_ibfk_5` FOREIGN KEY (`create_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of func
-- ----------------------------
INSERT INTO `func` VALUES ('1', 'XX功能点1', '5', '8', '2018-09-17 14:32:15', null, null, null, '0', null, null);
INSERT INTO `func` VALUES ('2', 'XX功能点2', '6', '8', '2018-09-17 14:32:59', null, null, null, '0', null, null);
INSERT INTO `func` VALUES ('3', 'XX功能点3', '5', '8', '2018-09-17 14:33:16', null, null, null, '0', null, null);

-- ----------------------------
-- Table structure for `project_team`
-- ----------------------------
DROP TABLE IF EXISTS `project_team`;
CREATE TABLE `project_team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(255) DEFAULT NULL,
  `belong_dpt_id` int(11) DEFAULT NULL,
  `team_leader` int(11) DEFAULT NULL,
  `team_num` int(11) DEFAULT NULL,
  `team_member` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `change_time` datetime DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  `op_person` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `project_team_table_ibfk_1` (`belong_dpt_id`),
  KEY `team_leader` (`team_leader`),
  CONSTRAINT `project_team_ibfk_1` FOREIGN KEY (`belong_dpt_id`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `project_team_ibfk_2` FOREIGN KEY (`team_leader`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_team
-- ----------------------------
INSERT INTO `project_team` VALUES ('1', '代理基金', '1', '2', '10', null, '2018-09-17 13:54:03', null, '0', null);
INSERT INTO `project_team` VALUES ('2', '个人资产管理', '1', '2', '10', null, '2018-09-17 13:55:58', null, '0', null);

-- ----------------------------
-- Table structure for `req`
-- ----------------------------
DROP TABLE IF EXISTS `req`;
CREATE TABLE `req` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `req_id` int(11) DEFAULT NULL,
  `req_name` varchar(255) DEFAULT NULL,
  `req_source` int(11) DEFAULT NULL,
  `dept` int(11) DEFAULT NULL,
  `impl_type` int(11) DEFAULT NULL,
  `lead_team` int(11) DEFAULT NULL,
  `coo_team` int(255) DEFAULT NULL,
  `now_user` int(11) DEFAULT NULL,
  `latter_user` int(11) DEFAULT NULL,
  `create_uesr` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modi_date` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  `upload` varchar(255) DEFAULT NULL,
  `review_result` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `req_source` (`req_source`),
  KEY `dept` (`dept`),
  KEY `impl_type` (`impl_type`),
  KEY `lead_team` (`lead_team`),
  KEY `coo_team` (`coo_team`),
  KEY `now_user` (`now_user`),
  KEY `latter_user` (`latter_user`),
  KEY `create_uesr` (`create_uesr`),
  KEY `state` (`state`),
  KEY `review_result` (`review_result`),
  CONSTRAINT `req_ibfk_1` FOREIGN KEY (`req_source`) REFERENCES `req_source` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `req_ibfk_10` FOREIGN KEY (`review_result`) REFERENCES `audit_result` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `req_ibfk_2` FOREIGN KEY (`dept`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `req_ibfk_3` FOREIGN KEY (`impl_type`) REFERENCES `req_impl_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `req_ibfk_4` FOREIGN KEY (`lead_team`) REFERENCES `project_team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `req_ibfk_5` FOREIGN KEY (`coo_team`) REFERENCES `project_team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `req_ibfk_6` FOREIGN KEY (`now_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `req_ibfk_7` FOREIGN KEY (`latter_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `req_ibfk_8` FOREIGN KEY (`create_uesr`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `req_ibfk_9` FOREIGN KEY (`state`) REFERENCES `state` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of req
-- ----------------------------
INSERT INTO `req` VALUES ('1', '1', '《GRB18050402龙钱宝支持多产品业务需求说明》', '1', '2', '1', '1', null, null, '1', null, '2018-09-17 14:16:04', null, '7', '0', null, null);
INSERT INTO `req` VALUES ('2', '2', '增加对信用卡不能办理基金业务的校验', '2', '3', '1', '2', null, null, null, null, '2018-09-17 14:17:58', null, '2', '0', null, null);

-- ----------------------------
-- Table structure for `req_func`
-- ----------------------------
DROP TABLE IF EXISTS `req_func`;
CREATE TABLE `req_func` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `req_id` int(11) DEFAULT NULL,
  `func_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modi_date` datetime DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `req_id` (`req_id`),
  KEY `func_id` (`func_id`),
  KEY `create_user` (`create_user`),
  CONSTRAINT `req_func_ibfk_1` FOREIGN KEY (`req_id`) REFERENCES `req` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `req_func_ibfk_2` FOREIGN KEY (`func_id`) REFERENCES `func` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `req_func_ibfk_3` FOREIGN KEY (`create_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of req_func
-- ----------------------------
INSERT INTO `req_func` VALUES ('1', '1', '1', '2018-09-17 14:33:51', null, null, '0');
INSERT INTO `req_func` VALUES ('2', '1', '2', '2018-09-17 14:34:04', null, null, '0');
INSERT INTO `req_func` VALUES ('3', '2', '3', '2018-09-17 14:34:17', null, null, '0');

-- ----------------------------
-- Table structure for `req_impl_type`
-- ----------------------------
DROP TABLE IF EXISTS `req_impl_type`;
CREATE TABLE `req_impl_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `req_impl_type_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `change_time` datetime DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  `op_person` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of req_impl_type
-- ----------------------------
INSERT INTO `req_impl_type` VALUES ('1', '日常优化', '2018-09-17 10:21:11', null, '0', null);
INSERT INTO `req_impl_type` VALUES ('2', '项目', '2018-09-17 10:21:22', null, '0', null);

-- ----------------------------
-- Table structure for `req_source`
-- ----------------------------
DROP TABLE IF EXISTS `req_source`;
CREATE TABLE `req_source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `req_souce_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `change_time` datetime DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  `op_person` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of req_source
-- ----------------------------
INSERT INTO `req_source` VALUES ('1', 'ITDM', '2018-09-17 10:19:50', null, '0', null);
INSERT INTO `req_source` VALUES ('2', '功能优化', '2018-09-17 10:20:03', null, '0', null);
INSERT INTO `req_source` VALUES ('3', 'DCM单', '2018-09-17 10:20:15', null, '0', null);
INSERT INTO `req_source` VALUES ('4', '任务书', '2018-09-17 10:20:25', null, '0', null);
INSERT INTO `req_source` VALUES ('5', '配合任务', '2018-09-17 10:20:37', null, '0', null);
INSERT INTO `req_source` VALUES ('6', 'PIO', '2018-09-17 10:20:49', null, '0', null);

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_type` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modi_time` datetime DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  `op_person` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `create_person` (`op_person`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '需求管理人', '2018-09-17 10:16:55', null, '0', null);
INSERT INTO `role` VALUES ('2', '设计管理人', '2018-09-17 10:17:08', null, '0', null);
INSERT INTO `role` VALUES ('3', '开发管理人', '2018-09-17 10:17:20', null, '0', null);
INSERT INTO `role` VALUES ('4', '测试管理人', '2018-09-17 10:17:31', null, '0', null);

-- ----------------------------
-- Table structure for `role_authority`
-- ----------------------------
DROP TABLE IF EXISTS `role_authority`;
CREATE TABLE `role_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `authority_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modi_date` datetime DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  `op_person` int(11) DEFAULT NULL COMMENT '操作人',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `authority_id` (`authority_id`),
  KEY `op_user` (`op_person`),
  CONSTRAINT `role_authority_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_authority_ibfk_2` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_authority
-- ----------------------------
INSERT INTO `role_authority` VALUES ('1', '1', '1', '2018-09-17 14:05:20', null, '0', null);
INSERT INTO `role_authority` VALUES ('2', '1', '5', '2018-09-17 14:06:26', null, '0', null);
INSERT INTO `role_authority` VALUES ('3', '2', '2', '2018-09-17 14:06:52', null, '0', null);
INSERT INTO `role_authority` VALUES ('4', '2', '5', '2018-09-17 14:07:19', null, '0', null);
INSERT INTO `role_authority` VALUES ('5', '3', '3', '2018-09-17 14:07:39', null, '0', null);
INSERT INTO `role_authority` VALUES ('6', '3', '5', '2018-09-01 14:07:53', null, '0', null);
INSERT INTO `role_authority` VALUES ('7', '4', '4', '2018-09-17 14:08:14', null, '0', null);

-- ----------------------------
-- Table structure for `state`
-- ----------------------------
DROP TABLE IF EXISTS `state`;
CREATE TABLE `state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `change_time` datetime DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  `op_person` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of state
-- ----------------------------
INSERT INTO `state` VALUES ('1', '需求待审核', '2018-09-17 10:10:52', null, '0', null);
INSERT INTO `state` VALUES ('2', '需求审核通过', '2018-09-17 10:11:15', null, '0', null);
INSERT INTO `state` VALUES ('3', '设计待审核', '2018-09-17 10:11:45', null, '0', null);
INSERT INTO `state` VALUES ('4', '设计审核通过', '2018-09-17 10:11:58', null, '0', null);
INSERT INTO `state` VALUES ('5', '开发待审核', '2018-09-17 10:12:23', null, '0', null);
INSERT INTO `state` VALUES ('6', '同意开发', '2018-09-17 10:12:36', null, '0', null);
INSERT INTO `state` VALUES ('7', '已受理', '2018-09-17 10:13:04', null, '0', null);
INSERT INTO `state` VALUES ('8', '正在实施', '2018-09-17 10:13:38', null, '0', null);
INSERT INTO `state` VALUES ('9', '不实施', '2018-09-17 10:13:52', null, '0', null);
INSERT INTO `state` VALUES ('10', '已上线', '2018-09-17 10:14:09', null, '0', null);
INSERT INTO `state` VALUES ('11', '需求审核不通过', '2018-09-17 10:14:54', null, '0', null);
INSERT INTO `state` VALUES ('12', '设计审核不通过', '2018-09-17 10:15:09', null, '0', null);
INSERT INTO `state` VALUES ('13', '开发审核不通过', '2018-09-17 10:15:34', null, '0', null);
INSERT INTO `state` VALUES ('14', '关闭', '2018-09-17 10:16:02', null, '0', null);
INSERT INTO `state` VALUES ('15', '测试未开始', '2018-09-17 16:17:48', null, '0', null);
INSERT INTO `state` VALUES ('16', '测试中', '2018-09-17 16:18:01', null, '0', null);
INSERT INTO `state` VALUES ('17', '测试已完成', '2018-09-17 16:18:13', null, '0', null);

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `test_id` int(11) DEFAULT NULL,
  `test_name` varchar(255) DEFAULT NULL,
  `online` datetime DEFAULT NULL COMMENT '上线点',
  `test_user` int(11) DEFAULT NULL COMMENT '测试任务执行人',
  `func_num` int(11) DEFAULT NULL,
  `team` int(11) DEFAULT NULL COMMENT '项目组名称',
  `create_user` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `func_state` int(11) DEFAULT NULL,
  `nonfunc_state` int(11) DEFAULT NULL,
  `dev_id` int(11) DEFAULT NULL,
  `modi_date` datetime DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  `upload` varchar(255) DEFAULT NULL,
  `review_result` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `test_user` (`test_user`),
  KEY `team` (`team`),
  KEY `create_user` (`create_user`),
  KEY `func_state` (`func_state`),
  KEY `nonfunc_state` (`nonfunc_state`),
  KEY `dev_id` (`dev_id`),
  KEY `review_result` (`review_result`),
  CONSTRAINT `test_ibfk_1` FOREIGN KEY (`test_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `test_ibfk_2` FOREIGN KEY (`team`) REFERENCES `project_team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `test_ibfk_3` FOREIGN KEY (`create_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `test_ibfk_4` FOREIGN KEY (`func_state`) REFERENCES `state` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `test_ibfk_5` FOREIGN KEY (`nonfunc_state`) REFERENCES `state` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `test_ibfk_6` FOREIGN KEY (`dev_id`) REFERENCES `dev` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `test_ibfk_7` FOREIGN KEY (`review_result`) REFERENCES `audit_result` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '1', 'XX1', '2018-09-19 16:16:14', '7', '3', '1', '8', '2018-09-17 16:16:41', '15', '15', '1', null, '0', null, null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_dep` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `call` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modi_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_table_ibfk_1` (`user_dep`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`user_dep`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '袁蘅', '123456', '1', null, null, '2018-09-17 10:22:04', null);
INSERT INTO `user` VALUES ('2', '张晓科', '123456', '1', null, null, '2018-09-17 10:38:58', null);
INSERT INTO `user` VALUES ('3', '彭积良', '123456', '1', null, null, '2018-09-17 11:25:30', null);
INSERT INTO `user` VALUES ('4', '邓昌胜', '123456', '1', null, null, '2018-09-17 11:26:01', null);
INSERT INTO `user` VALUES ('5', '朱琳', '123456', '1', null, null, '2018-09-17 11:26:18', null);
INSERT INTO `user` VALUES ('6', '谭文', '123456', '1', null, null, '2018-09-17 11:26:36', null);
INSERT INTO `user` VALUES ('7', '彭东脉', '123456', '1', null, null, '2018-09-17 11:26:57', null);
INSERT INTO `user` VALUES ('8', '龚正东', '123456', '1', null, null, '2018-09-17 14:11:51', null);

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modi_date` datetime DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  `op_person` varchar(255) DEFAULT NULL COMMENT '操作人',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  KEY `op_user` (`op_person`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1', '2018-09-17 14:09:10', null, '0', null);
INSERT INTO `user_role` VALUES ('2', '2', '3', '2018-09-17 14:10:37', null, '0', null);
INSERT INTO `user_role` VALUES ('3', '3', '2', '2018-09-17 14:10:55', null, '0', null);
INSERT INTO `user_role` VALUES ('4', '8', '4', '2018-09-17 14:12:31', null, '0', null);
