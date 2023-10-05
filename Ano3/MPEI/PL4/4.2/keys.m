function keys = keys(min, max, N, letras,   probs)

M = cell(1, N);

switch nargin
    case 4
        for k =1 : N
       size = randi([min, max]);
       chaveN = zeros(1,size);
            for j = 1 : size
                i = randi([1 length(letras)]);      %gera uma letra com igual probabilidade dentro das 52 letras disponiveis
                chaveN(j) = letras(i);
            end
     word = char(chaveN);
     M{k} = word;
        end

        
    case 5
         for k =1 : N
         letras = ['A':'Z'];
         size = randi([min, max]);
         chaveN = zeros(1,size);
            for j = 1 : size
                u = rand();
                if (u < probs(1))
                    i = 1;
                else
                B = find(probs < u);
                i = B(length(B));
                end
                chaveN(j) = letras(i);
            end
     word = char(chaveN);
     M{k} = word;
         end
end

    keys = M;
        

end