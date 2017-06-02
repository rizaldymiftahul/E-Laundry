-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 02, 2017 at 09:04 
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `laundry`
--

-- --------------------------------------------------------

--
-- Table structure for table `simpan`
--

CREATE TABLE IF NOT EXISTS `simpan` (
  `id_simpan` int(4) NOT NULL AUTO_INCREMENT,
  `tgl_ambil` date NOT NULL,
  `tgl_antar` date NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `catatan` varchar(200) NOT NULL,
  PRIMARY KEY (`id_simpan`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=30 ;

--
-- Dumping data for table `simpan`
--

INSERT INTO `simpan` (`id_simpan`, `tgl_ambil`, `tgl_antar`, `alamat`, `catatan`) VALUES
(29, '0000-00-00', '0000-00-00', 'djsjsj', 'xjsjsj'),
(28, '2017-05-31', '2017-06-01', 'jember', 'bersih'),
(27, '2017-05-31', '2017-06-01', 'jember', 'bersih');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `alamat` varchar(100) NOT NULL,
  `telp` int(15) NOT NULL,
  `repassword` varchar(50) NOT NULL,
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`alamat`, `telp`, `repassword`, `id`, `username`, `email`, `password`) VALUES
('', 0, '', 1, 'bobi', 'bobi@gmail.com', '1234'),
('', 0, '', 2, 'a', 'a@gmail.com', 'a'),
('', 0, '', 4, 'rama', 'rama@gmail.com', '1234');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
