-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 19, 2017 at 01:55 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bloodbank`
--

-- --------------------------------------------------------

--
-- Table structure for table `bloodstock`
--

CREATE TABLE `bloodstock` (
  `A+` int(11) DEFAULT NULL,
  `A-` int(11) DEFAULT NULL,
  `B+` int(11) DEFAULT NULL,
  `B-` int(11) DEFAULT NULL,
  `AB+` int(11) DEFAULT NULL,
  `AB-` int(11) DEFAULT NULL,
  `O+` int(11) DEFAULT NULL,
  `O-` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bloodstock`
--

INSERT INTO `bloodstock` (`A+`, `A-`, `B+`, `B-`, `AB+`, `AB-`, `O+`, `O-`) VALUES
(3, 3, 4, 1, 1, 1, 2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `bloodstocks`
--

CREATE TABLE `bloodstocks` (
  `bloodType` int(11) NOT NULL,
  `A+` int(11) NOT NULL,
  `A-` int(11) NOT NULL,
  `B+` int(11) NOT NULL,
  `B-` int(11) NOT NULL,
  `AB+` int(11) NOT NULL,
  `AB-` int(11) NOT NULL,
  `O+` int(11) NOT NULL,
  `O-` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `donee`
--

CREATE TABLE `donee` (
  `doneeID` int(11) NOT NULL,
  `fName` varchar(50) NOT NULL,
  `mName` varchar(50) NOT NULL,
  `lName` varchar(50) NOT NULL,
  `age` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `address` longtext NOT NULL,
  `contactNo` varchar(50) NOT NULL,
  `eMail` varchar(50) NOT NULL,
  `bloodType` varchar(50) NOT NULL,
  `receivedDate` date NOT NULL,
  `bloodTypeNeed` varchar(50) NOT NULL,
  `purpose` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `donee`
--

INSERT INTO `donee` (`doneeID`, `fName`, `mName`, `lName`, `age`, `gender`, `address`, `contactNo`, `eMail`, `bloodType`, `receivedDate`, `bloodTypeNeed`, `purpose`) VALUES
(1, 'asd', 'asda', 'asd', 'sad', 'Female', 'asd', 'asd', 'asd', 'A+', '2017-11-08', 'A+', 'adsadasda'),
(2, 'sr', 'wer', 'werwerwer', '123', 'Female', 'asd', 'asdd', 'asd', 'A-', '2017-11-15', 'A-', 'aadsasd'),
(4, 'srasd', 'weraasdasd', 'werweradasdawer', '123', 'Female', 'asd', 'asddasdas', 'asd', 'A-', '2017-11-15', 'A-', 'aadsasd');

-- --------------------------------------------------------

--
-- Table structure for table `donors`
--

CREATE TABLE `donors` (
  `donorsID` int(11) NOT NULL,
  `fName` varchar(50) NOT NULL,
  `mName` varchar(50) NOT NULL,
  `lName` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `address` longtext NOT NULL,
  `contactNo` varchar(50) NOT NULL,
  `eMail` varchar(50) NOT NULL,
  `bloodType` varchar(50) NOT NULL,
  `cycle` int(11) NOT NULL,
  `donateDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `donors`
--

INSERT INTO `donors` (`donorsID`, `fName`, `mName`, `lName`, `age`, `gender`, `address`, `contactNo`, `eMail`, `bloodType`, `cycle`, `donateDate`) VALUES
(4, 'wer', 'wer', 'wer', 12, 'Male', '1', 'dad', 'asd', 'Blood Type', 1, '1111-11-11'),
(5, 'sdf', 'sdf', 'sdf', 1, 'Male', 'dsf', 'dsf', 'fdf', 'Blood Type', 1, '1111-11-11'),
(6, 'qwe', 'qwe', 'qwe', 1, 'Male', 'qwe', 'qwe', 'qwe', 'A-', 1, '1111-11-11'),
(7, 'qweq', 'qwe', 'qwe', 1, 'Male', 'qwe', 'qwe', 'qwe', 'A+', 1, '1111-11-11'),
(8, 'asd', 'asd', 'asd', 1, 'Male', '11', '1', '1', 'A+', 1, '1111-11-11'),
(9, 'qwe1', 'qwe', 'qwe', 1, 'Male', 'sada', 'dsa', 'asd', 'A+', 1, '1111-11-11'),
(10, 'qwer', 'qwe', 'qwe', 1, 'Male', 'qwe', 'qwe', 'wqe', 'A+', 1, '1111-11-11'),
(11, 'sdf', 'dsfsdf', 'sdf', 2, 'Male', 'sdf', 'sdf', 'sdf', 'A+', 1, '1111-11-11'),
(13, 'ewrewrwe', 'werw', 'erwerwe', 1, 'Male', 'er', 'werwe', 'rewrer', 'A-', 1, '1111-11-03'),
(15, 'q', 'dasdasd', 'asdas', 1, 'Male', 'sdas', 'dasdaa', 'dasd', 'A+', 1, '1111-11-11'),
(16, 'wrwer', 'werwe', 'wer', 12, 'Male', 'wer', 'wer', 'wer', 'A+', 1, '1111-11-11'),
(17, 'sdfsd', 'sdf', 'sdf', 2, 'Male', 'sdf', 'sdf', 'sdf', 'A+', 1, '1233-11-20'),
(18, 'sdfs', 'sdf', 'dsfsd', 1, 'Male', '1', '1', '1', 'A+', 1, '1111-11-11'),
(19, 'qweqw', 'eqwe', 'qweqwe', 1, 'Male', 'qweq', 'asd', 'a', 'A+', 1, '1111-11-11'),
(20, 'asd1', 'asd', 'asd', 1, 'Male', 'asd', 'asdasd', 'asd', 'A+', 1, '1111-11-11'),
(21, '1asd1', 'asd', 'asd', 1, 'Male', '11', '11', '11', 'A+', 1, '1111-11-11'),
(22, 'wer', 'ewr', 'ewr', 2, 'Male', 'rwr', 'ewr', 'wer2', 'A+', 1, '1111-11-11'),
(23, 'qwe', 'wqe', 'qwe', 1, 'Male', '1', 'ase', 'ae', 'A+', 1, '1111-11-11'),
(24, 'asdas', 'asdasd', 'asdasd', 1, 'Male', 'wa', 'ad', 'w1asd', 'A+', 1, '1111-11-11'),
(25, 'erwr', 'werw', 'rwerwer', 1, 'Male', 'erw', 'wer', 'wer', 'A-', 1, '1111-11-11'),
(26, 'werwer', 'werwer', 'werwer', 1, 'Male', 'werw', 'wer', 'wer', 'A+', 1, '1111-11-11'),
(27, 'qeqweqweq', 'wqewq', 'ewq', 1, 'Male', 'wqe', 'qwe', 'qwe', 'A-', 1, '1111-11-11'),
(28, 'dasdsa', 'asdasd', 'asdsad', 12, 'Male', 'asdasd', 'asd', 'sad', 'B+', 1, '1111-11-11'),
(29, 'sdfsdf', 'sdf', 'sdfs', 11, 'Male', 'sdf', 'dsf', 'sdf', 'B+', 1, '1111-11-11'),
(30, 'asd', 'sadasd', 'sads', 11, 'Male', 'sad', 'sd', 'asd', 'B+', 1, '1111-11-11'),
(31, 'ewr', 'wer', 'wre', 1, 'Male', 'ds', 'sdf', 'sdf', 'A-', 1, '1111-11-11'),
(32, 'asda', 'asd', 'asd', 1, 'Male', 'aa', 'ds', 'ads', 'O+', 1, '1111-11-11'),
(33, 'dasdsad', 'asdasd', 'asdsad', 1, 'Male', 'asda', 'dfa', 'd', 'O+', 1, '1111-11-11'),
(34, 'asdas', 'asd', 'asd', 12, 'Female', 'asd', 'sad', 'asd', 'A-', 1, '2017-11-23'),
(35, 'aasd', 'asd', 'sd', 13, 'Male', 'asda', 'asda', 'sdasd', 'A+', 1, '2017-11-02'),
(36, 'sda', 'dasdas', 'dasdas', 123, 'Male', '12', '123', 'sad', 'A-', 1, '2017-11-01'),
(37, 'sfasda', 'asdasd', 'asdsad', 23, 'Female', 'sad', 'asd', 'asd', 'B-', 1, '2017-11-02'),
(38, 'sasdasd', 'asda', 'asda', 22, 'Female', 'dsad', 'sa', 'da', 'AB+', 1, '2017-11-02');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int(11) NOT NULL,
  `fName` varchar(50) NOT NULL,
  `mName` varchar(50) NOT NULL,
  `lName` varchar(50) NOT NULL,
  `birthDate` date NOT NULL,
  `gender` varchar(25) NOT NULL,
  `bloodType` varchar(50) NOT NULL,
  `address` longtext NOT NULL,
  `eMail` varchar(50) NOT NULL,
  `contactNo` varchar(50) NOT NULL,
  `userType` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `image` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `fName`, `mName`, `lName`, `birthDate`, `gender`, `bloodType`, `address`, `eMail`, `contactNo`, `userType`, `username`, `password`, `image`) VALUES
(1, 'Miko', 'O.', 'Landayan', '2017-11-02', 'Male', 'A+', 'Mars', 'email@email.com', '0912341231', 'Admin', 'admin', 'admin', ''),
(2, 'Noel', 'John', 'Babon', '2017-11-29', 'Male', 'A+', 'Pluto', 'email@email.com', '0912342343', 'Staff', 'babon', '1234', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
