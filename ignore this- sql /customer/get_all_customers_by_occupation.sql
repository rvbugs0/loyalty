DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_customers_by_occupation` $$
CREATE PROCEDURE `loyalty`.`get_all_customers_by_occupation` (in v_occupation char(30))
BEGIN
select * from customer_view where occupation=v_occupation;
END $$

DELIMITER ;