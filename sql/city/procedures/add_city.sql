DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`add_city`$$
CREATE PROCEDURE `loyalty`.`add_city` (in v_name char(30),in v_state char(30),in v_country char(30),out code int)
BEGIN
INSERT INTO city (name,state,country) values (v_name,v_state,v_country);
set code = last_insert_id();
END$$

DELIMITER ;
