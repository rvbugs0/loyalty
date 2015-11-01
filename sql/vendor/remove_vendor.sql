DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_vendor`$$
CREATE PROCEDURE `loyalty`.`remove_vendor` (in v_code int)
BEGIN
delete from vendor where code = v_code;
END$$

DELIMITER ;
