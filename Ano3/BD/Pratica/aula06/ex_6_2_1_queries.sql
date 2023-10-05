--all queries will be put in here, instead of multiple files


--a
select Pname, Ssn, Fname, Lname
from Company.Project
join Company.Works_on on Pno=Pnumber
join Company.Employee on Essn=Ssn;

--b
select Fname, Lname 
from Company.Employee
where Super_ssn=(select Ssn from Company.Employee where Fname='Carlos' and Minit='D' and Lname='Gomes')

--c
select Pname, total_worked 
from Company.Project
join(
select Pno, SUM(hours) as total_worked from Company.Works_on
group by Pno
)as Worked_Table
on Pnumber=Pno

--d
select Fname, Lname 
from Company.Project
join Company.Works_on ON Pnumber=Pno
join (
			select Fname, Lname, Ssn from Company.Employee
			where Dno=3
			) as dep3_empls
on Essn=Ssn
where hours>20

--e
select Fname, Minit, Lname 
from Company.Employee
left join Company.Works_on on Essn=Ssn
where Pno is null

--f
select Dname, AVG(Salary) as Avg_Salary 
from Company.Department
join (select * 
from Company.Employee 
where Sex='F') as F_DEP on Dnumber=Dno
group by Dname

--g
select Fname, Minit, Lname 
from Company.Employee
join (
    select Essn, COUNT(Essn) AS count_dep FROM Company.Dependent
    group by Essn
    having COUNT(Essn)>1
    ) as TWOORMORE
on Ssn=Essn

--h
select Fname, Minit, Lname 
from Company.Department
join(
        select E.Fname, E.Minit, E.Lname, E.Ssn 
        from Company.Employee as E
        left join Company.Dependent on Ssn=Essn
        where Essn is null
        ) 
as NODEP_EMP
on Mgr_ssn=Ssn

--i
select Fname, Minit, Lname, e_Address 
from Company.Employee
join(
			select * 
            from Company.Project
			join Company.Dept_locations on Dnum=Dnumber
			where Dlocation!='Aveiro' and Plocation='Aveiro'
			) as PROJECT_LST
on Dno=Dnum