DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_married_customers` $$
CREATE PROCEDURE `loyalty`.`get_all_married_customers` ()
BEGIN
select * from customer_view where is_married=true;
END $$

DELIMITER ;