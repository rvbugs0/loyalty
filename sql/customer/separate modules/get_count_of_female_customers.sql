DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_count_of_female_customers` $$
CREATE PROCEDURE `loyalty`.`get_count_of_female_customers` (out v_female_customers_count int)
BEGIN
declare customer_count Int;
select count(*) into customer_count from customer where gender='F';
set v_female_customers_count=customer_count;

END $$

DELIMITER ;