%a)Defina, em Matlab, a matriz de transic¸ao de estados ˜ T assumindo p = 0, 4 e q = 0, 6.

p = 0.4;
q = 0.6;

%Matriz


%     A         B   C   D
%A    p^2       0   0   q^2
%B   (1-p)^2    0   0   q(1-q)
%C    p(1-p)    0   0   q(1-q)
%D    p(1-p)    1   1   (1-q)^2

Matriz =[p^2, 0, 0, q^2; 
        (1-p)^2, 0, 0, q*(1-q);
        p*(1-p), 0, 0, q*(1-q);
        p*(1-p), 1, 1, (1-q)^2];
    
   


%b)Assuma que o sistema se encontra inicialmente no estado A. Qual a probabilidade de estar em cada
%estado ao fim de 5 transic¸oes? E de 10 transic¸ ˜ oes? E de 100 transic¸ ˜ oes? E de 200 transic¸ ˜ oes? 

fprintf("b)-----------------------------");
transicoes = [5, 10, 100, 200];
vetor =[1; 0; 0; 0];

for i = 1:length(transicoes)
    n = transicoes(i);
    Probs = Matriz^n * vetor;
    fprintf("\n-----------------------------------------");
    fprintf("\nPara %d transiçoes: ", n);
    fprintf("\n-------------------------------------");
    fprintf("\nProbabilidade de estar em A --> %f", Probs(1));
    fprintf("\nProbabilidade de estar em B --> %f", Probs(2));
    fprintf("\nProbabilidade de estar em B --> %f", Probs(3));
    fprintf("\nProbabilidade de estar em D --> %f", Probs(4));
    fprintf("\n---------------------------------------");
    fprintf("\n");
end


%c)Determine as probabilidades limite de cada estado. Compare estes valores com os obtidos na al´ınea
%anterior. O que conclui?

