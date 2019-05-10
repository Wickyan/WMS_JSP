--create user test1 identified by 123456;
--grant resource,connect to test1;
create table Admin
(
  account varchar(20) primary key,
  password varchar(20),
  name varchar(10),
  sex varchar(5),
  age varchar(5),
  phone varchar(15),
  address varchar(30),
  email varchar(30) 
);

insert into admin ( ACCOUNT, PASSWORD, NAME, SEX, AGE, PHONE, ADDRESS, EMAIL)
values ('admq', '123456', '张三', '女', '32', '13611111111', null, null);

create table customer
(
  account varchar(20) primary key,
  password varchar(20),
  name varchar(10),
  sex varchar(5),
  age varchar(5),
  phone varchar(15),
  address varchar(30),
  email varchar(30) 
);

create table goods
( 
  name varchar(20) primary key,
  address varchar(20),
  num varchar(10),
  goodsid varchar(10) ,
  sort varchar(15),
  price varchar(10) 
);
