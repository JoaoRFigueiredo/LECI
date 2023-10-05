m = 1e6;
n = 5;
A = rand(n, m) < 0.002;
xi =0:5

x0 = sum(sum(A)== 0);
x1 = sum(sum(A)== 1);
x2 = sum(sum(A)== 2);
x3 = sum(sum(A)== 3);
x4 = sum(sum(A)== 4);
x5 = sum(sum(A)== 5);

X = [x0 x1 x2 x3 x4 x5];
Px = X/m

%%valor esperado
E = sum(xi.*Px)

%% variancia
var = sum((xi.^2).*Px) - E^2
%%desvio

desvio = sqrt(var);

%%valores teoricos

100^2*var;
desvio100 = sqrt(var);

%%$cada 5 linhas representam as peças dentro das caixas e para simular 100
%%caixas, corremos um loop 100 vezes
E100 = 0;
var=0;
for i=1:100
m = 1e5;
n = 5;
A = rand(n, m) < 0.002;
xi =0:5;

x0 = sum(sum(A)== 0);
x1 = sum(sum(A)== 1);
x2 = sum(sum(A)== 2);
x3 = sum(sum(A)== 3);
x4 = sum(sum(A)== 4);
x5 = sum(sum(A)== 5);

X = [x0 x1 x2 x3 x4 x5];
Px = X/m;

%%valor esperado
E100 = E100 + sum(xi.*Px);

%var(100X) = var(x)
end
E100
var = sum((xi.^2).*Px) - (E)^2
desvio = sqrt(var)


