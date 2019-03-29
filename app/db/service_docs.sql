DROP TABLE IF EXISTS `service_docs`;
CREATE TABLE `service_docs` (
  `api_id` varchar(2) NOT NULL DEFAULT '',
  `api_name` varchar(50) NOT NULL DEFAULT '',
  `api_uri` varchar(120) NOT NULL DEFAULT '',
  `api_desc` varchar(200) NOT NULL DEFAULT '',
  `api_method` varchar(4) NOT NULL DEFAULT '',
  PRIMARY KEY (`api_id`)
);

INSERT INTO `service_docs` (`api_id`,`api_name`,`api_uri`,`api_desc`,`api_method`) VALUES ('01','API_ACTIVATE','/v1/terminals/activate','POS registration','POST'),('02','API_PRIVILEGE_REDEEM_CAMPAIGN','/privilege/v1/terminals/{terminalId}/redeem-campaign','Redeem by Campaign Code','POST'),('03','API_PRIVILEGE_REDEEM_CODE','/privilege/v1/terminals/{terminalId}/redeem-code','Redeem by Reward Code','POST'),('04','API_PRIVILEGE_EARN_POINT','/privilege/v1/terminals/{terminalId}/earn-point','Earn Point','POST'),('05','API_PRIVILEGE_TRUE_YOU_CARD','/privilege/v1/terminals/{terminalId}/true-you-card','Get TrueYou Card Information','GET'),('06','API_PRIVILEGE_EARN_POINT_VOID','/privilege/v1/terminals/{terminalId}/earn-point/{traceId}/void','Void earn-True-point transaction','POST'),('07','API_PRIVILEGE_BURN_POINT_VOID','/privilege/v1/terminals/{terminalId}/burn-point/{traceId}/void','Void redemption transaction','POST'),('08','API_CAMPAIGN','/campaign/v1/terminals/{terminalId}','Get Campaigns','GET'),('09','API_PAYMENTS','/payment/v1/terminals/{terminalId}/payments','Create Payment','POST'),('10','API_PAYMENTS_VOID','/payment/v1/terminals/{terminalId}/payments/{traceId}/void','Void Transaction','POST'),('11','API_POS_HEALTH','/pos/health','Health check','GET');