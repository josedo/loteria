--------------------------------------------------------
-- Archivo creado  - mi�rcoles-julio-05-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence DRAFTS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "LOTERIA"."DRAFTS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PAGES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "LOTERIA"."PAGES_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PAYMENT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "LOTERIA"."PAYMENT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PRIZE_POT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "LOTERIA"."PRIZE_POT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PROFILES_PAGES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "LOTERIA"."PROFILES_PAGES_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PROFILES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "LOTERIA"."PROFILES_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence RECHARGES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "LOTERIA"."RECHARGES_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TICKETS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "LOTERIA"."TICKETS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TRANSACTIONS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "LOTERIA"."TRANSACTIONS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence USERS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "LOTERIA"."USERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence WINNERS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "LOTERIA"."WINNERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table DRAFTS
--------------------------------------------------------

  CREATE TABLE "LOTERIA"."DRAFTS" 
   (	"ID" NUMBER(*,0), 
	"date" DATE, 
	"NUMBER_1" NUMBER(*,0), 
	"NUMBER_2" NUMBER(*,0), 
	"NUMBER_3" NUMBER(*,0), 
	"NUMBER_4" NUMBER(*,0), 
	"NUMBER_5" NUMBER(*,0), 
	"NUMBER_6" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PAGES
--------------------------------------------------------

  CREATE TABLE "LOTERIA"."PAGES" 
   (	"ID" NUMBER(*,0), 
	"NAME" VARCHAR2(100 BYTE), 
	"URL" VARCHAR2(100 BYTE), 
	"ICON" VARCHAR2(20 BYTE), 
	"PARENT" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PAYMENT
--------------------------------------------------------

  CREATE TABLE "LOTERIA"."PAYMENT" 
   (	"ID" NUMBER(*,0), 
	"NO_TICKETS" NUMBER(*,0), 
	"AMOUNT" NUMBER(*,0), 
	"TRANSACTIONS_ID" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PRIZE_POT
--------------------------------------------------------

  CREATE TABLE "LOTERIA"."PRIZE_POT" 
   (	"ID" NUMBER, 
	"POT" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PROFILES
--------------------------------------------------------

  CREATE TABLE "LOTERIA"."PROFILES" 
   (	"ID" NUMBER(*,0), 
	"NAME" VARCHAR2(25 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PROFILES_PAGES
--------------------------------------------------------

  CREATE TABLE "LOTERIA"."PROFILES_PAGES" 
   (	"ID" NUMBER(*,0), 
	"PROFILES_ID" NUMBER(*,0), 
	"PAGES_ID" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table RECHARGES
--------------------------------------------------------

  CREATE TABLE "LOTERIA"."RECHARGES" 
   (	"ID" NUMBER(*,0), 
	"AMOUNT" NUMBER(*,0), 
	"USERS_ID" NUMBER(*,0), 
	"TRANSACTIONS_ID" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TICKETS
--------------------------------------------------------

  CREATE TABLE "LOTERIA"."TICKETS" 
   (	"ID" NUMBER(*,0), 
	"NUMBER_1" NUMBER(*,0), 
	"NUMBER_2" NUMBER(*,0), 
	"NUMBER_3" NUMBER(*,0), 
	"NUMBER_4" NUMBER(*,0), 
	"NUMBER_5" NUMBER(*,0), 
	"NUMBER_6" NUMBER(*,0), 
	"PAYMENT_ID" NUMBER(*,0), 
	"DRAFTS_ID" NUMBER(*,0), 
	"USERS_ID" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TRANSACTIONS
--------------------------------------------------------

  CREATE TABLE "LOTERIA"."TRANSACTIONS" 
   (	"ID" NUMBER(*,0), 
	"PAYMENT_METHOD" VARCHAR2(50 BYTE), 
	"AMOUNT" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "LOTERIA"."USERS" 
   (	"ID" NUMBER(*,0), 
	"USERNAME" VARCHAR2(50 BYTE), 
	"PASSWORD" VARCHAR2(50 BYTE), 
	"FIRST_NAME" VARCHAR2(60 BYTE), 
	"LAST_NAME" VARCHAR2(60 BYTE), 
	"WALLET" NUMBER(*,0), 
	"PROFILES_ID" NUMBER(*,0), 
	"RUT" NUMBER(10,0), 
	"DV" VARCHAR2(1 BYTE), 
	"EMAIL" VARCHAR2(60 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table WINNERS
--------------------------------------------------------

  CREATE TABLE "LOTERIA"."WINNERS" 
   (	"ID" NUMBER(*,0), 
	"PRIZE" NUMBER(*,0), 
	"DRAFTS_ID" NUMBER(*,0), 
	"USERS_ID" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into LOTERIA.DRAFTS
SET DEFINE OFF;
REM INSERTING into LOTERIA.PAGES
SET DEFINE OFF;
REM INSERTING into LOTERIA.PAYMENT
SET DEFINE OFF;
REM INSERTING into LOTERIA.PRIZE_POT
SET DEFINE OFF;
Insert into LOTERIA.PRIZE_POT (ID,POT) values ('1','500000000');
REM INSERTING into LOTERIA.PROFILES
SET DEFINE OFF;
Insert into LOTERIA.PROFILES (ID,NAME) values ('1','Administrador');
Insert into LOTERIA.PROFILES (ID,NAME) values ('2','Usuario');
REM INSERTING into LOTERIA.PROFILES_PAGES
SET DEFINE OFF;
REM INSERTING into LOTERIA.RECHARGES
SET DEFINE OFF;
Insert into LOTERIA.RECHARGES (ID,AMOUNT,USERS_ID,TRANSACTIONS_ID) values ('1','500000','1','1');
REM INSERTING into LOTERIA.TICKETS
SET DEFINE OFF;
REM INSERTING into LOTERIA.TRANSACTIONS
SET DEFINE OFF;
Insert into LOTERIA.TRANSACTIONS (ID,PAYMENT_METHOD,AMOUNT) values ('1','Tarjeta de Credito','500000');
REM INSERTING into LOTERIA.USERS
SET DEFINE OFF;
Insert into LOTERIA.USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,WALLET,PROFILES_ID,RUT,DV,EMAIL) values ('1','admin','admin','Administrador','Supremo','500000','1','11111111','1','admin@loteria.net');
Insert into LOTERIA.USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,WALLET,PROFILES_ID,RUT,DV,EMAIL) values ('2','mleon','user1','Mario','Leon','0','2','16752163','0','mleon@gmail.com');
Insert into LOTERIA.USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,WALLET,PROFILES_ID,RUT,DV,EMAIL) values ('3','jbecerra','user2','Jose','Becerra','30000','2','22222222','2','jbecerra@gmail.com');
Insert into LOTERIA.USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,WALLET,PROFILES_ID,RUT,DV,EMAIL) values ('4','amontes','user3','Alexander','Montes','1200','2','33333333','3','amontes@loteria.net');
REM INSERTING into LOTERIA.WINNERS
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index DRAFTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LOTERIA"."DRAFTS_PK" ON "LOTERIA"."DRAFTS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PAGES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LOTERIA"."PAGES_PK" ON "LOTERIA"."PAGES" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PAYMENT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LOTERIA"."PAYMENT_PK" ON "LOTERIA"."PAYMENT" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PRIZE_POT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LOTERIA"."PRIZE_POT_PK" ON "LOTERIA"."PRIZE_POT" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PROFILES_PAGES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LOTERIA"."PROFILES_PAGES_PK" ON "LOTERIA"."PROFILES_PAGES" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PROFILES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LOTERIA"."PROFILES_PK" ON "LOTERIA"."PROFILES" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index RECHARGES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LOTERIA"."RECHARGES_PK" ON "LOTERIA"."RECHARGES" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index TICKETS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LOTERIA"."TICKETS_PK" ON "LOTERIA"."TICKETS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index TRANSACTIONS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LOTERIA"."TRANSACTIONS_PK" ON "LOTERIA"."TRANSACTIONS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LOTERIA"."USERS_PK" ON "LOTERIA"."USERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index WINNERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LOTERIA"."WINNERS_PK" ON "LOTERIA"."WINNERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table DRAFTS
--------------------------------------------------------

  ALTER TABLE "LOTERIA"."DRAFTS" ADD CONSTRAINT "DRAFTS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LOTERIA"."DRAFTS" MODIFY ("NUMBER_6" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."DRAFTS" MODIFY ("NUMBER_5" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."DRAFTS" MODIFY ("NUMBER_4" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."DRAFTS" MODIFY ("NUMBER_3" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."DRAFTS" MODIFY ("NUMBER_2" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."DRAFTS" MODIFY ("NUMBER_1" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."DRAFTS" MODIFY ("date" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."DRAFTS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PAGES
--------------------------------------------------------

  ALTER TABLE "LOTERIA"."PAGES" ADD CONSTRAINT "PAGES_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LOTERIA"."PAGES" MODIFY ("PARENT" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."PAGES" MODIFY ("ICON" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."PAGES" MODIFY ("URL" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."PAGES" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."PAGES" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PAYMENT
--------------------------------------------------------

  ALTER TABLE "LOTERIA"."PAYMENT" ADD CONSTRAINT "PAYMENT_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LOTERIA"."PAYMENT" MODIFY ("TRANSACTIONS_ID" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."PAYMENT" MODIFY ("NO_TICKETS" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."PAYMENT" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PRIZE_POT
--------------------------------------------------------

  ALTER TABLE "LOTERIA"."PRIZE_POT" ADD CONSTRAINT "PRIZE_POT_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LOTERIA"."PRIZE_POT" MODIFY ("POT" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."PRIZE_POT" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PROFILES
--------------------------------------------------------

  ALTER TABLE "LOTERIA"."PROFILES" ADD CONSTRAINT "PROFILES_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LOTERIA"."PROFILES" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."PROFILES" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PROFILES_PAGES
--------------------------------------------------------

  ALTER TABLE "LOTERIA"."PROFILES_PAGES" ADD CONSTRAINT "PROFILES_PAGES_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LOTERIA"."PROFILES_PAGES" MODIFY ("PAGES_ID" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."PROFILES_PAGES" MODIFY ("PROFILES_ID" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."PROFILES_PAGES" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RECHARGES
--------------------------------------------------------

  ALTER TABLE "LOTERIA"."RECHARGES" ADD CONSTRAINT "RECHARGES_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LOTERIA"."RECHARGES" MODIFY ("TRANSACTIONS_ID" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."RECHARGES" MODIFY ("USERS_ID" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."RECHARGES" MODIFY ("AMOUNT" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."RECHARGES" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TICKETS
--------------------------------------------------------

  ALTER TABLE "LOTERIA"."TICKETS" ADD CONSTRAINT "TICKETS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LOTERIA"."TICKETS" MODIFY ("USERS_ID" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."TICKETS" MODIFY ("DRAFTS_ID" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."TICKETS" MODIFY ("PAYMENT_ID" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."TICKETS" MODIFY ("NUMBER_6" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."TICKETS" MODIFY ("NUMBER_5" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."TICKETS" MODIFY ("NUMBER_4" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."TICKETS" MODIFY ("NUMBER_3" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."TICKETS" MODIFY ("NUMBER_2" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."TICKETS" MODIFY ("NUMBER_1" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."TICKETS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TRANSACTIONS
--------------------------------------------------------

  ALTER TABLE "LOTERIA"."TRANSACTIONS" ADD CONSTRAINT "TRANSACTIONS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LOTERIA"."TRANSACTIONS" MODIFY ("AMOUNT" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."TRANSACTIONS" MODIFY ("PAYMENT_METHOD" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."TRANSACTIONS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "LOTERIA"."USERS" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."USERS" MODIFY ("DV" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."USERS" MODIFY ("RUT" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."USERS" ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LOTERIA"."USERS" MODIFY ("PROFILES_ID" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."USERS" MODIFY ("WALLET" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."USERS" MODIFY ("LAST_NAME" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."USERS" MODIFY ("FIRST_NAME" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."USERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."USERS" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."USERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WINNERS
--------------------------------------------------------

  ALTER TABLE "LOTERIA"."WINNERS" ADD CONSTRAINT "WINNERS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LOTERIA"."WINNERS" MODIFY ("USERS_ID" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."WINNERS" MODIFY ("DRAFTS_ID" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."WINNERS" MODIFY ("PRIZE" NOT NULL ENABLE);
  ALTER TABLE "LOTERIA"."WINNERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table PAYMENT
--------------------------------------------------------

  ALTER TABLE "LOTERIA"."PAYMENT" ADD CONSTRAINT "PAYMENT_TRANSACTIONS_FK" FOREIGN KEY ("TRANSACTIONS_ID")
	  REFERENCES "LOTERIA"."TRANSACTIONS" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PROFILES_PAGES
--------------------------------------------------------

  ALTER TABLE "LOTERIA"."PROFILES_PAGES" ADD CONSTRAINT "PROFILES_PAGES_PAGES_FK" FOREIGN KEY ("PAGES_ID")
	  REFERENCES "LOTERIA"."PAGES" ("ID") ENABLE;
  ALTER TABLE "LOTERIA"."PROFILES_PAGES" ADD CONSTRAINT "PROFILES_PAGES_PROFILES_FK" FOREIGN KEY ("PROFILES_ID")
	  REFERENCES "LOTERIA"."PROFILES" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RECHARGES
--------------------------------------------------------

  ALTER TABLE "LOTERIA"."RECHARGES" ADD CONSTRAINT "RECHARGES_TRANSACTIONS_FK" FOREIGN KEY ("TRANSACTIONS_ID")
	  REFERENCES "LOTERIA"."TRANSACTIONS" ("ID") ENABLE;
  ALTER TABLE "LOTERIA"."RECHARGES" ADD CONSTRAINT "RECHARGES_USERS_FK" FOREIGN KEY ("USERS_ID")
	  REFERENCES "LOTERIA"."USERS" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TICKETS
--------------------------------------------------------

  ALTER TABLE "LOTERIA"."TICKETS" ADD CONSTRAINT "TICKETS_DRAFTS_FK" FOREIGN KEY ("DRAFTS_ID")
	  REFERENCES "LOTERIA"."DRAFTS" ("ID") ENABLE;
  ALTER TABLE "LOTERIA"."TICKETS" ADD CONSTRAINT "TICKETS_PAYMENT_FK" FOREIGN KEY ("PAYMENT_ID")
	  REFERENCES "LOTERIA"."PAYMENT" ("ID") ENABLE;
  ALTER TABLE "LOTERIA"."TICKETS" ADD CONSTRAINT "TICKETS_USERS_FK" FOREIGN KEY ("USERS_ID")
	  REFERENCES "LOTERIA"."USERS" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "LOTERIA"."USERS" ADD CONSTRAINT "USERS_PROFILES_FK" FOREIGN KEY ("PROFILES_ID")
	  REFERENCES "LOTERIA"."PROFILES" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table WINNERS
--------------------------------------------------------

  ALTER TABLE "LOTERIA"."WINNERS" ADD CONSTRAINT "WINNERS_DRAFTS_FK" FOREIGN KEY ("DRAFTS_ID")
	  REFERENCES "LOTERIA"."DRAFTS" ("ID") ENABLE;
  ALTER TABLE "LOTERIA"."WINNERS" ADD CONSTRAINT "WINNERS_USERS_FK" FOREIGN KEY ("USERS_ID")
	  REFERENCES "LOTERIA"."USERS" ("ID") ENABLE;
--------------------------------------------------------
--  DDL for Trigger DRAFTS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LOTERIA"."DRAFTS_TRG" 
BEFORE INSERT ON DRAFTS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT DRAFTS_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "LOTERIA"."DRAFTS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PAGES_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LOTERIA"."PAGES_TRG" 
BEFORE INSERT ON PAGES 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT PAGES_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "LOTERIA"."PAGES_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PAYMENT_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LOTERIA"."PAYMENT_TRG" 
BEFORE INSERT ON PAYMENT 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT PAYMENT_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "LOTERIA"."PAYMENT_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PRIZE_POT_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LOTERIA"."PRIZE_POT_TRG" 
BEFORE INSERT ON PRIZE_POT 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT PRIZE_POT_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "LOTERIA"."PRIZE_POT_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PROFILES_PAGES_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LOTERIA"."PROFILES_PAGES_TRG" 
BEFORE INSERT ON PROFILES_PAGES 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT PROFILES_PAGES_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "LOTERIA"."PROFILES_PAGES_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PROFILES_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LOTERIA"."PROFILES_TRG" 
BEFORE INSERT ON PROFILES 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT PROFILES_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "LOTERIA"."PROFILES_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger RECHARGES_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LOTERIA"."RECHARGES_TRG" 
BEFORE INSERT ON RECHARGES 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT RECHARGES_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "LOTERIA"."RECHARGES_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TICKETS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LOTERIA"."TICKETS_TRG" 
BEFORE INSERT ON TICKETS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT TICKETS_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "LOTERIA"."TICKETS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRANSACTIONS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LOTERIA"."TRANSACTIONS_TRG" 
BEFORE INSERT ON TRANSACTIONS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT TRANSACTIONS_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "LOTERIA"."TRANSACTIONS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger USERS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LOTERIA"."USERS_TRG" 
BEFORE INSERT ON USERS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT USERS_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "LOTERIA"."USERS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger WINNERS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LOTERIA"."WINNERS_TRG" 
BEFORE INSERT ON WINNERS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT WINNERS_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "LOTERIA"."WINNERS_TRG" ENABLE;
