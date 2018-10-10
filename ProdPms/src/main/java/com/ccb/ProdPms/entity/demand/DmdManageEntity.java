package com.ccb.ProdPms.entity.demand;

import java.io.Serializable;

public class DmdManageEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long reqId;
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
}
