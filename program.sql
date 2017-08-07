/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.27 : Database - aspire
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`aspire` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `aspire`;

/*Table structure for table `program` */

DROP TABLE IF EXISTS `program`;

CREATE TABLE `program` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'mysql支持的id自增长',
  `name` varchar(100) NOT NULL COMMENT '文件名称',
  `duration` int(5) DEFAULT NULL COMMENT '文件持续时长，单位秒',
  `md5` varchar(100) NOT NULL COMMENT '文件MD5',
  `extension` varchar(10) NOT NULL COMMENT '文件后缀',
  `size` varchar(100) NOT NULL COMMENT '文件大小，单位字节',
  `recordDateTime` datetime DEFAULT NULL COMMENT '入库时间：YYYY-MM-DD HH-mm-ss',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `program` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
