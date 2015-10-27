﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_married_customer_count_by_spouse_occupation` $$
CREATE PROCEDURE `loyalty`.`get_married_customer_count_by_spouse_occupation` (in v_spouse_occupation char(50),out v_customer_count int)
BEGIN
DECLARE c_count int;
select count(*) into c_count from marital_details where spouse_occupation = v_spouse_occupation;
set v_customer_count = c_count ;
END $$

DELIMITER ;
