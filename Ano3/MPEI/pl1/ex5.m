%5)

%% Codigo 2- ca´lculo analı´tico de probabilidade em se´ries experieˆncias de Bernoulli
% Dados relativos ao problema 1
p = 0.5;
k = 2;
n = 3;
probEx1 = nchoosek(n,k)*p^k*(1-p)^(n-k); % nchoosek(n,k)= n!/(n-k)!/k!

%% 6 caras em 15 lançamentos
prob6em15 = probT(0.5, 6, 15)

%% Pelo menos 6 caras em 15 lançamentos
Prob = 0;
for i =6:15
num = probT(0.5, i, 15)

Prob = Prob + num;
end
fprintf("Prob = %f", Prob);



function probT = probT(p, k, n)%p= probabilidade de cara / k = numero de caras / n= numero de lançamentos
    probT = nchoosek(n,k)*p^k*(1-p)^(n-k);
end