%%Considere que o tempo em cada dia e genericamente classificado num de 3 estados – sol, nuvens e chuva ´
%– e que o tempo num determinado dia apenas depende do tempo no dia anterior. Assuma que estamos
%no primeiro dia de janeiro e que as probabilidades de transic¸ao de estados s ˜ ao as da tabela seguinte.

%a)Defina, em Matlab, a correspondente matriz de transic¸ao.

%S - sol
%N - Nuvens
%C - chuva

%       S    N    C
%S      0.7  0.2  0.3
%N      0.2  0.3  0.3
%C      0.1  0.5  0.4


Matriz = [0.7, 0.2, 0.3;
          0.2, 0.3, 0.3;
          0.1, 0.5, 0.4];
    
 %b)Qual a probabilidade de estar sol no segundo dia e no terceiro dia de janeiro quando o primeiro dia
%e de sol?
sum(Matriz)
T2 = Matriz *[1; 0; 0]
T3 = Matriz^2 *[1; 0; 0]
fprintf("\nAlínea B)");
fprintf("\nProbabilidade de estar sol no segundo dia de janeiro é %1.3f", T2(1));
fprintf("\nProbabilidade de estar sol no terceiro dia de janeiro é igual a %1.4f", T3(1));



%c)Qual a probabilidade de nao chover nem no segundo dia nem no terceiro dia de janeiro quando o ˜
%primeiro dia e de sol?

fprintf("\n\nAlínea C)");
fprintf("\nProbabilidade de não chover no segundo dia de janeiro é 0.9");
fprintf("\nProbabilidade de não chover no terceiro dia de janeiro é igual a %1.4f", T3(1, 1)+T3(2, 1));
fprintf("\nProbabilidade de não chover nos dois dias é igual a %1.4f", T3(1)+T3(2)*0.9);


%d)Assumindo que o primeiro dia e de sol, determine o n ´ umero m ´ edio de dias de sol, de nuvens e de ´
%chuva que se espera ter em todo o mes de janeiro.

vetor = [1; 0; 0];
diasSol = vetor(1) + Matriz(1, 1);
diasNuvens = vetor(2)+ Matriz(2, 1);
diasChuva = vetor(3) + Matriz(3, 1);

for i = 2:30
   X = Matriz^i * vetor;
    diasSol = diasSol+ X(1) ;
    diasNuvens = diasNuvens+ X(2) ;
    diasChuva = diasChuva + X(3) ;
end

fprintf("\n\nAlínea D)");
fprintf("\nTeremos em média os seguintes números de dias de sol, nuvens e chuva para o mes de janeiro: ");
fprintf("\nDe sol : %.4f", diasSol);
fprintf("\nDe nuvens : %.4f", diasNuvens);
fprintf("\nDe Chuva : %.4f", diasChuva);

totalD = (diasSol + diasNuvens + diasChuva);




%e)Assumindo que o primeiro dia e de chuva, determine o n ´ umero m ´ edio de dias de sol, de nuvens e ´
%de chuva que se espera ter em todo o mes de janeiro. Compare estes resultados com os da al ˆ ´ınea
%anterior. O que conclui?
vetor = [0; 0; 1];
diasSol = vetor(1) + Matriz(1, 1);
diasNuvens = vetor(2)+ Matriz(2, 1);
diasChuva = vetor(3) + Matriz(3, 1);

for i = 2:30
   X = Matriz^i * vetor;
    diasSol = diasSol+ X(1) ;
    diasNuvens = diasNuvens+ X(2) ;
    diasChuva = diasChuva + X(3) ;
end
fprintf("\n");
fprintf("\nAlínea E)");
fprintf("\nTeremos em média os seguintes números de dias de sol, nuvens e chuva para o mes de janeiro: ");
fprintf("\nDe sol : %.4f", diasSol);
fprintf("\nDe nuvens : %.4f", diasNuvens);
fprintf("\nDe Chuva : %.4f", diasChuva);

totalE = (diasSol + diasNuvens + diasChuva);


%f) Considere uma pessoa com reumatismo cronico que tem dores reum ´ aticas com probabilidades de ´
%10%, 30% e 50% quando os dias sao de sol, de nuvens ou de chuva, respetivamente. Qual o n ˜ umero ´
%esperado de dias que a pessoa vai sofrer de dores reumaticas em janeiro quando o primeiro dia ´ e de ´
%sol? E quando o primeiro dia e de chuva? 

fprintf("\n\nAlínea F)");
fprintf("\nDe acordo com o tempo no primeiro dia temos a seguinte quantidade de dores: ");

doresSol = 0.1;
doresNuvens = 0.3;
doresChuva = 0.5;

vetor1 = [1; 0; 0];
vetor2 = [0; 1; 0];
vetor3 = [0; 0; 1];

diasSol = vetor(1) + Matriz(1, 1);
diasNuvens = vetor(2)+ Matriz(2, 1);
diasChuva = vetor(3) + Matriz(3, 1);

dores = zeros(3, 1);

for k =1:3
for i = 2:30
   
    diasSol = diasSol+ X(1) ;
    diasNuvens = diasNuvens+ X(2) ;
    diasChuva = diasChuva + X(3) ;
    
end
dores(k) = dores(k) + diasSol*0.1 + diasNuvens*0.3 + diasChuva*0.5;
end

fprintf("\nEstado do tempo  |    Total de dores");
fprintf("\n--------------------------------------");
fprintf("\n    Sol          |     %f", dores(1));  
fprintf("\n    Nuvens       |     %f", dores(2));
fprintf("\n    Chuva        |     %f", dores(3));



