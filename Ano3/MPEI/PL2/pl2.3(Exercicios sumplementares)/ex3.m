%%Considere a variavel aleatoria  X que representa o numero de brinquedos defeituosos numa caixa.

%a)Estime por simulac¸ao a funcao massa de probabilidade  pX(x) de X quando n = 8 brinquedos e
%desenhe-a num grafico  stem. Descreva os resultados obtidos e verifique a sua consistencia com o ˆ
%resultado obtido na questao 2(a). 

X = 0:8;
Probs = zeros(1, 9);
p1 = 0.2/100;
p2 = 0.5/100;
pa = 0.01;
N = 1e5;
n = 8;
for i = 1:9
d1 = rand(n, N) < p1; %situaçoes em que componente 1 tem defeito
d2 = rand(n, N) < p2; %situaçoes em que componente 2 tem defeito
da = rand(n, N) < pa; %situaçoes em que o brinquedo tem defeito(e as componentes não)
defeitos = d1 + d2 +da; % situações em que houve defeitos (quer seja das componentes ou do processo de montagem)
caixasDefeitos = sum(defeitos > 0); %número de brinquedos defeituosos por caixa
brinquedosDefeituosos = sum(caixasDefeitos == i-1); %obtem todos os valores para i brinquedos defeituosos numa caixa de 8
Probs(i) = brinquedosDefeituosos/N;

end

figure
stem(X, Probs);
xlabel("Número de brinquedos defeituosos");
ylabel("PX(x)");
title("Probabilidade em função do número de brinquedos defeituosos por caixa");

%b) Com base em pX(x), calcule a probabilidade de X >= 2. O que conclui?
PeloMenos2 =0;

for i = 1:7
   PeloMenos2 = PeloMenos2 + Probs(i+2); 
end   

fprintf("PX(x) com X >=2 é igual a %f", PeloMenos2);


%c)Com base em pX(x), estime o valor esperado, a variancia e o desvio padrao de  X.

ValorEsperado = sum(Probs.*X);
Variancia = sum((X.^2).*Probs) - ValorEsperado^2;
DesvioPadrao = sqrt(Variancia);
fprintf("\n----Alínea C) -------------------");
fprintf("\nC)-- E[X] = %f", ValorEsperado);
fprintf("\nC)-- Var[X] = %f", Variancia);
fprintf("\nC)-- DesvioPadrao = %f", DesvioPadrao);


%d)Repita as questoes 3(a), 3(b) e 3(c), mas agora considerando ˜ n = 16 brinquedos. Compare todos
%os resultados com os obtidos anteriormente (com n = 8 brinquedos) e justifique as diferenc¸as.

fprintf("\n-----------Alínea D) -------------------------");


X = 0:16;
Probs = zeros(1, 17);
p1 = 0.2/100;
p2 = 0.5/100;
pa = 0.01;
N = 1e5;
n = 16;
for i = 1:17
d1 = rand(n, N) < p1; %situaçoes em que componente 1 tem defeito
d2 = rand(n, N) < p2; %situaçoes em que componente 2 tem defeito
da = rand(n, N) < pa; %situaçoes em que o brinquedo tem defeito(e as componentes não)
defeitos = d1 + d2 +da; % situações em que houve defeitos (quer seja das componentes ou do processo de montagem)
caixasDefeitos = sum(defeitos > 0); %número de brinquedos defeituosos por caixa
brinquedosDefeituosos = sum(caixasDefeitos == i-1); %obtem todos os valores para i brinquedos defeituosos numa caixa de 8
Probs(i) = brinquedosDefeituosos/N;

end

figure
stem(X, Probs);
xlabel("Número de brinquedos defeituosos");
ylabel("PX(x)");
title("Probabilidade em função do número de brinquedos defeituosos por caixa");


PeloMenos2 =0;

for i = 1:15
   PeloMenos2 = PeloMenos2 + Probs(i+2); 
end   

fprintf("\nPX(x) com X >=2 é igual a %f", PeloMenos2);




ValorEsperado = sum(Probs.*X);
Variancia = sum((X.^2).*Probs) - ValorEsperado^2;
DesvioPadrao = sqrt(Variancia);

fprintf("\nD)-- E[X] = %f", ValorEsperado);
fprintf("\nD)-- Var[X] = %f", Variancia);
fprintf("\nD)-- DesvioPadrao = %f", DesvioPadrao);




