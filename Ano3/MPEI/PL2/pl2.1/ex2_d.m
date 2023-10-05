


N = 1e5;
m = [200 500 1000 2000 5000 10000 20000 50000 100000];
n = 100;
nValues = 1:10;
probs = zeros(1, length(m));

for i = 1 : length(m)
    
    [pa pb] = dardos2(n, m(i), N);% Columns have the number of the target the darts hit
    
    
    
    probs(i) = pb;
end

figure 
plot(m,probs);

xlabel('m')
ylabel('P(n)')
title('Probabilities for n = 100')