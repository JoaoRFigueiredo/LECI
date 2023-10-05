%%Considere a seguinte situacao e responda as alıneas abaixo:
%Um aluno do primeiro ano de um curso de Engenharia tem todas as semanas 2 aulas Teorico-Praticas de 
%uma Unidade Curricular X as 9:00,  as quartas e sextas. `
%Todos os dias que tem aulas desta UC, o aluno decide se vai a aula ou n ` ao da seguinte forma: Se tiver ˜
%estado presente na aula anterior a probabilidade de ir a aula ` e 70%; se faltou ´ a anterior, a probabilidade `
%de ir e 80%.

%(a) Se estiver presente na aula de quarta numa determinada semana, qual a probabilidade de estar
%presente na aula de quarta da semana seguinte?
%Sugestao: Comece por definir a matriz de transicao de estados e o vetor estado correspondentes.

%A-- ir à aula
%B-- não ir à aula

%Matriz Transição de estados
%    A        B
%A   0.7      0.8
%B   0.3      0.2

Matriz = [0.7, 0.8; 0.3, 0.2];
vetor = [1; 0];

%vetor -->Não faltar  1
%         Faltar      0

ProximaSemana = (Matriz^2) * vetor;

fprintf("Alínea A --------------------");
fprintf("\nProbabilidade de não faltar à aula da próxima quarta-feira, sendo que não faltou na quarta anterior, é igual a %f", ProximaSemana(1, 1)); 

%b)Se nao estiver presente na aula de quarta numa determinada semana, qual a probabilidade de estar ˜
%presente na aula de quarta da semana seguinte?
vetor = [0; 1];
ProximaSemana = (Matriz^2) * vetor;
fprintf("\n");
fprintf("\nAlínea B--------------------");
fprintf("\nProbabilidade de não faltar à aula da próxima quarta-feira, sendo que faltou na quarta anterior, é igual a %f", ProximaSemana(1, 1)); 


%c)Sabendo que esteve presente na primeira aula, qual a probabilidade de estar na ultima aula, assu- ´
%mindo que o semestre tem exactamente 15 semanas de aulas e nao existem feriados? 

UltimaAula = Matriz^29 *[1; 0];
fprintf("\n\nAlínea C)-----------------");
fprintf("\nProbabilidade de estar presente na última aula, sendo que foi à primeira, é igual a %f", UltimaAula(1, 1));

%d)Represente num grafico a probabilidade de faltar a cada uma das 30 aulas, assumindo que a proba- ´
%bilidade de estar presente na primeira aula e de 85%.

vetor = [0.85; 0.15];
probs = zeros(1, 30);
Aula = 1:30;
for i =1:30
    proximaAula = Matriz^(i-1) * vetor;
    probs(i) = proximaAula(2);
end

figure
plot(Aula, probs);
xlabel("Ordem das aulas");
ylabel("Probabilidade de não faltar");
title("Probabilidade de não faltar em relação a cada aula");







