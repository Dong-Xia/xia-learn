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
  `systemFileName` varchar(100) NOT NULL COMMENT '文件后天存储名称；格式使用时间戳yyyyMMddHHmmssSSS.扩展名 年月日时分秒毫秒',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

/*Data for the table `program` */

insert  into `program`(`id`,`name`,`duration`,`md5`,`extension`,`size`,`recordDateTime`,`systemFileName`) values (6,'Kalimba.mp3',348,'2ADDF5EBE20CE22CA79CEB9D7DF59A42','.mp3','8414449','2017-08-09 10:00:32','20170809100032285.mp3'),(7,'Sleep Away.mp3',200,'F312BDAF8C1D0A901682C0395119E1C8','.mp3','4842585','2017-08-09 10:00:54','20170809100054743.mp3'),(8,'Maid with the Flaxen Hair.mp3',169,'9535D8FC5D05B0EB862FCAB6721F262B','.mp3','4113874','2017-08-09 10:01:04','20170809100104643.mp3'),(9,'_Re-梦_,阿桑 - 一直很安静(阿桑)（Cover 阿桑）.mp3',250,'1989E0693793CA7197938B7E26DDDDF9','.mp3','6095580','2017-08-09 10:11:58','20170809101158031.mp3'),(10,'_Re-梦_,胡歌 - 逍遥叹（Cover 胡歌）.mp3',314,'160989ED66F5145F7CEAAB618794F6A8','.mp3','7620259','2017-08-09 10:12:09','20170809101209449.mp3'),(25,'青鸟飞鱼 - 此生不换.mp3',266,'18320C15FCC30B183B95529A0E53AC87','.mp3','6535702','2017-08-09 16:36:38','20170809163638422.mp3'),(26,'光良 - 童话.mp3',246,'1D238DCA490154716FC07C791B0A36C5','.mp3','6403465','2017-08-09 16:38:14','20170809163814513.mp3'),(27,'Maid with the Flaxen Hair.mp3',169,'C67C00DFE41B267916E169DA9F41E18C','.mp3','4113874','2017-08-09 16:44:53','20170809164453737.mp3'),(32,'Kalimba.mp3',348,'803A3D00D3191E041B13EB1A8C9E30AF','.mp3','8414449','2017-08-09 16:59:50','20170809165950254.mp3'),(33,'Sleep Away.mp3',200,'F312BDAF8C1D0A901682C0395119E1C8','.mp3','4842585','2017-08-09 16:59:56','20170809165956030.mp3'),(40,'赵雷 - 成都.mp3',328,'62000308281D2E9583B2BDC4D8ED5DE2','.mp3','8137791','2017-08-10 00:18:02','20170810001802773.mp3'),(41,'Maid with the Flaxen Hair.mp3',169,'C67C00DFE41B267916E169DA9F41E18C','.mp3','4113874','2017-08-10 14:19:21','20170810141921284.mp3'),(42,'Kalimba.mp3',348,'803A3D00D3191E041B13EB1A8C9E30AF','.mp3','8414449','2017-08-10 14:19:46','20170810141946001.mp3'),(43,'Kalimba.mp3',348,'803A3D00D3191E041B13EB1A8C9E30AF','.mp3','8414449','2017-08-10 14:19:51','20170810141951453.mp3'),(44,'Maid with the Flaxen Hair.mp3',169,'9535D8FC5D05B0EB862FCAB6721F262B','.mp3','4113874','2017-08-10 14:23:02','20170810142302175.mp3'),(48,'Kalimba.mp3',348,'2ADDF5EBE20CE22CA79CEB9D7DF59A42','.mp3','8414449','2017-08-10 15:38:30','20170810153830893.mp3'),(49,'Kalimba.mp3',348,'2ADDF5EBE20CE22CA79CEB9D7DF59A42','.mp3','8414449','2017-08-10 15:39:15','20170810153915327.mp3'),(50,'Maid with the Flaxen Hair.mp3',169,'C67C00DFE41B267916E169DA9F41E18C','.mp3','4113874','2017-08-10 16:39:11','20170810163911825.mp3'),(51,'张芸京 - 偏爱.mp3',213,'4fd21300b4327b90452eb91ea1708a2b','.mp3','5765555','2017-08-10 17:21:42','20170810172142198.mp3'),(54,'_Re-梦_,胡歌 - 逍遥叹（Cover 胡歌）.mp3',314,'75fef9c15e7a232fabb7a72a0f9adae9','.mp3','7620259','2017-08-10 18:10:50','20170810181050616.mp3'),(55,'_Re-梦_,阿桑 - 一直很安静(阿桑)（Cover 阿桑）.mp3',250,'eacb66e3e55a64644b0354a55809e4fd','.mp3','6095580','2017-08-10 18:31:40','20170810183140273.mp3'),(56,'_Re-梦_,胡歌 - 逍遥叹（Cover 胡歌）.mp3',314,'75fef9c15e7a232fabb7a72a0f9adae9','.mp3','7620259','2017-08-10 18:31:54','20170810183154368.mp3'),(57,'赵雷 - 南方姑娘.mp3',335,'81444fb67f9f4a1b972a186cfb10dd2e','.mp3','8142687','2017-08-10 18:33:37','20170810183337964.mp3'),(58,'_Re-梦_,胡歌 - 逍遥叹（Cover 胡歌）.mp3',314,'75fef9c15e7a232fabb7a72a0f9adae9','.mp3','7620259','2017-08-10 20:23:45','20170810202345404.mp3'),(60,'光良 - 烟火.mp3',251,'5f682f6d079d622ed78c0e40b0f47b0a','.mp3','6083238','2017-08-10 23:20:08','20170810232008125.mp3'),(61,'_Re-梦_,阿桑 - 一直很安静(阿桑)（Cover 阿桑）.mp3',250,'eacb66e3e55a64644b0354a55809e4fd','.mp3','6095580','2017-08-10 23:20:21','20170810232021410.mp3'),(62,'张芸京 - 偏爱.mp3',213,'4fd21300b4327b90452eb91ea1708a2b','.mp3','5765555','2017-08-10 23:32:30','20170810233230640.mp3'),(66,'赵雷 - 成都.mp3',328,'7670543286bb51f0dfc1737af65fead6','.mp3','8137791','2017-08-11 00:02:39','20170811000239761.mp3'),(68,'赵雷 - 成都.mp3',328,'7670543286bb51f0dfc1737af65fead6','.mp3','8137791','2017-08-11 09:25:20','20170811092520978.mp3'),(69,'光良,曹格 - 少年.mp3',253,'834ca1def85ffd9a7ae695fd9b2a22be','.mp3','6577153','2017-08-11 09:27:48','20170811092748046.mp3'),(70,'赵雷 - 成都.mp3',328,'7670543286bb51f0dfc1737af65fead6','.mp3','8137791','2017-08-11 09:28:00','20170811092800108.mp3');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
