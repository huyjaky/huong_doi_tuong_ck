-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.25-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for quanlytaikhoancanhan
CREATE DATABASE `quanlytaikhoancanhan` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `quanlytaikhoancanhan`;

-- Dumping structure for table quanlytaikhoancanhan.danhmucchi
CREATE TABLE IF NOT EXISTS `danhmucchi` (
  `madanhmucchi` varchar(20) NOT NULL,
  `tendanhmuc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`madanhmucchi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table quanlytaikhoancanhan.danhmucchi: ~5 rows (approximately)
INSERT INTO `danhmucchi` (`madanhmucchi`, `tendanhmuc`) VALUES
	('dm0', NULL),
	('dm1', 'an uong'),
	('dm2', 'mua sam'),
	('dm3', 'di cho'),
	('dm4896', 'mua ban phim');

-- Dumping structure for table quanlytaikhoancanhan.giaodich
CREATE TABLE IF NOT EXISTS `giaodich` (
  `magiaodich` varchar(20) NOT NULL,
  `thoigian` datetime DEFAULT NULL,
  `lydo` varchar(50) DEFAULT NULL,
  `muctieuchi` varchar(50) DEFAULT NULL,
  `madanhmuc` varchar(20) DEFAULT NULL,
  `khoangchi` double DEFAULT NULL,
  `mota` varchar(50) DEFAULT NULL,
  `phuongthucgiaodich` varchar(50) DEFAULT NULL,
  `nguoinhan` varchar(50) DEFAULT NULL,
  `nguoigui` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`magiaodich`),
  KEY `FK_giaodich_danhmucchi` (`madanhmuc`),
  CONSTRAINT `FK_giaodich_danhmucchi` FOREIGN KEY (`madanhmuc`) REFERENCES `danhmucchi` (`madanhmucchi`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table quanlytaikhoancanhan.giaodich: ~11 rows (approximately)
INSERT INTO `giaodich` (`magiaodich`, `thoigian`, `lydo`, `muctieuchi`, `madanhmuc`, `khoangchi`, `mota`, `phuongthucgiaodich`, `nguoinhan`, `nguoigui`) VALUES
	('gd1', '2022-12-08 15:35:17', 'di an', 'di an', 'dm1', 23, 'di an', 'Transfer', 'jhuy@', NULL),
	('gd10589', '2023-01-26 14:11:45', '', '', 'dm0', 100, '', 'Transfer', 'huyphanuyg12@gmail.com', 'huyphanuyg@gmail.com'),
	('gd11139', '2023-01-26 14:36:32', '', '', 'dm0', 50, '', 'Transfer', 'huyphanuyg12@gmail.com', 'huyphanuyg@gmail.com'),
	('gd2', '2022-12-08 15:35:51', 'mua sam', 'mua do', 'dm2', 12, 'mua do', 'Transfer', NULL, 'jhuy@'),
	('gd3', '2023-01-26 10:19:00', NULL, NULL, 'dm3', 1212, NULL, NULL, NULL, 'jhuy@'),
	('gd442', '2023-01-26 10:26:58', NULL, NULL, NULL, 123, NULL, 'Transfer', 'jhuy@', NULL),
	('gd5111', '2024-01-26 10:29:19', '', '', 'dm1', 90, '', 'Transfer', 'thinh@', 'jhuy@'),
	('gd6613', '2023-02-26 10:30:01', '', '', 'dm1', 5, '', 'Transfer', 'thinh@', 'jhuy@'),
	('gd7403', '2023-01-26 13:46:45', NULL, NULL, NULL, 100, NULL, 'Transfer', 'huyphanuyg12@gmail.com', NULL),
	('gd8591', '2023-01-26 13:49:49', NULL, NULL, NULL, 100, NULL, 'Transfer', 'huyphanuyg12@gmail.com', NULL),
	('gd9233', '2023-01-26 13:50:34', NULL, NULL, NULL, 100, NULL, 'Transfer', 'huyphanuyg12@gmail.com', NULL);

-- Dumping structure for table quanlytaikhoancanhan.nguoidung
CREATE TABLE IF NOT EXISTS `nguoidung` (
  `email` varchar(30) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(30) DEFAULT NULL,
  `Sodu` double DEFAULT NULL,
  `gioihan` double DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table quanlytaikhoancanhan.nguoidung: ~5 rows (approximately)
INSERT INTO `nguoidung` (`email`, `user_name`, `PASSWORD`, `Sodu`, `gioihan`) VALUES
	('huyphanuyg12@gmail.com', 'asdf', '!Qwerty12', 150, 0),
	('huyphanuyg@gmail.com', 'jajajajau', '!Qwerty12', 50, 200),
	('jhuy@', 'huy', '123', 5, 0),
	('sdfasdf@gmail.com', 'asdfasdfasdf', '!Qwerty12', 0, 0),
	('thinh@', 'thinh', '456', 5, 0);

-- Dumping structure for table quanlytaikhoancanhan.quanlydanhmuc
CREATE TABLE IF NOT EXISTS `quanlydanhmuc` (
  `madanhmuc` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  KEY `FK__danhmucchi` (`madanhmuc`),
  KEY `FK__nguoidung` (`email`),
  CONSTRAINT `FK__danhmucchi` FOREIGN KEY (`madanhmuc`) REFERENCES `danhmucchi` (`madanhmucchi`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK__nguoidung` FOREIGN KEY (`email`) REFERENCES `nguoidung` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table quanlytaikhoancanhan.quanlydanhmuc: ~5 rows (approximately)
INSERT INTO `quanlydanhmuc` (`madanhmuc`, `email`) VALUES
	('dm1', 'jhuy@'),
	('dm2', 'jhuy@'),
	('dm3', 'jhuy@'),
	('dm0', 'sdfasdf@gmail.com'),
	('dm0', 'huyphanuyg@gmail.com');

-- Dumping structure for table quanlytaikhoancanhan.quanlygiaodich
CREATE TABLE IF NOT EXISTS `quanlygiaodich` (
  `magiaodich` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  KEY `FK_quanlygiaodich_giaodich` (`magiaodich`),
  KEY `FK_quanlygiaodich_nguoidung` (`email`),
  CONSTRAINT `FK_quanlygiaodich_giaodich` FOREIGN KEY (`magiaodich`) REFERENCES `giaodich` (`magiaodich`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_quanlygiaodich_nguoidung` FOREIGN KEY (`email`) REFERENCES `nguoidung` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table quanlytaikhoancanhan.quanlygiaodich: ~15 rows (approximately)
INSERT INTO `quanlygiaodich` (`magiaodich`, `email`) VALUES
	('gd1', 'jhuy@'),
	('gd2', 'thinh@'),
	('gd2', 'jhuy@'),
	('gd3', 'jhuy@'),
	('gd442', 'jhuy@'),
	('gd5111', 'jhuy@'),
	('gd6613', 'jhuy@'),
	('gd6613', 'huyphanuyg12@gmail.com'),
	('gd7403', 'huyphanuyg12@gmail.com'),
	('gd8591', 'huyphanuyg12@gmail.com'),
	('gd8591', 'huyphanuyg@gmail.com'),
	('gd9233', 'huyphanuyg12@gmail.com'),
	('gd10589', 'huyphanuyg12@gmail.com'),
	('gd10589', 'huyphanuyg@gmail.com'),
	('gd11139', 'huyphanuyg@gmail.com');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
quanlytaikhoancanhan