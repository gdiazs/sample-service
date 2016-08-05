create table employees(
    id integer not null,
    name varchar(100) not null,
    position varchar(100) not null,
    created_at date not null,
    updated_at date not null,
    primary key(id)
);


insert into employees (id,name,position,created_at,updated_at )values (1, 'Guillermo', 'Developer', '2016-06-01', '2016-06-01');

insert into employees (id,name,position,created_at,updated_at )values (300, 'Pedro', 'Developer', '2016-06-01', '2016-06-01');
