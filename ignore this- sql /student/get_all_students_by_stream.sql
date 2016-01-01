DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_students_by_stream` $$
CREATE PROCEDURE `loyalty`.`get_all_students_by_stream` (in v_stream char(50))
BEGIN
select * from student_view where stream=v_stream;
END $$

DELIMITER ;