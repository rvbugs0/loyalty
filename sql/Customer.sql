DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_customers` $$
CREATE PROCEDURE `loyalty`.`get_all_customers` ()
BEGIN
select * from customer_view;
END $$

DELIMITER ;
﻿
DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_count_by_name` $$
CREATE PROCEDURE `loyalty`.`get_customer_count_by_name` (in v_name char(50),out v_count int)
BEGIN
declare customer_count int;
select count(*) into customer_count from customer where name=v_name;
set v_count =customer_count;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_all_customers` $$
CREATE PROCEDURE `loyalty`.`remove_all_customers` ()
BEGIN
truncate customer;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`customer_exists_by_mail_id` $$
CREATE PROCEDURE `loyalty`.`customer_exists_by_mail_id` (in v_mail_id char(100))
BEGIN
select * from customer where mail_id=v_mail_id;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_customer` $$
CREATE PROCEDURE `loyalty`.`remove_customer` (in v_code int)
BEGIN
delete from customer where code=v_code;
END $$

DELIMITER ;

﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`customer_exists_by_contact_number` $$
CREATE PROCEDURE `loyalty`.`customer_exists_by_contact_number` (in v_contact_number char(20))
BEGIN
select * from customer where contact_number=v_contact_number;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_count_of_student_customers` $$
CREATE PROCEDURE `loyalty`.`get_count_of_student_customers` (out v_student_customers_count int)
BEGIN
declare customer_count Int;
select count(*) into customer_count from customer where is_student=true;
set v_student_customers_count=customer_count;

END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_male_customers` $$
CREATE PROCEDURE `loyalty`.`get_all_male_customers` ()
BEGIN
select * from customer_view where gender='M';
END $$

DELIMITER ;
﻿
DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`add_customer` $$
CREATE PROCEDURE `loyalty`.`add_customer` (in v_name char(50),in v_username char(20),in v_password char(100),in v_password_key char(100),in

v_permanent_address varchar(500),in v_current_address varchar(500),in v_city_code int,in v_date_of_birth date,in v_gender char(1),in v_occupation char

(30),in v_is_married bool,in v_is_student bool,in v_contact_number char(20),in v_mail_id char(100),out v_code int )
BEGIN
insert into customer (name,username,password,password_key,permanent_address,current_address,city_code,date_of_birth,gender,occupation,is_married,is_student,contact_number,mail_id) values(v_name,v_username,v_password,v_password_key,v_permanent_address,v_current_address,v_city_code,v_date_of_birth,v_gender,v_occupation,v_is_married,v_is_student,v_contact_number,v_mail_id);
set v_code=last_insert_id();

END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_customers_by_date_of_birth` $$
CREATE PROCEDURE `loyalty`.`get_all_customers_by_date_of_birth` (in v_date_of_birth date)
BEGIN
select * from customer_view where date_of_birth=v_date_of_birth;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_by_contact_number` $$
CREATE PROCEDURE `loyalty`.`get_customer_by_contact_number` (in v_contact_number char(20))
BEGIN
select * from customer_view where contact_number=v_contact_number;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_customers_by_city` $$
CREATE PROCEDURE `loyalty`.`get_all_customers_by_city` (in v_city_code int)
BEGIN
select * from customer_view where city_code=v_city_code;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_by_code` $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_customer_by_code`(in v_code int)
BEGIN
select * from customer_view where customer_code=v_code;
END $$

DELIMITER ;

﻿DROP VIEW IF EXISTS `loyalty`.`customer_view`;
CREATE OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `customer_view` AS select `customer`.`code` AS `customer_code`,trim(`customer`.`name`) AS `name`,trim(`customer`.`username`) AS `username`,trim(`customer`.`password`) AS `password`,trim(`customer`.`password_key`) AS `password_key`,trim(`customer`.`permanent_address`) AS `permanent_address`,trim(`customer`.`current_address`) AS `current_address`,`customer`.`city_code` AS `city_code`,trim(`city`.`name`) AS `city_name`,trim(`city`.`state`) AS `state`,trim(`city`.`country`) AS `country`,`customer`.`date_of_birth` AS `date_of_birth`,trim(`customer`.`gender`) AS `gender`,trim(`customer`.`occupation`) AS `occupation`,`customer`.`is_married` AS `is_married`,`customer`.`is_student` AS `is_student`,trim(`customer`.`contact_number`) AS `contact_number`,trim(`customer`.`mail_id`) AS `mail_id` from (`customer` join `city` on((`customer`.`city_code` = `city`.`code`)));
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_count_of_male_customers` $$
CREATE PROCEDURE `loyalty`.`get_count_of_male_customers` (out v_male_customers_count int)
BEGIN
declare customer_count Int;
select count(*) into customer_count from customer where gender='M';
set v_male_customers_count=customer_count;

END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_count_of_female_customers` $$
CREATE PROCEDURE `loyalty`.`get_count_of_female_customers` (out v_female_customers_count int)
BEGIN
declare customer_count Int;
select count(*) into customer_count from customer where gender='F';
set v_female_customers_count=customer_count;

END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_count_of_married_customers` $$
CREATE PROCEDURE `loyalty`.`get_count_of_married_customers` (out v_married_customers_count int)
BEGIN
declare customer_count Int;
select count(*) into customer_count from customer where is_married=true;
set v_married_customers_count=customer_count;

END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_customers_by_name` $$
CREATE PROCEDURE `loyalty`.`get_all_customers_by_name` (in v_name char(50))
BEGIN
select * from customer_view where name=v_name;
END $$

DELIMITER ;
DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`update_customer`$$
CREATE PROCEDURE `loyalty`.`update_customer` (in v_code int,in v_name char(50),in v_username char(20),in v_password char(100),in v_password_key char(100), in v_permanent_address Varchar(500),in v_current_address Varchar(500),in v_city_code int,in v_date_of_birth date,in v_gender char(1),in v_occupation char(30),in v_is_married bool,in v_is_student bool,in v_contact_number char(20),in v_mail_id char(100))


BEGIN

update customer set name=v_name,password=v_password,password_key =v_password_key,permanent_address=v_permanent_address ,current_address =v_current_address ,city_code =v_city_code ,date_of_birth=v_date_of_birth,gender =v_gender,occupation=v_occupation ,is_married =v_is_married ,is_student =v_is_student ,contact_number=v_contact_number ,mail_id =v_mail_id where username = v_username and code = v_code;
END$$

DELIMITER ;




﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_female_customers` $$
CREATE PROCEDURE `loyalty`.`get_all_female_customers` ()
BEGIN
select * from customer_view where gender='F';
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`customer_exists_by_code` $$
CREATE PROCEDURE `loyalty`.`customer_exists_by_code` (in v_code int)
BEGIN
select * from customer where code=v_code;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_count_by_city` $$
CREATE PROCEDURE `loyalty`.`get_customer_count_by_city` (in v_city_code int,out v_count int)
BEGIN
declare customer_count int;
select count(*) into customer_count from customer where city_code=v_city_code;
set v_count =customer_count;

END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`customer_exists_by_username` $$
CREATE PROCEDURE `loyalty`.`customer_exists_by_username` (in v_username char(20))
BEGIN
select * from customer where username=v_username;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_married_customers` $$
CREATE PROCEDURE `loyalty`.`get_all_married_customers` ()
BEGIN
select * from customer_view where is_married=true;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_by_mail_id` $$
CREATE PROCEDURE `loyalty`.`get_customer_by_mail_id` (in v_mail_id char(100))
BEGIN
select * from customer_view where mail_id=v_mail_id;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_student_customers` $$
CREATE PROCEDURE `loyalty`.`get_all_student_customers` ()
BEGIN
select * from customer_view where is_student=true;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_count_by_date_of_birth` $$
CREATE PROCEDURE `loyalty`.`get_customer_count_by_date_of_birth` (in v_date_of_birth char(50),out v_count int)
BEGIN
declare customer_count int;
select count(*) into customer_count from customer where date_of_birth=v_date_of_birth;
set v_count =customer_count;

END $$

DELIMITER ;

﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_count` $$
CREATE PROCEDURE `loyalty`.`get_customer_count` (out v_customer_count int)
BEGIN
declare customer_count Int;
select count(*) into customer_count from customer;
set v_customer_count=customer_count;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_count_by_occupation` $$
CREATE PROCEDURE `loyalty`.`get_customer_count_by_occupation` (in v_occupation char(30),out v_count int)
BEGIN
declare customer_count int;
select count(*) into customer_count from customer where occupation=v_occupation;
set v_count =customer_count;

END $$

DELIMITER ;

﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_customers_by_occupation` $$
CREATE PROCEDURE `loyalty`.`get_all_customers_by_occupation` (in v_occupation char(30))
BEGIN
select * from customer_view where occupation=v_occupation;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_by_username` $$
CREATE PROCEDURE `loyalty`.`get_customer_by_username` (in v_username char(20))
BEGIN
select * from customer_view where username=v_username;
END $$

DELIMITER ;
