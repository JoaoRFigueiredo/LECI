# BD: Guião 5


## ​Problema 5.1
 
### *a)*

```
proj_lst = project ⨝ Dno = Dnum employee
π Pname, Fname, Ssn, Lname (proj_lst) 
```


### *b)* 

```
Carlos = π Mgr_ssn←Ssn (σ Fname = 'Carlos' ∧ Minit='D' ∧ Lname = 'Gomes' (employee))
employee_lst = employee ⨝ Super_ssn=Mgr_ssn Carlos
π Fname, Lname (employee_lst)
```


### *c)* 

```
working_hours = γ Pno; sum(Hours) -> total_worked works_on
π Pname, total_worked (project ⨝ Pnumber=Pno working_hours)
```


### *d)* 

```
work = (σ Dno=3 (employee))⨝(Essn=Ssn) (σ Hours>20 ∧ Pname='Aveiro Digital' (project ⨝ (Pnumber=Pno) works_on))
π Pname,Fname,Hours,Dno (work
```


### *e)* 

```
list = employee ⟕ Ssn=Essn works_on
πFname, Lname (σ Pno=null (list))
```


### *f)* 

```
dep_fem=department⨝Dno=Dnumber (σ(Sex='F') (employee))
γ Dname;avg(Salary) -> Avg_Salary (dep_fem)
```


### *g)* 

```
T = (γEssn;count(Ssn) -> ndep (employee⨝Ssn=Essn (dependent)))
π Fname,Lname (σ ndep>1 (T⨝Essn=Ssn employee))
```


### *h)* 

```
not_dep = σEssn=null (dependent⟖Essn=Ssn employee)
π Fname,Lname (department⨝Mgr_ssn=Ssn not_dep)
```


### *i)* 

```
dep_loc = σDlocation≠'Aveiro' (department⨝department.Dnumber=dept_location.Dnumber (dept_location))
p_dif_loc = σPlocation≠Dlocation (project⨝Dnum=department.Dnumber (dep_loc))

πFname,Lname,Address (employee⨝department.Dnumber=Dno p_dif_loc)

```


## ​Problema 5.2

### *a)*

```
πnome (σnumero=null (encomenda⟖fornecedor=nif fornecedor))
```

### *b)* 

```
πnome,avg_unidade ((γcodProd;avg(unidades) -> avg_unidade item)⨝codProd=codigo produto )
```


### *c)* 

```
γ;avg(nprod)->average (γ numEnc;count(codProd)-> nprod (item))
```


### *d)* 

```
table = γ codProd,fornecedor;sum(unidades)->total (item ⨝numEnc=numero encomenda)
π fornecedor.nome,produto.nome,total (table ⨝fornecedor=nif fornecedor ⨝codProd=codigo produto)
```


## ​Problema 5.3

### *a)*

```

table = (σ numPresc=null (prescricao ⟗prescricao.numUtente=paciente.numUtente paciente))
π nome (table)

```

### *b)* 

```
γ especialidade; count(especialidade) -> numeroDePrescricoes (prescricao ⨝numMedico=numSNS medico)
```


### *c)* 

```
γ nome; count(numPresc) -> numeroDePrescricoes (prescricao ⨝farmacia=nome farmacia)
```


### *d)* 

```
σ numPresc = null (σ numRegFarm = 906 (farmaco) ⟕ nome = nomeFarmaco σ numRegFarm = 906 (presc_farmaco))
```

### *e)* 

```
π farmacia, numRegFarm, num (γ farmacia, numRegFarm; count(prescricao.numPresc) -> num (σ farmacia!=null (π prescricao.numPresc, farmacia (prescricao)) ⨝ prescricao.numPresc=presc_farmaco.numPresc (presc_farmaco)))
```

### *f)* 

```
π  numUtente (σ num>1 (π numUtente,num (γ numUtente; count(numUtente) -> num (π numUtente, numMedico, num (γ numUtente, numMedico; count(numUtente) -> num prescricao)))))
```
