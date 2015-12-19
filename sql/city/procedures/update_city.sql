DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`update_city`$$
CREATE PROCEDURE `loyalty`.`update_city` (in v_code int,in v_name char(30),in v_state char(30),in v_country char(30))
BEGIN
UPDATE city set name = v_name , state = v_state , country = v_country where code = v_code;
END$$

DELIMITER ;
