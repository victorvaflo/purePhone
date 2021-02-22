DROP DATABASE IF EXISTS `tpjava`;
CREATE DATABASE `tpjava`;
USE `tpjava`;

-- MySQL dump 10.16  Distrib 10.2.31-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: tpjava
-- ------------------------------------------------------
-- Server version	10.2.31-MariaDB

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
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorie` (
  `id_categorie` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nom_categorie` varchar(100) NOT NULL,
  `img_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
INSERT INTO `categorie` VALUES (1,'Apple','img-cat-apple.png'),(2,'Samsung','img-cat-samsung.png'),(3,'LG','img-cat-lg.png'),(4,'Huawei','img-cat-huawei.png');
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id_client` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id_client`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (4,'test','test','test@test.com','test');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commande` (
  `id_commande` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_client` int(10) unsigned NOT NULL,
  `date_commande` datetime NOT NULL,
  `prix_total_commande` double NOT NULL,
  PRIMARY KEY (`id_commande`),
  KEY `commande_fk` (`id_client`),
  CONSTRAINT `commande_fk` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande`
--

LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
INSERT INTO `commande` VALUES (1000,4,'2020-05-21 00:00:00',1800),(1001,4,'2020-05-22 00:00:00',2900),(1002,4,'2020-05-22 00:00:00',1800),(1003,4,'2020-05-22 00:00:00',600);
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ligne_commande`
--

DROP TABLE IF EXISTS `ligne_commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ligne_commande` (
  `id_ligne_commande` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_commande` int(10) unsigned NOT NULL,
  `id_produit` int(10) unsigned NOT NULL,
  `qte_produit` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_ligne_commande`),
  KEY `ligne_commande_fk` (`id_commande`),
  KEY `ligne_commande_fk_1` (`id_produit`),
  CONSTRAINT `ligne_commande_fk` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id_commande`),
  CONSTRAINT `ligne_commande_fk_1` FOREIGN KEY (`id_produit`) REFERENCES `produit` (`id_produit`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ligne_commande`
--

LOCK TABLES `ligne_commande` WRITE;
/*!40000 ALTER TABLE `ligne_commande` DISABLE KEYS */;
INSERT INTO `ligne_commande` VALUES (1,1000,7,1),(2,1000,13,3),(3,1001,2,1),(4,1001,8,2),(5,1001,13,3),(6,1002,7,2),(7,1003,13,2);
/*!40000 ALTER TABLE `ligne_commande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produit` (
  `id_produit` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `titre` varchar(100) NOT NULL,
  `description` longtext DEFAULT NULL,
  `img_url` varchar(100) DEFAULT NULL,
  `prix` double NOT NULL,
  `couleur` varchar(100) DEFAULT NULL,
  `stockage` int(11) DEFAULT NULL,
  `id_categorie` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_produit`),
  KEY `produit_fk` (`id_categorie`),
  CONSTRAINT `produit_fk` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id_categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit`
--

LOCK TABLES `produit` WRITE;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
INSERT INTO `produit` VALUES (1,'iPhone X','L’iPhone X, c’est un design tout écran intégrant un écran Super Retina HD 5,8 pouces avec HDR et affichage True Tone1. Il se charge sans fil et résiste à l’eau et à la poussière.','iphone-x.jpg',1050,'Noir',64,1),(2,'iPhone 11','Ecran liquid Rétina de 6,1\" HD. Il est résistant à l’eau et à la poussière (IP68)','iPhone_11_Purple.jpg',900,'Violet',64,1),(3,'iPhone 11 Pro Max','Ecran Super Retina XDR de 6,5 pouces. Triple appareil photo de 12 MP + 12 Mp + 12MP. Caméra avant de 12MP','iPhone11ProMax.jpg',1290,'Noir',128,1),(4,'iPhone 7 Plus','L’iPhone 7 Plus est un smartphone de 5,5 pouces. Il possède une puce A10 Fusion de quatre coeurs','iphone-7-plus.png',700,'Rose',64,1),(5,'Samsung Galaxy Z Flip','Il une a Caméra. 12 Mpx. 2 capteurs, et une taille d\"écran. 6.7 pouces.','SS_Z_Flip_Catalog_Black.png',600,'Noir',16,2),(6,'Samsung Galaxy S20 Ultra 5G','Il offre un écran Infinity Super AMOLED de 6,9 pouces, un appareil photo de 108 Mpx','SS_S20_Ultra_Catalog_Gray_F_B.png',800,'Noir',512,2),(7,'Samsung Galaxy S10 plus','Le Samsung Galaxy S10 Plus est la version grande taille du Galaxy S10 avec un écran de 6,4 pouces de diagonale ainsi que 8 Go de RAM.','samsung-galaxy-s10.png',900,'Noir',128,2),(8,'Samsung Galaxy Note 8','Le Samsung Galaxy Note 8 est un smartphone de grande taille offrant des performances haut de gamme : un écran 6,3 pouces avec un rendu en Full HD+, un processeur ultra-performant, une mémoire vive conséquente','samsung-galaxy-note-9.png',550,'Violet',128,2),(9,'LG G8X ThinQ','Le LG G8X ThinQ dispose d un écran OLED avec une diagonale d écran de 6,4 pouces et une petite encoche derrière laquelle se trouve la caméra frontale. La présentation se caractérise par de belles couleurs, des contrastes élevés et une bonne luminosité','lg-g8x-ss-black-back2back-min.png',500,'Noir',16,3),(10,'LG G8X ThinQ Dual Screen','Au-delà des téléphones pliables, le LG Dual Screen vous permet de doubler instantanément votre écran afin que vous puissiez tout faire à la fois','lg-g8-dual-screen.jpg',850,'Noir',128,3),(11,'LG G7 One','Le LG G7 One est le premier smartphone de la marque coréenne sous Android One. il dispose d un SoC Qualcomm Snapdragon 835 épaulé par 4 Go de RAM, un capteur photo de 16 mégapixels et une sortie jack avec Quad Dac.','lg-g7.jpg',300,'Noir',16,3),(12,'Huawei P30','Le Huawei P30 est un smartphone doté d un écran OLED FHD+ de 6,1 pouces. Il embarque le processeur Kirin 980 avec 6 Go de mémoire vive','huawei-p30.png',1230,'Bleu',128,4),(13,'Huawei P20 Lite','Le Huawei P20 Lite est un smartphone équipé d un écran bord à bord de 5,84 pouces au format 19/9','huawei-p20.jpg',300,'Noir',64,4),(14,'Huawei Y6 2019','Le Huawei Y6 2019 est un smartphone d\'entrée de gamme annoncé en janvier 2019. Il est équipé d\'un écran de 6,09 pouces avec une définition HD+, d\'un SoC Helio P20 épaulé par 3 Go de RAM et d\'un capteur de 13 mégapixels','huawei-y6-2019.png',700,'Bleu',32,4),(15,'Huawei P40 Lite','Huawei P40 Lite. Le Huawei P40 Lite est équipé du SoC Kirin 810, épaulé par 6 Go de RAM et 128 Go de stockage, extensible par nanoSD. Il possède 4 capteurs photos à l\'arrière, le principal fait 48 mégapixels. Il a une batterie de 4200 mAh compatible avec la charge rapide jusqu\'à 40 W.','huawei-p40.png',800,'Rose-Vert',64,4),(16,'iPhone 8','La onzième itération de l\'iPhone s\'appelle l\'iPhone 8. Il a été annoncé le 12 Septembre 2017 et à la particularité d\'embarquer iOS 11, un SoC A11 gravé en 10 nm','iphone-8.png',800,'Rose-Gold',64,1);
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tpjava'
--

--
-- Dumping routines for database 'tpjava'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-22 10:16:55
