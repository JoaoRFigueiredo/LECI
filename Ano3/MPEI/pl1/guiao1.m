%2)Estime a probabilidade de obter 6 caras em 15 lanc¸amentos de uma moeda equilibrada? 


N= 1e5; %nu´mero de experieˆncias
p = 0.5; %probabilidade de cara
k = 6; %nu´mero de caras
n = 15; %nu´mero de lanc¸amentos
lancamentos = rand(n,N) > p;
sucessos= sum(lancamentos)==k;
probSimulacao6em15 = sum(sucessos)/N



%. 3)Qual e a probabilidade de obter pelo menos 6 caras em 15 lanc¸amentos de uma moeda equilibrada?
N= 1e5; %nu´mero de experieˆncias
p = 0.5; %probabilidade de cara
k = 6; %nu´mero de caras
n = 15; %nu´mero de lanc¸amentos
lancamentos = rand(n,N) > p;
sucessos= sum(lancamentos)>=k;
probSimulacaoPeloMenos6em15= sum(sucessos)/N

%4) a)Aplique a func¸ao para voltar a estimar as probabilidades das quest ˜ oes anteriores assim como estimar ˜
%as probabilidades para todo o espac¸o de amostragem2 para os seguintes numeros de lanc¸amentoss: 20, ´
%40 e 100.

%20 lançamentos

for v = 0:1:20
prob20 = prob(1e5, v, 20);
%fprintf("Probabilidade de obter %f caras em 20 lançamentos é de %f\n", v, prob20);
end

disp("------------------------------------------");
%40 lançamentos

for v = 0:1:40
prob40 = prob(1e5, v, 40);
%fprintf("Probabilidade de obter %f caras em 40 lançamentos é de %f\n", v, prob40);
end
disp("------------------------------------------");
%100 lançamentos

for v = 0:1:100
prob100 = prob(1e5, v, 100);
%fprintf("Probabilidade de obter %f caras em 100 lançamentos é de %f\n", v, prob100);
end

disp("------------------------------------------");




%b)
x = 1:20;
for v = 1:20
x(v) = prob(1e5, v, 20);
end
stem(x);


function prob = prob(N, k, n) %N = numero de experiencias / k = numero de caras / n = numero de lançamentos
        lancamentos = rand(n, N) > 0.5;
        sucessos = sum(lancamentos) == k;
        prob = sum(sucessos)/N;
end



