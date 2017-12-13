CREATE TABLE laptop (
  id int(20) primary key NOT NULL AUTO_INCREMENT,
  laptop_tag varchar(50)  NOT NULL UNIQUE,
  brand varchar(50),
  model_num varchar(15) ,
  serial_num varchar(50) ,
  battery_serial_num varchar(50) ,
  dop date ,
  warranty tinyint(1) ,
  vt tinyint(1) ,
  wifi tinyint(1) ,
  ram varchar(50) ,
  processor varchar(50) ,
  hdd varchar(50) ,
  supplier varchar(50) 
) ;


CREATE TABLE adapter (
  id int(20) primary key NOT NULL AUTO_INCREMENT,
  adapter_tag  varchar(50)  NOT NULL UNIQUE,
  brand varchar(50) ,
  model_num varchar(50) ,
  serial_num varchar(50) ,
  dop date ,
  warranty tinyint(1) ,
  supplier varchar(50) 
) ;
