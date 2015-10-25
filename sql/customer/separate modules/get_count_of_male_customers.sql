DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_count_of_male_customers` $$
CREATE PROCEDURE `loyalty`.`get_count_of_male_customers` (out v_male_customers_count int)
BEGIN
declare customer_count Int;
select count(*) into customer_count from customer where gender='M';
set v_male_customers_count=customer_count;

END $$

DELIMITER ;