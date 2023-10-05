
%O Diretor da empresa seleciona de forma aleatoria um dos 100 programas produzidos pelos seus 3 ´
%programadores e descobre que este contem um erro s ´ erio. 
%%
%Programador Prob(“erro num programa”) programas
%Andre´         0.01                    20
%Bruno          0.05                    30
%Carlos         0.001                   50

%a)Probabilidade de o programa ser do Carlos?


N = 1e6;
p_erro_andre = 0.01;
p_erro_bruno = 0.05;
p_erro_carlos = 0.001;

p_carlos = 50/100;
p_andre = 20/100;
p_bruno = 30/100;


%probabilidade total, neste caso: p_erro = P(E|C) * P(C) +P(E|B) * P(B) + P(E|A) * P(A) 
p_erro = p_erro_andre * p_andre + p_erro_bruno * p_bruno + p_erro_carlos * p_carlos;


andre = rand(20, N) < 0.01;
bruno = rand(30, N) < 0.05;
carlos = rand(50, N) < 0.001;


prog = [andre; bruno; carlos]


erros = 0;
countC = 0;
countA = 0;
countB = 0;

for i = 1: N
    aux = randi(100);
    if(prog(aux, i) == true)
        erros = erros +1;
        if(aux > 50)
            countC = countC +1;
        end
        if(aux <= 20)
            countA = countA +1;
        end
        if(aux > 20 && aux <=50)
            countB = countB +1;
        end
        
    end
    
end

prob_erro = erros/N
prob_carlos_erro = countC/erros
prob_andre_erro = countA/erros
prob_bruno_erro = countB/erros
 