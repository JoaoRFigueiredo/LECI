%%Considere a variavel aleat ´ oria ´ X correspondente a face que fica para cima no lanc¸amento de 1 dado. `
%Usando os valores teoricos: 

%a)Considere a variavel aleat ´ oria ´ X correspondente a face que fica para cima no lanc¸amento de 1 dado. `
%Usando os valores teoricos: 

x = [1, 2, 3, 4, 5, 6];
px =[1/6, 1/6, 1/6, 1/6, 1/6, 1/6];
figure
stem(x, px);
xlabel("Valor de x");
ylabel("Px");

%b)num segundo grafico da mesma figura, desenhe o gr ´ afico da func¸ ´ ao de distribuic¸ ˜ ao acumulada (use ˜
%a func¸ao˜ stairs do Matlab).
figure
b = cumsum(px);
stairs(x, b)