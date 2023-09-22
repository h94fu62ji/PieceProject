CREATE DATABASE  IF NOT EXISTS `piece_data` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `piece_data`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: piece_data
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `block_list`
--

DROP TABLE IF EXISTS `block_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `block_list` (
  `user_id` int DEFAULT '0',
  `block_id` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `block_list`
--

LOCK TABLES `block_list` WRITE;
/*!40000 ALTER TABLE `block_list` DISABLE KEYS */;
INSERT INTO `block_list` VALUES (10000001,10000000),(10000002,10000000);
/*!40000 ALTER TABLE `block_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat` (
  `chat_id` int NOT NULL AUTO_INCREMENT,
  `user_1` int DEFAULT '0',
  `user_2` int DEFAULT '0',
  `user_1_read` int DEFAULT '0',
  `user_2_read` int DEFAULT '0',
  PRIMARY KEY (`chat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50000001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES (40000000,10000001,10000002,50000037,50000002);
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat_mesg`
--

DROP TABLE IF EXISTS `chat_mesg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat_mesg` (
  `mesg_id` int NOT NULL AUTO_INCREMENT,
  `chat_id` int DEFAULT '0',
  `sender_id` int DEFAULT '0',
  `text` varchar(1000) DEFAULT NULL,
  `time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`mesg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50000052 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_mesg`
--

LOCK TABLES `chat_mesg` WRITE;
/*!40000 ALTER TABLE `chat_mesg` DISABLE KEYS */;
INSERT INTO `chat_mesg` VALUES (50000000,40000000,10000001,'哈囉','2023-09-22 10:03:35'),(50000001,40000000,10000002,'幹嘛','2023-09-22 10:03:57'),(50000002,40000000,10000001,'吃壽司郎阿','2023-09-22 10:27:14'),(50000037,40000000,10000002,'好啊?','2023-09-22 12:01:53'),(50000038,40000000,10000001,'測試文字測試文字測試文字測試文字測試文字測試文字測試文字測試文字測試文字','2023-09-22 14:14:34'),(50000042,40000000,10000001,'ㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎㄎ','2023-09-22 14:52:06'),(50000043,40000000,10000001,'嗨\n','2023-09-22 14:52:34'),(50000044,40000000,10000001,'嗨','2023-09-22 14:52:38'),(50000045,40000000,10000001,'\n嗨','2023-09-22 14:52:40'),(50000046,40000000,10000001,'\n嗨','2023-09-22 14:52:42'),(50000047,40000000,10000001,'嗨','2023-09-22 14:52:47'),(50000048,40000000,10000001,'嗨','2023-09-22 14:52:54'),(50000049,40000000,10000001,'嗨','2023-09-22 14:53:02'),(50000050,40000000,10000001,'嗨','2023-09-22 14:53:08'),(50000051,40000000,10000001,'hello','2023-09-22 14:55:01');
/*!40000 ALTER TABLE `chat_mesg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pic`
--

DROP TABLE IF EXISTS `pic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pic` (
  `pic_id` int NOT NULL AUTO_INCREMENT,
  `pic_address` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`pic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000128 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pic`
--

LOCK TABLES `pic` WRITE;
/*!40000 ALTER TABLE `pic` DISABLE KEYS */;
INSERT INTO `pic` VALUES (100,'C:\\Users\\minic\\OneDrive\\Desktop\\JAVA\\javaproject\\Piece\\img\\logo.png'),(10000000,'C:\\Users\\minic\\OneDrive\\Desktop\\JAVA\\javaproject\\Piece\\img\\10000000.png'),(10000050,'C:\\Users\\minic\\OneDrive\\Desktop\\JAVA\\javaproject\\Piece\\img\\10000000.png'),(10000100,'C:\\Users\\minic\\OneDrive\\Desktop\\JAVA\\javaproject\\Piece\\img\\10000000.png'),(10000120,'C:/Users/minic/OneDrive/Desktop/JAVA/javaproject/Piece/img/10000120.png'),(10000121,'C:/Users/minic/OneDrive/Desktop/JAVA/javaproject/Piece/img/10000121.png'),(10000122,'C:/Users/minic/OneDrive/Desktop/JAVA/javaproject/Piece/img/10000122.png'),(10000123,'C:/Users/minic/OneDrive/Desktop/JAVA/javaproject/Piece/img/10000123.jpeg'),(10000124,'C:/Users/minic/OneDrive/Desktop/JAVA/javaproject/Piece/img/10000124.jpeg'),(10000125,'C:/Users/minic/OneDrive/Desktop/JAVA/javaproject/Piece/img/10000125.jpeg'),(10000126,'C:/Users/minic/OneDrive/Desktop/JAVA/javaproject/Piece/img/10000126.jpeg'),(10000127,'C:/Users/minic/OneDrive/Desktop/JAVA/javaproject/Piece/img/10000127.jpeg');
/*!40000 ALTER TABLE `pic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `post_id` int NOT NULL AUTO_INCREMENT,
  `sender_id` int DEFAULT '0',
  `share_id` int DEFAULT '0',
  `text` varchar(1000) DEFAULT NULL,
  `time` datetime DEFAULT CURRENT_TIMESTAMP,
  `up` int DEFAULT '0',
  `pic_id` int DEFAULT '0',
  `public` tinyint DEFAULT '0',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20000030 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (20000000,10000000,0,'歡迎成為我們的一塊，假裝用內文假裝用內文假裝用內文假裝用內文假裝用內文假裝用內文假裝用內文，假裝用內文假裝用內文假裝用內文假裝用內文，假裝用內文假裝用內文假裝用內文','2023-09-19 16:00:41',50,10000000,0),(20000001,10000001,0,'假裝用內文假裝用內文，假裝用內文假裝用內文假裝用內文假裝用內文假裝用內文，假裝用內文假裝用內文假裝用內文假裝用內文，假裝用內文假裝用內文假裝用內文，假裝用內文假裝用內文假裝用內文，假裝用內文假裝用內文假裝用內文','2023-09-19 16:00:41',0,10000121,0),(20000002,10000002,0,'假裝用內文假裝用內文假裝用內文假裝用內文，假裝用內文假裝用內文，假裝用內文，假裝用內文假裝用內文假裝用內文假裝用內文，假裝用內文假裝用內文','2023-09-19 16:00:41',1,10000100,0),(20000022,10000001,0,'大家好','2023-09-20 22:01:08',0,10000120,0),(20000023,10000001,0,'這個好笑','2023-09-20 23:35:22',0,10000121,0),(20000024,10000001,0,'今天天氣真好','2023-09-21 09:03:06',0,10000122,0),(20000025,10000001,0,'今天真開心','2023-09-21 14:23:46',0,10000123,0),(20000026,10000001,0,'哈囉','2023-09-21 15:28:07',0,10000124,0),(20000027,10000001,0,'好棒喔','2023-09-21 15:28:21',0,10000125,0),(20000028,10000001,0,'測試','2023-09-21 15:28:37',0,10000126,0),(20000029,10000001,0,'ET','2023-09-21 15:28:45',0,10000127,0);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_mesg`
--

DROP TABLE IF EXISTS `post_mesg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_mesg` (
  `mesg_id` int NOT NULL AUTO_INCREMENT,
  `post_id` int DEFAULT '0',
  `sender_id` int DEFAULT '0',
  `text` varchar(1000) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `up` int DEFAULT '0',
  PRIMARY KEY (`mesg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30000003 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_mesg`
--

LOCK TABLES `post_mesg` WRITE;
/*!40000 ALTER TABLE `post_mesg` DISABLE KEYS */;
INSERT INTO `post_mesg` VALUES (30000000,20000000,10000001,'初次見面','2023-09-19 16:00:41',1),(30000001,20000000,10000002,'歡迎歡迎','2023-09-19 16:00:41',0),(30000002,20000000,10000001,'阿你怎麼也在','2023-09-19 16:00:41',87);
/*!40000 ALTER TABLE `post_mesg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `track_list`
--

DROP TABLE IF EXISTS `track_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `track_list` (
  `user_id` int DEFAULT '0',
  `track_id` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `track_list`
--

LOCK TABLES `track_list` WRITE;
/*!40000 ALTER TABLE `track_list` DISABLE KEYS */;
INSERT INTO `track_list` VALUES (10000000,10000001),(10000000,10000002),(10000001,10000002),(10000002,10000001);
/*!40000 ALTER TABLE `track_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_data`
--

DROP TABLE IF EXISTS `user_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_data` (
  `user_id` int NOT NULL DEFAULT '0',
  `user_name` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `introduce` varchar(200) DEFAULT NULL,
  `pic_id` int DEFAULT '0',
  `sex` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_data`
--

LOCK TABLES `user_data` WRITE;
/*!40000 ALTER TABLE `user_data` DISABLE KEYS */;
INSERT INTO `user_data` VALUES (10000000,'admin','1995-09-19','台北','成為我們的一塊',10000000,'秘密'),(10000001,'我是user1','1996-01-01','台中','user1的自介',10000050,'女'),(10000002,'我是user2','1997-10-10','台南','user2的自介',10000100,'男');
/*!40000 ALTER TABLE `user_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `account_state` tinyint DEFAULT '1',
  `admin_state` tinyint DEFAULT '0',
  PRIMARY KEY (`user_id`,`account`)
) ENGINE=InnoDB AUTO_INCREMENT=10000003 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (10000000,'admin','admin','2023-09-19 16:00:41',1,0),(10000001,'user1','1234','2023-09-19 16:00:41',1,0),(10000002,'user2','1234','2023-09-19 16:00:41',1,0);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-22 15:14:31
