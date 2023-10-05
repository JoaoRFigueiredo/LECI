%A  S   O   C   F


T = [0, 1/3, 0, 1/2, 0;
     1/3, 0, 1/3, 0, 0;
     0, 1/3, 0, 1/2, 0;
     1/3, 0, 1/3, 0, 0;
     1/3, 1/3, 1/3, 0, 1];
 sum(T);
 
 %c)
 
 n =randi(4);
 letras ='ASOC';
 p = Crawl(T, n, 5);
 p1 = p(1:length(p)-1);
 palavra = letras(p1);
 
 %e)
 
 N = 10e5;
 M = cell(N, 1);
 for i =1:N
      p = Crawl(T, n, 5);
 p1 = p(1:length(p)-1);
 palavra = letras(p1);
     
     
     M{i} = palavra;
     
 end 
 
 palavrasDiferentes = length(unique(M));
 K = unique(M);
 
 J = cell(palavrasDiferentes, 2);
[uc, ~, idc] = unique(M);
 counts = accumarray(idc,ones(size(idc)))  ; 
 
 for i=1:palavrasDiferentes
    J(i,1)=K(i);               %1ª coluna da cell --> palavra
    J(i,2)=num2cell(counts(i)); %2ª coluna da cell --> ocurrencias/contagem da palavra
end
 
 J = sortrows(J, 2);
for i =1:5
    disp(J(length(J)-(i-1), 1));
    fprintf("-------->");
 disp(J(length(J)-(i-1), 2));
end

for i =1:5
    prob = cell2mat(J(length(J)-(i-1), 2))/N;
    fprintf("\npalavra top %d, possui a probabilidade de %f", i, prob);
end

index = find(strcmp(J, 'CASO'))
 