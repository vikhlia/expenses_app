CREATE TABLE transactions
(
    id BIGSERIAL PRIMARY KEY ,
    amount NUMERIC NOT NULL ,
    date VARCHAR NOT NULL ,
    type VARCHAR NOT NULL,
    category INTEGER NOT NULL
    );

CREATE TABLE category
(
    id BIGSERIAL PRIMARY KEY ,
    name VARCHAR NOT NULL
);
