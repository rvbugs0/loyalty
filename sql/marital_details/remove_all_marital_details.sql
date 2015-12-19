DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_all_marital_details` $$
CREATE PROCEDURE `loyalty`.`remove_all_marital_details` ()
BEGIN
truncate marital_details;
END $$

DELIMITER ;