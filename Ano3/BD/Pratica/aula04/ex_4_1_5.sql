CREATE TABLE ARTIGO_CIENTIFICO(
titulo varchar(30) not null,
num_registo int not null,

PRIMARY KEY (num_registo),

);

CREATE TABLE CONFERENCIA(
id int not null,

PRIMARY KEY (id),
);

CREATE TABLE INSTITUICAO (
nome varchar(30) not null,
endereco varchar(30) not null,
nome_instituicao char(20) not null,

PRIMARY KEY (nome_instituicao),

);


CREATE TABLE PESSOA(
nome varchar(30) not null,
email char(30) not null,
instituicao varchar(20) not null,

PRIMARY KEY (email),

FOREIGN KEY (instituicao) REFERENCES INSTITUICAO(nome_instituicao),

);

CREATE TABLE APRESENTA(
num_registo_artigo int not null,
id_conferencia int not null,

FOREIGN KEY(num_registo_artigo) REFERENCES ARTIGO_CIENTIFICO(num_registo),
FOREIGN KEY(id_conferencia) REFERENCES CONFERENCIA(id),

);


CREATE TABLE AUTOR(
nome varchar(30) not null,
email char(30) not null,

PRIMARY KEY (email),
FOREIGN KEY (email) REFERENCES PESSOA(email),

);

CREATE TABLE TEM(
email_autor varchar(30) not null,
num_registo_artigo int not null,

FOREIGN KEY(email_autor) REFERENCES AUTOR(email),
FOREIGN KEY(num_registo_artigo) REFERENCES ARTIGO_CIENTIFICO(num_registo),

);

CREATE TABLE PARTICIPANTE(
email char(30) not null,
nome varchar(30) not null,
id_conferencia int not null,
data_inscricao date not null,
morada varchar(30) not null,


PRIMARY KEY (email),
FOREIGN KEY (email) REFERENCES PESSOA(email),
FOREIGN KEY (id_conferencia) REFERENCES CONFERENCIA(id),
);

CREATE TABLE ESTUDANTE(
email_participante char(30) not null,
nome varchar(30) not null,
comprovativo varchar(50) not null,
data_inscricao date not null,
morada varchar(30) not null,


PRIMARY KEY (email_participante),
FOREIGN KEY (email_participante) REFERENCES PARTICIPANTE(email),
);

CREATE TABLE NAO_ESTUDANTE(
email_participante char(30) not null,
nome varchar(30) not null,
referencia int not null,
data_inscricao date not null,
morada varchar(30) not null,


PRIMARY KEY (email_participante),
FOREIGN KEY (email_participante) REFERENCES PARTICIPANTE(email),
);


