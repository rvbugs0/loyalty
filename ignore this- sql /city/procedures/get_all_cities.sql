DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_cities`$$
CREATE PROCEDURE `loyalty`.`get_all_cities` ()
BEGIN
select * from city ;
END$$

DELIMITER ;
