DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_married_customer_count_by_spouse_date_of_birth` $$
CREATE PROCEDURE `loyalty`.`get_married_customer_count_by_spouse_date_of_birth` (in v_spouse_date_of_birth date)
BEGIN
select * from marital_details where spouse_date_of_birth=v_spouse_date_of_birth;
END $$

DELIMITER ;