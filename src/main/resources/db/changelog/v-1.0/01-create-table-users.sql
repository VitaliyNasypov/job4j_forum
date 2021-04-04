create table users(
    id serial primary key,
    username varchar(255),
    password varchar(255),
    enabled boolean,
    authority_id integer references authorities(id)
);
GO
INSERT INTO USERS (username, password, authority_id, enabled)
VALUES ('Developer', '$2a$10$zeftZfZNHmPxDS.O9DI0fO5HKd4Vq.Okrib7O.cOjRUn3S/Z2nYMq', 1, true);