palavras = keys(6, 20);

tablesizes=[5e5, 1e6, 2e6];

[vetorA1, contagemA1, CollisionsA(1, 1), TimeA(1, 1)] = simulateChainHashTable(palavras, tablesizes(1), @string2hash, 'djb2');
[vetorA2, contagemA2, CollisionsA(2, 1), TimeA(2, 1)] = simulateChainHashTable(palavras, tablesizes(1), @string2hash, 'djb2');
[vetorA3, contagemA3, CollisionsA(3, 1), TimeA(3, 1)] = simulateChainHashTable(palavras, tablesizes(1), @string2hash, 'djb2');


[vetorB1, contagemB1, CollisionsB(1, 1), TimeB(1, 1)] = simulateChainHashTable(palavras, tablesizes(1), @string2hash, 'sdbm');
[vetorB2, contagemB2, CollisionsB(2, 1), TimeB(2, 1)] = simulateChainHashTable(palavras, tablesizes(1), @string2hash, 'sdbm');
[vetorB3, contagemB3, CollisionsB(3, 1), TimeB(3, 1)] = simulateChainHashTable(palavras, tablesizes(1), @string2hash, 'sdbm');

[vetorC1, contagemC1, CollisionsC(1, 1), TimeC(1, 1)] = simulateChainHashTable(palavras, tablesizes(1), @DJB31MA, 127);
[vetorC2, contagemC2, CollisionsC(2, 1), TimeC(2, 1)] = simulateChainHashTable(palavras, tablesizes(1), @DJB31MA, 127);
[vetorC3, contagemC3, CollisionsC(3, 1), TimeC(3, 1)] = simulateChainHashTable(palavras, tablesizes(1), @DJB31MA, 127);

[vetorD1, contagemD1, CollisionsD(1, 1), TimeD(1, 1)] = simulateChainHashTable(palavras, tablesizes(1), @hashstring, tablesizes(1));
[vetorD2, contagemD2, CollisionsD(2, 1), TimeD(2, 1)] = simulateChainHashTable(palavras, tablesizes(1), @hashstring, tablesizes(2));
[vetorD3, contagemD3, CollisionsD(3, 1), TimeD(3, 1)] = simulateChainHashTable(palavras, tablesizes(1), @hashstring, tablesizes(3));

fprintf("\nString2hash, djb2:");

for i=1:3
    fprintf("\nTablesize = %d, NºColisoes = %d, Tempo de execução = %f", tablesizes(i), CollisionsA(i, 1), TimeA(i, 1));
end

fprintf("\n\nString2hash, sdbm:");

for i=1:3
    fprintf("\nTablesize = %d, NºColisoes = %d, Tempo de execução = %f", tablesizes(i), CollisionsB(i, 1), TimeB(i, 1));
end

fprintf("\n\nDJB31MA:");

for i=1:3
    fprintf("\nTablesize = %d, NºColisoes = %d, Tempo de execução = %f", tablesizes(i), CollisionsC(i, 1), TimeC(i, 1));
end

fprintf("\n\nhashstring:");

for i=1:3
    fprintf("\nTablesize = %d, NºColisoes = %d, Tempo de execução = %f", tablesizes(i), CollisionsD(i, 1), TimeD(i, 1));
end