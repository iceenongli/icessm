# Host: localhost  (Version: 5.5.53)
# Date: 2018-02-24 20:27:51
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "t_user"
#

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `birthday` datetime DEFAULT NULL COMMENT '出生年月',
  `salary` decimal(10,2) DEFAULT NULL COMMENT '工资',
  `loginCount` int(11) DEFAULT NULL COMMENT '登陆次数',
  `praise` bigint(20) DEFAULT NULL COMMENT '点赞数',
  `account` double(10,2) DEFAULT NULL COMMENT '账户金额',
  `status` varchar(10) DEFAULT NULL COMMENT '用户状态',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户表';

#
# Data for table "t_user"
#

/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1001,'张三','123456','2018-02-24 20:27:19',9999.00,0,987654321,12345.67,'LOGIN'),(1002,'李四','123456','2018-02-24 20:27:31',9999.00,0,987654321,12345.67,'LOGIN');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
