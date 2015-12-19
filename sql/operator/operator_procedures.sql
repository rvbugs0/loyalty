DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `add_operator`(in v_vendor_outlet_code integer,in v_name char(30),in v_username char(30),in v_password char (30),out v_code integer)
BEGIN
insert into operator (vendor_outlet_code,name,username,password) values (v_vendor_outlet_code,v_name,v_username,md5(password));
set v_code=last_inset_id();
END$$
DELIMITER ;



DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_all_operators`()
BEGIN
select * from operator ;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_all_operators_by_vendor_outlet_code`(in v_vendor_outlet_code integer)
BEGIN
select * from operator where vendor_outlet_code=v_vendor_outlet_code ;
END$$
DELIMITER ;



DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_by_code`(in v_code integer)
BEGIN
select * from operator where code=v_code;
END$$
DELIMITER ;





DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_by_name`(in v_name char(30))
BEGIN
select * from operator where name=v_name;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_by_username`(in v_username char(30))
BEGIN
select * from operator where username=v_username;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_count`()
BEGIN
select count(*) as cnt from operator;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_count_by_name`(in v_name char(30))
BEGIN
select count(*) as cnt from operator where  name=v_name;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_count_by_username`(in v_username char(30))
BEGIN
select count(*) as cnt from operator where username=v_username;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `get_operator_count_by_vendor_outlet_code`(in v_vendor_outlet_code integer)
BEGIN
select count(*) as cnt from operator where vendor_outlet_code=v_vendor_outlet_code;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `operator_exists_by_code`(in v_code integer)
BEGIN
select * from operator where code=v_code;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `operator_exists_by_username`(in v_username char(30))
BEGIN
select * from operator where username=v_username;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `remove_all_operators`()
BEGIN
delete from operator ;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `remove_operator`(in v_code integer)
BEGIN
delete from operator where code=v_code;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `remove_operator_by_username`(in v_username char(30))
BEGIN
delete from operator where username=v_username;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `remove_all_operators_by_vendor_outlet_code`(in vendor_outlet_code integer)
BEGIN
delete from operator where vendor_outlet_code=v_vendor_outlet_code;
END$$
DELIMITER ;




DELIMITER $$
CREATE DEFINER=`loyalty`@`%` PROCEDURE `update_operator`(in v_code integer,in v_vendor_outlet_code integer,in v_name char(30),in v_username char(30),in v_password char (30))
BEGIN
update operator set vendor_outlet_code=v_vendor_outlet_code,name=v_name,username =v_username,password=md5(password) where code=v_code;
END$$
DELIMITER ;













