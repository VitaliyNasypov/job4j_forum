create table employees (
   id serial primary key not null,
   first_name varchar(2000),
   surname varchar(2000),
   individual_tax_number integer,
   date_employment timestamp
);
GO
insert into employees (first_name, surname, individual_tax_number, date_employment)
values ('first name', 'first surname', 100, current_timestamp);
GO
insert into employees (first_name, surname, individual_tax_number, date_employment)
values ('second name', 'second surname', 200, current_timestamp);
GO
insert into employees (first_name, surname, individual_tax_number, date_employment)
values ('third name', 'third surname', 300, current_timestamp);