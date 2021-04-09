create table persons (
   id serial primary key not null,
   login varchar(2000),
   password varchar(2000)
);
GO
insert into persons (login, password) values ('first', '123');
GO
insert into persons (login, password) values ('second', '123');
GO
insert into persons (login, password) values ('third', '123');