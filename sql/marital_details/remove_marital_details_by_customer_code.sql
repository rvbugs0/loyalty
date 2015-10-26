DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_marital_details_by_customer_code` $$
CREATE PROCEDURE `loyalty`.`remove_marital_details_by_customer_code` (in v_customer_code int)
BEGIN
delete from marital_details where customer_code=v_customer_code;
END $$

DELIMITER ;