DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`add_vendor`$$
CREATE PROCEDURE `loyalty`.`add_vendor` (in v_name char(50),in v_username char(50),in v_password_key char(100),in v_password char(100),in v_city_code int, in v_address Varchar(500),in v_mail_id char(100),in v_contact_number char(20),out v_code int)
BEGIN
insert into vendor (name_of_firm ,username ,password_key ,password ,  city_code, address, mail_id ,contact_number ) values (v_name,v_username,v_password_key,v_password,v_city_code,v_address,v_mail_id,v_contact_number);
set v_code = last_insert_id();
END$$

DELIMITER ;
