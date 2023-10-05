%%Considere um dado de seis faces numeradas de 1 a 6 lanc¸ado 2 vezes. Assuma que o dado e equilibrado ´
%(mesma probabilidade para todas as faces ficarem para cima). Considere os acontecimentos seguintes:
%“A – a soma dos dois valores e igual a 9”, “B – o segundo valor ´ e par”, “C – pelo menos um dos valores ´
%e igual a 5” e “D – nenhum dos valores ´ e igual a 1”.

%%
%a)Estime por simulac¸ao a probabilidade da cada um dos 4 acontecimentos.

%A
N=1e5;

dados = randi(6, 2, N);
noves = sum(dados) == 9;
sucessos = sum(noves);


probA = sucessos /N;
fprintf("A probabilidade do acontecimento A é %f\n", probA);
%B 
Npares = 0;
for i =1:N
if ( mod(dados(2, i), 2) == 0)
    Npares = Npares +1;
end  

end
probB = Npares/N;
fprintf("A probabilidade do acontecimento B é %f\n", probB);

%C)
cincos = 0;
for i =1:N
if ( dados(1, i) == 5 || dados(2, i) == 5)
    cincos = cincos +1;
end  

end

probC = cincos/N;
fprintf("A probabilidade do acontecimento C é %f\n", probC);

%D)
sem1 = 0;
for i =1:N
if ( dados(1, i) ~= 1 && dados(2, i) ~= 1)
    sem1 = sem1 +1;
end  

end

probD = sem1/N;
fprintf("A probabilidade do acontecimento D é %f\n", probD);

%b) e c) feitos no caderno.

%A e B são independentes

%C e D não são independentes




