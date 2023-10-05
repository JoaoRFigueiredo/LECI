% Co´digo base para detecao de pares similares
udata=load('u.data'); % Carrega o ficheiro dos dados dos filmes

% Fica apenas com as duas primeiras colunas
u= udata(1:end,1:2); clear udata;

% Lista de utilizadores
users = unique(u(:,1)); % Extrai os IDs dos utilizadores
Nu= length(users); % Nu´mero de utilizadores

% Constrói a lista de filmes para cada utilizador
Set= cell(Nu,1); % Usa celulas
for n = 1:Nu % Para cada utilizador
    % Obtem os filmes de cada um
    ind = find(u(:,1) == users(n));
    % E guarda num array. Usa celulas porque utilizador tem um numero
    % diferente de filmes. Se fossem iguais podia ser um array
    Set{n} = [Set{n} u(ind,2)];
end



%codigo de minhash
tic
k = 50;
minHashValue = inf(Nu, k);

for i = 1: Nu
    conjunto = Set{i};
    for j = 1: length(conjunto)
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
    for n2= n1+1:Nu
           J(n1,n2) = sum(minHashValue(n1,:) ~= minHashValue(n2,:))/k;              %% Adicionar co´digo aqui
    end
end
save J.mat
delete (h)
%% Com base na distaˆncia, determina pares com
%% distaˆncia inferior a um limiar pre´-definido
threshold =0.4; % limiar de decisa˜o
% Array para guardar pares similares (user1, user2, distaˆncia)
SimilarUsers= zeros(1,3);
k= 1;
for n1= 1:Nu
for n2= n1+1:Nu
if J(n1, n2) <= threshold
SimilarUsers(k,:)= [users(n1) users(n2) J(n1,n2)];
k= k+1;
end
end
end
