
%a)
%palavras = keys(6, 20);

%b)

fileID = fopen("prob_pt.txt", 'r');
formatSpec = '%f';
A = fscanf(fileID, formatSpec); %devolve um vetor com todos os valores do ficheiro
Probabilidades =cumsum(A);  %função de probabilidade acumulada das probabilidades obtidas anteriormente
palavras = keys(6, 20, Probabilidades);





    