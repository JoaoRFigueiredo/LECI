%Assumindo que o numero de erros tipogr ´ aficos numa p ´ agina de um livro tem uma distribuic¸ ´ ao de Poisson ˜
%com λ = 0.02, calcule a probabilidade de que exista no maximo 1 erro num livro de 100 p ´ aginas. ´
%Considere que o numero de erros em cada p ´ agina ´ e independente do n ´ umero de erros nas outras p ´ aginas
%%

lambda = 0.02; % lambda = n*p // 1 pagina

lambda100 = lambda *100;

%ProbPoisson = ((lambda^k)*exp(-lambda))/(factorial(k));

Maximo1Erro = ((lambda100^0)*exp(-lambda100))/(factorial(0)) +((lambda100^1)*exp(-lambda100))/(factorial(1))
