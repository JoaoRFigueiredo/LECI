CREATE PROCEDURE GetMovieDetails
    @content_id INT
AS
BEGIN
    SELECT c.content_id, c.nome, f.runtime, f.synopsis, f.data_estreia, f.rating, lg.nome_genero, lp.nome_premio
    FROM conteudo AS c
    JOIN Filme AS f ON c.content_id = f.content_id
    LEFT JOIN genero AS g ON c.content_id = g.content_id
    LEFT JOIN lista_generos AS lg ON g.nome_genero_id = lg.nome_genero_id
    LEFT JOIN premio AS p ON c.content_id = p.content_id
    LEFT JOIN lista_premios AS lp ON p.nome_premio_id = lp.nome_premio_id
    WHERE c.content_id = @content_id;
END;

CREATE PROCEDURE AddUser
    @user_id INT,
    @nome NVARCHAR(30),
    @password NVARCHAR(15)
AS
BEGIN
    INSERT INTO utilizador (user_id, nome, password)
    VALUES (@user_id, @nome, @password);
END;