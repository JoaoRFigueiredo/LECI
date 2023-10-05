use Company;


--ex1
DROP PROCEDURE IF EXISTS sp_remove_employee;
go
create procedure sp_remove_employee @ssn as int

as 
begin
	delete from Dependents where essn = @ssn;
	delete from Works_on where essn = @ssn;
	update Department set MGr_ssn=NULL where  Mgr_ssn=@ssn;
	update Employee set Super_ssn=null where Super_ssn=@ssn;
	delete from Employee where Ssn=@ssn;
	
end;
go
EXEC sp_remove_employee 21312332;

go

--Temos de atualizar o manager_ssn nas tabelas: Department e Employee

--ex2
DROP PROCEDURE IF EXISTS sp_get_dept_oldest_manager;

go
CREATE procedure sp_get_dept_oldest_manager (@mgr_ssn INT OUTPUT, @worked_years INT OUTPUT)

as
	begin
			select employee.* from Employee inner join Department on Employee.Ssn=Department.Mgr_ssn;
			select @mgr_ssn = Department.Mgr_ssn,  @worked_years = datediff(year, Mgr_start_date, getdate()) from Department
					where Mgr_start_date = (select min(Mgr_start_date) from Department);
					
	end

	go

DECLARE @ssn INT;
DECLARE @yrs INT;
exec sp_get_dept_oldest_manager @ssn OUTPUT, @yrs OUTPUT;
PRINT @ssn;
PRINT @yrs;
go



--ex3


GO
CREATE TRIGGER one_dept ON Department INSTEAD OF INSERT, UPDATE
AS
	BEGIN
		IF (SELECT count(*) FROM inserted) > 0
			BEGIN
				DECLARE @employee_ssn AS INT;
				SELECT @employee_ssn = Mgr_ssn FROM inserted;
				IF (@employee_ssn) IS NULL OR ((SELECT count(*) FROM Employee WHERE Ssn=@employee_ssn) = 0)
					RAISERROR('Employee doesnt existing', 16, 1);
				ELSE
					BEGIN
						IF (SELECT COUNT(Dnumber) FROM Department WHERE Mgr_ssn=@employee_ssn) >=1
							RAISERROR('Employee cant manage more than one department', 16, 1);	
						ELSE
							INSERT INTO Department SELECT * FROM inserted;
					END
			END
	END



--ex4

GO
CREATE TRIGGER tr_check_salary ON Employee AFTER INSERT, UPDATE
AS
	BEGIN
		DECLARE @ssn_emp AS INT;
		DECLARE @sal_emp AS INT;
		DECLARE @dno AS INT;
		DECLARE @mgr_sal AS INT;

		SELECT @ssn_emp=inserted.Ssn, @sal_emp=inserted.Salary, @dno=inserted.Dno FROM inserted;
		SELECT @mgr_sal=Employee.Salary FROM Department
			INNER JOIN Employee ON Department.Mgr_Ssn=Employee.Ssn
			WHERE @dno=Department.Dnumber;

		IF @sal_emp > @mgr_sal
		BEGIN
			UPDATE Employee SET Employee.Salary=@mgr_sal-1
			WHERE Employee.Ssn=@ssn_emp
		END
	END


--ex5

select * from Project;

DROP FUNCTION IF EXISTS get_employee_projects_info;
GO

CREATE FUNCTION get_employee_projects_info (@ssn INT)	
RETURNS TABLE
AS RETURN
    SELECT p.Pname, p.Plocation
    FROM Project p
    INNER JOIN Works_On w ON p.Pnumber = w.Pno
    WHERE w.Essn = @ssn;
GO

--ex6
drop function if exists get_employee_above_avg_salary;

go
create function get_employee_above_avg_salary (@dno INT)
returns table
as
return (
	select Fname,Lname,Salary 
	from EMPLOYEE
	where Dno = @dno and Salary > (
		select AVG(salary)
		from EMPLOYEE
		where Dno = @dno
	)
)
go

--ex7

go
create function employeeDeptHighAverage(@dno INT)
returns table
as
return (
	select p.Pname,p.Pnumber,p.Plocation,p.Dnum,
		SUM(w.Hours/40 * e.Salary) as budget,
		SUM(SUM(w.Hours/40 * e.Salary)) over (order by p.Pname) as total_budget
	from Project p
	join Works_on w on p.Pnumber = w.Pno
	join EMPLOYEE e on e.Ssn = w.Essn
	where p.Dnum = @dno
	group by p.Pname,p.Pnumber,p.Plocation,p.Dnum
)
go

--ex8.1 -> after

go
create trigger trigger_delete_department
on DEPARTMENT
after delete
as
begin
	if (exists (select * from INFORMATION_SCHEMA.TABLES
		where TABLE_SCHEMA = 'dbo' and TABLE_NAME = 'department_deleted'))
	begin
		insert into department_deleted
		select * from deleted;
	end
	else
	begin
		select * into department_deleted
		from deleted;
	end
end
go

--ex8.2 -> instead of
create trigger trigger_delete_department
on DEPARTMENT
instead of delete
as
begin
	if (exists (select * from INFORMATION_SCHEMA.TABLES
			where TABLE_SCHEMA = 'dbo' and TABLE_NAME = 'department_deleted'))
		begin
			insert into department_deleted
			select * from deleted;
		end
		else
		begin
			select *
			into department_deleted
			from deleted;
		end

		delete from DEPARTMENT
		where DEPARTMENT.Dnumber in (select DEPARTMENT.Dnumber from deleted)
end