DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_students` $$
CREATE PROCEDURE `loyalty`.`get_all_students` ()
BEGIN
select * from student_view;
END $$

DELIMITER ;


