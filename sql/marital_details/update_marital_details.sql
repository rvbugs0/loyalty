DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`update_marital_details` $$
CREATE PROCEDURE `loyalty`.`update_marital_details` (in v_customer_code int,in v_spouse_name char(50),in v_spouse_date_of_birth date,in v_anniversary_date date,in v_spouse_occupation char(50),in v_number_of_girl_child int,in v_number_of_boy_child int)
BEGIN
 update marital_details set spouse_name=v_spouse_name,spouse_date_of_birth=v_spouse_date_of_birth,anniversary_date=v_anniversary_date,spouse_occupation=v_spouse_occupation,number_of_girl_child=v_number_of_girl_child,number_of_boy_child=v_number_of_boy_child
 where customer_code=v_customer_code;
END $$

DELIMITER ;