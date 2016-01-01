DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_student_by_customer_code` $$
CREATE PROCEDURE `loyalty`.`remove_student_by_customer_code` (in v_customer_code int)
BEGIN
delete from student where customer_code=v_customer_code;
END $$

DELIMITER ;