%%) Complete o diagrama de estados abaixo (incompleto!...) relativo a cadeia de Markov correspon- `
%dente indicando todos os estados e transic¸oes poss ˜ ´ıveis segundo o enunciado. Crie em Matlab a
%matriz de transic¸ao de estados ( ˜ T) correspondente.
%%
%   9   1   3   3   5   9   fim

%9  0   0   0   0   0   0   0
%1  0.5 0   0   0   0   0   0
%3  0.5 0   0   0   0   0   0
%3  0   1/3 0   0.2 0.1 0   0
%5  0   1/3 0.6 0.5 0.4 0.3 0  
%9  0   1/3 0.4 0   0.3 0.3 0
%F  0   0   0   0.3 0.2 0.4 0

matriz = [0,   0,   0,   0,   0,   0,   0;
          0.5, 0,   0,   0,   0,   0,   0;
          0.5, 0,   0,   0,   0,   0,   0;
          0,   1/3, 0,   0.2, 0.1, 0,   0;
          0,   1/3, 0.6, 0.5, 0.4, 0.3, 0;
          0,   1/3, 0.4, 0,   0.3, 0.3, 0;
          0,   0,   0,   0.3, 0.2, 0.4, 1];
      
verifiy =sum(matriz)

      
%b)Qual a probabilidade de uma sequencia de ˆ 7 d´ıgitos iniciada por 91 e terminada em 9 ?

t5 = matriz^5;

prob9 = 0.5* t5(6, 2) * 0.4





%c)Qual a probabilidade de sequencias de 7 dıgitos iniciadas por 91 ?
t6 = matriz^6;
prob = t6(7, 2)*0.5

    


    
    
