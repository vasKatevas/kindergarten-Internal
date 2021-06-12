GRANT ALL ON *.* to 'hbstudent'@'%' IDENTIFIED BY 'p@ssword123';
CREATE DATABASE kindergarten;
USE kindergarten;
CREATE TABLE IF NOT EXISTS `user` (
 `username` varchar(50) NOT NULL,
 `password` varchar(100) NOT NULL,
 `enabled` tinyint(1) NOT NULL,
 PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `authorities` (
 `username` varchar(50) NOT NULL,
 `authority` varchar(50) NOT NULL,
 UNIQUE KEY `ix_auth_username` (`username`,`authority`),
 CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



create table IF NOT EXISTS `user_information` (
`username` varchar(50) not null,
`firstName` varchar(50) not null,
`lastName` varchar(50) not null,
PRIMARY KEY (`username`),
foreign key (username) references user(username)  ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS `teacher` (
  `username` varchar(50) NOT NULL,
  `class` int(10) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `class` (`class`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS `child` (
  `id` int(11) auto_increment NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `classroom` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `child_ibfk_1` FOREIGN KEY (`classroom`) REFERENCES `teacher` (`class`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `application` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `parent_first_name` varchar(30) NOT NULL,
  `parent_last_name` varchar(30) NOT NULL,
  `income` int NOT NULL,
  `child_first_name` varchar(30) NOT NULL,
  `child_last_name` varchar(30) NOT NULL,
  `age` int NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

INSERT IGNORE INTO `user` (`username`, `password`, `enabled`) VALUES
    ('admin', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1);

INSERT IGNORE INTO `authorities` (`username`, `authority`) VALUES
    ('admin', 'ROLE_ADMIN');

INSERT IGNORE INTO `user` (`username`, `password`, `enabled`) VALUES
    ('external', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1);

INSERT IGNORE INTO `authorities` (`username`, `authority`) VALUES
    ('external', 'ROLE_EXTERNAL');


