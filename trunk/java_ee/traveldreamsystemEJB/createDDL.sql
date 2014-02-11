CREATE DATABASE  IF NOT EXISTS `traveldreamsystem_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `traveldreamsystem_db`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: traveldreamsystem_db
-- ------------------------------------------------------
-- Server version	5.6.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `escursione`
--

DROP TABLE IF EXISTS `escursione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escursione` (
  `IDPRODBASE` int(11) NOT NULL AUTO_INCREMENT,
  `COSTO` int(11) DEFAULT NULL,
  `DATAPARTENZA` datetime NOT NULL,
  `DATARITORNO` datetime NOT NULL,
  `DESCRIZIONE` longtext NOT NULL,
  `LUOGO` varchar(45) NOT NULL,
  PRIMARY KEY (`IDPRODBASE`),
  UNIQUE KEY `IDPRODBASE` (`IDPRODBASE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escursione`
--

LOCK TABLES `escursione` WRITE;
/*!40000 ALTER TABLE `escursione` DISABLE KEYS */;
/*!40000 ALTER TABLE `escursione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escursionipacchper`
--

DROP TABLE IF EXISTS `escursionipacchper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escursionipacchper` (
  `DATAACQUISTO` datetime DEFAULT NULL,
  `IDESCURSIONE` int(11) NOT NULL,
  `IDPACCHPER` int(11) NOT NULL,
  PRIMARY KEY (`IDESCURSIONE`,`IDPACCHPER`),
  KEY `FK_escursioniPacchPer_IDPACCHPER` (`IDPACCHPER`),
  CONSTRAINT `FK_escursioniPacchPer_IDESCURSIONE` FOREIGN KEY (`IDESCURSIONE`) REFERENCES `escursione` (`IDPRODBASE`),
  CONSTRAINT `FK_escursioniPacchPer_IDPACCHPER` FOREIGN KEY (`IDPACCHPER`) REFERENCES `pacchper` (`IDPACCHPER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escursionipacchper`
--

LOCK TABLES `escursionipacchper` WRITE;
/*!40000 ALTER TABLE `escursionipacchper` DISABLE KEYS */;
/*!40000 ALTER TABLE `escursionipacchper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escursionipacchpred`
--

DROP TABLE IF EXISTS `escursionipacchpred`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escursionipacchpred` (
  `IDESCURSIONE` int(11) NOT NULL,
  `IDPACCHPRED` int(11) NOT NULL,
  PRIMARY KEY (`IDESCURSIONE`,`IDPACCHPRED`),
  KEY `FK_escursioniPacchPred_IDPACCHPRED` (`IDPACCHPRED`),
  CONSTRAINT `FK_escursioniPacchPred_IDESCURSIONE` FOREIGN KEY (`IDESCURSIONE`) REFERENCES `escursione` (`IDPRODBASE`),
  CONSTRAINT `FK_escursioniPacchPred_IDPACCHPRED` FOREIGN KEY (`IDPACCHPRED`) REFERENCES `pacchpred` (`IDPACCHPRED`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escursionipacchpred`
--

LOCK TABLES `escursionipacchpred` WRITE;
/*!40000 ALTER TABLE `escursionipacchpred` DISABLE KEYS */;
/*!40000 ALTER TABLE `escursionipacchpred` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel` (
  `IDPRODBASE` int(11) NOT NULL AUTO_INCREMENT,
  `CITTA` varchar(45) NOT NULL,
  `COSTO` int(11) DEFAULT NULL,
  `DATAPARTENZA` datetime NOT NULL,
  `DATARITORNO` datetime NOT NULL,
  `DESCRIZIONE` longtext NOT NULL,
  `STELLE` int(11) NOT NULL,
  `TIPOCAMERA` varchar(45) NOT NULL,
  PRIMARY KEY (`IDPRODBASE`),
  UNIQUE KEY `IDPRODBASE` (`IDPRODBASE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotelspacchper`
--

DROP TABLE IF EXISTS `hotelspacchper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotelspacchper` (
  `DATAACQUISTO` datetime DEFAULT NULL,
  `IDHOTEL` int(11) NOT NULL,
  `IDPACCHPER` int(11) NOT NULL,
  PRIMARY KEY (`IDHOTEL`,`IDPACCHPER`),
  KEY `FK_hotelsPacchPer_IDPACCHPER` (`IDPACCHPER`),
  CONSTRAINT `FK_hotelsPacchPer_IDHOTEL` FOREIGN KEY (`IDHOTEL`) REFERENCES `hotel` (`IDPRODBASE`),
  CONSTRAINT `FK_hotelsPacchPer_IDPACCHPER` FOREIGN KEY (`IDPACCHPER`) REFERENCES `pacchper` (`IDPACCHPER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotelspacchper`
--

LOCK TABLES `hotelspacchper` WRITE;
/*!40000 ALTER TABLE `hotelspacchper` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotelspacchper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotelspacchpred`
--

DROP TABLE IF EXISTS `hotelspacchpred`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotelspacchpred` (
  `IDHOTEL` int(11) NOT NULL,
  `IDPACCHPRED` int(11) NOT NULL,
  PRIMARY KEY (`IDHOTEL`,`IDPACCHPRED`),
  KEY `FK_hotelsPacchPred_IDPACCHPRED` (`IDPACCHPRED`),
  CONSTRAINT `FK_hotelsPacchPred_IDHOTEL` FOREIGN KEY (`IDHOTEL`) REFERENCES `hotel` (`IDPRODBASE`),
  CONSTRAINT `FK_hotelsPacchPred_IDPACCHPRED` FOREIGN KEY (`IDPACCHPRED`) REFERENCES `pacchpred` (`IDPACCHPRED`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotelspacchpred`
--

LOCK TABLES `hotelspacchpred` WRITE;
/*!40000 ALTER TABLE `hotelspacchpred` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotelspacchpred` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacchper`
--

DROP TABLE IF EXISTS `pacchper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pacchper` (
  `IDPACCHPER` int(11) NOT NULL AUTO_INCREMENT,
  `LISTAREGALI` tinyint(1) NOT NULL DEFAULT '0',
  `IDCLIENTE` varchar(45) DEFAULT NULL,
  `IDPACCHPRED` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDPACCHPER`),
  UNIQUE KEY `IDPACCHPER` (`IDPACCHPER`),
  KEY `FK_pacchPer_IDCLIENTE` (`IDCLIENTE`),
  KEY `FK_pacchPer_IDPACCHPRED` (`IDPACCHPRED`),
  CONSTRAINT `FK_pacchPer_IDPACCHPRED` FOREIGN KEY (`IDPACCHPRED`) REFERENCES `pacchpred` (`IDPACCHPRED`),
  CONSTRAINT `FK_pacchPer_IDCLIENTE` FOREIGN KEY (`IDCLIENTE`) REFERENCES `utente` (`MAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacchper`
--

LOCK TABLES `pacchper` WRITE;
/*!40000 ALTER TABLE `pacchper` DISABLE KEYS */;
/*!40000 ALTER TABLE `pacchper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacchpred`
--

DROP TABLE IF EXISTS `pacchpred`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pacchpred` (
  `IDPACCHPRED` int(11) NOT NULL,
  `DESCRIZIONE` longtext NOT NULL,
  PRIMARY KEY (`IDPACCHPRED`),
  UNIQUE KEY `IDPACCHPRED` (`IDPACCHPRED`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacchpred`
--

LOCK TABLES `pacchpred` WRITE;
/*!40000 ALTER TABLE `pacchpred` DISABLE KEYS */;
/*!40000 ALTER TABLE `pacchpred` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trasportipacchper`
--

DROP TABLE IF EXISTS `trasportipacchper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trasportipacchper` (
  `DATAACQUISTO` datetime DEFAULT NULL,
  `IDPACCHPER` int(11) NOT NULL,
  `IDTRASPORTO` int(11) NOT NULL,
  PRIMARY KEY (`IDPACCHPER`,`IDTRASPORTO`),
  KEY `FK_trasportiPacchPer_IDTRASPORTO` (`IDTRASPORTO`),
  CONSTRAINT `FK_trasportiPacchPer_IDTRASPORTO` FOREIGN KEY (`IDTRASPORTO`) REFERENCES `trasporto` (`IDPRODBASE`),
  CONSTRAINT `FK_trasportiPacchPer_IDPACCHPER` FOREIGN KEY (`IDPACCHPER`) REFERENCES `pacchper` (`IDPACCHPER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trasportipacchper`
--

LOCK TABLES `trasportipacchper` WRITE;
/*!40000 ALTER TABLE `trasportipacchper` DISABLE KEYS */;
/*!40000 ALTER TABLE `trasportipacchper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trasportipacchpred`
--

DROP TABLE IF EXISTS `trasportipacchpred`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trasportipacchpred` (
  `IDPACCHPRED` int(11) NOT NULL,
  `IDTRASPORTO` int(11) NOT NULL,
  PRIMARY KEY (`IDPACCHPRED`,`IDTRASPORTO`),
  KEY `FK_trasportiPacchPred_IDTRASPORTO` (`IDTRASPORTO`),
  CONSTRAINT `FK_trasportiPacchPred_IDPACCHPRED` FOREIGN KEY (`IDPACCHPRED`) REFERENCES `pacchpred` (`IDPACCHPRED`),
  CONSTRAINT `FK_trasportiPacchPred_IDTRASPORTO` FOREIGN KEY (`IDTRASPORTO`) REFERENCES `trasporto` (`IDPRODBASE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trasportipacchpred`
--

LOCK TABLES `trasportipacchpred` WRITE;
/*!40000 ALTER TABLE `trasportipacchpred` DISABLE KEYS */;
/*!40000 ALTER TABLE `trasportipacchpred` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trasporto`
--

DROP TABLE IF EXISTS `trasporto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trasporto` (
  `IDPRODBASE` int(11) NOT NULL AUTO_INCREMENT,
  `CITTAPARTENZA` varchar(45) NOT NULL,
  `CITTARITORNO` varchar(45) NOT NULL,
  `COSTO` int(11) DEFAULT NULL,
  `DATAPARTENZA` datetime NOT NULL,
  `DATARITORNO` datetime NOT NULL,
  `DESCRIZIONE` longtext,
  PRIMARY KEY (`IDPRODBASE`),
  UNIQUE KEY `IDPRODBASE` (`IDPRODBASE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trasporto`
--

LOCK TABLES `trasporto` WRITE;
/*!40000 ALTER TABLE `trasporto` DISABLE KEYS */;
/*!40000 ALTER TABLE `trasporto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utente` (
  `MAIL` varchar(45) NOT NULL,
  `COGNOME` varchar(45) NOT NULL,
  `NOME` varchar(45) NOT NULL,
  `PASSWORD` varchar(64) NOT NULL,
  `REGISTEREDON` datetime NOT NULL,
  `TIPOUTENTE` varchar(45) NOT NULL,
  PRIMARY KEY (`MAIL`),
  UNIQUE KEY `MAIL` (`MAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES ('admin','admin','admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','2013-11-27 23:44:12','AMMINISTRATORE'),('cliente','cliente','cliente','a60b85d409a01d46023f90741e01b79543a3cb1ba048eaefbe5d7a63638043bf','2013-11-27 23:44:12','CLIENTE'),('impiegato','impiegato','impiegato','3f65f50ce25d0b80006018e4f6d90bf039f6ea2d717aa90aa224b90d3941f30a','2013-11-27 23:44:12','IMPIEGATO');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-11 18:32:32