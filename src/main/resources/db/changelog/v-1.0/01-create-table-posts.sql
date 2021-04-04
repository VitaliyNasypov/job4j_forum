create table posts(
    id serial primary key,
    created timestamp,
    description varchar(255),
    name varchar(255),
    user_id integer references users(id)
);
GO
INSERT INTO POSTS (name, description, created, user_id)
VALUES ('First post', 'First Description', current_timestamp, 1);