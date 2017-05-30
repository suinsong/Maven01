

select count(*) from buyer ;  -- 레코드 전체 개수 확인

select count(*) from buyer where bucode like "3%" -- 코드가 3으로 시작되는 데이터 개수 

select * from sales ;

select sadate, satime, sabucode from sales ;

select sadate , satime, sabucode, buname from sales
left join buyer
on sales.sabucode = buyer.bucode ;



