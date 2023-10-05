# BD: Guião 9


## ​9.1
 
### *a)*

```
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

-- Preocupações -> temos de atualizar o manager_ssn nas tabelas: Department e Employee
```

### *b)* 

```
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
```

### *c)* 

```
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
```

### *d)* 

```
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

INSERT INTO Employee VALUES ('Ze', 'T', 'Afonsado', 999888777, '2001-03-10', 'Rua Principal 8', 'M', 1500, 21312332, 1);
INSERT INTO Employee VALUES ('Andre', 'M', 'Zuquete', 123456789, '2001-06-17', 'Estrada da Cela 8', 'M', 1200, 21312332, 1);
SELECT * FROM Employee;
```

### *e)* 

```
GO

CREATE FUNCTION get_employee_projects_info (@ssn INT)	
RETURNS TABLE
AS RETURN
    SELECT p.Pname, p.Plocation
    FROM Project p
    INNER JOIN Works_On w ON p.Pnumber = w.Pno
    WHERE w.Essn = @ssn;
GO

SELECT * FROM get_employee_projects_info(41124234 );
```

### *f)* 

```
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
```

### *g)* 

```
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
```

### *h)* 

```
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
go
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
go
```

### *i)* 

```
Stored Procedures são batchs armazenadas com um nome, que podem ter parâmetros de entrada, valor de retorno ou devolver um conjunto de registros. As suas vantagens incluem maior extensibilidade, performance, usabilidade, integridade de dados e segurança. Além disso, podem ser utilizados como fonte de dados nas consultas e nas cláusulas WHERE/HAVING. Um possível exemplo de utilização seria uma base de dados de uma loja online onde pode ter uma stored procedure chamada "AddOrder" que aceita como parâmetros o ID do cliente, os IDs dos produtos e as quantidades a serem compradas. A stored procedure pode então inserir os detalhes do pedido na tabela de pedidos e deduzir o estoque dos produtos comprados.

As UDFs podem ser utilizadas para incorporar lógica complexa dentro de uma consulta e oferecem as mesmas vantagens das vistas. Podem aceitar parâmetros, mas possuem algumas limitações, como serem determinísticas, não permitirem BLOBs ou table variables como valor de retorno, terem recursividade limitada e não permitirem TRY...CATCH ou RAISERROR.Um possível exemplo de utilização seria uma base de dados de uma empresa que precisa de calcular o preço total de um produto, levando em conta o imposto e o desconto aplicado. Eles podem criar uma UDF chamada "CalculatePrice" que aceita como parâmetros o preço base do produto, a taxa de imposto e o valor do desconto. Esta UDF poderia ser usada para calcular o preço total de vários produtos de uma vez.

```
