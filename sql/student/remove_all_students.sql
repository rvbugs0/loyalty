DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_all_students` $$
CREATE PROCEDURE `loyalty`.`remove_all_students` ()
BEGIN
truncate student;
END $$

DELIMITER ;