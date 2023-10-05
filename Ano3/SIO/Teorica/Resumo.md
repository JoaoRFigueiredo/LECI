# **SIO -> Segurança Informática e nas Organizações**
## Resumo da matéria (Index)

- [Introdução à segurança Informática](#introduçã-à-segurança-informática)
- [Vulnerabilidades](#vulnerabilidades)
- [Criptografia](#criptografia)
- [Gestão de chaves assimétricas](#gestão-de-chaves-assimétricas)
- [SmartCards e Cartão de Cidadão](#smartcards-e-cartão-de-cidadão) 
- [Autenticação: mecanismos e protocolos](#autenticação-mecanismos-e-protocolos)
- [SIstemas Operativos](#sistemas-operativos)
- [Armazenamento](#armazenamento)
- [Segurança em redes](#segurança-em-redes)


## **Introduçã à segurança Informática**

- O que é?
- Ciclo de vida.
    - Planeamento
    - Desenvolvimento
    - Execução
    - Processos
    - Pessoas
    - Clientes e fornecedores
    - Mecanismos
    - Normas
    - Propriedade intelectual
- Facetas da Segurança
- Segurança de informação
- Objetivos da Segurança
- Conceitos Fundamentais
    - Domínios 
    - Políticas
    - Mecanismos
    - Controlos
- Aplicação da Segurança
- Segurança em sistemas computacionais
- Principal fontes de vulnerabilidades
- Políticas em Sistemas distribuídos
- Defesa em Perímetro
- Defesa em profundidade
- Zero trust
- Atualidade
    - Utilizadores comuns
    - Empresas
    - Nações
    - Grupos ofensivos
    - Grupos criminosos
    - fatores limitantes

### **O que é?**

A segurança informática é a disciplina que se foca na previsibilidade dos sistemas, processos, ambientes, etc


### **Ciclo de vida**

#### **Planeamento**

Desenho de uma solução que seja capaz de responder aos requisitos, num contexto normativo.

Não pode haver falhas neste solução proposta, ou seja, todos os estados de funcionamento são os previstos e não podem existir estados que fujam à lógica pretendida.

### **Desenvolvimento**

Implementação da solução desenhada/proposta, que responda ao design.

Esta, não pode possuir bugs/erros que comprometam o um funcionamento correto.

Alguns exemplos:

- Sem crashes
- Nada de respostas inválida ou inesperadas
- Tempo de execução correto (ou seja, o previsto)
- Consumo de recursos adequado
- Nada de leaks

No que toca software, envolve uma implementação cuidada e a realização de testes para obter uma solução que realize o pretendido e apenas isso.

### **Execução**

Execução de código tal como foi escrito e com todo os processo previstos.

Isto implica:

- A existência de um ambiente controlado, não manipulável e não observável.
- A inexistência de comportamentos anómalos, estes introduzidos pelo ambiente onde executa.
    - Alguns aspetos relevantes: velocidade do disco, quantidade de RAM, tipos de comunicações e a sua fiabilidade, ...

### **Pessoas e parceiros**

O comportamento dos sujeitos não possui um impacto negativo na solução.

Existem normas, as quais definem os melhores comportamentos. 

Existe um formação para poder distinguir entre comportamentos corretos e incorretos. Possuem, também, incentivos para manter comportamentos corretos.

Quando comprometidos ou desviantes, as ações têm um impacto limitado.

### **Análise de auditoria**

Qual é o comportamento atual da solução?

- Identificar aspetos irregulares.
    - Falhas, erros, comportamentos
- Identificar o risco da solução ser desviada.
    -Exposição a possíveis atacantes.
    - Incentivos para que seja desviada.
    - Potenciais atores.
- Identificar o impacto dos desvios.
    - Perda total de dados? Disrupção? Custo da operação?


### **Facetas**

Estas facetas são interligadas e indissociáveis.

- Defensiva:
    - Foca-se na manutenção da previsibilidade.
- Ofensiva:
    - Foca-se na violação da previsibilidade
    - Pode ter intuito malicioso/criminoso
    - Pode ter intuito de validação da solução (Red Teams)
- Outras:
    - Engenharia reversa
        - Recuperar o design através do produto
    - Forense
        -Identificar ações passadas e recuperar informação
    - Recuperração de desastres
        - Minimizar o impacto
    - Auditoria
        - Validar o cumprimento de acordo com as respetivas premissas

### **Segurança da Informação**

<u>Confidencialidade</u> : Informação só é acedida por um grupo restrito de sujeitos.

Medidas:

- Cifrar informação
- Uso de senhas (fortes)
- Sistemas de identificação e autenticação
- Firewalls
- Portas e paredes robustas
- Pessoal de segurança
- Formação das pessoas

<u>Integridade</u>: Informação mantém-se inalterada. A mesma lógica é aplicada ao comportamento de dispositvios e serviços.

Medidas:

- Controlos de intregidades
- Backups
- Controlos de acesso
- Dispositivos de armazenamento robustos
- Processos de verificação da informação

<u>Disponibilidade</u>: Informação mantém-se disponível. Pode ser aplicada a serviços e dispositivos.

Medidas:
- Backups
- Planos de recuperação de desastres
- Redundância
- Virtualização
- Monitorização

<u>Privacidade</u>: Como é tratada a informação pessoal. A recolha, o processamento, o armazenamento, partilha de informação, eliminação.

Medidas:

- Controlos de acesso
- Transparência dos processos
- Cifras
- Controlos de integridade e de autenticidade
- Registos

### **Objetivos da segurança**

- Defesa contra catástrofes
- Degradação dos sistemas informáticos físicos
- Defesa contra falhas e erros comuns
- Defesa contra atividades não autorizadas (oponentes)
    - Acesso e alteração de informação
    - Utilização de recursos
    - DDOS
    - Vandalismo

### **Conceitos Fundamentais**

### **Domínios**

Conjunto de entidades que partilham atributos de segurança semelhantes.

- Gerir a segurança de forma agregada
- Os comportamentos e interações são homogéneos dentro do domínio
- Domínios podem ser organizados de forma plana ou hierárquica
- Interações entre domínios são controladas

### **Políticas de Seguraça**

Conjunto de orientações relativas à segurança que regem um domínio.

- A sua organização possui uma hierarquia de políticas
- Devem ser coerentes entre si
- Exemplo d epolíticas:
    - Só é possível aceder a serviços web
    - Pessoas têm que se identificar para entrar
    - etc
- Definem o poder de cada sujeito
- Definem os procedimentos de segurança
- Definem requisitos mínimos de seg. dos sistemas
- Definem as estratégias de defesa e de resposta
- Definem a linha entre o correto e o incorreto


### **Mecanismos de Segurança**

- Os mecanismos implementam as políticas
- Alguns exemplos de mecanismos genéricos:
    - Confinamento
    - Autenticação
    - Controlo de acesso
    - Registo
    - etc

Exemplos reais de políticas/mecanismos

**Políticas** -> Movimentos entre domínios devem ser restritos.
**Mecanismos** -> Portas, guardas, senhas, objetos/documentos.


**Políticas** -> Sistemas devem ser resilientes.
**Mecanismos** -> Equipamentos/ligações duplicadas, arquitetura.

### **Controlos de Segurança**

Controlos são todos e quaisquer aspetos que permitam evitar, detetar, neutralizar ou minimizar o risco.

- Controlos incluem políticas e mecanismos, mas também aspetos legais:
    - Normas e leis
    - Processos
    - Políticas
    - Mecanismos
    - Técnicas
- Controlos são definidos de forma explícita e são verificáveis



### **Aplicação da Segurança**

Não existe segurança perfeita.
Devemos:

- Focar nos eventos mais prováveis
- Considerar custo e receitas
- Considerar todos os domínios e entidades
- Considerar o impacto
- Considerar o custo e tempo de recuperação
- Caraterizar os atacantes
- Considerar que o sistemas vai ser comprometido


### **Segurança em sistemas computacionais**

- Computadores podem fazer muitos estragos num curto espaço de tempo
- O número de vulnerabilidades aumenta sempre
- Redes permitem novos mecanismos de ataque
- Atacantes podem construir cadeias de ataque complexas
- Usuários não possuem noção do risco
- Usuários são desleixados

### **Principais fontes de Vulnerabilidades**

- Aplicações hostis ou erros em aplicações
- Usuários
- Administração deficiente
- Comunicações sobre ligações não controladas/conhecidas

### **Aplicação da Segurança**

Tem de englobar múltiplos sistemas e redes.

- Domínios de segurança
- Gateways de segurança
- Conjunto de controlos para validação

### **Defesa em Perímetro**

(Mínimo aconselhado, mas insuficiente) 

- Proteção contra atacantes externos
- Assume que utilizadores internos são confiáveis e partilham políticas
- Utilização doméstica ou em pequenas organizações
- Limitações:
    - Não protege contra atacantes internos

### **Defesa em profundidade**

(Mais adequado, mas também falível)

- Proteção contra atacantes externos e internos
- Assume domínios bem definidos sobre todos os aspetos
- Limitações:
    - Necessidade de coordenação entre controlos
    - Custo
    - Necessidade de treino, alteração de processos e auditorias frequentes
- Sistemas Operativos Confiáveis
- Firewalls e sistemas de segurança
- Comunicações Seguras / VPNs
- Autenticação
- Entidades de Certidicação /PKI
- Cifra de ficheiros e dados em sessões
- Deteção de intrusões
- Inventariação de vulnerabilidades
- Testes de penetração
- Monitorização de conteúdos
- Administração da segurança
- Resposta a incidentes / Seguimento em tempo real

### **Zero Trust**

- Modelo de defesa sem perímetros específicos
- Modelo recomendado para novos sistemas

### **Princípios**

1. Conhecer a arquitetura e as identidades
2. Validar comportamentos e saúde de dispositivos e serviços
3. Usar políticas para autorizar pedidos
4. Autenticar e autorizar todas as interações
5. Monitorizar utilizadores, dispositivos e serviços
6. Não confiar em nenhuma rede, nem mesmo a própria
7. usar serviços desenvolvidos para Zero Trust

### **Atualidade**
### **Utilizadores Comuns**

- Usam o mesmo dispositivo para todas as suas interações
- Utilização de sistemas e serviços com base no objetivo final
- Sem formação e incautos

### **Empresas**

- Focadas no objeto do negócio
- Seguras na medida do estritamente necessário

### **Nações**

- Focadas na soberania política, económica, cultural
- Possuem entidades dedicadas à cibersegurança
- Podem realizar ações ofensivas contra outras entidades

### **Grupos ofensivos**

- Realizam ataques contra qualquer um
- Por vezes considerados Advanced Persistent Threats
- Variadas motivações

### **Grupos Criminosos**

- Frequentemente operam como empresas
- Operam segundo vários modelos
- Ambiente de software rico e dinâmico

### **Fatores limitantes**

- É limitada por aspetos económicos, operacionais e logísticos.


No fundo, Cibersegurança resume-se a construir e aplicar uma estratégia, com um orçamento e num contexto operacional e legal.

---

## **Vulnerabilidades**

- Medidas para contrariar.
- Vulnerabilidade
- Exposição
- Prontidão/Security Readiness
- CVE
    - Identificadores
        - Nomes
        - Números
        - IDs
        - CVEs
- Benefícios dos CVEs
- Deteção de vulnerabilidades
- CWE
- Gestão de vulnerabilidades
- Zero day attacks
- Como se sobrevive a zero day attacks
- CERT
- CSIRT
- Ataques Comuns
    - Phishing 
    - Malware
    - RansomWare
    - KeyLoggers/Spyware



### **Medidas para contrariar**

### **Desencorajamento**
Existem motivos a **desencorajar** alguém de explorar vulnerabilidades, tais como:

- Punição (Questões legais)
- Barreiras de segurança (firewalls, autenticação, comunicação segura)

### **Deteção**

Existem formas e mecanismos para **detetar**, tais como:

- Sistemas de deteção
- Auditorias
- Análise Forense

### **Ilusão**

Existem formas e sistemas de iludir um atacante a atacar um sistema "armadilha". Portanto serve como decoy:

- Honeypots/Honeynets
- Acompanhamento Forense

### **Prevenção**

Existem formas de prevenir a exlporação:

- Políticas restritivas
- Deteção de vulnerabilidades
- Correção das vulnerabilidades

### **Recuperação**

Para remediar situações de ataques, devem existir formas de recuperar a informação perdida:

- Backups
- Sistemas redundantes
- Recuperação forense


 ### **Vulnerabilidades**

 Uma vulnerabilidade é um erro existente no software que, quando explorado, pode causar problemas ou até compromoter o sistema. Permite a um atacante ganhar acesso ao sistema ou à rede.

 Este erro, só é uma vulnerabilidade, quando permite ao atacante violar uma política de segurança.

 Uma vulnerabilidade, pode ser vista como um estado do sistema que permite o seguinte:

 - Um atacante executar comandos em nome de terceiros
 - Um atacante aceder a dados, ignorando restrições de acesso
 - O atacante se apresente como outrem
 - O atacante negue a prestação de serviços


### **Exposição**

Representa um problema de configuração de um sistema ou um erro no software que permitem aceder a informação ou auxiliar um atacante.

Ao contrário da vulnerabilidade, isto não permite compromoter **diretamente** o sistema/rede.

Uma exposição pode ser um estado do sistema, que permita o seguinte.

- Atacante realiza recolhas de informação
- Atacante esconde as suas atividades
- Possui funcionalidades que se comportam como esperado, mas são facilmente comprometidas
- Serve como ponto comum de entrada para atcantes para obterem acesso
- Visto como **problemático** por uma política de segurança razoável.

### **Prontidão/Security readiness**

Para podermos aplicar as medidas, necessitamos de algum conhecimento. Ou seja, este processo requer informação prévia. Esta informação deve conter:

- Vulnerabilidades conhecidas.
- Padrões de atividades dos ataques
- Padrões anormais de atividade

No que toca redes de computadores, as ameaças são diferentes de outras ameaças:
- Baixo custo de execução
- Podem ser automatizados
- São rápidos
- Os ataques podem ser lançados em qualquer hora e local, sendo facilmente coordenados.

Logo, é preciso um capacidade de vigilância permanente (24/7) e reação rápida:

- Equipa formada por especialistas em segurança
- Sistema de alertas de ataques na hora
- Teste e avaliação dos níveis de segurança existentes
- Procedimentos de reação expeditos

### **CVE -> Common Vulnerabilities and Exposures**

O CVE representa um dicionário público de vulnerabilidades e exposições. A existência deste dicionário facilita:

- A gestão de vulnerabilidades e correções
- A deteção de intrusões
- A alarmística de vulnerabilidades

O CVE utiliza id comuns para um mesmo CVE.

Os detalhes de um DVE podem ser privados.
- Faz parte do processo de divulgação responsável, espera-se que o fornecedor crie uma correção.

### **CVE: Identificadores**

Estes identifcadores são: os nomes, os números, os ids dos cves e os próprios CVEs.

São identificadores únicos para vulnerabilidades conhecidas e públicas da CVE list.

Formato: 
- ID numérico do CVE (CVE-ano-índice)
- Estado (candidato ou entry)
- Descrição sumária da vulnerabilidade ou exposição
- Referências para informação adicional

### **Benefícios dos CVEs**

Funciona como uma linguagem comum para referir problemas.

Fornece algumas vantagens como:
- Facilita a partilha de dados
    - Sistemas de deteção
    - Ferramentas de aferição
    - Equipas de resposta a incidentes
    - etc
- Permite melhorar as ferramentas de segurança
    - Oferece uma maior abrangência, facilidade de comparação
- Fomenta/Inspira a inovação

### **Deteção de vulnerabilidades**

Um ataque pode explorar várias vulnerabilidades e não apenas uma só.

Como podemos detetá-las? Existem algumas formas:
- Ferramentas de deteção
- Ferramentas que replicam ataques conhecidos
    - Ou seja, replicam ataques a vulnerabilidades já conhecidas


Por fim, a sua deteção é vital na aferição da robustez das aplicações e sistemas.

Onde é feita a deteção?
- No código desenvolvido (análise estática)
- Na aplicação a executar (análise dinâmica)
- Externamente como um sistema remoto (OpenVAS, )

No entanto, não podem ser aplicadas de forma cega a sistemas já em produção, pois:
- Pode haver uma perda/corrupção de dados
- DDOS
- Possível ato ilegal

### **CWE -> Common Weakness Enumeration**

Linguagem comum para discutir, encontrar e lidar com as <u>causas das vulnerabilidades de segurança</u>.
No que toca:
- Programas, o seu desenho ou até a arquitetura do sistema
- CWE = Tipo de vulnerabilidade
- A lista fornece, em detalhe, a definição pormenarizada de cada CWE

Os CWEs são catagolados segundo uma estrutura hierárquica.

Relevante adicionar, CWE != CVE

### **Gestão de vulnerabilidades**

Como são geridas as vulnerabilidades:

- Durante a fase de desenvolvimento, podem ser encaradas como bugs
    - Sendo resolvidas por equipas de segurança ou os próprios developers
- Se o software for público, as vulnerabilidades são geridas globalmente.
- Uma gestão pública leva a um maior foco
    - Atacantes também ficam a saber melhor como atacar sistemas
- Estas também podem ser geridas de forma pricada
    - Podem fazer parte de um arsenal de possíveis ataques no futuro
    - Exploits = Munição (Analogia)
- Conhecimento de exploits é comercializado
    - Pagamentos na ordem dos milhhões, em alguns casso
    - existem ofertas, que pagam também bastante bem, para programas de procura de erros
- Geridas de forma (ainda mais) privada/desconhecida
    - Obviamente, referimo-nos a situações de crime

Resumindo, gerir vulnerabilidades não é fácil, os exploits nem sempre são conhecidos, o seu impacto e valor podem ser sub-estimados, informação não recente causa uma falsa sensação de segurança e a comunidade é muito dinâmica. 

Comunidade muito dinâmica --> Defensores podem testar diretamente, mas o atacantes podem incorporar vulnerabilidades

### **Ataques de dia 0 (Zero day attacks)**

Representa ataques que usam vulnerbailidades ainda desconhecidas ou que não foram comunicadas. Também não existe correção para as mesmas.

Curiosamente, estes ataques podem ocorrer muito tempo após o lançamento de um produto/atualização. Apesar do nome, não ocorrem no dia de lançamento. Um atacante pode ter conhecimento deste exploit e "guardá-lo" durante o tempo que pretender.

### **Como se sobrevive a zero day attacks?**

- Diversidade pode ser uma solução
    - MS Windows, normalmente, é um grande alvo. Porquê?
    - Porque o windows representa uma grande quatidade de utilizadores, % no mundo de OS, logo irá haver mais ataques direcionados ao windows.
    - Linux, por exemplo, tem a vantagem de "segurança por obscuridade". Visto que representa uma quantidade muito mais baixa de utilizadores, % de OS, menos pessoas irão tentar criar ataques para o linux (exemplo)
- Coordenação é um grande auxílio


### **Cert -> Computer Emergency Readiness Team**

- Organização, cujo objetico é garantir que as práticas de gestão de tecnologias e sistemas são usados para:
    - resistir a ataques em sistemas distribuídos
    - Limitar/minimizar o dano, garantindo que serviços críticos continuam ativos

### **CSIRT -> Computer Security Incident Response Team**

- Organização responsável por receber, revre e responder a relatórios de incidentes e atividade.
    - Serviços 24/7 para utilizadores, empresas e agências do governo
    - Único contacto confiável para denunciar incidentes de segurança à escala global.
    - Meios para reportar incidentes e disseminar informação relativa a incidentes

### **Ataques comuns**

### **Phishing**

- Criam réplicas de páginas/serviços reais
- Tentam contactar as vítimas através do email/sms com um link, contendo essas réplicas, com o intuito de as enganar
    - Tentam obter dados
    - Roubar dinheiro
    - Fazer com que a vítima instale malware

### **Malware**

- Infetam os sistemas com código malicioso:
    - Vírus
    - Worm
    - Trojan

- Operação (normalmente):
    - Vítima executa ficheiro transferido
    - Vírus propaga-se para outros sistemas
    - Malware pode tornar-se persistente
    - Malware pode manter-se adormecido

### **RansomWare**

O objetivo é obter algum pagamento por parte da vítima

- Operação:
    - executam código duvidoso/malicioso num computador
    - Código compromete CIA (Confidencialidade, Integridade, Disponibilidade/Availability)
    - Atacante exige pagamento para:
        - Não divulgar informação
        - Vítima poder recuperar a sua informação
    - Atacante pode utilizar diretamente a informação

### **KeyLoggers/Spyware**

- Programa regista eventos num sistema
    - teclas pressionadas (key strokes)
    - capturas de ecrâ
    - Imagens de webcam

Estes dados são enviados par ao atacante

- Objetivo
    - Extorsão (caso das imagens/vídeos capturados)
    - Uso de informação obtida
        - passwords
        - Número do cartão de crédito

---

## **Criptografia**

- O que é? Terminologia
- Criptanálise - Objetivos
- Aatques através de criptanálise
- Como têm evoluído as cifras'
- Cifras - básicas
- Cifras de Vigenère
- Máquinas de rotores
- Criptografia:
    - Aproximações teóricas
    - Aproximações Práticas
- Robustez Criptográfica
- Cifras contínuas
- Cifras Modernas
- Cifras simétricas
    - normais
    - contínuas
    - por blocos
- Redes de substituição-Permutação
- DES - Data Encryption Standard
    - Robustez
- Cifras por blocos
- Modos:
    - ECB
    - CCB
- ECB vs CCB
- ECB/CCB problemas de alinhamento
- Reforço de segurança
- Cifras assimétricas por blocos
- Como garantir:
    - Confidencialidade
    - Autenticidade
- Randomização das chaves públicas das cifras
- Como melhorar performance
- Funções de síntese/digest
- MIC - Message Integrated Code
- MAC - Message Authenticaed Code
- Assinaturas digitais 
- Assinaturas  de forma cega
- Derivação de chaves
    - Definição
    - PBKDF2
    - Scrypt


### **Terminologia**

<u>Criptografia</u> -> arte/ciência de escrever algo de forma escondida

<u>Criptanálise</u> -> arte/ciência de quebrar sistemas criptográficos ou informação criptografada

<u>Criptologia</u> -> mix das duas anteriores.

<u>Cifra</u> -> Técnica de criptografia

<u>Operação de um a cifra</u> ->
- Cifrar = passar texto normal para um criptograma
- Decifrar = processo oposto, passar um criptograma para texto normal


<u>Algoritmo</u> -> modo de transformação de dados

<u>Chave</u> parâmetro do algoritmo, influência a operação

Se a chave for igual no processo de cifra de decifra, o texto obtido/decifrado tem de ser igual ao texto original.


### **Crptanálise - Objetivos**

- Obter o texto original
- Obter a chave usada na cifra
- Obter o algortimo da cifra


### **Ataques através de criptanálise**

- Força Bruta (ataque genérico)
    - No fundo «, é uma pesquisa exaustiva. Procura-se por todas as possíveis chaves até uma dar
- Ataques mais eficientes
    - Identificar padrões em algumas operações
    - Reduzir o espaço de pesquisa para uma dimensão menor (números, palavras, alfabeto, etc)

### **Como têm evoluído as cifras**

- Inicialmente, eram manuais, os quais continham os algoritmos de substituição ou transposição. 
- Com a chegada do séxulo 19, começaram a haver dispositvioos mecânicos para realizar estas cifras (máquinas)
- E atualmente, existem cifrfas informáticas. Surgiram com o uso dos computadores, possuindo algoritmos muito mais complexos, que consigam lidar com numeros também muito maiores. são utilizadas de forma comum no dia-a-dia

### **Cifras - as básicas**

- Substituição
    - mono-alfabética (1 - 1)
    - Poli-alfabética (vários - 1) 
    - Homofónica (um para vários)


### **Cifra de Vigenère**

tem vários slides, logo farei alguns apontamentos.

Esta cifra é poli-alfabética e tem um problema. Se aplicar o teste de kasiski:
- localizamos padrões comuns no criptograma, 
- calculamos os afastamentos entre padrões
- o maior divisor comum sugere a dimensão da chave

Índice de coincidência (com poema completo):
- Sobreposição de uma cópia, com afastamento
- Contagem dos carateres que se repetem


### **Máquina de rotores**

- Estas máquinas concretizam cifras poli-alfabéticas complexas
- Resumidamente a chave da cifra é:
    - o conjunto de rotores
    - a posição relativa de rotores
    - a posição de avanço do rotor seguinte
    - a posição original dos rotores
- Rotores simétricos (bidirecionais) permitem decifras usando cifras duplas. Para isso usa um disco refletor.
- Operação com um refletor é reciproca.
    - se clicar no 'A' (texto), obtém o 'Z' (criptograma).
    - se clicar no 'Z' (criptograma), obtém 'A' (texto)
    - Uma letra nunca pode ser cifrda por si própria ('A' -> 'Z')

Enigma -> máquina de rotores alemã.

### **Criptografia: Aproximações Teóricas**
- Espaço de texto (nº de combinações de texto diferentes)
- Espaço do criptograma (nº de criptogramas diferentes)
- Espaço de chaves (nº de chaves diferentes para um algoritmo de cifra, k)
- Cifra perfeita
- Cifra de Vernam -> aplicar XOR ao texto e ao criptograma

### **Criptografia: Aproximações práticas**

- Teórico vs Prático
    - Uso teórico != epxloração prática
    - Práticas incorretas podem compromoter boas cifras ()Por exemplo, reutilizar one-time-pads)
- Cifras seguras na prática
    - Dificuldade computacional de realzair criptanálise --> Segurança
    - Segurança baseada em limites razoáveis
        - Custo
        - Infraestrutura reservada
        - Tempo útil de criptanálise

Os 5 critérios de Shannon:
1. Quantidade de secretismo oferecida
2. Complexidade na escolha das chaves
3. A simplicidade da realziação
4. A propagação de erros
5. A dimensão do criptograma

- Confusão
    - Complexidade na relação entre o texto, a chave e o criptograma (a dependência entre os bits resultantes e os de entrada deve ser complexa)
- Difusão
    - Alteração de grandes porções do criptograma em função de uma pequena alteração de texto (1 bit do texto muda --> o criptograma muda substancialmente, de fomra imprevisível e pseudo-aleatória. Efeito avalanche)


Devemos assumir, sempre, o pior caso.

- O criptoanalista conhece o algoritmo
- Ele possui um grande número de criptogramas gerados com um algoritmo e chave (criptogramas não são secretos)
- Ele conhece parte dos textos originais
    - É normal haver uma noção do texto original
    - Ataques com texto conhecido ou esocolhido

### **Robustez criptográfica**

A robustez dos algoritmos existe até serem quebrados, aí deixam de ser robustos. Existem orientações/guidelines sobre o que deve/ não deve ser usado.

- Os algoritmos públicos, sem ataques conhecidos, são os mais robustos.
- Maior a chave -> maior a robustez
    - Mas em contrapartida, mais lentos

### **Cifras contínuas (Streams)**

-Precisa de uma chave contínua **aleatória**(one time pad) ou **pseudoaleatória**(produzida por um gerador)
- Utiliza a operação lógica XOR
- É uma cifra poli-alfabética
- Keystream pode ser infinita, no entanto tem um período (dependente do gerador)
- Aspetos de segurança das keystreams
    - keystream -> usada apenas 1 vez
    - Caso contrário, somando os criptogramas, obtemos o texto
    - Dimensão do texto tem de ser **menor** que o período
    - Controlar a integridade é importante. Só existe confusão e não difusão


### **Cifras modernas - Tipos**

- Quanto à operação:
    - Por blocos (mono-alfabética)
    - Contínuas (poli-alfabéticas)
- Quanto à chave:
    - Simétricas
    - Assimétricas (chave pública)

Cifras contínuas com chaves assimétricas não existem.

### **Cifras simétricas**

É uma chave secreta única, partilhada por 2 ou mais pessoas envolvidas numa comunicação (exemplo: whatsapp chat)

Permitem:
- Confidencialidade para os conhecedores da chave
- Autenticar as mensagens

Vantagens: 
- Desempenho

Desvantagens:
- Para N pessoas envolvidas, 2 a 2, são precisas N*(N-1)/2 chaves

Problemas:
- Distribuir as chaves

### **Cifras Simétricas contínuas**

Aproximações usadas:
- Desenho de geradores pseudo-aleatórios
    - Baseados em LFSRs, cifras por blocos, etc
- Normalmente são síncronos
    - Emissor/Recetor têm de estar sincronizados
- Sem possibilidade de acesso aleatório rápido


### **Cifras simétricas por blocos**

Aproximações usadas:
- Blocos grandes (maior que 128 bits)

Difusão e confusão:
- Podem ser feitas:
    - Permutações, substituições, expansões ou compressões
- Redes de feistel com múltiplas iterações
- Redes de substituição-permutação

### **Redes de substituição-Permutação**

S-Box(Substituição):
- Baseado num bit de entrada, troca bits de saída
- a substituição não é direta (1 for 1)
- Ideal seria que a alteração de um bit provocasse a alteração de todos os bits
- Na prática, alterar 1 bit só altera, pelo menos, metade dos bits

P-box(Permutação):
- permuta a posição dos bits de entrada e saída
- ideal seria permutar a posição de todos os bits

Ambas as operações são dependentes da chave.

### **DES - Data Encryption Standard**
### **DES-Robustez**

Escolher as chaves
- maior parte dos valores de 56 bits são adequados, mas existem 4 chaves fracas, 12 semi-fracas e 48 quase-fracas
- São fáceis de identificar e de evitar

Ataques conhecidos:
- Pesquisa exaustiva (Tentar todas as soluções até encontrar a correta)

Atualmente 56 bits não são suficientes. Uma pesquisa exaustiva é técnica e economicamente viável.

Solução:
- Cifras múltiplas
    - Cifra tripla/ triple DES
    - 2 ou 3 chaves
    - chaves de 112 ou 168 bits
    - usa-se a mesma chave, logo o algoritmo é compatível com o DES


### **Cifras por blocos - Modos**

- Processam texto em bloos de bits
    - texto é múltiplo do tamanho do bloco
    - tamanho do criptograma é igual ou maior ao tamanho do texto

- Podem aplicar mecanismos de difusão e confusão
    - dentro de caca bloco, podendo ser usados como cifras contínuas
- Método de cifra mais comum

AES é a cifra mais popular

- Inicialmente proposto para o DES
- Em teoria, podem ser usados com outras cifras


### **Modo - Electronic Code block(ECB)**

- cifra/decifra direta de cada bloco
- os blocos são independentes
- mas há um problema:
    - T1 = T2 -> C1 = C2

### **Modo - Cipher Block Chaining(CCB)**

- Cifra cada bloco Ti com feedback do Ci-1
- Decifra cada bloco Ci com feedback do Ci-11
- Bloco inicial utiliza IV (Initialization Vector)
    - valor aleatório único

### **ECB vs CCB**

Exemplo de imagens, apesar do processo de cifra, com ECB dá para ver a silouete de elementos, enquanto que no CBC é imposśivel ver algo em concreto.

### **ECB/CBC problemas de alinhamento**

- Ambos precisam de textos com dimensão múltipla da dimensão do bloco
- Blocos incompletos necessitam de tratamento especial (padding?)
- Resultado é um bloco
- Cifrar o último bloco de forma diferenciada
    - Ciphertext stealing
        - Usa parte do riptograma do penúltimo bloco para preencher o último
        - Usa excipiente fixo e cifra contínua antes de cifra por blocos

### **Reforço da Segurança**

- Cifra dupla:
    - Violável por intromissão em 2^(n+1) tentativas
    - não é muita segura
- Cifra tripla:
    - normalmente usa-se k1 = k3
    - Se k1=k2=k3, torna-se numa cifra simples

Caso de exemplo para a cifra dupla:

- cifra dupla com 2 chaves
- Se conhecermos o Texto e o Criptograma, podemos calcular todos os valores cifrados e cifrados variando as chaves, ou seja, para todos os valores D (decifrar) variando Kb, e para todos os valores E (cifrar) variar Ka
- Descobrimos as chaves quando a igualdade se verificar

Técnica de branqueamento ( simples e eficiente de introduzir confusão):
- Ci = Ek(K1 XOR Ti) XOR K2
- Ti = K1 XOR Dk(K2 XOR Ci)


### **Cifras assimétricas por blocos**

- Par de chaves
    - 1 privada
    - 1 pública

- Permitem
    - Confidencialidade
    - Autenticação de conteúdos(Integridade) e de autoria (assinaturas digitais)

- Vantagens
    - Interação de N pessoas requer apenas N pares de chaves

- Desvantagens
    - Desempenho

- Problemas
    - Distribuir as chaves públicas (tem de ser feito à priori)
    - Tempo de vida dos pares de chaves(tẽm de expirar)

- Aprximações -> complexidade matemática
    - cálculo de logaritmos discretos
    - fatorização de grandes números
    - Knapsack problem

- Algoritmos mais usados
    - RSA
    - ELGammal
    - Curvas elíticas

### **Como é assegurada a confidencialidade**

- O transmissor cifra o texto com a chave pública e o recetor decifra o criptograma com a chave privada.
    - Neste processo o recetor não faz ideia de quem produziu o criptograma
    -  Não existe autenticação de origem


### **Como é assegurada a autenticação**

- O transmissor cifra o texto com uma chave privada e o recetor decifra com uma pública.
    - O criptograma não pode ser alterado
        - Pois só o transmissor conhece a chave privada
    - Não há confidencialidade
        - quem tiver a chave pública pode decifrar o criptograma

### **Randomização de cifras com chave pública**

- O resultado de uma cifra com chave pública não deverá ser determinístico
    - N cifras do memso valor, com a mesma chave --> n resultados diferentes

- Técnicas
    - Concatenar o valor a cifrar com dois valores, 1 fixo (controlode erros) e um aleatório( para randomização)


### **Como melhorar a performance?**

- Cifra híbrida ( mistura de cifra assimétrica com simétrica)
    - Usa-se o melhor ambos os mundos
    - Bom desempenho (devido á simétrica)
    - Boa utilização de chaves públicas ( devido à assimétrica)


### **Funções de síntese/Digest**

- Resultado de tamanho constante, mas com entradas variáveis
- Entradas semelhantes -> resultados muito diferentes
- Algumas propriedades importantes:
    - Resistência à descoberta de um texto
        - Dada um síntese, é difícil encontrar o texto que o prduza
    - Resistência à descoberta de um segundo texto
        - Dado um texto, é difícil encontar um 2º textto que produza a mesma síntese
    - Resistência à colisão
        - Difícil encontrar 2 textos com a mesma síntese
- Aproximações
    - Difusão e confusão em funções de compressão
- Algoritmos mais comuns
    - MD5
    - SHA-1
    - SHA-2, aka, SHA-256

### **MIC - Messgae Integrity Code**

- Capacidade de detetar alterações
    - devidos a erros ou por motivos aleatórios
- Muito giro, mas não protege contra alterações deliberadas
    - Atacante manipula o texto no T'(texto recebido)

### **MAC - Message Authentication Code**

- Síntese é feita com recurso a uma chave
    - Só quem conhece a chave pode gerar o MAC
- Utilizada para garantir autenticidade

Aproximações:
- Cifrando uma síntese normal
- Usando uma função chaveada
- Usando uma chave nos parâmetros da função


### **Assinaturas digitais**

- Autenticam o conteúdo dos documentos
- autenticam o autor
- Previnem repudiação do conteúdo

Aproximações:
- Cifra assimétrica sobre Síntese
    - síntese usada por questões de desempenho
    - cifra assimétrica para garantir autenticidade

### **Assinaturas de forma cega**

- Servem par agarantir o anonimato e a não alteração da informação assinada

### **Derivação de chaves**

- Os algoritmos requerem chaves com uma dimensão fixa
    - 56, 128, 256 bits ( potências de 2)
- Existe a necessidade de derivar as várias fontes
    - Segredos partilhados
    - Passwords são geradas por humanos
    - Códigos pins e segredos pequenos
- Fonte original pode ter baixa entropia
    - Reduz a dificuldade de um ataque de força bruta
    - A transformação entre a fonte e a chave tem de ser complexa
- Necessidade de poder chegar-se a múltiplas chaves para a mesma password
    - Assim, evita-se deduzir a password a partir da chave gerada
- Reforço das chaves, aumentando a segurança de uma password
- Expandir a dimenao das chaves -> aumentar o tamanho de uma password

A derivação de chaves implica a existência de:
- um sal que torna a geração única
- problema custoso
- grau de complexidade parametrizável

Existem dificuldades computacionais:
- Transformação requer recursos computacionais relevantes

Existem dificuldades de armazenamento:
- Transformação ocupa recursos de armazenamento relevantes
(memória)

### **Derivação de chaves - PBKDF2**

- Produz uma chave com um **custo computacional** pré-definido

Como é produzida a chave:
- K = PBKDF2(PFR, Sal, Iterações, Password, dim)
    - PFR -> Síntese
    - Sal -> Um valor aleatório
    - Iterações -> Custo (um valor nas centenas de milhares)
    - Password -> Um segredo
    - Dim -> dimensão do resultado pretendido
- Operação realiza N * dim operações dp PRF, com base no SAL e password
    - Maior o N -> Maior o custo

### **Derivação de chaves: Scrypt**

- Produz uma chave com um custo de armazenamento pré-definido

---

## **Gestão de Chaves Assimétricas**

- Problemas a resolver
    - Garanitr que os pares de chaves são utilizados de forma apropriada
    - Evolução temporal do mapeamento entre entidade <-> par de chaves
    - Garantir a geraçao correta dos pares de chaves
- Objetivos
    - Gerar os pares de chave
    - Manusear as chaves privadas
    - Distribuir as chaves públicas
    - Ciclo de vida dos pares de chaves
- Certificados digitais das chaves públicas
- Utilização de um par de chaves
- Entidades certificadoras (CA)
- Entidades certificadoras confiáveis
- Hierarquias de certificação:
    - Modelo PEM
    - Modelo PGP
- Refrescamento das chaves assimétricas
- Listas de revogação de certificados (CRL)
- Online Certificate Status protocol
- Distribuição de certificados de chaves públicas
- PKI:
    - Public Key Infasctructure
    - Relações de confiança
    - Fixação de certificados
- Transparência de certificados
    

### **Problemas a resolver?**

**Temos de garantir que os pares de chaves são utilizados apropriados.**

- Manter a privacidade Chaves privadas
    - Garantir autencidade
    - Prevenir a repudição das assinaturas
- Distribuir, corretamente, as chaves públicas
    - Garantir confidencialidade
    - Garantir a validação correta das assinaturas digitais

**Evolução temporal do mapeamento entre entidade <-> par de chaves.**

- Lidar com ocorrências catastróficas
    - Perdas de chaves privadas
- Lidar com requisitos básicos da sua exploração
    - Atualizar pares para reduzir riscos de impersonificação

**Garantir a geração correta dos pares de chaves**

- Garantir uma qualidade dos pares de chave
    - Aleatoriedade
    - Evitar que possam ser adivinhadas
- Melhorias de eficiência sem comprometer a segurança
    - Tornar os mecanismos mais úteis
    - Aumentar a performance

### **Objetivos**

1. Gerar as pares de chaves
2. Manusear as chaves privadas
3. Distribuição de chaves públicas
4. Ciclo de vida dos pares de chaves

### **Geração de chaves**

<u>Princípios:</u>

- Devemos utilizar geradores bons na produção de segredos.
    - O resultado é indistinguível do ruído
- Ter processos fáceis, mas sem que a segurança seja comprometida
    - Chaves públicas eficientes
- A chave privada deve ser gerada pelo **próprio**
    - Assim, assegura-se ao máximo a sua privacidade
    - Este princípio pode ser relaxado caso não se pretenda assinaturas digitais

<u>Cuidados: </u>

- Correção
    - A chave privada representa o sujeito
    - O caminho de acesso à chave deve ser controlado
- Confinamento
    - A chave deve ser armazenada numa entidade autónoma e segura
    - A chave é utilizada de forma protegida


### **Distribuir as Chaves Públicas**

Como deve ser feita esta distribuição?

- Quem quer enviar informação confidencial:
    - De forma manual
    - protegida por segredo partilhado
    - Uso de certificados digitais
- Quem quer validar informação autenticada(recber):
    - Manual
    - Uso de certificados digitais

Como garantir a correção de uma chave pública?
- Disseminação confiável de chaves públicas.
    - Uso de caminhos e grafos de relações de confiança
- Hierarquias e grafos de certificação

### **Certificados digitais de chaves públicas**

<u>Documentos digitais emitidos por uma entidade Certificadora.</u>

- Ligam a uma chave pública a uma entidade
- Documentos públicos
- São seguros por meios criptográficos


<u>Usados para distribuir chaves públicas de forma confiável</u>

- Os verificadores podem validar os documentos
- Os verificadores confiam no comportamento das CA 

### **Utilizações de um par de chaves**

- O certificado associa um par de chaves a um perfil de utilização restrito.
    - Cada certificado -> cada utilização
    - Key Usage (definido no certificado)
-  Perfis típicos
    - Autenticação/distribuir as chaves
    - Assinatura de documentos
    - Emitir certificados

### **Entidades certificadoras (CA)**

- Organizações que gerem certifcados de chave pública
- É importante que operem corretamente para serem confiáveis
    - Definem políticas e mecanismos para
    - Emitir, revogar e distribuir certificados
    - Distribuir e emitir chaves privadas correspondentes
- Gerem os processo de revogação de certificados

### **Entidades certificadoras confiáveis**

- CA raiz
    - podem ser confiáveis por um grupo restrito ou uma maioria
    - Possuem processo de gestão confiáveis
- CA intermédias -> são certificadas por outra CA
    - através de um certificado, formam hierarquias de certificação
- Raízes de confiança/certificação
    - **Alguém possui e confia numa chave pública**
    - Certificados das CAs são auto-assinados
    - Distribuição manual

### **Hierarquias de certificação: Modelo PEM**

- Distribuição de certificados para o Privacy Enhanced Electronic (PEM) mail
- Modelo de monopólio
    - 1 raiz única
    - Várias PCA (Policy creation authorities)
    - Várias CAs abaixo de cada PCA
    - Forma uma cadeira de certificação
    - árvore de raiz única
- Nunca foi implementado a nível global
- Floresta de hierarquias em cada CA, sem um IPRA, é preferido
- Cada CA raiz negoceia a distribuição da sua chave pública em cada entidade
 

### **Hierarquias de certificação: Modelo PGP**

PGP -> Pretty Good Privacy

- Modelo baseado numa rede de confiança
- Não existe nenhuma autoridade central de confiança
- As pessoas uam dois tipos de confianças
    - chaves
    - comportamento de certificadores

**Confiança transitiva**

No fundo, é esta relação:

```
A --> B & B --> C, logo A --> C
```

- Uma pessoa pode confiar noi«utra
    - Confiança é unidirecional, pessoal e subjetiva
    - Níveis:
        - ultimate: chaves próprias das quais se tem a chave privada
        - complete
        - Marginal
        - no trust/Untrusted
- Validade: quanta verificação a chave possui
    - Válida: confiança total entre as pessoas
        - A confia totalmente em B, e B assinou a chave de E
    - marginalmente válida: 
    - Inválida: não há caminho

### **Refrescamento de chaves assimétricas**

- Pares de chaves devem ter uma validade limitada
- Problemas:
    - Certificados podem ser copiados e distribuídos livremente
    - O universo do possuídores de certificados não é conhecido
- Soluções:
    - Certificados com uma validade temporal definida (não antes nem depois)
    - Listas de revogação de certificados

### **Listas de Revogação de certificados (CRL)**

- Listas assinadas com ids de certificados revogados prematuramente
- Publicação e distribuição de CRLs
- Vários formatos disponíveis:
    - Base CRL -> lista completa com os certificados revogados
    - Delta CRL -> lista com diferenças desde a última CRL
    - OCSP -> API para verificar cada certificado (1 a 1)

### **Online Certificate Status Protocol**

- Protocolo baseado em HTTP para verificar a revogação de certificados
- Reduz a largura de banda usada pelos clientes
- pode precisar de maior largura de banda para as CAs
- OCSP stapling
    - instante temporal assinado na resposta
    - clientes podem guardar resposta durante a sua validade

### **Distribuição de certificados de chave pública**

- Transparente e integrado nos istemas e aplicaçoes
- Explicitamente pelo utilizadores

### **PKI: Public Key Infrastructure**

Infraestrutura de apoio ao uso de pares de chaves e certificados

- Criação segura de pares de chaves assimétricas
    - Políticas de subscrição
    - Políticas de geração de pares de chaves
- Criação e distribuição de certificados de chaves públicas
    - Políticas de subscrição
    - Definição de atributos do certificado
- definição e uso de cadeias de certificação
- Atualização, publicação e consulta de listas de certificados revogados
- Uso de estruturas de dados e protocolos que permitem a interoperação entre componentes


### **PKI: Relações de confiança**

- Um PKI estabelece relações de confiança de duas formas:
    - emitindo certificados de chaves públicas de outras CAs
    - Requerendo certificação da sua chave pública a outras CAs
- Relações de confiança características
    - Hierárquicas
    - Cruzadas (A certifica b e vice-versa)
    - ad-hoc (meshed)
        - grafos complexos de certificação

### **PKI: Fixação dos Certificados (Pinning)**

- Se um atacante possui acesso a uma raiz de confiança, ele pode emitir qualquer certificado para qualquer entidade
- Certificate Pinning -> Adicionar uma impressão digital da chave pública ao código
    - impressão digital usa síntese
    - Associado a um pedido HTTP
- Processo de validação normal +  verificação de impressão digital
    - certificado tem de ser asssinado por uma raiz de confiança
    - certificado tem de ter uma chave pública com a impressão digital especificada


### **Transparência de Certificação (RFC 6962)**

- Problemas:
    - CAs podem ser comprometidas
    - É difícil de detetar um comprometimento

Definição --> **Sistema que regista todos os certificados públicos emitidos**
- só são publicados certificados que levam raízes legítimas
- Armazena toda a cadei a de certificação de cada certificado
- Apresenta esta informação para auditoria


---

## **SmartCards e Cartão de cidadão**

- Smartcards
- Pilha de comunicações / comunication stack
- Modelo de computação do Smartcard - Cartões Java
- Cartão de cidadão
    - Atributos Visuais
    - Atributos Digitais
- Proteção por pin
- Certificados no smartcard
    - Objetivos
    - Interoperação com outras aplicações
- Aplicações no cartão de cidadão
- Serviços criptográficos do Smartcard
    - Midldeware
- PTEID middleware and SDK
- Assinatura de documentos
- Autenticação com o CC
- Autenticação.gov
- Chave Móvel Digital


### **Smartcards**

- São dispositivos físicos para armazenamento de chaves e operações sobre as mesmas.
    - São invioláveis, resistentes  a ataques por canais paralelos ou vírus.

- Têm como objetivo, permitir utilizar as chaves sem o seu compromisso.

- Como utilizamos? Para nos **autenticarmos**.

- Têm capacidade de computação, possuem:
    - CPU
    - ROM
    - EEPROM
    - RAM

- Possuem uma interface:
    - com contactos
    - sem contactos

### **Pilha de comunicações**

- Interação com o smartcard, protocolos de baixo nível T = 0, T = 1:
- T = 0:
    - Envia um octeto de cada vez
    - Mais lento
- T = 1:
    - octetos transmitidos em blocos
    - Mais rápid, mas requer suporte nas camadas superiores
- ATR:
    - Resposta à operação RESET
    - Reporta o protocolo esperado pelo cartão

### **Codificação de objetos nos smartcards**

- Tag-Length-Value:
    - Tag --> tipo de objeto
    - Length --> tamanho do objeto
    - Value --> Dados do objeto
- TLV é codificado através das regras ASN.1 BER
- Dados de um objeto podem conter outros TLV
- Permite ignorar objetos desconhecidos


### **Modelo de computação do Smartcard - Cartões Java**

- Smartcards executam Applets Java (Utilizam o java Card Runtime Environment)
- O JCRE executa em cima do SO nativo


### **Cartão de cidadão**

**Definição** --> É um cartão de identificação das dimensões de um cartão de crédito.

- Possui vários métodos de fornecer informação e identidade:
    - Informática (interação com o smartcard)
    - Visual, legível por humanos
    - Visual, legível por dispositivos

#### **Atributos Visuais: legíveis por hhumanos**

- Nome
- Atributos físicos (Sexo e altura)
- Outros (data de nascimento, fotografia, assinatura caligráfica)
- Números (identificação civil e checksum, fiscal, segurança social, SNS, validade)
- Versão do cartão

### **Atributos visuais: legíveis por dispositivos**

- Nome
- Atributos físicos (Sexo e altura)
- Outros (data de nascimento, fotografia, assinatura caligráfica)
- Números (identificação civil e checksum, fiscal, segurança social, SNS, validade)
- Versão do cartão


### **Atributos Digitais**

- Todos os atributos visíveis, exceto a assinatura
- Morada
- Modelo da impressão digital biométrica
- 5 certificados de chave pública
    - 2 relacionados com os pares de chaves anteriores e 3 relacionados com CAs intermédias necessárias para construir o caminho de certificação
- 1 chave simétrica para EMV-CAP(foi retirado recentemente)
- 4 códigos de utilizadores (Pins)
    - Autenticação, morada, assinatura e o PUK

### **Proteção por PIN**
- Ter o cartão é unsificiente para:
    - Obter a morada (nos recentes é possível)
    - Obter ou usar a chave privada de autenticação
    - Obter ou usar a chave privada de assiinatura
    - Obter ou usar a chave secreta de EMV-CAP

- Operações protegidas por PIN:
    - PIN de 4 números
    - PIN é bloqueado após 3 tentativas incorretas

- Exceções:
    - Forças policiais podem obter a morada sem o PIN 

### **Certificados no Smartcard: Objetivos**

- Permite autenticar o dono do cartão
- Permite o dono autenticar outras pessoas com cartões semelhantes
- Permite ocartão autenticar clientes com certificados semelhantes


- CAs intermédias com duração muito limitada.

### **Interoperação com outras aplicações**

- Inserção
    - Aplicações obtêm certificados e inserem-nos nos repositorios dos navegadores
    - Utilização das chaves é condicionada pelo PIN
- Remoção
    - Aplicações removem os certificados dos repositórios dos navegadores

### **Aplicações no cartão de Cidadão**
- IAS Classic V3
    - autenticação e assinatura digital
    - Utilização de pares de chaves assimétricas
- EMV-CAP:
    - Geração de one-time-passwords para canais alternativos (foi retirado em 2016)
- Precise Biometric BIO Match on card
    - Validar impressões digitais

### **Middleware**

- Bibliotecas que servem de ponte entre as funcionalidades do Smartcard e as aplicações de mais alto nível.

### **PKCS#11 - Integração do Middleware Cryptoki**

- Existe uma hierarquia de objetos
- Sessões de cryptoki:
    - Ligações lógicas entre aplicações e cartões:
        - sessões de leitua/leitura e escrita
    - Operações em sessões ativas
        - login-logout
        - criar/destruir objeto no cartão
        - Criptográficas
    - Objetos da sessão
        - Objetos temporários criados (e validados) durante a sessão
    - Tempo de vida das sessões
        - Normalmente, apenas para uma única operação

#### **Cryptoki --> Sessões de leitura**

- Sessão pública
    - acesso para ler os objetos públicos
    - acesso para ler/escrever nos objetos de sessão publica
- Funções de leitura do utilizador
    - acesos de leitua a todos os objetos do cartão (públicos e privados)
    - Acesso de ler/escrever a todos os objetos de sessão pública ou privada



#### **Cryptoki --> Sessões de leitura e escrita**

- Sessão pública de leitura e escrita
    - ler e escrever todos os objetos públicos
- Funções do SO de leitura e escrita
    - Ler/escrever objetos públicos (nada de privados)
    - O SO pode definir o PIN dos utilizadores (SO --> Security Officer)
- Funções do utilizador de Leitura e Escrita
    - Ler e escrever todos os objetos


### **Conceitos utilizados pelo CC**

- PIN de autenticação
    - PIN do utilizador no PKCS #11
- PIN de assinatura
    - não está exposto pela interface PKCS #11
- PIN de Morada
    - não exposto pelo interface PKCS #11
    - 0000 por defeito nos cartões recentes
- PKCS #11 SO PIN
    - não é utilizado pelos titulares do cartão


### **PTEID middleware & SDK**
- Distribuição pública
- Linguagens
    - bibliotecas dinâmicas para c/c++
    - Wrapper java para c/c++
    - Wrapper C# .NET
- Manuais
    - Validação do número de documento do CC
    - Autenticação com o CC
    - Manual técnico do middleware do cartão de Cidadão
    - Certificados e entidades de certificação
- API adicional para interagir com o CC
- Permite acesso aos dados relativos do cartão
    - nome, fotografia, etc
- Objetos PTEID armazenado como ficheiros


### **Assinatura de Documentos**

- CC permite gerar assinaturas e podem ser inseridas em documentos
- Assinatura digital representa uma substituição da assinatura caligrafada
- Utiliza chave privada e Selo temporal da PKI

### **Autenticação com o CC**

- Autenticador envia um NONCE ao CC para ser cifrado com a chave privada
- Problema:
    - Browsers não possuem acesso ao cartão
- Solução:
    - Utilizar um plugin no computador do utente

### **Plugin Autenticação.gov**

### **Chave móvel Digital**

- Tem como objetivo, possibilitar a autenticação/assinatura mesmo sem o CC presente
    - Havendo uma segurança de nível semelhante

- Princípios de funcionamento:
    - Precisa de um CC para autenticar o pedido de uma CMD
    - Utentes podem autenticar-se/assinar com a CMD
    - não precisa de plugin
    - Não precisa de cartão para utilização futura
    - Utiliza 2FA


- Processo baseado na criação de um par de chaves, armazenado remotamente:

1. Cidadão usa o CC para pedir uma CMD
2. É gerado um par de chaves
3. Chave pública enviada para geração de certificados
4. Chaves e certificado armazenados em ambiente seguro 
5. Permitidas operações a quem validar a autenticidade



---

## **Autenticação: mecanismos e protocolos**


- Autenticação
    - Tipo de provas
    - Objetivos
    - Requisitos
    - Entidades e Modelos de implantação
- Protocolos de autenticação: Aproximações elementares
- Sujeitos: 
    - Aproximação direta com senha memorizada
    - Aproximação direta com biometria
    - Vantagens da Biometria
    - Desvantagens da Biometria
    - Aproximação direta com senhas descartáveis
    - Vantagens das senhas descartáveis
    - Desvantagens das senhas descartáveis
    -  RSA SecureId e Yubikey
    - Aproximação Desafio Resposta
        - Conceito
        - Vantagens
        - Desvantagens
    - Desafio com Dispositivos
    - Desafio com Smartcards
    - Desafio Resposta com segredos partilhados
    - S/ key:
        - Processo de autenticação
    - Desafio Resposta com chaves partilhadas
- GSM: Autenticação do subscritor
- Autenticação de sistemas
- Autenticação de Serviços
- TLS (Transport layer Security)
    - Objetivos
    - Ciphersuites
- SSH (Secure Shell)
    - Mecanismos de autenticação
- Autenticação em sistemas específicos
- Dispositivos comuns
- Dispositivos móveis: smartphones
    - Android
    - Impressão digital
    - Reconhecimento Facial
- Computadores Portáteis
- OS:   
    - Windows
    - Linux
- Autenticação em sistemas distribuídos
- SSO --> Single Sign On


### **Autenticação**

- Tem com objetivo, provar uma entidade possui um atributo que diz ter



#### **Tipo de Provas**

- Algo que sabemos
    - segredo memorizado pela entidade
- Algo que temos 
    - um objeto/token possuído pela entidade
- Algo que somos
    - Biometria
- Autenticação multifatorial
    - Utilização simultânea de diferentes tipoos


#### **Objetivos**

- Autenticar entidades que interagem
- Possibilitar a aplicação de políticas de autorização e mecanismos
    - Relembrar que autorização != autenticação
- Facilitar a exploração de outros protocolos relacionados com segurança

#### **Requisitos**

- Confiança
    - quão boa é a provar a identidade de uma entidade?
    - Quão difícil é de subverter?
    - Level of assurance?
- Secretismo
    - Não divulgar as credenciais usadas pelas entidades
- Robustez
    - Impedir ataques
- Simplicidade
    - Deverá ser tão simples quanto possível para evitar que os utilizador escolham simplificações perigosas
- Lidar com vulnerabilidades vindas das pessoas
    - Existe a têndencia natural para facilitar ou para tomarem iniciativas perigosas


#### **Entidades e Modelos de Implantação**

- Entidades:
    - Pessoas, servidores, redes, serviços
- Modelos de Implantação:
    - Ao longo do tempo:
        - quando a interação inicia e durante o decurso da mesma
    - Direcionalidade:
        - Pode ser unidirecional ou bidirecional


### **Protocolos de Autenticação: aproximações elemnetares**

- Aproximação Direta:
    - Apresentar as credenciais e esperar pelo veredicto
- Aproximação com desafio-resposta:
    - Obter o desafio, calcular e fornecer a resposta calculada com base no desafio e credenciais e esperar pelo veredicto

### **Sujeitos**

#### **Aproximação direta com senha memorizada**

-  Senha é confrontada com um valor guardado para a pessoa que se está a autenticar
- Valor pessoal guardado


- Vantagens:
    - Simplicidade
Desvantagens/Problemas:
    - Usar senhas fracas/inseguras
    - Transmissão das senhas, em claro, em canais de comunicação inseguros


#### **Aproximação direta com Biometria**

- Pessoa autentica-se usando medidas do seu corpo
- Estas medidas comparadas com um registo pessoal similar

- Vantagens:
    - Não há necessidade do sujeito ter de memorizar algo
    - Pessoas não escolhem senhas fracas
    - Crdenciais não podem ser transferidas para outros
        - Dificulta roubos
- Desvantagens:
    - Alguns métodos ainda são incipientes
    - Sujeitos não podem alterar as credenciais
    - Credenciais não podem ser transferidas para outros
        - Dificulta atuar em situações de mergência (ex, situação médica)
    - Coloca os sujeitos em risco
    - De difícil aplicação em sistemas remotos
    - Biometria pode revelar informação pessoal

#### **Aproximação direta com senhas descartáveis**

- Senhas decartáveis/ One time passwords
    - só são utilizadas uma vez e são pré-distribuídas


- Vantagens:
    - Segredos podem ser escutados/canais inseguros podem ser utilizados
    - Segredos podem ser escolhidos pelo autenticador
    - Podem depender de uma senha
    - Podem depender de um dispositivo
- Desvantagens:
    - Entidades necessitam de mecanismos para saber que senha usar em cada ocasião (tem que have sincronização)
    - Sujeitos podem necessitra de recursos para armazenar ou gerar chaves
    - Mecanismos adicionais necessários podem ser roubados


#### **RSA SecureID**

- É dispositivo de autenticação pessoal
- Gera um único valor em intervalos fixos
- Como funciona:
    - Sujeito gera uma OTP combinando o userID com o número de dispositivo (OTP = UserID | Token)
    - o servidor RSA ACE realiza a mesam operação
- Robusto contra ataques por dicionário
- Vulneráveis contra ataques ao servidor

#### **YubiKey**

- Mesmo objetivo do dispositivo anterior
- Funciona como USB e/ou NFC
- Ao ativar gera uma chave de 44 carateres


#### **Aproximação Desafio resposta**

- Conceito --> credenciais não são constante e dependem de um desafio enviado pelo autenticador
    - sujeito acede ao autenticador
    - autenticador fornece o desafio
    - sujeito transforma o desafio
    - Envia o resultado aao autenticador
    - Autenticador valida o resultado do desafio
- Vantagens:
    - Credenciais não são expostas (não circulam num canal de comuicação e existe uma transformação de credencial)
    - Robustas contra ataques MITM (atacantes podem roubar desafio mas não conseguem replicar a transformação)
    - Compatíveis com outras aproximações
    - Autenticador escolhe a transformação e complexidade do desafio
- Desvantagens:
    - Sujeitos precisam de um método para calcular repostas aos desafios
    - Autenticador pode necessitar de armazenar segredos em claro
    - Pode ser possível calcular todas as respostas possíveis
    - Obriga que o autenticador faça uma boa gestão dos NONCEs
        - Não podem ser reutilizados
    
#### **Desafio com dispositivos**

- Credenciais de autenticação
- o autenticador sabe a chave pública
- è robusto contra:
    - ataques por dicionário
    - roubo da DB do servidor
    - canais inseguros


#### **Desafio com Smartcards**

- O autenticador gera um desafio
- Smartcard cifra o desafio com a chave privada
- Autenticador decifra o resultado com a chave pública
    - Uma alternativa seria verificar a assinatura

#### **Desafio Resposta com segredos partilhados**

- Credenciais de autenticação --> senha escolhida pelo sujeito
- O autenticador sabe:
    - por aproximação fraca --> a senha do sujeito
    - por uma aproximação melhor: uma transformação da chave
        - (Ideal --> transformação não é reversível)


- **Protocolo Básico de Desafio-Resposta**
    - Autenticador gera um valor único
    - Sujeito calcula uma transformação do valor com um segredo
    - Validação:
        - Autenticador calcula o resultado e compara
        - ou resultado = Ek(desafio) com k derivada da password


- Exemplos:PAP e CHAP
    - Point-to-Point protocol
        - Autenticação unidirecional (autenticador autentica sujeito e não o contrário)
    - PAP --> PPP authentication protocol
        - simples apresentação do par (UID/password)
        - transmissão insegura: apresentação direta do desafio
    - CHAP --> challenge response authentication protocol


- Exemplo2: S/key
    - Credenciais de autenticação: uma password
    - o autenticador sabe da última OTP usada pelo sujeito, o índice dessa OTP e a raiz de todas as OTPs
    - Configuração:
        - o autenticador define uma raiz/semente aleatória
        - o sujeito gera a OTP inicial
        - o autenticador armazena a raiz, o índice N e a OTPn
    - Processo de autenticação:
        - o autenticador envia a raiz e o índice do sujeito
        - o sujeito gera índice-1 OTPs consecutivas
        - Autenticador calcula H(resultado) e compara com o valor de OTPíndice armazenado

#### **Desafio Resposta com chaves partilhadas**

- Semelhante ao uso de senhas dos sujeitos
- Utiliza uma chave com dimensão e aleatoridade elevadas

#### **GSM: autenticação do subscritor**

- Baseado num segredo partilhado entre o HLR e o subscritor
- algoritmos, inicialmente, não são conhecidos
- A3 e A 8 são implementados no SIM e A5 na baseband
- MSC pede valores do subscritor ao HLR/AUC
- HLR gera RNAD e os restantes valores usadno uma KI
- A3/A8, frequentemente, é o algoritmo COMP128


#### **Autenticação de sistemas**

- Através do nome(DNS), endereço MAC e IP
- Uso de chaves criptográficas


#### **Autenticação de Serviços**

- Autentica o sistema
- As credenciais são exclusivas a cada serviço

#### **TLS - Transport Layer Security**

- Objetivos:
    - Comunicações seguras sobre TCP/IP
    - Mecanismos de Segurança (confidencialidade e integridade da comunicação, autenticação das entidades intervenientes)
- Ciphersuites:
    - Se o servidor usar um algoritmo específico, não se pode esperar que todos os clientes o suportem
    - a noção deste conceito é o que permite a negociação de mecanismos entre clientes e servidores


#### **SSH - Secure Shell**

- Objetivo --> gerir sessões interativas sobre tcp/IP
- Mecanismos de segurança  (confidencialidade e integridade da comunicação, autenticação das entidades intervenientes)
- Mecanismos de autenticação:
    - par de chaves assimétricas para o servidor
    - autenticação parametrizável para o cliente
- Chaves de longa duração em /etc/ssh/
- lista de números primos
- servidor pode restringir clientes e utilizadores
- Pode interagir com sistemas existentes
- Informação pessoal de cada utilizador em ~/.ssh
- Cliente:
    - chaves para autenticação com chaves assimétricas
    - config --> altera o comportamento para ums ervidor ou todos
    - know_hosts --> armazena as chaves públicas de servidores
- Servidor:
    - authorized_keys --> armazena as chaves públicas do cliente

#### **Autenticação em sistemas específicos1**

- Dispositivos operam frequentemente com base na identidade de um sujeito
- Validação de identidade é feita contra um modelo/ ou credenciais
- Normlamente fornecem mecanismos de autenticação local


#### **Dispositivos comuns**

- Dispositivos móveis
- computadores pessoais
- Computadores em redes
- Dispositivos de suporte

#### **Smartphone**

- São dispositivos pessoais
- podem fazer uso de cartão SIM e outro hardware
- Podem fazer uso de variados métodos de autenticação
- Composto por vários elementos distintos


#### **Android**

- TEE --> Trusted Execution Environment
- Gateways de segurança
- credenciais estão associadas a um sujeito
- Gatekeeper:
    - É necessário um aprovisionamento inicial
    - Gatekeeperd (no REE)
    - Fingerprint
- Keymaster:
    - fornece acesso ao armazenamento
    - Keymaster 1 --> android 6
    - Keymaster 2 --> android 7
    - Keymaster 3 --> android 8
    - Keymaster 4 --> android 9
- Android: Keymaster Key Attestation:
    - Objetivo --> Garantir que as chaves provêm do TEE implementado em hardware e são autênticas
        - Que são geradas no TEE atual
        - que são associadas à aplicação que faz o pedido
        - Que o dispositivo iniciou de forma segura
    - É chamada de attestKey(KeyToAttest, attestParams)
    - Resultado --> certificado x.506
- gatekeeper: autenticação
    - PIN
    - Senha
    - Padrão

#### **Impressão digital**

- TEE armazena vários modelos de uma impressão digital
- Perfil é obtido pelo sensor e validade no TEE
- Segurança varia com a implementação
- Leitores óticos:
    - Sensor adquire imagem do dedo
    - imagem é 2d
    - Apenas usado em versões agora obsoletas
    - Usado em autenticação de edifícios
- Leitores capacitivos:
    - Sensor possui uma matriz quer determina capaxidade
    - vulnerável a modelos físicos
    - Interferência de suor, loções e água
- Leitores ultrassónicos:
    - Composto por um emissor e um recetor
    - Mais resilientes e precisos
    - Mesmo assim, possuem falhas

#### **Reconhecimento facial**

- Objetivo --> Verificar correspondência entre uma imagem e um modelo treinado
- Requer um aprovisionamento inicial para treinar o modelo
- Probblemas:
    - imagens simples podem ser falsificadas
    - nem sempre robusto a alterações de luminosidade
    - Não robusto a alterações de sujeito(óculos, barba)
    - Não robusto a alterações de direção


#### **Computadores portáteis**

- Dispositivos potencialmente partilhados
- Autenticação nativa e depois delegada ao OS
- Sem suporte universsal para armazenamento generalizado de chaves
- Leitores ed impressões digitais semelhantes aos smartphones
- Sensores adicionais para reconhecimento facial
- Leitor de Smartcards
- Podem interagir com outros dispositivos


#### **Windows**

- Suporta variados métodos de autenticação
- Credenciais são armazenadas no Security Account Manager
- Desde o Vista: aplicação de user Access Control
- Senhas --> validação direta de um valor
- LM Passwords usadas até ao windows 7
- NTLM Password Hash
- Validação:
    - pedir a identificação e senha
    - Calcular a síntese e comparar com o valor armazenado

#### **Windows PIN**

- Suportado por um módulo seguro TPM
- Introdução do código PIN desbloqueia as chaves


#### **Windows HELLO**

- Autenticação Facial usando uma cãmara de infravermelho
- Vulnerabilidades:
    - Busto impresso?
    - fotografia visível a infravermelhos
    - simples fotofgrafia

#### **Linux**

- Suporta variados métodos de autenticação 
- Framework: Pluggable Authentication Modules
- Senhas --> armazenadas num ficheiro

#### **Linux - Senhas diretas**

- Dados da conta armazenados em /etc/passwd
- Credenciais em /etc/shadow
- Validação:
    - obter identificador e credenciais
    - obter sal e método de síntese
    - Calcular síntese (sal | senha)
    - Comparar resultado com valor armazenado 

#### **Autenticação em sistemas distribuídos**

- Comum utilizar-se autenticação centralizada
- Exemplo: autenticação centralida da UA
    - efetuada pelo serviço IDP.ua.pt


#### **SSO: Signle Sign On**

- Explora sistemas externos de confiança (TTP) para autenticação
- Serviços de AAA
- Vantagens:
    - reutilização das mesmas credenciais em vários sistemas
    - Repositório único para as credenciais
    - Pode implementar restrições ao perfil para cada sistema
- Desvantagens:
    - Precisa de mais recursos para o sistema de autenticação
    - Único ponto de falha
    - Falha implica perda de acesso a todos os sistemas
    - Introfuz atrasos nos processo de autenticação

- Requer um agente que expõe utilizadores remotos nos sitemas locais
- Pode forncer informação adicional do perfil
- Sistemas que fazem uso de SSO tẽm de ser aprovisionados

#### **SSO: LDAP --> Lightweight Directory Access Protocol**
- Protocolo para manter um diretório de informação
- Acesso ao diretório pode ter partes públicas e restritas
- LDAP Bind: associa uma sessão a um utilizador

#### **SSO: Kerberos**

- Protocolo de autenticação para ambiente de rede
- Suporta autenticação mútua
- Quatro entidades chave
- Key disrtibution center = AS + TGS (+ base de dados)


- Exemplo de uma autenticação de um cliente:
    - utilizador envia pedido ao AS com o seu clientID
    - AS responde com 2 mensagens
    - Utilizador usa a sua chave para decifrar A
    - Envia pedido ao TGS com 2 mensagens
    - TGS responde com 2 mensagens



---

## **Sistemas operativos**

### **2 Modos**
- Modo de utilizador --> execução normla do CPU
- Modo de supervisor --> execução de modo privilegiado do cpu com acesso a instruções privilegiado

### **Funções do sistema operativo**

- Inicializar os dispositivos
- Virtualizar o hardware
- Fornecer mecanismos de proteção
- Fornecer um Sistema de ficheiros Virtual

### **Níveis de execução**

- existem diferentes níveis
- Os procesadores têm 4 anéis
    - SOs, normalmente, só usam 2
- a transferência de controlo entre anéis requer mecanismos de passagem especiais

### **Execução de máquinas virtuais**

- Aproximação mais comum:
    - virtualização por software
    - execução do código em modo deutilizador
    - Tradução binária de código privilegiado

- Virtualização é assistida pelo hardware
    - Pode ser completa (anel -1)
    - Ou virtualizar hardware para vários núcleos no anel 0
- Implementam um mecanismo essencial para a segurança: **Confinamento**
- fornecem mecanismos adicionais:
    - controlo de recursos
    - prioritização de acesso a recursos
    - criação de imagens para análise
    - reposição rápida do estado esperado


### **Modelo computacional**

- Entidades/objetos são geridos pelo núcleo do SO
    - define como as aplicações e utilizadores interagem com o core
- exemplos:
    - ids
    - processos
    - memória virtual

### **Identificadores de utilizadores/UID**

- Para o SO, utilizador = número
- atividades executadas estãoa ssociadas a um UID


### **Identificadores de Grupos(GID)**

- Também existe identificadores de grupo
- Um utilizador pode pertencer a diversos grupos
- Em linux as atividades executam associadas a um conjunto de grupos

### **Processos**

- O processo contextualiza atividades
- Contexto possui relevância para a segurança (identidade, recursos em uso)

### **Memória Virtual**

- Espaço de memória onde têm lugar ações efetuadas por uma atividade
- A memória virtual não precisa de ser usada na íntegra
- a memória virtual é mapeada em RAM quando é necessário ler ou escrever

### **Virtual File System**

- Fornecem um método para representar pontos de montagem, diretórios, ficheiros e links
- Ponto de montagem --> acesso à raiz de um FS(File System) específico
- Diretório: um método de organização hierárquico
- Links: mecanismos de indireção no FS
- Ficheiros:
    - servem para armazenar dados de forma perene
    - São sequências ordenadas ed bytes associadas a um nome
    - O seu conteúdo pode ser alterado, removido ou acrscentado
    - Possuem uma proteção que controla o seu uso

### ** VFS - mecanismos de Segurança dos ficheiros e diretórios**

- Mecanismo de proteção mandatórios:
    - Dono
    - utilizadores e grupos permitidos
    - Permissões: leitura, escrita e execução
- Mecanismos de proteção discricionários
    - regras específicas definidas pelo utilizador
- Mecanismos adicionais:    
    - compressão implícita
    - indireção para recursos remotos
    - assinatura
    - Cifra

### **Canais de comunicação**

- São essenciais
- procesos do mesmo SO
    - pipes, sockets, streams, etc
- processos em máquinas distintas:
    - tcp/IP ou UDP/IP

### **Controlo de acessos**

- O núcleo de um OS é um monitor de controlo de acesso
    - controla todas as interações com o hardware e entre entidades do modelo computacional
- Sujeitos
    - Típicamente os processo locais
    - Mas também mensagens de outras máquinas

### **Controlo de Acesso Obrigatório/Mandatório**

- Existem inúmeros casos de controlo de acesso obrigatório num sistema operativo:
    - fazem parte da lógica do modelo computacional
    - Não são moldáveis pelos utentes e admins
- No linux:
    - quem é root faz tudo
    - sinais e processos são enviados pelo root ou dono
    - sockets são criados pelo root ou por processo com capacidade CAP_NET_RAW
- MACOS:
    - root pode fazer quase tudo
    - root não altera binários e diretórios assinados pela Apple

### **Controlo de acesso discricionário**

- Utilizadores podem definir regras para controlo de acesso
    - Podem ser definíveis apenas pelo dono/utilizador
- Exemplos:
    - listas de controlo de acesso discricionárias
    - Linux apparmor
    - MacOS sandboxd

### **Proteção com ACLs**
- Cada objeto possui uma ACL (access control list)
    - diz quem pode fazer o quê
- a ACL pode ser discricionária ou obrigatória
    - obrigatória não se modifica
    - discricionária pode ser alterada
- É verificada quando uma atividade pretende manipular o objeto
    - Pedido não autorizado é negado
    - o core do SO é que valida as ACLs

### **Proteção de ficheiros: ACLs de dimensão fixa**
- cada elemento do sistema de ficheiros --> 1 ACL
- Direitos de ficheiros/diretórios
    - Leitura/escrita
    - Escrita/adição e/ou remoção de ficheiros ou subdiretorias
    - Execução/uso como diretoria corrente do processo
- Entidades:
    - UID
    - GID
    - Os demais

### **Proteção de ficheiros: ACLs de dimensão variável**
- Cada elemento do sistema de ficheiros possui uma ACL e um dono
- Direitos:
    - Leitura: listagem para diretorias
    - Escrita: adição de ficheiros para diretorias
    - Execução: uso como diretoria corrente para diretorias
    - Acrescento: adição de subdiretorias para diretorias
    - Remoção de ficheiros e subdiretorias
    - Remoção (do próprio)
    - Leitura / escrita dos atributos
    - Leitura dos atributos estendidos
    - Leitura / alteração dos direitos
    - Tomada de posse
- entidades:
    - Utilizadores singulares
    - grupo de utilizadores

- Windows --> Cada recurso possui uma ACL e um dono
- Entidades:
    - utilizadores individuais
    - grupo de utilizadores

### **Elevação de Privilégios: Set-UID**

- Effective UID/Real UID
    - real uid = uid do processo criador
    - effective UID = UID do processo
- alterar o UID
    - aplicação normal:
        - eUID = rUID = UID
    - aplicção Set-UID:
        - eUID = UID da aplicação executada, rUID = UID inicial do processo
    -rUID não pode ser alterado
- Permite alterar ids dos processo, quando carregados de ficheiros específicos
- Permite aos utilizadores realizar tarefas de admin

### **Login: não é uma operação do core**

- Aplicação de login apresneta uma interface de login para obter as credenciais dos utentes
-  Esta valida as credenciais e obtém os UID e GID apropriados para o utente
- Daí em diante todos os processos criados pelo utente têm os seus identifcadores
- O processo de login tem de ser privilegiado

### **Processo de validação de senha**

- O nome do utente é usado para encontrar o parUID/GID no ficheiro /etc/passwd
- A senha é transformada usando uma função de síntese
- O resultado é verificaod face a um valor guardado no ficheiro /etc/shadow
- Proteções dos ficheiros
    - exemplo: /etc/shadow só pode ser lido pelo root

### **Ferramenta sudo**

- A administração pelo root não é adequada
- Aproximação preferível
- sudo é uma aplicação Set-UID com UID = 0


### **Mecanismo chroot**

- Reduz visibilidade do sistema de ficheiros
- É usado para proteger o sistema de ficheiros de aplicações potencialmente perigosas

### **Confinamento: Apparmor**
- Mecanismo para restringit aplicações com base num modelo de comportamento
- Ficheiros de configurações definem que atividades podem ser invocadas

### **Confinamento: Namespaces**

- Permite o particionamento dso recursos em vistas/namespaces
- Tipo de namespaces:
    - mount --> aplicado a pontos de montagem
    - Process_ID --> primeiro processo tem id 1
    - network --> stack da rede independente
    - IPC --> métodos de comunicação entre processos
    - UTS: independência de nomes (DNS)
    - user_id --> segregação de permissões
    - cgroup --> limitação dos recrusos utilizados

### **Confinamento: Containers**

- Explora namespaces para fornecer uma vista virtual do sistema
- Processo são executados no âmbito de um "container"
- aproximações relevantes: 
    - Linux container
    - Docker
    - Singularity


---

## **Armazenamento**

### **Problemas**

- Os dispositivos de armazenamento eventualmente avariam
    - é preciso minimizar falhas do disco e perdas de informação
    - sabemos que vai falhar, mas não quando
- Acesso mecânico à informação é lento  
    - Tempo = tempo de translação  + tempo de rotação
    - mais informação --> mais estrangulamento/mais demoraod
- SSDs têm um número de escritas mais reduzido
- Existem eventos que levam à perda total de dados
    - incêndios, picos de energia, inundações, erros humanos, etc
- Poderá ser necessário distribuir dados de forma inteligente
    - Para maximizar desempenho e reduzir custos


### **Soluções**

- Cópias de segurança/backups
- Armazenamento Redundante
- Discos mais caros, ambiente mais controlado
- Infraestruturas dedicadas de armazenamento

### **Backups**

- Cópias periódicas dos dados
- De forma completa --> imagem completa da informação
    - recuperação rápida, mas precisa de muito espaço
- De forma diferenciada --> compara as diferenças com o último backup completo
    - recuperação mais lenta, mas não precisa de tanto espaço
    - diferenciais diários vão aumentando de tamanho
- De forma incremental --> compara diferenças com o último backup
    - recuperação lenta, mas com grande eficiência de espaço

- Uma backups não é armazenar a informação num disco adicional!
- Existem políticas, mecanismos e processos, que devem ser considerados para realizar, manter e recuperar cópias de informação
- Existe também um enquadramento legal o que obriga a um cuidado especial
    - Existência de dados pessoais
    - tem de haver um política de retenção


### **Backups - Compressão**

- Compressão por algoritmos sem perdas
    - ex: ZIP
- Cópias seletivas de informação
- Deduplicação
    - armazenar apenas ficheiros/blocos únicos
    - Cópias totais com processo de redução posterior


### **Backups: Níveis**

- Aplicacional
    - extração de dados da aplicação
    - Representa uma vista consistente para a aplicação
    - Necessário repetir para todas as aplicações existentes
- Ficheiros
    - Cópia dos ficheiros individuais
    - Permite copiar qualquer aplicação
    - Estado guardado pode ser inconsistente
- Sistema de ficheiros
    - criação de registos de alterações periódicos
    - pode permitir recuperar ficheiros individuais ou não
- Blocos
    - Cópia dos blocos do suporte de armazenamento
    - Agnóstico do sistema de ficheiros e SO
    - Pode ser realizado pela infraestrutura de armazenamento


### **Backups - Local da Cópia**

- No mesmo volume ou sistema
    - permite a rápida recuperação de informação
    - Protege contra alterações/remoções indevidas de ficheiros
    - não protege contra avarias do armazenamento
- Num sistema localizado na mesma infraestrutura
    - acesso rápido
    - Protege contra falhas isoladas no armazenamento
    - não protege contra eventos naturais:
        - incêndios, roubos, inundações, etc
- Remotos (Off-Site)
    - realizados para um sistema a grande distância
    - Permitem recuperar informação em caso de evento com grandes danos
    - Recuperação de informação muito mais lento

### **Seleção do equipamento**

- Existem gamas diferentes: enterprise vs desktop
- é ajustado ao caso de uso e oa nível de desempenho
    - diferenças no nível de consumo, fiabilidade e desempenho
    - existem 3 tiers quanto ao desempenho:
        0. desempenho muito alto e baixa capacidade
        1. desempenho, capacidade e disponibilidade altos
        2. desemepnho baixo, alta capacidade

### **RAID - Redundant Array of Inexpensive Drives**

- Garantir a sobrevivência da informação
- Solução de baixo custo e é eficiente
- No entanto, isto não substitui o backup e pode aumentar a chance de falha do sistema

### **RAID 0 - striping**

- Objetivo --> acelerar acesso à informação do disco
- Aproximação --> Acesso a discos em paralelo e striping
- Prós:
    - Aceleração dos acessos aos discos até N-vezes
- Contras:
    - aumenta a probabilidade de perder informação
    - aumenta o número de dispositivos


### **RAID 1 - mirroring**

- Objetivo --> tolerar falhas de discos
- Aproximação --> Duplicação da informação
- Prós:
    - Diminuição da probabilidade de perda de informação
- Contras:
    - Desperdício da capacidade de armazenamento
    - Aumento do número de dispositivos


### **RAID 0+1**

- Objetivo --> benefícios do raid 0 e 1 (desempenho e resistência a falhas)
- Aproximação --> mirroring de columes stripped
- contras:
    - desperdício da capacidade de armazenamento
    - Aumento do número de dispositivos necessários


### **RAID 4**

- Objetivo --> ter a proteção do raid 1 e o desempenho/eficiência do raid 0
- Aproximação --> Armazenamento de dados em N-1 discos; armazenamento de paridade em um disco
- Problemas:
    - Necessita de 3 ou mais discos
    - A atualização da paridade é complexa e demorada
    - A recuperação é mais demorada do que com RAID 1


### **RAID 5 **

- Objetivos --> semelhante ao raid 4, mas mais eficient na escrita
- Aproximação --> 
    - Blocos de paridade espalhados por todos os discos
    - O desperdício de espaço é igual ao do raid 4
    - A concorrência nas escritas é melhorada
- Problemas:
    - mais complexo que o raid4


### **RAID 6**

- Objetivo --> melhorar a fiabilidade do raid 5
- Aproximação:
    - 2 blocos de paridade espalhados por todos os discos
    - O desperdício de espaço é maior do que o RAID 5
    - A concorrência na escritas é ligeiramente pior que o raid 5
- Problemas:
    - mais complexo que o raid 5
- Vantagens:
    - Permite falha simultânea de 2 discos

### **NAS e SAN**

- NAS --> Network Attached Storage
    - Disponível por rede
    - Frequentemente com vários discos em RAID
    - Custo: centenas a milhares de euros

- SAN --> Storage Area Network
    - Conjunto de sistemas disponíveis por rede
    - Pode implementar qualquer esquema de redundância
    - Custo: centenas de milhares a milhõe de euros

- Vantagens:
    - centralização de políticas de armazenamento
    - interface normalizado independente do armazenamento real
    - utilizados para armazenamento e cópias

### **Confidencialidade do armazenamento**

- Problema 1--> Sistema de ficheiros tradicional possui proteções que são limitadas
- Tipos de proteções:
    - físicas --> sistema de ficheiros é confinado a um dispositivo
    - lógicas --> o controlo de acesso é aplicado pelo SO e faz-se uso de ACLs e outros mecanismos de confinamento

- Problema 2--> existem situações onde esta proteção é irrelevante
- Caso de acesso direto e físico aos dispositivos:
    -  Acessos aos dispositivos anfitriões
    - Dispositivos de armazenamento discretos, por vezes externos
- Caso de casso através de mecanismos de controlo de acesso:
    - Acesso não ético pelos admins
    - Personificação dos utentes

- Problema 3--> Prevalência de armazenamento distribuído
- é preciso confiança em vários admins (às vezes, anónimos)
- autenticação é efetuada de forma remota
- Informação é transmitida na rede

#### **Soluções: Cifra de informação**

- Cifra/decifra do conteúdo dos ficheiros
- Problemas:
    - Acesso á informação:
        - utentes não podem perder as chaves
        - Cifra ilegítima ou abusiva da informação
    - Partilha de ficheiros
        - por si, implica a libertação de ficheiros ou de chaves
    - Possível interferência com tarefas comuns de administração

### **Nível aplicacional**

- Informação é transformada por aplicações autónomas
- Apresenta janelas de vulnerabilidades
- Informação pode ser transformada por algoritmos/aplicações diferentes
- Difícil partilhar ficheiros internos ao pacote cifrado


### **Nível aplicacional: TrueCrypt**
- Cria um ficheiro no FS que contém vários volumes
- Suporta Negação Plausível

### **Nível dos sistemas de ficheiros**

- Informação é transformada entre a memória e a escrita no volume

### **Nível dos volumes**

- Transforma informação a nível do controlador
- Políticas de cifra definidas ao nível da aplicação ou controlador
- Não resolve questões com sistemas distribuídos mas sim de dispositivos móveis


### **Bitlocker Windows**

- Cifra um volume inteiro
- Armazenamento da chave
- Processo da cifra


### **Nível do dispositivo**

- Dispositivo aplica política de segurança interna
- Vantagens:
    - sem perda de perfomance
    - Pode não ser trivial a extração de informação ou chaves
    - Possível de coordenar o processo com aplixações
- Desvantagens:
    - Quando o dispositivo é desbloqueado, dados ficam acessíveis
    - Segurança é limitada aos algoritmos presentes
    - Possível presença de erros ou backdoors é difícil
- Dispositivos possuem 2 áreas:
    - Shadow disk --> read only
    - Real disk --> write, contém dados e está protegido
- Duas chaves:
    - KEK --> Key Encryption Key (autenticação)
    - MEK --> Media (Data) Encryption Key
- Boot process:
    


---

## **Segurança em redes**

### **Comunicação sem fios: aspetos de segurança**

- Comunicação efetuada em Broadcast
    - difícil de controlar propagação
    - Limitações físicas são pouco eficientes contra:
        - interferência com as comunicações legítimas
        - Interceção das comunicações
- Mitigação
    - Mecanismo de redução e interceção e interferência

### **PHY: redução de inteferência e interceção**

- Prevenir que os atacantes descodifiquem o canal
- exemplo: bluetooh FHSS
    - frequência alterada segundo um padrão conhecido ao emissor e recetor
    - FHSS aparece como um impulso de ruído de curta duração
- Evita que o canal seja monopolizado por transmissores


### **MAC: Redução de interferência e interceção**

- Evita que atacantes identifiquem os participantes numa combinação
- Evita que atacantes compreendam os dados
- Evita que atacantes forjem tramas válidas

### **IEEE 8902.11: Arquiterua em redes estruturadas**

- Estação (STA)
    - dispositivo que se liga a uma rede sem fios
    - possui um id único, endereço MAC
- Ponto de acesso (AP)
    - Dispositivo que permite a ligação de dispositivos sem fios
    - permissão de interligação a outras redes com fios
- Redes sem fios
    - Conujnto formado por um conjunto de STAs E APs associados entre si e comunicando.

### **Terminologia**

- BSS --> Basic Service Set
    - Rede formada por estações e um AP
- Extended Service Set (ESS)
    - Rede formada por várias BSS interligadas por um distribution system
- Service Set ID (SSID)
    - Identificador de uma rede sem fios servida por uma BSS 
    - Um ap pode fornecer vários SSIDs

### **Tipos de mensagens**

- Mensagens de gestão
    - beacons, requests e responses --> probe, authentication, association, reassociation
    - Diassociation
- Mensagens de controlo
    - request to send
    - clear to send
    - ACK

### **WEP Wired Equivalent Privacy**

- Autenticação unilateral e facultativa
    - ap suporta vários modos ao mesmo tempo
- OSA: Open System Authentication
    - Não ha autenticação
- SKA Shared Key authentication
    - desafio e resposta entre a sta e ap
    - chave distinta po cliente ou rede
    - autenticação unilateral da sta
- Dados 
    - cifrados com RC4
    - autenticados usando um CRC-32


- WEP 'completamente inseguro, mesmo com SKA
- A mesma chave para autenticação e confidencialidade
- Controlo de integridade fraco
- Fraca gestão de IVs

### **WAP: WEP melhor**

- WAP = WEP mais seguro
- implementando inicialmente a nível do driver
- Alinhado com a especificação IEEE 802.11i

### **WPA (Wi-fi protected Access): TKIP**

- chaves temporais
- sequenciação de mensagens
- mistura de chaves
- controlo de integridade melhorado
- contra-medidas


### **Ataques Beck-tews**
- Condições
    - endereço da rede é conhecido no ínicio (parcialmente)
    - a rede suporta QoS com 8 canais
    - período de renovação é longo
    - Ataque chop-chop --> decifrar m bytes de um pacote, enviando m*128 pacotes, usando força bruta no ICV
- Ataque
    - Capturar pacote ARP
    - enviar pacotes, adivinhando o texto
    - força bruta sobre o endereço
    - reverter o mic
    - obter a keystream válida para qualquer TSC

### **WPA2**

- define uma robust Security Network
- Usa mecanismos avançados para proteção de mensagens
- Usa 802.1x para autenticação de clientes

### **Autenticação por portas**

- Modelo de autenticação para todas as redes
- Originalmente desenhado para grandes redes
- foco --> distribuição de chaves

### **Hierarquia de chaves**

- MSK --> resultado direto de um processo com EAP, arquitetura enterprise
- PSK --> Longo termo partilhada entre AP-STa, arquiterua SOHO
- PNK --> chave recente usada para autenticação mútuada ap-sta
- PTK --> chave para proteger interações entre sta-ap

### **EAP - Extensible Authentication Protocol**

- Inicialmente desenhado para o ppp
- AP não é envolvido
- Não concebido para redes sem fios


### **Segurança resolvida?**

- Ataques por dicionários ainda são possíveis
- Apenas os dados são protegidos
- Problemas a nível do meio de acesso
    - Atacante tem mais tempo de acesso

### **WPA2 - vulnerabilidades**

- falta de segurança futura
- descoberta de senhas
- descoberta do PIN WPS
- Reinstalação de chaves


### **WPA2 - ataques - segurança futura**

- Segurança futura remete para a reutilização de chaves
- WPA-PSK não possui descoberta da PMK/PSK, permite decifrar sessões anteriores
- WPA-Enterprise pode possuir
    - Se a PMK for diferente a cada autenticação

### **WPA2 - descoberta de senhas**

- Durante o $WH o atacnate consegue obter: ssid, ANonce, AP, MAC, STA MAC 
- chaves:
    - PMK = PBKDF2(HMAC−SHA1, senha, ssid, 4096, 256)
    - PTK = PRF(PMK | ANonce | SNonce | AP MAC |STA MAC)
- Ataque
    - atacnate espera por uma associação
    - atacnate captura ssid, Nonces, endereços MAC
    - Offline: força bruta ou diconário para calcular PTK
- APs enviam um valor para acelerar o processo de autenticação

### **WPA2 Reinstalação de chaves**

- forçar a vítima a reutilizar as chaves
- vulnerabilidade: Suplicant processa sempre a Msg3
- ataque:
    - bloquear msg4
    - ap irá retransmitir MSG3
    - chave é reinstalada
    - Pacode de dados volta a usar NONE = 1
    