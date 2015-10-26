DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_marital_details` $$
CREATE PROCEDURE `loyalty`.`get_all_marital_details` ()
BEGIN
select * from marital_details_view;
END $$

DELIMITER ;