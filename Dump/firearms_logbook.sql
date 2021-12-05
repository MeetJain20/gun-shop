-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: firearms
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `logbook`
--

DROP TABLE IF EXISTS `logbook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logbook` (
  `custid` int NOT NULL,
  `Gunmodel` varchar(30) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phoneNo` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logbook`
--

LOCK TABLES `logbook` WRITE;
/*!40000 ALTER TABLE `logbook` DISABLE KEYS */;
INSERT INTO `logbook` VALUES (1,'Skorpion','LookDown Cafe , Las vegas','9837461739'),(2,'Uzi','Pub Club , Tokyo','8163449618'),(3,'DBS','Cross Road , Los Angeles','7582685050'),(4,'Grenade','No entry Club , Mumbai','6868729599'),(5,'S12K','Red Mafia Gang , Ohio','9978762599'),(6,'S686','Cross Road , Los Angeles','9683657892'),(7,'S1897','Pub Club , Tokyo','6826482958'),(5,'Mg3','Disco Bar , Mumbai','8276582365'),(4,'M249','Mirzapur , Uttarpradesh','7785628959'),(3,'Dp-28','Black Mafia Gang , Texas','9725173899'),(2,'M24','Frenzy Road , USA','8875820735'),(1,'AWM','AAF Club , Delhi','6789263752');
/*!40000 ALTER TABLE `logbook` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-05 23:10:07
