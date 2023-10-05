m= 1e5;
n = 10;
experiencia = (randi([1, 50], n, m)) ;

experiencia = experiencia <9;
sum(sum(experiencia)==3)/m