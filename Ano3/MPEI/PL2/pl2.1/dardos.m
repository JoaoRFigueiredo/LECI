

%n = numero de dardos // m = numero de alvos // N = numero de experiencias
%p1 = probabilidade de have pelo menos um alvo que foi atingido 2 ou mais
%vezes
function p1 = dardos(n, m, N);

alvos = randi([1, m], n, N);
umaVez = 0;
for i=1:N
    if(length(unique(alvos(:, i))) == n)
        umaVez = umaVez +1;
    end
 
        
end
p1 = umaVez/N;
end