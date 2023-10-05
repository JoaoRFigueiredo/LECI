N = 1e5; %numero de experiencias
n = 10; %numero de keys
m = 1000; %tamanho do array
hash = m-1; %numero de maximo do hash

NValues =1:10;
probs = zeros(1, 10);

for g =1 :10
experience = randi([0 hash], n*g, N);
sucessos = 0;

for i=1 : N
    if(length(unique(experience(:, i))) < n*g)
        sucessos = sucessos +1;
    end
end
probs(g) = sucessos/N
end

figure 
plot(NValues*10,probs);

xlabel('number of keys')
ylabel('P(n)')
title('Probabilities of atleast one collision in an array with a size of 1000')