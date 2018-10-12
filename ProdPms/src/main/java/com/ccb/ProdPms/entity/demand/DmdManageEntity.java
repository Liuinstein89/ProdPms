package com.ccb.ProdPms.entity.demand;

import java.io.Serializable;

public class DmdManageEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long reqNo;

  `req_name` varchar(255) DEFAULT NULL,
  `req_source` varchar(255) DEFAULT NULL,
  `dept` varchar(255) DEFAULT NULL,
  `exec_type` varchar(255) DEFAULT NULL,
  `lead_team` varchar(255) DEFAULT NULL,
  `coo_team` varchar(255) DEFAULT NULL,
  `now_user` varchar(255) DEFAULT NULL,
  `latter_user` varchar(255) DEFAULT NULL,
  `create_uesr` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
            `modi_date` datetime DEFAULT NULL,
            `req_status` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
}



    SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
        -- Table structure for `req`
        -- ----------------------------
        DROP TABLE IF EXISTS `req`;
        CREATE TABLE `req` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `req_id` int(11) DEFAULT NULL,
        `req_name` varchar(255) DEFAULT NULL,
        `req_source` varchar(255) DEFAULT NULL,
        `dept` varchar(255) DEFAULT NULL,
        `impl_type` varchar(255) DEFAULT NULL,
        `lead_team` varchar(255) DEFAULT NULL,
        `coo_team` varchar(255) DEFAULT NULL,
        `now_user` varchar(255) DEFAULT NULL,
        `latter_user` varchar(255) DEFAULT NULL,
        `create_uesr` varchar(255) DEFAULT NULL,
        `create_date` datetime DEFAULT NULL,
        `modi_date` datetime DEFAULT NULL,
        `state` varchar(255) DEFAULT NULL,
        `is_deleted` tinyint(4) DEFAULT '0',
        `upload` varchar(255) DEFAULT NULL,
        PRIMARY KEY (`id`),
        KEY `id` (`id`,`req_id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;