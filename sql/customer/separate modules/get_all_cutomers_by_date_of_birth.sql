DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_customers_by_date_of_birth` $$
CREATE PROCEDURE `loyalty`.`get_all_customers_by_date_of_birth` (in v_date_of_birth date)
BEGIN
select * from customer_view where date_of_birth=v_date_of_birth;
END $$

DELIMITER ;