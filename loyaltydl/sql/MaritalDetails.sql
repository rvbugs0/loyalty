DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_married_customers_by_spouse_occupation` $$
CREATE PROCEDURE `loyalty`.`get_all_married_customers_by_spouse_occupation` (in v_spouse_occupation char(50))
BEGIN
select * from marital_details_view where spouse_occupation=v_spouse_occupation;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_all_marital_details` $$
CREATE PROCEDURE `loyalty`.`remove_all_marital_details` ()
BEGIN
truncate marital_details;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_married_customers_by_spouse_date_of_birth` $$
CREATE PROCEDURE `loyalty`.`get_all_married_customers_by_spouse_date_of_birth` (in v_spouse_date_of_birth date)
BEGIN
select * from marital_details_view where spouse_date_of_birth=v_spouse_date_of_birth;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_marital_details_by_customer_code` $$
CREATE PROCEDURE `loyalty`.`remove_marital_details_by_customer_code` (in v_customer_code int)
BEGIN
delete from marital_details where customer_code=v_customer_code;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`add_marital_details` $$
CREATE PROCEDURE `loyalty`.`add_marital_details` (in v_customer_code int,in v_spouse_name char(50),in v_spouse_date_of_birth date,in v_anniversary_date date,in v_spouse_occupation char(50),in v_number_of_girl_child int,in v_number_of_boy_child int)
BEGIN
insert into marital_details (customer_code,spouse_name,spouse_date_of_birth,anniversary_date,spouse_occupation,number_of_girl_child,number_of_boy_child) values(v_customer_code,v_spouse_name,v_spouse_date_of_birth,v_anniversary_date,v_spouse_occupation,v_number_of_girl_child,v_number_of_boy_child);
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_married_customers_by_anniversary_date` $$
CREATE PROCEDURE `loyalty`.`get_all_married_customers_by_anniversary_date` (in v_anniversary_date date)
BEGIN
select * from marital_details_view where anniversary_date=v_anniversary_date;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_married_customer_count_by_anniversary_date` $$
CREATE PROCEDURE `loyalty`.`get_married_customer_count_by_anniversary_date` (in v_anniversary_date date)
BEGIN
select * from marital_details where anniversary_date=v_anniversary_date;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_married_customer_count_by_spouse_date_of_birth` $$
CREATE PROCEDURE `loyalty`.`get_married_customer_count_by_spouse_date_of_birth` (in v_spouse_date_of_birth date)
BEGIN
select * from marital_details where spouse_date_of_birth=v_spouse_date_of_birth;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_marital_details` $$
CREATE PROCEDURE `loyalty`.`get_all_marital_details` ()
BEGIN
select * from marital_details_view;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_married_customer_count_by_spouse_occupation` $$
CREATE PROCEDURE `loyalty`.`get_married_customer_count_by_spouse_occupation` (in v_spouse_occupation char(50))
BEGIN
select * from marital_details where spouse_occupation=v_spouse_occupation;
END $$

DELIMITER ;
﻿DROP VIEW IF EXISTS `loyalty`.`marital_details_view`;
CREATE OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `marital_details_view` AS select `marital_details`.`customer_code` AS `customer_code`,trim(`customer`.`name`) AS `name`,trim(`customer`.`username`) AS `username`,trim(`customer`.`password`) AS `password`,trim(`customer`.`password_key`) AS `password_key`,trim(`customer`.`permanent_address`) AS `permanent_address`,trim(`customer`.`current_address`) AS `current_address`,`customer`.`city_code` AS `city_code`,`customer`.`date_of_birth` AS `date_of_birth`,trim(`customer`.`gender`) AS `gender`,trim(`customer`.`occupation`) AS `occupation`,trim(`customer`.`contact_number`) AS `contact_number`,trim(`customer`.`mail_id`) AS `mail_id`,trim(`marital_details`.`spouse_name`) AS `spouse_name`,trim(`marital_details`.`spouse_date_of_birth`) AS `spouse_date_of_birth`,trim(`marital_details`.`anniversary_date`) AS `anniversary_date`,trim(`marital_details`.`spouse_occupation`) AS `spouse_occupation`,trim(`marital_details`.`number_of_girl_child`) AS `number_of_girl_child`,trim(`marital_details`.`number_of_boy_child`) AS `number_of_boy_child` from (`marital_details` join `customer` on((`marital_details`.`customer_code` = `customer`.`code`)));
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`update_marital_details` $$
CREATE PROCEDURE `loyalty`.`update_marital_details` (in v_customer_code int,in v_spouse_name char(50),in v_spouse_date_of_birth date,in v_anniversary_date date,in v_spouse_occupation char(50),in v_number_of_girl_child int,in v_number_of_boy_child int)
BEGIN
 update marital_details set spouse_name=v_spouse_name,spouse_date_of_birth=v_spouse_date_of_birth,anniversary_date=v_anniversary_date,spouse_occupation=v_spouse_occupation,number_of_girl_child=v_number_of_girl_child,number_of_boy_child=v_number_of_boy_child
 where customer_code=v_customer_code;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`marital_details_exists_by_customer_code` $$
CREATE PROCEDURE `loyalty`.`marital_details_exists_by_customer_code` (in v_customer_code int)
BEGIN
select * from marital_details where customer_code=v_customer_code;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_marital_details_count` $$
CREATE PROCEDURE `loyalty`.`get_marital_details_count` (out v_marital_details_count int)
BEGIN
declare marital_details_count Int;
select count(*) into marital_details_count from marital_details;
set v_marital_details_count=marital_details_count;

END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_marital_details_by_customer_code` $$
CREATE PROCEDURE `loyalty`.`get_marital_details_by_customer_code` (in v_customer_code int)
BEGIN
select * from marital_details_view where customer_code=v_customer_code;
END $$

DELIMITER ;
