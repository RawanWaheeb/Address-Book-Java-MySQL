-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 24, 2026 at 04:46 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `addressbook`
--

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL,
  `nick_name` varchar(20) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `home_phone` varchar(10) DEFAULT NULL,
  `work_phone` varchar(10) DEFAULT NULL,
  `cell_phone` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `web_site` varchar(100) DEFAULT NULL,
  `profession` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`id`, `name`, `nick_name`, `address`, `home_phone`, `work_phone`, `cell_phone`, `email`, `birthday`, `web_site`, `profession`) VALUES
(1, 'Mariam Mohamed', 'Mimi', 'Alexandria', '034455', '036677', '012777888', 'mariam.m@email.com', '2002-05-15', 'www.mariam-dev.com', 'Senior Artist'),
(2, 'Ghaidaa El-Sayed', 'Ghaidaa', 'Cairo', '02111', '02222', '010999', 'ghaidaa@mail.com', '2001-08-20', 'www.ghaidaa.com', 'Software Engineer'),
(3, 'Ahmed Ali', 'Hamada', 'Mansoura', '05011', '05022', '010111', 'ahmed@mail.com', '1995-01-01', 'www.ahmed.com', 'Java Developer'),
(4, 'Laila Hassan', 'Lulu', 'Giza', '02333', '02444', '011222', 'laila@mail.com', '1998-05-12', 'www.laila.design', 'UI Designer'),
(6, 'Mostafa Mahmoud', 'Desha', 'Suez', '06211', '06222', '010555', 'mostafa@mail.com', '1988-07-22', 'www.desha.net', 'Teacher'),
(7, 'Nour El-Din', 'Nour', 'Port Said', '06611', '06622', '011666', 'nour@mail.com', '1999-12-30', 'www.nour.com', 'Accountant');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
