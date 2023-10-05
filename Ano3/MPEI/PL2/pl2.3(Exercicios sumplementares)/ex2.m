%%Considere o evento ”B - uma caixa de brinquedos nao tem brinquedos com defeito”
%

%a)  Estime por simulac¸ao a probabilidade do evento B quando ˜ n = 8 brinquedos. 

p1 = 0.2/100;
p2 = 0.5/100;
pa = 0.01;
N = 1e6;
n = 8;
d1 = rand(n, N) < p1; %situaçoes em que componente 1 tem defeito
d2 = rand(n, N) < p2; %situaçoes em que componente 2 tem defeito
da = rand(n, N) < pa; %situaçoes em que o brinquedo tem defeito(e as componentes não)
defeitos = d1 + d2 +da; % situações em que houve defeitos (quer seja das componentes ou do processo de montagem)
caixasDefeitos = sum(defeitos > 0); %número de brinquedos defeituosos por caixa
peloMenos1 = sum(caixasDefeitos >=1 );%número de caixas com, pelo menos 1 brinquedo defeituoso
ProbA = peloMenos1/N; %Prob de haver pelo menos um brinquedo defeituoso numa caixa de 8

semdefeitos = sum(sum(defeitos) == 0);
ProbB = semdefeitos/N;%Probabilidade de não haver brinquedos defeituosos em caixas de 8

fprintf("EX2-a) Probabilidade de não haver brinquedos defeituosos é igual a %f", ProbB);

%Verifique a consistencia deste resultado com o obtido na questao 1(a).

%Resposta --> O acontecimento B representa o acontecimento contrário ao A,
%portanto Prob(B) = 1 - Prob(A).

Consistencia = (ProbB == (1 - ProbA));
if(Consistencia == 1)
fprintf("\nOs resultados são consistentes com o exercício anterior, pois p(B) = 1-p(A)");
end





%b) Determine o valor teorico da probabilidade do evento B e compare-o com o valor estimado por ´
%simulac¸ao na quest ˜ ao 2(a). O que conclui? 
ProbabilidadeA = p1*p2*pa + p1*pa + p1 *p2 + pa *p2+p1+p2+pa; %<-- Probabilidade de haver pelo menos 1 defeito


ProbabilidadeB = 1 - ProbabilidadeA; %<-- Probabilidade de não haver defeitos
%aplicar a fórmula binomial

n = 8;
k = 8;
p = ProbabilidadeB;


ValorTeorico = nchoosek(n, k)*(p^k)*(1-p)^(n-k);
fprintf("\n");
fprintf("\nEX-b) Valor teorico da probabilidade pedida na alínea anterior é igual a %f", ValorTeorico);
fprintf("\nObservamos valores muito semelhantes, portanto podemos concluir que o cálculo de ambos está correto");


%c)Fac¸a as simulac¸oes necess ˜ arias para desenhar um gr ´ afico ´ plot da probabilidade do evento B em
%func¸ao da capacidade da caixa ˜ n. Considere todos os valores de n de 2 a 20. Descreva e justifique
%os resultados obtidos



N = 1e5;
Probs = zeros(1, 19);
for n = 2:20
    

p1 = 0.2/100;
p2 = 0.5/100;
pa = 0.01;

d1 = rand(n, N) < p1; %situaçoes em que componente 1 tem defeito
d2 = rand(n, N) < p2; %situaçoes em que componente 2 tem defeito
da = rand(n, N) < pa; %situaçoes em que o brinquedo tem defeito(e as componentes não)
defeitos = d1 + d2 +da; % situações em que houve defeitos (quer seja das componentes ou do processo de montagem)
caixasDefeitos = sum(defeitos > 0); %número de brinquedos defeituosos por caixa
peloMenos1 = sum(caixasDefeitos >=1 );%número de caixas com, pelo menos 1 brinquedo defeituoso
ProbA = peloMenos1/N; %Prob de haver pelo menos um brinquedo defeituoso numa caixa de 8
semdefeitos = sum(sum(defeitos) == 0);
ProbB = semdefeitos/N;
Probs(n-1) = ProbB;
end

n = 2:20;
figure
plot(n, Probs, n, ones(19)*0.9);

xlabel("Número de brinquedos por caixa");
ylabel("Probabilidade de não haver brinquedos defeituosos");
title("Probabilidade de não haver brinquedos defeituosos de acordo com o número de brinquedos por caixa");

%d)Analisando o grafico trac¸ado na quest ´ ao anterior, 2(c), qual deve ser a capacidade m ˜ axima da caixa ´
%se a empresa quiser garantir que a probabilidade de cada caixa nao ter brinquedos com defeito seja ˜
%de pelo menos 90%?

fprintf("\nPara que a probabilidade não seja inferior a 90%, a capacidade máxima deve ser 6 brinquedos por caixa.");



