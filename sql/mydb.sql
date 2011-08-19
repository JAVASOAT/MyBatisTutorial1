CREATE DATABASE mydb;

USE mydb;

CREATE TABLE author
(
   id_author     int AUTO_INCREMENT PRIMARY KEY,
   name_author   varchar(50)
);

CREATE TABLE category
(
   id_category     int AUTO_INCREMENT PRIMARY KEY,
   name_category   varchar(50)
);

CREATE TABLE book
(
   id_book             int AUTO_INCREMENT PRIMARY KEY,
   isbn                varchar(10),
   title               varchar(50),
   short_description   varchar(100),
   long_description    varchar(1000),
   image_name          varchar(100),
   id_author           int    REFERENCES author(id_author)
);


CREATE TABLE category_book
(
   id_category   int    REFERENCES category(id_category),
   id_book       int    REFERENCES book(id_book),
   PRIMARY KEY(id_category, id_book)
);

CREATE TABLE user
(
   id_user     int AUTO_INCREMENT PRIMARY KEY,
   name        varchar(100),
   firstname   varchar(100),
   email       varchar(200),
   password    varchar(100)
);

DROP PROCEDURE IF EXISTS helloProcedure;
CREATE PROCEDURE helloProcedure(IN  name varchar(100), OUT pout varchar(200))
BEGIN
      SET pout = concat('MySQL procedure says hello to ', name);
   END;

DROP FUNCTION IF EXISTS helloFunction;
CREATE FUNCTION helloFunction(name varchar(100)) RETURNS varchar(200) CHARSET latin1
BEGIN
      RETURN concat('MySQL function says hello to ', name);
   END;
   