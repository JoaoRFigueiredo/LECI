function [p1 p2] = dardos2(n, m, N);

alvos = randi([1, m], n, N);
umaVez = 0;
for i=1:N
    if(length(unique(alvos(:, i))) == n)
        umaVez = umaVez +1;
    end
 
        
end
p1 = umaVez/N;
p2 = 1 -p1;
end