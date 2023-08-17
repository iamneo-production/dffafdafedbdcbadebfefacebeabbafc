-- MariaDB dump 10.19  Distrib 10.6.14-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: appdb
-- ------------------------------------------------------
-- Server version	5.6.51

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `appdb`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `appdb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `appdb`;

--
-- Table structure for table `cricketer`
--

DROP TABLE IF EXISTS `cricketer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cricketer` (
  `name` varchar(30) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `country` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cricketer`
--

LOCK TABLES `cricketer` WRITE;
/*!40000 ALTER TABLE `cricketer` DISABLE KEYS */;
INSERT INTO `cricketer` VALUES ('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India'),('Kane Williamson',35,'New Zealand'),('MS Dhoni',30,'India'),('Steve Smith',31,'Australia'),('Virat Kohli',32,'India');
/*!40000 ALTER TABLE `cricketer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `bidding_price` double NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sold` bit(1) NOT NULL,
  `team_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdvd6ljes11r44igawmpm1mc5s` (`team_id`),
  CONSTRAINT `FKdvd6ljes11r44igawmpm1mc5s` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_details`
--

DROP TABLE IF EXISTS `player_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player_details` (
  `id` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `bidding_price` double NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sold` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_details`
--

LOCK TABLES `player_details` WRITE;
/*!40000 ALTER TABLE `player_details` DISABLE KEYS */;
INSERT INTO `player_details` VALUES (100,23,0,'Admin','demo@gmail.com','admin',''),(1000,24,15000,'Seniorteam','Viratdemo@gmail.com','Demo','');
/*!40000 ALTER TABLE `player_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `maximum_budget` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,457,'browndemo'),(2,457,'browndemo'),(3,457,'browndemo'),(4,457,'browndemo'),(5,457,'browndemo'),(6,457,'browndemo'),(7,457,'browndemo'),(8,457,'browndemo'),(9,457,'browndemo'),(10,457,'browndemo'),(11,457,'browndemo'),(12,457,'browndemo');
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'$2a$10$YYzIIZ0nYc2UyveDnKtryeKFy25Li07rHlnY2tMEzO/cccyPZPvym','Admin','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-17  5:21:48
