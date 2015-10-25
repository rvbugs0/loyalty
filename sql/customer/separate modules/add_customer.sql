
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