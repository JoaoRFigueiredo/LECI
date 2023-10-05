%A distribuic¸ao de Poisson ˜ e uma forma limite da distribuic¸ ´ ao binomial (quando ˜ n → ∞ , p → 0 e np
%permanece constante) e portanto pode ser usada para aproximar e simplificar os calculos envolvidos com ´
%a binomial em situac¸oes em que as condic¸ ˜ oes anteriores se verifiquem. ˜
%Num processo industrial de fabrico de chips, alguns aparecem defeituosos tornando-os inapropriados
%para comercializac¸ao. ˜ E sabido que em m ´ edia por cada 1000 chips h ´ a um defeituoso.
%%

p = 1/1000; %Probabilidade de defeito

%a)Usando a distribuic¸ao binomial, determine a probabilidade de numa amostra de ˜ 8000 chips aparecerem 7 defeituosos.
i = 7; %numero de chips defeituosos

ProbaBinomial =nchoosek(8000,i) * p.^i .* (1-p).^(8000-i)


%b)Determine a mesma probabilidade usando a aproximac¸ao de Poisson e compare o resultado com o ˜da al´ınea anterior

n = 8000;


ProbPoisson = (((n*p)^7)*(exp(-(n*p))))/(factorial(7))
