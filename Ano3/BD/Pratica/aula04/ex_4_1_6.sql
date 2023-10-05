CREATE TABLE PESSOA (
num_cc int not null,
morada varchar(30) not null, 
data_nascimento date not null,
nome varchar(30) not null, 
PRIMARY KEY(num_cc),
);

CREATE TABLE ATIVIDADE(
desginacao varchar(30) not null,
custo int not null,
id int not null,

PRIMARY KEY(id),
);

CREATE TABLE TURMA(
designacao varchar(30) not null,
id_turma int not null,
ano_letivo int not null,
num_max int not null,
num_cc_professor int not null,

PRIMARY KEY(id_turma),
)



CREATE TABLE PROFESSOR (
num_funcinario int not null,
id_turma int not null,
contacto_telefonico int not null,
email varchar(30) not null,
num_registo int not null,
num_cc_pessoa int not null,
data_nascimento date not null,
nome varchar(30) not null,

PRIMARY KEY(num_cc_pessoa),
FOREIGN KEY(num_cc_pessoa) REFERENCES PESSOA(num_cc),
FOREIGN KEY (id_turma) REFERENCES TURMA(id_turma),
);

ALTER TABLE TURMA
ADD CONSTRAINT fk_turma_professor
FOREIGN KEY (num_cc_professor) REFERENCES PROFESSOR(num_cc_pessoa);


CREATE TABLE TEM(
id_turma int not null,
id_atividade int not null,

PRIMARY KEY (id_turma),
FOREIGN KEY (id_turma) REFERENCES TURMA(id_turma),
FOREIGN KEY (id_atividade) REFERENCES ATIVIDADE(id),

);

CREATE TABLE ALUNO(
morada varchar(30)  not null,
num_cc int not null,
data_nascimento date not null,
nome varchar(30) not null,

PRIMARY KEY (num_cc),
FOREIGN KEY (num_cc) REFERENCES PESSOA(num_cc),
);

CREATE TABLE FREQUENTA(
id_turma int not null,
id_atividade int not null,
num_cc int not null,

FOREIGN KEY (id_turma) REFERENCES TEM(id_turma),
FOREIGN KEY (id_atividade) REFERENCES ATIVIDADE(id),
FOREIGN KEY (num_cc) REFERENCES ALUNO(num_cc),


);

CREATE TABLE ENCARREGADO(
morada varchar(30) not null,
num_cc_pessoa int not null,
num_cc_aluno int not null,
data_nascimento date not null,
nome varchar(30) not null,
contacto_telefonico int not null,
email varchar(30) not null,

FOREIGN KEY (num_cc_pessoa) REFERENCES PESSOA(num_cc),
FOREIGN KEY (num_cc_aluno) REFERENCES ALUNO(num_cc),
);

CREATE TABLE ENTREGA_LEVANTA(
num_cc_aluno int not null,
num_cc_pessoa int not null,
data_nascimento date not null,
nome varchar(30) not null,
contacto_telefonico int not null,
email varchar(30) not null,
autorizado bit not null,

FOREIGN KEY(num_cc_aluno) REFERENCES ALUNO(num_cc),
FOREIGN KEY(num_cc_pessoa) REFERENCES PESSOA(num_cc),
);

