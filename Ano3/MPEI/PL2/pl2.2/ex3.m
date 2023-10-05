%Considere 4 lanc¸amentos de uma moeda equilibrada. Seja X a variavel aleat ´ oria representativa do ´
%numero de coroas observados nos ´ 4 lanc¸amentos.
%%

%a)Estime por simulac¸ao a funçao massa de probabilidade ˜ pX(x) da variavel aleat ´ oria ´ X.

n = 4; %nº de lançamentos
N = 1e5;


experiencias = rand(n, N) < 0.5;
coroas0 = sum(sum(experiencias)== 0);
coroas1 = sum(sum(experiencias)== 1);
coroas2 = sum(sum(experiencias)== 2);
coroas3 = sum(sum(experiencias)== 3);
coroas4 = sum(sum(experiencias)== 4); 

x = 0:1:4
px =[coroas0 coroas1 coroas2 coroas3 coroas4]/N;



 figure
 stem(x, px);
 xlabel("Número de coroas");
 ylabel("Probabilidade");
 title("Função massa de probabilidade (Simulação)");
 
 %b)Estime o valor esperado, a variancia e o desvio padr ˆ ao de ˜ X com base em pX(x).
 
 %E[X] = Xi * pXi;
EX = sum(x.*px)

%Variancia = E[X^2] - E^2[X]


var = sum((x.^2).*px) - EX^2


%desvio padrao é igual à raiz quadrada da variancia

desvio = sqrt(var)



%c) Identifique o tipo da distribuic¸ao da vari ˜ avel aleat ´ oria ´ X e escreva a expressao te ˜ orica da respectiva ´
%func¸ao de probabilidade.

%Respostas: Distribuição binomial


%d) Calcule os valores teoricos da func¸ ´ ao massa de probabilidade de ˜ X e compare-os com os valores
%estimados por simulac¸ao obtidos em (a).

%nchoosek(n,k)*(p^k)*(p^(n-k)); <-- lei binomial, n = numero de elementos,
%k elemento do espaço de amostragem, p = probabilidade


n = 4;
p = 0.5;
for k = 0:4
    prob(k+1) = nchoosek(n,k)*(p^k)*(p^(n-k));
end
prob;

figure 
stem(x, prob);
xlabel("Número de coroas");
ylabel("Probabilidade");
title("Função massa de probabilidade (teórico");

%e)Calcule os valores teoricos de ´ E[x] e de V ar(X) e compare-os com os valores obtidos em (b).

 %E[X] = Xi * pXi;
EX = sum(x.*prob)

%Variancia = E[X^2] - E^2[X]


var = sum((x.^2).*prob) - EX^2


%desvio padrao é igual à raiz quadrada da variancia

desvio = sqrt(var)


%Os valores são os mesmos.


%(f) Com base nos valores teoricos da funcao massa de probabilidade desta distribuicao, calcule: 
%i. a probabilidade de obter pelo menos 2 coroas;

%i)Pelo menos 2 coroas (2, 3 ou 4 coroas);


ProbTeoricaPeloMenos2 = prob(3) + prob(4) + prob(5)


%ii)a probabilidade de obter ate 1 coroa ( 0 ou 1);

ProbTeoricaAte1 = prob(1) + prob(2)

%iii) a probabilidade de obter entre 1 e 3 coroas (1, 2 ou 3);

ProbTeorica1A3 = prob(2) + prob(3) + prob(4)

