-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2023 at 04:12 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_exam`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `id` int(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `username`, `password`, `role`) VALUES
(1, 'admin', 'adminadmin', 'Admin'),
(3, 'student1', 'student123', 'student');

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `exammulti_id` int(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `question` varchar(255) NOT NULL,
  `c1` varchar(255) NOT NULL,
  `c2` varchar(255) NOT NULL,
  `c3` varchar(255) NOT NULL,
  `c4` varchar(255) NOT NULL,
  `c5` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`exammulti_id`, `subject`, `question`, `c1`, `c2`, `c3`, `c4`, `c5`, `answer`) VALUES
(9, 'TEST1', 'TEST1', 'MC1', 'MC2', 'MC3', 'MC4', 'MC5', 'A'),
(10, 'TEST1', 'TEST2', 'MC2', 'MC3', 'MC4', 'MC5', 'MC6', 'C'),
(11, 'TEST3', 'TEST3', 'MC3', 'MC4', 'MC5', 'MC6', 'MC6', 'B'),
(12, 'TEST3', 'TEST4', 'A', 'B', 'C', 'D', 'MC6', 'A'),
(13, 'TEST3', 'TEST5', 'A', 'B', 'C', 'X', 'MC6', 'C'),
(16, 'TEST1', 'TEST6', 'A', 'B', 'C', 'D', 'E', 'A'),
(18, 'TEST1', 'TEST7', 'MC1', 'MC2', 'MC3', 'MC4', 'MC5', 'A'),
(19, 'TEST1', 'TEST8', 'MC2', 'MC3', 'MC4', 'MC5', 'MC6', 'A'),
(20, 'TEST1', 'TEST9', 'MC3', 'MC4', 'MC5', 'MC6', 'MC7', 'A'),
(21, 'TEST1', 'TEST10', 'MC4', 'MC5', 'MC6', 'MC7', 'MC8', 'A'),
(22, 'TEST1', 'TEST11', 'MC5', 'MC6', 'MC7', 'MC8', 'MC9', 'A'),
(23, 'TEST1', 'TEST12', 'MC6', 'MC7', 'MC8', 'MC9', 'MC10', 'A'),
(24, 'TEST1', 'TEST13', 'MC7', 'MC8', 'MC9', 'MC10', 'MC11', 'A'),
(25, 'TEST1', 'TEST14', 'MC8', 'MC9', 'MC10', 'MC11', 'MC12', 'A'),
(26, 'TEST1', 'TEST15', 'MC9', 'MC10', 'MC11', 'MC12', 'MC13', 'A'),
(27, 'TEST1', 'TEST16', 'MC10', 'MC11', 'MC12', 'MC13', 'MC14', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `examcreated`
--

CREATE TABLE `examcreated` (
  `exam_id` int(11) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `grading_period` varchar(255) NOT NULL,
  `yearlevel` varchar(255) NOT NULL,
  `semester` varchar(255) NOT NULL,
  `prof_name` varchar(255) NOT NULL,
  `multiplechoice` int(50) NOT NULL,
  `indentification` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `examcreated`
--

INSERT INTO `examcreated` (`exam_id`, `subject`, `grading_period`, `yearlevel`, `semester`, `prof_name`, `multiplechoice`, `indentification`) VALUES
(1, 'TEST111', 'Midterm', 'Second Year', 'Second Semester', 'TEST PROF', 60, 60),
(2, 'PPCG11', 'Midterm', 'Second Year', 'Second Semester', 'Test prof1', 60, 50),
(3, 'TEST 123', 'Prelim', 'First Year', 'First Semester', 'Zaki', 3, 3),
(4, 'TEST1', 'Prelim', 'First Year', 'First Semester', 'TEST PROF', 5, 5),
(5, 'TEST1', 'Midterm', 'Second Year', 'Second Semester', 'TEST PROF', 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `exam_take`
--

CREATE TABLE `exam_take` (
  `examtake_id` int(11) NOT NULL,
  `student_name` varchar(32) NOT NULL,
  `subject` varchar(32) NOT NULL,
  `grading_per` varchar(32) NOT NULL,
  `score` varchar(32) DEFAULT NULL,
  `yearl` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `exam_take`
--

INSERT INTO `exam_take` (`examtake_id`, `student_name`, `subject`, `grading_per`, `score`, `yearl`) VALUES
(1, 'TEST1', 'Prelim', 'student1', NULL, NULL),
(5, 'TEST 123', 'Prelim', 'student1', NULL, NULL),
(11, 'TEST1', 'Midterm', 'student1', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `identification`
--

CREATE TABLE `identification` (
  `examiden_id` int(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `question` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `identification`
--

INSERT INTO `identification` (`examiden_id`, `subject`, `question`, `answer`) VALUES
(1, 'TEST1', 'QUESTION1', 'ANSWER1'),
(2, 'TEST2', 'QUESTION2', 'ANSWER2'),
(3, 'TEST3', 'QUESTION3', 'ANSWER3'),
(4, 'TEST4', 'QUESTION4', 'ANSWER4'),
(5, 'TEST5', 'QUESTION5', 'ANSWER5'),
(6, 'TEST6', 'QUESTION6', 'ANSWER6'),
(7, 'TEST7', 'QUESTION7', 'ANSWER7'),
(50, 'TEST1', 'QUESTION9', 'ANSWER1'),
(98, 'TEST7', 'QUESTION99', 'ANSWER7'),
(100, 'TEST1', 'QUESTION8', 'ANSWER2'),
(102, 'TEST1', 'QUESTION10', 'ANSWER4'),
(103, 'TEST1', 'QUESTION11', 'ANSWER5'),
(104, 'TEST1', 'QUESTION12', 'ANSWER6'),
(105, 'TEST1', 'QUESTION13', 'ANSWER7');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`exammulti_id`),
  ADD UNIQUE KEY `qs` (`question`);

--
-- Indexes for table `examcreated`
--
ALTER TABLE `examcreated`
  ADD PRIMARY KEY (`exam_id`);

--
-- Indexes for table `exam_take`
--
ALTER TABLE `exam_take`
  ADD PRIMARY KEY (`examtake_id`),
  ADD UNIQUE KEY `student_name` (`student_name`,`subject`,`grading_per`) USING BTREE;

--
-- Indexes for table `identification`
--
ALTER TABLE `identification`
  ADD PRIMARY KEY (`examiden_id`),
  ADD UNIQUE KEY `question` (`question`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `exam`
--
ALTER TABLE `exam`
  MODIFY `exammulti_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `examcreated`
--
ALTER TABLE `examcreated`
  MODIFY `exam_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `exam_take`
--
ALTER TABLE `exam_take`
  MODIFY `examtake_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `identification`
--
ALTER TABLE `identification`
  MODIFY `examiden_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=113;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
