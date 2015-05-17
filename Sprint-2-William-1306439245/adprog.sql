-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2015 at 01:04 PM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `adprog`
--
CREATE DATABASE IF NOT EXISTS `adprog` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `adprog`;

-- --------------------------------------------------------

--
-- Table structure for table `membership`
--

CREATE TABLE IF NOT EXISTS `membership` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `npm` int(10) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `membership`
--

INSERT INTO `membership` (`id`, `username`, `password`, `npm`) VALUES
(5, 'william', 'xxxx', 1234567890),
(6, 'Izhar_Almizan', 'coba', 1234567890),
(15, 'agung', '123', 1234567890);

-- --------------------------------------------------------

--
-- Table structure for table `parking_lot`
--

CREATE TABLE IF NOT EXISTS `parking_lot` (
  `area_id` varchar(3) NOT NULL,
  `user_id` int(11) NOT NULL,
  `check_in_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `check_out_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `parking_lot`
--

INSERT INTO `parking_lot` (`area_id`, `user_id`, `check_in_time`, `check_out_time`) VALUES
('a01', 0, '2015-05-15 12:07:39', '2015-05-15 12:07:40'),
('a01', 0, '2015-05-15 12:07:43', '2015-05-15 12:07:44'),
('a01', 0, '2015-05-15 12:10:21', '2015-05-15 12:10:22'),
('a01', 0, '2015-05-15 12:13:54', '2015-05-15 12:13:55'),
('a01', 0, '2015-05-15 12:23:59', '2015-05-15 12:23:59'),
('a01', 0, '2015-05-16 08:13:15', '2015-05-16 08:13:15'),
('a01', 0, '2015-05-16 16:22:28', '2015-05-16 16:22:29'),
('a01', 0, '2015-05-16 16:33:51', '2015-05-16 16:33:51'),
('a01', 0, '2015-05-16 16:48:43', '2015-05-16 16:48:43'),
('a01', 0, '2015-05-16 17:02:08', '2015-05-16 17:02:08'),
('a01', 0, '2015-05-16 17:05:31', '2015-05-16 17:05:31'),
('a01', 0, '2015-05-17 10:07:40', '2015-05-17 10:07:41'),
('a01', 0, '2015-05-17 10:29:57', '2015-05-17 10:29:58'),
('a01', 0, '2015-05-17 10:30:17', '2015-05-17 10:30:17'),
('a01', 0, '2015-05-17 10:32:02', '2015-05-17 10:32:03'),
('a01', 0, '2015-05-17 11:01:49', '2015-05-17 11:01:50'),
('a02', 0, '2015-05-14 16:14:24', '2015-05-14 16:14:25'),
('a02', 0, '2015-05-15 12:07:54', '2015-05-15 12:07:54'),
('a02', 0, '2015-05-15 12:24:05', '2015-05-15 12:24:05'),
('a02', 0, '2015-05-16 08:13:00', '2015-05-16 08:13:00'),
('a02', 0, '2015-05-16 17:05:19', '2015-05-16 17:05:20'),
('a02', 0, '2015-05-17 06:46:31', '2015-05-17 06:46:32'),
('a02', 0, '2015-05-17 07:16:35', '2015-05-17 07:16:35'),
('a02', 0, '2015-05-17 07:18:26', '2015-05-17 07:18:27'),
('a02', 0, '2015-05-17 07:21:27', '2015-05-17 07:21:28'),
('a02', 0, '2015-05-17 07:21:49', '2015-05-17 07:21:50'),
('a02', 0, '2015-05-17 07:23:54', '2015-05-17 07:23:55'),
('a02', 57, '2015-05-01 06:42:04', '2015-05-01 06:42:04'),
('a03', 67, '2015-05-01 06:46:04', '2015-05-01 06:46:05'),
('a04', 0, '2015-05-15 12:08:25', '2015-05-15 12:08:26'),
('a08', 91, '2015-05-01 06:48:56', '2015-05-01 06:48:57'),
('a08', 91, '2015-05-01 06:49:32', '2015-05-01 06:49:33'),
('a08', 91, '2015-05-01 06:49:50', '2015-05-01 06:49:51'),
('a11', 80, '2015-04-30 14:47:21', '2015-04-30 14:47:22'),
('a12', 0, '2015-05-14 10:04:28', '2015-05-14 10:04:28'),
('a12', 0, '2015-05-14 11:21:45', '2015-05-14 11:21:45');

-- --------------------------------------------------------

--
-- Table structure for table `parking_space`
--

CREATE TABLE IF NOT EXISTS `parking_space` (
  `area_id` varchar(3) NOT NULL,
  `availability` int(2) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `parking_space`
--

INSERT INTO `parking_space` (`area_id`, `availability`) VALUES
('a01', 0),
('a02', 0),
('a03', 0),
('a04', 0),
('a05', 0),
('a06', 0),
('a07', 0),
('a08', 0),
('a09', 0),
('a10', 0),
('a11', 0),
('a12', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `membership`
--
ALTER TABLE `membership`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `parking_lot`
--
ALTER TABLE `parking_lot`
  ADD PRIMARY KEY (`area_id`,`user_id`,`check_in_time`);

--
-- Indexes for table `parking_space`
--
ALTER TABLE `parking_space`
  ADD PRIMARY KEY (`area_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `membership`
--
ALTER TABLE `membership`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `parking_lot`
--
ALTER TABLE `parking_lot`
ADD CONSTRAINT `parking_lot_ibfk_1` FOREIGN KEY (`area_id`) REFERENCES `parking_space` (`area_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
