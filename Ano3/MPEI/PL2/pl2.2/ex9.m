%Considerando a variavel aleatoria  X, representativa das classificacoes dos alunos de um determinado 
%curso, contínua e com distribuic¸ao normal  (media = 14 e desvio padrao = 2), obtenha atraves de simulacao
%uma estimativa para as probabilidades de:
%%

%E[X] = 14
%Var(x) = (Desviao Padrao)^2
%Desvio Padrao = 2 // desvio padrao = sqrt(variancia)


%a)um aluno do curso ter uma classificacao entre  12 e 16;

%randn --> media = 0 e desvio padrao = 1;

%Caso tenhamos media = x e desvio padrao = y, usaremos o randn da seginte
%forma: randn(1, N).*y +x; onde N = numero de experiencias

%entre 12 e 16 --> {12, 13, 14, 15, 16}
N = 1e5;

notas14 = randn(1, N).*2 + 14;
% mean(notas14A)
% std(notas14A)
ProbA = sum(notas14 >= 12)/N - sum(notas14 >16)/N;
fprintf("\nProbabilidade de ter uma nota entre 12 e 16 é igual a %f", ProbA);

%b)os alunos terem classificac¸oes entre 10 e 18;
notas14 = randn(1, N).*2 + 14;
ProbB = sum(notas14 >= 10)/N - sum(notas14 >18)/N;
fprintf("\nProbabilidade de obter uma nota entre 10 e 18 é igual a %f", ProbB);

%c)um aluno passar (ter classificac¸ao maior ou igual a 10);


ProbC = sum(notas14 >= 10)/N;
fprintf("\nProbabilidade de passar é igual a %f", ProbC);

%(d) verifique a correc¸ao dos resultados anteriores usando a func¸ ˜ ao Matlab ˜ normcdf().

X = normcdf([10 20], 14, 2);
X(2) - X(1)












