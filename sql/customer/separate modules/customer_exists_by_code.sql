DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`customer_exists_by_code` $$
CREATE PROCEDURE `loyalty`.`customer_exists_by_code` (in v_code int)
BEGIN
select * from customer where code=v_code;
END $$

DELIMITER ;