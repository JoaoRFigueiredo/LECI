# Project 2 - Secure Game

| Nmec | Nome | Email |
| :---: | :---: | :---: |
| 98403 | Diogo Fontes | diogo.fontes@ua.pt |
| 98506 | João Figueiredo | jrcidra@ua.pt |
| x | João Matos | x@ua.pt|

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


## Player and Caller Authentication and Registration
É usado PKI para autenticar tanto o Player como o Caller.



## Encryption Algorithms - Signature algorithms - Keys
 -> Uma chave assimétrica para a playing area, para assinar mensagens.

 -> Uma chave assimétrica por jogador, gerada antes do registo. A sua chave privada é usada para assinar as suas mensagens. A sua chave pública torna-se disponível para o Caller e para a playing area.

 -> Uma chave simétrica, por jogador e para o caller, para encriptar o deck.



## Log
No ficheiro server.log encontra-se disponível todas as mensagens enviadas e recebidas pela playing area.

## Cheating
Implementámos várias formas para, tanto o caller e o player, fazerem batota:  

### Player:
- Possibilidade de gerar um cartão inválido  
- Possibilidade de interferir com o deck handling, ignorar o deck recebido e enviar um novo (pode ser um deck válido ou não)
- No fim do jogo, pode mentir sobre os vencedores e incluir-se na lista 

### Caller: 
- Possibilidade de interferir com o deck handling, criando um deck inválido que é passado 


## Instruções de como correr o jogo

 Passo 1: python3 parea_sec.py

 Passo 2: python3 caller_sec.py

 Passo 3: python3 user_sec.py (repetir este passo para entrarem n players )

Nota: Serão precisos, pelo menos, 2 players válidos, para o jogo começar

## O que faltou ser implementado
 -> Citizen Card 




