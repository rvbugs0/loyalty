DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`student_exists_by_customer_code` $$
CREATE PROCEDURE `loyalty`.`student_exists_by_customer_code` (in v_customer_code int)
BEGIN
select * from student where customer_code=v_customer_code;
END $$

DELIMITER ;