%%Considere um processo de produc¸ao fabril que produz torneiras em que a probabilidade de cada torneira ˜
%%ser produzida com defeito e de 30%. No processo de controlo de qualidade, ´ e selecionada uma amostra ´
%%de 5 pec¸as.

%a) calculo analitico de 3 peças sairem defeituosas
ProbDefeitoTeorica = probT(0.3, 3, 5)

N= 1e5; %nu´mero de experieˆncias
p = 0.7; %probabilidade de cara
k = 3; %nu´mero de caras
n = 5; %nu´mero de lanc¸amentos
lancamentos = rand(n,N) > p;
sucessos= sum(lancamentos)==k;
probSimulacao= sum(sucessos)/N

%b)Calcule analiticamente e por simulacao a probabilidade de, no 
%máximo, 2 das pec¸as da amostra serem defeituosas
 ProbTeorica2  = 0;
for i =0:2
num = probT(0.3, i, 5);
ProbTeorica2 = ProbTeorica2 + num;
end
ProbTeorica2

N= 1e5; %nu´mero de experieˆncias
p = 0.3; %probabilidade de defeito
k = 2; %nu´mero de peças defeituosas
n = 5; %numero da amostra
lancamentos = rand(n,N) < p;
sucessos= sum(lancamentos)<=k;


%c)

for v = 1:6
x(v) = prob(1e5, v-1, 5);
end
figure(1);
bar(1:6,x, 'b')
figure(2)
hist(x);


function prob = prob(N, k, n) %N = numero de experiencias / k = numero de caras / n = numero de lançamentos
        lancamentos = rand(n, N) > 0.7;
        sucessos = sum(lancamentos) == k;
        prob = sum(sucessos)/N;
end


function probT = probT(p, k, n)%p= probabilidade de cara / k = numero de caras / n= numero de lançamentos
    probT = nchoosek(n,k)*p^k*(1-p)^(n-k);
end
