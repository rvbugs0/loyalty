DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_male_customers` $$
CREATE PROCEDURE `loyalty`.`get_all_male_customers` ()
BEGIN
select * from customer_view where gender='M';
END $$

DELIMITER ;