%%Considere a seguinte “danc¸a” de grupos: Divide-se uma turma em 3 grupos (A, B e C) no in´ıcio do
%semestre e no final de cada aula efectuam-se os seguintes movimentos:
%• 1/3 do grupo A vai para o grupo B e outro 1/3 do grupo A vai para o grupo C;
%• 1/4 do grupo B vai para A e 1/5 de B vai para C
%• Metade do grupo C vai para o grupo B; a outra mantem-se no grupo C.


%   A         B       C
%A  1/3       1/4     0
%B  1/3       11/20   1/2
%C  1/3       1/5     1/2

Matriz = [1/3, 1/4, 0; 1/3, 11/20, 1/2; 1/3, 1/5, 1/2];
verificar = sum(Matriz);
if(verificar == [1 1 1])
    fprintf("\na) A matriz é estocástica");
end

%Crie o vector relativo ao estado inicial considerando que no total temos 90 alunos, o grupo A tem
%o dobro da soma dos outros dois e os grupos B e C tem o mesmo n ˆ umero de alunos.

vetor = [60; 15 ; 15]; %[2*(2x); x; x]

%c)Quantos elementos integrarao cada grupo no fim da aula 30 considerando como estado inicial o ˜
%definido na al´ınea anterior?
fprintf("\n c)")
aula30 = round(Matriz^29 * vetor);
if (sum(aula30) == 90)
    fprintf("\nAlunos no grupo A = %d \nAlunos no grupo B = %d \nAlunos no grupo C = %d", aula30(1), aula30(2), aula30(3));
end

%Quantos elementos integrarao cada grupo no fim da aula 30 considerando que inicialmente se dis- ˜
%tribuiram os 90 alunos equitativamente pelos 3 grupos?

vetor = [30; 30; 30]; %[x; x; x]

fprintf("\n D)")
aula30 = round(Matriz^29 * vetor);
if (sum(aula30) == 90)
    fprintf("\nAlunos no grupo A = %d \nAlunos no grupo B = %d \nAlunos no grupo C = %d", aula30(1), aula30(2), aula30(3));
end
