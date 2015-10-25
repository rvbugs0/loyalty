DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_customers` $$
CREATE PROCEDURE `loyalty`.`get_all_customers` ()
BEGIN
select * from customer_view;
END $$

DELIMITER ;