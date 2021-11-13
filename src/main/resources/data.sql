insert into course(id, name,created_date,last_updated_date) values(1001,'JPA -in 100 steps', sysdate(), sysdate());
insert into course(id, name,created_date,last_updated_date) values(1002,'Hibernate -in 100 steps', sysdate(), sysdate());
insert into course(id, name,created_date,last_updated_date) values(1003,'Spring Boot -in 100 steps', sysdate(), sysdate());

insert into passport(id, number,created_date,last_updated_date) values(4001,'E0MH001', sysdate(), sysdate());
insert into passport(id, number,created_date,last_updated_date) values(4002,'E0MH002', sysdate(), sysdate());
insert into passport(id, number,created_date,last_updated_date) values(4003,'E0MH003', sysdate(), sysdate());

insert into student(id, name,created_date,last_updated_date,passport_id) values(2001,'Ashish', sysdate(), sysdate(),4001);
insert into student(id, name,created_date,last_updated_date,passport_id) values(2002,'Akash', sysdate(), sysdate(),4002);
insert into student(id, name,created_date,last_updated_date,passport_id) values(2003,'Prashant', sysdate(), sysdate(),4003);

insert into review(id,rating,description,course_id,created_date,last_updated_date) values(5001,'5','Good course',1001 ,sysdate(), sysdate());
insert into review(id,rating,description,course_id,created_date,last_updated_date) values(5002,'3','Average course',1001, sysdate(), sysdate());
insert into review(id,rating,description,course_id,created_date,last_updated_date) values(5003,'4',' Good content',1003, sysdate(), sysdate());