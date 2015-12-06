DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_married_customer_count_by_spouse_occupation` $$
CREATE PROCEDURE `loyalty`.`get_married_customer_count_by_spouse_occupation` (in v_spouse_occupation char(50))
BEGIN
select * from marital_details where spouse_occupation=v_spouse_occupation;
END $$

DELIMITER ;