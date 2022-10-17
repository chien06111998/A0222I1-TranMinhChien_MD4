create database blog;
use blog;
create table blog(
	id int primary key auto_increment,
    `name` varchar(50),
    discription varchar(255)
);
insert into blog(`name`, discription)
value ("Hoa", "Hoa hong"),
("keo", "Keo hong"),
("Nhua", "Nhua hong");