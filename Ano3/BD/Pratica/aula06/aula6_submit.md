# BD: Guião 6

## Problema 6.1

### *a)* Todos os tuplos da tabela autores (authors);

```
Select * 
from authors 
```

### *b)* O primeiro nome, o último nome e o telefone dos autores;

```
select au_fname, au_lname, phone 
from authors
```

### *c)* Consulta definida em b) mas ordenada pelo primeiro nome (ascendente) e depois o último nome (ascendente); 

```
select au_fname, au_lname, phone 
from authors order by au_fname;
```

### *d)* Consulta definida em c) mas renomeando os atributos para (first_name, last_name, telephone); 

```
select au_fname as first_name, au_lname as last_name, phone as telephone 
from authors order by first_name
```

### *e)* Consulta definida em d) mas só os autores da Califórnia (CA) cujo último nome é diferente de ‘Ringer’; 

```
select au_fname as first_name, au_lname as last_name, phone as telephone 
from authors  where au_lname != 'Ringer' and state = 'CA' order by first_name 
```

### *f)* Todas as editoras (publishers) que tenham ‘Bo’ em qualquer parte do nome; 

```
select pub_name 
from publishers where pub_name like '%Bo%'
```

### *g)* Nome das editoras que têm pelo menos uma publicação do tipo ‘Business’; 

```
 select pub_name 
 from publishers join titles on (publishers.pub_id=titles.pub_id) where type = 'business'
```

### *h)* Número total de vendas de cada editora; 

```
select pub_name, sum(qty) 
from  publishers join titles on (publishers.pub_id=titles.pub_id) join sales on (titles.title_id=sales.title_id) group by pub_name
```

### *i)* Número total de vendas de cada editora agrupado por título; 

```
select pub_name,  title, sum(qty) as sales
from  publishers join titles on (publishers.pub_id=titles.pub_id) join sales on (titles.title_id=sales.title_id)
  group by title, pub_name
```

### *j)* Nome dos títulos vendidos pela loja ‘Bookbeat’; 

```
select title
from titles join sales on (titles.title_id=sales.title_id) join stores on (sales.stor_id=stores.stor_id)
where stor_name = 'Bookbeat'
```

### *k)* Nome de autores que tenham publicações de tipos diferentes; 

```
select au_fname, au_lname
from authors join titleauthor on (authors.au_id = titleauthor.au_id)
join titles on (titleauthor.title_id=titles.title_id)
group by au_fname, au_lname
having count(distinct type) > 1
```

### *l)* Para os títulos, obter o preço médio e o número total de vendas agrupado por tipo (type) e editora (pub_id);

```
select type, pub_id, avg(price) as avg_price, sum(qty) as num_of_sales
from titles join sales on titles.title_id=sales.title_id
group by type, pub_id
```

### *m)* Obter o(s) tipo(s) de título(s) para o(s) qual(is) o máximo de dinheiro “à cabeça” (advance) é uma vez e meia superior à média do grupo (tipo);

```
select type, max(advance) as max_advance, avg(advance) as average_advance
from titles
group by type
having max(advance) > 1.5*avg(advance)
```

### *n)* Obter, para cada título, nome dos autores e valor arrecadado por estes com a sua venda;

```
select title, au_fname, au_lname, ytd_sales*price*royalty/100 as profit
from titles join titleauthor on titleauthor.title_id=titles.title_id
join authors on authors.au_id=titleauthor.au_id
GROUP BY title, price, au_fname, au_lname, ytd_sales, royalty
```

### *o)* Obter uma lista que incluía o número de vendas de um título (ytd_sales), o seu nome, a faturação total, o valor da faturação relativa aos autores e o valor da faturação relativa à editora;

```
select title, ytd_sales, ytd_sales*price as facturacao, 
ytd_sales*price*royalty/100 as author_revenue,
ytd_sales*price -ytd_sales*price*royalty/100 as publisher_revenue
from titles
```

### *p)* Obter uma lista que incluía o número de vendas de um título (ytd_sales), o seu nome, o nome de cada autor, o valor da faturação de cada autor e o valor da faturação relativa à editora;

```
select title, ytd_sales, au_fname +' '+ au_lname as author, 
ytd_sales*price*royalty/100 as author_revenue,
ytd_sales*price -ytd_sales*price*royalty/100 as publisher_revenue
from titles
join titleauthor on titleauthor.title_id = titles.title_id
join authors on authors.au_id=titleauthor.au_id
group by title, ytd_sales, au_fname, au_lname, price, royalty
```

### *q)* Lista de lojas que venderam pelo menos um exemplar de todos os livros;

```
select stor_name
from stores join sales on stores.stor_id = sales.stor_id
join titles on titles.title_id=sales.title_id
group by stor_name
having count(title) = (select count(title_id) from titles)
```

### *r)* Lista de lojas que venderam mais livros do que a média de todas as lojas;

```
select stor_name
from stores join sales on stores.stor_id = sales.stor_id
join titles on sales.title_id=titles.title_id
group by stor_name
having sum(sales.qty) > (select SUM(sales.qty)/COUNT(stor_id) from sales)
```

### *s)* Nome dos títulos que nunca foram vendidos na loja “Bookbeat”;

```
select title
from titles
except
select distinct title from titles 
join sales on sales.title_id = titles.title_id
join stores on stores.stor_id = sales.stor_id
where stor_name="Bookbeat"
```

### *t)* Para cada editora, a lista de todas as lojas que nunca venderam títulos dessa editora; 

```
(select pub_name as publisher, stor_name as store
from publishers, stores
group by pub_name, stor_name
)
except
(select pub_name, stor_name
from publishers join titles on publishers.pub_id=titles.pub_id
join sales on titles.title_id=sales.title_id
join stores on stores.stor_id=sales.stor_id
group by pub_name, stor_name
)
```

## Problema 6.2

### ​5.1

#### a) SQL DDL Script
 
[a) SQL DDL File](ex_6_2_1_ddl.sql "SQLFileQuestion")

#### b) Data Insertion Script

[b) SQL Data Insertion File](ex_6_2_1_data.sql "SQLFileQuestion")

#### c) Queries

##### *a)*

```
select Pname, Ssn, Fname, Lname
from Company.Project
join Company.Works_on on Pno=Pnumber
join Company.Employee on Essn=Ssn;

```

##### *b)* 

```
select Fname, Lname 
from Company.Employee
where Super_ssn=(select Ssn from Company.Employee where Fname='Carlos' and Minit='D' and Lname='Gomes')

```

##### *c)* 

```
select Pname, total_worked 
from Company.Project
join(
select Pno, SUM(hours) as total_worked from Company.Works_on
group by Pno
)as Worked_Table
on Pnumber=Pno
```

##### *d)* 

```
select Fname, Lname 
from Company.Project
join Company.Works_on ON Pnumber=Pno
join (
			select Fname, Lname, Ssn from Company.Employee
			where Dno=3
			) as dep3_empls
on Essn=Ssn
where hours>20
```

##### *e)* 

```
select Fname, Minit, Lname 
from Company.Employee
left join Company.Works_on on Essn=Ssn
where Pno is null

```

##### *f)* 

```
select Dname, AVG(Salary) as Avg_Salary 
from Company.Department
join (select * 
from Company.Employee 
where Sex='F') as F_DEP on Dnumber=Dno
group by Dname
```

##### *g)* 

```
select Fname, Minit, Lname 
from Company.Employee
join (
    select Essn, COUNT(Essn) AS count_dep FROM Company.Dependent
    group by Essn
    having COUNT(Essn)>1
    ) as TWOORMORE
on Ssn=Essn
```

##### *h)* 

```
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
```

##### *i)* 

```
select Fname, Minit, Lname, e_Address 
from Company.Employee
join(
			select * 
            from Company.Project
			join Company.Dept_locations on Dnum=Dnumber
			where Dlocation!='Aveiro' and Plocation='Aveiro'
			) as PROJECT_LST
on Dno=Dnum
```

### 5.2

#### a) SQL DDL Script
 
[a) SQL DDL File](ex_6_2_2_ddl.sql "SQLFileQuestion")

#### b) Data Insertion Script

[b) SQL Data Insertion File](ex_6_2_2_data.sql "SQLFileQuestion")

#### c) Queries

##### *a)*

```
select nome 
from GESTSTOCK.encomenda
full outer join GESTSTOCK.fornecedor on fornecedor=nif
where fornecedor is null
```

##### *b)* 

```
select nome, AVG(I.unidades) as media 
from GESTSTOCK.item as I
join GESTSTOCK.produto on codProd=codigo
group by codProd, nome
```


##### *c)* 

```
select AVG(num_prod) as media 
from 
	(select COUNT(codProd) as num_prod 
	from GESTSTOCK.item
	group by numEnc) as P
```


##### *d)* 

```
select F.nome, P.nome, qnt_total 
from GESTSTOCK.fornecedor as F
join (
			select codProd, fornecedor, SUM(unidades) as qnt_total 
			from GESTSTOCK.item
			join GESTSTOCK.encomenda on numEnc=numero
			group by codProd, fornecedor
			) as AUX_TABLE
on fornecedor=nif
join GESTSTOCK.produto as P on codProd=codigo
```

### 5.3

#### a) SQL DDL Script
 
[a) SQL DDL File](ex_6_2_3_ddl.sql "SQLFileQuestion")

#### b) Data Insertion Script

[b) SQL Data Insertion File](ex_6_2_3_data.sql "SQLFileQuestion")

#### c) Queries

##### *a)*

```
select nome, paciente.numUtente 
from Prescricao.prescricao 
full outer join Prescricao.paciente on prescricao.numUtente=paciente.numUtente
where numPresc is null
```

##### *b)* 

```
select especialidade, COUNT(numPresc) as total_presc 
from Prescricao.prescricao
join Prescricao.medico on numMedico=numSNS
group by especialidade
```


##### *c)* 

```
select nome, COUNT(numPresc) as total_presc 
from Prescricao.prescricao
join Prescricao.farmacia on farmacia=nome
group by nome
```


##### *d)* 

```
select farmaco.nome  
from Prescricao.farmaco
join Prescricao.farmaceutica on numRegFarm=numReg
where numRegFarm=906
except
(select nomeFarmaco 
from Prescricao.presc_farmaco
where numRegFarm=906)
```

##### *e)* 

```
select farmacia, nome, qtd_farmacos 
from Prescricao.farmaceutica
join (
			select farmacia, numRegFarm, COUNT(numRegFarm) as qtd_farmacos 
            from
				(select farmacia, numRegFarm 
                from Prescricao.presc_farmaco
				join Prescricao.prescricao on presc_farmaco.numPresc=prescricao.numPresc
				where farmacia is not null) as FARM_SELLED
			group by farmacia, numRegFarm
			) as AUX_TABLE
on numRegFarm=numReg
```

##### *f)* 

```
select nome from Prescricao.paciente
join (
			select numUtente, COUNT(numMedico) as medicos_dif from 
				( select numUtente, numMedico from Prescricao.prescricao ) as AUX
			group by numUtente
			having COUNT(numMedico)>1
			) as UTENTE_2MED
on paciente.numUtente=UTENTE_2MED.numUtente
```
