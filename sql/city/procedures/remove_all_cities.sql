DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_all_cities`$$
CREATE PROCEDURE `loyalty`.`remove_all_cities` ()
BEGIN
truncate city;
END$$

DELIMITER ;
