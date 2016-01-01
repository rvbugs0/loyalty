DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`add_student` $$
CREATE PROCEDURE `loyalty`.`add_student` (in v_customer_code int,in v_stream char(50),in v_course_details char(100))
BEGIN
insert into student (customer_code,stream,course_details) values (v_customer_code,v_stream,v_course_details);
END $$

DELIMITER ;