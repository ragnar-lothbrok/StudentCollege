create database testDB;

use testDB;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) DEFAULT NULL,
  `lastName` varchar(20) DEFAULT NULL,
  `mobileNo` varchar(10) DEFAULT NULL,
  `country` varchar(32) DEFAULT 'India',
  `aboutMe` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `college` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `student_college` (
  `student_id` int(11) NOT NULL,
  `college_id` int(11) NOT NULL,
  PRIMARY KEY (college_id,`student_id`),
  CONSTRAINT `student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `college_id_fk` FOREIGN KEY (`college_id`) REFERENCES `college` (`id`)
);

insert into college(name) values ("NIT Bhopal"),("NIT Durgapur"),("NIT Surat"),("NIT Jaipur"),("NIT SriNagar");