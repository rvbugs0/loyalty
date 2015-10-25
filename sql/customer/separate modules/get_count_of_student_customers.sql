DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_count_of_student_customers` $$
CREATE PROCEDURE `loyalty`.`get_count_of_student_customers` (out v_student_customers_count int)
BEGIN
declare customer_count Int;
select count(*) into customer_count from customer where is_student=true;
set v_student_customers_count=customer_count;

END $$

DELIMITER ;