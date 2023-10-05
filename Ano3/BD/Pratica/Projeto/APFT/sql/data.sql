-- INSERT INTO estudio
INSERT INTO estudio (estudio_id, ano_criacao, localizacao, nome)
VALUES (1, '2000-01-01', 'Los Angeles', 'Studio A'),
       (2, '1995-05-10', 'New York', 'Studio B'),
       (3, '1980-12-15', 'London', 'Studio C');

-- INSERT INTO utilizador
INSERT INTO utilizador (user_id, nome, password)
VALUES (1, 'John Doe', 'password1'),
       (2, 'Jane Smith', 'password2'),
       (3, 'David Johnson', 'password3');

-- INSERT INTO avalia
INSERT INTO avalia (user_id, review, content_id)
VALUES (1, 'Great movie!', 1),
       (2, 'Average film.', 1),
       (3, 'Excellent series!', 2);

-- INSERT INTO lista_generos
INSERT INTO lista_generos (nome_genero_id, nome_genero)
VALUES (1, 'Action'),
       (2, 'Comedy'),
       (3, 'Drama');

-- INSERT INTO genero
INSERT INTO genero (nome_genero_id, content_id)
VALUES (1, 1),
       (2, 1),
       (3, 2);

-- INSERT INTO lista_premios
INSERT INTO lista_premios (nome_premio_id, nome_premio)
VALUES (1, 'Oscar'),
       (2, 'Golden Globe'),
       (3, 'BAFTA');

-- INSERT INTO premio
INSERT INTO premio (nome_premio_id, content_id)
VALUES (1, 1),
       (2, 1),
       (3, 2);

-- INSERT INTO pessoa
INSERT INTO pessoa (num_cc, nome, data_nasc)
VALUES (1, 'Director A', '1980-05-20'),
       (2, 'Director B', '1975-10-15'),
       (3, 'Actor A', '1990-03-25');

-- INSERT INTO realizador
INSERT INTO realizador (num_cc, nome, data_nasc, num_filmes)
VALUES (1, 'Director A', '1980-05-20', 10),
       (2, 'Director B', '1975-10-15', 5);

-- INSERT INTO diretor
INSERT INTO diretor (num_cc, nome, data_nasc, num_filmes)
VALUES (1, 'Director A', '1980-05-20', 10),
       (2, 'Director B', '1975-10-15', 5);

-- INSERT INTO ator
INSERT INTO ator (num_cc, nome, data_nasc, ator_id)
VALUES (3, 'Actor A', '1990-03-25', 1);

-- INSERT INTO personagem
INSERT INTO personagem (nome, papel, personagem_id)
VALUES ('Character A', 'Lead', 1),
       ('Character B', 'Supporting', 2);

-- INSERT INTO interpreta
INSERT INTO interpreta (ator_id, personagem_id)
VALUES (1, 1),
       (1, 2);

-- INSERT INTO figura_em
INSERT INTO figura_em (content_id, personagem_id)
VALUES (1, 1),
       (1, 2);

-- INSERT INTO pessoa_content
INSERT INTO pessoa_content (num_cc, content_id)
VALUES (1, 1),
       (2, 1),
       (3, 2);

-- INSERT INTO conteudo
INSERT INTO conteudo (estudio_id, nome, content_id)
VALUES (1, 'Movie A', 1),
       (2, 'Movie B', 2),
       (3, 'Series A', 3);

-- INSERT INTO Filme
INSERT INTO Filme (content_id, runtime, synopsis, data_estreia, nome, rating)
VALUES (1, 120, 'Action-packed movie', '2020-01-01', 'Movie A', 8),
       (2, 105, 'Comedy film', '2018-05-15', 'Movie B', 7);

-- INSERT INTO serie_televisiva
INSERT INTO serie_televisiva (content_id, nome, synopsis, rating)
VALUES (3, 'Series A', 'Drama series', 9);

-- INSERT INTO temporada
INSERT INTO temporada (season_id, content_id, numero_season)
VALUES (1, 3, 1),
       (2, 3, 2);

-- INSERT INTO episodio
INSERT INTO episodio (num_episodio, season_id, runtime, synopsis, data_estreia, rating)
VALUES (1, 1, 40, 'Episode 1', '2022-01-01', 9),
       (2, 1, 40, 'Episode 2', '2022-01-08', 8),
       (1, 2, 45, 'Episode 1', '2022-02-01', 9),
       (2, 2, 45, 'Episode 2', '2022-02-08', 8);