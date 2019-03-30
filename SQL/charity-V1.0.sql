-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 30, 2019 at 08:34 AM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `charity`
--
CREATE DATABASE IF NOT EXISTS `charity` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `charity`;

-- --------------------------------------------------------

--
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
CREATE TABLE IF NOT EXISTS `animal` (
                                      `idamin` int(11) NOT NULL AUTO_INCREMENT,
                                      `nom` varchar(255) NOT NULL,
                                      `etat` varchar(2500) NOT NULL,
                                      `declaree` tinyint(1) NOT NULL,
                                      `montant` double NOT NULL,
                                      `iduser` int(11) NOT NULL,
                                      `photo` varchar(255) NOT NULL,
                                      `video` varchar(255) NOT NULL,
                                      `date_creation` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                      `idcat` int(11) NOT NULL,
                                      PRIMARY KEY (`idamin`),
                                      KEY `iduser` (`iduser`),
                                      KEY `idcat` (`idcat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
                                         `idcat` int(11) NOT NULL AUTO_INCREMENT,
                                         `idsoucat` int(11) DEFAULT NULL,
                                         `nomcat` varchar(255) NOT NULL,
                                         `description` varchar(2500) NOT NULL,
                                         PRIMARY KEY (`idcat`),
                                         KEY `idsoucat` (`idsoucat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `contribution`
--

DROP TABLE IF EXISTS `contribution`;
CREATE TABLE IF NOT EXISTS `contribution` (
                                            `idcon` int(11) NOT NULL AUTO_INCREMENT,
                                            `iduser` int(11) NOT NULL,
                                            `idpost` int(11) NOT NULL,
                                            `description` varchar(2500) NOT NULL,
                                            `montant` double NOT NULL,
                                            `date_con` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                            `type` int(11) NOT NULL,
                                            PRIMARY KEY (`idcon`),
                                            KEY `description` (`description`(767)),
                                            KEY `iduser` (`iduser`),
                                            KEY `idpost` (`idpost`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
CREATE TABLE IF NOT EXISTS `event` (
                                     `idevent` int(11) NOT NULL AUTO_INCREMENT,
                                     `iduser` int(11) NOT NULL,
                                     `idcat` int(11) NOT NULL,
                                     `photo` varchar(255) NOT NULL,
                                     `date_event` datetime NOT NULL,
                                     `description` varchar(2500) NOT NULL,
                                     `lat` double NOT NULL,
                                     `lon` double NOT NULL,
                                     `lieu` varchar(255) NOT NULL,
                                     `video` varchar(255) NOT NULL,
                                     `titre` varchar(255) NOT NULL,
                                     PRIMARY KEY (`idevent`),
                                     KEY `iduser` (`iduser`),
                                     KEY `idcat` (`idcat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `membre`
--

DROP TABLE IF EXISTS `membre`;
CREATE TABLE IF NOT EXISTS `membre` (
                                      `id` int(11) NOT NULL AUTO_INCREMENT,
                                      `username` varchar(255) NOT NULL,
                                      `email` varchar(255) NOT NULL,
                                      `password` varchar(255) NOT NULL,
                                      `enable` tinyint(1) NOT NULL,
                                      `nom1` varchar(255) NOT NULL,
                                      `nom2` varchar(255) NOT NULL,
                                      `role` varchar(255) NOT NULL,
                                      `date_creation` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                      `description` varchar(2500) DEFAULT NULL,
                                      `photo` varchar(2500) DEFAULT NULL,
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `membre`
--

INSERT INTO `membre` (`id`, `username`, `email`, `password`, `enable`, `nom1`, `nom2`, `role`, `date_creation`, `description`, `photo`) VALUES
(1, 'dfs', 'dsfa', 'areazd', 0, 'qsdqsd', 'vgaezad', 'sqddqd', '2019-03-28 21:31:09', 'sqcxwcaq', 'azeazevbv');

-- --------------------------------------------------------

--
-- Table structure for table `participer`
--

DROP TABLE IF EXISTS `participer`;
CREATE TABLE IF NOT EXISTS `participer` (
                                          `idevent` int(11) NOT NULL,
                                          `iduser` int(11) NOT NULL,
                                          KEY `idevent` (`idevent`),
                                          KEY `iduser` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE IF NOT EXISTS `payment` (
                                       `idpay` int(11) NOT NULL AUTO_INCREMENT,
                                       `idroom` int(11) NOT NULL,
                                       `idpost` int(11) NOT NULL,
                                       `montant` int(11) NOT NULL,
                                       PRIMARY KEY (`idpay`),
                                       KEY `idpost` (`idpost`),
                                       KEY `idroom` (`idroom`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
CREATE TABLE IF NOT EXISTS `post` (
                                    `idpost` int(11) NOT NULL,
                                    `idcat` int(11) NOT NULL,
                                    `titre` varchar(255) NOT NULL,
                                    `description` varchar(2500) NOT NULL,
                                    `image` varchar(255) NOT NULL,
                                    `video` varchar(255) NOT NULL,
                                    `lieu` varchar(255) NOT NULL,
                                    `jour_val` int(11) NOT NULL,
                                    `iduser` int(11) NOT NULL,
                                    `montant` double NOT NULL,
                                    `date_creation` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                    `enable` tinyint(1) NOT NULL,
                                    PRIMARY KEY (`idpost`),
                                    KEY `idcat` (`idcat`),
                                    KEY `iduser` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
CREATE TABLE IF NOT EXISTS `rating` (
                                      `idevent` int(11) NOT NULL,
                                      `iduser` int(11) NOT NULL,
                                      `value` int(11) NOT NULL,
                                      KEY `idevent` (`idevent`),
                                      KEY `iduser` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
                                           `idrec` int(11) NOT NULL AUTO_INCREMENT,
                                           `iduser` int(11) NOT NULL,
                                           `idobjet` int(11) NOT NULL,
                                           `idtr` int(11) DEFAULT NULL,
                                           `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                           PRIMARY KEY (`idrec`),
                                           KEY `iduser` (`iduser`),
                                           KEY `idpost` (`idobjet`),
                                           KEY `idtr` (`idtr`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1582 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reclamation`
--

INSERT INTO `reclamation` (`idrec`, `iduser`, `idobjet`, `idtr`, `date`) VALUES
(1580, 1, 45644, NULL, '2019-03-30 00:08:45'),
(1581, 1, 15, 5, '2019-03-30 00:25:55');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE IF NOT EXISTS `room` (
                                    `idroom` int(11) NOT NULL AUTO_INCREMENT,
                                    `roomname` varchar(255) NOT NULL,
                                    `montant` double NOT NULL,
                                    `categorie` varchar(255) NOT NULL,
                                    PRIMARY KEY (`idroom`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `typereclamation`
--

DROP TABLE IF EXISTS `typereclamation`;
CREATE TABLE IF NOT EXISTS `typereclamation` (
                                               `idtr` int(11) NOT NULL AUTO_INCREMENT,
                                               `desciption` varchar(250) NOT NULL,
                                               PRIMARY KEY (`idtr`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `typereclamation`
--

INSERT INTO `typereclamation` (`idtr`, `desciption`) VALUES
(1, 'Le don ne respecte pas les conditions générales d\'utilisation.'),
(2, 'Le contenu du don est offensant.'),
(3, 'Les informations transmis dans le don sont fausses.'),
(4, 'Mise de danger des personnes.'),
(5, 'Le don n\'est pas réelles.');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `animal_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `membre` (`id`),
  ADD CONSTRAINT `animal_ibfk_2` FOREIGN KEY (`idcat`) REFERENCES `categorie` (`idcat`);

--
-- Constraints for table `categorie`
--
ALTER TABLE `categorie`
  ADD CONSTRAINT `categorie_ibfk_1` FOREIGN KEY (`idsoucat`) REFERENCES `categorie` (`idcat`);

--
-- Constraints for table `contribution`
--
ALTER TABLE `contribution`
  ADD CONSTRAINT `contribution_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `membre` (`id`),
  ADD CONSTRAINT `contribution_ibfk_2` FOREIGN KEY (`idpost`) REFERENCES `post` (`idpost`);

--
-- Constraints for table `participer`
--
ALTER TABLE `participer`
  ADD CONSTRAINT `participer_ibfk_1` FOREIGN KEY (`idevent`) REFERENCES `event` (`idevent`),
  ADD CONSTRAINT `participer_ibfk_2` FOREIGN KEY (`iduser`) REFERENCES `membre` (`id`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`idroom`) REFERENCES `room` (`idroom`);

--
-- Constraints for table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `post_ibfk_1` FOREIGN KEY (`idcat`) REFERENCES `categorie` (`idcat`),
  ADD CONSTRAINT `post_ibfk_2` FOREIGN KEY (`iduser`) REFERENCES `membre` (`id`);

--
-- Constraints for table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `rating_ibfk_1` FOREIGN KEY (`idevent`) REFERENCES `event` (`idevent`),
  ADD CONSTRAINT `rating_ibfk_2` FOREIGN KEY (`iduser`) REFERENCES `membre` (`id`);

--
-- Constraints for table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `reclamation_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `membre` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
