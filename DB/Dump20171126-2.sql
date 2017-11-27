-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: db_sigecu
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

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
  `aTelefono` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `aEmail` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `e_idEmpresa` int(11) NOT NULL,
  `aCarrera` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `aNotebook` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `aStatus` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `u_idusers` int(11) NOT NULL,
  PRIMARY KEY (`idalumno`,`u_idusers`),
  KEY `fk_alumno_empresa1_idx` (`e_idEmpresa`),
  KEY `fk_alumno_users1_idx` (`u_idusers`),
  CONSTRAINT `fk_alumno_empresa1` FOREIGN KEY (`e_idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_alumno_users1` FOREIGN KEY (`u_idusers`) REFERENCES `users` (`idusers`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (2,'Jorge','Casas','Avila','4425226986','avilaj@gmail.com',3,'ISC','si','1',2);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno_has_diploma`
--

DROP TABLE IF EXISTS `alumno_has_diploma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno_has_diploma` (
  `a_idalumno` int(11) NOT NULL AUTO_INCREMENT,
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
  `confirmado` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `activo` int(2) DEFAULT NULL,
  PRIMARY KEY (`a_idalumno`,`e_idevento`),
  KEY `fk_alumno_has_eventos_eventos1_idx` (`e_idevento`),
  KEY `fk_alumno_has_eventos_alumno1_idx` (`a_idalumno`),
  CONSTRAINT `fk_alumno_has_eventos_alumno1` FOREIGN KEY (`a_idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_alumno_has_eventos_eventos1` FOREIGN KEY (`e_idevento`) REFERENCES `eventos` (`idevento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_has_eventos`
--

LOCK TABLES `alumno_has_eventos` WRITE;
/*!40000 ALTER TABLE `alumno_has_eventos` DISABLE KEYS */;
INSERT INTO `alumno_has_eventos` VALUES (2,50,'0',1);
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
  `cNombre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `p_idPais` int(11) NOT NULL,
  PRIMARY KEY (`idCiudad`),
  KEY `fk_ciudad_pais1_idx` (`p_idPais`),
  CONSTRAINT `fk_ciudad_pais1` FOREIGN KEY (`p_idPais`) REFERENCES `pais` (`idPais`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (4,'Querétaro',3),(5,'San Luis Potosi',3);
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
  `cNombre` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `cDescripcion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idcursos`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'Certificacion CCNA2','Curso de certificacion para CCNA'),(2,'Fundamentos de Big Data','Curso  Big Data');
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos_has_especialidad1`
--

DROP TABLE IF EXISTS `cursos_has_especialidad1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursos_has_especialidad1` (
  `c_idcursos` int(11) NOT NULL,
  `e_idespecialidad` int(11) NOT NULL,
  PRIMARY KEY (`c_idcursos`,`e_idespecialidad`),
  KEY `fk_cursos_has_especialidad1_especialidad1_idx` (`e_idespecialidad`),
  KEY `fk_cursos_has_especialidad1_cursos1_idx` (`c_idcursos`),
  CONSTRAINT `fk_cursos_has_especialidad1_cursos1` FOREIGN KEY (`c_idcursos`) REFERENCES `cursos` (`idcursos`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cursos_has_especialidad1_especialidad1` FOREIGN KEY (`e_idespecialidad`) REFERENCES `especialidad` (`idespecialidad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos_has_especialidad1`
--

LOCK TABLES `cursos_has_especialidad1` WRITE;
/*!40000 ALTER TABLE `cursos_has_especialidad1` DISABLE KEYS */;
/*!40000 ALTER TABLE `cursos_has_especialidad1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destinatario`
--

DROP TABLE IF EXISTS `destinatario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `destinatario` (
  `iddestinatario` int(11) NOT NULL AUTO_INCREMENT,
  `dNombre` varchar(45) DEFAULT NULL,
  `dDescripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iddestinatario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destinatario`
--

LOCK TABLES `destinatario` WRITE;
/*!40000 ALTER TABLE `destinatario` DISABLE KEYS */;
INSERT INTO `destinatario` VALUES (1,'individual','eventos publicos  persona interesada'),(2,'grupo','eventos dirigidos al sector privado');
/*!40000 ALTER TABLE `destinatario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diploma`
--

DROP TABLE IF EXISTS `diploma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diploma` (
  `iddiploma` int(11) NOT NULL AUTO_INCREMENT,
  `dNombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `dCurso` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `dFecha` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
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
  `eNombre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `eEmail` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `eTelefono` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `edireccion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idEmpresa`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (2,'DMV','hr@dvm.com','4425226898','sn'),(3,'ninguna','ejemplo@dominio.com','4425226898','sn');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidad`
--

DROP TABLE IF EXISTS `especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especialidad` (
  `idespecialidad` int(11) NOT NULL AUTO_INCREMENT,
  `eNombre` varchar(45) DEFAULT NULL,
  `eDescripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idespecialidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidad`
--

LOCK TABLES `especialidad` WRITE;
/*!40000 ALTER TABLE `especialidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `especialidad` ENABLE KEYS */;
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
  `eNombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `eFechaInicio` date NOT NULL,
  `eFechaFin` date NOT NULL,
  `eTiempo` time NOT NULL,
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
  `cursos_idcursos` int(11) NOT NULL,
  `i_idinstructor` int(11) NOT NULL,
  `eDescripcion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `eFechaInicio` date DEFAULT NULL,
  `eFechaTermino` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ePrograma` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `eHorario` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `lugar_idlugar` int(11) NOT NULL,
  `t_idtempletes` int(11) NOT NULL,
  `eCapacidad` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `eTipo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `eEstatus` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idevento`,`lugar_idlugar`,`t_idtempletes`),
  KEY `fk_eventos_instructor1_idx` (`i_idinstructor`),
  KEY `fk_eventos_lugar1_idx` (`lugar_idlugar`),
  KEY `fk_eventos_cursos1_idx` (`cursos_idcursos`),
  KEY `fk_eventos_templetes1_idx` (`t_idtempletes`),
  CONSTRAINT `fk_eventos_cursos1` FOREIGN KEY (`cursos_idcursos`) REFERENCES `cursos` (`idcursos`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_eventos_instructor1` FOREIGN KEY (`i_idinstructor`) REFERENCES `instructor` (`idinstructor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_eventos_lugar1` FOREIGN KEY (`lugar_idlugar`) REFERENCES `lugar` (`idlugar`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_eventos_templetes1` FOREIGN KEY (`t_idtempletes`) REFERENCES `templetes` (`idtempletes`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
INSERT INTO `eventos` VALUES (50,1,4,'Cursos para certificacion','2017-12-10','2018-03-10','Por definir','12:00',1,3,'20','publico','on');
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventos_has_promociones`
--

DROP TABLE IF EXISTS `eventos_has_promociones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventos_has_promociones` (
  `e_idevento` int(11) NOT NULL,
  `p_idpromociones` int(11) NOT NULL,
  PRIMARY KEY (`e_idevento`,`p_idpromociones`),
  KEY `fk_eventos_has_promociones_promociones1_idx` (`p_idpromociones`),
  KEY `fk_eventos_has_promociones_eventos1_idx` (`e_idevento`),
  CONSTRAINT `fk_eventos_has_promociones_eventos1` FOREIGN KEY (`e_idevento`) REFERENCES `eventos` (`idevento`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_eventos_has_promociones_promociones1` FOREIGN KEY (`p_idpromociones`) REFERENCES `promociones` (`idpromociones`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos_has_promociones`
--

LOCK TABLES `eventos_has_promociones` WRITE;
/*!40000 ALTER TABLE `eventos_has_promociones` DISABLE KEYS */;
INSERT INTO `eventos_has_promociones` VALUES (50,3);
/*!40000 ALTER TABLE `eventos_has_promociones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventos_precios_destinatarios`
--

DROP TABLE IF EXISTS `eventos_precios_destinatarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventos_precios_destinatarios` (
  `d_iddestinatario` int(11) NOT NULL,
  `p_idprecios` int(11) NOT NULL,
  `e_idevento` int(11) NOT NULL,
  PRIMARY KEY (`d_iddestinatario`,`p_idprecios`,`e_idevento`),
  KEY `fk_destinatario_has_precios_precios1_idx` (`p_idprecios`),
  KEY `fk_destinatario_has_precios_destinatario1_idx` (`d_iddestinatario`),
  KEY `fk_destinatario_has_precios_eventos1_idx` (`e_idevento`),
  CONSTRAINT `fk_destinatario_has_precios_destinatario1` FOREIGN KEY (`d_iddestinatario`) REFERENCES `destinatario` (`iddestinatario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_destinatario_has_precios_eventos1` FOREIGN KEY (`e_idevento`) REFERENCES `eventos` (`idevento`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_destinatario_has_precios_precios1` FOREIGN KEY (`p_idprecios`) REFERENCES `precios` (`idprecios`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos_precios_destinatarios`
--

LOCK TABLES `eventos_precios_destinatarios` WRITE;
/*!40000 ALTER TABLE `eventos_precios_destinatarios` DISABLE KEYS */;
INSERT INTO `eventos_precios_destinatarios` VALUES (1,1,50);
/*!40000 ALTER TABLE `eventos_precios_destinatarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historialPagos`
--

DROP TABLE IF EXISTS `historialPagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historialPagos` (
  `idhistorialPagos` int(11) NOT NULL AUTO_INCREMENT,
  `ahe_a_idalumno` int(11) NOT NULL,
  `ahe_e_idevento` int(11) NOT NULL,
  `pagoCompleto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idhistorialPagos`),
  KEY `fk_historialPagos_alumno_has_eventos1_idx` (`ahe_a_idalumno`,`ahe_e_idevento`),
  CONSTRAINT `fk_historialPagos_alumno_has_eventos1` FOREIGN KEY (`ahe_a_idalumno`, `ahe_e_idevento`) REFERENCES `alumno_has_eventos` (`a_idalumno`, `e_idevento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historialPagos`
--

LOCK TABLES `historialPagos` WRITE;
/*!40000 ALTER TABLE `historialPagos` DISABLE KEYS */;
INSERT INTO `historialPagos` VALUES (4,2,50,'0');
/*!40000 ALTER TABLE `historialPagos` ENABLE KEYS */;
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
  `iEmail` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iTelefono` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iDireccion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `u_idusers` int(11) NOT NULL,
  PRIMARY KEY (`idinstructor`),
  KEY `fk_instructor_users1_idx` (`u_idusers`),
  CONSTRAINT `fk_instructor_users1` FOREIGN KEY (`u_idusers`) REFERENCES `users` (`idusers`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (4,'Brayan','Sanchez','Roa','ISC','elbrayan@gmail.com','4425226986','menchaca 1',3);
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor_has_especialidad`
--

DROP TABLE IF EXISTS `instructor_has_especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instructor_has_especialidad` (
  `i_idinstructor` int(11) NOT NULL,
  `e_idespecialidad` int(11) NOT NULL,
  PRIMARY KEY (`i_idinstructor`,`e_idespecialidad`),
  KEY `fk_instructor_has_especialidad_especialidad1_idx` (`e_idespecialidad`),
  KEY `fk_instructor_has_especialidad_instructor1_idx` (`i_idinstructor`),
  CONSTRAINT `fk_instructor_has_especialidad_especialidad1` FOREIGN KEY (`e_idespecialidad`) REFERENCES `especialidad` (`idespecialidad`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_instructor_has_especialidad_instructor1` FOREIGN KEY (`i_idinstructor`) REFERENCES `instructor` (`idinstructor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor_has_especialidad`
--

LOCK TABLES `instructor_has_especialidad` WRITE;
/*!40000 ALTER TABLE `instructor_has_especialidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `instructor_has_especialidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lugar`
--

DROP TABLE IF EXISTS `lugar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lugar` (
  `idlugar` int(11) NOT NULL AUTO_INCREMENT,
  `lNombre` varchar(45) DEFAULT NULL,
  `lDescripcion` varchar(45) DEFAULT NULL,
  `c_idCiudad` int(11) NOT NULL,
  PRIMARY KEY (`idlugar`,`c_idCiudad`),
  KEY `fk_lugar_ciudad1_idx` (`c_idCiudad`),
  CONSTRAINT `fk_lugar_ciudad1` FOREIGN KEY (`c_idCiudad`) REFERENCES `ciudad` (`idCiudad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugar`
--

LOCK TABLES `lugar` WRITE;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
INSERT INTO `lugar` VALUES (1,'Sede Querétaro','sin descripcion',4),(2,'Sede San Luis Potosi','sin descripcion',5);
/*!40000 ALTER TABLE `lugar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materiales`
--

DROP TABLE IF EXISTS `materiales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materiales` (
  `idmaterial` int(11) NOT NULL AUTO_INCREMENT,
  `c_idcursos` int(11) NOT NULL,
  `mNombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `mDescripcion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `mRuta` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
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
  `tP_idtipoPago` int(11) NOT NULL,
  `pCantidad` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pFecha` date DEFAULT NULL,
  `pStatus` int(11) DEFAULT NULL,
  `hP_idhistorialPagos` int(11) NOT NULL,
  PRIMARY KEY (`idpagos`,`hP_idhistorialPagos`),
  KEY `fk_pagos_historialPagos1_idx` (`hP_idhistorialPagos`),
  KEY `fk_pagos_tipoPago1_idx` (`tP_idtipoPago`),
  CONSTRAINT `fk_pagos_historialPagos1` FOREIGN KEY (`hP_idhistorialPagos`) REFERENCES `historialPagos` (`idhistorialPagos`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pagos_tipoPago1` FOREIGN KEY (`tP_idtipoPago`) REFERENCES `tipoPago` (`idtipoPago`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
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
  `pNombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `pRegion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (3,'México','centro');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `precios`
--

DROP TABLE IF EXISTS `precios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `precios` (
  `idprecios` int(11) NOT NULL AUTO_INCREMENT,
  `precio` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idprecios`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `precios`
--

LOCK TABLES `precios` WRITE;
/*!40000 ALTER TABLE `precios` DISABLE KEYS */;
INSERT INTO `precios` VALUES (1,'5000'),(2,'8000');
/*!40000 ALTER TABLE `precios` ENABLE KEYS */;
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
  `pPregunta` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
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
  `nombre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idpromociones`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promociones`
--

LOCK TABLES `promociones` WRITE;
/*!40000 ALTER TABLE `promociones` DISABLE KEYS */;
INSERT INTO `promociones` VALUES (3,'20%');
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
  `rRespuesta` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `rSolucion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `rPuntaje` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
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
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `idroles` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `role` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `u_idusers` int(11) NOT NULL,
  PRIMARY KEY (`idroles`),
  KEY `fk_roles_users1_idx` (`u_idusers`),
  CONSTRAINT `fk_roles_users1` FOREIGN KEY (`u_idusers`) REFERENCES `users` (`idusers`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'rcastillo','comercial','encargado de registro de nuevos eventos',1),(2,'josh','alumno','alumno inscrito',2),(3,'brayan','instructor','instructor de CCNA',3);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `templetes`
--

DROP TABLE IF EXISTS `templetes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `templetes` (
  `idtempletes` int(11) NOT NULL AUTO_INCREMENT,
  `tDescripcion` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tImagen` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idtempletes`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `templetes`
--

LOCK TABLES `templetes` WRITE;
/*!40000 ALTER TABLE `templetes` DISABLE KEYS */;
INSERT INTO `templetes` VALUES (3,'Herradura','sin imagen'),(4,'Aula','sin imagen'),(5,'Auditorio','sin imagen');
/*!40000 ALTER TABLE `templetes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoPago`
--

DROP TABLE IF EXISTS `tipoPago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoPago` (
  `idtipoPago` int(11) NOT NULL AUTO_INCREMENT,
  `tpNombre` varchar(45) DEFAULT NULL,
  `tpDatos` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipoPago`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoPago`
--

LOCK TABLES `tipoPago` WRITE;
/*!40000 ALTER TABLE `tipoPago` DISABLE KEYS */;
INSERT INTO `tipoPago` VALUES (1,'tarjeta','tarjeta de credito o debito'),(2,'efectivo','8574285785445'),(3,'efectivo','8574285785445'),(4,'cheque','En cuenta de cheques');
/*!40000 ALTER TABLE `tipoPago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `idusers` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `utelefono` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `imagen` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`idusers`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Rolando Castillo','castillomartinez@acm.org','4425226986','rcastillo','63a9f0ea7bb98050796b649e85481845','sin imagen'),(2,'Jorge','josh@gmail.comorg','4425226986','josh','63a9f0ea7bb98050796b649e85481845','sin imagen'),(3,'Brayan Sanchez','elbrayan@gmail.com','4425226986','brayan','63a9f0ea7bb98050796b649e85481845','sin imagen');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-26 18:22:19
