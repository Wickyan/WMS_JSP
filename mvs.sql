-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.51


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema mvs_2
--

CREATE DATABASE IF NOT EXISTS mvs_2;
USE mvs_2;

--
-- Definition of table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `account` varchar(20) NOT NULL,
  `password` varchar(250) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `age` varchar(5) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `admin`
--

/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`account`,`password`,`name`,`sex`,`age`,`phone`,`address`,`email`) VALUES 
 ('admin','123456','张三','女','32','13611111111',NULL,NULL),
 ('wickyan','123456','wickyan','男','200','150000001333234','江苏省徐州市金山东路一号徐海学院','17asdasdas@asd');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;


--
-- Definition of table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `account` varchar(20) NOT NULL,
  `password` varchar(250) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `age` varchar(5) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `customer`
--

/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`account`,`password`,`name`,`sex`,`age`,`phone`,`address`,`email`) VALUES 
 ('000000','000000','000000','男','40','','wickyan@cumt.cn','江苏省徐州市金山东路一号徐海学院');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


--
-- Definition of table `goods`
--

DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `name` varchar(20) NOT NULL,
  `address` varchar(20) DEFAULT NULL,
  `num` int(10) unsigned DEFAULT NULL,
  `goodsid` int(10) unsigned DEFAULT NULL,
  `sort` varchar(15) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `goods`
--

/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` (`name`,`address`,`num`,`goodsid`,`sort`,`price`) VALUES 
 ('000','0000厂商',0,0,'000','000'),
 ('1212112','',190908,1212121,'',''),
 ('1351','',21,2313,'',''),
 ('222','222',1000,222,'','222'),
 ('234234','',234234,234234,'',''),
 ('333','333',633,333,'333','333'),
 ('333333','',333333,333333,'',''),
 ('4536653','',4356,456436,'',''),
 ('465465','',10000,54564545,'',''),
 ('555','555',1400,555,'5555',''),
 ('5555','江苏省徐州市金山东路一号徐海学院',0,5555,'矿泉水',''),
 ('647456','',657567,657567,'',''),
 ('666','666厂商',1021,666,'','2'),
 ('666666','66666',66666,666666,'66666',''),
 ('777','',1300,777,'',''),
 ('7859879','97987',8968,678978,'96896','9789'),
 ('789579','7567',56756,657567,'657567','5'),
 ('789809','',9800,9809,'','980980'),
 ('999','999',1111,999,'999','999'),
 ('康师傅方便面','康师傅',9000,12121123,'方便面','4'),
 ('康师傅矿泉水','康师傅',12000,123,'矿泉水','2'),
 ('康师傅矿泉水asd','',23,12,'',''),
 ('康师傅矿泉水sad','江苏省徐州市金山东路一号徐海学院',10000,12121,'矿泉水','2'),
 ('康师傅矿泉水啊啊啊','222',1000,12121232,'222','222'),
 ('康师傅矿泉水安尔碘所所','江苏省徐州市金山东路一号徐海学院',10000,12121,'矿泉水','2'),
 ('康师傅矿泉水看见','江苏省徐州市金山东路一号徐海学院',10600,1989,'矿泉水','2');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
