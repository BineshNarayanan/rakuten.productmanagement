-- --------------------------------------------------------
-- Host:                         incompopsuat
-- Server version:               5.0.96-community-nt - MySQL Community Edition (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table test.Product
CREATE TABLE IF NOT EXISTS `Product` (
  `Id` bigint(20) NOT NULL auto_increment,
  `Name` varchar(100) NOT NULL,
  `Description` varchar(2000) default NULL,
  `Price` double NOT NULL default '0',
  `Available` char(1) default NULL,
  `CategoryId` bigint(20) default NULL,
  `CategoryPath` varchar(200) default NULL,
  `Popularity` int(11) default '0',
  `CreateDate` timestamp NULL default CURRENT_TIMESTAMP,
  `UpdateDate` timestamp NULL default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;
INSERT INTO `Product` (`Id`, `Name`, `Description`, `Price`, `Available`, `CategoryId`, `CategoryPath`, `Popularity`, `CreateDate`, `UpdateDate`) VALUES
	(8, 'P1', 'Desc1', 20.15, NULL, 0, 'Electronics/Computers/Phablet/', 0, '2015-08-07 16:29:57', NULL),
	(12, 'P1', 'Desc1', 20.15, NULL, 0, 'Electronics/Computers/Phablet/', 0, '2015-08-07 16:47:30', NULL),
	(13, 'P1', 'Desc1', 20.15, NULL, 0, 'Electronics/Computers/Phablet/', 0, '2015-08-07 16:48:54', NULL),
	(14, 'P1', 'Desc1', 20.15, NULL, 0, 'Electronics/Computers/Phablet/', 0, '2015-08-07 16:49:32', NULL),
	(15, 'P1', 'Desc1', 20.15, NULL, 0, 'Electronics/Computers/Phablet/', 0, '2015-08-07 16:50:09', NULL),
	(17, 'TestProduct', NULL, 0, NULL, 0, NULL, 0, '2015-08-08 01:35:16', NULL),
	(20, 'TestProduct', NULL, 0, NULL, 0, NULL, 0, '2015-08-08 01:55:31', NULL),
	(21, 'TestProduct', NULL, 0, NULL, 0, NULL, 0, '2015-08-08 02:01:54', NULL),
	(22, 'TestProduct', NULL, 0, NULL, 0, NULL, 0, '2015-08-08 02:07:56', NULL),
	(23, 'TestProduct', NULL, 0, NULL, 0, NULL, 0, '2015-08-08 02:11:40', NULL),
	(24, 'TestProduct', NULL, 0, NULL, 0, NULL, 0, '2015-08-08 02:19:36', NULL),
	(25, 'TestProduct', NULL, 0, NULL, 0, NULL, 0, '2015-08-08 02:20:06', NULL),
	(26, 'TestProduct', NULL, 0, NULL, 0, NULL, 0, '2015-08-08 02:21:47', NULL),
	(27, 'P1', 'Desc1', 20.15, NULL, 0, NULL, 0, '2015-08-11 15:55:41', NULL),
	(28, 'P1', 'Desc1', 20.15, NULL, 0, NULL, 0, '2015-08-11 16:35:35', NULL),
	(29, 'TestProduct', NULL, 0, NULL, 0, NULL, 0, '2015-08-11 16:35:36', NULL),
	(30, 'P1', 'Desc1', 20.15, NULL, 0, NULL, 0, '2015-08-11 17:02:06', NULL),
	(33, 'Amd Laptop', 'Amd A8 Laptop', 28000, NULL, 0, 'ELECTRONICS/COMPUTERS/LAPTOP', 8, '2015-08-12 12:03:56', NULL),
	(36, 'P1', 'Desc1', 20.15, NULL, 0, NULL, 0, '2015-08-12 18:29:01', NULL),
	(37, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 18:47:57', NULL),
	(38, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 18:47:57', NULL),
	(39, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 18:49:36', NULL),
	(40, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 18:49:36', NULL),
	(41, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 23:52:16', NULL),
	(42, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 23:52:16', NULL),
	(43, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 23:56:21', NULL),
	(45, 'TestProduct', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 23:56:21', NULL),
	(46, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 23:56:21', NULL),
	(47, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 23:56:21', NULL),
	(48, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 23:57:27', NULL),
	(50, 'TestProduct', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 23:57:27', NULL),
	(51, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 23:57:27', NULL),
	(52, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 23:58:23', NULL),
	(53, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 23:58:23', NULL),
	(54, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 23:58:30', NULL),
	(55, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 23:59:05', NULL),
	(56, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 23:59:26', NULL),
	(57, 'TestingUpdate', NULL, 0, NULL, 0, NULL, 0, '2015-08-12 23:59:26', NULL),
	(58, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:00:55', NULL),
	(59, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:00:55', NULL),
	(60, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:00:55', NULL),
	(61, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:02:38', NULL),
	(62, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:02:38', NULL),
	(63, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:02:38', NULL),
	(64, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:03:07', NULL),
	(65, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:03:47', NULL),
	(66, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:04:18', NULL),
	(67, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:06:04', NULL),
	(68, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:06:04', NULL),
	(69, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:08:04', NULL),
	(70, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:09:32', NULL),
	(71, 'TestingUpdate', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:09:32', NULL),
	(72, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:11:50', NULL),
	(73, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:11:55', NULL),
	(74, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:12:00', NULL),
	(75, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:12:41', NULL),
	(76, 'TestingDelete', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:12:44', NULL),
	(77, 'TestSave', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:32:55', NULL),
	(78, 'TestingUpdate', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:32:55', NULL),
	(79, 'TestSave', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:35:06', NULL),
	(80, 'TestingUpdate', NULL, 0, NULL, 0, NULL, 0, '2015-08-13 00:35:06', NULL);
/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
