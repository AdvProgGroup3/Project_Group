-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 02 Mei 2015 pada 06.32
-- Versi Server: 5.6.16
-- PHP Version: 5.5.11

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
-- Struktur dari tabel `booking`
--

CREATE TABLE IF NOT EXISTS `booking` (
  `area_id` varchar(3) NOT NULL,
  `u_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `membership`
--

CREATE TABLE IF NOT EXISTS `membership` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `npm` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `membership`
--

INSERT INTO `membership` (`id`, `username`, `password`, `npm`) VALUES
(5, 'william', 'xxxx', 1234567890),
(6, 'Izhar_Almizan', 'coba', 1234567890),
(15, 'agung', '123', 1234567890);

-- --------------------------------------------------------

--
-- Struktur dari tabel `parking_lot`
--

CREATE TABLE IF NOT EXISTS `parking_lot` (
  `area_id` varchar(3) NOT NULL,
  `user_id` int(11) NOT NULL,
  `check_in_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `check_out_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`area_id`,`user_id`,`check_in_time`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `parking_lot`
--

INSERT INTO `parking_lot` (`area_id`, `user_id`, `check_in_time`, `check_out_time`) VALUES
('a01', 0, '2015-04-23 15:55:32', '2015-04-23 15:55:32'),
('a01', 0, '2015-04-30 09:08:16', '2015-04-24 16:59:59'),
('a04', 90, '2015-04-30 09:07:52', '2015-04-25 01:13:23'),
('a11', 88, '2015-04-24 05:50:25', '2015-04-24 05:50:26');

-- --------------------------------------------------------

--
-- Struktur dari tabel `parking_space`
--

CREATE TABLE IF NOT EXISTS `parking_space` (
  `area_id` varchar(3) NOT NULL,
  `availability` int(1) NOT NULL,
  `location` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `parking_space`
--

INSERT INTO `parking_space` (`area_id`, `availability`, `location`) VALUES
('A1', 0, 'gedung A'),
('A2', 0, 'gedung A'),
('A3', 0, 'gedung A'),
('A4', 0, 'gedung A'),
('A5', 0, 'gedung A'),
('A6', 0, 'gedung A'),
('A7', 0, 'gedung A'),
('A8', 0, 'gedung A'),
('A9', 0, 'gedung A'),
('A11', 0, 'gedung A'),
('A12', 0, 'gedung A'),
('A10', 0, 'gedung A');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
