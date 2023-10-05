app()

    function app()
    load('Namigos.mat', 'Namigos', 'dic', 'SimilarUsers', 'MinHashSig', 'nomes', 'bf', 'SimilarUsersInterests')
    id = 0;
    
    while(id < 1 || id > 1000)
        prompt = "Please insert an id number between 1 and 1000 -> ";
        id = input(prompt);
    end
    
    clc
    fprintf("\n\t\tENJOY THE APP USER %d",id)
    option = 0;
    p = "\nMenu:"+"\n1-    Your Friends"+"\n2-    Interests from most similiar user"+"\n3-    Search Name"+"\n4-    Find most similar users based in list of interests"+"\n5-    Exit\n";
    while(option < 1 || option > 5)
        fprintf(p)
        fprintf("Please %s (%d), choose one of the options: ",string(nomes{id, :}),id);
        option = input('');    
    end
    
    while(option~=5)
        switch(option)  %Opção de escolha para correr
            case 1      %Mostrar os seus amigos
                amigos(id, Namigos);
            case 2      %Mostra o utilizador mais semelhante
                semelhante(id, SimilarUsers);
            case 3      %Motor de busca
                 bf = Inicializar(5000);
                for i =1:1000
                    bf = inserir(bf, lower(nomes{i}), 5);
                end

                SearchName(nomes, MinHashSig, bf);
            case 4      %Os 3 amigos mais semelhantes do amigo selecionado
                SimilarInterests(id, SimilarUsersInterests, nomes, Namigos)
            case 5      %Final do loop
               
            otherwise
                fprintf(2,'\nOpção Inválida.\n');    
        end
        %Após finalizar uma funcionalidade torna a aparecer até o
        %utilizador escolher sair
        option = 0;
        p = "\nMenu:"+"\n1-    Your Friends"+"\n2-    Interests from most similiar user"+"\n3-    Search Name"+"\n4-    Find most similar users based in list of interests"+"\n5-    Exit\n";
        while(option < 1 || option > 5)
            fprintf(p)
            fprintf("Please %s (%d), choice one of the options: ",string(nomes{id, :}),id);
            option = input('');    
        end
        clc;
    end
 fprintf("Saíu da aplicação");




    function amigos(id, Namigos)
        numberOfFriends = sum(Namigos(id, :) ~=0);
        fprintf("\nNumber of friends: %d", numberOfFriends);
        fprintf("\nFriends: \n");
        for i = 1:numberOfFriends
            fprintf("\t\t%4d\t", Namigos(id, i));
            fprintf("%s ", dic{Namigos(id, i), 2});
            fprintf("%s", dic{Namigos(id, i), 3});
            fprintf("\n");
        end
    end
    
    function semelhante(id, SimilarUsers)
        for i=4:40                      %Percorremos os interesses do utilizador, i.e., desde valor coluna 4 até a um valor aleatório   
            a = ismissing(dic{id, i});  %
            if a == 1                   %
                break;                  %Se tiver celulas missing para de percorrer
            end                         %
            gostos1{i-3}=dic{id, i};    %Guarda os gostos do utilizador numa cell array
        end                             %
                                        %Após calcular os utilizadores similares
        indices = find(SimilarUsers(:, 1) == id);               %
        sim = SimilarUsers(indices(1), 3);                      %
        maisSemelhante = SimilarUsers(indices(1), 2);           %
        for i = 1:length(indices)                               %
            if(SimilarUsers(indices(i), 3) < sim)               %
                maisSemelhante = SimilarUsers(indices(i), 2);   %
                sim = SimilarUsers(indices(i), 3);
            end
        end
        fprintf("\n%s %s de id %d é bastante semelhante a si.\n",dic{maisSemelhante, 2},dic{maisSemelhante, 3}, maisSemelhante);
        fprintf("Distância de Jacc é igual a %.4f",sim)
        fprintf("\n\nEis os gostos do utilizador mais semelhante a si:\n");
        
        for i =4:50                         %Percorremos os interesses, i.e., desde valor coluna 4 até a um valor aleatório   
            str = dic{maisSemelhante, i};   %Vamos à linha do mais semelhante
            a = ismissing(str);             %
            if a == 1                       %
                break;                      %
            end                             %
            fprintf("%s\n", str);           %e extraimos os seus interesses
            gostos2{i-3}=str;               %Guarda os gostos do mais semelhante numa cell array
        end                                 %
        C = setxor(gostos1, gostos2);       %setxor dá-nos o que não têm em comum
        C = intersect(C, gostos2);          %(AS COISAS QUE SÓ O B GOSTA) Depois disso que não têm em comum fizemos a interseção com os 
        fprintf("\nEis algumas sugestões: ")%interesses do mais semelhante e imprimindo assim os gostos PARTICULARES
        for i =1:length(C)                  %
            fprintf("%s\n", C{i})           %Imprime todos os interesses que o mais semelhante tem e que 
        end                                 %o utilizador não tem como método de sugestão
    end
    
    function SearchName(nomes, MinHashSig, bf)          %
        str = lower(input('\nWrite a String: ', 's'));  %
        verify = verificar(bf, str, 5);                 %

        if verify
            fprintf("\nA string que inseriu pode ser igual a um dos nomes existentes.\n")
        end

        threshold = 0.9;                                %
        shingle_size = 3;                               %
        K = size(MinHashSig, 2);                        %
        shinglesAns = {};                               %
        for i = 1:length(str) - shingle_size+1          %
            shingle = str(i:i+shingle_size-1);          %
            shinglesAns{i} = shingle;                   %
        end                                             %
                                                        %
        MinHashString = inf(1,K);                       %
        for j = 1:length(shinglesAns)                   %
            chave = char(shinglesAns{j});               %
            hash = zeros(1,K);                          %
            for kk = 1:K                                %
                chave = [chave num2str(kk)];            %
                hash(kk) = DJB31MA(chave, 127);         %
            end                                         %
            MinHashString(1,:) = min([MinHashString(1,:); hash]);
        end
        
        distJ = ones(1, size(nomes,1));  % array para guardar distancias
        h = waitbar(0,'Calculating');
        for i=1:size(nomes, 1)  % cada hashcode da string
            waitbar(i/K, h);
            distJ(i) = sum(MinHashSig(i,:) ~= MinHashString)/K;
        end
        delete(h);
        
        flag = false;  % Fazemos uma flag para saber se houve algum filme encontrado com uma distancia menor ou igual a threshold
                
        for i = 1:5
            [val, pos] = min(distJ);  % Calcular o valor minimo (mais similaridade)
            if (val <= threshold)  % Se o valor minimo já nao pretencer ao threshold não dá print
                flag = true;
                fprintf('%20s    (%f)\n', nomes{pos, 1}, val);
            end
            distJ(pos) = 1;  % Retirar esse nome dando uma distancia igual a 1
        end
        if(~flag)
            fprintf(2,'Não foi encontrado nenhum nome semelhante.\n');%Por exemplo para casos com um ou duas letra
            SearchName(nomes, MinHashSig, bf);
        end
    end
    
    function SimilarInterests(id, SimilarUsersInterests, nomes, Namigos)
        numberOfFriends = sum(Namigos(id, :) ~=0);
        amigos(id, Namigos)
        for i=1:numberOfFriends
            IDS(i) = Namigos(id, i);
        end
        newID = input("\nInsira um dos ID's lista de amigos apresentada -> ");
        NaoPodesSerTu=true;
        while NaoPodesSerTu || ~ismember(newID, IDS)
            NaoPodesSerTu=false;
            if(id==newID)
                fprintf(2,"Não podes ser tu!");
                newID = input("\nInsira um dos ID's da lista de amigos apresentada -> ");
                NaoPodesSerTu=true;
            end
            if(~ismember(newID, IDS))
                fprintf(2,"Esse id não representa um dos seus amigos.");
                newID = input("\nInsira um dos ID's da lista de amigos apresentada -> ");
            end
        end
        
        indices = find(SimilarUsersInterests(:, 1) == newID);
        submatrix = SimilarUsersInterests(indices(1):indices(length(indices)), :);
        submatrix = sortrows(submatrix, 3);
        fprintf("\nAqui estão os 3 utilizadores mais similares ao amigo que escolheu com base nos interesses.\n");
        for i=1:3
            fprintf("%2dº --> %4d, %s com uma distância de jaccard de %.3f\n",i,  submatrix(i, 2), nomes{submatrix(i, 2)}, submatrix(i, 3));
        end
    end 
end
