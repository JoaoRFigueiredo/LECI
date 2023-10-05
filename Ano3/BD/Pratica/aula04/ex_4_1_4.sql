CREATE TABLE MEDICO (
id int not null,
especialidade varchar(30) not null,
nome varchar(30) not null,

PRIMARY KEY(id),
);


CREATE TABLE PACIENTE(
num_utente int not null,
endereco varchar(30) not null,
data_nascimento date not null,
nome varchar(30) not null,

PRIMARY KEY (num_utente),
);

CREATE TABLE FARMACIA (
farmacia_nif int not null,
endereco varchar(30) not null,
nome varchar(30) not null,
telefone int not null,

PRIMARY KEY (farmacia_nif),
);

CREATE TABLE PRESCICAO(
m_id int not null,
data_presc date not null,
num_prescicao int not null,
num_utente int not null,
fnif int not null,

PRIMARY KEY (num_prescicao),
FOREIGN KEY (fnif) REFERENCES FARMACIA(farmacia_nif),
FOREIGN KEY (num_utente) REFERENCES PACIENTE(num_utente),
FOREIGN KEY (m_id) REFERENCES MEDICO(id),

);


CREATE TABLE FARMACEUTICA(
num_registo_nacional int not null,
endereco varchar(30) not null,
nome varchar(30) not null,
telefone int not null,

PRIMARY KEY (num_registo_nacional),
);

CREATE TABLE FARMACO (
nome char(20) not null,
formula varchar(30) not null,
num_registo_nacional_far int not null

PRIMARY KEY (nome),
FOREIGN KEY (num_registo_nacional_far) REFERENCES FARMACEUTICA(num_registo_nacional),

);

CREATE TABLE CONTEM(
num_prescicao int not null,
nome varchar(20) not null,

FOREIGN KEY (num_prescicao) REFERENCES PRESCICAO(num_prescicao),
FOREIGN KEY (nome) REFERENCES FARMACO(nome),

);