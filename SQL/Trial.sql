create database assingnment ;
 
 use assingnment ;
create table student 
(
	stuID int,
    stuName varchar(100),
    EndrollmentNo varchar(15),
    division varchar(50),
    sem int,
    birthDate datetime,
    Email varchar(100),
    ContactNo varchar(50)
);

insert into student 
values (101, 'Naimish Patel', '090200107051', 'BCX -3', 3, '1991-12-06', 'naimishp49@gmail.com', '8866566768'),
	   (102, 'Firoz A. S.', '090200107090', 'BCY -3', 3, '1994-05-03', 'Firoz.me@gmail.com', '8888999922'),
       (103, 'Krunal Vyas', '090200107101', 'BCZ -5', 5, '1984-03-01', 'Krunal.vyas@gmail.com', '9999888877'),
       (104, 'Vijay Patel', '090200107102', 'BCX -5', 5, '1985-02-15', 'Vijay.patel123@gmail.com', '8787878787'),
       (105, 'Vimal Trivedi', '090200107103', 'BCY -3', 3, '1988-01-20', 'Vimal123@gmail.com', NULL);

--1
select * from student   
where division = 'BCX -3'

--2
select stuName from student
where sem = 3 or sem = 5


select stuName from student
where sem in(3,5)

--3
select * from student
where stuName not like 'v%'

--4
-- SELECT TOP 3 * FROM STUDENTS
select * from student
limit 3;

--5
select distinct division from student

--6
select stuName, EndrollmentNo TOP 30 PERCENT from student
where ContactNo like '%7'

--7
select * from student
where Email = '%3@g%' and division = 'BCZ -5'

--8
select stuID ,stuName, Email from student

--9
select * from student
where birthDate > '1990-01-01'

--10
select stuName from student
where sem = 3 and EndrollmentNo = 107

--11
select stuName, division from student
order by EndrollmentNo


--12
select * from student
where ContactNo = ''


--13
select distinct sem from student

--14
select EndrollmentNo , sem from student
where birthDate > '1986-03-15' and ( division = 'BCX -3' or division = 'BCZ -5' or division = 'BCY -3' )


--15
select * from student
order by birthDate DESC 

