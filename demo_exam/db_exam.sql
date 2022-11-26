create database test_exam;
use test_exam;
create table customer_type(
	id integer primary key auto_increment,
    `name` varchar(50)
);

create table customer(
	id_customer varchar(50) primary key,
    customer_name varchar(50),
    customer_type_id integer,
    birth_day date,
    gender boolean,
    id_card varchar(50),
    phone_number varchar(50),
    email varchar(50),
    address varchar(50),
	foreign key(customer_type_id) references customer_type(id)
);