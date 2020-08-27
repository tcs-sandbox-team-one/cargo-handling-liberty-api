CREATE SCHEMA `handlingmsdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
use handlingmsdb;

CREATE USER 'handlingmsdb'@'%' IDENTIFIED BY 'handlingmsdb';
GRANT ALL PRIVILEGES ON handlingmsdb.* TO 'handlingmsdb'@'%';

##Handling_activity DDL 
CREATE TABLE handling_activity ( 
  id int(11) NOT NULL AUTO_INCREMENT, 
  event_completion_time timestamp NULL DEFAULT NULL, 
  event_type varchar(225) DEFAULT NULL, 
  booking_id varchar(20) DEFAULT NULL, 
  voyage_number varchar(100) DEFAULT NULL, 
  location varchar(100) DEFAULT NULL, 
  PRIMARY KEY (id) ) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;