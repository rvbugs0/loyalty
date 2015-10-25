DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_customers_by_name` $$
CREATE PROCEDURE `loyalty`.`get_all_customers_by_name` (in v_name char(50))
BEGIN
select * from customer_view where name=v_name;
END $$

DELIMITER ;