DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`customer_exists_by_mail_id` $$
CREATE PROCEDURE `loyalty`.`customer_exists_by_mail_id` (in v_mail_id char(100))
BEGIN
select * from customer where mail_id=v_mail_id;
END $$

DELIMITER ;