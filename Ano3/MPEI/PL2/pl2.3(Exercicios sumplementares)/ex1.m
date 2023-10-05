%Considere uma empresa fabricante de brinquedos que produz um determinado brinquedo. O brinquedo e´
%composto por dois componentes (1 e 2) que sao produzidos separadamente e posteriormente montados. No ˜
%final, os brinquedos sao embalados para comercializac¸ ˜ ao em caixas com ˜ n brinquedos cada.
%O processo de fabrico do Componente 1 produz p1 = 0, 2% de componentes com defeito. O processo de
%fabrico do Componente 2 produz p2 = 0, 5% de componentes com defeito. Um brinquedo esta com defeito ´
%se pelo menos um de seus componentes estiver com defeito. O processo de montagem produz pa = 1% de
%brinquedos com defeito (mesmo quando nenhum dos 2 componentes esta com defeito). 

%%

p1 = 0.2/100;
p2 = 0.5/100;
pa = 0.01;
N = 1e6;

%1 Considere o evento ”A - uma caixa de brinquedos tem pelo menos 1
%brinquedo com defeito” --> 1 ou mais

%a)Estime por simulac¸ao a probabilidade do evento A quando ˜ n = 8 brinquedo
n = 8;
d1 = rand(n, N) < p1; %situaçoes em que componente 1 tem defeito
d2 = rand(n, N) < p2; %situaçoes em que componente 2 tem defeito
da = rand(n, N) < pa; %situaçoes em que o brinquedo tem defeito(e as componentes não)
defeitos = d1 + d2 +da; % situações em que houve defeitos (quer seja das componentes ou do processo de montagem)
caixasDefeitos = sum(defeitos > 0);
peloMenos1 = sum(caixasDefeitos >=1 );
c = sum(sum(defeitos > 0));
Proba = peloMenos1/N;
semdefeitos = sum(sum(defeitos) == 0);
1- (semdefeitos/N)

fprintf("EX1, a)- Probabilidade de pelo menos 1 brinquedo defeituoso numa caixa de 8 é igual a %f", Proba);

%b)Estime por simulac¸ao o n ˜ umero m ´ edio de brinquedos defeituosos apenas devido ao processo de ´
%montagem quando ocorre o evento A e n = 8 brinquedos.

defeitosMontagem = sum(sum(da == 1));
NumMedio = defeitosMontagem/c;

fprintf("\nEX1, b) O número médio de brinquedos defeituosos devido ao processo de montagem é igual %f", NumMedio);
fprintf("\n");











