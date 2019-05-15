create table users_roles(
	user_id int not null,
    role_id int not null,
    primary key (user_id, role_id),
    foreign key (user_id) references user(user_id),
    foreign key (role_id) references role(role_id)
);

select * from users_roles;

insert into users_roles values (4,1);