%Suponha que o numero de mensagens que chega a um servidor de ´ email segue uma lei de Poisson com
%media de 15 (mensagens por segundo). Calcule a probabilidade de num intervalo de um segundo: 
%%

%a)o servidor nao receber nenhuma mensagem;

%E[X] = np = 15  --> lambda;
%Var(X) = 15; 



%a)Aplicar a expressao de poisson

%Poisson(x) =  (((lambda)^x)*(exp(-(lambda))))/(factorial(k));

ProbPoisson0Mensagens = (((15)^0)*(exp(-(15))))/(factorial(0))

%b)o servidor receber mais de 10 mensagens.

%mais de 10, ou seja, k>10 --> muitos numeros, portanto vamos atraves do
%complementar

Complemento = 0;

for i = 0:10
    
    Complemento = Complemento + (((15)^i)*(exp(-(15))))/(factorial(i));
    
end

ProbMaisDe10 = 1-Complemento


