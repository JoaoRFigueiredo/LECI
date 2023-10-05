%ex5
size = 8000;

m = 1000;
Fp = zeros(1, 7);

for k=4:10
    words = keys(6, 20, m, (['a':'z']));
    words10000 = keys(6, 20, 10000, (['A':'Z']));
    
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



%ex 3 e 4
contador = 0;   %contador para o nº de falsos positivos

for i =1:length(words10000)
    verify = verificar(B, words10000{i}, k);
    if verify == true
       contador = contador +1;
    end
end

Fp(k-3) = contador/100;
    
end

k=4:10;
figure
plot(k, Fp);
xlabel("k-Nº de funções");
ylabel("Falsos positivos obtidos(Percentual)")
title("Falsos positivos obtidos em relaçáo ao k");
