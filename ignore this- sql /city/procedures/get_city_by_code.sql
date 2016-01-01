DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_city_by_code`$$
CREATE PROCEDURE `loyalty`.`get_city_by_code` (in v_code int)
BEGIN
select * from city where code = v_code ;
END$$

DELIMITER ;
