# BD: Guião 8


## ​8.1. Complete a seguinte tabela.
Complete the following table.

| #    | Query                                                                                                      | Rows  | Cost  | Pag. Reads | Time (ms) | Index used | Index Op.            | Discussion |
| :--- | :--------------------------------------------------------------------------------------------------------- | :---- | :---- | :--------- | :-------- | :--------- | :------------------- | :--------- |
| 1    | SELECT * from Production.WorkOrder                                                                         | 72591 | 0.484 | 531        | 1171      |PK          | Clustered Index Scan |            |
| 2    | SELECT * from Production.WorkOrder where WorkOrderID=1234                                                  |1       |0.003       |278            |161           |PK            |Clustered Index Seek                      |            |
| 3.1  | SELECT * FROM Production.WorkOrder WHERE WorkOrderID between 10000 and 10010                               |11       |0.003       |278            |111           |PK            |Clustered Index Seek                      |            |
| 3.2  | SELECT * FROM Production.WorkOrder WHERE WorkOrderID between 1 and 72591                                   |72591       |0.473       |816            |879           |PK            |Clustered Index Seek                      |            |
| 4    | SELECT * FROM Production.WorkOrder WHERE StartDate = '2007-06-25'                                          |   55    |    0.522   |    818       | 167         |    WorkOrderID (PK)        |    Clustered Index Scan                  |            |
| 5    | SELECT * FROM Production.WorkOrder WHERE ProductID = 757                                                   |   9    |    0.0373   |     302       |   116        |    ProductID        |    Non Clustered Index Seek                  |            |
| 6.1  | SELECT WorkOrderID, StartDate FROM Production.WorkOrder WHERE ProductID = 757                              |   9    |    0.0373   |     302       |    51       |    ProductID Covered (StartDate)        |      Non Clustered Index Seek                |            |
| 6.2  | SELECT WorkOrderID, StartDate FROM Production.WorkOrder WHERE ProductID = 945                              |    1105   |   0.005    |     26       |   87        |      ProductID Covered (StartDate)      |        Non Clustered Index Seek              |            |
| 6.3  | SELECT WorkOrderID FROM Production.WorkOrder WHERE ProductID = 945 AND StartDate = '2006-01-04'            |  1     |  0.005     |  20          |     15     |     ProductID Covered (StartDate)       |      Non Clustered Index Seek                |            |
| 7    | SELECT WorkOrderID, StartDate FROM Production.WorkOrder WHERE ProductID = 945 AND StartDate = '2006-01-04' |   1    |   0.017   |   29         |   50        |    ProductID and StartDate        |      Non Clustered Index Seek 2x                |            |
| 8    | SELECT WorkOrderID, StartDate FROM Production.WorkOrder WHERE ProductID = 945 AND StartDate = '2006-01-04' |     1  |    0.003   |            |      32     |        12    |             Composite (ProductID, StartDate)         |    Non Clustered Index Seek        |

## ​8.2.

### a)

```
CREATE UNIQUE CLUSTERED INDEX idx_rid ON dbo.mytemp(rid)
```

### b)

```
Fragmentação: 98.8%
Ocupação: 69.9%
```

### c)

```
Fillfactor: 65%
61150 ms
Fillfactor: 80%
61590 ms
Fillfactor: 90%
65686 ms
```

### d)

```
Fillfactor: 65%
54050 ms
Fillfactor: 80%
54400 ms
Fillfactor: 90%
53896 ms
```

### e)

```
75915 ms
Uma vez que há mais indices, a performance de inserção piora.
```

## ​8.3.

```
i) CREATE UNIQUE CLUSTERED INDEX idx_ssn ON EMPLOYEE(Ssn);
ii) CREATE NONCLUSTERED INDEX idx_f_lname ON EMPLOYEE(Fname, Lname);
iii) CREATE NONCLUSTERED INDEX idx_dno ON EMPLOYEE(Dno);
CREATE UNIQUE CLUSTERED INDEX idx_dnumber ON DEPARTMENT(Dnumber);
iv) CREATE UNIQUE CLUSTERED INDEX idx_essn_pno ON WORKS_ON(Essn, Pno);
CREATE NONCLUSTERED INDEX idx_pnum ON PROJECT(Pnumber);
v) CREATE UNIQUE CLUSTERED INDEX idx_essn_dname ON DEPENDENT(Essn, Dependent_name);
vi) CREATE CLUSTERED INDEX idx_pnum_dno ON PROJECT(Pnumber, Dnum)
```