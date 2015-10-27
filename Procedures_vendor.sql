/*vendor_view*/
DROP VIEW IF EXISTS 'vendor_view';
create view vendor_view as 
select vendor.code as code  , trim(name_of_firm) as name_of_firm , trim(username) as username , trim(password) as password, trim(password_key) as password_key, city_code ,trim(address) as address, trim(contact_number) as contact_number,trim(mail_id) as mail_id, trim(city.name)  as city_name , trim(state) as state_name , trim(country) as country_name  from vendor inner join city on vendor.city_code = city.code;  


/*add vendor */


DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`add_vendor`$$
CREATE PROCEDURE `loyalty`.`add_vendor` (in v_name char(50),in v_username char(50),in v_password_key char(100),in v_password char(100),in v_city_code int, in v_address Varchar(500),in v_mail_id char(100),in v_contact_number char(100),out v_code int)
BEGIN
insert into vendor (name_of_firm ,username ,password_key ,password ,  city_code, address, mail_id ,contact_number ) values (v_name,v_username,v_password_key,v_password,v_city_code,v_address,v_mail_id,v_contact_number);
set v_code = last_insert_id();
END$$

DELIMITER ;


/*update vendor*/

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`update_vendor`$$
CREATE PROCEDURE `loyalty`.`update_vendor` (in v_code int,in v_name char(50),in v_username char(50),in v_password_key char(100),in v_password char(100),in v_city_code int, in v_address Varchar(500),in v_mail_id char(100),in v_contact_number char(100))
BEGIN
update vendor set name_of_firm = v_name , password_key = v_password_key ,password = v_password ,city_code = v_city_code ,address= v_address ,mail_id = v_mail_id ,contact_number= v_contact_number where username = v_username and code = v_code;
END$$

DELIMITER ;



/*get vendor count*/

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_count`$$
CREATE PROCEDURE `loyalty`.`get_vendor_count` (out v_vendor_count int)
BEGIN
DECLARE vendor_count Int;
select count(*) into vendor_count from vendor_view; 
set v_vendor_count = vendor_count;
END$$

DELIMITER ;


/*get vendor count by contact number*/

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_count_by_contact_number`$$
CREATE PROCEDURE `loyalty`.`get_vendor_count_by_contact_number` (in v_phone_number char(100),out v_count int)
BEGIN
DECLARE vendor_count int;
select count(*) into vendor_count from vendor where contact_number = v_phone_number;
set v_count=vendor_count; 
END$$

DELIMITER ;


/*get vendor count by username*/

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_count_by_username`$$
CREATE PROCEDURE `loyalty`.`get_vendor_count_by_username` (in v_username char(50),out v_count int)
BEGIN
DECLARE vendor_count int;
select count(*) into vendor_count from vendor where username= v_username;
set v_count=vendor_count; 
END$$

DELIMITER ;




/*vendor exists by username*/

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_exists_by_username`$$
CREATE PROCEDURE `loyalty`.`vendor_exists_by_username` (in v_username char(50))
BEGIN
select code from vendor_view where username = v_username;
END$$

DELIMITER ;


/*vendor exists by code*/

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_exists_by_code`$$
CREATE PROCEDURE `loyalty`.`vendor_exists_by_code` (in v_code int)
BEGIN
select code from vendor_view where code = v_code;
END$$

DELIMITER ;


/*vendor exists by mail_id*/

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_exists_by_mail_id`$$
CREATE PROCEDURE `loyalty`.`vendor_exists_by_mail_id` (in v_mail_id char(100))
BEGIN
select code from vendor_view where mail_id = v_mail_id;
END$$

DELIMITER ;


/*vendor exists by contact_number*/

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_exists_by_contact_number`$$
CREATE PROCEDURE `loyalty`.`vendor_exists_by_mail_id` (in v_contact_number char(20))
BEGIN
select code from vendor_view where contact_number = v_contact_number;
END$$

DELIMITER ;


/*get vendor by contact number */
DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_by_contact_number`$$
CREATE PROCEDURE `loyalty`.`get_vendor_by_contact_number` (in v_contact_number char(100))
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , contact_number from vendor_view  where contact_number = v_contact_number;
END$$

DELIMITER ;

/*get vendor by email id */
DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_by_mail_id`$$
CREATE PROCEDURE `loyalty`.`get_vendor_by_mail_id` (in v_mail_id char(100))
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , contact_number from vendor_view where mail_id = v_mail_id ; 
END$$

DELIMITER ;



