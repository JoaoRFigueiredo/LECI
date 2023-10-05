N = 1e5; %numero de experiencias
n = 50; %numero de keys
m = 100; %tamanho do array
NValues = 1:10;
probs = zeros(1, 10);
sizes = 10:10:100;

for g =1 :10
m = m*g;
hash = m-1;
experience = randi([0 hash], n, N);
sucessos = 0;

for i=1 : N
    if(length(unique(experience(:, i))) < n)
        sucessos = sucessos +1;
    end
end
probs(g) = 1-(sucessos/N)
end

figure 
plot(sizes*10,probs);

xlabel('Size of the array')
ylabel('Probability)')
title('Probabilities of no collisions with 50 keys according to arrays size')
