DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_by_code` $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_customer_by_code`(in v_code int)
BEGIN
select * from customer_view where code=v_code;
END $$

DELIMITER ;
