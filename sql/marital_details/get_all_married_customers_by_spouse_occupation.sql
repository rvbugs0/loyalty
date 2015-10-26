DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_married_customers_by_spouse_occupation` $$
CREATE PROCEDURE `loyalty`.`get_all_married_customers_by_spouse_occupation` (in v_spouse_occupation char(50))
BEGIN
select * from marital_details_view where spouse_occupation=v_spouse_occupation;
END $$

DELIMITER ;