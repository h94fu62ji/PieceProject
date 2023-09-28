CREATE DATABASE  IF NOT EXISTS `demo_test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `demo_test`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: demo_test
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
-- Table structure for table `atm`
--

DROP TABLE IF EXISTS `atm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atm` (
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `amount` int DEFAULT '0',
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atm`
--

LOCK TABLES `atm` WRITE;
/*!40000 ALTER TABLE `atm` DISABLE KEYS */;
INSERT INTO `atm` VALUES ('a','$0000000',0),('b','00~00000',800),('d','$0000000',10000),('e','0_000000',900);
/*!40000 ALTER TABLE `atm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank`
--

DROP TABLE IF EXISTS `bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank` (
  `id` varchar(20) NOT NULL,
  `bank_name` varchar(20) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `pwd` varchar(45) DEFAULT NULL,
  `user_money` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank`
--

LOCK TABLES `bank` WRITE;
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
INSERT INTO `bank` VALUES ('A01','台新銀行','蔡孟賢','hello',1000),('A02','永豐銀行','蔡孟錤','2796',0),('A03','中信銀行','林則叡','hey',0),('A04','小狗銀行','小狗','doge',100);
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` varchar(20) NOT NULL,
  `course_name` varchar(20) DEFAULT NULL,
  `credit` int DEFAULT NULL,
  `is_required` tinyint DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('A001','Java',4,1),('A002','Python',3,0),('A003','Vue',2,1),('A004','J a v a',4,1),('A005','C#',4,0),('A006','進階Java',4,1),('A007','Java2',2,0),('A008','Java3',2,0),('A009','超級Ja va',4,0);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food` (
  `id` int NOT NULL AUTO_INCREMENT,
  `restaurant` varchar(20) DEFAULT NULL,
  `food` varchar(20) DEFAULT NULL,
  `money` int DEFAULT '0',
  `star` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `name` varchar(20) NOT NULL,
  `cooking_style` varchar(20) NOT NULL,
  `price` int DEFAULT '0',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES ('小火鍋','煮',150),('小籠包','蒸',70),('水餃','煮',60),('滷味','滷',100),('牛肉麵','煮',120),('義大利麵','煮',130),('蛋炒飯','炒',70),('鍋燒意麵','煮',60),('鴨肉便當','炒',90);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(20) DEFAULT NULL,
  `quantity` int DEFAULT '0',
  `uuid` varchar(36) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'滑鼠',800,NULL,NULL),(2,'鍵盤',250,NULL,NULL),(3,'螢幕',120,NULL,NULL),(4,'滑鼠',360,NULL,NULL),(5,'印表機',90,NULL,NULL),(6,'鍵盤',180,NULL,NULL),(7,'鍵盤',500,NULL,NULL),(8,'印表機',60,NULL,NULL),(9,'螢幕',60,NULL,NULL),(31,'無線滑鼠',500,'4ec36a03-ccc7-424b-83cd-fc0e42f72acc','2023-08-29 16:54:02'),(32,'無線滑鼠',500,'695bcd0b-da9e-4dd4-baef-1c4c09b9dddc','2023-08-29 16:55:16'),(33,'無線滑鼠',500,'4d084332-87b7-4f89-b140-358ab743883b','2023-08-29 17:14:17');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_info`
--

DROP TABLE IF EXISTS `person_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_info` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `age` int DEFAULT '0',
  `city` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_info`
--

LOCK TABLES `person_info` WRITE;
/*!40000 ALTER TABLE `person_info` DISABLE KEYS */;
INSERT INTO `person_info` VALUES ('a','Tom',30,'加拿大'),('b','Wong',23,'台灣'),('c','Fubuki',19,'日本'),('d','Hana',23,'日本'),('e','Jojo',20,'日本'),('f','Tanjuro',13,'日本'),('g','Tony',20,'美國'),('h','Giogio',17,'義大利'),('i','Lily',27,'美國'),('j','Dio',100,'印度'),('k','Roy',11,'台灣'),('l','Jolin',17,'日本'),('m','Jhon',20,'美國'),('n','Funs',30,'美國'),('o','Dog',30,'美國'),('p','Cat',30,'美國'),('q','Apple',30,'美國'),('r','Dora',30,'美國'),('w','UwU',10,'美國'),('x','Peko',10,'日本'),('y','Nasi',0,'日本'),('z','Haiya',36,'美國');
/*!40000 ALTER TABLE `person_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_id` varchar(20) NOT NULL,
  `student_name` varchar(20) DEFAULT NULL,
  `course_id` varchar(20) NOT NULL,
  `score` int DEFAULT '0',
  PRIMARY KEY (`student_id`,`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('001','李碩安','A001',74),('001','李碩安','A002',93),('002','李安','A002',100),('002','李安','A003',82),('002','李安','A005',94),('003','張三','A001',88),('003','張三','A002',75),('004','李四','A001',90),('004','李四','A003',80),('004','李四','A005',76);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-28 12:12:00
