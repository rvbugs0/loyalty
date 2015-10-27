DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_city`$$
CREATE PROCEDURE `loyalty`.`remove_city` (in v_code int)
BEGIN
delete from city where code = v_code;
END$$


DELIMITER ;
