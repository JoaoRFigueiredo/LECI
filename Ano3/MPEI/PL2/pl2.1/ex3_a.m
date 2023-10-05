N = 1e5; %numero de experiencias
n = 10; %numero de keys
m = 1000; %tamanho do array
hash = m-1; %numero de maximo do hash


experience = randi([0 hash], n, N);
sucessos = 0;

for i=1 : N
    if(length(unique(experience(:, i))) < n)
        sucessos = sucessos +1;
    end
end

fprintf("3a) %f", sucessos/N);



