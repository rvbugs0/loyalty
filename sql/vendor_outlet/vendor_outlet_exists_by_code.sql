DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_outlet_exists_by_code`$$
CREATE PROCEDURE `loyalty`.`vendor_outlet_exists_by_code` (in v_code int)
BEGIN
select code from vendor_outlet_view where code=v_code;
END$$

DELIMITER ;
