DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_female_customers` $$
CREATE PROCEDURE `loyalty`.`get_all_female_customers` ()
BEGIN
select * from customer_view where gender='F';
END $$

DELIMITER ;