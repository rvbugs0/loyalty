DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`update_customer`$$
CREATE PROCEDURE `loyalty`.`update_customer` (in v_code int,in v_name char(50),in v_username char(20),in v_password char(100),in v_password_key char(100), in v_permanent_address Varchar(500),in v_current_address Varchar(500),in v_city_code int,in v_date_of_birth date,in v_gender char(1),in v_occupation char(30),in v_is_married bool,in v_is_student bool,in v_contact_number char(20),in v_mail_id char(100))


BEGIN

update customer set name=v_name,password=v_password,password_key =v_password_key,permanent_address=v_permanent_address ,current_address =v_current_address ,city_code =v_city_code ,date_of_birth=v_date_of_birth,gender =v_gender,occupation=v_occupation ,is_married =v_is_married ,is_student =v_is_student ,contact_number=v_contact_number ,mail_id =v_mail_id where username = v_username and code = v_code;
END$$

DELIMITER ;



