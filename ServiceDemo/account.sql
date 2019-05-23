
create database bank character set utf8;

use bank;

CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  `balance` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

INSERT INTO `bank`.`account` (`name`, `balance`) VALUES ('张三', 1000);
INSERT INTO account (name, balance) VALUES ('李四', 1000);
INSERT INTO account (name, balance) VALUES ('lisa', 1000);

select * from account where name='张三';

