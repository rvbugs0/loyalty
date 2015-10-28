DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_count` $$
CREATE PROCEDURE `loyalty`.`get_customer_count` (out v_customer_count int)
BEGIN
declare customer_count Int;
select count(*) into customer_count from customer;
set v_customer_count=customer_count;
END $$

DELIMITER ;