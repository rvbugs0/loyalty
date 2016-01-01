DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_marital_details_by_customer_code` $$
CREATE PROCEDURE `loyalty`.`get_marital_details_by_customer_code` (in v_customer_code int)
BEGIN
select * from marital_details_view where customer_code=v_customer_code;
END $$

DELIMITER ;