DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_married_customers_by_spouse_date_of_birth` $$
CREATE PROCEDURE `loyalty`.`get_all_married_customers_by_spouse_date_of_birth` (in v_spouse_date_of_birth date)
BEGIN
select * from marital_details_view where spouse_date_of_birth=v_spouse_date_of_birth;
END $$

DELIMITER ;