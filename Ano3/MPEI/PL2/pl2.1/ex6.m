N = 1e5;
%a)

sequences = randi(3, 2, N);
sucessos = 0;
for i =1:N
    if(sequences(1, i) == 1 && sequences(2, i) == 2)
        sucessos = sucessos +1;
    end
end

probA = sucessos /N


%b)

sucessos = 0;
for i =1:N
    if(sequences(1, i) == 1 || sequences(2, i) == 1)
        sucessos = sucessos +1;
    end
end

probB = sucessos /N


%c)
sucessos = 0;
for i =1:N
    if(sequences(1, i) == 1 || sequences(2, i) == 1 || sequences(1, i) == 2 || sequences(2, i) == 2)
        sucessos = sucessos +1;
    end
end

prbC = sucessos/N

%d)

ambos = 0;
incluiDois = 0;
for i =1:N
    if((sequences(1, i) == 1 && sequences(2, i) == 2) || (sequences(1, i) == 2 && sequences(2, i) == 1))
        ambos = ambos +1;
    end
    
    if(sequences(1, i) == 2 || sequences(2, i) == 2)
        incluiDois = incluiDois +1;
    end
    
    
end


ambos/N
incluiDois
prbC = (ambos/N)/(incluiDois/N)



