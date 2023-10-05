use movies_db;
--create database movies_db;

create table estudio(
    estudio_id int not null,
    ano_criacao date not null,
    localizacao varchar(20),
    nome varchar(30),
    PRIMARY key (estudio_id),
);


create table utilizador(
    user_id int not null,
    nome varchar(30),
	password varchar(15),
    primary key (user_id),
);

create table avalia(
    user_id int not null,
    review varchar(100),
    content_id int not null,

    foreign key (user_id) references utilizador(user_id),
);

create table lista_generos(
    nome_genero_id int not null,
    nome_genero varchar(20),

    primary key(nome_genero_id),
);

create table genero(
    nome_genero_id int not null,
    content_id int not null,

    foreign key (nome_genero_id) references lista_generos(nome_genero_id),
    primary key(nome_genero_id, content_id),
)


create table lista_premios(
    nome_premio_id int not null,
    nome_premio varchar(20),

    primary key(nome_premio_id),
);

create table premio(
    nome_premio_id int not null,
    content_id int not null,

    foreign key (nome_premio_id) references lista_premios(nome_premio_id),
    primary key(nome_premio_id, content_id),
);

create table pessoa(
    num_cc int not null,
    nome varchar(30) not null,
    data_nasc date not null,

    primary key (num_cc),
);

create table realizador(
    num_cc int not null,
    nome varchar(30) not null,
    data_nasc date not null,
    num_filmes int not null,

    foreign key (num_cc) references pessoa(num_cc),
);

create table diretor(
    num_cc int not null,
    nome varchar(30) not null,
    data_nasc date not null,
    num_filmes int not null,

    foreign key (num_cc) references pessoa(num_cc),
);

create table ator(
    num_cc int not null,
    nome varchar(30) not null,
    data_nasc date not null,
    ator_id int not null,

    foreign key (num_cc) references pessoa(num_cc),
    primary key (ator_id),
);


create table personagem(
    nome varchar(30) not null,
    papel varchar(20) not null,
    personagem_id int not null,

    primary key (personagem_id), 
);

create table interpreta(
    ator_id int not null,
    personagem_id int not null,

    foreign key (ator_id) references ator(ator_id),
    foreign key (personagem_id) references personagem(personagem_id),
);

create table figura_em(
	content_id int not null,
	personagem_id int not null,

	foreign key(personagem_id) references personagem(personagem_id),
);

create table pessoa_content(
	num_cc int not null,
	content_id int not null,

	foreign key(num_cc) references pessoa(num_cc),
);

create table conteudo(
    estudio_id int not null,
    nome varchar(30) not null,
    content_id int not null,

    primary key (content_id),
    foreign key (estudio_id) references  estudio(estudio_id),
);




ALTER TABLE pessoa_content ADD CONSTRAINT fk_content_id0 FOREIGN KEY (content_id) REFERENCES conteudo(content_id);
ALTER TABLE figura_em ADD CONSTRAINT fk_content_id1 FOREIGN KEY (content_id) REFERENCES conteudo(content_id);
ALTER TABLE avalia ADD CONSTRAINT fk_content_id2 FOREIGN KEY (content_id) REFERENCES conteudo(content_id);
ALTER TABLE genero ADD CONSTRAINT fk_content_id3 FOREIGN KEY (content_id) REFERENCES conteudo(content_id);
ALTER TABLE premio ADD CONSTRAINT fk_content_id4 FOREIGN KEY (content_id) REFERENCES conteudo(content_id);

create table Filme(
    content_id int,
    runtime int,
    synopsis varchar(100),
    data_estreia date,
    nome varchar(30),
    rating int check (rating >= 0 and rating <= 10),


    foreign key (content_id) references conteudo(content_id),
);

create table serie_televisiva(
    content_id int,
    nome varchar(30),
    synopsis varchar(100),
    rating int,

    primary key (content_id),
    foreign key (content_id) references conteudo(content_id),
);


create table temporada(
    season_id int,
    content_id int,
	numero_season int,
    primary key (season_id),
    foreign key (content_id) references serie_televisiva(content_id),
);

create table episodio(
    num_episodio int,
    season_id int,
    runtime int,
    synopsis varchar(100),
    data_estreia date,
    rating int check (rating >= 0 and rating <= 10),

    foreign key (season_id) references temporada(season_id),
);


