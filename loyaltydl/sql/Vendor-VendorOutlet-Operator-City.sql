
drop table IF EXISTS marital_details;
drop table IF EXISTS student;
drop table IF EXISTS city;
drop table IF EXISTS operator;
drop table IF EXISTS vendor;
drop table IF EXISTS vendor_outlet;
drop table IF EXISTS customer;



Create table customer (
	code Int NOT NULL AUTO_INCREMENT,
	name Char(50) NOT NULL,
	username Char(20) NOT NULL,
	password Char(100) NOT NULL,
	password_key Char(100) NOT NULL,
	permanent_address Varchar(500),
	current_address Varchar(500) NOT NULL,
	city_code Int NOT NULL,
	date_of_birth Date NOT NULL,
	gender Char(1) NOT NULL,
	occupation Char(30) NOT NULL,
	is_married Bool NOT NULL,
	is_student Bool NOT NULL,
	contact_number Char(20) NOT NULL,
	mail_id Char(100) NOT NULL,
	UNIQUE (code),
	UNIQUE (username),
	UNIQUE (contact_number),
	UNIQUE (mail_id),
 Primary Key (code)) ENGINE = InnoDB;

Create table vendor_outlet (
	code Int NOT NULL AUTO_INCREMENT,
	vendor_code Int NOT NULL,
	address Varchar(500) NOT NULL,
	latitude Char(30) NOT NULL,
	longitude Char(30) NOT NULL,
	city_code Int NOT NULL,
	contact_number Char(20) NOT NULL,
	UNIQUE (code),
	UNIQUE (latitude),
	UNIQUE (longitude),
	UNIQUE (contact_number),
 Primary Key (code)) ENGINE = InnoDB;

Create table vendor (
	code Int NOT NULL AUTO_INCREMENT,
	name_of_firm Char(50) NOT NULL,
	username Char(50) NOT NULL COMMENT '**',
	password Char(100) NOT NULL,
	password_key Char(100) NOT NULL,
	address Varchar(500) NOT NULL,
	city_code Int NOT NULL,
	contact_number Char(20) NOT NULL,
	mail_id Char(100) NOT NULL,
	UNIQUE (code),
	UNIQUE (name_of_firm),
	UNIQUE (username),
	UNIQUE (contact_number),
	UNIQUE (mail_id),
 Primary Key (code)) ENGINE = InnoDB;

Create table operator (
	code Int NOT NULL AUTO_INCREMENT,
	name Char(30) NOT NULL,
	username Char(30) NOT NULL,
	password Char(100) NOT NULL,
	password_key Char(100) NOT NULL,
	vendor_outlet_code Int NOT NULL,
	UNIQUE (code),
	UNIQUE (username),
	UNIQUE (password),
 Primary Key (code)) ENGINE = InnoDB;

Create table city (
	code Int NOT NULL AUTO_INCREMENT,
	name Char(30) NOT NULL,
	state Char(30) NOT NULL,
	country Char(30) NOT NULL,
	UNIQUE (code),
 Primary Key (code)) ENGINE = InnoDB;

Create table student (
	customer_code Int NOT NULL,
	stream Char(50) NOT NULL,
	course_details Char(100) NOT NULL,
	UNIQUE (customer_code),
 Primary Key (customer_code)) ENGINE = InnoDB;

Create table marital_details (
	customer_code Int NOT NULL,
	spouse_name Char(50),
	spouse_date_of_birth Date,
	anniversary_date Date,
	spouse_occupation Char(50),
	number_of_girl_child Int,
	number_of_boy_child Int,
	UNIQUE (customer_code),
 Primary Key (customer_code)) ENGINE = InnoDB;


Alter table student add Constraint Relationship8 Foreign Key (customer_code) references customer (code) on delete  restrict on update  restrict;
Alter table marital_details add Constraint Relationship9 Foreign Key (customer_code) references customer (code) on delete  restrict on update  restrict;
Alter table operator add Constraint Relationship5 Foreign Key (vendor_outlet_code) references vendor_outlet (code) on delete  restrict on update  restrict;
Alter table vendor_outlet add Constraint Relationship4 Foreign Key (vendor_code) references vendor (code) on delete  restrict on update  restrict;
Alter table customer add Constraint Relationship1 Foreign Key (city_code) references city (code) on delete  restrict on update  restrict;
Alter table vendor_outlet add Constraint Relationship2 Foreign Key (city_code) references city (code) on delete  restrict on update  restrict;
Alter table vendor add Constraint Relationship3 Foreign Key (city_code) references city (code) on delete  restrict on update  restrict;



/* city  */

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`update_city`$$
CREATE PROCEDURE `loyalty`.`update_city` (in v_code int,in v_name char(30),in v_state char(30),in v_country char(30))
BEGIN
UPDATE city set name = v_name , state = v_state , country = v_country where code = v_code;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_city_by_code`$$
CREATE PROCEDURE `loyalty`.`get_city_by_code` (in v_code int)
BEGIN
select * from city where code = v_code ;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`city_exists_by_name`$$
CREATE PROCEDURE `loyalty`.`city_exists_by_name` (in v_name char(30))
BEGIN
select * from city where name = v_name;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_cities`$$
CREATE PROCEDURE `loyalty`.`get_all_cities` ()
BEGIN
select * from city ;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`add_city`$$
CREATE PROCEDURE `loyalty`.`add_city` (in v_name char(30),in v_state char(30),in v_country char(30),out code int)
BEGIN
INSERT INTO city (name,state,country) values (v_name,v_state,v_country);
set code = last_insert_id();
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_all_cities`$$
CREATE PROCEDURE `loyalty`.`remove_all_cities` ()
BEGIN
truncate city;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_city_count`$$
CREATE PROCEDURE `loyalty`.`get_city_count` (out v_city_count int)
BEGIN
DECLARE city_count Int;
select count(*) into city_count from city; 
set v_city_count = city_count;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_cities_by_name`$$
CREATE PROCEDURE `loyalty`.`get_cities_by_name` (in v_name char(30))
BEGIN
select * from city where name=v_name;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_city`$$
CREATE PROCEDURE `loyalty`.`remove_city` (in v_code int)
BEGIN
delete from city where code = v_code;
END$$


DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_city_count_by_name`$$
CREATE PROCEDURE `loyalty`.`get_city_count_by_name` (in v_name char(30),out v_count int)
BEGIN
DECLARE city_count int;
select count(*) into city_count from city where name= v_name;
set v_count=city_count; 
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`city_exists_by_code`$$
CREATE PROCEDURE `loyalty`.`city_exists_by_code` (in v_code int)
BEGIN
select * from city where code = v_code;
END$$

DELIMITER ;

/* vendor */

create view vendor_view as 
select vendor.code as code  , trim(name_of_firm) as name_of_firm , trim(username) as username , trim(password) as password, trim(password_key) as password_key, city_code ,trim(address) as address, trim(contact_number) as contact_number,trim(mail_id) as mail_id, trim(city.name)  as city_name , trim(state) as state_name , trim(country) as country_name  from vendor inner join city on vendor.city_code = city.code;


DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_by_code`$$
CREATE PROCEDURE `loyalty`.`get_vendor_by_code` (in v_code int)
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , name_of_firm ,contact_number from vendor_view where code = v_code ; 
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_exists_by_code`$$
CREATE PROCEDURE `loyalty`.`vendor_exists_by_code` (in v_code int)
BEGIN
select code from vendor_view where code = v_code;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_count`$$
CREATE PROCEDURE `loyalty`.`get_vendor_count` (out v_vendor_count int)
BEGIN
DECLARE vendor_count Int;
select count(*) into vendor_count from vendor_view; 
set v_vendor_count = vendor_count;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_count_by_city`$$
CREATE PROCEDURE `loyalty`.`get_vendor_count_by_city` (in v_city_code int,out v_vendor_count int)
BEGIN
DECLARE vendor_count Int;
select count(*) into vendor_count from vendor_view where city_code = v_city_code ; 
set v_vendor_count = vendor_count;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_by_name_of_firm`$$
CREATE PROCEDURE `loyalty`.`get_vendor_by_name_of_firm` (in v_name char(50))
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , name_of_firm ,contact_number from vendor_view where name_of_firm = v_name ; 
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_by_username`$$
CREATE PROCEDURE `loyalty`.`get_vendor_by_username` (in v_username char(50))
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , contact_number,name_of_firm from vendor_view where username = v_username ; 
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_vendor`$$
CREATE PROCEDURE `loyalty`.`remove_vendor` (in v_code int)
BEGIN
delete from vendor where code = v_code;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_all_vendors`$$
CREATE PROCEDURE `loyalty`.`remove_all_vendors` ()
BEGIN
truncate vendors;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_by_contact_number`$$
CREATE PROCEDURE `loyalty`.`get_vendor_by_contact_number` (in v_contact_number char(20))
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , contact_number,name_of_firm from vendor_view  where contact_number = v_contact_number;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`update_vendor`$$
CREATE PROCEDURE `loyalty`.`update_vendor` (in v_code int,in v_name char(50),in v_username char(50),in v_password_key char(100),in v_password char(100),in v_city_code int, in v_address Varchar(500),in v_mail_id char(100),in v_contact_number char(20))
BEGIN
update vendor set name_of_firm = v_name , password_key = v_password_key ,password = v_password ,city_code = v_city_code ,address= v_address ,mail_id = v_mail_id ,contact_number= v_contact_number where code = v_code;
END$$

DELIMITER ;


DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_exists_by_username`$$
CREATE PROCEDURE `loyalty`.`vendor_exists_by_username` (in v_username char(50))
BEGIN
select code from vendor_view where username = v_username;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_exists_by_name_of_firm`$$
CREATE PROCEDURE `loyalty`.`vendor_exists_by_name_of_firm` (in v_name char(50))
BEGIN
select code from vendor_view where name_of_firm = v_name;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_vendors`$$
CREATE PROCEDURE `loyalty`.`get_all_vendors` ()
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , contact_number,name_of_firm from vendor_view  ;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_exists_by_mail_id`$$
CREATE PROCEDURE `loyalty`.`vendor_exists_by_mail_id` (in v_mail_id char(100))
BEGIN
select code from vendor_view where mail_id = v_mail_id;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_exists_by_contact_number`$$
CREATE PROCEDURE `loyalty`.`vendor_exists_by_contact_number` (in v_contact_number char(20))
BEGIN
select code from vendor_view where contact_number = v_contact_number;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`add_vendor`$$
CREATE PROCEDURE `loyalty`.`add_vendor` (in v_name char(50),in v_username char(50),in v_password_key char(100),in v_password char(100),in v_city_code int, in v_address Varchar(500),in v_mail_id char(100),in v_contact_number char(20),out v_code int)
BEGIN
insert into vendor (name_of_firm ,username ,password_key ,password ,  city_code, address, mail_id ,contact_number ) values (v_name,v_username,v_password_key,v_password,v_city_code,v_address,v_mail_id,v_contact_number);
set v_code = last_insert_id();
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_by_mail_id`$$
CREATE PROCEDURE `loyalty`.`get_vendor_by_mail_id` (in v_mail_id char(100))
BEGIN
select code, username , city_code ,password,password_key,address , mail_id ,name_of_firm ,contact_number from vendor_view where mail_id = v_mail_id ; 
END$$

DELIMITER ;

/*  vendor outlet */

create view vendor_outlet_view as select * from vendor_outlet;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_outlet_by_coordinates`$$
CREATE PROCEDURE `loyalty`.`get_vendor_outlet_by_coordinates` (in v_latitude char(30),in v_longitude char(30))
BEGIN
select code , latitude , longitude ,address,contact_number,city_code ,vendor_code from vendor_outlet_view where latitude = v_latitude and longitude = v_longitude ;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_vendor_outlets_by_city`$$
CREATE PROCEDURE `loyalty`.`get_all_vendor_outlets_by_city` (in v_city_code int)
BEGIN
select code , latitude , longitude ,address,contact_number,city_code ,vendor_code from vendor_outlet_view where city_code = v_city_code ;	
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_vendor_outlet`$$
CREATE PROCEDURE `loyalty`.`remove_vendor_outlet` (in v_code int)
BEGIN
delete from vendor_outlet where code = v_code ;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_vendor_outlets_by_vendor_code`$$
CREATE PROCEDURE `loyalty`.`get_all_vendor_outlets_by_vendor_code` (in v_vendor_code int)
BEGIN
select code , latitude , longitude ,address,contact_number,city_code ,vendor_code from vendor_outlet_view where vendor_code = v_vendor_code ;	
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_vendor_outlets`$$
CREATE PROCEDURE `loyalty`.`get_all_vendor_outlets` ()
BEGIN
select code , latitude , longitude ,address,contact_number ,vendor_code ,city_code from vendor_outlet_view  ;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_all_vendor_outlets`$$
CREATE PROCEDURE `loyalty`.`remove_all_vendor_outlets` ()
BEGIN
truncate vendor_outlet;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_outlet_exists_by_contact_number`$$
CREATE PROCEDURE `loyalty`.`vendor_outlet_exists_by_contact_number` (in v_contact_number char(20))
BEGIN
select code from vendor_outlet_view where contact_number = v_contact_number ;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`add_vendor_outlet`$$
CREATE PROCEDURE `loyalty`.`add_vendor_outlet` (in v_vendor_code int,in v_address Varchar(500),in v_latitude char(30),in v_longitude char(30),in v_city_code int,in v_contact_number char(20),out v_out_code int)
BEGIN
insert into vendor_outlet (vendor_code ,address,latitude,longitude,city_code ,contact_number) values (v_vendor_code , v_address,v_latitude,v_longitude,v_city_code ,v_contact_number);
set v_out_code = last_insert_id();
END$$

DELIMITER ;


DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_outlet_count`$$
CREATE PROCEDURE `loyalty`.`get_vendor_outlet_count` (out v_count int)
BEGIN
DECLARE v_outlet_count int;
select count(*) into v_outlet_count from vendor_outlet_view ;
set  v_count = v_outlet_count ;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_outlet_count_by_city`$$
CREATE PROCEDURE `loyalty`.`get_vendor_outlet_count_by_city` (in v_city_code int ,out v_count int)
BEGIN
DECLARE v_outlet_count int;
select count(*) into v_outlet_count from vendor_outlet_view where city_code = v_city_code;
set  v_count = v_outlet_count ;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_outlet_exists_by_coordinates`$$
CREATE PROCEDURE `loyalty`.`vendor_outlet_exists_by_coordinates` (in v_latitude char(30),in v_longitude char(30))
BEGIN
select code from vendor_outlet_view where latitude = v_latitude and longitude = v_longitude ;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_outlet_by_contact_number`$$
CREATE PROCEDURE `loyalty`.`get_vendor_outlet_by_contact_number` (in v_contact_number char(20))
BEGIN
select code , latitude , longitude ,address,contact_number ,vendor_code,city_code from vendor_outlet_view where contact_number = v_contact_number ;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_outlet_exists_by_code`$$
CREATE PROCEDURE `loyalty`.`vendor_outlet_exists_by_code` (in v_code int)
BEGIN
select code from vendor_outlet_view where code=v_code;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_outlet_by_code`$$
CREATE PROCEDURE `loyalty`.`get_vendor_outlet_by_code` (in v_code int)
BEGIN
select code , latitude , longitude ,address,contact_number ,vendor_code ,city_code from vendor_outlet_view where code = v_code ;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`update_vendor_outlet`$$
CREATE PROCEDURE `loyalty`.`update_vendor_outlet` (in v_code int,in v_vendor_code int,in v_address Varchar(500),in v_latitude char(30),in v_longitude char(30),in v_city_code int,in v_contact_number char(20))
BEGIN
update vendor_outlet set latitude=v_latitude , longitude=v_longitude ,address = v_address ,contact_number= v_contact_number ,vendor_code = v_vendor_code where code =v_code;
END$$

DELIMITER ;

/* operator */


DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `add_operator`(in v_vendor_outlet_code integer,in v_name char(30),in v_username char(30),in v_password char (30),out v_code integer)
BEGIN
insert into operator (vendor_outlet_code,name,username,password) values (v_vendor_outlet_code,v_name,v_username,md5(password));
set v_code=last_inset_id();
END$$
DELIMITER ;



DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_all_operators`()
BEGIN
select * from operator ;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_all_operators_by_vendor_outlet_code`(in v_vendor_outlet_code integer)
BEGIN
select * from operator where vendor_outlet_code=v_vendor_outlet_code ;
END$$
DELIMITER ;



DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_by_code`(in v_code integer)
BEGIN
select * from operator where code=v_code;
END$$
DELIMITER ;





DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_by_name`(in v_name char(30))
BEGIN
select * from operator where name=v_name;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_by_username`(in v_username char(30))
BEGIN
select * from operator where username=v_username;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_count`()
BEGIN
select count(*) as cnt from operator;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_count_by_name`(in v_name char(30))
BEGIN
select count(*) as cnt from operator where  name=v_name;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_count_by_username`(in v_username char(30))
BEGIN
select count(*) as cnt from operator where username=v_username;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_count_by_vendor_outlet_code`(in v_vendor_outlet_code integer)
BEGIN
select count(*) as cnt from operator where vendor_outlet_code=v_vendor_outlet_code;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `operator_exists_by_code`(in v_code integer)
BEGIN
select * from operator where code=v_code;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `operator_exists_by_username`(in v_username char(30))
BEGIN
select * from operator where username=v_username;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `remove_all_operators`()
BEGIN
delete from operator ;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `remove_operator`(in v_code integer)
BEGIN
delete from operator where code=v_code;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `remove_operator_by_username`(in v_username char(30))
BEGIN
delete from operator where username=v_username;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `remove_all_operators_by_vendor_outlet_code`(in vendor_outlet_code integer)
BEGIN
delete from operator where vendor_outlet_code=v_vendor_outlet_code;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `update_operator`(in v_code integer,in v_vendor_outlet_code integer,in v_name char(30),in v_username char(30),in v_password char (30))
BEGIN
update operator set vendor_outlet_code=v_vendor_outlet_code,name=v_name,username =v_username,password=md5(password) where code=v_code;
END$$
DELIMITER ;




