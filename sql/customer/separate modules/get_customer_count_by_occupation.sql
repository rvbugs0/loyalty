DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_count_by_occupation` $$
CREATE PROCEDURE `loyalty`.`get_customer_count_by_occupation` (in v_occupation char(30),out v_count int)
BEGIN
declare customer_count int;
select count(*) into customer_count from customer where occupation=v_occupation;
set v_count =customer_count;

END $$

DELIMITER ;
