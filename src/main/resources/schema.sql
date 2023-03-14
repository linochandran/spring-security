-- Sequence and defined type
CREATE SEQUENCE IF NOT EXISTS user_details_tbl_user_id_seq;

-- Table Definition
CREATE TABLE "public"."user_details_tbl" (
 "user_id" int4 NOT NULL DEFAULT nextval('user_details_tbl_user_id_seq'::regclass),
 "first_name" varchar(255),
 "last_name" varchar(255),
 "email" varchar(255),
 "password" varchar(255),
 "user_role" varchar(255),
 PRIMARY KEY ("user_id")
);