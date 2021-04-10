CREATE TABLE operation (
       id SERIAL PRIMARY KEY,
       supplier_id BIGINT NOT NULL,
       account VARCHAR(12) NOT NULL,
       amount DOUBLE PRECISION,
       command VARCHAR(10) NOT NULL,
       date TIMESTAMP NOT NULL
);