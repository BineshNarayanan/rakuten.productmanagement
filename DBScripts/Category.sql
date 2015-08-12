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

-- Dumping structure for table test.Category
CREATE TABLE IF NOT EXISTS `Category` (
  `Id` bigint(20) NOT NULL auto_increment,
  `Name` varchar(100) NOT NULL,
  `ParentId` bigint(20) default NULL,
  `Description` varchar(1000) default NULL,
  `Depth` int(11) NOT NULL default '0',
  `CreateDate` datetime default NULL,
  `UpdateDate` datetime default NULL,
  `CreatedBy` varchar(50) default NULL,
  `UpdatedBy` varchar(50) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
