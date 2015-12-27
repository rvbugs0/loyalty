CREATE DATABASE  IF NOT EXISTS `loyalty` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `loyalty`;
-- MySQL dump 10.13  Distrib 5.6.27, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: loyalty
-- ------------------------------------------------------
-- Server version	5.6.27-0ubuntu0.15.04.1

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  `username` char(20) NOT NULL,
  `password` char(50) NOT NULL,
  `password_key` char(50) NOT NULL,
  `contact_number` char(100) NOT NULL,
  `mail_id` char(100) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code` (`code`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `contact_number` (`contact_number`),
  UNIQUE KEY `mail_id` (`mail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (4,'Ravi Ailani','railani1','question20','question20','8518900017','rvbugs0@gmail.com');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(30) NOT NULL,
  `state` char(30) NOT NULL,
  `country` char(30) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=1482 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Kolhapur','Maharashtra','India'),(2,'Port Blair','Andaman and Nicobar Islands','India'),(3,'Adilabad','Andhra Pradesh','India'),(4,'Adoni','Andhra Pradesh','India'),(5,'Amadalavalasa','Andhra Pradesh','India'),(6,'Amalapuram','Andhra Pradesh','India'),(7,'Anakapalle','Andhra Pradesh','India'),(8,'Anantapur','Andhra Pradesh','India'),(9,'Badepalle','Andhra Pradesh','India'),(10,'Banganapalle','Andhra Pradesh','India'),(11,'Bapatla','Andhra Pradesh','India'),(12,'Bellampalle','Andhra Pradesh','India'),(13,'Bethamcherla','Andhra Pradesh','India'),(14,'Bhadrachalam','Andhra Pradesh','India'),(15,'Bhainsa','Andhra Pradesh','India'),(16,'Bheemunipatnam','Andhra Pradesh','India'),(17,'Bhimavaram','Andhra Pradesh','India'),(18,'Bhongir','Andhra Pradesh','India'),(19,'Bobbili','Andhra Pradesh','India'),(20,'Bodhan','Andhra Pradesh','India'),(21,'Chilakaluripet','Andhra Pradesh','India'),(22,'Chirala','Andhra Pradesh','India'),(23,'Chittoor','Andhra Pradesh','India'),(24,'Cuddapah','Andhra Pradesh','India'),(25,'Devarakonda','Andhra Pradesh','India'),(26,'Dharmavaram','Andhra Pradesh','India'),(27,'Eluru','Andhra Pradesh','India'),(28,'Farooqnagar','Andhra Pradesh','India'),(29,'Gadwal','Andhra Pradesh','India'),(30,'Gooty','Andhra Pradesh','India'),(31,'Gudivada','Andhra Pradesh','India'),(32,'Gudur','Andhra Pradesh','India'),(33,'Guntakal','Andhra Pradesh','India'),(34,'Guntur','Andhra Pradesh','India'),(35,'Hanuman Junction','Andhra Pradesh','India'),(36,'Hindupur','Andhra Pradesh','India'),(37,'Hyderabad','Andhra Pradesh','India'),(38,'Ichchapuram','Andhra Pradesh','India'),(39,'Jaggaiahpet','Andhra Pradesh','India'),(40,'Jagtial','Andhra Pradesh','India'),(41,'Jammalamadugu','Andhra Pradesh','India'),(42,'Jangaon','Andhra Pradesh','India'),(43,'Kadapa','Andhra Pradesh','India'),(44,'Kadiri','Andhra Pradesh','India'),(45,'Kagaznagar','Andhra Pradesh','India'),(46,'Kakinada','Andhra Pradesh','India'),(47,'Kalyandurg','Andhra Pradesh','India'),(48,'Kamareddy','Andhra Pradesh','India'),(49,'Kandukur','Andhra Pradesh','India'),(50,'Karimnagar','Andhra Pradesh','India'),(51,'Kavali','Andhra Pradesh','India'),(52,'Khammam','Andhra Pradesh','India'),(53,'Koratla','Andhra Pradesh','India'),(54,'Kothagudem','Andhra Pradesh','India'),(55,'Kothapeta','Andhra Pradesh','India'),(56,'Kovvur','Andhra Pradesh','India'),(57,'Kurnool','Andhra Pradesh','India'),(58,'Kyathampalle','Andhra Pradesh','India'),(59,'Macherla','Andhra Pradesh','India'),(60,'Machilipatnam','Andhra Pradesh','India'),(61,'Madanapalle','Andhra Pradesh','India'),(62,'Mahbubnagar','Andhra Pradesh','India'),(63,'Mancherial','Andhra Pradesh','India'),(64,'Mandamarri','Andhra Pradesh','India'),(65,'Mandapeta','Andhra Pradesh','India'),(66,'Manuguru','Andhra Pradesh','India'),(67,'Markapur','Andhra Pradesh','India'),(68,'Medak','Andhra Pradesh','India'),(69,'Miryalaguda','Andhra Pradesh','India'),(70,'Mogalthur','Andhra Pradesh','India'),(71,'Nagari','Andhra Pradesh','India'),(72,'Nagarkurnool','Andhra Pradesh','India'),(73,'Nandyal','Andhra Pradesh','India'),(74,'Narasapur','Andhra Pradesh','India'),(75,'Narasaraopet','Andhra Pradesh','India'),(76,'Narayanpet','Andhra Pradesh','India'),(77,'Narsipatnam','Andhra Pradesh','India'),(78,'Nellore','Andhra Pradesh','India'),(79,'Nidadavole','Andhra Pradesh','India'),(80,'Nirmal','Andhra Pradesh','India'),(81,'Nizamabad','Andhra Pradesh','India'),(82,'Nuzvid','Andhra Pradesh','India'),(83,'Ongole','Andhra Pradesh','India'),(84,'Palacole','Andhra Pradesh','India'),(85,'Palasa Kasibugga','Andhra Pradesh','India'),(86,'Palwancha','Andhra Pradesh','India'),(87,'Parvathipuram','Andhra Pradesh','India'),(88,'Pedana','Andhra Pradesh','India'),(89,'Peddapuram','Andhra Pradesh','India'),(90,'Pithapuram','Andhra Pradesh','India'),(91,'Pondur','Andhra pradesh','India'),(92,'Ponnur','Andhra Pradesh','India'),(93,'Proddatur','Andhra Pradesh','India'),(94,'Punganur','Andhra Pradesh','India'),(95,'Puttur','Andhra Pradesh','India'),(96,'Rajahmundry','Andhra Pradesh','India'),(97,'Rajam','Andhra Pradesh','India'),(98,'Ramachandrapuram','Andhra Pradesh','India'),(99,'Ramagundam','Andhra Pradesh','India'),(100,'Rayachoti','Andhra Pradesh','India'),(101,'Rayadurg','Andhra Pradesh','India'),(102,'Renigunta','Andhra Pradesh','India'),(103,'Repalle','Andhra Pradesh','India'),(104,'Sadasivpet','Andhra Pradesh','India'),(105,'Salur','Andhra Pradesh','India'),(106,'Samalkot','Andhra Pradesh','India'),(107,'Sangareddy','Andhra Pradesh','India'),(108,'Sattenapalle','Andhra Pradesh','India'),(109,'Siddipet','Andhra Pradesh','India'),(110,'Singapur','Andhra Pradesh','India'),(111,'Sircilla','Andhra Pradesh','India'),(112,'Srikakulam','Andhra Pradesh','India'),(113,'Srikalahasti','Andhra Pradesh','India'),(114,'Suryapet','Andhra Pradesh','India'),(115,'Tadepalligudem','Andhra Pradesh','India'),(116,'Tadpatri','Andhra Pradesh','India'),(117,'Tandur','Andhra Pradesh','India'),(118,'Tanuku','Andhra Pradesh','India'),(119,'Tenali','Andhra Pradesh','India'),(120,'Tirupati','Andhra Pradesh','India'),(121,'Tuni','Andhra Pradesh','India'),(122,'Uravakonda','Andhra Pradesh','India'),(123,'Venkatagiri','Andhra Pradesh','India'),(124,'Vicarabad','Andhra Pradesh','India'),(125,'Vijayawada','Andhra Pradesh','India'),(126,'Vinukonda','Andhra Pradesh','India'),(127,'Visakhapatnam','Andhra Pradesh','India'),(128,'Vizianagaram','Andhra Pradesh','India'),(129,'Wanaparthy','Andhra Pradesh','India'),(130,'Warangal','Andhra Pradesh','India'),(131,'Yellandu','Andhra Pradesh','India'),(132,'Yemmiganur','Andhra Pradesh','India'),(133,'Yerraguntla','Andhra Pradesh','India'),(134,'Zahirabad','Andhra Pradesh','India'),(135,'Rajampet','Andra Pradesh','India'),(136,'Along','Arunachal Pradesh','India'),(137,'Bomdila','Arunachal Pradesh','India'),(138,'Itanagar','Arunachal Pradesh','India'),(139,'Naharlagun','Arunachal Pradesh','India'),(140,'Pasighat','Arunachal Pradesh','India'),(141,'Abhayapuri','Assam','India'),(142,'Amguri','Assam','India'),(143,'Anandnagaar','Assam','India'),(144,'Barpeta','Assam','India'),(145,'Barpeta Road','Assam','India'),(146,'Bilasipara','Assam','India'),(147,'Bongaigaon','Assam','India'),(148,'Dhekiajuli','Assam','India'),(149,'Dhubri','Assam','India'),(150,'Dibrugarh','Assam','India'),(151,'Digboi','Assam','India'),(152,'Diphu','Assam','India'),(153,'Dispur','Assam','India'),(154,'Gauripur','Assam','India'),(155,'Goalpara','Assam','India'),(156,'Golaghat','Assam','India'),(157,'Guwahati','Assam','India'),(158,'Haflong','Assam','India'),(159,'Hailakandi','Assam','India'),(160,'Hojai','Assam','India'),(161,'Jorhat','Assam','India'),(162,'Karimganj','Assam','India'),(163,'Kokrajhar','Assam','India'),(164,'Lanka','Assam','India'),(165,'Lumding','Assam','India'),(166,'Mangaldoi','Assam','India'),(167,'Mankachar','Assam','India'),(168,'Margherita','Assam','India'),(169,'Mariani','Assam','India'),(170,'Marigaon','Assam','India'),(171,'Nagaon','Assam','India'),(172,'Nalbari','Assam','India'),(173,'North Lakhimpur','Assam','India'),(174,'Rangia','Assam','India'),(175,'Sibsagar','Assam','India'),(176,'Silapathar','Assam','India'),(177,'Silchar','Assam','India'),(178,'Tezpur','Assam','India'),(179,'Tinsukia','Assam','India'),(180,'Amarpur','Bihar','India'),(181,'Araria','Bihar','India'),(182,'Areraj','Bihar','India'),(183,'Arrah','Bihar','India'),(184,'Asarganj','Bihar','India'),(185,'Aurangabad','Bihar','India'),(186,'Bagaha','Bihar','India'),(187,'Bahadurganj','Bihar','India'),(188,'Bairgania','Bihar','India'),(189,'Bakhtiarpur','Bihar','India'),(190,'Banka','Bihar','India'),(191,'Banmankhi Bazar','Bihar','India'),(192,'Barahiya','Bihar','India'),(193,'Barauli','Bihar','India'),(194,'Barbigha','Bihar','India'),(195,'Barh','Bihar','India'),(196,'Begusarai','Bihar','India'),(197,'Behea','Bihar','India'),(198,'Bettiah','Bihar','India'),(199,'Bhabua','Bihar','India'),(200,'Bhagalpur','Bihar','India'),(201,'Bihar Sharif','Bihar','India'),(202,'Bikramganj','Bihar','India'),(203,'Bodh Gaya','Bihar','India'),(204,'Buxar','Bihar','India'),(205,'Chandan Bara','Bihar','India'),(206,'Chanpatia','Bihar','India'),(207,'Chhapra','Bihar','India'),(208,'Colgong','Bihar','India'),(209,'Dalsinghsarai','Bihar','India'),(210,'Darbhanga','Bihar','India'),(211,'Daudnagar','Bihar','India'),(212,'Dehri-on-Sone','Bihar','India'),(213,'Dhaka','Bihar','India'),(214,'Dighwara','Bihar','India'),(215,'Dumraon','Bihar','India'),(216,'Fatwah','Bihar','India'),(217,'Forbesganj','Bihar','India'),(218,'Gaya','Bihar','India'),(219,'Gogri Jamalpur','Bihar','India'),(220,'Gopalganj','Bihar','India'),(221,'Hajipur','Bihar','India'),(222,'Hilsa','Bihar','India'),(223,'Hisua','Bihar','India'),(224,'Islampur','Bihar','India'),(225,'Jagdispur','Bihar','India'),(226,'Jamalpur','Bihar','India'),(227,'Jamui','Bihar','India'),(228,'Jehanabad','Bihar','India'),(229,'Jhajha','Bihar','India'),(230,'Jhanjharpur','Bihar','India'),(231,'Jogabani','Bihar','India'),(232,'Kanti','Bihar','India'),(233,'Katihar','Bihar','India'),(234,'Khagaria','Bihar','India'),(235,'Kharagpur','Bihar','India'),(236,'Kishanganj','Bihar','India'),(237,'Lakhisarai','Bihar','India'),(238,'Lalganj','Bihar','India'),(239,'Madhepura','Bihar','India'),(240,'Madhubani','Bihar','India'),(241,'Maharajganj','Bihar','India'),(242,'Mahnar Bazar','Bihar','India'),(243,'Makhdumpur','Bihar','India'),(244,'Maner','Bihar','India'),(245,'Manihari','Bihar','India'),(246,'Marhaura','Bihar','India'),(247,'Masaurhi','Bihar','India'),(248,'Mirganj','Bihar','India'),(249,'Mokameh','Bihar','India'),(250,'Motihari','Bihar','India'),(251,'Motipur','Bihar','India'),(252,'Munger','Bihar','India'),(253,'Murliganj','Bihar','India'),(254,'Muzaffarpur','Bihar','India'),(255,'Narkatiaganj','Bihar','India'),(256,'Naugachhia','Bihar','India'),(257,'Nawada','Bihar','India'),(258,'Nokha','Bihar','India'),(259,'Patna','Bihar','India'),(260,'Piro','Bihar','India'),(261,'Purnia','Bihar','India'),(262,'Rafiganj','Bihar','India'),(263,'Rajgir','Bihar','India'),(264,'Ramnagar','Bihar','India'),(265,'Raxaul Bazar','Bihar','India'),(266,'Revelganj','Bihar','India'),(267,'Rosera','Bihar','India'),(268,'Saharsa','Bihar','India'),(269,'Samastipur','Bihar','India'),(270,'Sasaram','Bihar','India'),(271,'Sheikhpura','Bihar','India'),(272,'Sheohar','Bihar','India'),(273,'Sherghati','Bihar','India'),(274,'Silao','Bihar','India'),(275,'Sitamarhi','Bihar','India'),(276,'Siwan','Bihar','India'),(277,'Sonepur','Bihar','India'),(278,'Sugauli','Bihar','India'),(279,'Sultanganj','Bihar','India'),(280,'Supaul','Bihar','India'),(281,'Warisaliganj','Bihar','India'),(282,'Ahiwara','Chhattisgarh','India'),(283,'Akaltara','Chhattisgarh','India'),(284,'Ambagarh Chowki','Chhattisgarh','India'),(285,'Ambikapur','Chhattisgarh','India'),(286,'Arang','Chhattisgarh','India'),(287,'Bade Bacheli','Chhattisgarh','India'),(288,'Balod','Chhattisgarh','India'),(289,'Baloda Bazar','Chhattisgarh','India'),(290,'Bemetra','Chhattisgarh','India'),(291,'Bhatapara','Chhattisgarh','India'),(292,'Bilaspur','Chhattisgarh','India'),(293,'Birgaon','Chhattisgarh','India'),(294,'Champa','Chhattisgarh','India'),(295,'Chirmiri','Chhattisgarh','India'),(296,'Dalli-Rajhara','Chhattisgarh','India'),(297,'Dhamtari','Chhattisgarh','India'),(298,'Dipka','Chhattisgarh','India'),(299,'Dongargarh','Chhattisgarh','India'),(300,'Durg-Bhilai Nagar','Chhattisgarh','India'),(301,'Gobranawapara','Chhattisgarh','India'),(302,'Jagdalpur','Chhattisgarh','India'),(303,'Janjgir','Chhattisgarh','India'),(304,'Jashpurnagar','Chhattisgarh','India'),(305,'Kanker','Chhattisgarh','India'),(306,'Kawardha','Chhattisgarh','India'),(307,'Kondagaon','Chhattisgarh','India'),(308,'Korba','Chhattisgarh','India'),(309,'Mahasamund','Chhattisgarh','India'),(310,'Mahendragarh','Chhattisgarh','India'),(311,'Mungeli','Chhattisgarh','India'),(312,'Naila Janjgir','Chhattisgarh','India'),(313,'Raigarh','Chhattisgarh','India'),(314,'Raipur','Chhattisgarh','India'),(315,'Rajnandgaon','Chhattisgarh','India'),(316,'Sakti','Chhattisgarh','India'),(317,'Tilda Newra','Chhattisgarh','India'),(318,'Amli','Dadra & Nagar Haveli','India'),(319,'Silvassa','Dadra and Nagar Haveli','India'),(320,'Daman and Diu','Daman & Diu','India'),(321,'Daman and Diu','Daman & Diu','India'),(322,'Asola','Delhi','India'),(323,'Delhi','Delhi','India'),(324,'Aldona','Goa','India'),(325,'Curchorem Cacora','Goa','India'),(326,'Madgaon','Goa','India'),(327,'Mapusa','Goa','India'),(328,'Margao','Goa','India'),(329,'Marmagao','Goa','India'),(330,'Panaji','Goa','India'),(331,'Ahmedabad','Gujarat','India'),(332,'Amreli','Gujarat','India'),(333,'Anand','Gujarat','India'),(334,'Ankleshwar','Gujarat','India'),(335,'Bharuch','Gujarat','India'),(336,'Bhavnagar','Gujarat','India'),(337,'Bhuj','Gujarat','India'),(338,'Cambay','Gujarat','India'),(339,'Dahod','Gujarat','India'),(340,'Deesa','Gujarat','India'),(341,'Dharampur','Himachal Pradesh','India'),(342,'Dholka','Gujarat','India'),(343,'Gandhinagar','Gujarat','India'),(344,'Godhra','Gujarat','India'),(345,'Himatnagar','Gujarat','India'),(346,'Idar','Gujarat','India'),(347,'Jamnagar','Gujarat','India'),(348,'Junagadh','Gujarat','India'),(349,'Kadi','Gujarat','India'),(350,'Kalavad','Gujarat','India'),(351,'Kalol','Gujarat','India'),(352,'Kapadvanj','Gujarat','India'),(353,'Karjan','Gujarat','India'),(354,'Keshod','Gujarat','India'),(355,'Khambhalia','Gujarat','India'),(356,'Khambhat','Gujarat','India'),(357,'Kheda','Gujarat','India'),(358,'Khedbrahma','Gujarat','India'),(359,'Kheralu','Gujarat','India'),(360,'Kodinar','Gujarat','India'),(361,'Lathi','Gujarat','India'),(362,'Limbdi','Gujarat','India'),(363,'Lunawada','Gujarat','India'),(364,'Mahesana','Gujarat','India'),(365,'Mahuva','Gujarat','India'),(366,'Manavadar','Gujarat','India'),(367,'Mandvi','Gujarat','India'),(368,'Mangrol','Gujarat','India'),(369,'Mansa','Gujarat','India'),(370,'Mehmedabad','Gujarat','India'),(371,'Modasa','Gujarat','India'),(372,'Morvi','Gujarat','India'),(373,'Nadiad','Gujarat','India'),(374,'Navsari','Gujarat','India'),(375,'Padra','Gujarat','India'),(376,'Palanpur','Gujarat','India'),(377,'Palitana','Gujarat','India'),(378,'Pardi','Gujarat','India'),(379,'Patan','Gujarat','India'),(380,'Petlad','Gujarat','India'),(381,'Porbandar','Gujarat','India'),(382,'Radhanpur','Gujarat','India'),(383,'Rajkot','Gujarat','India'),(384,'Rajpipla','Gujarat','India'),(385,'Rajula','Gujarat','India'),(386,'Ranavav','Gujarat','India'),(387,'Rapar','Gujarat','India'),(388,'Salaya','Gujarat','India'),(389,'Sanand','Gujarat','India'),(390,'Savarkundla','Gujarat','India'),(391,'Sidhpur','Gujarat','India'),(392,'Sihor','Gujarat','India'),(393,'Songadh','Gujarat','India'),(394,'Surat','Gujarat','India'),(395,'Talaja','Gujarat','India'),(396,'Thangadh','Gujarat','India'),(397,'Tharad','Gujarat','India'),(398,'Umbergaon','Gujarat','India'),(399,'Umreth','Gujarat','India'),(400,'Una','Gujarat','India'),(401,'Unjha','Gujarat','India'),(402,'Upleta','Gujarat','India'),(403,'Vadnagar','Gujarat','India'),(404,'Vadodara','Gujarat','India'),(405,'Valsad','Gujarat','India'),(406,'Vapi','Gujarat','India'),(407,'Vapi','Gujarat','India'),(408,'Veraval','Gujarat','India'),(409,'Vijapur','Gujarat','India'),(410,'Viramgam','Gujarat','India'),(411,'Visnagar','Gujarat','India'),(412,'Vyara','Gujarat','India'),(413,'Wadhwan','Gujarat','India'),(414,'Wankaner','Gujarat','India'),(415,'Adalaj','Gujrat','India'),(416,'Adityana','Gujrat','India'),(417,'Alang','Gujrat','India'),(418,'Ambaji','Gujrat','India'),(419,'Ambaliyasan','Gujrat','India'),(420,'Andada','Gujrat','India'),(421,'Anjar','Gujrat','India'),(422,'Anklav','Gujrat','India'),(423,'Antaliya','Gujrat','India'),(424,'Arambhada','Gujrat','India'),(425,'Atul','Gujrat','India'),(426,'Ballabhgarh','Hariyana','India'),(427,'Ambala','Haryana','India'),(428,'Ambala','Haryana','India'),(429,'Asankhurd','Haryana','India'),(430,'Assandh','Haryana','India'),(431,'Ateli','Haryana','India'),(432,'Babiyal','Haryana','India'),(433,'Bahadurgarh','Haryana','India'),(434,'Barwala','Haryana','India'),(435,'Bhiwani','Haryana','India'),(436,'Charkhi Dadri','Haryana','India'),(437,'Cheeka','Haryana','India'),(438,'Ellenabad 2','Haryana','India'),(439,'Faridabad','Haryana','India'),(440,'Fatehabad','Haryana','India'),(441,'Ganaur','Haryana','India'),(442,'Gharaunda','Haryana','India'),(443,'Gohana','Haryana','India'),(444,'Gurgaon','Haryana','India'),(445,'Haibat(Yamuna Nagar)','Haryana','India'),(446,'Hansi','Haryana','India'),(447,'Hisar','Haryana','India'),(448,'Hodal','Haryana','India'),(449,'Jhajjar','Haryana','India'),(450,'Jind','Haryana','India'),(451,'Kaithal','Haryana','India'),(452,'Kalan Wali','Haryana','India'),(453,'Kalka','Haryana','India'),(454,'Karnal','Haryana','India'),(455,'Ladwa','Haryana','India'),(456,'Mahendragarh','Haryana','India'),(457,'Mandi Dabwali','Haryana','India'),(458,'Narnaul','Haryana','India'),(459,'Narwana','Haryana','India'),(460,'Palwal','Haryana','India'),(461,'Panchkula','Haryana','India'),(462,'Panipat','Haryana','India'),(463,'Pehowa','Haryana','India'),(464,'Pinjore','Haryana','India'),(465,'Rania','Haryana','India'),(466,'Ratia','Haryana','India'),(467,'Rewari','Haryana','India'),(468,'Rohtak','Haryana','India'),(469,'Safidon','Haryana','India'),(470,'Samalkha','Haryana','India'),(471,'Shahbad','Haryana','India'),(472,'Sirsa','Haryana','India'),(473,'Sohna','Haryana','India'),(474,'Sonipat','Haryana','India'),(475,'Taraori','Haryana','India'),(476,'Thanesar','Haryana','India'),(477,'Tohana','Haryana','India'),(478,'Yamunanagar','Haryana','India'),(479,'Arki','Himachal Pradesh','India'),(480,'Baddi','Himachal Pradesh','India'),(481,'Bilaspur','Himachal Pradesh','India'),(482,'Chamba','Himachal Pradesh','India'),(483,'Dalhousie','Himachal Pradesh','India'),(484,'Dharamsala','Himachal Pradesh','India'),(485,'Hamirpur','Himachal Pradesh','India'),(486,'Mandi','Himachal Pradesh','India'),(487,'Nahan','Himachal Pradesh','India'),(488,'Shimla','Himachal Pradesh','India'),(489,'Solan','Himachal Pradesh','India'),(490,'Sundarnagar','Himachal Pradesh','India'),(491,'Jammu','Jammu & Kashmir','India'),(492,'Achabbal','Jammu and Kashmir','India'),(493,'Akhnoor','Jammu and Kashmir','India'),(494,'Anantnag','Jammu and Kashmir','India'),(495,'Arnia','Jammu and Kashmir','India'),(496,'Awantipora','Jammu and Kashmir','India'),(497,'Bandipore','Jammu and Kashmir','India'),(498,'Baramula','Jammu and Kashmir','India'),(499,'Kathua','Jammu and Kashmir','India'),(500,'Leh','Jammu and Kashmir','India'),(501,'Punch','Jammu and Kashmir','India'),(502,'Rajauri','Jammu and Kashmir','India'),(503,'Sopore','Jammu and Kashmir','India'),(504,'Srinagar','Jammu and Kashmir','India'),(505,'Udhampur','Jammu and Kashmir','India'),(506,'Amlabad','Jharkhand','India'),(507,'Ara','Jharkhand','India'),(508,'Barughutu','Jharkhand','India'),(509,'Bokaro Steel City','Jharkhand','India'),(510,'Chaibasa','Jharkhand','India'),(511,'Chakradharpur','Jharkhand','India'),(512,'Chandrapura','Jharkhand','India'),(513,'Chatra','Jharkhand','India'),(514,'Chirkunda','Jharkhand','India'),(515,'Churi','Jharkhand','India'),(516,'Daltonganj','Jharkhand','India'),(517,'Deoghar','Jharkhand','India'),(518,'Dhanbad','Jharkhand','India'),(519,'Dumka','Jharkhand','India'),(520,'Garhwa','Jharkhand','India'),(521,'Ghatshila','Jharkhand','India'),(522,'Giridih','Jharkhand','India'),(523,'Godda','Jharkhand','India'),(524,'Gomoh','Jharkhand','India'),(525,'Gumia','Jharkhand','India'),(526,'Gumla','Jharkhand','India'),(527,'Hazaribag','Jharkhand','India'),(528,'Hussainabad','Jharkhand','India'),(529,'Jamshedpur','Jharkhand','India'),(530,'Jamtara','Jharkhand','India'),(531,'Jhumri Tilaiya','Jharkhand','India'),(532,'Khunti','Jharkhand','India'),(533,'Lohardaga','Jharkhand','India'),(534,'Madhupur','Jharkhand','India'),(535,'Mihijam','Jharkhand','India'),(536,'Musabani','Jharkhand','India'),(537,'Pakaur','Jharkhand','India'),(538,'Patratu','Jharkhand','India'),(539,'Phusro','Jharkhand','India'),(540,'Ramngarh','Jharkhand','India'),(541,'Ranchi','Jharkhand','India'),(542,'Sahibganj','Jharkhand','India'),(543,'Saunda','Jharkhand','India'),(544,'Simdega','Jharkhand','India'),(545,'Tenu Dam-cum- Kathhara','Jharkhand','India'),(546,'Arasikere','Karnataka','India'),(547,'Bangalore','Karnataka','India'),(548,'Belgaum','Karnataka','India'),(549,'Bellary','Karnataka','India'),(550,'Chamrajnagar','Karnataka','India'),(551,'Chikkaballapur','Karnataka','India'),(552,'Chintamani','Karnataka','India'),(553,'Chitradurga','Karnataka','India'),(554,'Gulbarga','Karnataka','India'),(555,'Gundlupet','Karnataka','India'),(556,'Hassan','Karnataka','India'),(557,'Hospet','Karnataka','India'),(558,'Hubli','Karnataka','India'),(559,'Karkala','Karnataka','India'),(560,'Karwar','Karnataka','India'),(561,'Kolar','Karnataka','India'),(562,'Kota','Karnataka','India'),(563,'Lakshmeshwar','Karnataka','India'),(564,'Lingsugur','Karnataka','India'),(565,'Maddur','Karnataka','India'),(566,'Madhugiri','Karnataka','India'),(567,'Madikeri','Karnataka','India'),(568,'Magadi','Karnataka','India'),(569,'Mahalingpur','Karnataka','India'),(570,'Malavalli','Karnataka','India'),(571,'Malur','Karnataka','India'),(572,'Mandya','Karnataka','India'),(573,'Mangalore','Karnataka','India'),(574,'Manvi','Karnataka','India'),(575,'Mudalgi','Karnataka','India'),(576,'Mudbidri','Karnataka','India'),(577,'Muddebihal','Karnataka','India'),(578,'Mudhol','Karnataka','India'),(579,'Mulbagal','Karnataka','India'),(580,'Mundargi','Karnataka','India'),(581,'Mysore','Karnataka','India'),(582,'Nanjangud','Karnataka','India'),(583,'Pavagada','Karnataka','India'),(584,'Puttur','Karnataka','India'),(585,'Rabkavi Banhatti','Karnataka','India'),(586,'Raichur','Karnataka','India'),(587,'Ramanagaram','Karnataka','India'),(588,'Ramdurg','Karnataka','India'),(589,'Ranibennur','Karnataka','India'),(590,'Robertson Pet','Karnataka','India'),(591,'Ron','Karnataka','India'),(592,'Sadalgi','Karnataka','India'),(593,'Sagar','Karnataka','India'),(594,'Sakleshpur','Karnataka','India'),(595,'Sandur','Karnataka','India'),(596,'Sankeshwar','Karnataka','India'),(597,'Saundatti-Yellamma','Karnataka','India'),(598,'Savanur','Karnataka','India'),(599,'Sedam','Karnataka','India'),(600,'Shahabad','Karnataka','India'),(601,'Shahpur','Karnataka','India'),(602,'Shiggaon','Karnataka','India'),(603,'Shikapur','Karnataka','India'),(604,'Shimoga','Karnataka','India'),(605,'Shorapur','Karnataka','India'),(606,'Shrirangapattana','Karnataka','India'),(607,'Sidlaghatta','Karnataka','India'),(608,'Sindgi','Karnataka','India'),(609,'Sindhnur','Karnataka','India'),(610,'Sira','Karnataka','India'),(611,'Sirsi','Karnataka','India'),(612,'Siruguppa','Karnataka','India'),(613,'Srinivaspur','Karnataka','India'),(614,'Talikota','Karnataka','India'),(615,'Tarikere','Karnataka','India'),(616,'Tekkalakota','Karnataka','India'),(617,'Terdal','Karnataka','India'),(618,'Tiptur','Karnataka','India'),(619,'Tumkur','Karnataka','India'),(620,'Udupi','Karnataka','India'),(621,'Vijayapura','Karnataka','India'),(622,'Wadi','Karnataka','India'),(623,'Yadgir','Karnataka','India'),(624,'Adoor','Kerala','India'),(625,'Akathiyoor','Kerala','India'),(626,'Alappuzha','Kerala','India'),(627,'Ancharakandy','Kerala','India'),(628,'Aroor','Kerala','India'),(629,'Ashtamichira','Kerala','India'),(630,'Attingal','Kerala','India'),(631,'Avinissery','Kerala','India'),(632,'Chalakudy','Kerala','India'),(633,'Changanassery','Kerala','India'),(634,'Chendamangalam','Kerala','India'),(635,'Chengannur','Kerala','India'),(636,'Cherthala','Kerala','India'),(637,'Cheruthazham','Kerala','India'),(638,'Chittur-Thathamangalam','Kerala','India'),(639,'Chockli','Kerala','India'),(640,'Erattupetta','Kerala','India'),(641,'Guruvayoor','Kerala','India'),(642,'Irinjalakuda','Kerala','India'),(643,'Kadirur','Kerala','India'),(644,'Kalliasseri','Kerala','India'),(645,'Kalpetta','Kerala','India'),(646,'Kanhangad','Kerala','India'),(647,'Kanjikkuzhi','Kerala','India'),(648,'Kannur','Kerala','India'),(649,'Kasaragod','Kerala','India'),(650,'Kayamkulam','Kerala','India'),(651,'Kochi','Kerala','India'),(652,'Kodungallur','Kerala','India'),(653,'Kollam','Kerala','India'),(654,'Koothuparamba','Kerala','India'),(655,'Kothamangalam','Kerala','India'),(656,'Kottayam','Kerala','India'),(657,'Kozhikode','Kerala','India'),(658,'Kunnamkulam','Kerala','India'),(659,'Malappuram','Kerala','India'),(660,'Mattannur','Kerala','India'),(661,'Mavelikkara','Kerala','India'),(662,'Mavoor','Kerala','India'),(663,'Muvattupuzha','Kerala','India'),(664,'Nedumangad','Kerala','India'),(665,'Neyyattinkara','Kerala','India'),(666,'Ottappalam','Kerala','India'),(667,'Palai','Kerala','India'),(668,'Palakkad','Kerala','India'),(669,'Panniyannur','Kerala','India'),(670,'Pappinisseri','Kerala','India'),(671,'Paravoor','Kerala','India'),(672,'Pathanamthitta','Kerala','India'),(673,'Payyannur','Kerala','India'),(674,'Peringathur','Kerala','India'),(675,'Perinthalmanna','Kerala','India'),(676,'Perumbavoor','Kerala','India'),(677,'Ponnani','Kerala','India'),(678,'Punalur','Kerala','India'),(679,'Quilandy','Kerala','India'),(680,'Shoranur','Kerala','India'),(681,'Taliparamba','Kerala','India'),(682,'Thiruvalla','Kerala','India'),(683,'Thiruvananthapuram','Kerala','India'),(684,'Thodupuzha','Kerala','India'),(685,'Thrissur','Kerala','India'),(686,'Tirur','Kerala','India'),(687,'Vadakara','Kerala','India'),(688,'Vaikom','Kerala','India'),(689,'Varkala','Kerala','India'),(690,'Kavaratti','Lakshadweep','India'),(691,'Ashok Nagar','Madhya Pradesh','India'),(692,'Balaghat','Madhya Pradesh','India'),(693,'Betul','Madhya Pradesh','India'),(694,'Bhopal','Madhya Pradesh','India'),(695,'Burhanpur','Madhya Pradesh','India'),(696,'Chhatarpur','Madhya Pradesh','India'),(697,'Dabra','Madhya Pradesh','India'),(698,'Datia','Madhya Pradesh','India'),(699,'Dewas','Madhya Pradesh','India'),(700,'Dhar','Madhya Pradesh','India'),(701,'Fatehabad','Madhya Pradesh','India'),(702,'Gwalior','Madhya Pradesh','India'),(703,'Indore','Madhya Pradesh','India'),(704,'Itarsi','Madhya Pradesh','India'),(705,'Jabalpur','Madhya Pradesh','India'),(706,'Katni','Madhya Pradesh','India'),(707,'Kotma','Madhya Pradesh','India'),(708,'Lahar','Madhya Pradesh','India'),(709,'Lundi','Madhya Pradesh','India'),(710,'Maharajpur','Madhya Pradesh','India'),(711,'Mahidpur','Madhya Pradesh','India'),(712,'Maihar','Madhya Pradesh','India'),(713,'Malajkhand','Madhya Pradesh','India'),(714,'Manasa','Madhya Pradesh','India'),(715,'Manawar','Madhya Pradesh','India'),(716,'Mandideep','Madhya Pradesh','India'),(717,'Mandla','Madhya Pradesh','India'),(718,'Mandsaur','Madhya Pradesh','India'),(719,'Mauganj','Madhya Pradesh','India'),(720,'Mhow Cantonment','Madhya Pradesh','India'),(721,'Mhowgaon','Madhya Pradesh','India'),(722,'Morena','Madhya Pradesh','India'),(723,'Multai','Madhya Pradesh','India'),(724,'Murwara','Madhya Pradesh','India'),(725,'Nagda','Madhya Pradesh','India'),(726,'Nainpur','Madhya Pradesh','India'),(727,'Narsinghgarh','Madhya Pradesh','India'),(728,'Narsinghgarh','Madhya Pradesh','India'),(729,'Neemuch','Madhya Pradesh','India'),(730,'Nepanagar','Madhya Pradesh','India'),(731,'Niwari','Madhya Pradesh','India'),(732,'Nowgong','Madhya Pradesh','India'),(733,'Nowrozabad','Madhya Pradesh','India'),(734,'Pachore','Madhya Pradesh','India'),(735,'Pali','Madhya Pradesh','India'),(736,'Panagar','Madhya Pradesh','India'),(737,'Pandhurna','Madhya Pradesh','India'),(738,'Panna','Madhya Pradesh','India'),(739,'Pasan','Madhya Pradesh','India'),(740,'Pipariya','Madhya Pradesh','India'),(741,'Pithampur','Madhya Pradesh','India'),(742,'Porsa','Madhya Pradesh','India'),(743,'Prithvipur','Madhya Pradesh','India'),(744,'Raghogarh-Vijaypur','Madhya Pradesh','India'),(745,'Rahatgarh','Madhya Pradesh','India'),(746,'Raisen','Madhya Pradesh','India'),(747,'Rajgarh','Madhya Pradesh','India'),(748,'Ratlam','Madhya Pradesh','India'),(749,'Rau','Madhya Pradesh','India'),(750,'Rehli','Madhya Pradesh','India'),(751,'Rewa','Madhya Pradesh','India'),(752,'Sabalgarh','Madhya Pradesh','India'),(753,'Sagar','Madhya Pradesh','India'),(754,'Sanawad','Madhya Pradesh','India'),(755,'Sarangpur','Madhya Pradesh','India'),(756,'Sarni','Madhya Pradesh','India'),(757,'Satna','Madhya Pradesh','India'),(758,'Sausar','Madhya Pradesh','India'),(759,'Sehore','Madhya Pradesh','India'),(760,'Sendhwa','Madhya Pradesh','India'),(761,'Seoni','Madhya Pradesh','India'),(762,'Seoni-Malwa','Madhya Pradesh','India'),(763,'Shahdol','Madhya Pradesh','India'),(764,'Shajapur','Madhya Pradesh','India'),(765,'Shamgarh','Madhya Pradesh','India'),(766,'Sheopur','Madhya Pradesh','India'),(767,'Shivpuri','Madhya Pradesh','India'),(768,'Shujalpur','Madhya Pradesh','India'),(769,'Sidhi','Madhya Pradesh','India'),(770,'Sihora','Madhya Pradesh','India'),(771,'Singrauli','Madhya Pradesh','India'),(772,'Sironj','Madhya Pradesh','India'),(773,'Sohagpur','Madhya Pradesh','India'),(774,'Tarana','Madhya Pradesh','India'),(775,'Tikamgarh','Madhya Pradesh','India'),(776,'Ujhani','Madhya Pradesh','India'),(777,'Ujjain','Madhya Pradesh','India'),(778,'Umaria','Madhya Pradesh','India'),(779,'Vidisha','Madhya Pradesh','India'),(780,'Wara Seoni','Madhya Pradesh','India'),(781,'Ahmednagar','Maharashtra','India'),(782,'Akola','Maharashtra','India'),(783,'Amravati','Maharashtra','India'),(784,'Aurangabad','Maharashtra','India'),(785,'Baramati','Maharashtra','India'),(786,'Chalisgaon','Maharashtra','India'),(787,'Chinchani','Maharashtra','India'),(788,'Devgarh','Maharashtra','India'),(789,'Dhule','Maharashtra','India'),(790,'Dombivli','Maharashtra','India'),(791,'Durgapur','Maharashtra','India'),(792,'Ichalkaranji','Maharashtra','India'),(793,'Jalna','Maharashtra','India'),(794,'Kalyan','Maharashtra','India'),(795,'Latur','Maharashtra','India'),(796,'Loha','Maharashtra','India'),(797,'Lonar','Maharashtra','India'),(798,'Lonavla','Maharashtra','India'),(799,'Mahad','Maharashtra','India'),(800,'Mahuli','Maharashtra','India'),(801,'Malegaon','Maharashtra','India'),(802,'Malkapur','Maharashtra','India'),(803,'Manchar','Maharashtra','India'),(804,'Mangalvedhe','Maharashtra','India'),(805,'Mangrulpir','Maharashtra','India'),(806,'Manjlegaon','Maharashtra','India'),(807,'Manmad','Maharashtra','India'),(808,'Manwath','Maharashtra','India'),(809,'Mehkar','Maharashtra','India'),(810,'Mhaswad','Maharashtra','India'),(811,'Miraj','Maharashtra','India'),(812,'Morshi','Maharashtra','India'),(813,'Mukhed','Maharashtra','India'),(814,'Mul','Maharashtra','India'),(815,'Mumbai','Maharashtra','India'),(816,'Murtijapur','Maharashtra','India'),(817,'Nagpur','Maharashtra','India'),(818,'Nalasopara','Maharashtra','India'),(819,'Nanded-Waghala','Maharashtra','India'),(820,'Nandgaon','Maharashtra','India'),(821,'Nandura','Maharashtra','India'),(822,'Nandurbar','Maharashtra','India'),(823,'Narkhed','Maharashtra','India'),(824,'Nashik','Maharashtra','India'),(825,'Navi Mumbai','Maharashtra','India'),(826,'Nawapur','Maharashtra','India'),(827,'Nilanga','Maharashtra','India'),(828,'Osmanabad','Maharashtra','India'),(829,'Ozar','Maharashtra','India'),(830,'Pachora','Maharashtra','India'),(831,'Paithan','Maharashtra','India'),(832,'Palghar','Maharashtra','India'),(833,'Pandharkaoda','Maharashtra','India'),(834,'Pandharpur','Maharashtra','India'),(835,'Panvel','Maharashtra','India'),(836,'Parbhani','Maharashtra','India'),(837,'Parli','Maharashtra','India'),(838,'Parola','Maharashtra','India'),(839,'Partur','Maharashtra','India'),(840,'Pathardi','Maharashtra','India'),(841,'Pathri','Maharashtra','India'),(842,'Patur','Maharashtra','India'),(843,'Pauni','Maharashtra','India'),(844,'Pen','Maharashtra','India'),(845,'Phaltan','Maharashtra','India'),(846,'Pulgaon','Maharashtra','India'),(847,'Pune','Maharashtra','India'),(848,'Purna','Maharashtra','India'),(849,'Pusad','Maharashtra','India'),(850,'Rahuri','Maharashtra','India'),(851,'Rajura','Maharashtra','India'),(852,'Ramtek','Maharashtra','India'),(853,'Ratnagiri','Maharashtra','India'),(854,'Raver','Maharashtra','India'),(855,'Risod','Maharashtra','India'),(856,'Sailu','Maharashtra','India'),(857,'Sangamner','Maharashtra','India'),(858,'Sangli','Maharashtra','India'),(859,'Sangole','Maharashtra','India'),(860,'Sasvad','Maharashtra','India'),(861,'Satana','Maharashtra','India'),(862,'Satara','Maharashtra','India'),(863,'Savner','Maharashtra','India'),(864,'Sawantwadi','Maharashtra','India'),(865,'Shahade','Maharashtra','India'),(866,'Shegaon','Maharashtra','India'),(867,'Shendurjana','Maharashtra','India'),(868,'Shirdi','Maharashtra','India'),(869,'Shirpur-Warwade','Maharashtra','India'),(870,'Shirur','Maharashtra','India'),(871,'Shrigonda','Maharashtra','India'),(872,'Shrirampur','Maharashtra','India'),(873,'Sillod','Maharashtra','India'),(874,'Sinnar','Maharashtra','India'),(875,'Solapur','Maharashtra','India'),(876,'Soyagaon','Maharashtra','India'),(877,'Talegaon Dabhade','Maharashtra','India'),(878,'Talode','Maharashtra','India'),(879,'Tasgaon','Maharashtra','India'),(880,'Tirora','Maharashtra','India'),(881,'Tuljapur','Maharashtra','India'),(882,'Tumsar','Maharashtra','India'),(883,'Uran','Maharashtra','India'),(884,'Uran Islampur','Maharashtra','India'),(885,'Wadgaon Road','Maharashtra','India'),(886,'Wai','Maharashtra','India'),(887,'Wani','Maharashtra','India'),(888,'Wardha','Maharashtra','India'),(889,'Warora','Maharashtra','India'),(890,'Warud','Maharashtra','India'),(891,'Washim','Maharashtra','India'),(892,'Yevla','Maharashtra','India'),(893,'Uchgaon','Maharastra','India'),(894,'Udgir','Maharastra','India'),(895,'Umarga','Maharastra','India'),(896,'Umarkhed','Maharastra','India'),(897,'Umred','Maharastra','India'),(898,'Vadgaon Kasba','Maharastra','India'),(899,'Vaijapur','Maharastra','India'),(900,'Vasai','Maharastra','India'),(901,'Virar','Maharastra','India'),(902,'Vita','Maharastra','India'),(903,'Yavatmal','Maharastra','India'),(904,'Yawal','Maharastra','India'),(905,'Imphal','Manipur','India'),(906,'Kakching','Manipur','India'),(907,'Lilong','Manipur','India'),(908,'Mayang Imphal','Manipur','India'),(909,'Thoubal','Manipur','India'),(910,'Jowai','Meghalaya','India'),(911,'Nongstoin','Meghalaya','India'),(912,'Shillong','Meghalaya','India'),(913,'Tura','Meghalaya','India'),(914,'Aizawl','Mizoram','India'),(915,'Champhai','Mizoram','India'),(916,'Lunglei','Mizoram','India'),(917,'Saiha','Mizoram','India'),(918,'Dimapur','Nagaland','India'),(919,'Kohima','Nagaland','India'),(920,'Mokokchung','Nagaland','India'),(921,'Tuensang','Nagaland','India'),(922,'Wokha','Nagaland','India'),(923,'Zunheboto','Nagaland','India'),(924,'Anandapur','Orissa','India'),(925,'Anugul','Orissa','India'),(926,'Asika','Orissa','India'),(927,'Balangir','Orissa','India'),(928,'Balasore','Orissa','India'),(929,'Baleshwar','Orissa','India'),(930,'Bamra','Orissa','India'),(931,'Barbil','Orissa','India'),(932,'Bargarh','Orissa','India'),(933,'Bargarh','Orissa','India'),(934,'Baripada','Orissa','India'),(935,'Basudebpur','Orissa','India'),(936,'Belpahar','Orissa','India'),(937,'Bhadrak','Orissa','India'),(938,'Bhawanipatna','Orissa','India'),(939,'Bhuban','Orissa','India'),(940,'Bhubaneswar','Orissa','India'),(941,'Biramitrapur','Orissa','India'),(942,'Brahmapur','Orissa','India'),(943,'Brajrajnagar','Orissa','India'),(944,'Byasanagar','Orissa','India'),(945,'Cuttack','Orissa','India'),(946,'Debagarh','Orissa','India'),(947,'Dhenkanal','Orissa','India'),(948,'Gunupur','Orissa','India'),(949,'Hinjilicut','Orissa','India'),(950,'Jagatsinghapur','Orissa','India'),(951,'Jajapur','Orissa','India'),(952,'Jaleswar','Orissa','India'),(953,'Jatani','Orissa','India'),(954,'Jeypur','Orissa','India'),(955,'Jharsuguda','Orissa','India'),(956,'Joda','Orissa','India'),(957,'Kantabanji','Orissa','India'),(958,'Karanjia','Orissa','India'),(959,'Kendrapara','Orissa','India'),(960,'Kendujhar','Orissa','India'),(961,'Khordha','Orissa','India'),(962,'Koraput','Orissa','India'),(963,'Malkangiri','Orissa','India'),(964,'Nabarangapur','Orissa','India'),(965,'Paradip','Orissa','India'),(966,'Parlakhemundi','Orissa','India'),(967,'Pattamundai','Orissa','India'),(968,'Phulabani','Orissa','India'),(969,'Puri','Orissa','India'),(970,'Rairangpur','Orissa','India'),(971,'Rajagangapur','Orissa','India'),(972,'Raurkela','Orissa','India'),(973,'Rayagada','Orissa','India'),(974,'Sambalpur','Orissa','India'),(975,'Soro','Orissa','India'),(976,'Sunabeda','Orissa','India'),(977,'Sundargarh','Orissa','India'),(978,'Talcher','Orissa','India'),(979,'Titlagarh','Orissa','India'),(980,'Umarkote','Orissa','India'),(981,'Karaikal','Pondicherry','India'),(982,'Mahe','Pondicherry','India'),(983,'Pondicherry','Pondicherry','India'),(984,'Yanam','Pondicherry','India'),(985,'Ahmedgarh','Punjab','India'),(986,'Amritsar','Punjab','India'),(987,'Barnala','Punjab','India'),(988,'Batala','Punjab','India'),(989,'Bathinda','Punjab','India'),(990,'Bhagha Purana','Punjab','India'),(991,'Budhlada','Punjab','India'),(992,'Chandigarh','Punjab','India'),(993,'Dasua','Punjab','India'),(994,'Dhuri','Punjab','India'),(995,'Dinanagar','Punjab','India'),(996,'Faridkot','Punjab','India'),(997,'Fazilka','Punjab','India'),(998,'Firozpur','Punjab','India'),(999,'Firozpur Cantt.','Punjab','India'),(1000,'Giddarbaha','Punjab','India'),(1001,'Gobindgarh','Punjab','India'),(1002,'Gurdaspur','Punjab','India'),(1003,'Hoshiarpur','Punjab','India'),(1004,'Jagraon','Punjab','India'),(1005,'Jaitu','Punjab','India'),(1006,'Jalalabad','Punjab','India'),(1007,'Jalandhar','Punjab','India'),(1008,'Jalandhar Cantt.','Punjab','India'),(1009,'Jandiala','Punjab','India'),(1010,'Kapurthala','Punjab','India'),(1011,'Karoran','Punjab','India'),(1012,'Kartarpur','Punjab','India'),(1013,'Khanna','Punjab','India'),(1014,'Kharar','Punjab','India'),(1015,'Kot Kapura','Punjab','India'),(1016,'Kurali','Punjab','India'),(1017,'Longowal','Punjab','India'),(1018,'Ludhiana','Punjab','India'),(1019,'Malerkotla','Punjab','India'),(1020,'Malout','Punjab','India'),(1021,'Mansa','Punjab','India'),(1022,'Maur','Punjab','India'),(1023,'Moga','Punjab','India'),(1024,'Mohali','Punjab','India'),(1025,'Morinda','Punjab','India'),(1026,'Mukerian','Punjab','India'),(1027,'Muktsar','Punjab','India'),(1028,'Nabha','Punjab','India'),(1029,'Nakodar','Punjab','India'),(1030,'Nangal','Punjab','India'),(1031,'Nawanshahr','Punjab','India'),(1032,'Pathankot','Punjab','India'),(1033,'Patiala','Punjab','India'),(1034,'Patran','Punjab','India'),(1035,'Patti','Punjab','India'),(1036,'Phagwara','Punjab','India'),(1037,'Phillaur','Punjab','India'),(1038,'Qadian','Punjab','India'),(1039,'Raikot','Punjab','India'),(1040,'Rajpura','Punjab','India'),(1041,'Rampura Phul','Punjab','India'),(1042,'Rupnagar','Punjab','India'),(1043,'Samana','Punjab','India'),(1044,'Sangrur','Punjab','India'),(1045,'Sirhind Fatehgarh Sahib','Punjab','India'),(1046,'Sujanpur','Punjab','India'),(1047,'Sunam','Punjab','India'),(1048,'Talwara','Punjab','India'),(1049,'Tarn Taran','Punjab','India'),(1050,'Urmar Tanda','Punjab','India'),(1051,'Zira','Punjab','India'),(1052,'Zirakpur','Punjab','India'),(1053,'Bali','Rajastan','India'),(1054,'Banswara','Rajastan','India'),(1055,'Ajmer','Rajasthan','India'),(1056,'Alwar','Rajasthan','India'),(1057,'Bandikui','Rajasthan','India'),(1058,'Baran','Rajasthan','India'),(1059,'Barmer','Rajasthan','India'),(1060,'Bikaner','Rajasthan','India'),(1061,'Fatehpur','Rajasthan','India'),(1062,'Jaipur','Rajasthan','India'),(1063,'Jaisalmer','Rajasthan','India'),(1064,'Jodhpur','Rajasthan','India'),(1065,'Kota','Rajasthan','India'),(1066,'Lachhmangarh','Rajasthan','India'),(1067,'Ladnu','Rajasthan','India'),(1068,'Lakheri','Rajasthan','India'),(1069,'Lalsot','Rajasthan','India'),(1070,'Losal','Rajasthan','India'),(1071,'Makrana','Rajasthan','India'),(1072,'Malpura','Rajasthan','India'),(1073,'Mandalgarh','Rajasthan','India'),(1074,'Mandawa','Rajasthan','India'),(1075,'Mangrol','Rajasthan','India'),(1076,'Merta City','Rajasthan','India'),(1077,'Mount Abu','Rajasthan','India'),(1078,'Nadbai','Rajasthan','India'),(1079,'Nagar','Rajasthan','India'),(1080,'Nagaur','Rajasthan','India'),(1081,'Nargund','Rajasthan','India'),(1082,'Nasirabad','Rajasthan','India'),(1083,'Nathdwara','Rajasthan','India'),(1084,'Navalgund','Rajasthan','India'),(1085,'Nawalgarh','Rajasthan','India'),(1086,'Neem-Ka-Thana','Rajasthan','India'),(1087,'Nelamangala','Rajasthan','India'),(1088,'Nimbahera','Rajasthan','India'),(1089,'Nipani','Rajasthan','India'),(1090,'Niwai','Rajasthan','India'),(1091,'Nohar','Rajasthan','India'),(1092,'Nokha','Rajasthan','India'),(1093,'Pali','Rajasthan','India'),(1094,'Phalodi','Rajasthan','India'),(1095,'Phulera','Rajasthan','India'),(1096,'Pilani','Rajasthan','India'),(1097,'Pilibanga','Rajasthan','India'),(1098,'Pindwara','Rajasthan','India'),(1099,'Pipar City','Rajasthan','India'),(1100,'Prantij','Rajasthan','India'),(1101,'Pratapgarh','Rajasthan','India'),(1102,'Raisinghnagar','Rajasthan','India'),(1103,'Rajakhera','Rajasthan','India'),(1104,'Rajaldesar','Rajasthan','India'),(1105,'Rajgarh (Alwar)','Rajasthan','India'),(1106,'Rajgarh (Churu','Rajasthan','India'),(1107,'Rajsamand','Rajasthan','India'),(1108,'Ramganj Mandi','Rajasthan','India'),(1109,'Ramngarh','Rajasthan','India'),(1110,'Ratangarh','Rajasthan','India'),(1111,'Rawatbhata','Rajasthan','India'),(1112,'Rawatsar','Rajasthan','India'),(1113,'Reengus','Rajasthan','India'),(1114,'Sadri','Rajasthan','India'),(1115,'Sadulshahar','Rajasthan','India'),(1116,'Sagwara','Rajasthan','India'),(1117,'Sambhar','Rajasthan','India'),(1118,'Sanchore','Rajasthan','India'),(1119,'Sangaria','Rajasthan','India'),(1120,'Sardarshahar','Rajasthan','India'),(1121,'Sawai Madhopur','Rajasthan','India'),(1122,'Shahpura','Rajasthan','India'),(1123,'Shahpura','Rajasthan','India'),(1124,'Sheoganj','Rajasthan','India'),(1125,'Sikar','Rajasthan','India'),(1126,'Sirohi','Rajasthan','India'),(1127,'Sojat','Rajasthan','India'),(1128,'Sri Madhopur','Rajasthan','India'),(1129,'Sujangarh','Rajasthan','India'),(1130,'Sumerpur','Rajasthan','India'),(1131,'Suratgarh','Rajasthan','India'),(1132,'Taranagar','Rajasthan','India'),(1133,'Todabhim','Rajasthan','India'),(1134,'Todaraisingh','Rajasthan','India'),(1135,'Tonk','Rajasthan','India'),(1136,'Udaipur','Rajasthan','India'),(1137,'Udaipurwati','Rajasthan','India'),(1138,'Vijainagar','Rajasthan','India'),(1139,'Gangtok','Sikkim','India'),(1140,'Calcutta','West Bengal','India'),(1141,'Arakkonam','Tamil Nadu','India'),(1142,'Arcot','Tamil Nadu','India'),(1143,'Aruppukkottai','Tamil Nadu','India'),(1144,'Bhavani','Tamil Nadu','India'),(1145,'Chengalpattu','Tamil Nadu','India'),(1146,'Chennai','Tamil Nadu','India'),(1147,'Chinna salem','Tamil nadu','India'),(1148,'Coimbatore','Tamil Nadu','India'),(1149,'Coonoor','Tamil Nadu','India'),(1150,'Cuddalore','Tamil Nadu','India'),(1151,'Dharmapuri','Tamil Nadu','India'),(1152,'Dindigul','Tamil Nadu','India'),(1153,'Erode','Tamil Nadu','India'),(1154,'Gudalur','Tamil Nadu','India'),(1155,'Gudalur','Tamil Nadu','India'),(1156,'Gudalur','Tamil Nadu','India'),(1157,'Kanchipuram','Tamil Nadu','India'),(1158,'Karaikudi','Tamil Nadu','India'),(1159,'Karungal','Tamil Nadu','India'),(1160,'Karur','Tamil Nadu','India'),(1161,'Kollankodu','Tamil Nadu','India'),(1162,'Lalgudi','Tamil Nadu','India'),(1163,'Madurai','Tamil Nadu','India'),(1164,'Nagapattinam','Tamil Nadu','India'),(1165,'Nagercoil','Tamil Nadu','India'),(1166,'Namagiripettai','Tamil Nadu','India'),(1167,'Namakkal','Tamil Nadu','India'),(1168,'Nandivaram-Guduvancheri','Tamil Nadu','India'),(1169,'Nanjikottai','Tamil Nadu','India'),(1170,'Natham','Tamil Nadu','India'),(1171,'Nellikuppam','Tamil Nadu','India'),(1172,'Neyveli','Tamil Nadu','India'),(1173,'O\' Valley','Tamil Nadu','India'),(1174,'Oddanchatram','Tamil Nadu','India'),(1175,'P.N.Patti','Tamil Nadu','India'),(1176,'Pacode','Tamil Nadu','India'),(1177,'Padmanabhapuram','Tamil Nadu','India'),(1178,'Palani','Tamil Nadu','India'),(1179,'Palladam','Tamil Nadu','India'),(1180,'Pallapatti','Tamil Nadu','India'),(1181,'Pallikonda','Tamil Nadu','India'),(1182,'Panagudi','Tamil Nadu','India'),(1183,'Panruti','Tamil Nadu','India'),(1184,'Paramakudi','Tamil Nadu','India'),(1185,'Parangipettai','Tamil Nadu','India'),(1186,'Pattukkottai','Tamil Nadu','India'),(1187,'Perambalur','Tamil Nadu','India'),(1188,'Peravurani','Tamil Nadu','India'),(1189,'Periyakulam','Tamil Nadu','India'),(1190,'Periyasemur','Tamil Nadu','India'),(1191,'Pernampattu','Tamil Nadu','India'),(1192,'Pollachi','Tamil Nadu','India'),(1193,'Polur','Tamil Nadu','India'),(1194,'Ponneri','Tamil Nadu','India'),(1195,'Pudukkottai','Tamil Nadu','India'),(1196,'Pudupattinam','Tamil Nadu','India'),(1197,'Puliyankudi','Tamil Nadu','India'),(1198,'Punjaipugalur','Tamil Nadu','India'),(1199,'Rajapalayam','Tamil Nadu','India'),(1200,'Ramanathapuram','Tamil Nadu','India'),(1201,'Rameshwaram','Tamil Nadu','India'),(1202,'Rasipuram','Tamil Nadu','India'),(1203,'Salem','Tamil Nadu','India'),(1204,'Sankarankoil','Tamil Nadu','India'),(1205,'Sankari','Tamil Nadu','India'),(1206,'Sathyamangalam','Tamil Nadu','India'),(1207,'Sattur','Tamil Nadu','India'),(1208,'Shenkottai','Tamil Nadu','India'),(1209,'Sholavandan','Tamil Nadu','India'),(1210,'Sholingur','Tamil Nadu','India'),(1211,'Sirkali','Tamil Nadu','India'),(1212,'Sivaganga','Tamil Nadu','India'),(1213,'Sivagiri','Tamil Nadu','India'),(1214,'Sivakasi','Tamil Nadu','India'),(1215,'Srivilliputhur','Tamil Nadu','India'),(1216,'Surandai','Tamil Nadu','India'),(1217,'Suriyampalayam','Tamil Nadu','India'),(1218,'Tenkasi','Tamil Nadu','India'),(1219,'Thammampatti','Tamil Nadu','India'),(1220,'Thanjavur','Tamil Nadu','India'),(1221,'Tharamangalam','Tamil Nadu','India'),(1222,'Tharangambadi','Tamil Nadu','India'),(1223,'Theni Allinagaram','Tamil Nadu','India'),(1224,'Thirumangalam','Tamil Nadu','India'),(1225,'Thirunindravur','Tamil Nadu','India'),(1226,'Thiruparappu','Tamil Nadu','India'),(1227,'Thirupuvanam','Tamil Nadu','India'),(1228,'Thiruthuraipoondi','Tamil Nadu','India'),(1229,'Thiruvallur','Tamil Nadu','India'),(1230,'Thiruvarur','Tamil Nadu','India'),(1231,'Thoothukudi','Tamil Nadu','India'),(1232,'Thuraiyur','Tamil Nadu','India'),(1233,'Tindivanam','Tamil Nadu','India'),(1234,'Tiruchendur','Tamil Nadu','India'),(1235,'Tiruchengode','Tamil Nadu','India'),(1236,'Tiruchirappalli','Tamil Nadu','India'),(1237,'Tirukalukundram','Tamil Nadu','India'),(1238,'Tirukkoyilur','Tamil Nadu','India'),(1239,'Tirunelveli','Tamil Nadu','India'),(1240,'Tirupathur','Tamil Nadu','India'),(1241,'Tirupathur','Tamil Nadu','India'),(1242,'Tiruppur','Tamil Nadu','India'),(1243,'Tiruttani','Tamil Nadu','India'),(1244,'Tiruvannamalai','Tamil Nadu','India'),(1245,'Tiruvethipuram','Tamil Nadu','India'),(1246,'Tittakudi','Tamil Nadu','India'),(1247,'Udhagamandalam','Tamil Nadu','India'),(1248,'Udumalaipettai','Tamil Nadu','India'),(1249,'Unnamalaikadai','Tamil Nadu','India'),(1250,'Usilampatti','Tamil Nadu','India'),(1251,'Uthamapalayam','Tamil Nadu','India'),(1252,'Uthiramerur','Tamil Nadu','India'),(1253,'Vadakkuvalliyur','Tamil Nadu','India'),(1254,'Vadalur','Tamil Nadu','India'),(1255,'Vadipatti','Tamil Nadu','India'),(1256,'Valparai','Tamil Nadu','India'),(1257,'Vandavasi','Tamil Nadu','India'),(1258,'Vaniyambadi','Tamil Nadu','India'),(1259,'Vedaranyam','Tamil Nadu','India'),(1260,'Vellakoil','Tamil Nadu','India'),(1261,'Vellore','Tamil Nadu','India'),(1262,'Vikramasingapuram','Tamil Nadu','India'),(1263,'Viluppuram','Tamil Nadu','India'),(1264,'Virudhachalam','Tamil Nadu','India'),(1265,'Virudhunagar','Tamil Nadu','India'),(1266,'Viswanatham','Tamil Nadu','India'),(1267,'Agartala','Tripura','India'),(1268,'Badharghat','Tripura','India'),(1269,'Dharmanagar','Tripura','India'),(1270,'Indranagar','Tripura','India'),(1271,'Jogendranagar','Tripura','India'),(1272,'Kailasahar','Tripura','India'),(1273,'Khowai','Tripura','India'),(1274,'Pratapgarh','Tripura','India'),(1275,'Udaipur','Tripura','India'),(1276,'Achhnera','Uttar Pradesh','India'),(1277,'Adari','Uttar Pradesh','India'),(1278,'Agra','Uttar Pradesh','India'),(1279,'Aligarh','Uttar Pradesh','India'),(1280,'Allahabad','Uttar Pradesh','India'),(1281,'Amroha','Uttar Pradesh','India'),(1282,'Azamgarh','Uttar Pradesh','India'),(1283,'Bahraich','Uttar Pradesh','India'),(1284,'Ballia','Uttar Pradesh','India'),(1285,'Balrampur','Uttar Pradesh','India'),(1286,'Banda','Uttar Pradesh','India'),(1287,'Bareilly','Uttar Pradesh','India'),(1288,'Chandausi','Uttar Pradesh','India'),(1289,'Dadri','Uttar Pradesh','India'),(1290,'Deoria','Uttar Pradesh','India'),(1291,'Etawah','Uttar Pradesh','India'),(1292,'Fatehabad','Uttar Pradesh','India'),(1293,'Fatehpur','Uttar Pradesh','India'),(1294,'Fatehpur','Uttar Pradesh','India'),(1295,'Greater Noida','Uttar Pradesh','India'),(1296,'Hamirpur','Uttar Pradesh','India'),(1297,'Hardoi','Uttar Pradesh','India'),(1298,'Jajmau','Uttar Pradesh','India'),(1299,'Jaunpur','Uttar Pradesh','India'),(1300,'Jhansi','Uttar Pradesh','India'),(1301,'Kalpi','Uttar Pradesh','India'),(1302,'Kanpur','Uttar Pradesh','India'),(1303,'Kota','Uttar Pradesh','India'),(1304,'Laharpur','Uttar Pradesh','India'),(1305,'Lakhimpur','Uttar Pradesh','India'),(1306,'Lal Gopalganj Nindaura','Uttar Pradesh','India'),(1307,'Lalganj','Uttar Pradesh','India'),(1308,'Lalitpur','Uttar Pradesh','India'),(1309,'Lar','Uttar Pradesh','India'),(1310,'Loni','Uttar Pradesh','India'),(1311,'Lucknow','Uttar Pradesh','India'),(1312,'Mathura','Uttar Pradesh','India'),(1313,'Meerut','Uttar Pradesh','India'),(1314,'Modinagar','Uttar Pradesh','India'),(1315,'Muradnagar','Uttar Pradesh','India'),(1316,'Nagina','Uttar Pradesh','India'),(1317,'Najibabad','Uttar Pradesh','India'),(1318,'Nakur','Uttar Pradesh','India'),(1319,'Nanpara','Uttar Pradesh','India'),(1320,'Naraura','Uttar Pradesh','India'),(1321,'Naugawan Sadat','Uttar Pradesh','India'),(1322,'Nautanwa','Uttar Pradesh','India'),(1323,'Nawabganj','Uttar Pradesh','India'),(1324,'Nehtaur','Uttar Pradesh','India'),(1325,'NOIDA','Uttar Pradesh','India'),(1326,'Noorpur','Uttar Pradesh','India'),(1327,'Obra','Uttar Pradesh','India'),(1328,'Orai','Uttar Pradesh','India'),(1329,'Padrauna','Uttar Pradesh','India'),(1330,'Palia Kalan','Uttar Pradesh','India'),(1331,'Parasi','Uttar Pradesh','India'),(1332,'Phulpur','Uttar Pradesh','India'),(1333,'Pihani','Uttar Pradesh','India'),(1334,'Pilibhit','Uttar Pradesh','India'),(1335,'Pilkhuwa','Uttar Pradesh','India'),(1336,'Powayan','Uttar Pradesh','India'),(1337,'Pukhrayan','Uttar Pradesh','India'),(1338,'Puranpur','Uttar Pradesh','India'),(1339,'Purquazi','Uttar Pradesh','India'),(1340,'Purwa','Uttar Pradesh','India'),(1341,'Rae Bareli','Uttar Pradesh','India'),(1342,'Rampur','Uttar Pradesh','India'),(1343,'Rampur Maniharan','Uttar Pradesh','India'),(1344,'Rasra','Uttar Pradesh','India'),(1345,'Rath','Uttar Pradesh','India'),(1346,'Renukoot','Uttar Pradesh','India'),(1347,'Reoti','Uttar Pradesh','India'),(1348,'Robertsganj','Uttar Pradesh','India'),(1349,'Rudauli','Uttar Pradesh','India'),(1350,'Rudrapur','Uttar Pradesh','India'),(1351,'Sadabad','Uttar Pradesh','India'),(1352,'Safipur','Uttar Pradesh','India'),(1353,'Saharanpur','Uttar Pradesh','India'),(1354,'Sahaspur','Uttar Pradesh','India'),(1355,'Sahaswan','Uttar Pradesh','India'),(1356,'Sahawar','Uttar Pradesh','India'),(1357,'Sahjanwa','Uttar Pradesh','India'),(1358,'Saidpur','Ghazipur','India'),(1359,'Sambhal','Uttar Pradesh','India'),(1360,'Samdhan','Uttar Pradesh','India'),(1361,'Samthar','Uttar Pradesh','India'),(1362,'Sandi','Uttar Pradesh','India'),(1363,'Sandila','Uttar Pradesh','India'),(1364,'Sardhana','Uttar Pradesh','India'),(1365,'Seohara','Uttar Pradesh','India'),(1366,'Shahabad','Hardoi','India'),(1367,'Shahabad','Rampur','India'),(1368,'Shahganj','Uttar Pradesh','India'),(1369,'Shahjahanpur','Uttar Pradesh','India'),(1370,'Shamli','Uttar Pradesh','India'),(1371,'Shamsabad','Agra','India'),(1372,'Shamsabad','Farrukhabad','India'),(1373,'Sherkot','Uttar Pradesh','India'),(1374,'Shikarpur','Bulandshahr','India'),(1375,'Shikohabad','Uttar Pradesh','India'),(1376,'Shishgarh','Uttar Pradesh','India'),(1377,'Siana','Uttar Pradesh','India'),(1378,'Sikanderpur','Uttar Pradesh','India'),(1379,'Sikandra Rao','Uttar Pradesh','India'),(1380,'Sikandrabad','Uttar Pradesh','India'),(1381,'Sirsaganj','Uttar Pradesh','India'),(1382,'Sirsi','Uttar Pradesh','India'),(1383,'Sitapur','Uttar Pradesh','India'),(1384,'Soron','Uttar Pradesh','India'),(1385,'Suar','Uttar Pradesh','India'),(1386,'Sultanpur','Uttar Pradesh','India'),(1387,'Sumerpur','Uttar Pradesh','India'),(1388,'Tanda','Uttar Pradesh','India'),(1389,'Tanda','Uttar Pradesh','India'),(1390,'Tetri Bazar','Uttar Pradesh','India'),(1391,'Thakurdwara','Uttar Pradesh','India'),(1392,'Thana Bhawan','Uttar Pradesh','India'),(1393,'Tilhar','Uttar Pradesh','India'),(1394,'Tirwaganj','Uttar Pradesh','India'),(1395,'Tulsipur','Uttar Pradesh','India'),(1396,'Tundla','Uttar Pradesh','India'),(1397,'Unnao','Uttar Pradesh','India'),(1398,'Utraula','Uttar Pradesh','India'),(1399,'Varanasi','Uttar Pradesh','India'),(1400,'Vrindavan','Uttar Pradesh','India'),(1401,'Warhapur','Uttar Pradesh','India'),(1402,'Zaidpur','Uttar Pradesh','India'),(1403,'Zamania','Uttar Pradesh','India'),(1404,'Almora','Uttarakhand','India'),(1405,'Bazpur','Uttarakhand','India'),(1406,'Chamba','Uttarakhand','India'),(1407,'Dehradun','Uttarakhand','India'),(1408,'Haldwani','Uttarakhand','India'),(1409,'Haridwar','Uttarakhand','India'),(1410,'Jaspur','Uttarakhand','India'),(1411,'Kashipur','Uttarakhand','India'),(1412,'kichha','Uttarakhand','India'),(1413,'Kotdwara','Uttarakhand','India'),(1414,'Manglaur','Uttarakhand','India'),(1415,'Mussoorie','Uttarakhand','India'),(1416,'Nagla','Uttarakhand','India'),(1417,'Nainital','Uttarakhand','India'),(1418,'Pauri','Uttarakhand','India'),(1419,'Pithoragarh','Uttarakhand','India'),(1420,'Ramnagar','Uttarakhand','India'),(1421,'Rishikesh','Uttarakhand','India'),(1422,'Roorkee','Uttarakhand','India'),(1423,'Rudrapur','Uttarakhand','India'),(1424,'Sitarganj','Uttarakhand','India'),(1425,'Tehri','Uttarakhand','India'),(1426,'Muzaffarnagar','Uttarpradesh','India'),(1427,'Adra','Purulia','India'),(1428,'Alipurduar','West Bengal','India'),(1429,'Arambagh','West Bengal','India'),(1430,'Asansol','West Bengal','India'),(1431,'Baharampur','West Bengal','India'),(1432,'Bally','West Bengal','India'),(1433,'Balurghat','West Bengal','India'),(1434,'Bankura','West Bengal','India'),(1435,'Barakar','West Bengal','India'),(1436,'Barasat','West Bengal','India'),(1437,'Bardhaman','West Bengal','India'),(1438,'Bidhan Nagar','West Bengal','India'),(1439,'Chinsura','West Bengal','India'),(1440,'Contai','West Bengal','India'),(1441,'Cooch Behar','West Bengal','India'),(1442,'Darjeeling','West Bengal','India'),(1443,'Durgapur','West Bengal','India'),(1444,'Haldia','West Bengal','India'),(1445,'Howrah','West Bengal','India'),(1446,'Islampur','West Bengal','India'),(1447,'Jhargram','West Bengal','India'),(1448,'Kharagpur','West Bengal','India'),(1449,'Kolkata','West Bengal','India'),(1450,'Mainaguri','West Bengal','India'),(1451,'Mal','West Bengal','India'),(1452,'Mathabhanga','West Bengal','India'),(1453,'Medinipur','West Bengal','India'),(1454,'Memari','West Bengal','India'),(1455,'Monoharpur','West Bengal','India'),(1456,'Murshidabad','West Bengal','India'),(1457,'Nabadwip','West Bengal','India'),(1458,'Naihati','West Bengal','India'),(1459,'Panchla','West Bengal','India'),(1460,'Pandua','West Bengal','India'),(1461,'Paschim Punropara','West Bengal','India'),(1462,'Purulia','West Bengal','India'),(1463,'Raghunathpur','West Bengal','India'),(1464,'Raiganj','West Bengal','India'),(1465,'Rampurhat','West Bengal','India'),(1466,'Ranaghat','West Bengal','India'),(1467,'Sainthia','West Bengal','India'),(1468,'Santipur','West Bengal','India'),(1469,'Siliguri','West Bengal','India'),(1470,'Sonamukhi','West Bengal','India'),(1471,'Srirampore','West Bengal','India'),(1472,'Suri','West Bengal','India'),(1473,'Taki','West Bengal','India'),(1474,'Tamluk','West Bengal','India'),(1475,'Tarakeswar','West Bengal','India'),(1476,'Chikmagalur','Karnataka','India'),(1477,'Davanagere','Karnataka','India'),(1478,'Dharwad','Karnataka','India'),(1479,'Gadag','Karnataka','India'),(1480,'Chennai','Tamil Nadu','India'),(1481,'Coimbatore','Tamil Nadu','India');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(50) NOT NULL,
  `username` char(20) NOT NULL,
  `password` char(100) NOT NULL,
  `password_key` char(100) NOT NULL,
  `permanent_address` varchar(500) DEFAULT NULL,
  `current_address` varchar(500) NOT NULL,
  `city_code` int(11) NOT NULL,
  `date_of_birth` date NOT NULL,
  `gender` char(1) NOT NULL,
  `occupation` char(30) NOT NULL,
  `is_married` tinyint(1) NOT NULL,
  `is_student` tinyint(1) NOT NULL,
  `contact_number` char(20) NOT NULL,
  `mail_id` char(100) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code` (`code`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `contact_number` (`contact_number`),
  UNIQUE KEY `mail_id` (`mail_id`),
  KEY `Relationship1` (`city_code`),
  CONSTRAINT `Relationship1` FOREIGN KEY (`city_code`) REFERENCES `city` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marital_details`
--

DROP TABLE IF EXISTS `marital_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marital_details` (
  `customer_code` int(11) NOT NULL,
  `spouse_name` char(50) DEFAULT NULL,
  `spouse_date_of_birth` date DEFAULT NULL,
  `anniversary_date` date DEFAULT NULL,
  `spouse_occupation` char(50) DEFAULT NULL,
  `number_of_girl_child` int(11) DEFAULT NULL,
  `number_of_boy_child` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_code`),
  UNIQUE KEY `customer_code` (`customer_code`),
  CONSTRAINT `Relationship9` FOREIGN KEY (`customer_code`) REFERENCES `customer` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marital_details`
--

LOCK TABLES `marital_details` WRITE;
/*!40000 ALTER TABLE `marital_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `marital_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operator`
--

DROP TABLE IF EXISTS `operator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operator` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(30) NOT NULL,
  `username` char(30) NOT NULL,
  `password` char(100) NOT NULL,
  `password_key` char(100) NOT NULL,
  `vendor_outlet_code` int(11) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code` (`code`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `password` (`password`),
  KEY `Relationship5` (`vendor_outlet_code`),
  CONSTRAINT `Relationship5` FOREIGN KEY (`vendor_outlet_code`) REFERENCES `vendor_outlet` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operator`
--

LOCK TABLES `operator` WRITE;
/*!40000 ALTER TABLE `operator` DISABLE KEYS */;
/*!40000 ALTER TABLE `operator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `customer_code` int(11) NOT NULL,
  `stream` char(50) NOT NULL,
  `course_details` char(100) NOT NULL,
  PRIMARY KEY (`customer_code`),
  UNIQUE KEY `customer_code` (`customer_code`),
  CONSTRAINT `Relationship8` FOREIGN KEY (`customer_code`) REFERENCES `customer` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `student_view`
--

DROP TABLE IF EXISTS `student_view`;
/*!50001 DROP VIEW IF EXISTS `student_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `student_view` AS SELECT 
 1 AS `customer_code`,
 1 AS `name`,
 1 AS `username`,
 1 AS `password`,
 1 AS `password_key`,
 1 AS `permanent_address`,
 1 AS `current_address`,
 1 AS `city_code`,
 1 AS `date_of_birth`,
 1 AS `gender`,
 1 AS `occupation`,
 1 AS `contact_number`,
 1 AS `mail_id`,
 1 AS `stream`,
 1 AS `course_details`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `name_of_firm` char(50) NOT NULL,
  `username` char(50) NOT NULL COMMENT '**',
  `password` char(100) NOT NULL,
  `password_key` char(100) NOT NULL,
  `address` varchar(500) NOT NULL,
  `city_code` int(11) NOT NULL,
  `contact_number` char(20) NOT NULL,
  `mail_id` char(100) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code` (`code`),
  UNIQUE KEY `name_of_firm` (`name_of_firm`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `contact_number` (`contact_number`),
  UNIQUE KEY `mail_id` (`mail_id`),
  KEY `Relationship3` (`city_code`),
  CONSTRAINT `Relationship3` FOREIGN KEY (`city_code`) REFERENCES `city` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` VALUES (4,'Pakeeza Traders.','pkz12345','hundred100','hundred100','452 freegunj, ujjain',1,'9926354123','pkzujjain@gmail.com'),(7,'Sarvanand Bazaar','srvrtlm1','sarvanand','sarvanand','40  vikram nagar , ratlam',2,'9425918170','srvratlam@gmail.com'),(8,'Reliance Trends','rtrends123','rtrends1123','rtrends1123','A/ 52  Nanakheda ujjain',1,'85189000018','rtrends@gmail.com'),(9,'Apna Sweets','railani12','question20','question20','40 Aadarsh vikram nagar',1,'8518900013','rvugs0@gmail.com'),(11,'Shree Ganga','railani16','question20','question20','56 Freegunj ujjain',2,'8518900014','rvbs0@gmail.com');
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor_outlet`
--

DROP TABLE IF EXISTS `vendor_outlet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor_outlet` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `vendor_code` int(11) NOT NULL,
  `address` varchar(500) NOT NULL,
  `latitude` char(30) NOT NULL,
  `longitude` char(30) NOT NULL,
  `city_code` int(11) NOT NULL,
  `contact_number` char(20) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code` (`code`),
  UNIQUE KEY `latitude` (`latitude`),
  UNIQUE KEY `longitude` (`longitude`),
  UNIQUE KEY `contact_number` (`contact_number`),
  KEY `Relationship4` (`vendor_code`),
  KEY `Relationship2` (`city_code`),
  CONSTRAINT `Relationship2` FOREIGN KEY (`city_code`) REFERENCES `city` (`code`),
  CONSTRAINT `Relationship4` FOREIGN KEY (`vendor_code`) REFERENCES `vendor` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor_outlet`
--

LOCK TABLES `vendor_outlet` WRITE;
/*!40000 ALTER TABLE `vendor_outlet` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor_outlet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vendor_outlet_view`
--

DROP TABLE IF EXISTS `vendor_outlet_view`;
/*!50001 DROP VIEW IF EXISTS `vendor_outlet_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vendor_outlet_view` AS SELECT 
 1 AS `code`,
 1 AS `vendor_code`,
 1 AS `address`,
 1 AS `latitude`,
 1 AS `longitude`,
 1 AS `city_code`,
 1 AS `contact_number`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vendor_view`
--

DROP TABLE IF EXISTS `vendor_view`;
/*!50001 DROP VIEW IF EXISTS `vendor_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vendor_view` AS SELECT 
 1 AS `code`,
 1 AS `name_of_firm`,
 1 AS `username`,
 1 AS `password`,
 1 AS `password_key`,
 1 AS `city_code`,
 1 AS `address`,
 1 AS `contact_number`,
 1 AS `mail_id`,
 1 AS `city_name`,
 1 AS `state_name`,
 1 AS `country_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'loyalty'
--
/*!50003 DROP PROCEDURE IF EXISTS `add_admin` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_admin`(in v_name char(20),in v_username char(20),in v_password char(50),in v_password_key char(50),in v_mail_id char(100),in v_contact_number char(100),out v_code int)
BEGIN
insert into admin (name,username,password,password_key, mail_id ,contact_number ) values (v_name,v_username,v_password,v_password_key,v_mail_id,v_contact_number);
set v_code = last_insert_id();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_city` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_city`(in v_name char(30),in v_state char(30),in v_country char(30),out code int)
BEGIN
INSERT INTO city (name,state,country) values (v_name,v_state,v_country);
set code = last_insert_id();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_customer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_customer`(in v_name char(50),in v_username char(20),in v_password char(100),in v_password_key char(100),in

v_permanent_address varchar(500),in v_current_address varchar(500),in v_city_code int,in v_date_of_birth date,in v_gender char(1),in v_occupation char

(30),in v_is_married bool,in v_is_student bool,in v_contact_number char(20),in v_mail_id char(100),out v_code int )
BEGIN
insert into customer (name,username,password,password_key,permanent_address,current_address,city_code,date_of_birth,gender,occupation,is_married,is_student,contact_number,mail_id) values(v_name,v_username,v_password,v_password_key,v_permanent_address,v_current_address,v_city_code,v_date_of_birth,v_gender,v_occupation,v_is_married,v_is_student,v_contact_number,v_mail_id);
set v_code=last_insert_id();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_marital_details` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_marital_details`(in v_customer_code int,in v_spouse_name char(50),in v_spouse_date_of_birth date,in v_anniversary_date date,in v_spouse_occupation char(50),in v_number_of_girl_child int,in v_number_of_boy_child int)
BEGIN
insert into marital_details (customer_code,spouse_name,spouse_date_of_birth,anniversary_date,spouse_occupation,number_of_girl_child,number_of_boy_child) values(v_customer_code,v_spouse_name,v_spouse_date_of_birth,v_anniversary_date,v_spouse_occupation,v_number_of_girl_child,v_number_of_boy_child);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_operator` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`loyalty`@`%` PROCEDURE `add_operator`(in v_vendor_outlet_code integer,in v_name char(30),in v_username char(30),in v_password char (30),out v_code integer)
BEGIN
insert into operator (vendor_outlet_code,name,username,password) values (v_vendor_outlet_code,v_name,v_username,md5(password));
set v_code=last_inset_id();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_student` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_student`(in v_customer_code int,in v_stream char(50),in v_course_details char(100))
BEGIN
insert into student (customer_code,stream,course_details) values (v_customer_code,v_stream,v_course_details);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_vendor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_vendor`(in v_name char(50),in v_username char(50),in v_password_key char(100),in v_password char(100),in v_city_code int, in v_address Varchar(500),in v_mail_id char(100),in v_contact_number char(20),out v_code int)
BEGIN
insert into vendor (name_of_firm ,username ,password_key ,password ,  city_code, address, mail_id ,contact_number ) values (v_name,v_username,v_password_key,v_password,v_city_code,v_address,v_mail_id,v_contact_number);
set v_code = last_insert_id();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_vendor_outlet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_vendor_outlet`(in v_vendor_code int,in v_address Varchar(500),in v_latitude char(30),in v_longitude char(30),in v_city_code int,in v_contact_number char(20),out v_out_code int)
BEGIN
insert into vendor_outlet (vendor_code ,address,latitude,longitude,city_code ,contact_number) values (v_vendor_code , v_address,v_latitude,v_longitude,v_city_code ,v_contact_number);
set v_out_code = last_insert_id();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `admin_exists_by_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `admin_exists_by_code`(in v_code int)
BEGIN
select code from admin where code = v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `admin_exists_by_contact_number` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `admin_exists_by_contact_number`(in v_contact_number char(100))
BEGIN
select code from admin where contact_number = v_contact_number;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `admin_exists_by_mail_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `admin_exists_by_mail_id`(in v_mail_id char(100))
BEGIN
select code from admin where mail_id = v_mail_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `admin_exists_by_name` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `admin_exists_by_name`(in v_name char(20))
BEGIN
select code from admin where name = v_name;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `admin_exists_by_username` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `admin_exists_by_username`(in v_username char(20))
BEGIN
select code from admin where username = v_username;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `city_exists_by_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `city_exists_by_code`(in v_code int)
BEGIN
select * from city where code = v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `city_exists_by_name` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `city_exists_by_name`(in v_name char(30))
BEGIN
select * from city where name = v_name;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `customer_exists_by_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `customer_exists_by_code`(in v_code int)
BEGIN
select * from customer where code=v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `customer_exists_by_contact_number` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `customer_exists_by_contact_number`(in v_contact_number char(20))
BEGIN
select * from customer where contact_number=v_contact_number;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `customer_exists_by_mail_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `customer_exists_by_mail_id`(in v_mail_id char(100))
BEGIN
select * from customer where mail_id=v_mail_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `customer_exists_by_username` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `customer_exists_by_username`(in v_username char(20))
BEGIN
select * from customer where username=v_username;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_admin_by_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_admin_by_code`(in v_code int)
BEGIN
select code, username ,password,password_key, mail_id , name ,contact_number from admin where code = v_code ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_admin_by_contact_number` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_admin_by_contact_number`(in v_contact_number char(100))
BEGIN
select code, username,password,password_key,mail_id , contact_number,name from admin  where contact_number = v_contact_number;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_admin_by_mail_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_admin_by_mail_id`(in v_mail_id char(100))
BEGIN
select code, username,password,password_key,mail_id ,name,contact_number from admin where mail_id = v_mail_id ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_admin_by_name` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_admin_by_name`(in v_name char(20))
BEGIN
select code, username,password,password_key, mail_id , name,contact_number from admin where name= v_name ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_admin_by_username` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_admin_by_username`(in v_username char(20))
BEGIN
select code, username,password,password_key, mail_id , contact_number,name from admin where username = v_username ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_admin_count` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_admin_count`(out v_admin_count int)
BEGIN
DECLARE admin_count Int;
select count(*) into admin_count from admin;
set v_admin_count = admin_count;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_admins` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_admins`()
BEGIN
select code, username,password,password_key,mail_id , contact_number,name from admin ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_cities` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_cities`()
BEGIN
select * from city ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_customers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_customers`()
BEGIN
select * from customer_view;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_customers_by_city` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_customers_by_city`(in v_city_code int)
BEGIN
select * from customer_view where city_code=v_city_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_customers_by_date_of_birth` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_customers_by_date_of_birth`(in v_date_of_birth date)
BEGIN
select * from customer_view where date_of_birth=v_date_of_birth;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_customers_by_name` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_customers_by_name`(in v_name char(50))
BEGIN
select * from customer_view where name=v_name;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_customers_by_occupation` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_customers_by_occupation`(in v_occupation char(30))
BEGIN
select * from customer_view where occupation=v_occupation;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_female_customers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_female_customers`()
BEGIN
select * from customer_view where gender='F';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_male_customers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_male_customers`()
BEGIN
select * from customer_view where gender='M';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_marital_details` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_marital_details`()
BEGIN
select * from marital_details_view;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_married_customers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_married_customers`()
BEGIN
select * from customer_view where is_married=true;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_married_customers_by_anniversary_date` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_married_customers_by_anniversary_date`(in v_anniversary_date date)
BEGIN
select * from marital_details_view where anniversary_date=v_anniversary_date;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_married_customers_by_spouse_date_of_birth` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_married_customers_by_spouse_date_of_birth`(in v_spouse_date_of_birth date)
BEGIN
select * from marital_details_view where spouse_date_of_birth=v_spouse_date_of_birth;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_married_customers_by_spouse_occupation` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_married_customers_by_spouse_occupation`(in v_spouse_occupation char(50))
BEGIN
select * from marital_details_view where spouse_occupation=v_spouse_occupation;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_operators` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_all_operators`()
BEGIN
select * from operator ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_operators_by_vendor_outlet_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_all_operators_by_vendor_outlet_code`(in v_vendor_outlet_code integer)
BEGIN
select * from operator where vendor_outlet_code=v_vendor_outlet_code ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_students` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_students`()
BEGIN
select * from student_view;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_students_by_stream` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_students_by_stream`(in v_stream char(50))
BEGIN
select * from student_view where stream=v_stream;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_student_customers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_student_customers`()
BEGIN
select * from customer_view where is_student=true;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_vendors` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_vendors`()
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , contact_number,name_of_firm from vendor_view  ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_vendor_outlets` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_vendor_outlets`()
BEGIN
select code , latitude , longitude ,address,contact_number ,vendor_code ,city_code from vendor_outlet_view  ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_vendor_outlets_by_city` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_vendor_outlets_by_city`(in v_city_code int)
BEGIN
select code , latitude , longitude ,address,contact_number,city_code ,vendor_code from vendor_outlet_view where city_code = v_city_code ;	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_vendor_outlets_by_vendor_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_vendor_outlets_by_vendor_code`(in v_vendor_code int)
BEGIN
select code , latitude , longitude ,address,contact_number,city_code ,vendor_code from vendor_outlet_view where vendor_code = v_vendor_code ;	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_cities_by_name` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_cities_by_name`(in v_name char(30))
BEGIN
select * from city where name=v_name;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_city_by_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_city_by_code`(in v_code int)
BEGIN
select * from city where code = v_code ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_city_count` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_city_count`(out v_city_count int)
BEGIN
DECLARE city_count Int;
select count(*) into city_count from city; 
set v_city_count = city_count;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_city_count_by_name` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_city_count_by_name`(in v_name char(30),out v_count int)
BEGIN
DECLARE city_count int;
select count(*) into city_count from city where name= v_name;
set v_count=city_count; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_count_of_female_customers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_count_of_female_customers`(out v_female_customers_count int)
BEGIN
declare customer_count Int;
select count(*) into customer_count from customer where gender='F';
set v_female_customers_count=customer_count;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_count_of_male_customers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_count_of_male_customers`(out v_male_customers_count int)
BEGIN
declare customer_count Int;
select count(*) into customer_count from customer where gender='M';
set v_male_customers_count=customer_count;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_count_of_married_customers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_count_of_married_customers`(out v_married_customers_count int)
BEGIN
declare customer_count Int;
select count(*) into customer_count from customer where is_married=true;
set v_married_customers_count=customer_count;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_count_of_student_customers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_count_of_student_customers`(out v_student_customers_count int)
BEGIN
declare customer_count Int;
select count(*) into customer_count from customer where is_student=true;
set v_student_customers_count=customer_count;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_customer_by_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_customer_by_code`(in v_code int)
BEGIN
select * from customer_view where customer_code=v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_customer_by_contact_number` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_customer_by_contact_number`(in v_contact_number char(20))
BEGIN
select * from customer_view where contact_number=v_contact_number;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_customer_by_mail_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_customer_by_mail_id`(in v_mail_id char(100))
BEGIN
select * from customer_view where mail_id=v_mail_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_customer_by_username` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_customer_by_username`(in v_username char(20))
BEGIN
select * from customer_view where username=v_username;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_customer_count` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_customer_count`(out v_customer_count int)
BEGIN
declare customer_count Int;
select count(*) into customer_count from customer;
set v_customer_count=customer_count;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_customer_count_by_city` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_customer_count_by_city`(in v_city_code int,out v_count int)
BEGIN
declare customer_count int;
select count(*) into customer_count from customer where city_code=v_city_code;
set v_count =customer_count;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_customer_count_by_date_of_birth` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_customer_count_by_date_of_birth`(in v_date_of_birth char(50),out v_count int)
BEGIN
declare customer_count int;
select count(*) into customer_count from customer where date_of_birth=v_date_of_birth;
set v_count =customer_count;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_customer_count_by_name` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_customer_count_by_name`(in v_name char(50),out v_count int)
BEGIN
declare customer_count int;
select count(*) into customer_count from customer where name=v_name;
set v_count =customer_count;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_customer_count_by_occupation` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_customer_count_by_occupation`(in v_occupation char(30),out v_count int)
BEGIN
declare customer_count int;
select count(*) into customer_count from customer where occupation=v_occupation;
set v_count =customer_count;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_marital_details_count` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_marital_details_count`(out v_marital_details_count int)
BEGIN
declare marital_details_count Int;
select count(*) into marital_details_count from marital_details;
set v_marital_details_count=marital_details_count;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_married_customer_count_by_anniversary_date` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_married_customer_count_by_anniversary_date`(in v_anniversary_date date)
BEGIN
select * from marital_details where anniversary_date=v_anniversary_date;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_married_customer_count_by_spouse_date_of_birth` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_married_customer_count_by_spouse_date_of_birth`(in v_spouse_date_of_birth date)
BEGIN
select * from marital_details where spouse_date_of_birth=v_spouse_date_of_birth;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_married_customer_count_by_spouse_occupation` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_married_customer_count_by_spouse_occupation`(in v_spouse_occupation char(50))
BEGIN
select * from marital_details where spouse_occupation=v_spouse_occupation;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_operator_by_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_by_code`(in v_code integer)
BEGIN
select * from operator where code=v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_operator_by_name` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_by_name`(in v_name char(30))
BEGIN
select * from operator where name=v_name;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_operator_by_username` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_by_username`(in v_username char(30))
BEGIN
select * from operator where username=v_username;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_operator_count` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_count`()
BEGIN
select count(*) as cnt from operator;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_operator_count_by_name` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_count_by_name`(in v_name char(30))
BEGIN
select count(*) as cnt from operator where  name=v_name;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_operator_count_by_username` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_count_by_username`(in v_username char(30))
BEGIN
select count(*) as cnt from operator where username=v_username;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_operator_count_by_vendor_outlet_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_count_by_vendor_outlet_code`(in v_vendor_outlet_code integer)
BEGIN
select count(*) as cnt from operator where vendor_outlet_code=v_vendor_outlet_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_student_by_customer_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_student_by_customer_code`(in v_customer_code int)
BEGIN
select * from student_view where customer_code=v_customer_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_student_count` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_student_count`(out v_student_count int)
BEGIN
declare student_count Int;
select count(*) into student_count from student;
set v_student_count=student_count;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_student_count_by_stream` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_student_count_by_stream`(in v_stream char(50),out v_count int)
BEGIN
declare student_count int;
select count(*) into student_count from student where stream=v_stream;
set v_count =student_count;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_vendor_by_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_vendor_by_code`(in v_code int)
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , name_of_firm ,contact_number from vendor_view where code = v_code ; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_vendor_by_contact_number` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_vendor_by_contact_number`(in v_contact_number char(20))
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , contact_number,name_of_firm from vendor_view  where contact_number = v_contact_number;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_vendor_by_mail_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_vendor_by_mail_id`(in v_mail_id char(100))
BEGIN
select code, username , city_code ,password,password_key,address , mail_id ,name_of_firm ,contact_number from vendor_view where mail_id = v_mail_id ; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_vendor_by_name_of_firm` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_vendor_by_name_of_firm`(in v_name char(50))
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , name_of_firm ,contact_number from vendor_view where name_of_firm = v_name ; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_vendor_by_username` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_vendor_by_username`(in v_username char(50))
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , contact_number,name_of_firm from vendor_view where username = v_username ; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_vendor_count` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_vendor_count`(out v_vendor_count int)
BEGIN
DECLARE vendor_count Int;
select count(*) into vendor_count from vendor_view; 
set v_vendor_count = vendor_count;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_vendor_count_by_city` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_vendor_count_by_city`(in v_city_code int,out v_vendor_count int)
BEGIN
DECLARE vendor_count Int;
select count(*) into vendor_count from vendor_view where city_code = v_city_code ; 
set v_vendor_count = vendor_count;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_vendor_outlet_by_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_vendor_outlet_by_code`(in v_code int)
BEGIN
select code , latitude , longitude ,address,contact_number ,vendor_code ,city_code from vendor_outlet_view where code = v_code ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_vendor_outlet_by_contact_number` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_vendor_outlet_by_contact_number`(in v_contact_number char(20))
BEGIN
select code , latitude , longitude ,address,contact_number ,vendor_code,city_code from vendor_outlet_view where contact_number = v_contact_number ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_vendor_outlet_by_coordinates` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_vendor_outlet_by_coordinates`(in v_latitude char(30),in v_longitude char(30))
BEGIN
select code , latitude , longitude ,address,contact_number,city_code ,vendor_code from vendor_outlet_view where latitude = v_latitude and longitude = v_longitude ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_vendor_outlet_count` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_vendor_outlet_count`(out v_count int)
BEGIN
DECLARE v_outlet_count int;
select count(*) into v_outlet_count from vendor_outlet_view ;
set  v_count = v_outlet_count ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_vendor_outlet_count_by_city` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_vendor_outlet_count_by_city`(in v_city_code int ,out v_count int)
BEGIN
DECLARE v_outlet_count int;
select count(*) into v_outlet_count from vendor_outlet_view where city_code = v_city_code;
set  v_count = v_outlet_count ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `marital_details_exists_by_customer_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `marital_details_exists_by_customer_code`(in v_customer_code int)
BEGIN
select * from marital_details where customer_code=v_customer_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `operator_exists_by_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`loyalty`@`%` PROCEDURE `operator_exists_by_code`(in v_code integer)
BEGIN
select * from operator where code=v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `operator_exists_by_username` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`loyalty`@`%` PROCEDURE `operator_exists_by_username`(in v_username char(30))
BEGIN
select * from operator where username=v_username;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_admin` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove_admin`(in v_code int)
BEGIN
delete from admin where code = v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_all_admins` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove_all_admins`()
BEGIN
truncate admins;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_all_cities` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove_all_cities`()
BEGIN
truncate city;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_all_customers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove_all_customers`()
BEGIN
truncate customer;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_all_marital_details` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove_all_marital_details`()
BEGIN
truncate marital_details;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_all_operators` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`loyalty`@`%` PROCEDURE `remove_all_operators`()
BEGIN
delete from operator ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_all_operators_by_vendor_outlet_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`loyalty`@`%` PROCEDURE `remove_all_operators_by_vendor_outlet_code`(in vendor_outlet_code integer)
BEGIN
delete from operator where vendor_outlet_code=v_vendor_outlet_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_all_students` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove_all_students`()
BEGIN
truncate student;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_all_vendors` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove_all_vendors`()
BEGIN
truncate vendors;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_all_vendor_outlets` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove_all_vendor_outlets`()
BEGIN
truncate vendor_outlet;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_city` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove_city`(in v_code int)
BEGIN
delete from city where code = v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_customer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove_customer`(in v_code int)
BEGIN
delete from customer where code=v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_marital_details_by_customer_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove_marital_details_by_customer_code`(in v_customer_code int)
BEGIN
delete from marital_details where customer_code=v_customer_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_operator` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`loyalty`@`%` PROCEDURE `remove_operator`(in v_code integer)
BEGIN
delete from operator where code=v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_operator_by_username` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`loyalty`@`%` PROCEDURE `remove_operator_by_username`(in v_username char(30))
BEGIN
delete from operator where username=v_username;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_student_by_customer_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove_student_by_customer_code`(in v_customer_code int)
BEGIN
delete from student where customer_code=v_customer_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_vendor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove_vendor`(in v_code int)
BEGIN
delete from vendor where code = v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_vendor_outlet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove_vendor_outlet`(in v_code int)
BEGIN
delete from vendor_outlet where code = v_code ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `student_exists_by_customer_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `student_exists_by_customer_code`(in v_customer_code int)
BEGIN
select * from student where customer_code=v_customer_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_admin` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_admin`(in v_code int,in v_name char(20),in v_username char(20),in v_password char(50),in v_password_key char(50),in v_mail_id char(100),in v_contact_number char(100))
BEGIN
update admin set name= v_name , password_key = v_password_key,password = v_password ,mail_id = v_mail_id ,contact_number= v_contact_number where code = v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_city` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_city`(in v_code int,in v_name char(30),in v_state char(30),in v_country char(30))
BEGIN
UPDATE city set name = v_name , state = v_state , country = v_country where code = v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_customer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_customer`(in v_code int,in v_name char(50),in v_username char(20),in v_password char(100),in v_password_key char(100), in v_permanent_address Varchar(500),in v_current_address Varchar(500),in v_city_code int,in v_date_of_birth date,in v_gender char(1),in v_occupation char(30),in v_is_married bool,in v_is_student bool,in v_contact_number char(20),in v_mail_id char(100))
BEGIN

update customer set name=v_name,password=v_password,password_key =v_password_key,permanent_address=v_permanent_address ,current_address =v_current_address ,city_code =v_city_code ,date_of_birth=v_date_of_birth,gender =v_gender,occupation=v_occupation ,is_married =v_is_married ,is_student =v_is_student ,contact_number=v_contact_number ,mail_id =v_mail_id where username = v_username and code = v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_marital_details` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_marital_details`(in v_customer_code int,in v_spouse_name char(50),in v_spouse_date_of_birth date,in v_anniversary_date date,in v_spouse_occupation char(50),in v_number_of_girl_child int,in v_number_of_boy_child int)
BEGIN
 update marital_details set spouse_name=v_spouse_name,spouse_date_of_birth=v_spouse_date_of_birth,anniversary_date=v_anniversary_date,spouse_occupation=v_spouse_occupation,number_of_girl_child=v_number_of_girl_child,number_of_boy_child=v_number_of_boy_child
 where customer_code=v_customer_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_operator` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`loyalty`@`%` PROCEDURE `update_operator`(in v_code integer,in v_vendor_outlet_code integer,in v_name char(30),in v_username char(30),in v_password char (30))
BEGIN
update operator set vendor_outlet_code=v_vendor_outlet_code,name=v_name,username =v_username,password=md5(password) where code=v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_student` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_student`(in v_customer_code int,in v_stream char(50),in v_course_details char(100))
BEGIN
update student set stream=v_stream,course_details=v_course_details where customer_code=v_customer_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_vendor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_vendor`(in v_code int,in v_name char(50),in v_username char(50),in v_password_key char(100),in v_password char(100),in v_city_code int, in v_address Varchar(500),in v_mail_id char(100),in v_contact_number char(20))
BEGIN
update vendor set name_of_firm = v_name , password_key = v_password_key ,password = v_password ,city_code = v_city_code ,address= v_address ,mail_id = v_mail_id ,contact_number= v_contact_number where code = v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_vendor_outlet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_vendor_outlet`(in v_code int,in v_vendor_code int,in v_address Varchar(500),in v_latitude char(30),in v_longitude char(30),in v_city_code int,in v_contact_number char(20))
BEGIN
update vendor_outlet set latitude=v_latitude , longitude=v_longitude ,address = v_address ,contact_number= v_contact_number ,vendor_code = v_vendor_code where code =v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `vendor_exists_by_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `vendor_exists_by_code`(in v_code int)
BEGIN
select code from vendor_view where code = v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `vendor_exists_by_contact_number` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `vendor_exists_by_contact_number`(in v_contact_number char(20))
BEGIN
select code from vendor_view where contact_number = v_contact_number;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `vendor_exists_by_mail_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `vendor_exists_by_mail_id`(in v_mail_id char(100))
BEGIN
select code from vendor_view where mail_id = v_mail_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `vendor_exists_by_name_of_firm` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `vendor_exists_by_name_of_firm`(in v_name char(50))
BEGIN
select code from vendor_view where name_of_firm = v_name;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `vendor_exists_by_username` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `vendor_exists_by_username`(in v_username char(50))
BEGIN
select code from vendor_view where username = v_username;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `vendor_outlet_exists_by_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `vendor_outlet_exists_by_code`(in v_code int)
BEGIN
select code from vendor_outlet_view where code=v_code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `vendor_outlet_exists_by_contact_number` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `vendor_outlet_exists_by_contact_number`(in v_contact_number char(20))
BEGIN
select code from vendor_outlet_view where contact_number = v_contact_number ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `vendor_outlet_exists_by_coordinates` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `vendor_outlet_exists_by_coordinates`(in v_latitude char(30),in v_longitude char(30))
BEGIN
select code from vendor_outlet_view where latitude = v_latitude and longitude = v_longitude ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `student_view`
--

/*!50001 DROP VIEW IF EXISTS `student_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `student_view` AS select `student`.`customer_code` AS `customer_code`,trim(`customer`.`name`) AS `name`,trim(`customer`.`username`) AS `username`,trim(`customer`.`password`) AS `password`,trim(`customer`.`password_key`) AS `password_key`,trim(`customer`.`permanent_address`) AS `permanent_address`,trim(`customer`.`current_address`) AS `current_address`,`customer`.`city_code` AS `city_code`,`customer`.`date_of_birth` AS `date_of_birth`,trim(`customer`.`gender`) AS `gender`,trim(`customer`.`occupation`) AS `occupation`,trim(`customer`.`contact_number`) AS `contact_number`,trim(`customer`.`mail_id`) AS `mail_id`,trim(`student`.`stream`) AS `stream`,trim(`student`.`course_details`) AS `course_details` from (`student` join `customer` on((`student`.`customer_code` = `customer`.`code`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vendor_outlet_view`
--

/*!50001 DROP VIEW IF EXISTS `vendor_outlet_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vendor_outlet_view` AS select `vendor_outlet`.`code` AS `code`,`vendor_outlet`.`vendor_code` AS `vendor_code`,`vendor_outlet`.`address` AS `address`,`vendor_outlet`.`latitude` AS `latitude`,`vendor_outlet`.`longitude` AS `longitude`,`vendor_outlet`.`city_code` AS `city_code`,`vendor_outlet`.`contact_number` AS `contact_number` from `vendor_outlet` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vendor_view`
--

/*!50001 DROP VIEW IF EXISTS `vendor_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vendor_view` AS select `vendor`.`code` AS `code`,trim(`vendor`.`name_of_firm`) AS `name_of_firm`,trim(`vendor`.`username`) AS `username`,trim(`vendor`.`password`) AS `password`,trim(`vendor`.`password_key`) AS `password_key`,`vendor`.`city_code` AS `city_code`,trim(`vendor`.`address`) AS `address`,trim(`vendor`.`contact_number`) AS `contact_number`,trim(`vendor`.`mail_id`) AS `mail_id`,trim(`city`.`name`) AS `city_name`,trim(`city`.`state`) AS `state_name`,trim(`city`.`country`) AS `country_name` from (`vendor` join `city` on((`vendor`.`city_code` = `city`.`code`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-27 20:27:09
