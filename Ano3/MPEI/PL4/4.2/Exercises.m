size = 8000;
k = 3;
m = 1000;
words = keys(6, 20, m, (['a':'z']));
words10000 = keys(6, 20, 10000, (['A':'Z']));

%ex1
B = Inicializar(size);

for i =1:length(words)
    B = inserir(B, words{i}, k);
end
falseNegative = 0;
for i =1:length(words)
    verify = verificar(B, words{i}, k);
    if verify == false
        falseNegative = falseNegative +1;
        fprintf("\n%s não está no bloom filter", words{i});
    end
end

%ex 2
fprintf("\nNúmero de falsos negativos: %d", falseNegative);

%ex 3 e 4
contador = 0;   %contador para o nº de falsos positivos

for i =1:length(words10000)
    verify = verificar(B, words10000{i}, k);
    if verify == true
       contador = contador +1;
    end
end

fprintf("\nPercentagem de falsos positivos é igual a %.3f", contador/100);

FPTeorica = (1-exp(-k*m/size))^k;
fprintf("\nProbabilidade teórica de falsos positivos é igual a %.3f ", 100*FPTeorica );


