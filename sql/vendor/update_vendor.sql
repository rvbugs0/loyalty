DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`update_vendor`$$
CREATE PROCEDURE `loyalty`.`update_vendor` (in v_code int,in v_name char(50),in v_username char(50),in v_password_key char(100),in v_password char(100),in v_city_code int, in v_address Varchar(500),in v_mail_id char(100),in v_contact_number char(20))
BEGIN
update vendor set name_of_firm = v_name , password_key = v_password_key ,password = v_password ,city_code = v_city_code ,address= v_address ,mail_id = v_mail_id ,contact_number= v_contact_number where code = v_code;
END$$

DELIMITER ;

