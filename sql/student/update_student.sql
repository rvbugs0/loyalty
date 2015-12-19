DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`update_student` $$
CREATE PROCEDURE `loyalty`.`update_student` (in v_customer_code int,in v_stream char(50),in v_course_details char(100))
BEGIN
update student set stream=v_stream,course_details=v_course_details where customer_code=v_customer_code;
END $$

DELIMITER ;