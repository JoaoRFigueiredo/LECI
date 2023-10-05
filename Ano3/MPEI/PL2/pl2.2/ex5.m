%Suponha que o(s) motor(es) de um aviao pode(m) falhar com probabilidade ˜ p e que as falhas sao in- ˜
%dependentes entre motores. Suponha ainda que o aviao se despenha se mais de metade dos motores ˜
%falharem. Nestas condic¸oes, prefere voar num avi ˜ ao com ˜ 2 ou 4 motores? Utilize a distribuic¸ao que ˜
%considerar mais adequada
%%

N = 1e5; % numero de experiencias
ProbMotor = logspace(-3,log10(1/2),100);



for i = 1:100
    % 1 = motor falhou
   
     DoisMotores = rand(2, N) < ProbMotor(i);
     
     
     QuatroMotores = rand(4, N) < ProbMotor(i);
     
     ProbDespenho2(i) = (sum(sum(DoisMotores) == 2))/N;
     
     ProbDespenho4(i) = ((sum(sum(QuatroMotores) == 3))+(sum(sum(QuatroMotores) == 4)))/N;
    
end


 figure
 
 plot(ProbMotor, ProbDespenho2, ProbMotor, ProbDespenho4);
%  hold on
%  plot(ProbMotor, ProbDespenho4);
%  hold off
 legend({'2Motores','4Motores'});
 title("Probabilidade de despenho de acordo com o numero de motores e a probabilidade de falha no motor");
 xlabel("Probabilidade de falha num motor");
 ylabel("Probabilidade de Despenho");


