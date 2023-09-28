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
  `account` varchar(45) DEFAULT NULL,
  `block_id` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `block_list`
--

LOCK TABLES `block_list` WRITE;
/*!40000 ALTER TABLE `block_list` DISABLE KEYS */;
INSERT INTO `block_list` VALUES ('user1','admin'),('user2','admin');
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
  `user_1` varchar(45) DEFAULT NULL,
  `user_2` varchar(45) DEFAULT NULL,
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
INSERT INTO `chat` VALUES (40000000,'user1','user2',50000037,50000119),(40000001,'user1','admin',50000124,50000125);
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
  `sender_id` varchar(45) DEFAULT NULL,
  `text` varchar(1000) DEFAULT NULL,
  `time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`mesg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50000126 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_mesg`
--

LOCK TABLES `chat_mesg` WRITE;
/*!40000 ALTER TABLE `chat_mesg` DISABLE KEYS */;
INSERT INTO `chat_mesg` VALUES (50000000,40000000,'user1','哈囉','2023-09-22 10:03:35'),(50000001,40000000,'user2','幹嘛','2023-09-22 10:03:57'),(50000002,40000000,'user1','吃壽司郎阿','2023-09-22 10:27:14'),(50000037,40000000,'user2','好啊?','2023-09-22 12:01:53'),(50000056,40000000,'user1','40元壽司','2023-09-22 16:33:51'),(50000057,40000000,'user1','\n超級好吃','2023-09-22 16:33:54'),(50000058,40000000,'user1','\n的拉','2023-09-22 16:33:55'),(50000059,40000000,'user1','為啥會這樣','2023-09-22 16:34:00'),(50000060,40000000,'user1','但是我 發消息不會更新左側欄位','2023-09-22 16:52:27'),(50000062,40000000,'user1','?','2023-09-23 22:47:37'),(50000063,40000001,'admin','幹','2023-09-23 23:13:12'),(50000064,40000001,'user1','怎麼了','2023-09-25 11:15:42'),(50000065,40000001,'admin','今天天氣超好','2023-09-25 11:16:08'),(50000073,40000001,'admin','適合待在家裡','2023-09-25 11:16:58'),(50000114,40000000,'user1','好','2023-09-26 10:11:44'),(50000115,40000000,'user1','原來','2023-09-26 10:12:55'),(50000116,40000000,'user1','嗨','2023-09-26 10:34:22'),(50000117,40000001,'user1','?','2023-09-26 10:38:46'),(50000118,40000001,'admin','嗨','2023-09-27 17:57:17'),(50000119,40000000,'user1','嗨','2023-09-28 09:23:13'),(50000120,40000001,'admin','class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"','2023-09-28 10:04:17'),(50000121,40000001,'admin','class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"','2023-09-28 10:04:55'),(50000122,40000001,'admin','\nclass=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"class=\"rounded-2xl w-[430px]\"','2023-09-28 10:04:57'),(50000123,40000001,'admin','\nk','2023-09-28 10:04:59'),(50000124,40000001,'admin','????????','2023-09-28 10:05:52'),(50000125,40000001,'user1','嗨','2023-09-28 10:12:32');
/*!40000 ALTER TABLE `chat_mesg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `like_count`
--

DROP TABLE IF EXISTS `like_count`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `like_count` (
  `id` int NOT NULL AUTO_INCREMENT,
  `post_mesg_id` int DEFAULT '0',
  `user_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `like_count`
--

LOCK TABLES `like_count` WRITE;
/*!40000 ALTER TABLE `like_count` DISABLE KEYS */;
INSERT INTO `like_count` VALUES (1,20000000,'admin'),(2,20000000,'user1'),(3,20000000,'user2');
/*!40000 ALTER TABLE `like_count` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=10000145 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pic`
--

LOCK TABLES `pic` WRITE;
/*!40000 ALTER TABLE `pic` DISABLE KEYS */;
INSERT INTO `pic` VALUES (100,'C:/Users/minic/OneDrive/Desktop/PieceProject/Piece/img/logo.png'),(10000000,'C:\\Users\\minic\\OneDrive\\Desktop\\PieceProject\\Piece\\img\\10000000.png'),(10000050,'C:\\Users\\minic\\OneDrive\\Desktop\\PieceProject\\Piece\\img\\10000000.png'),(10000100,'C:\\Users\\minic\\OneDrive\\Desktop\\PieceProject\\Piece\\img\\10000000.png'),(10000120,'C:/Users/minic/OneDrive/Desktop/PieceProject/Piece/img/10000120.png'),(10000121,'C:/Users/minic/OneDrive/Desktop/PieceProject/Piece/img/10000121.png'),(10000122,'C:/Users/minic/OneDrive/Desktop/PieceProject/Piece/img/10000122.png'),(10000123,'C:/Users/minic/OneDrive/Desktop/PieceProject/Piece/img/10000123.jpeg'),(10000124,'C:/Users/minic/OneDrive/Desktop/PieceProject/Piece/img/10000124.jpeg'),(10000125,'C:/Users/minic/OneDrive/Desktop/PieceProject/Piece/img/10000125.jpeg'),(10000126,'C:/Users/minic/OneDrive/Desktop/PieceProject/Piece/img/10000126.jpeg'),(10000127,'C:/Users/minic/OneDrive/Desktop/PieceProject/Piece/img/10000127.jpeg'),(10000138,'C:/Users/minic/OneDrive/Desktop/PieceProject/Piece/img/10000138.jpeg'),(10000139,'C:/Users/minic/OneDrive/Desktop/PieceProject/Piece/img/10000139.jpeg'),(10000140,'C:/Users/minic/OneDrive/Desktop/PieceProject/Piece/img/10000140.jpeg'),(10000141,'C:/Users/minic/OneDrive/Desktop/PieceProject/Piece/img/10000141.jpeg'),(10000142,'C:/Users/minic/OneDrive/Desktop/PieceProject/Piece/img/10000142.jpeg'),(10000143,'C:/Users/minic/OneDrive/Desktop/PieceProject/Piece/img/10000143.gif'),(10000144,'C:/Users/minic/OneDrive/Desktop/PieceProject/Piece/img/10000144.mp4');
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
  `sender_id` varchar(45) DEFAULT NULL,
  `share_id` varchar(45) DEFAULT NULL,
  `text` varchar(1000) DEFAULT NULL,
  `time` datetime DEFAULT CURRENT_TIMESTAMP,
  `up` int DEFAULT '0',
  `pic_id` int DEFAULT '0',
  `public` tinyint DEFAULT '0',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20000047 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (20000000,'admin','','歡迎成為我們的一塊，假裝用內文假裝用內文假裝用內文假裝用內文假裝用內文假裝用內文假裝用內文，假裝用內文假裝用內文假裝用內文假裝用內文，假裝用內文假裝用內文假裝用內文','2023-09-19 16:00:41',50,10000000,0),(20000001,'user1','','假裝用內文假裝用內文，假裝用內文假裝用內文假裝用內文假裝用內文假裝用內文，假裝用內文假裝用內文假裝用內文假裝用內文，假裝用內文假裝用內文假裝用內文，假裝用內文假裝用內文假裝用內文，假裝用內文假裝用內文假裝用內文','2023-09-19 16:00:41',0,10000121,0),(20000002,'user2','','假裝用內文假裝用內文假裝用內文假裝用內文，假裝用內文假裝用內文，假裝用內文，假裝用內文假裝用內文假裝用內文假裝用內文，假裝用內文假裝用內文','2023-09-19 16:00:41',1,10000100,0),(20000022,'user1','','大家好','2023-09-20 22:01:08',0,10000120,0),(20000023,'user1','','這個好笑','2023-09-20 23:35:22',0,10000121,0),(20000024,'user1','','今天天氣真好','2023-09-21 09:03:06',0,10000122,0),(20000025,'user1','','今天真開心','2023-09-21 14:23:46',0,10000123,0),(20000026,'user1','','哈囉','2023-09-21 15:28:07',0,10000124,0),(20000027,'user1','','好棒喔','2023-09-21 15:28:21',0,10000125,0),(20000028,'user1','','測試','2023-09-21 15:28:37',0,10000126,0),(20000029,'user1','','很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET很多很多的ET 超級超級多ET','2023-09-21 15:28:45',0,10000127,0),(20000042,'admin',NULL,'即將開放','2023-09-27 17:45:54',0,10000140,0),(20000043,'admin',NULL,'嗨','2023-09-27 17:59:52',0,10000141,0),(20000044,'asdfg',NULL,'嗨 大家好','2023-09-28 09:21:04',0,10000142,0),(20000045,'admin',NULL,'嗨','2023-09-28 09:53:28',0,10000143,0),(20000046,'admin',NULL,'嗨','2023-09-28 09:55:12',0,10000144,0);
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
  `sender_id` varchar(45) DEFAULT NULL,
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
INSERT INTO `post_mesg` VALUES (30000000,20000000,'user1','初次見面','2023-09-19 16:00:41',1),(30000001,20000000,'user2','歡迎歡迎','2023-09-19 16:00:41',0),(30000002,20000000,'user1','阿你怎麼也在','2023-09-19 16:00:41',87);
/*!40000 ALTER TABLE `post_mesg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `track_list`
--

DROP TABLE IF EXISTS `track_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `track_list` (
  `account` varchar(45) DEFAULT NULL,
  `track_id` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `track_list`
--

LOCK TABLES `track_list` WRITE;
/*!40000 ALTER TABLE `track_list` DISABLE KEYS */;
INSERT INTO `track_list` VALUES ('admin','user1'),('admin','user2'),('user1','user2'),('user2','user1');
/*!40000 ALTER TABLE `track_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_data`
--

DROP TABLE IF EXISTS `user_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_data` (
  `account` varchar(45) NOT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `introduce` varchar(200) DEFAULT NULL,
  `pic_id` int DEFAULT '10000000',
  `sex` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_data`
--

LOCK TABLES `user_data` WRITE;
/*!40000 ALTER TABLE `user_data` DISABLE KEYS */;
INSERT INTO `user_data` VALUES ('admin','admin','1995-09-19','台北','成為我們的一塊',10000000,'秘密'),('asdf','Hello','1998-08-29','新竹','大家好 我是新來的小朋友',10000000,'男'),('asdfg','嗨','2023-09-28','新竹','初次見面',0,'秘密'),('user1','我是user1','1996-01-01','台中','user1的自介',10000120,'女'),('user2','我是user2','1997-10-10','台南','user2的自介',10000120,'男');
/*!40000 ALTER TABLE `user_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `account` varchar(45) NOT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `account_state` tinyint DEFAULT '1',
  `admin_state` tinyint DEFAULT '0',
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES ('admin','admin','2023-09-19',1,0),('asdf','asdf',NULL,NULL,NULL),('asdfg','asdfg',NULL,NULL,NULL),('user1','1234','2023-09-19',1,0),('user2','1234','2023-09-19',1,0);
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

-- Dump completed on 2023-09-28 13:57:50
