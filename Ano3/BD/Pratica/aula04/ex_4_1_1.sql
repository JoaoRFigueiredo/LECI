CREATE TABLE CLIENTE (
nif INT NOT NULL,
nome VARCHAR(30) NOT NULL,
endereco varchar(30) NOT NULL,
check (nif > 100000000 and nif < 999999999),
PRIMARY KEY (nif),
);




CREATE TABLE BALCAO(
numero int not null,
endereco varchar(30) not null,
nome varchar(30) not null,
PRIMARY KEY (numero),
);

CREATE TABLE TIPO_VEICULO(
desginacao varchar(30) not null,
arcondicionado bit not null,
codigo int not null,
PRIMARY KEY (codigo),
);


CREATE TABLE VEICULO(
ano int not null,
marca varchar(30) not null,
matricula char(6) not null,
codigo int not null,
PRIMARY KEY (matricula),
FOREIGN KEY (codigo) REFERENCES TIPO_VEICULO(codigo),

);


CREATE TABLE  ALUGUER (
numero int not null,
duracao int not null,
data_aluguer DATE not null,
cliente_nif int not null, 
numero_balcao int not null,
matricula_veiculo char(6) not null,
PRIMARY KEY (numero),
FOREIGN KEY (numero_balcao) REFERENCES BALCAO(numero),
FOREIGN KEY (cliente_nif) REFERENCES CLIENTE(nif),
FOREIGN KEY (matricula_veiculo) REFERENCES VEICULO(matricula),
);

CREATE TABLE LIGEIRO(
portas int not null,
numLugares int not null,
combustivel varchar(30) not null,
codigo_veiculo int not null,
FOREIGN KEY (codigo_veiculo) REFERENCES TIPO_VEICULO(codigo),

);


CREATE TABLE PESADO(
peso int not null,
passageiros int not null,
codigo_veiculo int not null,
FOREIGN KEY (codigo_veiculo) REFERENCES TIPO_VEICULO(codigo),

);

CREATE TABLE SIMILARIDADE(
codigo_1 int not null,
codigo_2 int not null,
FOREIGN KEY (codigo_1) REFERENCES TIPO_VEICULO(codigo),
FOREIGN KEY (codigo_2) REFERENCES TIPO_VEICULO(codigo),
);