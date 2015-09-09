# Seifer (Cuauhtemoc Herrera Muñoz) 09/03/2015
#
# -- MICROBLOG DATABASE STRUCTURE --
#

#SEQUENCES
CREATE SEQUENCE comment_id START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE authortag_index_id START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE hashtag_index_id START WITH 1 INCREMENT BY 1;

#TABLES
CREATE TABLE comment ( id INT NOT NULL PRIMARY KEY DEFAULT nextval( 'comment_id' ), "date" TIMESTAMP NOT NULL, author VARCHAR( 150 ) NOT NULL, content VARCHAR( 150 ) NOT NULL );
CREATE TABLE hashtag_index ( id INT NOT NULL PRIMARY KEY DEFAULT nextval( 'hashtag_index_id' ), hashtag VARCHAR( 150 ) NOT NULL, comment INT NOT NULL );
CREATE TABLE authortag_index ( id INT NOT NULL PRIMARY KEY DEFAULT nextval( 'authortag_index_id' ), author VARCHAR( 150 ) NOT NULL, comment INT NOT NULL );

#RELATIONSHIPS
ALTER TABLE hashtag_index ADD FOREIGN KEY( 'comment' ) REFERENCES comment( id );
ALTER TABLE authortag_index ADD FOREIGN KEY( 'comment' ) REFERENCES comment( id );
