# Project 2 - Secure Game

| Nmec | Nome | Email |
| :---: | :---: | :---: |
| 98403 | Diogo Fontes | diogo.fontes@ua.pt |
| 98506 | João Figueiredo | jrcidra@ua.pt |
| 103182 | João Matos | joaorpm02@ua.pt|

## Diagrama de protocolo
![Diagrama de protocolo](https://github.com/detiuaveiro/assignment-2---bingo-recurso-grupo38/blob/main/Diagrama/Diagrama.png)

## Mudanças para o recurso:
- Challenge-response foi implementado no login/registo dos clientes.
- Os players cards são validados e assinados pelo caller. Posteriormente no início do jogo, são partilhados com todos os players.
- Deck handling foi renovado:
    - Os decks são verificados pelos players quanto ao seu tamanho, durante a fase de encriptaçao;
    - Na fase de decriptação, os players e o caller, verificam o deck (completamente decriptado), ou seja, se os números estão dentro do intervalo correto ([1, N]), se não há números repetidos e se o tamanho da lista é o correto;
    - Durante a fase de decriptação, as assinaturas são validadas
    - A encriptação/decriptação é feita sem recurso ao fernet.





## Descrição
Este projeto foi realizado no âmbito da unidade curricular de Segurança Informática e nas Organizações do ano curricular 2022/23.
Este trabalho consiste na implementação de um protocolo seguro para lidar com o jogo, Bingo.

Na pasta playing_area encontra-se o código relativo á playing_area.
Na pasta player encontra-se o código relativo aos clientes (jogadores).
Na pasta caller encontra-se o código relativo ao sevidor (caller)
Na pasta utils encontra-se o código que os ficheiros das outras pasta necessitam para o funcionamento do jogo.

## Bingo the game
O bingo é um jogo relativamente simples. Temos 2 tipos de entidades, um caller e vários jogadores. Cada jogador possui um cartão com M números de 1 a N (deck).
O deck é encriptado e baralhado pelo caller e por todos os players presentes.
O user no fim também computa o resultado do jogo e o caller vê se o mesmo fez essa computação bem.

## Autenticação - Challenge-Response
O servidor gera um desafio que inclui um valor chamado "client_challenge", um timestamp, um nonce gerado aleatoriamente e um segredo compartilhado.
O desafio é criptografado com a chave pública do cliente e enviado para o cliente.
O cliente recebe o desafio e o decripta com sua chave privada. Em seguida, ele calcula uma resposta ao desafio usando o algoritmo HMAC (Keyed-Hash Message Authentication Code) e o segredo compartilhado. A resposta é então criptografada com a chave pública do servidor e enviada de volta.
O servidor decripta a resposta com sua chave privada e verifica se a resposta do cliente é válida comparando-a com a resposta esperada que foi calculada a partir do nonce, do client_challenge e do segredo compartilhado. Além disso, o servidor verifica se o timestamp do desafio ainda está dentro do período aceitável.
Se a resposta do cliente for válida, se a assinatura também for válida e se o timestamp estiver dentro do período aceitável, o servidor considera o cliente autenticado e permite o acesso. Caso contrário, o acesso é negado.

## Encryption Algorithms
 Na primeira fase usou-se o algoritmo Fernet para fazer a encriptação e desencriptação do deck. Nesta fase, o grupo decidiu usar o algoritmo AES-CFB (Cipher Feedback).
 


## Cheating
Implementámos várias formas para, tanto o caller e o player, fazerem batota:
O número de números no cartão é determinado pela variável M. A fonte de números para o cartão é o intervalo de 1 a N+1.

Primeiramente é gerado um cartão válido através da chamada da função "random.sample" para amostrar M números do intervalo. Em seguida, existe uma condição aleatória que tem 20% de chance de gerar um cartão inválido.

Se a condição for satisfeita, um número aleatório é gerado e comparado com diferentes intervalos para determinar o tipo de cartão inválido a ser gerado. Se o número aleatório for menor que 0,33, o tamanho do cartão será alterado para um tamanho aleatório entre M * 0,8 e M. Se o número aleatório estiver entre 0,33 e 0,66, o cartão irá ter números fora do intervalo original (1 a N+1). Se o número aleatório for maior que 0,66, o cartão irá ter tanto números válidos quanto inválidos, bem como números repetidos.

### Player:
- Possibilidade de gerar um cartão inválido  
- Possibilidade de interferir com o deck handling, ignorar o deck recebido e enviar um novo (pode ser um deck válido ou não)
- No fim do jogo, pode mentir sobre os vencedores e incluir-se na lista 

### Caller: 
- Possibilidade de interferir com o deck handling, criando um deck inválido que é passado 


## Instruções de como correr o jogo

 Terminal 1: python3 parea_sec.py

 Terminal 2: python3 caller_sec.py

 Terminal 3: python3 user_sec.py (repetir este passo para entrarem n players )

Nota: Serão precisos, pelo menos, 2 players válidos, para o jogo começar

## O que faltou ser implementado
 -> Cartão de Cidadão