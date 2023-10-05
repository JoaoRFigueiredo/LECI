
--a
select nome, paciente.numUtente 
from Prescricao.prescricao 
full outer join Prescricao.paciente on prescricao.numUtente=paciente.numUtente
where numPresc is null

--b
select especialidade, COUNT(numPresc) as total_presc 
from Prescricao.prescricao
join Prescricao.medico on numMedico=numSNS
group by especialidade

--c
select nome, COUNT(numPresc) as total_presc 
from Prescricao.prescricao
join Prescricao.farmacia on farmacia=nome
group by nome

--d
select farmaco.nome  
from Prescricao.farmaco
join Prescricao.farmaceutica on numRegFarm=numReg
where numRegFarm=906
except
(select nomeFarmaco 
from Prescricao.presc_farmaco
where numRegFarm=906)

--e
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

--f
select nome from Prescricao.paciente
join (
			select numUtente, COUNT(numMedico) as medicos_dif from 
				( select numUtente, numMedico from Prescricao.prescricao ) as AUX
			group by numUtente
			having COUNT(numMedico)>1
			) as UTENTE_2MED
on paciente.numUtente=UTENTE_2MED.numUtente