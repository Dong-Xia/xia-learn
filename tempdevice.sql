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

/*Table structure for table `tempdevice` */

DROP TABLE IF EXISTS `tempdevice`;

CREATE TABLE `tempdevice` (
  `deviceId` varchar(50) NOT NULL COMMENT '设备id规则：YYYYMMDDHH24MISS+6位序号SEQ',
  `deviceName` varchar(10) NOT NULL COMMENT '设备名称',
  `firmVersion` varchar(50) NOT NULL COMMENT '硬件版本，取值如下：DTSK3，DTSK4，DTSK3A',
  `recordDateTime` datetime DEFAULT NULL COMMENT '入库时间：YYYY-MM-DD HH-mm-ss',
  PRIMARY KEY (`deviceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tempdevice` */

insert  into `tempdevice`(`deviceId`,`deviceName`,`firmVersion`,`recordDateTime`) values ('20170407110403OTj20v','苹果','DTSK5','2017-08-07 11:04:03'),('201707230744DTSK3A','联想','DTSK3','2017-08-01 10:37:17'),('20170807151223H5til6','华硕','DTSK3','2017-08-07 15:12:23'),('20170807153958171cG4','小米','DTSK3','2017-08-07 15:39:58'),('201708219105634n07I5g','小米','DTSK5','2017-08-07 10:56:34'),('201708219110203EM6258','联想','DTSK5','2017-08-07 11:02:03'),('20178507110525gjI14R','vivo','DTSK5','2017-08-07 11:05:25');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
