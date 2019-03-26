# Host: localhost  (Version 5.5.36)
# Date: 2019-01-18 17:24:55
# Generator: MySQL-Front 6.1  (Build 1.26)


#
# Structure for table "trigger_services"
#

DROP TABLE IF EXISTS `trigger_services`;
CREATE TABLE `trigger_services` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `trigger_id` int(2) NOT NULL DEFAULT '0',
  `system_time` datetime DEFAULT NULL,
  `service_type` varchar(50) NOT NULL DEFAULT '',
  `res_owner` varchar(50) DEFAULT NULL,
  `req_owner` varchar(50) DEFAULT NULL,
  `data_status` varchar(50) DEFAULT NULL,
  `system_update` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "trigger_services"
#

INSERT INTO `trigger_services` VALUES (1,1,'2019-01-18 16:42:12','GET','-','POS','CREATE',NULL),(2,1,'2019-01-18 16:44:23','GET','SERVICE','POS','READ','2019-01-18 16:46:39');
