DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_customers_by_city` $$
CREATE PROCEDURE `loyalty`.`get_all_customers_by_city` (in v_city_code int)
BEGIN
select * from customer_view where city_code=v_city_code;
END $$

DELIMITER ;