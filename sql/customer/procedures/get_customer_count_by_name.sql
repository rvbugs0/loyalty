
DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_count_by_name` $$
CREATE PROCEDURE `loyalty`.`get_customer_count_by_name` (in v_name char(50),out v_count int)
BEGIN
declare customer_count int;
select count(*) into customer_count from customer where name=v_name;
set v_count =customer_count;
END $$

DELIMITER ;