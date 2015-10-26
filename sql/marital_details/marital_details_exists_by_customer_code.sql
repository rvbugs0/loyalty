DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`marital_details_exists_by_customer_code` $$
CREATE PROCEDURE `loyalty`.`marital_details_exists_by_customer_code` (in v_customer_code int)
BEGIN
select * from marital_details where customer_code=v_customer_code;
END $$

DELIMITER ;