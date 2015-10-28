DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_customer` $$
CREATE PROCEDURE `loyalty`.`remove_customer` (in v_code int)
BEGIN
delete from customer where code=v_code;
END $$

DELIMITER ;
