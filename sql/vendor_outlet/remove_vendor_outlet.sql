DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_vendor_outlet`$$
CREATE PROCEDURE `loyalty`.`remove_vendor_outlet` (in v_code int)
BEGIN
delete from vendor_outlet where code = v_code ;
END$$

DELIMITER ;
