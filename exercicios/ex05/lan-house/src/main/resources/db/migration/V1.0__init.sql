CREATE TABLE servidor (
    id serial primary key,
    nome varchar(20) not null,
    ip varchar(15) not null,
    grupo varchar(20) not null,
    Unique(ip)
);
