DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`customer_exists_by_username` $$
CREATE PROCEDURE `loyalty`.`customer_exists_by_username` (in v_username char(20))
BEGIN
select * from customer where username=v_username;
END $$

DELIMITER ;