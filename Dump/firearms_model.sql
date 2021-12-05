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
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `model` (
  `Gunmodel` varchar(20) NOT NULL,
  `details` varchar(100) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `availability` int DEFAULT NULL,
  PRIMARY KEY (`Gunmodel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` VALUES ('Akm','ASSAULT RIFLES ( 7.62mm )',17000,6),('AWM','SNIPER RIFLES ( 300 Magnum )',50000,10),('Beryl M762','ASSAULT RIFLES ( 7.62mm )',14000,8),('CrossBow','BOWS ( Bolts )',750,0),('DBS','SHOTGUN ( 12 gauge )',5000,0),('Desert Eagle','PISTOL ( .45acp )',2000,3),('Dp-28','LMG ( 7.62mm )',25000,4),('Grenade','THROWABLE',1750,3),('Groza','ASSAULT RIFLES ( 7.62mm )',22000,9),('K98','SNIPER RIFLES ( 7.62mm )',22000,4),('M16A4','ASSAULT RIFLES ( 5.56mm )',16000,4),('M24','SNIPER RIFLES ( 7.62mm )',35000,7),('M249','LMG ( 5.56mm )',30000,5),('M416','ASSAULT RIFLES ( 5.56mm )',20000,15),('Mg3','LMG ( 7.62mm )',20000,5),('Mini 14','DMR ( 5.56mm )',15000,2),('Mk14','DMR ( 7.62mm )',13000,6),('Molotov Cocktail','THROWABLES',2500,3),('P18C','PISTOL ( 9mm )',1500,1),('P1911','PISTOL ( .45acp )',1000,3),('P92','PISTOL ( 9mm )',1000,5),('R1895','PISTOL ( 7.62mm )',1500,0),('R45','PISTOL ( .45acp )',1000,1),('S12K','SHOTGUN ( 12 gauge )',2500,1),('S1897','SHOTGUN ( 12 gauge )',2250,2),('S686','SHOTGUN ( 12 gauge )',2500,1),('Sawed-off','SHOTGUN ( 12 gauge )',1200,2),('ScarL','ASSAULT RIFLES ( 5.56mm )',18550,1),('Skorpion','PISTOL ( 9mm )',2000,4),('Sks','DMR ( 7.62mm )',11000,0),('Tommy Gun','SUBMACHINE GUN ( .45acp )',9000,4),('Ump 45','SUBMACHINE GUN ( .45acp )',9000,4),('Uzi','SUBMACHINE GUN ( 9mm )',6000,2),('Vector','SUBMACHINE GUN ( 9mm )',8000,3),('VSS','DMR ( 9mm )',5500,0);
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-05 23:10:08
