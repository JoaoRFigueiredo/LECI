function [hCodes, contagem, Collisions, Time] = simulateChainHashTable(words, tablesize, func, arg)

%words --> cell array
%tablesize --> tamanho da hash table
%HashFunction --> função de dispersão a usar
%agr --> 2º argumento da função de dispersão


tic
key = words{1};
hash = mod(func(key, arg), tablesize);
hCodes(1) = hash;
contagem = zeros(tablesize, 1);

for i =2:length(words)
    key = words{i};
    hash = mod(func(key, arg), tablesize)+1;
    if ~ismember(hash, hCodes)
      hCodes = [hCodes; hash];
    end
    
    contagem(hash) = contagem(hash) +1; % contar a quantidade de hash atribuidos a cada posiçao do array
    
end

Collisions = (sum(contagem > 1));
Time = toc;
end



    
    



