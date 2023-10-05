function BF = inserir(BF, elemento, k)

%BloomFilter = filtro de bloom
%elemento = elemento a inserir
%k = nº de funções de dispersão

n = length(BF);

for i=1:k
    
    elemento= [elemento num2str(i)];
    h=DJB31MA(elemento, 127);
    h = mod(h, n) +1;
    BF(1, h) = 1;
end


end