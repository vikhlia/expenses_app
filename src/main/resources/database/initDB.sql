-- create function f() returns void as $$
--     BEGIN
--         IF NOT EXISTS (SELECT * FROM transactions WHERE type = 'expense') THEN
--             CREATE TYPE type AS ENUM ( 'income', 'expense' );
--         END IF;
--     END;
-- $$ language plpgsql;


CREATE TABLE IF NOT EXISTS transactions
(
    id BIGSERIAL PRIMARY KEY ,
    amount NUMERIC NOT NULL ,
    date TIMESTAMP NOT NULL ,
    type VARCHAR NOT NULL,
    category INTEGER NOT NULL
    );

CREATE TABLE IF NOT EXISTS category
(
    id BIGSERIAL PRIMARY KEY ,
    name VARCHAR NOT NULL
);
