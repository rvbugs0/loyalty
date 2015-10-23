
drop table IF EXISTS marital_details;
drop table IF EXISTS student;
drop table IF EXISTS city;
drop table IF EXISTS operator;
drop table IF EXISTS vendor;
drop table IF EXISTS vendor_outlet;
drop table IF EXISTS customer;



Create table customer (
	code Int NOT NULL AUTO_INCREMENT,
	name Char(50) NOT NULL,
	username Char(20) NOT NULL,
	password Char(100) NOT NULL,
	password_key Char(100) NOT NULL,
	permanent_address Varchar(500),
	current_address Varchar(500) NOT NULL,
	city_code Int NOT NULL,
	date_of_birth Date NOT NULL,
	gender Char(1) NOT NULL,
	occupation Char(30) NOT NULL,
	is_married Bool NOT NULL,
	is_student Bool NOT NULL,
	contact_number Char(20) NOT NULL,
	mail_id Char(100) NOT NULL,
	UNIQUE (code),
	UNIQUE (username),
	UNIQUE (contact_number),
	UNIQUE (mail_id),
 Primary Key (code)) ENGINE = InnoDB;

Create table vendor_outlet (
	code Int NOT NULL AUTO_INCREMENT,
	vendor_code Int NOT NULL,
	address Varchar(500) NOT NULL,
	latitude Char(30) NOT NULL,
	longitude Char(30) NOT NULL,
	city_code Int NOT NULL,
	contact_number Char(100) NOT NULL,
	UNIQUE (code),
	UNIQUE (latitude),
	UNIQUE (longitude),
	UNIQUE (contact_number),
 Primary Key (code)) ENGINE = InnoDB;

Create table vendor (
	code Int NOT NULL AUTO_INCREMENT,
	name_of_firm Char(50) NOT NULL,
	username Char(50) NOT NULL COMMENT '**',
	password Char(100) NOT NULL,
	password_key Char(100) NOT NULL,
	address Varchar(500) NOT NULL,
	city_code Int NOT NULL,
	contact_number Char(100) NOT NULL,
	mail_id Char(100) NOT NULL,
	UNIQUE (code),
	UNIQUE (name_of_firm),
	UNIQUE (username),
	UNIQUE (contact_number),
	UNIQUE (mail_id),
 Primary Key (code)) ENGINE = InnoDB;

Create table operator (
	code Int NOT NULL AUTO_INCREMENT,
	name Char(30) NOT NULL,
	username Char(30) NOT NULL,
	password Char(100) NOT NULL,
	password_key Char(100) NOT NULL,
	vendor_outlet_code Int NOT NULL,
	UNIQUE (code),
	UNIQUE (username),
	UNIQUE (password),
 Primary Key (code)) ENGINE = InnoDB;

Create table city (
	code Int NOT NULL AUTO_INCREMENT,
	name Char(30) NOT NULL,
	state Char(30) NOT NULL,
	country Char(30) NOT NULL,
	UNIQUE (code),
 Primary Key (code)) ENGINE = InnoDB;

Create table student (
	customer_code Int NOT NULL,
	stream Char(50) NOT NULL,
	course_details Char(100) NOT NULL,
	UNIQUE (customer_code),
 Primary Key (customer_code)) ENGINE = InnoDB;

Create table marital_status (
	customer_code Int NOT NULL,
	spouse_name Char(50),
	spouse_date_of_birth Date,
	anniversary_date Date,
	spouse_occupation Char(50),
	number_of_girl_child Int,
	number_of_boy_child Int,
	UNIQUE (customer_code),
 Primary Key (customer_code)) ENGINE = InnoDB;


Alter table student add Constraint Relationship8 Foreign Key (customer_code) references customer (code) on delete  restrict on update  restrict;
Alter table marital_status add Constraint Relationship9 Foreign Key (customer_code) references customer (code) on delete  restrict on update  restrict;
Alter table operator add Constraint Relationship5 Foreign Key (vendor_outlet_code) references vendor_outlet (code) on delete  restrict on update  restrict;
Alter table vendor_outlet add Constraint Relationship4 Foreign Key (vendor_code) references vendor (code) on delete  restrict on update  restrict;
Alter table customer add Constraint Relationship1 Foreign Key (city_code) references city (code) on delete  restrict on update  restrict;
Alter table vendor_outlet add Constraint Relationship2 Foreign Key (city_code) references city (code) on delete  restrict on update  restrict;
Alter table vendor add Constraint Relationship3 Foreign Key (city_code) references city (code) on delete  restrict on update  restrict;

