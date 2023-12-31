-- Dropping tables
DROP TABLE IF EXISTS episodio;
DROP TABLE IF EXISTS temporada;
DROP TABLE IF EXISTS serie_televisiva;
DROP TABLE IF EXISTS Filme;
DROP TABLE IF EXISTS pessoa_content;
DROP TABLE IF EXISTS figura_em;
DROP TABLE IF EXISTS interpreta;
DROP TABLE IF EXISTS personagem;
DROP TABLE IF EXISTS ator;
DROP TABLE IF EXISTS diretor;
DROP TABLE IF EXISTS realizador;
DROP TABLE IF EXISTS pessoa;
DROP TABLE IF EXISTS premio;
DROP TABLE IF EXISTS genero;
DROP TABLE IF EXISTS lista_premios;
DROP TABLE IF EXISTS lista_generos;
DROP TABLE IF EXISTS avalia;
DROP TABLE IF EXISTS utilizador;
DROP TABLE IF EXISTS conteudo;
DROP TABLE IF EXISTS estudio;

-- Dropping constraints
ALTER TABLE pessoa_content DROP CONSTRAINT IF EXISTS fk_content_id0;
ALTER TABLE figura_em DROP CONSTRAINT IF EXISTS fk_content_id1;
ALTER TABLE avalia DROP CONSTRAINT IF EXISTS fk_content_id2;
ALTER TABLE genero DROP CONSTRAINT IF EXISTS fk_content_id3;
ALTER TABLE premio DROP CONSTRAINT IF EXISTS fk_content_id4;
