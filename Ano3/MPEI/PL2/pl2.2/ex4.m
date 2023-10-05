%Sabendo que um processo de fabrico produz 30% de pec¸as defeituosas e considerando a variavel aleat ´ oria ´
%X, representativa do numero de pec¸as defeituosas numa amostra de 5 pec¸as tomadas aleatoriamente, ´
%obtenha:

%%
%(a) Por simulac¸ao: ˜
%i. estimativa para a func¸ao massa de probabilidade de ˜ X;

N = 1e5;
n = 5; %número de peças numa amostra


fabrico = rand(n, N) < 0.3;
defeitos0 = sum(sum(fabrico) == 0);
defeitos1 = sum(sum(fabrico) == 1);
defeitos2 = sum(sum(fabrico) == 2);
defeitos3 = sum(sum(fabrico) == 3);
defeitos4 = sum(sum(fabrico) == 4);
defeitos5 = sum(sum(fabrico) == 5);


probs = [defeitos0 defeitos1 defeitos2 defeitos3 defeitos4 defeitos5]/N;


figure
stem(0:5, probs);
title("Probabilidade de x peças defeituosas numa amostra de 5 peças");
xlabel("Número de peças");
ylabel("Probabilidade");


%ii) o grafico representativo da func¸ ´ ao distribuic¸ ˜ ao acumulada de probabilidades de ˜ X


figure
stairs(0:5, cumsum(probs));
title("Função distribuição acumulada.");
xlabel("Número de peças");
ylabel("Probabilidade");


%iii) iii. estimativa para probabilidade de, no maximo, 2 das pec¸as de uma amostra serem defeituosas.
%ou seja, 0, 1 ou 2

probMax2 = probs(1) + probs(2) + probs(3)

