use movies_db;

-- Create tables
create table estudio(
    estudio_id int not null,
    ano_criacao date not null,
    localizacao varchar(20),
    nome varchar(30),
    primary key (estudio_id)
);

create table utilizador(
    user_id int not null,
    nome varchar(30),
    primary key (user_id)
);

create table avalia(
    user_id int not null,
    review varchar(100),
    content_id int not null,
    foreign key (user_id) references utilizador(user_id)
);

create table lista_generos(
    nome_genero_id int not null,
    nome_genero varchar(20),
    primary key(nome_genero_id)
);

create table genero(
    nome_genero_id int not null,
    content_id int not null,
    foreign key (nome_genero_id) references lista_generos(nome_genero_id),
    primary key(nome_genero_id)
);

create table lista_premios(
    nome_premio_id int not null,
    nome_premio varchar(20),
    primary key(nome_premio_id)
);

create table premio(
    nome_premio_id int not null,
    content_id int not null,
    foreign key (nome_premio_id) references lista_premios(nome_premio_id),
    primary key(nome_premio_id)
);

create table pessoa(
    num_cc int not null,
    nome varchar(30) not null,
    data_nasc date not null,
    primary key (num_cc),
    CHECK (num_cc BETWEEN 10000000 AND 99999999)
);

create table realizador(
    num_cc int not null,
    nome varchar(30) not null,
    data_nasc date not null,
    num_filmes int not null,
    foreign key (num_cc) references pessoa(num_cc),
    CHECK (num_cc BETWEEN 10000000 AND 99999999)
);

create table diretor(
    num_cc int not null,
    nome varchar(30) not null,
    data_nasc date not null,
    num_filmes int not null,
    foreign key (num_cc) references pessoa(num_cc),
    CHECK (num_cc BETWEEN 10000000 AND 99999999)
);

create table ator(
    num_cc int not null,
    nome varchar(30) not null,
    data_nasc date not null,
    ator_id int not null,
    foreign key (num_cc) references pessoa(num_cc),
    primary key (ator_id),
    CHECK (num_cc BETWEEN 10000000 AND 99999999)
);

create table personagem(
    nome varchar(30) not null,
    papel varchar(20) not null,
    personagem_id int not null,
    primary key (personagem_id)
);

create table interpreta(
    ator_id int not null,
    personagem_id int not null,
    foreign key (ator_id) references ator(ator_id),
    foreign key (personagem_id) references personagem(personagem_id)
);

create table figura_em(
    content_id int not null,
    personagem_id int not null,
    foreign key(personagem_id) references personagem(personagem_id)
);

create table pessoa_content(
    num_cc int not null,
    content_id int not null,
    foreign key(num_cc) references pessoa(num_cc)
);

create table conteudo(
    estudio_id int not null,
    nome varchar(30) not null,
    content_id int not null,
    primary key (content_id),
    foreign key (estudio_id) references  estudio(estudio_id)
);

-- Add constraints
ALTER TABLE pessoa_content
ADD CONSTRAINT fk_pessoa_content_content_id FOREIGN KEY (content_id) REFERENCES conteudo(content_id);

ALTER TABLE figura_em
ADD CONSTRAINT fk_figura_em_content_id FOREIGN KEY (content_id) REFERENCES conteudo(content_id);

ALTER TABLE avalia
ADD CONSTRAINT fk_avalia_content_id FOREIGN KEY (content_id) REFERENCES conteudo(content_id);

ALTER TABLE genero
ADD CONSTRAINT fk_genero_content_id FOREIGN KEY (content_id) REFERENCES conteudo(content_id);

ALTER TABLE premio
ADD CONSTRAINT fk_premio_content_id FOREIGN KEY (content_id) REFERENCES conteudo(content_id);

-- Create specific tables for movie and TV series
create table Filme (
    content_id INT NOT NULL,
    runtime INT NOT NULL,
    synopsis VARCHAR(100),
    data_estreia DATE,
    nome VARCHAR(30),
    FOREIGN KEY (content_id) REFERENCES conteudo(content_id)
);

create table serie_televisiva (
    content_id INT NOT NULL,
    nome VARCHAR(30),
    synopsis VARCHAR(100),
    rating INT NOT NULL,
    PRIMARY KEY (content_id),
    FOREIGN KEY (content_id) REFERENCES conteudo(content_id)
);

create table temporada (
    season_id INT NOT NULL,
    content_id INT NOT NULL,
    synopsis VARCHAR(100),
    PRIMARY KEY (season_id),
    FOREIGN KEY (content_id) REFERENCES serie_televisiva(content_id)
);

create table episodio (
    num_episodio INT NOT NULL,
    season_id INT NOT NULL,
    runtime INT NOT NULL,
    synopsis VARCHAR(100),
    data_estreia DATE,
    rating INT NOT NULL,
    FOREIGN KEY (season_id) REFERENCES temporada(season_id)
);

-- Set default values for date columns
ALTER TABLE Filme
ADD CONSTRAINT DF_Filme_data_estreia DEFAULT '2023-01-01' FOR data_estreia;

ALTER TABLE episodio
ADD CONSTRAINT DF_episodio_data_estreia DEFAULT '2023-01-01' FOR data_estreia;

