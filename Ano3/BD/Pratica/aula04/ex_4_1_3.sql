CREATE TABLE EMPRESA (
enif INT NOT NULL,

PRIMARY KEY (enif),

);

CREATE TABLE FORNECEDOR(
fnif INT NOT NULL,
codigo_interno int not null,
nome varchar(30) not null,
fax int not null,
endereço varchar(30) not null,
condicoes_pagamento int not null check (condicoes_pagamento > 30 and condicoes_pagamento <= 90),

PRIMARY KEY (fnif),

);


CREATE TABLE ENCOMENDA (
id int not null,
data_realizacao date not null,
fnif int not null,
enif int not null,

PRIMARY KEY(id),
FOREIGN KEY (fnif) REFERENCES FORNECEDOR(fnif),
FOREIGN KEY (enif) REFERENCES EMPRESA(enif),
);

CREATE TABLE PRODUTO (
enif int not null,
iva int not null,
nome varchar(30) not null,
preco int not null,
num_produtos int not null,
codigo int not null,

PRIMARY KEY (codigo),
FOREIGN KEY (enif) REFERENCES EMPRESA(enif),

);


CREATE TABLE CONTEM(
encomenda_id int not null,
produto_codigo int not null,


FOREIGN KEY (encomenda_id) REFERENCES ENCOMENDA(id),
FOREIGN KEY (produto_codigo) REFERENCES PRODUTO(codigo),

);