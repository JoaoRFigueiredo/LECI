%%Gere aleatoriamente uma matriz de transic¸ao de estados para uma cadeia de 20 estados (identificados de ˜
%1 a 20) recorrendo a func¸ ` ao do Matlab ˜ rand. Com base nessa matriz:

%a)Confirme que a matriz de transic¸ao de estados ˜ e estoc ´ astica.

Matriz = rand(20);
total = sum(Matriz);
for i = 1:20
    for k =1:20
    NovaMatriz(k, i) = Matriz(k, i) / total(i);
    end
end
%sum(NovaMatriz)

if(sum(sum(NovaMatriz)) == 20)
    fprintf("\nA matriz é escotástica");
    
else
    fprintf("\nA matriz não é estocástica");
end

%b)Qual a probabilidade de o sistema, comec¸ando no estado 1, estar no estado 20 apos 2 transic¸ ´ oes? E ˜
%apos 5? E ap ´ os 10? E ap ´ os 100? Apresente os resultados em percentagem e com 5 casas decimais. ´
%O que conclui?
vetor = zeros(20, 1);
vetor(1, 1) = 1;
transicoes = [5, 10, 20, 100];


for k =1:length(transicoes)
    
    n = transicoes(k);
    AposXTransicoes = NovaMatriz^n * vetor;
    fprintf("\nProbabilidade de estar no estado 20 após %d transicoes é igual a %f", transicoes(k), AposXTransicoes(20));
    fprintf("\n----------------------");
end

