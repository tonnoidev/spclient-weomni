DROP TABLE IF EXISTS `service_req`;
CREATE TABLE `service_res` (
  `uid` varchar(100) NOT NULL DEFAULT '',
  `req_id` varchar(100) DEFAULT NULL,
  `brand_id` varchar(20) DEFAULT NULL,
  `branch_id` varchar(20) DEFAULT NULL,
  `terminal_id` varchar(20) DEFAULT NULL,
  `serial_no` varchar(20) DEFAULT NULL,
  `act_code` varchar(20) DEFAULT NULL,
  `true_you_id` varchar(20) DEFAULT NULL,
  `tran_trac_id` varchar(20) DEFAULT NULL,
  `tran_bat_id` varchar(20) DEFAULT NULL,
  `tran_ref_id` varchar(20) DEFAULT NULL,
  `tran_date` datetime DEFAULT NULL,
  `tran_point` varchar(20) DEFAULT NULL,
  `tran_amt` double(10,2) DEFAULT NULL,
  `cust_ref_id` varchar(20) DEFAULT NULL,
  `cust_point_used` varchar(20) DEFAULT NULL,
  `cust_point_balance` double(10,2) DEFAULT NULL,
  `rew_code` varchar(20) DEFAULT NULL,
  `acc_type` varchar(20) DEFAULT NULL,
  `acc_value` varchar(150) DEFAULT NULL,
  `true_card_no` varchar(20) DEFAULT NULL,
  `card_holder_name` varchar(150) DEFAULT NULL,
  `true_card_type` varchar(20) DEFAULT NULL,
  `true_card_status` varchar(20) DEFAULT NULL,
  `true_card_expired` varchar(20) DEFAULT NULL,
  `point_balance` double(10,2) DEFAULT NULL,
  `point_pack_desc` varchar(150) DEFAULT NULL,
  `point_pack_balance` double(10,2) DEFAULT NULL,
  `point_pack_expired` varchar(20) DEFAULT NULL,
  `sliptype_id` varchar(1) DEFAULT NULL COMMENT '1=Normal Cust, 2=True Cust (without card), 3=True Cust (card not expire), 4=True Cust (card expired or has not brought any True product/service), 5=Other',
  `sliptype_desc` varchar(150) DEFAULT NULL,
  `tran_type` varchar(20) DEFAULT NULL,
  `pay_trac_id` varchar(20) DEFAULT NULL,
  `pay_bat_id` varchar(20) DEFAULT NULL,
  `pay_tran_ref_id` varchar(20) DEFAULT NULL,
  `pay_tran_date` datetime DEFAULT NULL,
  `pay_amt` double(10,2) DEFAULT NULL,
  `pay_curr` varchar(20) DEFAULT NULL,
  `pay_code` varchar(20) DEFAULT NULL,
  `pay_method` varchar(20) DEFAULT NULL,
  `camp_name` varchar(150) DEFAULT NULL,
  `cont_camp_code` varchar(20) DEFAULT NULL,
  `cont_camp_name` varchar(150) DEFAULT NULL,
  `cont_camp_img_url` varchar(20) DEFAULT NULL,
  `cont_camp_start` varchar(20) DEFAULT NULL,
  `cont_camp_end` varchar(20) DEFAULT NULL,
  `cont_camp_last_modified` varchar(40) DEFAULT NULL,
  `cont_camp_status` varchar(20) DEFAULT NULL,
  `point_str` varchar(20) DEFAULT NULL,
  `res_data` varchar(255) DEFAULT NULL,
  `res_status` varchar(20) DEFAULT NULL COMMENT 'success, timeout, error',
  `res_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`)
);
