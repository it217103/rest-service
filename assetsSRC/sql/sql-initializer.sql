CREATE DATABASE IF NOT EXISTS `student_database`;
USE `student_database`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `first_name` varchar(45) DEFAULT NULL,
                           `last_name` varchar(45) DEFAULT NULL,
                           `email` varchar(45) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


INSERT INTO `student` VALUES
                          (1,'David','Adams','david@hua.gr'),
                          (2,'John','Doe','john@hua.gr'),
                          (3,'Ajay','Rao','ajay@hua.gr'),
                          (4,'Mary','Public','mary@hua.gr'),
                          (5,'Maxwell','Dixon','max@hua.gr');