DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_by_username` $$
CREATE PROCEDURE `loyalty`.`get_customer_by_username` (in v_username char(20))
BEGIN
select * from customer_view where username=v_username;
END $$

DELIMITER ;