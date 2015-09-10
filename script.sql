/*
# Seifer (Cuauhtemoc Herrera Muñoz) 09/03/2015
#
# -- MICROBLOG DATABASE STRUCTURE --
#
*/

-- #SEQUENCES
CREATE SEQUENCE microblog_comment_id START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE microblog_hashtag_id START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE microblog_authortag_id START WITH 1 INCREMENT BY 1;

-- #TABLES
CREATE TABLE microblog_comment ( id INT NOT NULL PRIMARY KEY DEFAULT nextval( 'microblog_comment_id' ), "date" TIMESTAMP NOT NULL, author VARCHAR( 150 ) NOT NULL, content VARCHAR( 150 ) NOT NULL );
CREATE TABLE microblog_hashtag( id INT NOT NULL PRIMARY KEY DEFAULT nextval( 'microblog_hashtag_id' ), hashtag VARCHAR( 150 ) NOT NULL );
CREATE TABLE microblog_authortag( id INT NOT NULL PRIMARY KEY DEFAULT nextval( 'microblog_authortag_id' ), authortag VARCHAR( 150 ) NOT NULL );
CREATE TABLE hashtag_index ( comment INT NOT NULL, hashtag INT NOT NULL );
CREATE TABLE authortag_index ( comment INT NOT NULL, authortag INT NOT NULL );

-- #RELATIONSHIPS
ALTER TABLE hashtag_index ADD FOREIGN KEY( comment ) REFERENCES microblog_comment( id );
ALTER TABLE hashtag_index ADD FOREIGN KEY( hashtag ) REFERENCES microblog_hashtag( id );
ALTER TABLE authortag_index ADD FOREIGN KEY( comment ) REFERENCES microblog_comment( id );
ALTER TABLE authortag_index ADD FOREIGN KEY( authortag ) REFERENCES microblog_authortag( id )

