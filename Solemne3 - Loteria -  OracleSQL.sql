-- Generado por Oracle SQL Developer Data Modeler 4.0.1.836
--   en:        2017-06-14 15:39:45 CLT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE TABLE drafts
  (
    id       INTEGER NOT NULL ,
    "date"   DATE NOT NULL ,
    number_1 INTEGER NOT NULL ,
    number_2 INTEGER NOT NULL ,
    number_3 INTEGER NOT NULL ,
    number_4 INTEGER NOT NULL ,
    number_5 INTEGER NOT NULL ,
    number_6 INTEGER NOT NULL
  ) ;
ALTER TABLE drafts ADD CONSTRAINT drafts_PK PRIMARY KEY ( id ) ;

CREATE TABLE pages
  (
    id     INTEGER NOT NULL ,
    name   VARCHAR2 (100) NOT NULL ,
    url    VARCHAR2 (100) NOT NULL ,
    icon   VARCHAR2 (20) NOT NULL ,
    parent INTEGER NOT NULL
  ) ;
ALTER TABLE pages ADD CONSTRAINT pages_PK PRIMARY KEY ( id ) ;

CREATE TABLE payment
  (
    id              INTEGER NOT NULL ,
    no_tickets      INTEGER NOT NULL ,
    amount          INTEGER ,
    transactions_id INTEGER NOT NULL
  ) ;
ALTER TABLE payment ADD CONSTRAINT payment_PK PRIMARY KEY ( id ) ;

CREATE TABLE profiles
  ( id INTEGER NOT NULL , name VARCHAR2 (25) NOT NULL
  ) ;
ALTER TABLE profiles ADD CONSTRAINT profiles_PK PRIMARY KEY ( id ) ;

CREATE TABLE profiles_pages
  (
    id          INTEGER NOT NULL ,
    profiles_id INTEGER NOT NULL ,
    pages_id    INTEGER NOT NULL
  ) ;
ALTER TABLE profiles_pages ADD CONSTRAINT profiles_pages_PK PRIMARY KEY ( id ) ;

CREATE TABLE recharges
  (
    id              INTEGER NOT NULL ,
    amount          INTEGER NOT NULL ,
    users_id        INTEGER NOT NULL ,
    transactions_id INTEGER NOT NULL
  ) ;
ALTER TABLE recharges ADD CONSTRAINT recharges_PK PRIMARY KEY ( id ) ;

CREATE TABLE tickets
  (
    id         INTEGER NOT NULL ,
    number_1   INTEGER NOT NULL ,
    number_2   INTEGER NOT NULL ,
    number_3   INTEGER NOT NULL ,
    number_4   INTEGER NOT NULL ,
    number_5   INTEGER NOT NULL ,
    number_6   INTEGER NOT NULL ,
    payment_id INTEGER NOT NULL ,
    drafts_id  INTEGER NOT NULL ,
    users_id   INTEGER NOT NULL
  ) ;
ALTER TABLE tickets ADD CONSTRAINT tickets_PK PRIMARY KEY ( id ) ;

CREATE TABLE transactions
  (
    id INTEGER NOT NULL ,
    payment_method UNKNOWN
    --  ERROR: Datatype UNKNOWN is not allowed
    ,
    amount INTEGER NOT NULL
  ) ;
ALTER TABLE transactions ADD CONSTRAINT transactions_PK PRIMARY KEY ( id ) ;

CREATE TABLE users
  (
    id          INTEGER NOT NULL ,
    username    VARCHAR2 (50) NOT NULL ,
    password    VARCHAR2 (50) NOT NULL ,
    first_name  VARCHAR2 (60) NOT NULL ,
    last_name   VARCHAR2 (60) NOT NULL ,
    wallet      INTEGER NOT NULL ,
    profiles_id INTEGER NOT NULL
  ) ;
ALTER TABLE users ADD CONSTRAINT users_PK PRIMARY KEY ( id ) ;

CREATE TABLE winners
  (
    id        INTEGER NOT NULL ,
    prize     INTEGER NOT NULL ,
    drafts_id INTEGER NOT NULL ,
    users_id  INTEGER NOT NULL
  ) ;
ALTER TABLE winners ADD CONSTRAINT winners_PK PRIMARY KEY ( id ) ;

ALTER TABLE payment ADD CONSTRAINT payment_transactions_FK FOREIGN KEY ( transactions_id ) REFERENCES transactions ( id ) ;

ALTER TABLE profiles_pages ADD CONSTRAINT profiles_pages_pages_FK FOREIGN KEY ( pages_id ) REFERENCES pages ( id ) ;

ALTER TABLE profiles_pages ADD CONSTRAINT profiles_pages_profiles_FK FOREIGN KEY ( profiles_id ) REFERENCES profiles ( id ) ;

ALTER TABLE recharges ADD CONSTRAINT recharges_transactions_FK FOREIGN KEY ( transactions_id ) REFERENCES transactions ( id ) ;

ALTER TABLE recharges ADD CONSTRAINT recharges_users_FK FOREIGN KEY ( users_id ) REFERENCES users ( id ) ;

ALTER TABLE tickets ADD CONSTRAINT tickets_drafts_FK FOREIGN KEY ( drafts_id ) REFERENCES drafts ( id ) ;

ALTER TABLE tickets ADD CONSTRAINT tickets_payment_FK FOREIGN KEY ( payment_id ) REFERENCES payment ( id ) ;

ALTER TABLE tickets ADD CONSTRAINT tickets_users_FK FOREIGN KEY ( users_id ) REFERENCES users ( id ) ;

ALTER TABLE users ADD CONSTRAINT users_profiles_FK FOREIGN KEY ( profiles_id ) REFERENCES profiles ( id ) ;

ALTER TABLE winners ADD CONSTRAINT winners_drafts_FK FOREIGN KEY ( drafts_id ) REFERENCES drafts ( id ) ;

ALTER TABLE winners ADD CONSTRAINT winners_users_FK FOREIGN KEY ( users_id ) REFERENCES users ( id ) ;


-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            10
-- CREATE INDEX                             0
-- ALTER TABLE                             21
-- CREATE VIEW                              0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ERRORS                                   1
-- WARNINGS                                 0
