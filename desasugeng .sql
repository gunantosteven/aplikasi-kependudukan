-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 29, 2015 at 02:17 
-- Server version: 5.5.36
-- PHP Version: 5.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `desasugeng`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_penduduk`
--

CREATE TABLE IF NOT EXISTS `data_penduduk` (
  `nik` varchar(20) NOT NULL,
  `namaLengkap` varchar(100) NOT NULL,
  `jenisKelamin` varchar(20) NOT NULL,
  `statusKawin` varchar(20) NOT NULL,
  `tempatLahir` varchar(100) NOT NULL,
  `tanggalLahir` date NOT NULL,
  `agama` varchar(50) NOT NULL,
  `pendidikanTerakhir` varchar(100) NOT NULL,
  `pekerjaan` varchar(100) NOT NULL,
  `kewarganegaraan` varchar(10) NOT NULL,
  `alamatLengkap` varchar(100) NOT NULL,
  `kedudukanDalamKeluarga` varchar(100) NOT NULL,
  `kk` varchar(30) NOT NULL,
  `keterangan` varchar(200) NOT NULL,
  `status` varchar(25) NOT NULL,
  PRIMARY KEY (`nik`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_penduduk`
--

INSERT INTO `data_penduduk` (`nik`, `namaLengkap`, `jenisKelamin`, `statusKawin`, `tempatLahir`, `tanggalLahir`, `agama`, `pendidikanTerakhir`, `pekerjaan`, `kewarganegaraan`, `alamatLengkap`, `kedudukanDalamKeluarga`, `kk`, `keterangan`, `status`) VALUES
('12312312', 'steven', 'WANITA', 'KAWIN', 'asfasf', '1930-01-29', 'asfasf', 'asfasfas', 'ABRI', 'asfasf', 'asfasf', 'BAPAK', 'asdf', 'asfasf', 'Hidup'),
('asd', 'asd', 'PRIA', 'KAWIN', 'asd', '2015-01-01', 'asd', 'asd', 'ABRI', 'asd', 'asd', 'IBU', 'asdf', 'asd', 'Hidup'),
('zxc', 'zxc', 'WANITA', 'KAWIN', 'zxc', '1994-01-28', 'zxc', 'zxc', 'LAIN-LAIN', 'zxc', 'zxc', 'ANAK', 'zxc', 'zxc', 'Mati');

-- --------------------------------------------------------

--
-- Table structure for table `mutasi`
--

CREATE TABLE IF NOT EXISTS `mutasi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nik` varchar(20) NOT NULL,
  `tempat` varchar(100) NOT NULL,
  `tanggal` date NOT NULL,
  `keterangan` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nik` (`nik`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=69 ;

--
-- Dumping data for table `mutasi`
--

INSERT INTO `mutasi` (`id`, `nik`, `tempat`, `tanggal`, `keterangan`) VALUES
(51, 'zxc', 'zxvzxvzxv', '1970-01-01', 'LAHIR'),
(52, 'zxc', 'zxvzxvzxv', '1970-01-01', 'LAHIR'),
(53, 'zxc', 'zxvzxvzxv', '1970-01-01', 'LAHIR'),
(54, 'zxc', 'zxvzxvzxv', '1970-01-01', 'LAHIR'),
(55, 'zxc', 'zxvzxvzxv', '1970-01-01', 'LAHIR'),
(57, 'zxc', 'zxvzxvzxv', '1970-01-01', 'LAHIR'),
(58, 'zxc', 'zxvzxvzxv', '1970-01-01', 'LAHIR'),
(59, 'zxc', 'zxvzxvzxv', '1970-01-01', 'LAHIR'),
(60, 'zxc', 'zxvzxvzxv', '1970-01-01', 'LAHIR'),
(61, 'zxc', 'zxvzxvzxv', '1970-01-01', 'LAHIR'),
(62, 'zxc', 'zxvzxvzxv', '1970-01-01', 'LAHIR'),
(63, 'zxc', 'zxvzxvzxv', '1970-01-01', 'LAHIR'),
(64, 'zxc', 'zxvzxvzxv', '1970-01-01', 'LAHIR'),
(65, 'zxc', 'zxvzxvzxv', '1970-01-01', 'LAHIR'),
(66, 'zxc', 'zxvzxvzxv', '1970-01-01', 'LAHIR'),
(67, 'zxc', 'zxvzxvzxv', '1970-01-01', 'LAHIR'),
(68, 'zxc', 'zxvzxvzxv', '1970-01-01', 'LAHIR');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mutasi`
--
ALTER TABLE `mutasi`
  ADD CONSTRAINT `mutasi_ibfk_1` FOREIGN KEY (`nik`) REFERENCES `data_penduduk` (`nik`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
