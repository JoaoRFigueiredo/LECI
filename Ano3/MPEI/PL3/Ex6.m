%%Considere a cadeia de Markov com o diagrama de transic¸ao de estados seguinte:

%       1       2       3       4       5

%1      0.8     0       0       0.3     0

%2      0.2     0.6     0       0.2     0

%3      0       0.3     1       0       0

%4      0       0.1     0       0.4     0

%5      0       0       0       0.1     1

Matriz = [0.8, 0,   0, 0.3, 0;
          0.2, 0.6, 0, 0.2, 0;
          0,   0.3, 1, 0,   0;
          0,   0.1, 0, 0.4, 0;
          0,   0,   0, 0.1, 1];
     
      
if (sum(sum(Matriz)) == 5)
    fprintf("\nA matriz é estocástica!");
end


%b)Fac¸a um grafico com a probabilidade de, comec¸ando no estado 1, estar no estado 2 ao fim de ´ n
%passos, com n a variar de 1 ate 100. Justifique o que observa

vetor = [1; 0; 0; 0; 0];

probs = zeros(100, 1);
for n = 1:100
    T = Matriz^n * vetor;
    probs(n) = T(2);
end

figure
plot(1:100, probs);
xlabel("Nº de transições");
ylabel("Probabilidade de estar do estado 2");
title("Probabilidade de transitar dos estado 1 para o 2 de acordo com o número de transições");

%c)Fac¸a um grafico com a probabilidade de, comec¸ando no estado 1, estar no estado 3 ao fim de ´ n
%passos. Na mesma figura, fac¸a um segundo grafico com a probabilidade de, comec¸ando no estado ´
%1, estar no estado 5 ao fim de n passos. Em ambos os casos, considere n a variar de 1 ate 100. ´
%Justifique o que observa.


probs3 = zeros(100, 1);
probs5 = zeros(100, 1);
for n = 1:100
    T = Matriz^n * vetor;
    probs3(n) = T(3);
    probs5(n) = T(5);
end

figure
plot(1:100, probs3, 1:100, probs5);
xlabel("Nº de transições");
ylabel("Probabilidade de transitar");
title("Probabilidades de transitar do estado 1 para o 3 ou 5 após n transições");
legend("Estado 1 --> Estado 3", "Estado 1 --> Estado 5");


%d) Determine a matriz Q.

C = [0.8, 0,   0.3, 0, 0;
    0.2,  0.6, 0.2, 0, 0;
    0,    0.1, 0.4, 0, 0;
    0,    0.3, 0,   1, 0;
    0,    0,   0.1, 0, 1];

Q = C(1:3, 1:3);
R = C(4:5, 1:3);
 

 
 
 %e)Determine a matriz fundamental F
 
 I = eye(3);
 F = (I-Q)^-1
 
 %f)Qual a media (valor esperado) do n ´ umero de passos at ´ e´ a absorc¸ ` ao comec¸ando no estado 1? E ˜
%comec¸ando no estado 2? E se comec¸ando no estado 4?

t = F'*ones(3, 1)

%g) Comec¸ando no estado 1, qual e a probabilidade de absorc¸ ´ ao do estado 3? E do estado 5? Verifique ˜
%a coerencia destes valores com o que observou na al ˆ ´ınea 6c).

B = R*F
