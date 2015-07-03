CREATE DATABASE  IF NOT EXISTS `oas` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
CREATE USER 'oas'@'localhost' IDENTIFIED BY 'mysql';
GRANT USAGE ON *.* TO 'oas'@'localhost' IDENTIFIED BY 'mysql' WITH MAX_QUERIES_PER_HOUR 0 
MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
GRANT ALL PRIVILEGES ON `oas`.* TO 'oas'@'localhost';
USE `oas`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: oas
-- ------------------------------------------------------
-- Server version	5.6.22-log

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
-- Table structure for table `act_ge_bytearray`
--

DROP TABLE IF EXISTS `act_ge_bytearray`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ge_bytearray` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTES_` longblob,
  `GENERATED_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_BYTEARR_DEPL` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_BYTEARR_DEPL` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ge_bytearray`
--

LOCK TABLES `act_ge_bytearray` WRITE;
/*!40000 ALTER TABLE `act_ge_bytearray` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ge_bytearray` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ge_property`
--

DROP TABLE IF EXISTS `act_ge_property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ge_property` (
  `NAME_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `VALUE_` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ge_property`
--

LOCK TABLES `act_ge_property` WRITE;
/*!40000 ALTER TABLE `act_ge_property` DISABLE KEYS */;
INSERT INTO `act_ge_property` VALUES ('historyLevel','2',1),('next.dbid','1',1),('schema.history','create(5.10)',1),('schema.version','5.10',1);
/*!40000 ALTER TABLE `act_ge_property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_actinst`
--

DROP TABLE IF EXISTS `act_hi_actinst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_actinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin NOT NULL,
  `ACT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ACT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `ASSIGNEE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime NOT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_ACT_INST_START` (`START_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_END` (`END_TIME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_actinst`
--

LOCK TABLES `act_hi_actinst` WRITE;
/*!40000 ALTER TABLE `act_hi_actinst` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_actinst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_attachment`
--

DROP TABLE IF EXISTS `act_hi_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_attachment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `URL_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CONTENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_attachment`
--

LOCK TABLES `act_hi_attachment` WRITE;
/*!40000 ALTER TABLE `act_hi_attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_comment`
--

DROP TABLE IF EXISTS `act_hi_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_comment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime NOT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `MESSAGE_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `FULL_MSG_` longblob,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_comment`
--

LOCK TABLES `act_hi_comment` WRITE;
/*!40000 ALTER TABLE `act_hi_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_detail`
--

DROP TABLE IF EXISTS `act_hi_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_detail` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TIME_` datetime NOT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_DETAIL_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_ACT_INST` (`ACT_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_TIME` (`TIME_`),
  KEY `ACT_IDX_HI_DETAIL_NAME` (`NAME_`),
  KEY `ACT_IDX_HI_DETAIL_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_detail`
--

LOCK TABLES `act_hi_detail` WRITE;
/*!40000 ALTER TABLE `act_hi_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_procinst`
--

DROP TABLE IF EXISTS `act_hi_procinst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_procinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `START_TIME_` datetime NOT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `END_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `PROC_INST_ID_` (`PROC_INST_ID_`),
  UNIQUE KEY `ACT_UNIQ_HI_BUS_KEY` (`PROC_DEF_ID_`,`BUSINESS_KEY_`),
  KEY `ACT_IDX_HI_PRO_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_PRO_I_BUSKEY` (`BUSINESS_KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_procinst`
--

LOCK TABLES `act_hi_procinst` WRITE;
/*!40000 ALTER TABLE `act_hi_procinst` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_procinst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_taskinst`
--

DROP TABLE IF EXISTS `act_hi_taskinst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_taskinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime NOT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `DUE_DATE_` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_taskinst`
--

LOCK TABLES `act_hi_taskinst` WRITE;
/*!40000 ALTER TABLE `act_hi_taskinst` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_taskinst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_id_group`
--

DROP TABLE IF EXISTS `act_id_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_id_group` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_id_group`
--

LOCK TABLES `act_id_group` WRITE;
/*!40000 ALTER TABLE `act_id_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_id_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_id_info`
--

DROP TABLE IF EXISTS `act_id_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_id_info` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VALUE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PASSWORD_` longblob,
  `PARENT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_id_info`
--

LOCK TABLES `act_id_info` WRITE;
/*!40000 ALTER TABLE `act_id_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_id_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_id_membership`
--

DROP TABLE IF EXISTS `act_id_membership`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_id_membership` (
  `USER_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`USER_ID_`,`GROUP_ID_`),
  KEY `ACT_FK_MEMB_GROUP` (`GROUP_ID_`),
  CONSTRAINT `ACT_FK_MEMB_GROUP` FOREIGN KEY (`GROUP_ID_`) REFERENCES `act_id_group` (`ID_`),
  CONSTRAINT `ACT_FK_MEMB_USER` FOREIGN KEY (`USER_ID_`) REFERENCES `act_id_user` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_id_membership`
--

LOCK TABLES `act_id_membership` WRITE;
/*!40000 ALTER TABLE `act_id_membership` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_id_membership` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_id_user`
--

DROP TABLE IF EXISTS `act_id_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_id_user` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `FIRST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LAST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EMAIL_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PWD_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PICTURE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_id_user`
--

LOCK TABLES `act_id_user` WRITE;
/*!40000 ALTER TABLE `act_id_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_id_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_re_deployment`
--

DROP TABLE IF EXISTS `act_re_deployment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_re_deployment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOY_TIME_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_re_deployment`
--

LOCK TABLES `act_re_deployment` WRITE;
/*!40000 ALTER TABLE `act_re_deployment` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_re_deployment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_re_procdef`
--

DROP TABLE IF EXISTS `act_re_procdef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_re_procdef` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VERSION_` int(11) DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DGRM_RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `HAS_START_FORM_KEY_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_PROCDEF` (`KEY_`,`VERSION_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_re_procdef`
--

LOCK TABLES `act_re_procdef` WRITE;
/*!40000 ALTER TABLE `act_re_procdef` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_re_procdef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_event_subscr`
--

DROP TABLE IF EXISTS `act_ru_event_subscr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_event_subscr` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `EVENT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EVENT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTIVITY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CONFIGURATION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EVENT_SUBSCR_CONFIG_` (`CONFIGURATION_`),
  KEY `ACT_FK_EVENT_EXEC` (`EXECUTION_ID_`),
  CONSTRAINT `ACT_FK_EVENT_EXEC` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_event_subscr`
--

LOCK TABLES `act_ru_event_subscr` WRITE;
/*!40000 ALTER TABLE `act_ru_event_subscr` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_event_subscr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_execution`
--

DROP TABLE IF EXISTS `act_ru_execution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_execution` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_EXEC_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `IS_ACTIVE_` tinyint(4) DEFAULT NULL,
  `IS_CONCURRENT_` tinyint(4) DEFAULT NULL,
  `IS_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_EVENT_SCOPE_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `CACHED_ENT_STATE_` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_RU_BUS_KEY` (`PROC_DEF_ID_`,`BUSINESS_KEY_`),
  KEY `ACT_IDX_EXEC_BUSKEY` (`BUSINESS_KEY_`),
  KEY `ACT_FK_EXE_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PARENT` (`PARENT_ID_`),
  KEY `ACT_FK_EXE_SUPER` (`SUPER_EXEC_`),
  CONSTRAINT `ACT_FK_EXE_PARENT` FOREIGN KEY (`PARENT_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ACT_FK_EXE_SUPER` FOREIGN KEY (`SUPER_EXEC_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_execution`
--

LOCK TABLES `act_ru_execution` WRITE;
/*!40000 ALTER TABLE `act_ru_execution` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_execution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_identitylink`
--

DROP TABLE IF EXISTS `act_ru_identitylink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `GROUP_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_IDENT_LNK_GROUP` (`GROUP_ID_`),
  KEY `ACT_IDX_ATHRZ_PROCEDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_TSKASS_TASK` (`TASK_ID_`),
  CONSTRAINT `ACT_FK_ATHRZ_PROCEDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_TSKASS_TASK` FOREIGN KEY (`TASK_ID_`) REFERENCES `act_ru_task` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_identitylink`
--

LOCK TABLES `act_ru_identitylink` WRITE;
/*!40000 ALTER TABLE `act_ru_identitylink` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_identitylink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_job`
--

DROP TABLE IF EXISTS `act_ru_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_job`
--

LOCK TABLES `act_ru_job` WRITE;
/*!40000 ALTER TABLE `act_ru_job` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_task`
--

DROP TABLE IF EXISTS `act_ru_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_task` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DELEGATION_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `CREATE_TIME_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DUE_DATE_` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_TASK_CREATE` (`CREATE_TIME_`),
  KEY `ACT_FK_TASK_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_TASK_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_TASK_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_TASK_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_task`
--

LOCK TABLES `act_ru_task` WRITE;
/*!40000 ALTER TABLE `act_ru_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_variable`
--

DROP TABLE IF EXISTS `act_ru_variable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_variable` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_VARIABLE_TASK_ID` (`TASK_ID_`),
  KEY `ACT_FK_VAR_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_VAR_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_VAR_BYTEARRAY` (`BYTEARRAY_ID_`),
  CONSTRAINT `ACT_FK_VAR_BYTEARRAY` FOREIGN KEY (`BYTEARRAY_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_variable`
--

LOCK TABLES `act_ru_variable` WRITE;
/*!40000 ALTER TABLE `act_ru_variable` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_variable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_dm_htlb`
--

DROP TABLE IF EXISTS `glxt_dm_htlb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_dm_htlb` (
  `HTLB_DM` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `HTLB_MC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISENABLED` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`HTLB_DM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_dm_htlb`
--

LOCK TABLES `glxt_dm_htlb` WRITE;
/*!40000 ALTER TABLE `glxt_dm_htlb` DISABLE KEYS */;
/*!40000 ALTER TABLE `glxt_dm_htlb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_dm_zjrb_kx_type`
--

DROP TABLE IF EXISTS `glxt_dm_zjrb_kx_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_dm_zjrb_kx_type` (
  `KX_TYPE_DM` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `KX_TYPE_MC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`KX_TYPE_DM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_dm_zjrb_kx_type`
--

LOCK TABLES `glxt_dm_zjrb_kx_type` WRITE;
/*!40000 ALTER TABLE `glxt_dm_zjrb_kx_type` DISABLE KEYS */;
INSERT INTO `glxt_dm_zjrb_kx_type` VALUES ('A','银行存款'),('B','现金'),('C','银行卡'),('D','承兑');
/*!40000 ALTER TABLE `glxt_dm_zjrb_kx_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_dm_zjrb_xm`
--

DROP TABLE IF EXISTS `glxt_dm_zjrb_xm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_dm_zjrb_xm` (
  `ZJRB_XM_DM` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ZJRB_XM_MC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ZJRB_XM_TYPE_DM` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ZJRB_XM_DM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_dm_zjrb_xm`
--

LOCK TABLES `glxt_dm_zjrb_xm` WRITE;
/*!40000 ALTER TABLE `glxt_dm_zjrb_xm` DISABLE KEYS */;
INSERT INTO `glxt_dm_zjrb_xm` VALUES ('1001','预收款','1'),('1002','工程款','1'),('1003','质保金','1'),('1004','收往来','2'),('1005','还借款','2'),('1006','收押金','2'),('1007','人工费','3'),('1008','机械费','3'),('1009','租金','3'),('1010','运费','3'),('1011','修理费','3'),('1012','原材料','3'),('1013','耗用材料','3'),('1014','燃油','3'),('1015','煤','3'),('1016','检测检验费','3'),('1017','其他','3'),('1018','税金','4'),('1019','工资','4'),('1020','办公费','4'),('1021','差旅费','4'),('1022','通讯费','4'),('1023','招待费','4'),('1024','员工餐费','4'),('1025','搬运费','4'),('1026','水电费','4'),('1027','汽车费','4'),('1028','财务费用','4'),('1029','租金','4'),('1030','其他','4'),('1031','还往来款','5'),('1032','付出押金','5'),('1033','员工借款','5');
/*!40000 ALTER TABLE `glxt_dm_zjrb_xm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_dm_zjrb_xm_type`
--

DROP TABLE IF EXISTS `glxt_dm_zjrb_xm_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_dm_zjrb_xm_type` (
  `XM_TYPE_DM` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `XM_TYPE_MC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`XM_TYPE_DM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_dm_zjrb_xm_type`
--

LOCK TABLES `glxt_dm_zjrb_xm_type` WRITE;
/*!40000 ALTER TABLE `glxt_dm_zjrb_xm_type` DISABLE KEYS */;
INSERT INTO `glxt_dm_zjrb_xm_type` VALUES ('1','回款-工程收入'),('10','付款-现金转出'),('11','付款-银行卡转出'),('2','回款-其他'),('3','付款-直接费用'),('4','付款-间接费用'),('5','付款-其他'),('6','回款-银行存款'),('7','回款-现金转入'),('8','回款-银行卡转入'),('9','付款-银行存款');
/*!40000 ALTER TABLE `glxt_dm_zjrb_xm_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_dm_zy`
--

DROP TABLE IF EXISTS `glxt_dm_zy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_dm_zy` (
  `ZY_DM` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ISENABLED` tinyint(1) DEFAULT NULL,
  `ZY_JB` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ZY_MC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ZY_SJ_DM` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ZY_DM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_dm_zy`
--

LOCK TABLES `glxt_dm_zy` WRITE;
/*!40000 ALTER TABLE `glxt_dm_zy` DISABLE KEYS */;
INSERT INTO `glxt_dm_zy` VALUES ('0001',1,'1','材料','0000'),('0002',1,'1','劳务','0000'),('0003',1,'1','机械','0000'),('0004',1,'1','零件','0000'),('0005',1,'1','其它','0000'),('0006',1,'2','沙石','0001'),('0007',1,'2','山皮石','0001'),('0008',1,'2','人力','0002'),('0009',1,'2','挖掘机','0003'),('0010',1,'2','5号钉','0004'),('0011',1,'2','办公用品','0005');
/*!40000 ALTER TABLE `glxt_dm_zy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_fkdo`
--

DROP TABLE IF EXISTS `glxt_fkdo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_fkdo` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `FKJE` double DEFAULT NULL,
  `FKRQ` datetime DEFAULT NULL,
  `FKTZD_ID` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISENABLED` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_fkdo`
--

LOCK TABLES `glxt_fkdo` WRITE;
/*!40000 ALTER TABLE `glxt_fkdo` DISABLE KEYS */;
/*!40000 ALTER TABLE `glxt_fkdo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_fktzd`
--

DROP TABLE IF EXISTS `glxt_fktzd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_fktzd` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `SCSJ` datetime DEFAULT NULL,
  `DYCS` int(11) DEFAULT NULL,
  `ISENABLED` tinyint(1) NOT NULL,
  `SQDO_ID` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_fktzd`
--

LOCK TABLES `glxt_fktzd` WRITE;
/*!40000 ALTER TABLE `glxt_fktzd` DISABLE KEYS */;
INSERT INTO `glxt_fktzd` VALUES ('11111134358589167992','2015-06-22 18:39:10',0,1,'11111119284159069492');
/*!40000 ALTER TABLE `glxt_fktzd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_hetong`
--

DROP TABLE IF EXISTS `glxt_hetong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_hetong` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `BCRQ` datetime DEFAULT NULL,
  `GYS` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HTBH` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `HTLX` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HTMC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HTZJ` double DEFAULT NULL,
  `ISENABLED` tinyint(1) NOT NULL,
  `JBR` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `JSDWMC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `KZR` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `RQ` datetime DEFAULT NULL,
  `TBR` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TBRQ` datetime DEFAULT NULL,
  `XM_ID` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `XMMC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_hetong`
--

LOCK TABLES `glxt_hetong` WRITE;
/*!40000 ALTER TABLE `glxt_hetong` DISABLE KEYS */;
INSERT INTO `glxt_hetong` VALUES ('11111115221312625668',NULL,'','项目一-材料-00002','0001','项目一-材料-00002',213400,1,'经办人','','','2015-06-22 00:00:00','','2015-06-22 13:20:12','11111139763039816337','项目一'),('11111121187233919297',NULL,'','项目一-劳务-00001','0002','项目一-劳务-00001',213400,1,'经办人','','','2015-06-22 00:00:00','','2015-06-22 14:59:38','11111139763039816337','项目一'),('11111142746743710696',NULL,'','项目一-材料-00001','0001','项目一-材料-00001',213400,1,'经办人','','','2015-06-21 00:00:00','','2015-06-21 23:18:27','11111139763039816337','项目一'),('11111150219890475647',NULL,'','项目一-机械-00001','0003','项目一-机械-00001',213400,1,'经办人','','','2015-06-22 00:00:00','','2015-06-22 23:03:31','11111139763039816337','项目一');
/*!40000 ALTER TABLE `glxt_hetong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_hetong_mx`
--

DROP TABLE IF EXISTS `glxt_hetong_mx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_hetong_mx` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `BCCS` int(11) DEFAULT NULL,
  `DJ` double DEFAULT NULL,
  `DW` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `guige` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HTBH` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISENABLED` tinyint(1) NOT NULL,
  `SL` int(11) DEFAULT NULL,
  `ZJ` double DEFAULT NULL,
  `ZYDM` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ZYMC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_hetong_mx`
--

LOCK TABLES `glxt_hetong_mx` WRITE;
/*!40000 ALTER TABLE `glxt_hetong_mx` DISABLE KEYS */;
INSERT INTO `glxt_hetong_mx` VALUES ('11111115220932325866',0,5800,'吨','规格1','项目一-材料-00002',1,13,75400,'','沙石'),('11111115221157698051',0,9200,'吨','规格2','项目一-材料-00002',1,15,138000,'','山皮石'),('11111121186844856183',0,9200,'吨','规格2','项目一-劳务-00001',1,15,138000,'','山皮石'),('11111121187068390440',0,5800,'吨','规格1','项目一-劳务-00001',1,13,75400,'','沙石'),('11111142746303229975',0,9200,'吨','规格2','项目一-材料-00001',1,15,138000,'','山皮石'),('11111142746479948242',0,5800,'吨','规格1','项目一-材料-00001',1,13,75400,'','沙石'),('11111150219567483149',0,9200,'吨','规格2','项目一-机械-00001',1,15,138000,'','山皮石'),('11111150219770269740',0,5800,'吨','规格1','项目一-机械-00001',1,13,75400,'','沙石');
/*!40000 ALTER TABLE `glxt_hetong_mx` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_hthb`
--

DROP TABLE IF EXISTS `glxt_hthb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_hthb` (
  `HBBH` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `HTHB_HT_FILES` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HTHB_HT_FILES_DATE` datetime DEFAULT NULL,
  `ISENABLED` tinyint(1) NOT NULL,
  `HTHB_SH_FilE_A` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HTHB_SH_FilE_A_DATE` datetime DEFAULT NULL,
  `HTHB_SH_FilE_B` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HTHB_SH_FilE_B_DATE` datetime DEFAULT NULL,
  `HTHB_SHR_A` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HTHB_SHR_B` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `XM_ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`HBBH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_hthb`
--

LOCK TABLES `glxt_hthb` WRITE;
/*!40000 ALTER TABLE `glxt_hthb` DISABLE KEYS */;
INSERT INTO `glxt_hthb` VALUES ('11111141932363725891','\\11111141932363725891\\OA.sql;\\11111141932363725891\\20150524系统第一次验收报告.doc;\\11111141932363725891\\进场材料明细.xls;','2015-06-21 23:04:53',1,'\\11111141932363725891\\init.sql','2015-06-21 23:11:47','\\11111141932363725891\\init2.sql','2015-06-21 23:12:02','admin','admin','11111139763039816337');
/*!40000 ALTER TABLE `glxt_hthb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_jsd`
--

DROP TABLE IF EXISTS `glxt_jsd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_jsd` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `TBR` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CLZT` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DYCS` int(11) DEFAULT NULL,
  `HTBH` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ISENABLED` tinyint(1) NOT NULL,
  `JJSJ` datetime DEFAULT NULL,
  `JSDBH` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `LB` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `RQ` datetime DEFAULT NULL,
  `SHSJ` datetime DEFAULT NULL,
  `SHSM` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TBSJ` datetime DEFAULT NULL,
  `XM_ID` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `XMMC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `YSQBZ` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ZJE` double DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_jsd`
--

LOCK TABLES `glxt_jsd` WRITE;
/*!40000 ALTER TABLE `glxt_jsd` DISABLE KEYS */;
INSERT INTO `glxt_jsd` VALUES ('11111119283999341595',NULL,'00',0,'项目一-材料-00002',1,NULL,'项目一-材料-00002预授权00001',NULL,'2015-06-22 14:27:55',NULL,NULL,'2015-06-22 14:27:55',NULL,NULL,'Y',0),('11111121200071364932',NULL,'00',0,'项目一-劳务-00001',1,NULL,'项目一-劳务-00001-预授权-00001','预授权','2015-06-22 14:59:51',NULL,NULL,'2015-06-22 14:59:51',NULL,NULL,'Y',20000),('11111142767312424791',NULL,'00',0,'项目一-材料-00001',1,'2015-06-21 23:54:22','项目一-材料-00001-00001','材料','2015-06-21 00:00:00','2015-06-21 23:53:55',NULL,'2015-06-21 23:18:47',NULL,'项目一','N',59800000),('11111146394644752614',NULL,'00',0,'项目一-材料-00001',1,'2015-06-22 00:26:47','项目一-材料-00001-00002','材料','2015-06-22 00:00:00','2015-06-22 00:24:20',NULL,'2015-06-22 00:19:15',NULL,'项目一','N',37700000),('11111150237148042391',NULL,'00',0,'项目一-机械-00001',1,'2015-06-22 23:05:37','项目一-机械-00001-00001','机械','2015-06-22 00:00:00','2015-06-22 23:05:41',NULL,'2015-06-22 23:03:48',NULL,'项目一','N',37700000);
/*!40000 ALTER TABLE `glxt_jsd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_jsdmx`
--

DROP TABLE IF EXISTS `glxt_jsdmx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_jsdmx` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `JSD_MX_DJH` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `JSD_MX_GG` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISENABLED` tinyint(1) NOT NULL,
  `JSDBH` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `JSD_MX_SL` int(11) DEFAULT NULL,
  `JSD_MX_ZYDM` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_jsdmx`
--

LOCK TABLES `glxt_jsdmx` WRITE;
/*!40000 ALTER TABLE `glxt_jsdmx` DISABLE KEYS */;
INSERT INTO `glxt_jsdmx` VALUES ('11111142766572687415','1432','9200.0',1,'项目一-材料-00001-00001',2000,''),('11111142766696891899','1052','9200.0',1,'项目一-材料-00001-00001',3000,''),('11111142766961166603','1064','9200.0',1,'项目一-材料-00001-00001',500,''),('11111142767191255983','1431','9200.0',1,'项目一-材料-00001-00001',1000,''),('11111146393883882713','1431','5800.0',1,'项目一-材料-00001-00002',1000,''),('11111146394050914928','1432','5800.0',1,'项目一-材料-00001-00002',2000,''),('11111146394283895228','1052','5800.0',1,'项目一-材料-00001-00002',3000,''),('11111146394523706148','1064','5800.0',1,'项目一-材料-00001-00002',500,''),('11111150236505623984','1064','5800.0',1,'项目一-机械-00001-00001',500,''),('11111150236655871797','1431','5800.0',1,'项目一-机械-00001-00001',1000,''),('11111150236797891425','1052','5800.0',1,'项目一-机械-00001-00001',3000,''),('11111150236963104155','1432','5800.0',1,'项目一-机械-00001-00001',2000,'');
/*!40000 ALTER TABLE `glxt_jsdmx` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_qx_authority`
--

DROP TABLE IF EXISTS `glxt_qx_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_qx_authority` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `AUTH_DESC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISENABLED` tinyint(1) DEFAULT NULL,
  `AUTH_NAME` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_qx_authority`
--

LOCK TABLES `glxt_qx_authority` WRITE;
/*!40000 ALTER TABLE `glxt_qx_authority` DISABLE KEYS */;
INSERT INTO `glxt_qx_authority` VALUES ('11000000000000000002','管理员',1,'AUTH_ADMIN'),('11111139696267260415','统计员',1,'AUTH_TJY');
/*!40000 ALTER TABLE `glxt_qx_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_qx_authority_resource`
--

DROP TABLE IF EXISTS `glxt_qx_authority_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_qx_authority_resource` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `AUTHORITY_ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ISENABLED` tinyint(1) NOT NULL,
  `RESOURCE_ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_qx_authority_resource`
--

LOCK TABLES `glxt_qx_authority_resource` WRITE;
/*!40000 ALTER TABLE `glxt_qx_authority_resource` DISABLE KEYS */;
INSERT INTO `glxt_qx_authority_resource` VALUES ('11111139711532846330','11111139696267260415',1,'10000000000000000001'),('11111139711798851103','11111139696267260415',1,'10000000000000000002'),('11111139711931310421','11111139696267260415',1,'10000000000000000005'),('11111139712096672804','11111139696267260415',1,'10000000000000000006'),('11111139712216340350','11111139696267260415',1,'10000000000000000007'),('11111139712348584401','11111139696267260415',1,'10000000000000000008'),('11111139712688938718','11111139696267260415',1,'10000000000000000009'),('11111139712833598641','11111139696267260415',1,'10000000000000000015'),('11111150987752100948','11000000000000000002',1,'10000000000000000001'),('11111150987883682857','11000000000000000002',1,'10000000000000000002'),('11111150988015234880','11000000000000000002',1,'10000000000000000003'),('11111150988136680125','11000000000000000002',1,'10000000000000000004'),('11111150988268431072','11000000000000000002',1,'10000000000000000005'),('11111150988389100238','11000000000000000002',1,'10000000000000000006'),('11111150988521680964','11000000000000000002',1,'10000000000000000007'),('11111150988647893354','11000000000000000002',1,'10000000000000000008'),('11111150988773630852','11000000000000000002',1,'10000000000000000009'),('11111150988905276734','11000000000000000002',1,'10000000000000000010'),('11111150989022206989','11000000000000000002',1,'10000000000000000011'),('11111150989142063185','11000000000000000002',1,'10000000000000000012'),('11111150989278983793','11000000000000000002',1,'10000000000000000013'),('11111150989407383402','11000000000000000002',1,'10000000000000000014'),('11111150989533107825','11000000000000000002',1,'10000000000000000015'),('11111150989666669157','11000000000000000002',1,'10000000000000000016'),('11111150989783952430','11000000000000000002',1,'10000000000000000017'),('11111150989916698925','11000000000000000002',1,'10000000000000000018'),('11111150990048921029','11000000000000000002',1,'10000000000000000019'),('11111150990179876751','11000000000000000002',1,'10000000000000000020'),('11111150990323407110','11000000000000000002',1,'10000000000000000021'),('11111150990444857025','11000000000000000002',1,'10000000000000000022'),('11111150990576363287','11000000000000000002',1,'10000000000000000023'),('11111150990697687591','11000000000000000002',1,'10000000000000000024'),('11111150990867479978','11000000000000000002',1,'10000000000000000025'),('11111150991137091513','11000000000000000002',1,'10000000000000000026'),('11111150991302483781','11000000000000000002',1,'10000000000000000027');
/*!40000 ALTER TABLE `glxt_qx_authority_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_qx_resource`
--

DROP TABLE IF EXISTS `glxt_qx_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_qx_resource` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `RES_DESC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISENABLED` tinyint(1) DEFAULT NULL,
  `RES_NAME` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `RES_PRIORITY` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `RES_STRING` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `RES_TYPE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_qx_resource`
--

LOCK TABLES `glxt_qx_resource` WRITE;
/*!40000 ALTER TABLE `glxt_qx_resource` DISABLE KEYS */;
INSERT INTO `glxt_qx_resource` VALUES ('10000000000000000001','录入结算合同数据',1,'录入结算合同数据',NULL,'/ywgl/lrjshtsj/lrjshtsj.jsp','URL'),('10000000000000000002','上传合同',1,'上传合同',NULL,'/ywgl/scjsht/scjsht.jsp','URL'),('10000000000000000003','结算合同核备A',1,'结算合同核备A',NULL,'/ywgl/jshthb/jshthbA.jsp','URL'),('10000000000000000004','结算合同核备B',1,'结算合同核备B',NULL,'/ywgl/jshthb/jshthbB.jsp','URL'),('10000000000000000005','查看合同核备结果',1,'查看合同核备结果',NULL,'/ywgl/ckhthbjg/ckhthbjg.jsp','URL'),('10000000000000000006','录入结算单数据',1,'录入结算单数据',NULL,'/ywgl/lrjsdsj/lrjsdsj.jsp','URL'),('10000000000000000007','生成结算单',1,'生成结算单',NULL,'/ywgl/scjsd/scjsd.jsp','URL'),('10000000000000000008','查询结算单',1,'查询结算单',NULL,'/cxgl/cxjsd/cxjsd.jsp','URL'),('10000000000000000009','查询结算合同台账',1,'查询结算合同台账',NULL,'/cxgl/cxjshttz/cxjshttz.jsp','URL'),('10000000000000000010','确认复核结算单',1,'确认复核结算单',NULL,'/ywgl/qrfhjsd/qrfhjsd.jsp','URL'),('10000000000000000011','授权付款',1,'授权付款',NULL,'/ywgl/sqfk/sqfk.jsp','URL'),('10000000000000000012','预授权付款',1,'预授权付款',NULL,'/ywgl/ysqfk/ysqfk.jsp','URL'),('10000000000000000013','生成付款通知单',1,'生成付款通知单',NULL,'/ywgl/scfktzd/scfktzd.jsp','URL'),('10000000000000000014','确认付款通知单',1,'确认付款通知单',NULL,'/ywgl/qrfktzd/qrfktzd.jsp','URL'),('10000000000000000015','查询付款通知单',1,'查询付款通知单',NULL,'/cxgl/cxfktzd/cxfktzd.jsp','URL'),('10000000000000000016','录入资金日报',1,'录入资金日报',NULL,'/ywgl/lrzjrb/lrzjrb.jsp','URL'),('10000000000000000017','查询资金日报',1,'查询资金日报',NULL,'/cxgl/cxzjrb/cxzjrb.jsp','URL'),('10000000000000000018','查询回收款',1,'查询回收款',NULL,'/cxgl/cxhsk/cxhsk.jsp','URL'),('10000000000000000019','录入收入合同',1,'录入收入合同',NULL,'/ywgl/lrsrht/lrsrht.jsp','URL'),('10000000000000000020','录入收款通知单',1,'录入收款通知单',NULL,'/ywgl/lrsktzd/lrsktzd.jsp','URL'),('10000000000000000021','查询收款通知单',1,'查询收款通知单',NULL,'/cxgl/cxsktzd/cxsktzd.jsp','URL'),('10000000000000000022','权限管理',1,'权限管理',NULL,'/qx/authority.jsp','URL'),('10000000000000000023','功能列表',1,'功能列表',NULL,'/qx/resource.jsp','URL'),('10000000000000000024','项目管理',1,'项目管理',NULL,'/qx/projects.jsp','URL'),('10000000000000000025','查询管理',1,'查询管理',NULL,'/qx/search.jsp','URL'),('10000000000000000026','用户管理',1,'用户管理',NULL,'/qx/user.jsp','URL'),('10000000000000000027','授权审核',1,'授权审核',NULL,'/ywsl/sqsh/sqsh.jsp','URL');
/*!40000 ALTER TABLE `glxt_qx_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_qx_role`
--

DROP TABLE IF EXISTS `glxt_qx_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_qx_role` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ROLE_ACT_GROUP_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ROLE_DESC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISENABLED` tinyint(1) DEFAULT NULL,
  `ROLE_NAME` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_qx_role`
--

LOCK TABLES `glxt_qx_role` WRITE;
/*!40000 ALTER TABLE `glxt_qx_role` DISABLE KEYS */;
INSERT INTO `glxt_qx_role` VALUES ('11000000000000000003',NULL,'管理员',1,'AUTH_ADMIN'),('11111139698559513208',NULL,'统计员',1,'AUTH_TJY');
/*!40000 ALTER TABLE `glxt_qx_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_qx_role_authority`
--

DROP TABLE IF EXISTS `glxt_qx_role_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_qx_role_authority` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `AUTHORITY_ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ISENABLED` tinyint(1) NOT NULL,
  `ROLE_ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_qx_role_authority`
--

LOCK TABLES `glxt_qx_role_authority` WRITE;
/*!40000 ALTER TABLE `glxt_qx_role_authority` DISABLE KEYS */;
INSERT INTO `glxt_qx_role_authority` VALUES ('11111139698703680027','11111139696267260415',1,'11111139698559513208'),('13000000000000000001','11000000000000000002',1,'11000000000000000003');
/*!40000 ALTER TABLE `glxt_qx_role_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_qx_user`
--

DROP TABLE IF EXISTS `glxt_qx_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_qx_user` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `USER_ACCOUNT` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `USER_ACT_USER_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `USER_DESC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISENABLED` tinyint(1) DEFAULT NULL,
  `USER_NAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `USER_PWD` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_qx_user`
--

LOCK TABLES `glxt_qx_user` WRITE;
/*!40000 ALTER TABLE `glxt_qx_user` DISABLE KEYS */;
INSERT INTO `glxt_qx_user` VALUES ('11000000000000000001','admin',NULL,'管理员',1,'管理员','202cb962ac59075b964b07152d234b70'),('11111139735562543280','wxh',NULL,'测试测试',1,'测试用户','202cb962ac59075b964b07152d234b70'),('11111140332817963580','abc',NULL,'123',1,'测试用户1','202cb962ac59075b964b07152d234b70');
/*!40000 ALTER TABLE `glxt_qx_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_qx_user_role`
--

DROP TABLE IF EXISTS `glxt_qx_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_qx_user_role` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ISENABLED` tinyint(1) NOT NULL,
  `ROLE_ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `USER_ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_qx_user_role`
--

LOCK TABLES `glxt_qx_user_role` WRITE;
/*!40000 ALTER TABLE `glxt_qx_user_role` DISABLE KEYS */;
INSERT INTO `glxt_qx_user_role` VALUES ('11111140332988357405',1,'11000000000000000003','11111140332817963580'),('11111140403033426988',1,'11111139698559513208','11111139735562543280'),('14000000000000000001',1,'11000000000000000003','11000000000000000001');
/*!40000 ALTER TABLE `glxt_qx_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_sktzd`
--

DROP TABLE IF EXISTS `glxt_sktzd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_sktzd` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `GCLB` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HTBH` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISENABLED` tinyint(1) NOT NULL,
  `JLK` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `JLQS` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `JLRQ` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NMGGZBZJ` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `QTKK` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SJ` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `YZMC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ZBJ` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_sktzd`
--

LOCK TABLES `glxt_sktzd` WRITE;
/*!40000 ALTER TABLE `glxt_sktzd` DISABLE KEYS */;
/*!40000 ALTER TABLE `glxt_sktzd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_sqdo`
--

DROP TABLE IF EXISTS `glxt_sqdo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_sqdo` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `SQSJ` datetime DEFAULT NULL,
  `ISENABLED` tinyint(1) NOT NULL,
  `JSDBH` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SQJE` double DEFAULT NULL,
  `YSQBZ` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SQLY` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CLZT` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `FKTZDDYCS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_sqdo`
--

LOCK TABLES `glxt_sqdo` WRITE;
/*!40000 ALTER TABLE `glxt_sqdo` DISABLE KEYS */;
INSERT INTO `glxt_sqdo` VALUES ('11111119284159069492','2015-06-22 14:27:55',1,'项目一-材料-00002预授权00001',10000,'Y',NULL,'04',0),('11111121200238387573','2015-06-22 14:59:51',1,'项目一-劳务-00001-预授权-00001',20000,'Y','测试1','02',0),('11111150379281222595','2015-06-22 23:06:11',1,'项目一-机械-00001-00001',30000000,'N','由结算单付款','02',0),('11111152812132970633','2015-06-22 02:06:13',1,'项目一-材料-00001-00001',800000,'N',NULL,'02',0);
/*!40000 ALTER TABLE `glxt_sqdo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_srhetong`
--

DROP TABLE IF EXISTS `glxt_srhetong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_srhetong` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `DW` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GCFL` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GG` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GYS` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HTBH` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HTJE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HTMC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISENABLED` tinyint(1) NOT NULL,
  `JGRQ` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `KGRQ` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MZ` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PZ` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SJJSJE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SJKGRQ` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SL` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `WGRQ` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `YZDWMC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ZBDWMC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ZYMC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_srhetong`
--

LOCK TABLES `glxt_srhetong` WRITE;
/*!40000 ALTER TABLE `glxt_srhetong` DISABLE KEYS */;
/*!40000 ALTER TABLE `glxt_srhetong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_user_xm`
--

DROP TABLE IF EXISTS `glxt_user_xm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_user_xm` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ISENABLED` tinyint(1) NOT NULL,
  `USER_ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `XM_ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_user_xm`
--

LOCK TABLES `glxt_user_xm` WRITE;
/*!40000 ALTER TABLE `glxt_user_xm` DISABLE KEYS */;
INSERT INTO `glxt_user_xm` VALUES ('11111139763218657849',1,'11000000000000000001','11111139763039816337'),('11111139763334318920',1,'11111139735562543280','11111139763039816337');
/*!40000 ALTER TABLE `glxt_user_xm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_xiangmu`
--

DROP TABLE IF EXISTS `glxt_xiangmu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_xiangmu` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `XM_DESC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISENABLED` tinyint(1) NOT NULL,
  `XM_MC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_xiangmu`
--

LOCK TABLES `glxt_xiangmu` WRITE;
/*!40000 ALTER TABLE `glxt_xiangmu` DISABLE KEYS */;
INSERT INTO `glxt_xiangmu` VALUES ('11111139763039816337','测试项目',1,'项目一');
/*!40000 ALTER TABLE `glxt_xiangmu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_zjrb`
--

DROP TABLE IF EXISTS `glxt_zjrb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_zjrb` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `CONTENT` longtext COLLATE utf8_unicode_ci,
  `CWZG` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISENABLED` tinyint(1) NOT NULL,
  `QMYE_A` double DEFAULT NULL,
  `QMYE_B` double DEFAULT NULL,
  `QMYE_C` double DEFAULT NULL,
  `QMYE_D` double DEFAULT NULL,
  `QMYE_E` double DEFAULT NULL,
  `TBDW` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TBRQ` datetime DEFAULT NULL,
  `ZBR` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_zjrb`
--

LOCK TABLES `glxt_zjrb` WRITE;
/*!40000 ALTER TABLE `glxt_zjrb` DISABLE KEYS */;
INSERT INTO `glxt_zjrb` VALUES ('11111110562582255162','<thead class=\"text-c  table-border table-bordered table-striped\"><tr id=\"XM\"><td id=\"NAME\" colspan=\"3\" width=\"18%\">项目</td><td>银行存款</td><td>现金</td><td>银行卡</td><td>承兑</td><td>合计</td></tr><tr id=\"QCJE\"><td colspan=\"3\">期初金额</td><td id=\"qcje1\" class=\"num\">-2000.0</td><td id=\"qcje2\" class=\"num\">0.0</td><td id=\"qcje3\" class=\"num\">0.0</td><td id=\"qcje4\" class=\"num\">0.0</td><td name=\"HJL\">-2000</td></tr><tr id=\"BQSR\"><td colspan=\"3\">本期收入</td><td id=\"bssr1\" class=\"num\">0</td><td id=\"bssr2\" class=\"num\">0</td><td id=\"bssr3\" class=\"num\">0</td><td id=\"bssr4\" class=\"num\">0</td><td name=\"HJL\">0</td></tr><tr id=\"BQZC\"><td colspan=\"3\">本期支出</td><td id=\"bszc1\" class=\"num\">5000</td><td id=\"bszc2\" class=\"num\">5000</td><td id=\"bszc3\" class=\"num\">5000</td><td id=\"bszc4\" class=\"num\">4000</td><td name=\"HJL\">19000</td></tr><tr id=\"QMJE\"><td colspan=\"3\">期末余额</td><td id=\"qmye1\" class=\"num\">-7000</td><td id=\"qmye2\" class=\"num\">-5000</td><td id=\"qmye3\" class=\"num\">-5000</td><td id=\"qmye4\" class=\"num\">-4000</td><td id=\"qmye\" name=\"HJL\">-21000</td></tr><tr id=\"LM\"><td colspan=\"3\">项目</td><td>银行存款</td><td>现金</td><td>银行卡</td><td>承兑</td><td>合计</td></tr></thead><tbody id=\"zjrbBody\" class=\"text-c  table-border table-bordered table-striped\"><tr id=\"1001\"><td rowspan=\"9\">回款</td><td rowspan=\"4\">工程收入</td><td>预收款</td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1002\"><td>工程款</td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1003\"><td>质保金</td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr4\"></td><td name=\"HJL\">0</td></tr><tr id=\"0\"><td>小计</td><td class=\"num\" name=\"hkgcsr1XJ\">0</td><td class=\"num\" name=\"hkgcsr2XJ\">0</td><td class=\"num\" name=\"hkgcsr3XJ\">0</td><td class=\"num\" name=\"hkgcsr4XJ\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1004\"><td rowspan=\"4\">其他</td><td>收往来</td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1005\"><td>还借款</td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1006\"><td>收押金</td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1\"><td>小计</td><td class=\"num\" name=\"hkqt1XJ\">0</td><td class=\"num\" name=\"hkqt2XJ\">0</td><td class=\"num\" name=\"hkqt3XJ\">0</td><td class=\"num\" name=\"hkqt4XJ\">0</td><td name=\"HJL\">0</td></tr><tr id=\"2\"><td colspan=\"2\">合计</td><td class=\"num\" name=\"hk1HJ\">0</td><td class=\"num\" name=\"hk2HJ\">0</td><td class=\"num\" name=\"hk3HJ\">0</td><td class=\"num\" name=\"hk4HJ\">0</td><td name=\"HJL\">0</td></tr><tr id=\"hk\"><td colspan=\"3\">银行存款</td><td class=\"edit num editable editable-click\" id=\"hk1\">0</td><td>现金转入</td><td class=\"edit num editable editable-click\" id=\"hk2\">0</td><td>银行卡转入</td><td class=\"edit num editable editable-click\" id=\"hk3\">0</td></tr><tr id=\"1007\"><td rowspan=\"31\">付款</td><td rowspan=\"12\">直接费用</td><td>人工费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1008\"><td>机械费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1009\"><td>租金</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1010\"><td>运费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1011\"><td>修理费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1012\"><td>原材料</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1013\"><td>耗用材料</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1014\"><td>燃油</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1015\"><td>煤</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1016\"><td>检测检验费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1017\"><td>其他</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"3\"><td>小计</td><td class=\"num\" name=\"fkzjfy1XJ\">0</td><td class=\"num\" name=\"fkzjfy2XJ\">0</td><td class=\"num\" name=\"fkzjfy3XJ\">0</td><td class=\"num\" name=\"fkzjfy4XJ\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1018\"><td rowspan=\"14\">间接费用</td><td>税金</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1019\"><td>工资</td><td style=\"display: table-cell;\" class=\"edit num editable editable-click editable-unsaved\" name=\"fkjjfy1\">4000</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td style=\"display: none;\" class=\"edit num editable editable-click editable-empty editable-open\" name=\"fkjjfy4\"></td><span class=\"editable-container editable-inline\"><div><div style=\"display: none;\" class=\"editableform-loading\"></div><form style=\"\" class=\"form-inline editableform\"><div class=\"control-group form-group\"><div><div style=\"position: relative;\" class=\"editable-input\"><input style=\"padding-right: 24px;\" class=\"form-control input-text\" type=\"text\"><span style=\"display: none;\" class=\"editable-clear-x\"></span></div></div><div style=\"display: none;\" class=\"editable-error-block help-block\"></div></div></form></div></span><td name=\"HJL\">4000</td></tr><tr id=\"1020\"><td>办公费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td style=\"display: table-cell;\" class=\"edit num editable editable-click editable-unsaved\" name=\"fkjjfy2\">3000</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">3000</td></tr><tr id=\"1021\"><td>差旅费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td style=\"display: table-cell;\" class=\"edit num editable editable-click editable-unsaved\" name=\"fkjjfy3\">2000</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">2000</td></tr><tr id=\"1022\"><td>通讯费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1023\"><td>招待费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1024\"><td>员工餐费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td style=\"display: table-cell;\" class=\"edit num editable editable-click editable-unsaved\" name=\"fkjjfy4\">4000</td><td name=\"HJL\">4000</td></tr><tr id=\"1025\"><td>搬运费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td style=\"display: table-cell;\" class=\"edit num editable editable-click editable-unsaved\" name=\"fkjjfy3\">3000</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">3000</td></tr><tr id=\"1026\"><td>水电费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td style=\"display: table-cell;\" class=\"edit num editable editable-click editable-unsaved\" name=\"fkjjfy2\">2000</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">2000</td></tr><tr id=\"1027\"><td>汽车费</td><td style=\"display: table-cell;\" class=\"edit num editable editable-click editable-unsaved\" name=\"fkjjfy1\">1000</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">1000</td></tr><tr id=\"1028\"><td>财务费用</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1029\"><td>租金</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1030\"><td>其他</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"4\"><td>小计</td><td class=\"num\" name=\"fkjjfy1XJ\">5000</td><td class=\"num\" name=\"fkjjfy2XJ\">5000</td><td class=\"num\" name=\"fkjjfy3XJ\">5000</td><td class=\"num\" name=\"fkjjfy4XJ\">4000</td><td name=\"HJL\">19000</td></tr><tr id=\"1031\"><td rowspan=\"4\">其他</td><td>还往来款</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1032\"><td>付出押金</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1033\"><td>员工借款</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt4\"></td><td name=\"HJL\">0</td></tr><tr id=\"5\"><td>小计</td><td class=\"num\" name=\"fkqt1XJ\">0</td><td class=\"num\" name=\"fkqt2XJ\">0</td><td class=\"num\" name=\"fkqt3XJ\">0</td><td class=\"num\" name=\"fkqt4XJ\">0</td><td name=\"HJL\">0</td></tr><tr id=\"6\"><td colspan=\"2\">合计</td><td class=\"num\" name=\"fk1HJ\">5000</td><td class=\"num\" name=\"fk2HJ\">5000</td><td class=\"num\" name=\"fk3HJ\">5000</td><td class=\"num\" name=\"fk4HJ\">4000</td><td name=\"HJL\">19000</td></tr><tr id=\"fk\"><td colspan=\"3\">银行存款</td><td class=\"edit num editable editable-click\" id=\"fk1\">0</td><td>现金转出</td><td class=\"edit num editable editable-click\" id=\"fk2\">0</td><td>银行卡转出</td><td class=\"edit num editable editable-click\" id=\"fk3\">0</td></tr></tbody>',NULL,1,-7000,-5000,-5000,-4000,-21000,NULL,'2015-06-29 00:00:00',NULL),('11111114985525966454','<thead class=\"text-c  table-border table-bordered table-striped\"><tr id=\"XM\"><td id=\"NAME\" colspan=\"3\" width=\"18%\">项目</td><td>银行存款</td><td>现金</td><td>银行卡</td><td>承兑</td><td>合计</td></tr><tr id=\"QCJE\"><td colspan=\"3\">期初金额</td><td id=\"qcje1\" class=\"num\">-2000.0</td><td id=\"qcje2\" class=\"num\">0.0</td><td id=\"qcje3\" class=\"num\">0.0</td><td id=\"qcje4\" class=\"num\">0.0</td><td name=\"HJL\">-2000</td></tr><tr id=\"BQSR\"><td colspan=\"3\">本期收入</td><td id=\"bssr1\" class=\"num\">2000</td><td id=\"bssr2\" class=\"num\">1000</td><td id=\"bssr3\" class=\"num\">2222</td><td id=\"bssr4\" class=\"num\">0</td><td name=\"HJL\">5222</td></tr><tr id=\"BQZC\"><td colspan=\"3\">本期支出</td><td id=\"bszc1\" class=\"num\">333</td><td id=\"bszc2\" class=\"num\">22</td><td id=\"bszc3\" class=\"num\">12</td><td id=\"bszc4\" class=\"num\">0</td><td name=\"HJL\">367</td></tr><tr id=\"QMJE\"><td colspan=\"3\">期末余额</td><td id=\"qmye1\" class=\"num\">-333</td><td id=\"qmye2\" class=\"num\">978</td><td id=\"qmye3\" class=\"num\">2210</td><td id=\"qmye4\" class=\"num\">0</td><td id=\"qmye\" name=\"HJL\">2855</td></tr><tr id=\"LM\"><td colspan=\"3\">项目</td><td>银行存款</td><td>现金</td><td>银行卡</td><td>承兑</td><td>合计</td></tr></thead><tbody id=\"zjrbBody\" class=\"text-c  table-border table-bordered table-striped\"><tr id=\"1001\"><td rowspan=\"9\">回款</td><td rowspan=\"4\">工程收入</td><td>预收款</td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1002\"><td>工程款</td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1003\"><td>质保金</td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkgcsr4\"></td><td name=\"HJL\">0</td></tr><tr id=\"0\"><td>小计</td><td class=\"num\" name=\"hkgcsr1XJ\">0</td><td class=\"num\" name=\"hkgcsr2XJ\">0</td><td class=\"num\" name=\"hkgcsr3XJ\">0</td><td class=\"num\" name=\"hkgcsr4XJ\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1004\"><td rowspan=\"4\">其他</td><td>收往来</td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1005\"><td>还借款</td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1006\"><td>收押金</td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"hkqt4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1\"><td>小计</td><td class=\"num\" name=\"hkqt1XJ\">0</td><td class=\"num\" name=\"hkqt2XJ\">0</td><td class=\"num\" name=\"hkqt3XJ\">0</td><td class=\"num\" name=\"hkqt4XJ\">0</td><td name=\"HJL\">0</td></tr><tr id=\"2\"><td colspan=\"2\">合计</td><td class=\"num\" name=\"hk1HJ\">0</td><td class=\"num\" name=\"hk2HJ\">0</td><td class=\"num\" name=\"hk3HJ\">0</td><td class=\"num\" name=\"hk4HJ\">0</td><td name=\"HJL\">0</td></tr><tr id=\"hk\"><td colspan=\"3\">银行存款</td><td style=\"display: table-cell;\" class=\"edit num editable editable-click editable-unsaved\" id=\"hk1\">2000</td><td>现金转入</td><td style=\"display: table-cell;\" class=\"edit num editable editable-click editable-unsaved\" id=\"hk2\">1000</td><td>银行卡转入</td><td style=\"display: table-cell;\" class=\"edit num editable editable-click editable-unsaved\" id=\"hk3\">2222</td></tr><tr id=\"1007\"><td rowspan=\"31\">付款</td><td rowspan=\"12\">直接费用</td><td>人工费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td style=\"display: table-cell;\" class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1008\"><td>机械费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1009\"><td>租金</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1010\"><td>运费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1011\"><td>修理费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1012\"><td>原材料</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1013\"><td>耗用材料</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1014\"><td>燃油</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1015\"><td>煤</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1016\"><td>检测检验费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1017\"><td>其他</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkzjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"3\"><td>小计</td><td class=\"num\" name=\"fkzjfy1XJ\">0</td><td class=\"num\" name=\"fkzjfy2XJ\">0</td><td class=\"num\" name=\"fkzjfy3XJ\">0</td><td class=\"num\" name=\"fkzjfy4XJ\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1018\"><td rowspan=\"14\">间接费用</td><td>税金</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1019\"><td>工资</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1020\"><td>办公费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1021\"><td>差旅费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1022\"><td>通讯费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1023\"><td>招待费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1024\"><td>员工餐费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1025\"><td>搬运费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1026\"><td>水电费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1027\"><td>汽车费</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1028\"><td>财务费用</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1029\"><td>租金</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1030\"><td>其他</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkjjfy4\"></td><td name=\"HJL\">0</td></tr><tr id=\"4\"><td>小计</td><td class=\"num\" name=\"fkjjfy1XJ\">0</td><td class=\"num\" name=\"fkjjfy2XJ\">0</td><td class=\"num\" name=\"fkjjfy3XJ\">0</td><td class=\"num\" name=\"fkjjfy4XJ\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1031\"><td rowspan=\"4\">其他</td><td>还往来款</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1032\"><td>付出押金</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt4\"></td><td name=\"HJL\">0</td></tr><tr id=\"1033\"><td>员工借款</td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt1\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt2\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt3\"></td><td class=\"edit num editable editable-click editable-empty\" name=\"fkqt4\"></td><td name=\"HJL\">0</td></tr><tr id=\"5\"><td>小计</td><td class=\"num\" name=\"fkqt1XJ\">0</td><td class=\"num\" name=\"fkqt2XJ\">0</td><td class=\"num\" name=\"fkqt3XJ\">0</td><td class=\"num\" name=\"fkqt4XJ\">0</td><td name=\"HJL\">0</td></tr><tr id=\"6\"><td colspan=\"2\">合计</td><td class=\"num\" name=\"fk1HJ\">0</td><td class=\"num\" name=\"fk2HJ\">0</td><td class=\"num\" name=\"fk3HJ\">0</td><td class=\"num\" name=\"fk4HJ\">0</td><td name=\"HJL\">0</td></tr><tr id=\"fk\"><td colspan=\"3\">银行存款</td><td style=\"display: table-cell;\" class=\"edit num editable editable-click editable-unsaved\" id=\"fk1\">333</td><td>现金转出</td><td style=\"display: table-cell;\" class=\"edit num editable editable-click editable-unsaved\" id=\"fk2\">22</td><td>银行卡转出</td><td style=\"display: table-cell;\" class=\"edit num editable editable-click editable-unsaved editable-bg-transition\" id=\"fk3\">012</td></tr></tbody>',NULL,1,-333,978,2210,0,2855,NULL,'2015-06-30 00:00:00',NULL),('11111130871308355848','<thead class=\"text-c  table-border table-bordered table-striped\"><tr id=\"XM\"><td id=\"NAME\" colspan=\"3\" width=\"18%\">项目</td><td>银行存款</td><td>现金</td><td>银行卡</td><td>承兑</td><td>合计</td></tr><tr id=\"QCJE\"><td colspan=\"3\">期初金额</td><td id=\"qcje1\" class=\"num\">0</td><td id=\"qcje2\" class=\"num\">0</td><td id=\"qcje3\" class=\"num\">0</td><td id=\"qcje4\" class=\"num\">0</td><td name=\"HJL\">0</td></tr><tr id=\"BQSR\"><td colspan=\"3\">本期收入</td><td id=\"bssr1\" class=\"num\">0</td><td id=\"bssr2\" class=\"num\">0</td><td id=\"bssr3\" class=\"num\">0</td><td id=\"bssr4\" class=\"num\">0</td><td name=\"HJL\">0</td></tr><tr id=\"BQZC\"><td colspan=\"3\">本期支出</td><td id=\"bszc1\" class=\"num\">2000</td><td id=\"bszc2\" class=\"num\">0</td><td id=\"bszc3\" class=\"num\">0</td><td id=\"bszc4\" class=\"num\">0</td><td name=\"HJL\">2000</td></tr><tr id=\"QMJE\"><td colspan=\"3\">期末余额</td><td id=\"qmye1\" class=\"num\">-2000</td><td id=\"qmye2\" class=\"num\">0</td><td id=\"qmye3\" class=\"num\">0</td><td id=\"qmye4\" class=\"num\">0</td><td id=\"qmye\" name=\"HJL\">-2000</td></tr><tr id=\"LM\"><td colspan=\"3\">项目</td><td>银行存款</td><td>现金</td><td>银行卡</td><td>承兑</td><td>合计</td></tr></thead><tbody id=\"zjrbBody\" class=\"text-c  table-border table-bordered table-striped\"><tr id=\"1001\"><td rowspan=\"9\">回款</td><td rowspan=\"4\">工程收入</td><td>预收款</td><td class=\"edit num editable editable-click\" name=\"hkgcsr1\">0</td><td class=\"edit num editable editable-click\" name=\"hkgcsr2\">0</td><td class=\"edit num editable editable-click\" name=\"hkgcsr3\">0</td><td class=\"edit num editable editable-click\" name=\"hkgcsr4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1002\"><td>工程款</td><td class=\"edit num editable editable-click\" name=\"hkgcsr1\">0</td><td class=\"edit num editable editable-click\" name=\"hkgcsr2\">0</td><td class=\"edit num editable editable-click\" name=\"hkgcsr3\">0</td><td class=\"edit num editable editable-click\" name=\"hkgcsr4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1003\"><td>质保金</td><td class=\"edit num editable editable-click\" name=\"hkgcsr1\">0</td><td class=\"edit num editable editable-click\" name=\"hkgcsr2\">0</td><td class=\"edit num editable editable-click\" name=\"hkgcsr3\">0</td><td class=\"edit num editable editable-click\" name=\"hkgcsr4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"0\"><td>小计</td><td class=\"num\" name=\"hkgcsr1XJ\">0</td><td class=\"num\" name=\"hkgcsr2XJ\">0</td><td class=\"num\" name=\"hkgcsr3XJ\">0</td><td class=\"num\" name=\"hkgcsr4XJ\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1004\"><td rowspan=\"4\">其他</td><td>收往来</td><td class=\"edit num editable editable-click\" name=\"hkqt1\">0</td><td class=\"edit num editable editable-click\" name=\"hkqt2\">0</td><td class=\"edit num editable editable-click\" name=\"hkqt3\">0</td><td class=\"edit num editable editable-click\" name=\"hkqt4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1005\"><td>还借款</td><td class=\"edit num editable editable-click\" name=\"hkqt1\">0</td><td class=\"edit num editable editable-click\" name=\"hkqt2\">0</td><td class=\"edit num editable editable-click\" name=\"hkqt3\">0</td><td class=\"edit num editable editable-click\" name=\"hkqt4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1006\"><td>收押金</td><td class=\"edit num editable editable-click\" name=\"hkqt1\">0</td><td class=\"edit num editable editable-click\" name=\"hkqt2\">0</td><td class=\"edit num editable editable-click\" name=\"hkqt3\">0</td><td class=\"edit num editable editable-click\" name=\"hkqt4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1\"><td>小计</td><td class=\"num\" name=\"hkqt1XJ\">0</td><td class=\"num\" name=\"hkqt2XJ\">0</td><td class=\"num\" name=\"hkqt3XJ\">0</td><td class=\"num\" name=\"hkqt4XJ\">0</td><td name=\"HJL\">0</td></tr><tr id=\"2\"><td colspan=\"2\">合计</td><td class=\"num\" name=\"hk1HJ\">0</td><td class=\"num\" name=\"hk2HJ\">0</td><td class=\"num\" name=\"hk3HJ\">0</td><td class=\"num\" name=\"hk4HJ\">0</td><td name=\"HJL\">0</td></tr><tr id=\"hk\"><td colspan=\"3\">银行存款</td><td class=\"edit num editable editable-click\" id=\"hk1\">0</td><td>现金转入</td><td class=\"edit num editable editable-click\" id=\"hk2\">0</td><td>银行卡转入</td><td class=\"edit num editable editable-click\" id=\"hk3\">0</td></tr><tr id=\"1007\"><td rowspan=\"31\">付款</td><td rowspan=\"12\">直接费用</td><td>人工费</td><td class=\"edit num editable editable-click\" name=\"fkzjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1008\"><td>机械费</td><td class=\"edit num editable editable-click\" name=\"fkzjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1009\"><td>租金</td><td class=\"edit num editable editable-click\" name=\"fkzjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1010\"><td>运费</td><td class=\"edit num editable editable-click\" name=\"fkzjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1011\"><td>修理费</td><td class=\"edit num editable editable-click\" name=\"fkzjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1012\"><td>原材料</td><td class=\"edit num editable editable-click\" name=\"fkzjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1013\"><td>耗用材料</td><td class=\"edit num editable editable-click\" name=\"fkzjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1014\"><td>燃油</td><td class=\"edit num editable editable-click\" name=\"fkzjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1015\"><td>煤</td><td class=\"edit num editable editable-click\" name=\"fkzjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1016\"><td>检测检验费</td><td class=\"edit num editable editable-click\" name=\"fkzjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1017\"><td>其他</td><td class=\"edit num editable editable-click\" name=\"fkzjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkzjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"3\"><td>小计</td><td class=\"num\" name=\"fkzjfy1XJ\">0</td><td class=\"num\" name=\"fkzjfy2XJ\">0</td><td class=\"num\" name=\"fkzjfy3XJ\">0</td><td class=\"num\" name=\"fkzjfy4XJ\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1018\"><td rowspan=\"14\">间接费用</td><td>税金</td><td class=\"edit num editable editable-click\" name=\"fkjjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1019\"><td>工资</td><td class=\"edit num editable editable-click\" name=\"fkjjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1020\"><td>办公费</td><td class=\"edit num editable editable-click\" name=\"fkjjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1021\"><td>差旅费</td><td class=\"edit num editable editable-click\" name=\"fkjjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1022\"><td>通讯费</td><td class=\"edit num editable editable-click\" name=\"fkjjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1023\"><td>招待费</td><td class=\"edit num editable editable-click\" name=\"fkjjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1024\"><td>员工餐费</td><td class=\"edit num editable editable-click\" name=\"fkjjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1025\"><td>搬运费</td><td class=\"edit num editable editable-click\" name=\"fkjjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1026\"><td>水电费</td><td class=\"edit num editable editable-click\" name=\"fkjjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1027\"><td>汽车费</td><td class=\"edit num editable editable-click\" name=\"fkjjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1028\"><td>财务费用</td><td class=\"edit num editable editable-click\" name=\"fkjjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1029\"><td>租金</td><td class=\"edit num editable editable-click\" name=\"fkjjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1030\"><td>其他</td><td class=\"edit num editable editable-click\" name=\"fkjjfy1\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy2\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy3\">0</td><td class=\"edit num editable editable-click\" name=\"fkjjfy4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"4\"><td>小计</td><td class=\"num\" name=\"fkjjfy1XJ\">0</td><td class=\"num\" name=\"fkjjfy2XJ\">0</td><td class=\"num\" name=\"fkjjfy3XJ\">0</td><td class=\"num\" name=\"fkjjfy4XJ\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1031\"><td rowspan=\"4\">其他</td><td>还往来款</td><td class=\"edit num editable editable-click\" name=\"fkqt1\">0</td><td class=\"edit num editable editable-click\" name=\"fkqt2\">0</td><td class=\"edit num editable editable-click\" name=\"fkqt3\">0</td><td class=\"edit num editable editable-click\" name=\"fkqt4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1032\"><td>付出押金</td><td class=\"edit num editable editable-click\" name=\"fkqt1\">0</td><td class=\"edit num editable editable-click\" name=\"fkqt2\">0</td><td class=\"edit num editable editable-click\" name=\"fkqt3\">0</td><td class=\"edit num editable editable-click\" name=\"fkqt4\">0</td><td name=\"HJL\">0</td></tr><tr id=\"1033\"><td>员工借款</td><td style=\"display: table-cell;\" class=\"edit num editable editable-click editable-unsaved\" name=\"fkqt1\">2000</td><td class=\"edit num editable editable-click\" name=\"fkqt2\">0</td><td class=\"edit num editable editable-click\" name=\"fkqt3\">0</td><td class=\"edit num editable editable-click\" name=\"fkqt4\">0</td><td name=\"HJL\">2000</td></tr><tr id=\"5\"><td>小计</td><td class=\"num\" name=\"fkqt1XJ\">2000</td><td class=\"num\" name=\"fkqt2XJ\">0</td><td class=\"num\" name=\"fkqt3XJ\">0</td><td class=\"num\" name=\"fkqt4XJ\">0</td><td name=\"HJL\">2000</td></tr><tr id=\"6\"><td colspan=\"2\">合计</td><td class=\"num\" name=\"fk1HJ\">2000</td><td class=\"num\" name=\"fk2HJ\">0</td><td class=\"num\" name=\"fk3HJ\">0</td><td class=\"num\" name=\"fk4HJ\">0</td><td name=\"HJL\">2000</td></tr><tr id=\"fk\"><td colspan=\"3\">银行存款</td><td class=\"edit num editable editable-click\" id=\"fk1\">0</td><td>现金转出</td><td class=\"edit num editable editable-click\" id=\"fk2\">0</td><td>银行卡转出</td><td class=\"edit num editable editable-click\" id=\"fk3\">0</td></tr></tbody>',NULL,1,-2000,0,0,0,-2000,NULL,'2015-06-28 00:00:00',NULL);
/*!40000 ALTER TABLE `glxt_zjrb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glxt_zjrb_mx`
--

DROP TABLE IF EXISTS `glxt_zjrb_mx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `glxt_zjrb_mx` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `FKTZD_ID` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISENABLED` tinyint(1) NOT NULL,
  `JE` double DEFAULT NULL,
  `ZJRB_KX_TYPE_DM` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LB` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SKTZD_ID` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ZJRB_ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ZJRB_XMDM` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glxt_zjrb_mx`
--

LOCK TABLES `glxt_zjrb_mx` WRITE;
/*!40000 ALTER TABLE `glxt_zjrb_mx` DISABLE KEYS */;
INSERT INTO `glxt_zjrb_mx` VALUES ('11111114480107864393',NULL,1,4000,'A','F',NULL,'11111110562582255162','1019'),('11111114480232758801',NULL,1,3000,'B','F',NULL,'11111110562582255162','1020'),('11111114480353649966',NULL,1,2000,'C','F',NULL,'11111110562582255162','1021'),('11111114480474543465',NULL,1,4000,'D','F',NULL,'11111110562582255162','1024'),('11111114480593675125',NULL,1,3000,'C','F',NULL,'11111110562582255162','1025'),('11111114480738383096',NULL,1,2000,'B','F',NULL,'11111110562582255162','1026'),('11111114480859290604',NULL,1,1000,'A','F',NULL,'11111110562582255162','1027'),('11111115042597753083',NULL,1,2000,'A','H',NULL,'11111114985525966454','1034'),('11111115042825774113',NULL,1,1000,'B','H',NULL,'11111114985525966454','1035'),('11111115042957998854',NULL,1,2222,'C','H',NULL,'11111114985525966454','1036'),('11111115043113522542',NULL,1,333,'A','F',NULL,'11111114985525966454','1037'),('11111115043234678005',NULL,1,22,'B','F',NULL,'11111114985525966454','1038'),('11111115043355236227',NULL,1,12,'C','F',NULL,'11111114985525966454','1039');
/*!40000 ALTER TABLE `glxt_zjrb_mx` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-30 21:41:22
