H = [0, 0, 0, 0, 1/4, 0;
     1/4, 0, 1, 0, 1/4, 0;
     0, 1/2, 0, 1, 0, 0;
     1/4, 1/2, 0, 0, 1/4, 0;
     1/4, 0, 0, 0, 0, 0;
     1/4, 0, 0, 0, 1/4, 0];
sum(H)

vetor =[1/6; 1/6; 1/6; 1/6; 1/6; 1/6];

for i =1:3
    vetor = H *vetor;
    
end

iteracoes3 =vetor

vetor1 =[1/6; 1/6; 1/6; 1/6; 1/6; 1/6];

for i =1:100
    vetor1 = H*vetor1;
end

iteracoes100 = vetor1

%d)

b = 0.8;
A = b*H + (1-b)*ones(6)/6
r = [1/6; 1/6; 1/6; 1/6; 1/6; 1/6];

pagerank = A*r

