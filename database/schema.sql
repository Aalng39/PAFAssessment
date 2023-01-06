DROP DATABASE IF EXISTS eshop;

CREATE DATABASE eshop;

USE eshop;

CREATE TABLE customers(
    name CHAR(32) not null,
    address VARCHAR(128) not null,
    email VARCHAR(128) not null, 

    PRIMARY KEY(name)
);

INSERT INTO customers 
VALUES("fred", "201 Cobblestone Lane", "fredflintstone@bedrock.com");

INSERT INTO customers 
VALUES("sherlock", "221B Baker Street, London", "sherlock@consultingdetective.org");

INSERT INTO customers 
VALUES("spongebob", "124 Conch Street, Bikini Bottom", "spongebob@yahoo.com");

INSERT INTO customers 
VALUES("jessica", "698 Candlewood Land, Cabot Cove", "fletcher@gmail.com");

INSERT INTO customers 
VALUES("dursley", "4 Privet Drive, Little Whinging, Surrey", "dursley@gmail.com");


CREATE TABLE orders(
    orderId VARCHAR(8) not null,
    name CHAR(32) not null,
    address VARCHAR(128) not null,
    email VARCHAR(128) not null, 
    orderDate DATE,

    PRIMARY KEY(orderId)
);

CREATE TABLE lineItems(
    orderId VARCHAR(8) not null,
    item VARCHAR(128) not null,
    quantity INT not null,

    PRIMARY KEY(orderId, item, quantity)
);

