DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_count_by_date_of_birth` $$
CREATE PROCEDURE `loyalty`.`get_customer_count_by_date_of_birth` (in v_date_of_birth char(50),out v_count int)
BEGIN
declare customer_count int;
select count(*) into customer_count from customer where date_of_birth=v_date_of_birth;
set v_count =customer_count;

END $$

DELIMITER ;
