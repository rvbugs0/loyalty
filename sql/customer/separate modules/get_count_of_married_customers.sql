DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_count_of_married_customers` $$
CREATE PROCEDURE `loyalty`.`get_count_of_married_customers` (out v_married_customers_count int)
BEGIN
declare customer_count Int;
select count(*) into customer_count from customer where is_married=true;
set v_married_customers_count=customer_count;

END $$

DELIMITER ;