-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 28, 2015 at 10:27 
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
  PRIMARY KEY (`nik`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_penduduk`
--

INSERT INTO `data_penduduk` (`nik`, `namaLengkap`, `jenisKelamin`, `statusKawin`, `tempatLahir`, `tanggalLahir`, `agama`, `pendidikanTerakhir`, `pekerjaan`, `kewarganegaraan`, `alamatLengkap`, `kedudukanDalamKeluarga`, `kk`, `keterangan`) VALUES
('asd', 'asd', 'PRIA', 'KAWIN', 'asd', '1999-01-01', 'asd', 'asd', 'asd', 'asd', 'asd', 'asd', 'asdf', 'asd');

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
