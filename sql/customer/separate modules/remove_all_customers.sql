DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_all_customers` $$
CREATE PROCEDURE `loyalty`.`remove_all_customers` ()
BEGIN
truncate customer;
END $$

DELIMITER ;