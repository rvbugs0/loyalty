DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_count_by_city` $$
CREATE PROCEDURE `loyalty`.`get_customer_count_by_city` (in v_city_code int,out v_count int)
BEGIN
declare customer_count int;
select count(*) into customer_count from customer where city_code=v_city_code;
set v_count =customer_count;

END $$

DELIMITER ;