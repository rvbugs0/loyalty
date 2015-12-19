DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_city_count_by_name`$$
CREATE PROCEDURE `loyalty`.`get_city_count_by_name` (in v_name char(30),out v_count int)
BEGIN
DECLARE city_count int;
select count(*) into city_count from city where name= v_name;
set v_count=city_count; 
END$$

DELIMITER ;
