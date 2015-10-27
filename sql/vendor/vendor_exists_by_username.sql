DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_exists_by_username`$$
CREATE PROCEDURE `loyalty`.`vendor_exists_by_username` (in v_username char(50))
BEGIN
select code from vendor_view where username = v_username;
END$$

DELIMITER ;
