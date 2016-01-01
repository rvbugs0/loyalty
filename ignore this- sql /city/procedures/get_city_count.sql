DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_city_count`$$
CREATE PROCEDURE `loyalty`.`get_city_count` (out v_city_count int)
BEGIN
DECLARE city_count Int;
select count(*) into city_count from city; 
set v_city_count = city_count;
END$$

DELIMITER ;
