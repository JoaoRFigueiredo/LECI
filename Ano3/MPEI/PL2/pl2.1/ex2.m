%% Considere o seguinte “jogo”: lanc¸amento com os olhos vendados de n dardos, um de cada vez, para m
% alvos, garantindo-se que cada dardo atinge sempre um alvo (e apenas 1).

%% a)Estime por simulac¸ao a probabilidade de nenhum alvo ter sido atingido mais do que uma vez ˜
%quando n = 20 dardos e m = 100 alvos.
 n = 20; % nº de dardos
 m = 100; % nªde alvos
 N= 1e5; %nu´mero de experieˆncias

 [p1 p2] = dardos2(n, m, N);
 p1
 p2
 
 %b)Estime por simulac¸ao a probabilidade de pelo menos 1 alvo ter sido atingido 2 ou mais vezes ˜
%quando n = 20 dardos e m = 100 alvos.



%c)Considere os valores de m = 1000 e m = 100000 alvos. Para cada um destes valores, fac¸a as
%simulac¸oes necess ˜ arias para desenhar um gr ´ afico (usando a func¸ ´ ao˜ plot do Matlab) da probabilidade
%da alinea (b) em func¸ao do n ˜ umero de dardos ´ n. Considere n de 10 a 100 com incrementos de 10.
%Os 2 graficos devem ser sub-gr ´ aficos de uma mesma figura (use a instruc¸ ´ ao˜ subplot do Matlab).
%Compare os resultados dos 2 casos e retire conclusoes.


%para m = 1000
N = 1e5;
m = 1e3;
nValues = 1:10;
probs = zeros(1, 10);

for n = 1 : 10
    
    [pa pb] = dardos2(n*10, m, N);% Columns have the number of the target the darts hit
    
    
    
    probs(n) = pb;
end

figure
subplot(1,2,1)
plot(nValues*10, probs)

xlabel('n')
ylabel('P(n)')
title('Probabilities for m = 1000')


%para m = 100000
N = 1e5;
m = 1e5;
nValues = 1:10;
probs = zeros(1, 10);

for n = 1 : 10
    
    [pa pb] = dardos2(n*10, m, N);% Columns have the number of the target the darts hit
    
    
    
    probs(n) = pb;
end


subplot(2,2,2)
plot(nValues*10, probs)

xlabel('n')
ylabel('P(n)')
title('Probabilities for m = 100000')


 
  