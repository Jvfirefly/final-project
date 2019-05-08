create table user(
	user_id int not null auto_increment,
    name varchar(30) default null,
    surname varchar(30) default null,
    username varchar(30) default null,
    password varchar(255) default null,
    city varchar(30) default null,
    address varchar(255) default null,
    phone varchar(10) default null,
    primary key(user_id),
    unique key unique_username (username)
);

select * from user;