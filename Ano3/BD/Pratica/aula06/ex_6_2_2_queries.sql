
--a
select nome 
from GESTSTOCK.encomenda
full outer join GESTSTOCK.fornecedor on fornecedor=nif
where fornecedor is null

--b
select nome, AVG(I.unidades) as media 
from GESTSTOCK.item as I
join GESTSTOCK.produto on codProd=codigo
group by codProd, nome

--c
select AVG(num_prod) as media 
from 
	(select COUNT(codProd) as num_prod 
	from GESTSTOCK.item
	group by numEnc) as P
	
--d
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