DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_all_vendors`$$
CREATE PROCEDURE `loyalty`.`remove_all_vendors` ()
BEGIN
truncate vendors;
END$$

DELIMITER ;
