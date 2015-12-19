DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_student_by_customer_code` $$
CREATE PROCEDURE `loyalty`.`get_student_by_customer_code` (in v_customer_code int)
BEGIN
select * from student_view where customer_code=v_customer_code;
END $$

DELIMITER ;