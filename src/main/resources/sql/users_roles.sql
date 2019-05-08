create table users_roles(
	user_id int not null,
    role_id int not null,
    foreign key (user_id) references user(user_id),
    foreign key (role_id) references role(role_id)
);