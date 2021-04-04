create table authorities(
    id serial primary key,
    authority varchar(255)
);
GO
INSERT INTO AUTHORITIES (authority) VALUES ('ROLE_USER');
GO
INSERT INTO AUTHORITIES (authority) VALUES ('ROLE_ADMIN');