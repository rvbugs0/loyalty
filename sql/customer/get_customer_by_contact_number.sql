DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_by_contact_number` $$
CREATE PROCEDURE `loyalty`.`get_customer_by_contact_number` (in v_contact_number char(20))
BEGIN
select * from customer_view where contact_number=v_contact_number;
END $$

DELIMITER ;