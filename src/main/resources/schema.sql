--SELECT 'CREATE DATABASE myReactiveDatabase' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'myReactiveDatabase');


--connect myReactiveDatabase;
--USE myReactiveDatabase;

--DROP DATABASE myReactiveDatabase;

--CREATE DATABASE myReactiveDatabase;
--CREATE SCHEMA vehicles;

CREATE SCHEMA IF NOT EXISTS vehicles;

DROP TABLE IF EXISTS vehicles.categories;

CREATE TABLE vehicles.categories (
    id             SERIAL PRIMARY KEY,
    name           VARCHAR(100) NOT NULL
);
