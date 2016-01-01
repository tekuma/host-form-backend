# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table test_persons (
  id                        integer auto_increment not null,
  user_name                 varchar(255) not null,
  biography                 varchar(255),
  time_stamp                datetime(6),
  constraint pk_test_persons primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table test_persons;

SET FOREIGN_KEY_CHECKS=1;

