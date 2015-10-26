DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`add_marital_details` $$
CREATE PROCEDURE `loyalty`.`add_marital_details` (in v_customer_code int,in v_spouse_name char(50),in v_spouse_date_of_birth date,in v_anniversary_date date,in v_spouse_occupation char(50),in v_number_of_girl_child int,in v_number_of_boy_child int)
BEGIN
insert into marital_details (customer_code,spouse_name,spouse_date_of_birth,anniversary_date,spouse_occupation,number_of_girl_child,number_of_boy_child) values(v_customer_code,v_spouse_name,v_spouse_date_of_birth,v_anniversary_date,v_spouse_occupation,v_number_of_girl_child,v_number_of_boy_child);
END $$

DELIMITER ;