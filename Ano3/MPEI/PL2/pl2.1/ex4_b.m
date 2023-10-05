%b)

N = 1e5;


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
if(prob > 0.9)
    break;
end

end

fprintf("O menor numero de pessoas para que a probabilidade seja superior a 0.5 é %d", nPessoas);