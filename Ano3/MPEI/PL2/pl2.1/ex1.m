%Considere fam´ılias com filhos em que a probabilidade de nascimento de rapazes e igual ´ a de nascimento `
%de raparigas:

%Obtenha por simulac¸ao uma estimativa da probabilidade do acontecimento “ter pelo menos um ˜
%filho rapaz” em fam´ılias com 2 filhos.

N= 1e5; %nu´mero de experieˆncias
p = 0.5; %probabilidade de ser rapaz
k = 1; %nu´mero de rapazes
n = 2; %nu´mero de filhos
genero = rand(n,N) > p;
rapaz= sum(lancamentos)>=k;
probSimulacao= sum(sucessos)/N;
fprintf("Probabilidade de ter, pelo menos, um filho rapaz é de %f", probSimulacao);

%b)Determine o valor teorico do acontecimento da al ´ ´ınea anterior e compare-o com a estimativa obtida
%por simulac¸ao. Os valores s ˜ ao iguais? Porque
prob = nchoosek(n,k)*p^k*(1-p)^(n-k) +  nchoosek(n,2)*p^2*(1-p)^(n-2)
valorTeorico = 3/4;

%c)Suponha que para uma fam´ılia com 2 filhos escolhida ao acaso, sabemos que um dos filhos e´
%rapaz. Qual a probabilidade do outro filho ser tambem rapaz? Determine o valor te ´ orico desta ´
%probabilidade e estime a mesma probabilidade por simulac¸ao.

%A --> ter 2 rapazes
%B --> ter 1 rapaz
%P(A|B) = P(A & B) / P(B);
genero = rand(n,N) > p;
r1= sum(lancamentos)>= 1;
r2= sum(lancamentos)== 2;
PAB = r2/N;
PB = r1/N;
ProbSim = PAB/PB



pAB = 0.25;
pB = 0.75;

pAseB = (pAB / pB)

%d)Sabendo que o primeiro filho de uma fam´ılia com 2 filhos e rapaz, determine por simulac¸ ´ ao a ˜
%probabilidade do segundo filho ser rapaz. O que se pode concluir do resultado obtido relativamente
%a independ ` encia de acontecimentos?


%primeiro filho é rapaz
filhos = rand(n,N) < p;
rprimeiro = sum(sum(filhos(1, :)==1));
pB = rprimeiro /N

%2º filho é rapaz
rsegundo = sum(sum(filhos) == n);

probSim = rsegundo/rprimeiro

%A e B são acontecimentos independentes, visto que pa * pb = pab

%e)Considere uma fam´ılia com 5 filhos. Sabendo que pelo menos um dos filhos e rapaz, obtenha por ´
%simulac¸ao uma estimativa para a probabilidade de um dos outros (e apenas um) ser tamb ˜ em rapaz. 

N= 1e5; %nu´mero de experieˆncias
p = 0.5; %probabilidade de ser rapaz
k = 1; %nu´mero de rapazes
n = 5; %nu´mero de filhos
filhos = rand(n,N) > p;

r2 = sum(sum(filhos)==2);
peloMenos1 = sum(sum(filhos) >= 1);

probSimE = (r2/N)/(peloMenos1/N)


%Repita a al´ınea (e), mas estimando a probabilidade de pelo menos um dos outros ser tambem rapaz. 

%Seja B --> pelo menos 1 rapaz // A --> pelo menos um dos outros ser rapaz.
peloMenos2 = sum(sum(filhos)>=2);
peloMenos1 = sum(sum(filhos) >= 1);

probSimF = (peloMenos2/N)/(peloMenos1/N)



