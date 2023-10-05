%%Considere uma festa em que esta presente um determinado n ´ umero ´ n de pessoas.
%%
%a)Qual deve ser o menor valor de n para o qual a probabilidade de duas ou mais pessoas terem a
%mesma data de aniversario (mes e dia) ˆ e superior a 0,5 (assuma que um ano tem sempre 365 dias)? 
N = 1e5;

dias = 365; % numero de dias num ano;
sucessos = 0;
for nPessoas = 2 :366
   sucessos = 0;
    calendario = randi(365, nPessoas, N);
for i = 1 :N
    
   
    if(length(unique(calendario(:, i))) < nPessoas)
    sucessos = sucessos +1;
    end
end
prob = sucessos/N
if(prob > 0.5)
    break;
end

end

fprintf("O menor numero de pessoas para que a probabilidade seja superior a 0.5 é %f", nPessoas);

