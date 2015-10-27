DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_cities_by_name`$$
CREATE PROCEDURE `loyalty`.`get_cities_by_name` (in v_name char(30))
BEGIN
select * from city where name=v_name;
END$$

DELIMITER ;
