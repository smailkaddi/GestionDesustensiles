-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 21, 2020 at 04:31 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbname`
--

-- --------------------------------------------------------

--
-- Table structure for table `assiettecarree`
--

CREATE TABLE `assiettecarree` (
  `id` int(11) NOT NULL,
  `cote` float NOT NULL,
  `anne_de_fabrication` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `assiettecarree`
--

INSERT INTO `assiettecarree` (`id`, `cote`, `anne_de_fabrication`) VALUES
(1, 1, 2010),
(2, 70, 1860);

-- --------------------------------------------------------

--
-- Table structure for table `assietteronde`
--

CREATE TABLE `assietteronde` (
  `id` int(11) NOT NULL,
  `rayon` float NOT NULL,
  `anne_de_fabrication` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `assietteronde`
--

INSERT INTO `assietteronde` (`id`, `rayon`, `anne_de_fabrication`) VALUES
(1, 6, 2000),
(2, 2, 1678),
(3, 8, 1890),
(4, 8, 1800),
(5, 26, 1995);

-- --------------------------------------------------------

--
-- Table structure for table `cuillere`
--

CREATE TABLE `cuillere` (
  `id` int(11) NOT NULL,
  `longeur` float NOT NULL,
  `anne_de_fabrication` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cuillere`
--

INSERT INTO `cuillere` (`id`, `longeur`, `anne_de_fabrication`) VALUES
(1, 45, 1899),
(2, 40, 1999),
(5, 20, 1740),
(6, 20, 1860),
(7, 12, 1995);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assiettecarree`
--
ALTER TABLE `assiettecarree`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `assietteronde`
--
ALTER TABLE `assietteronde`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cuillere`
--
ALTER TABLE `cuillere`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assiettecarree`
--
ALTER TABLE `assiettecarree`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `assietteronde`
--
ALTER TABLE `assietteronde`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `cuillere`
--
ALTER TABLE `cuillere`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
