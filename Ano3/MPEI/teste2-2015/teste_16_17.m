letras = [0.7 0.2 0 0 0 0;
            0.2 0 0.3 0 0 0;
            0 0.6 0.3 0 0 0;
            0.1 0.2 0.3 0.1 0 0;
             0 0 0 0.4 1 0;
             0 0 0.1 0.5 0 1];
     
         sum(letras);
         
x0 = [1; 0; 0; 0; 0; 0];
x10 = letras^9 * x0;
Q = letras(1:4, 1:4);

F = (eye(4)-Q)^-1
t = sum(F)