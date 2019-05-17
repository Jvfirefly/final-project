create table trip(
	trip_id int not null auto_increment,
	user_id int not null,
    name varchar(30) default null,
    date_from date default null,
    date_to date default null,
    impressions varchar(255) default null,
    photo1 varchar(255) default null,
	title1 varchar(30) default null,
	description1 varchar(255) default null,
    photo2 varchar(255) default null,
	title2 varchar(30) default null,
	description2 varchar(255) default null,
    location varchar(255) default null,
    primary key (trip_id),
    foreign key (user_id) references user(user_id),
    unique key unique_trip (user_id, name)
);

select * from trip;
alter table trip add deleted bool;