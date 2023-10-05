fdata = load('friends.txt');
dic = readcell('users.txt', 'Delimiter', ';');

for i =1:1000
    for j=4:17
         str = dic{i,j};
     a = ismissing(str);
             if a == 1
                 break;
             end
    atividades(i,j-3)= string(str);
    end
    
end

nomes = cell(1000, 1);
for i =1:1000
    
    nomes{i, 1} = append(dic{i, 2}, ' ',dic{i, 3} );
end

 
   
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%% OPÇÃO 3 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%codigo para shingles dos nomes
shingle_size=3;
K = 150;  % Número de funções de dispersão
MinHashSig = inf(length(nomes),K);
for i = 1:length(nomes)
    conjunto = lower(nomes{i,1});
    shingles = {};
    for j= 1 : length(conjunto) - shingle_size+1  % Criacao dos shingles para cada nome
        shingle = conjunto(j:j+shingle_size-1);
        shingles{j} = shingle;
    end
    
    for j = 1:length(shingles)
        chave = char(shingles(j));
        hash = zeros(1,K);
        for kk = 1:K
            chave = [chave num2str(kk)];
            hash(kk) = DJB31MA(chave,127);
        end
        MinHashSig(i,:) = min([MinHashSig(i,:);hash]);  % Valor minimo da hash para este shingle
    end
end

   
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%% OPÇÃO 1 (listar amigos da respetiva pessoa)%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
friends = fdata(1:end, 1:2);
users = unique(friends(:,1));
Set = cell(length(users), 1);
for i =1:1000
    ind = find(friends(:, 1) == i);
    for j = 1:length(ind)
    Namigos(i, j) = friends(ind(j),2);
    Set{i} = [Set{i} friends(ind(j),2)];
    end
end



   
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%% OPÇÃO 2 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Codigo para procurar o utilizador mais semelhante em termos de lista de amigos

%codigo de minhash
tic
k = 100;
Nu = length(Namigos);
minHashValue = inf(Nu, k);

for i = 1: Nu
    conjunto = Namigos(i, :);
    for j = 1: sum(Namigos(1, :) ~= 0)
        chave = char(conjunto(j));
        hash = zeros(1,k);
        for kk = 1:k
            chave = [chave num2str(kk)];
            hash(kk) = DJB31MA(chave, 127);
        end
        minHashValue(i,:) = min([minHashValue(i,:);hash]);
    end
end

J=zeros(Nu, Nu);
h = waitbar(0,'Calculating');
for n1= 1:Nu
    waitbar(n1/Nu,h);
    for n2= 1:Nu
        if n2 == n1
        continue
    end
           J(n1,n2) = sum(minHashValue(n1,:) ~= minHashValue(n2,:))/k;              
    end
end

delete (h)
%% Com base na distaˆncia, determina pares com
%% distaˆncia inferior a um limiar pre´-definido
threshold =1.0; % limiar de decisa˜o
% Array para guardar pares similares (user1, user2, distaˆncia)
SimilarUsers= zeros(1,3);
k= 1;
for n1= 1:Nu
for n2= 1:Nu
    if n2 == n1
        continue
    end
if J(n1, n2) < threshold
SimilarUsers(k,:)= [users(n1) users(n2) J(n1,n2)];
k= k+1;
end
end
end
   
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%% OPÇÃO 4 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%codigo de minhash
tic
k = 100;
Nu = length(atividades);
minHashValue = inf(Nu, k);

for i = 1: Nu
    conjunto = atividades(i, :);
    contador = 0;
    for h=1:14
        str = atividades(i, h);
     a = ismissing(str);
             if a == 1
                 break;
             end
             contador = contador+1;
    end
    
    for j = 1: contador
        chave = char(conjunto(j));
        hash = zeros(1,k);
        for kk = 1:k
            chave = [chave num2str(kk)];
            hash(kk) = DJB31MA(chave, 127);
        end
        minHashValue(i,:) = min([minHashValue(i,:);hash]);
    end
end
J=zeros(Nu, Nu);
h = waitbar(0,'Calculating');
for n1= 1:Nu
    waitbar(n1/Nu,h);
    for n2= 1:Nu
        if n2 == n1
        continue
    end
           J(n1,n2) = sum(minHashValue(n1,:) ~= minHashValue(n2,:))/k;              %% Adicionar co´digo aqui
    end
end
delete (h)
%% distaˆncia inferior a um limiar pre´-definido
threshold =1.0; % limiar de decisa˜o
% Array para guardar pares similares (user1, user2, distaˆncia)
SimilarUsersInterests= zeros(1,3);
k= 1;
for n1= 1:Nu
for n2= 1:Nu
    if n2 == n1
        continue
    end
if J(n1, n2) < threshold
SimilarUsersInterests(k,:)= [users(n1) users(n2) J(n1,n2)];
k= k+1;
end
end
end
save('Namigos.mat', 'Namigos', 'dic', 'J', 'SimilarUsers', 'MinHashSig', 'nomes', 'bf', 'SimilarUsersInterests');