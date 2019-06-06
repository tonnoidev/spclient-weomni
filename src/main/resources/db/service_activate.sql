DROP TABLE IF EXISTS `service_activate`;
CREATE TABLE `service_activate` (
  `brand_id` varchar(50) NOT NULL DEFAULT '',
  `branch_id` varchar(50) NOT NULL DEFAULT '',
  `terminal_id` varchar(50) NOT NULL DEFAULT '',
  `serial_number` varchar(50) NOT NULL DEFAULT '',
  `activation_code` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
