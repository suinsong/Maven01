



create table buyer(
	id int not null auto_increment,
	bucode varchar(10) not null,
	buname varchar(15) not null,
	butel varchar(15) not null,
	buaddr varchar(50) default "우리동네",
	bupoint int default 0,
	primary key(id)
	
);


drop table sale;

drop table sales; 



create table sales (
	id int not null auto_increment,
	sadate varchar(8) not null,
	satime varchar(8) not null,
	sabucode varchar(10),
	sapcode varchar(13), -- 상품코드
	sapprice int, -- 판매 단가
	sapqty int, -- 판매 수량
	saptotal int, -- 판매 금액
	sappoint int, 
	
	primary key(id)

);





create table names(
	id int not null auto_increment,
	egname varchar(30),
	hgname varchar(30),
	means varchar(150),
	
	primary key(id)

);

