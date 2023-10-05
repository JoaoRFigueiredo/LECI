%%Usando a matriz H das hyperligac¸oes, obtenha a estimativa do pagerank de cada p ˜ agina ao fim de ´
%10 iterac¸oes. Relembre que deve considerar (i) a mesma probabilidade de transic¸ ˜ ao de cada p ˜ agina ´
%para todas as paginas seguintes poss ´ ´ıveis e (ii) a probabilidade da pagina inicial deve ser igual para ´
%todas as paginas. Qual/quais a(s) p ´ agina(s) com maior pagerank e qual o seu valor ´?
%%
%   A   B   C   D   E   F
%A  0   0   0   0   1/3 0
%B  1   0   0   0   1/3 0
%C  0   0.5 0   1   0   0
%D  0   0   1   0   0   0
%E  0   0.5 0   0   0   0
%F  0   0   0   0   1/3 0



Matriz = [0, 0, 0, 0, 1/3, 0;
          1, 0, 0, 0, 1/3, 0;
          0, 0.5, 0, 1, 0, 0;
          0, 0, 1, 0,   0, 0;
          0, 0.5, 0, 0, 0, 0;
          0, 0, 0, 0, 1/3, 0];
           
      
Vetor = [1/6; 1/6; 1/6; 1/6; 1/6; 1/6];

%a)Usando a matriz H das hyperligac¸oes, obtenha a estimativa do pagerank de cada p ˜ agina ao fim de ´
%10 iterac¸oes.


for i =1:10
    Vetor = Matriz*Vetor;
end

Apos10 = Vetor

%b) Identificar "spider-trap" e a "dead-end" neste esquema

fprintf("\nSpider-trap ---> Estados C e D");
fprintf("\nDead-end --> Estado F");

%c)Altere a matriz H para resolver apenas o problema do ”dead-end”e recalcule o pagerank de cada
%pagina novamente em 10 iterac¸ ´ oes.

MatrizAjustada = [0, 0, 0, 0, 1/3, 1/6;
          1, 0, 0, 0, 1/3, 1/6;
          0, 0.5, 0, 1, 0, 1/6;
          0, 0, 1, 0, 0, 1/6;
          0, 0.5, 0, 0, 0, 1/6;
          0, 0, 0, 0, 1/3, 1/6];
      
 Vetor = [1/6; 1/6; 1/6; 1/6; 1/6; 1/6];
 
 for i =1:10
     Vetor = MatrizAjustada*Vetor;
 end
 it10 = Vetor
 
 %d)Resolva agora ambos os problemas e recalcule o pagerank de cada pagina novamente em 10 ´
%iterac¸oes (assuma ˜ β = 0, 8).

b = 0.8;

%Aplicar metodo da google e resolver spider-traps
A = b * Matriz + (1-b) * ones(6)/6;

%Agora calcular o pagerank de cada pagina apos 10 iteraçoes

Vetor = [1/6; 1/6; 1/6; 1/6; 1/6; 1/6];
 
 for i =1:10
     Vetor = A*Vetor;
 end
 AlineaD = Vetor


%e)Calcule agora o pagerank de cada pagina considerando um n ´ umero m ´ ´ınimo de iterac¸oes que garanta ˜
%que nenhum valor muda mais do que 10−4
%em 2 iterac¸oes consecutivas. Quantos iterac¸ ˜ oes s ˜ ao˜
%necessarias? Compare os valores de pagerank obtidos com os da al ´ ´ınea anterior. O que conclui?
Vetor = [1/6; 1/6; 1/6; 1/6; 1/6; 1/6];

M = cell(100, 1);
for i =1:100
    Vetor = A*Vetor;
    M{i} = Vetor;
end

for i=1:98
    B = M{i}
    C = M{i+1}
    D = abs(C-B);
    E = D>10e-4;
    
    if (sum(sum(E)) >= 1)
        break;
    end
end
fprintf("%f", i);


