DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_exists_by_code`$$
CREATE PROCEDURE `loyalty`.`vendor_exists_by_code` (in v_code int)
BEGIN
select code from vendor_view where code = v_code;
END$$

DELIMITER ;
