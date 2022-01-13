CREATE TABLE IF NOT EXISTS `user` (
    `username` varchar (50) NOT NULL,
    `password` varchar(100) NOT NULL,
    `enabled` tinyint(1) NOT NULL,
    PRIMARY KEY (`username`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `auth_username` (`username`,`authority`),
  CONSTRAINT `authorities_users` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` (`username`, `password`,`enabled`) VALUES
    ('user', 'pass12',1),
    ('root','root',1);

INSERT INTO `authorities`(`username`,`authority`) VALUES
    ('root','ROLE_ADMIN'),
    ('user', 'ROLE_USER');
