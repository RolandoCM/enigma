-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_sigecu
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB

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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `idalumno` int(11) NOT NULL AUTO_INCREMENT,
  `aNombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `aPaterno` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `aMaterno` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `e_idEmpresa` int(11) NOT NULL,
  `carrera` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `notebook` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `status` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idalumno`),
  KEY `fk_alumno_empresa1_idx` (`e_idEmpresa`),
  CONSTRAINT `fk_alumno_empresa1` FOREIGN KEY (`e_idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno_has_cursos`
--

DROP TABLE IF EXISTS `alumno_has_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno_has_cursos` (
  `a_idalumno` int(11) NOT NULL,
  `c_idcursos` int(11) NOT NULL,
  PRIMARY KEY (`a_idalumno`,`c_idcursos`),
  KEY `fk_alumno_has_cursos_cursos1_idx` (`c_idcursos`),
  KEY `fk_alumno_has_cursos_alumno1_idx` (`a_idalumno`),
  CONSTRAINT `fk_alumno_has_cursos_alumno1` FOREIGN KEY (`a_idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_alumno_has_cursos_cursos1` FOREIGN KEY (`c_idcursos`) REFERENCES `cursos` (`idcursos`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_has_cursos`
--

LOCK TABLES `alumno_has_cursos` WRITE;
/*!40000 ALTER TABLE `alumno_has_cursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumno_has_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno_has_diploma`
--

DROP TABLE IF EXISTS `alumno_has_diploma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno_has_diploma` (
  `a_idalumno` int(11) NOT NULL,
  `d_iddiploma` int(11) NOT NULL,
  PRIMARY KEY (`a_idalumno`,`d_iddiploma`),
  KEY `fk_alumno_has_diploma_diploma1_idx` (`d_iddiploma`),
  KEY `fk_alumno_has_diploma_alumno1_idx` (`a_idalumno`),
  CONSTRAINT `fk_alumno_has_diploma_alumno1` FOREIGN KEY (`a_idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_alumno_has_diploma_diploma1` FOREIGN KEY (`d_iddiploma`) REFERENCES `diploma` (`iddiploma`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_has_diploma`
--

LOCK TABLES `alumno_has_diploma` WRITE;
/*!40000 ALTER TABLE `alumno_has_diploma` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumno_has_diploma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno_has_eventos`
--

DROP TABLE IF EXISTS `alumno_has_eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno_has_eventos` (
  `a_idalumno` int(11) NOT NULL AUTO_INCREMENT,
  `e_idevento` int(11) NOT NULL,
  PRIMARY KEY (`a_idalumno`,`e_idevento`),
  KEY `fk_alumno_has_eventos_eventos1_idx` (`e_idevento`),
  KEY `fk_alumno_has_eventos_alumno1_idx` (`a_idalumno`),
  CONSTRAINT `fk_alumno_has_eventos_alumno1` FOREIGN KEY (`a_idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_alumno_has_eventos_eventos1` FOREIGN KEY (`e_idevento`) REFERENCES `eventos` (`idevento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_has_eventos`
--

LOCK TABLES `alumno_has_eventos` WRITE;
/*!40000 ALTER TABLE `alumno_has_eventos` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumno_has_eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudad` (
  `idCiudad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `p_idPais` int(11) NOT NULL,
  PRIMARY KEY (`idCiudad`),
  KEY `fk_ciudad_pais1_idx` (`p_idPais`),
  CONSTRAINT `fk_ciudad_pais1` FOREIGN KEY (`p_idPais`) REFERENCES `pais` (`idPais`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'queretaro',1),(2,'queretaro',1);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursos` (
  `idcursos` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `horario` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaInicio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaFin` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipo` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `i_idinstructor` int(11) NOT NULL,
  PRIMARY KEY (`idcursos`),
  KEY `fk_cursos_instructor1_idx` (`i_idinstructor`),
  CONSTRAINT `fk_cursos_instructor1` FOREIGN KEY (`i_idinstructor`) REFERENCES `instructor` (`idinstructor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos_has_pagos`
--

DROP TABLE IF EXISTS `cursos_has_pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursos_has_pagos` (
  `c_idcursos` int(11) NOT NULL AUTO_INCREMENT,
  `p_idpagos` int(11) NOT NULL,
  `promocion` double NOT NULL,
  PRIMARY KEY (`c_idcursos`,`p_idpagos`),
  KEY `fk_cursos_has_pagos_pagos1_idx` (`p_idpagos`),
  KEY `fk_cursos_has_pagos_cursos1_idx` (`c_idcursos`),
  CONSTRAINT `fk_cursos_has_pagos_cursos1` FOREIGN KEY (`c_idcursos`) REFERENCES `cursos` (`idcursos`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cursos_has_pagos_pagos1` FOREIGN KEY (`p_idpagos`) REFERENCES `pagos` (`idpagos`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos_has_pagos`
--

LOCK TABLES `cursos_has_pagos` WRITE;
/*!40000 ALTER TABLE `cursos_has_pagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `cursos_has_pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diploma`
--

DROP TABLE IF EXISTS `diploma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diploma` (
  `iddiploma` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `curso` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `fecha` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`iddiploma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diploma`
--

LOCK TABLES `diploma` WRITE;
/*!40000 ALTER TABLE `diploma` DISABLE KEYS */;
/*!40000 ALTER TABLE `diploma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `idEmpresa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idEmpresa`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'ITQ','sige@itq.edu.mx','4425226398','tecnologico');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluaciones`
--

DROP TABLE IF EXISTS `evaluaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluaciones` (
  `idevaluacion` int(11) NOT NULL AUTO_INCREMENT,
  `c_idcursos` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `idAlumno` int(11) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `tiempo` time NOT NULL,
  PRIMARY KEY (`idevaluacion`),
  KEY `fk_evaluaciones_cursos1_idx` (`c_idcursos`),
  CONSTRAINT `fk_evaluaciones_cursos1` FOREIGN KEY (`c_idcursos`) REFERENCES `cursos` (`idcursos`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluaciones`
--

LOCK TABLES `evaluaciones` WRITE;
/*!40000 ALTER TABLE `evaluaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventos`
--

DROP TABLE IF EXISTS `eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventos` (
  `idevento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `fechaInicio` date DEFAULT NULL,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `programa` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `i_idinstructor` int(11) NOT NULL,
  `lugar` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `c_idCiudad` int(11) NOT NULL,
  `capacidad` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `tipo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estatus` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `costo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `t_idtempletes` int(11) NOT NULL,
  `p_idpromociones` int(11) NOT NULL,
  `fechaTermino` date DEFAULT NULL,
  PRIMARY KEY (`idevento`),
  KEY `fk_eventos_instructor1_idx` (`i_idinstructor`),
  KEY `fk_eventos_templetes1_idx` (`t_idtempletes`),
  KEY `fk_eventos_ciudad1_idx` (`c_idCiudad`),
  KEY `fk_eventos_promociones1_idx` (`p_idpromociones`),
  CONSTRAINT `fk_eventos_ciudad1` FOREIGN KEY (`c_idCiudad`) REFERENCES `ciudad` (`idCiudad`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_eventos_instructor1` FOREIGN KEY (`i_idinstructor`) REFERENCES `instructor` (`idinstructor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_eventos_promociones1` FOREIGN KEY (`p_idpromociones`) REFERENCES `promociones` (`idpromociones`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_eventos_templetes1` FOREIGN KEY (`t_idtempletes`) REFERENCES `templetes` (`idtempletes`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
INSERT INTO `eventos` VALUES (1,'conferencia 0','2017-12-01','ninguna','programa',1,'CCN',1,'200','privado',NULL,'200.0',1,1,NULL),(2,'friki','2017-01-23','Sin descripcion','por definir',1,'CERN',1,'200','publico',NULL,'200.0',1,1,NULL),(3,'friki','2017-01-23','Sin descripcion','por definir',1,'CERN',1,'200','publico',NULL,'200.0',1,1,NULL),(4,'friki','2017-01-23','Sin descripcion','por definir',1,'CERN',1,'200','publico',NULL,'200.0',1,1,NULL),(5,'friki','2017-01-23','Sin descripcion','por definir',1,'CERN',1,'200','publico',NULL,'200.0',1,1,NULL),(6,'Fred','2017-01-23','Sin descripcion','por definir',1,'CERN',1,'200','publico',NULL,'200.0',1,1,NULL),(7,'conferencia magistral','2017-12-01','ninguna','programa',1,'CCN',1,'200','privado',NULL,'200.0',1,1,NULL),(8,'drones nuevo','2017-02-03','sin descripcion','programa',1,'CERN',1,'200','privado',NULL,'100.0',1,1,NULL),(9,'Rolando Ca','2018-02-03','sd','ds',2,'Tuberos 12 San Pedrito',2,'200','privado','on','100.0',1,1,NULL),(10,'Rolando Ca','2018-02-03','ere','rer',2,'Tuberos 12 San Pedrito',2,'200','publico','on','100.0',1,1,NULL),(11,'Rolando Ca','2018-02-03','sin descripcion','sin definir',2,'Tuberos 12 San Pedrito',2,'200','publico',NULL,'100.0',1,1,NULL),(12,'Rolando Ca','2018-02-03','sin descripcion','sin definir',2,'Tuberos 12 San Pedrito',2,'200','publico',NULL,'100.0',1,1,NULL),(13,'jose','2016-03-09','df','programa',1,'5',1,'200','privado',NULL,'100.0',1,1,NULL),(14,'Rolando Ca','2018-02-03','fdf','fd',1,'Tuberos 12 San Pedrito',2,'200','publico','on','100.0',2,1,NULL),(15,'Rolando Ca','2018-02-03','fd','fd',1,'Tuberos 12 San Pedrito',2,'200','privado',NULL,'100.0',1,1,NULL),(16,'Rolando Ca','2018-02-03','fd','fd',1,'Tuberos 12 San Pedrito',2,'200','privado',NULL,'100.0',1,1,NULL),(17,'Rolando Ca','2018-02-03','ere','fdf',1,'Tuberos 12 San Pedrito',2,'4','publico','on','44.0',1,1,NULL),(18,'Rolando Ca','2018-02-03','ere','fdf',1,'Tuberos 12 San Pedrito',2,'4','publico','on','44.0',1,1,NULL),(19,'Rolando Ca','2018-02-03','ere','fdf',1,'Tuberos 12 San Pedrito',2,'4','publico','on','44.0',1,1,NULL),(20,'Rolando Ca','2018-02-03','ere','fdf',1,'Tuberos 12 San Pedrito',2,'4','publico','on','44.0',1,1,NULL),(21,'Rolando Ca','2018-02-03','ere','fdf',1,'Tuberos 12 San Pedrito',2,'4','publico','on','44.0',1,1,NULL),(22,'conferencia magistral','0000-00-00','ninguna','por definir',1,'CCN',1,'200','1','2','200',1,1,NULL),(23,'Rolando Ca','2018-02-03','ere','fdf',1,'Tuberos 12 San Pedrito',2,'4','publico','on','44.0',1,1,NULL),(24,'Rolando Ca','2018-02-03','ere','fdf',1,'Tuberos 12 San Pedrito',2,'4','publico','on','44.0',1,1,NULL),(25,'Rolando Ca','2018-02-03','ere','fdf',1,'Tuberos 12 San Pedrito',2,'4','publico','on','44.0',1,1,NULL),(26,'conferencia magistral','0000-00-00','ninguna','por definir',1,'CCN',1,'200','1','2','200',1,1,NULL),(27,'Rolando Ca','2018-02-01','sin descripcion','sin definir',1,'Tuberos 12 San Pedrito',2,'3','publico','on','44.0',1,1,NULL),(28,'Rolando Ca','2018-02-01','sin descripcion','sin definir',1,'Tuberos 12 San Pedrito',2,'3','publico',NULL,'44.0',1,1,NULL),(29,'Rolando Ca','2018-02-01','sin descripcion','sin definir',1,'Tuberos 12 San Pedrito',2,'3','publico',NULL,'44.0',1,1,NULL),(30,'Rolando Ca','2018-02-01','sin descripcion','sin definir',1,'Tuberos 12 San Pedrito',2,'3','publico','on','44.0',1,1,NULL),(31,'Evento 1','2014-12-20','fdsfsf','asdfgb',2,'otro',1,'20','publico',NULL,'200.0',1,1,NULL),(32,'Evento 1','2014-12-20','fdsfsf','asdfgb',2,'otro',1,'20','publico',NULL,'200.0',1,1,NULL),(33,'Evento 1','2014-12-20','fdsfsf','asdfgb',2,'otro',1,'20','publico',NULL,'200.0',1,1,NULL),(34,'Evento 1','2014-12-20','fdsfsf','asdfgb',2,'otro',1,'20','publico',NULL,'200.0',1,1,NULL),(35,'Evento 1','2014-12-20','fdsfsf','asdfgb',2,'otro',1,'20','publico',NULL,'200.0',1,1,NULL),(36,'Evento 1','2014-12-20','fdsfsf','asdfgb',2,'otro',1,'20','publico',NULL,'200.0',1,1,NULL),(37,'Evento 1','2014-12-20','fdsfsf','asdfgb',2,'otro',1,'20','publico',NULL,'200.0',1,1,NULL),(38,'Evento 1','2014-12-20','fdsfsf','asdfgb',2,'otro',1,'20','publico',NULL,'200.0',1,1,NULL),(39,'conferencia magistral','2017-05-05','ninguna','por definir',1,'CCN',1,'200','1','2','200',1,1,'2017-12-04'),(40,'nuevo','2017-12-02','Sin descripcion','sin definir',2,'qro',1,'30','publico',NULL,'200.0',1,1,NULL),(41,'mi nuevo proyecto','2017-12-01','s','sin definir',1,'qro',2,'34','publico',NULL,'220.0',1,1,NULL),(42,'jose','2017-12-01','sin descripcion','no',2,'sin lugar',1,'20','publico',NULL,'300.0',1,1,'2017-05-03'),(43,'este es un evento','2017-12-01','sin descripcion','programa',1,'sin lugar',1,'23','publico',NULL,'300.0',1,1,'2016-12-15'),(44,'este es un nuevo evento','2017-06-24','sin descripcion','programa',1,'sin lugar',1,'30','privado','on','300.0',1,1,'2017-12-15'),(45,'evento 0','2016-03-09','s','sin definir',1,'sin lugar',1,'20','publico','on','302.0',1,1,'2017-12-15'),(46,'programacion c','2017-10-23','Curso de programacion','sin definir',2,'centro de inv',2,'15','privado','on','2000.0',1,1,'2017-11-20'),(47,'nuevo evento 9','2016-03-09','sin descripcion','sin definir',2,'sin lugar',2,'33','publico','on','300.0',1,1,'2017-12-15');
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventos_has_pagos`
--

DROP TABLE IF EXISTS `eventos_has_pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventos_has_pagos` (
  `e_idevento` int(11) NOT NULL AUTO_INCREMENT,
  `p_idpagos` int(11) NOT NULL,
  PRIMARY KEY (`e_idevento`,`p_idpagos`),
  KEY `fk_eventos_has_pagos_pagos1_idx` (`p_idpagos`),
  KEY `fk_eventos_has_pagos_eventos1_idx` (`e_idevento`),
  CONSTRAINT `fk_eventos_has_pagos_eventos1` FOREIGN KEY (`e_idevento`) REFERENCES `eventos` (`idevento`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_eventos_has_pagos_pagos1` FOREIGN KEY (`p_idpagos`) REFERENCES `pagos` (`idpagos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos_has_pagos`
--

LOCK TABLES `eventos_has_pagos` WRITE;
/*!40000 ALTER TABLE `eventos_has_pagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventos_has_pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `idfactura` int(11) NOT NULL AUTO_INCREMENT,
  `valor` double NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `RCFexpide` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `selloDigital` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `lugar` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha` date NOT NULL,
  `RFCrecibe` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `valorLetra` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `certificadoDigital` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idfactura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instructor` (
  `idinstructor` int(11) NOT NULL AUTO_INCREMENT,
  `iNombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `iPaterno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iMaterno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Carrera` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Especialidad` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iEmail` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iTelefono` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iDireccion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idinstructor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (1,'jose','casas','sas','isc','sd','casas@gmail.com','4423432112','ddffgg'),(2,'Rolando','Castillo','sas','isc','sd','cast@gmail.com','4423432112','ddffgg'),(3,'Rolando','Castillo','sas','isc','sd','cast@gmail.com','4423432112','ddffgg');
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materiales`
--

DROP TABLE IF EXISTS `materiales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materiales` (
  `idmaterial` int(11) NOT NULL AUTO_INCREMENT,
  `mNombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `mDescripcion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `mRuta` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `c_idcursos` int(11) NOT NULL,
  PRIMARY KEY (`idmaterial`),
  KEY `fk_materiales_cursos1_idx` (`c_idcursos`),
  CONSTRAINT `fk_materiales_cursos1` FOREIGN KEY (`c_idcursos`) REFERENCES `cursos` (`idcursos`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiales`
--

LOCK TABLES `materiales` WRITE;
/*!40000 ALTER TABLE `materiales` DISABLE KEYS */;
/*!40000 ALTER TABLE `materiales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagos`
--

DROP TABLE IF EXISTS `pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagos` (
  `idpagos` int(11) NOT NULL AUTO_INCREMENT,
  `f_idfactura` int(11) NOT NULL,
  `tipo` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpagos`),
  KEY `fk_pagos_factura1_idx` (`f_idfactura`),
  CONSTRAINT `fk_pagos_factura1` FOREIGN KEY (`f_idfactura`) REFERENCES `factura` (`idfactura`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos`
--

LOCK TABLES `pagos` WRITE;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `idPais` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `region` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'mx','19'),(2,'mx','19');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `idPerfil` int(11) NOT NULL,
  `perfil` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pre_inscripcion`
--

DROP TABLE IF EXISTS `pre_inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pre_inscripcion` (
  `idpreInscripcion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `e_idEmpresa` int(11) NOT NULL,
  `carrera` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `confirmar` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idpreInscripcion`),
  KEY `fk_pre-inscripcion_empresa1_idx` (`e_idEmpresa`),
  CONSTRAINT `fk_pre-inscripcion_empresa1` FOREIGN KEY (`e_idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pre_inscripcion`
--

LOCK TABLES `pre_inscripcion` WRITE;
/*!40000 ALTER TABLE `pre_inscripcion` DISABLE KEYS */;
INSERT INTO `pre_inscripcion` VALUES (1,'Rolando','Castillo Martinez','014425226986','castillor493@gmail.com',1,'ISC','si'),(2,'Rolando','Castillo Martinez','014425226986','castillor493@gmail.com',1,'ISC','si'),(3,'Rolando','Castillo Martinez','014425226986','castillor493@gmail.com',1,'ISC','si'),(4,'Rolando','Castillo Martinez','014425226986','castillor493@gmail.com',1,'ISC','si'),(5,'Rolando','Castillo Martinez','014425226986','castillor493@gmail.com',1,'ISC','si'),(6,'salo','Ramirez','4425226986','salo@gmail.com',1,'ISC','si'),(7,'Rolando','Castillo Martinez','4425226986','castillor493@gmail.com',1,'isc','si');
/*!40000 ALTER TABLE `pre_inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pre_inscripcion_has_pagos`
--

DROP TABLE IF EXISTS `pre_inscripcion_has_pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pre_inscripcion_has_pagos` (
  `p_idpre-inscripcion` int(11) NOT NULL AUTO_INCREMENT,
  `p_idpagos` int(11) NOT NULL,
  PRIMARY KEY (`p_idpre-inscripcion`,`p_idpagos`),
  KEY `fk_pre-inscripcion_has_pagos_pagos1_idx` (`p_idpagos`),
  KEY `fk_pre-inscripcion_has_pagos_pre-inscripcion1_idx` (`p_idpre-inscripcion`),
  CONSTRAINT `fk_pre-inscripcion_has_pagos_pagos1` FOREIGN KEY (`p_idpagos`) REFERENCES `pagos` (`idpagos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pre-inscripcion_has_pagos_pre-inscripcion1` FOREIGN KEY (`p_idpre-inscripcion`) REFERENCES `pre_inscripcion` (`idpreInscripcion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pre_inscripcion_has_pagos`
--

LOCK TABLES `pre_inscripcion_has_pagos` WRITE;
/*!40000 ALTER TABLE `pre_inscripcion_has_pagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pre_inscripcion_has_pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preguntas`
--

DROP TABLE IF EXISTS `preguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preguntas` (
  `idpregunta` int(11) NOT NULL AUTO_INCREMENT,
  `e_idevaluacion` int(11) NOT NULL,
  `idEvaluacion` int(11) NOT NULL,
  `Pregunta` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idpregunta`),
  KEY `fk_preguntas_evaluaciones1_idx` (`e_idevaluacion`),
  CONSTRAINT `fk_preguntas_evaluaciones1` FOREIGN KEY (`e_idevaluacion`) REFERENCES `evaluaciones` (`idevaluacion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preguntas`
--

LOCK TABLES `preguntas` WRITE;
/*!40000 ALTER TABLE `preguntas` DISABLE KEYS */;
/*!40000 ALTER TABLE `preguntas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promociones`
--

DROP TABLE IF EXISTS `promociones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promociones` (
  `idpromociones` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idpromociones`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promociones`
--

LOCK TABLES `promociones` WRITE;
/*!40000 ALTER TABLE `promociones` DISABLE KEYS */;
INSERT INTO `promociones` VALUES (1,'D75'),(2,'D75');
/*!40000 ALTER TABLE `promociones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuestas`
--

DROP TABLE IF EXISTS `respuestas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuestas` (
  `idRespuesta` int(11) NOT NULL AUTO_INCREMENT,
  `p_idpregunta` int(11) NOT NULL,
  `Respuesta` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Solucion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Puntaje` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idRespuesta`),
  KEY `fk_Respuestas_preguntas1_idx` (`p_idpregunta`),
  CONSTRAINT `fk_Respuestas_preguntas1` FOREIGN KEY (`p_idpregunta`) REFERENCES `preguntas` (`idpregunta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuestas`
--

LOCK TABLES `respuestas` WRITE;
/*!40000 ALTER TABLE `respuestas` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuestas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `templetes`
--

DROP TABLE IF EXISTS `templetes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `templetes` (
  `idtempletes` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `imagen` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idtempletes`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `templetes`
--

LOCK TABLES `templetes` WRITE;
/*!40000 ALTER TABLE `templetes` DISABLE KEYS */;
INSERT INTO `templetes` VALUES (1,'sala 1','imagen'),(2,'sala 1','imagen');
/*!40000 ALTER TABLE `templetes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idusuarios` int(11) NOT NULL AUTO_INCREMENT,
  `idPerfil` int(11) NOT NULL,
  `userName` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `userPass` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idusuarios`),
  KEY `fk_usuarios_perfil1_idx` (`idPerfil`),
  CONSTRAINT `fk_usuarios_perfil1` FOREIGN KEY (`idPerfil`) REFERENCES `perfil` (`idPerfil`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-13 12:12:39
