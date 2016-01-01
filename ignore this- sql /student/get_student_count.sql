DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_student_count` $$
CREATE PROCEDURE `loyalty`.`get_student_count` (out v_student_count int)
BEGIN
declare student_count Int;
select count(*) into student_count from student;
set v_student_count=student_count;

END $$

DELIMITER ;