DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_all_vendor_outlets`$$
CREATE PROCEDURE `loyalty`.`remove_all_vendor_outlets` ()
BEGIN
truncate vendor_outlet;
END$$

DELIMITER ;
