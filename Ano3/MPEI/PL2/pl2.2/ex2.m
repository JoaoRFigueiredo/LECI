%%Considere uma caixa contendo 90 notas de 5 Euros, 9 notas de 50 e 1 de 100.

%a)Descreva o espac¸o de amostragem da experiencia aleat ˆ oria, retirar uma nota da caixa, e as proba- ´
%bilidades dos acontecimentos elementares.


%O espaço de amostragem é constituído por 100 elementos, as notas acima
%referidas

notas5 = 90;
notas50 = 9;
notas100 = 1;


prob5 =90/100;
prob50 = 9/100;
prob100 = 1/100;

%b)Descrever o espaço de amostragem e a função massa de probabilidade

%Nesta situação, o espaço de amostragem é constituído por 3 notas, 5 euros,
%50 euros, 100 euros

x =[5 50 100];
probs = [prob5 prob50 prob100];

figure
stem(x, probs);
xlabel("Valor da nota");
ylabel("Probabilidade de retirar a nota");



%c)Determine a func¸ao distribuic¸ ˜ ao acumulada de ˜ X e efectue a sua representac¸ao gr ˜ afica em Matlab.

px = cumsum(probs);

figure
stairs(x, px);
xlabel("Valor da nota");
ylabel("Probabilidade de retirar a nota");



