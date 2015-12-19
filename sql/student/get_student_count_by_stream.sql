DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_student_count_by_stream` $$
CREATE PROCEDURE `loyalty`.`get_student_count_by_stream` (in v_stream char(50),out v_count int)
BEGIN
declare student_count int;
select count(*) into student_count from student where stream=v_stream;
set v_count =student_count;

END $$

DELIMITER ;