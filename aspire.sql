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

/*Table structure for table `device` */

DROP TABLE IF EXISTS `device`;

CREATE TABLE `device` (
  `deviceId` varchar(50) NOT NULL COMMENT '设备id规则：YYYYMMDDHH24MISS+6位序号SEQ',
  `deviceName` varchar(10) NOT NULL COMMENT '设备名称',
  `firmVersion` varchar(50) NOT NULL COMMENT '硬件版本，取值如下：DTSK3，DTSK4，DTSK3A',
  `recordDateTime` datetime DEFAULT NULL COMMENT '入库时间：YYYY-MM-DD HH-mm-ss',
  `deviceStatus` int(2) NOT NULL COMMENT '设备状态：1在线 2离线',
  PRIMARY KEY (`deviceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `device` */

insert  into `device`(`deviceId`,`deviceName`,`firmVersion`,`recordDateTime`,`deviceStatus`) values ('2017-08-213135c7f01f667704f3e89ef7594a397e1fa','联想','DTSK5','2017-08-01 13:18:51',2),('2017-08-213168ec6d46b6d124fc08f16089e77947113','华硕','DTSK5','2017-08-01 16:08:18',2),('2017-08-214111573acb6aeed434889317e337fbb9cfb','华硕','DTSK4','2017-08-02 11:18:57',2),('2017-08-214111f22227bdab44a1aa4a08d95616180fb','华为','DTSK5','2017-08-02 11:18:35',2),('2017-08-214116f6817bb7e5040d3b98b41bf28ee0fa2','联想','DTSK5','2017-08-02 11:21:37',2),('2017-08-21514f36b77607c7a461a9e2ae083641b04fa','苹果','DTSK5','2017-08-03 14:35:23',2),('2017-08-2151647e1822db1ec4a8da72e42c2e90131de','苹果','DTSK5','2017-08-03 16:22:14',2),('2017-08-215173a1e747abed1499fab607c19485395f6','苹果','DTSK5','2017-08-03 17:30:36',2),('20170719162024MISSLDTSK3','联想','DTSK3','2017-07-19 16:40:43',2),('201707212243HDTSK4','华硕','DTSK4','2017-07-21 22:43:29',2),('201707230744DTSK3A','苹果','DTSK3A','2017-07-23 07:44:49',2);

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

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
