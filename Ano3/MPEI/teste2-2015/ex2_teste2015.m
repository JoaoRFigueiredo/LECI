%    A     B   C   D
% A
% B
% C
% D


x0 = [1; 2; 10; 5]
total = x0./(1+2+10+5)
sum(total)
paises = [ 0.84 0.1 0 0.5;
           0.1 0.7 0 0.1;
            0.05 0.1 0.8 0.1;
            0.01 0.1 0.2 0.3];
        
sum(paises)

agosto = (paises^7 )*x0


%b)
Xmax = x0;
%temos um loop a simular entregas desde 2014 até fevereiro deste ano
for i=1:12*8+1
   Xold = Xmax;
   Xmax  = (paises^i) * x0;
   Xmax(1) = max(Xmax(1), Xold(1));
   Xmax(2) = max(Xmax(2), Xold(2));
   Xmax(3) = max(Xmax(3), Xold(3));
   Xmax(4) = max(Xmax(4), Xold(4));
   
    
    
end

Xmax



Xmax = x0;
%temos um loop a simular entregas desde 2014 até fevereiro deste ano
for i=1:12*8+1
   Xold = Xmax;
   Xmax  = (paises^i) * x0;
  if Xmax(4) < 2
      break;
  end
end

i