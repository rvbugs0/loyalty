DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`city_exists_by_code`$$
CREATE PROCEDURE `loyalty`.`city_exists_by_code` (in v_code int)
BEGIN
select * from city where code = v_code;
END$$

DELIMITER ;
