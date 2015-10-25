DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`customer_exists_by_contact_number` $$
CREATE PROCEDURE `loyalty`.`customer_exists_by_contact_number` (in v_contact_number char(20))
BEGIN
select * from customer where contact_number=v_contact_number;
END $$

DELIMITER ;