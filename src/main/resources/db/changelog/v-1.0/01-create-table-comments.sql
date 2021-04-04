create table comments(
    id serial primary key,
    text varchar(1000) not null,
    created timestamp not null,
    post_id integer references posts(id),
    user_id integer references users(id)
);