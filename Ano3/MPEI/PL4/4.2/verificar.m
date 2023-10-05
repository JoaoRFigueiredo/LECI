function Verify = verificar(BloomFilter, elemento, k)
n = length(BloomFilter);
Verify = true;
for i=1:k
    
   elemento = [elemento num2str(i)];
    h=DJB31MA(elemento, 127);
    h = mod(h, n) +1;
    if BloomFilter(h) == 0
        Verify = false;
        break;
    end
    
    
    
end
    
end