CREATE DATABASE estoque;

\connect estoque;

BEGIN;

-- drop tables
DROP TABLE IF EXISTS produto CASCADE;

CREATE TABLE produto (
    id serial primary key,
    nome varchar(20) not null,
    quantidade integer not null,
    valor decimal(7,2) not null
);

INSERT INTO produto (nome, quantidade, valor) VALUES ('caneta', 20, 2.75);
INSERT INTO produto (nome, quantidade, valor) VALUES ('lapis', 50, 1.75);
INSERT INTO produto (nome, quantidade, valor) VALUES ('lapiseira', 50, 7.50);
INSERT INTO produto (nome, quantidade, valor) VALUES ('borracha', 100, 4.00);


COMMIT;
