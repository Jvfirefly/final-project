-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: trips
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`role_id`, `name`) VALUES (1,'user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
INSERT INTO `trip` (`trip_id`, `user_id`, `name`, `date_from`, `date_to`, `impressions`, `photo1`, `title1`, `description1`, `photo2`, `title2`, `description2`, `location`, `deleted`) VALUES (6,4,'My trip to Antananarivo','2019-05-16','2019-05-19','The fauna and flora were unique.','lake-anosy.jpg','Lac Anosy','The lake was in the city centre.','baobab-trees.jpg','Baobab Trees','The trip to the Avenue of the Baobabs was an adventure on its own.','Madagascar',0);
INSERT INTO `trip` (`trip_id`, `user_id`, `name`, `date_from`, `date_to`, `impressions`, `photo1`, `title1`, `description1`, `photo2`, `title2`, `description2`, `location`, `deleted`) VALUES (7,4,'My trip to London','2019-05-01','2019-05-02','This city was amazing.','train.jpg','On the Train','This train was huge.','big-ben.jpg','Big Ben','I had the awkward sensation of traveling through time.','London',0);
INSERT INTO `trip` (`trip_id`, `user_id`, `name`, `date_from`, `date_to`, `impressions`, `photo1`, `title1`, `description1`, `photo2`, `title2`, `description2`, `location`, `deleted`) VALUES (8,12,'My first time in Bali','2019-04-11','2019-04-18','We had a wonderful time there.','beach.jpg','At the Beach','We saw a dolphin that day.','monkey.jpg','In the Rainforest','We saw a sweet little monkey.','Bali',0);
INSERT INTO `trip` (`trip_id`, `user_id`, `name`, `date_from`, `date_to`, `impressions`, `photo1`, `title1`, `description1`, `photo2`, `title2`, `description2`, `location`, `deleted`) VALUES (11,4,'My Home','2019-05-07','2019-05-08','nice','01.jpg','nice','nice','02.jpg','nice','nice','Brasov',0);
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `name`, `surname`, `username`, `password`, `city`, `address`, `phone`) VALUES (4,'Teodora','Enache','Teo','$2a$10$2yTdKzc7IQ0YKoiv6IMreuzGml9Mn.1dcDUCZELLnXBB0.s4rJiiq','Brasov','Zizinului','0744663366');
INSERT INTO `user` (`user_id`, `name`, `surname`, `username`, `password`, `city`, `address`, `phone`) VALUES (11,'Andrei','Stan','Andi','$2a$10$.gfP33xpbL5jLQgDnG82b.3zmnBrA7yHSgL4lgy3WQV4nsPa5PfAi','Brasov','Sperantei','0745123456');
INSERT INTO `user` (`user_id`, `name`, `surname`, `username`, `password`, `city`, `address`, `phone`) VALUES (12,'Michaela','Springer','Michi','$2a$10$yuiCgL9f9sD/6OfpLLOQ3.8AUzu07.ehr80A/6y2LV/mCDLNL0pia','Berlin','Dresdener Straße','0755456789');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (4,1);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (11,1);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (12,1);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-22 18:13:00
