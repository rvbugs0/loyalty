DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_student_customers` $$
CREATE PROCEDURE `loyalty`.`get_all_student_customers` ()
BEGIN
select * from customer_view where is_student=true;
END $$

DELIMITER ;