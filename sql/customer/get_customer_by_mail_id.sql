DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_customer_by_mail_id` $$
CREATE PROCEDURE `loyalty`.`get_customer_by_mail_id` (in v_mail_id char(100))
BEGIN
select * from customer_view where mail_id=v_mail_id;
END $$

DELIMITER ;