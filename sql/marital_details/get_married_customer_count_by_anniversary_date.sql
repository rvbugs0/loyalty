DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_married_customer_count_by_anniversary_date` $$
CREATE PROCEDURE `loyalty`.`get_married_customer_count_by_anniversary_date` (in v_anniversary_date date)
BEGIN
select * from marital_details where anniversary_date=v_anniversary_date;
END $$

DELIMITER ;