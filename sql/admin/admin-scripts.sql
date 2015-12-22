Create table admin (
	code Int NOT NULL AUTO_INCREMENT,
	name Char(20) NOT NULL,
	username Char(20) NOT NULL,
	password Char(50) NOT NULL,
	password_key Char(50) NOT NULL,
	contact_number Char(100) NOT NULL,
	mail_id Char(100) NOT NULL,
	UNIQUE (code),
	UNIQUE (name),
	UNIQUE (username),
	UNIQUE (contact_number),
	UNIQUE (mail_id),
 Primary Key (code)) ENGINE = InnoDB;


DELIMITER $$
DROP PROCEDURE IF EXISTS `loyalty`.`get_admin_by_code`$$
CREATE PROCEDURE `loyalty`.`get_admin_by_code` (in v_code int)
BEGIN
select code, username ,password,password_key, mail_id , name ,contact_number from admin where code = v_code ;
END$$
DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`admin_exists_by_code`$$
CREATE PROCEDURE `loyalty`.`admin_exists_by_code` (in v_code int)
BEGIN
select code from admin where code = v_code;
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS `loyalty`.`get_admin_count`$$
CREATE PROCEDURE `loyalty`.`get_admin_count` (out v_admin_count int)
BEGIN
DECLARE admin_count Int;
select count(*) into admin_count from admin;
set v_admin_count = admin_count;
END$$

DELIMITER ;


DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_admin_by_name`$$
CREATE PROCEDURE `loyalty`.`get_admin_by_name` (in v_name char(20))
BEGIN
select code, username,password,password_key, mail_id , name,contact_number from admin where name= v_name ;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_admin_by_username`$$
CREATE PROCEDURE `loyalty`.`get_admin_by_username` (in v_username char(20))
BEGIN
select code, username,password,password_key, mail_id , contact_number,name from admin where username = v_username ;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_admin`$$
CREATE PROCEDURE `loyalty`.`remove_admin` (in v_code int)
BEGIN
delete from admin where code = v_code;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_all_admins`$$
CREATE PROCEDURE `loyalty`.`remove_all_admins` ()
BEGIN
truncate admins;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_admin_by_contact_number`$$
CREATE PROCEDURE `loyalty`.`get_admin_by_contact_number` (in v_contact_number char(100))
BEGIN
select code, username,password,password_key,mail_id , contact_number,name from admin  where contact_number = v_contact_number;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`update_admin`$$
CREATE PROCEDURE `loyalty`.`update_admin` (in v_code int,in v_name char(20),in v_username char(20),in v_password char(50),in v_password_key char(50),in v_mail_id char(100),in v_contact_number char(100))
BEGIN
update admin set name= v_name , password_key = v_password_key,password = v_password ,mail_id = v_mail_id ,contact_number= v_contact_number where code = v_code;
END$$

DELIMITER ;


DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`admin_exists_by_username`$$
CREATE PROCEDURE `loyalty`.`admin_exists_by_username` (in v_username char(20))
BEGIN
select code from admin where username = v_username;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`admin_exists_by_name`$$
CREATE PROCEDURE `loyalty`.`admin_exists_by_name` (in v_name char(20))
BEGIN
select code from admin where name = v_name;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_admins`$$
CREATE PROCEDURE `loyalty`.`get_all_admins` ()
BEGIN
select code, username,password,password_key,mail_id , contact_number,name from admin ;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`admin_exists_by_mail_id`$$
CREATE PROCEDURE `loyalty`.`admin_exists_by_mail_id` (in v_mail_id char(100))
BEGIN
select code from admin where mail_id = v_mail_id;
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS `loyalty`.`admin_exists_by_contact_number`$$
CREATE PROCEDURE `loyalty`.`admin_exists_by_contact_number` (in v_contact_number char(100))
BEGIN
select code from admin where contact_number = v_contact_number;
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS `loyalty`.`add_admin`$$
CREATE PROCEDURE `loyalty`.`add_admin` (in v_name char(20),in v_username char(20),in v_password char(50),in v_password_key char(50),in v_mail_id char(100),in v_contact_number char(100),out v_code int)
BEGIN
insert into admin (name,username,password,password_key, mail_id ,contact_number ) values (v_name,v_username,v_password,v_password_key,v_mail_id,v_contact_number);
set v_code = last_insert_id();
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS `loyalty`.`get_admin_by_mail_id`$$
CREATE PROCEDURE `loyalty`.`get_admin_by_mail_id` (in v_mail_id char(100))
BEGIN
select code, username,password,password_key,mail_id ,name,contact_number from admin where mail_id = v_mail_id ;
END$$
DELIMITER ;

/*
DELIMITER $$
DROP PROCEDURE IF EXISTS`loyalty`.`add_city`$$
CREATE PROCEDURE`loyalty`.`add_city`(in v_name char(30),v_state char(30),v_country char(30),out v_code int)
BEGIN
insert into city(name,state,country) values(v_name,v_state,v_country);
set v_code=last_insert_id();
END $$
DELIMITER;

DELIMITER $$
DROP PROCEDURE IF EXISTS`loyalty`.`update_city`$$
CREATE PROCEDURE`loyalty`.`update_city`(in v_code int,in v_name char(30),v_state char(30),v_country char(30))
BEGIN
update city set name=v_name,state=v_state,country=v_country where code=v_code;
END $$
DELIMITER;

DELIMITER $$
DROP PROCEDURE IF EXISTS`loyalty`.`remove_city`$$
CREATE PROCEDURE`loyalty`.`remove_city`(in v_code int)
BEGIN
delete from city where code=v_code;
END $$
DELIMITER;

DELIMITER $$
DROP PROCEDURE IF EXISTS`loyalty`.`get_by_city_Code`$$
CREATE PROCEDURE`loyalty`.`get_by_city_code`(in v_code int)
BEGIN
select * from city where code=v_code;
END $$
DELIMITER;

DELIMITER $$
DROP PROCEDURE IF EXISTS`loyalty`.`get_by_state`$$
CREATE PROCEDURE`loyalty`.`get_by_state`(in v_state char(30))
BEGIN
select * from city where state=v_state;
END $$
DELIMITER;

DELIMITER $$
DROP PROCEDURE IF EXISTS`loyalty`.`get_by_country`$$
CREATE PROCEDURE`loyalty`.`get_by_country`(in v_country char(30))
BEGIN
select * from city where country=v_country;
END $$
DELIMITER;

DELIMITER $$
DROP PROCEDURE IF EXISTS`loyalty`.`get_all_cities`$$
CREATE PROCEDURE`loyalty`.`get_all_cities`()
BEGIN
select * from city;
END $$
DELIMITER;

DELIMITER $$
DROP PROCEDURE IF EXISTS`loyalty`.`get_count`$$
CREATE PROCEDURE`loyalty`.`get_count`(out v_count int)
BEGIN
DECLARE count Int;
select count(*) into count from city;
set v_count=count;
END $$
DELIMITER;

DELIMITER $$
DROP PROCEDURE IF EXISTS`loyalty`.`get_count_by_state`$$
CREATE PROCEDURE`loyalty`.`get_count_by_state`(in v_state char(30),out v_count int)
BEGIN
DECLARE count Int;
select count(*) into count from city where state=v_state;
set v_count=count;
END $$
DELIMITER;

DELIMITER $$
DROP PROCEDURE IF EXISTS`loyalty`.`get_count_by_country`$$
CREATE PROCEDURE`loyalty`.`get_count_by_country`(in v_country char(30),out v_count int)
BEGIN
DECLARE count Int;
select count(*) into count from city where country=v_country;
set v_count=count;
END $$
DELIMITER;
*/






