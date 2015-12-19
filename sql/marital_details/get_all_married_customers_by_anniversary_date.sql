DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_married_customers_by_anniversary_date` $$
CREATE PROCEDURE `loyalty`.`get_all_married_customers_by_anniversary_date` (in v_anniversary_date date)
BEGIN
select * from marital_details_view where anniversary_date=v_anniversary_date;
END $$

DELIMITER ;