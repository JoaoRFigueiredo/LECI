CREATE PROCEDURE AddMovie
    @estudio_id INT,
    @nome VARCHAR(30),
    @runtime INT,
    @synopsis VARCHAR(100),
    @data_estreia DATE,
    @rating INT
AS
BEGIN
    SET NOCOUNT ON;

    -- Step 1: Insert movie data into conteudo table
    INSERT INTO conteudo (estudio_id, nome)
    VALUES (@estudio_id, @nome)

    -- Step 2: Retrieve generated content_id
    DECLARE @content_id INT
    SET @content_id = SCOPE_IDENTITY()

    -- Step 3: Insert movie data into Filme table
    INSERT INTO Filme (content_id, runtime, synopsis, data_estreia, rating)
    VALUES (@content_id, @runtime, @synopsis, @data_estreia, @rating)

    -- Step 4: Retrieve generated content_id
    SELECT @content_id AS generated_content_id
END


CREATE PROCEDURE dbo.GetMoviesByDirector
    @directorName varchar(30)
AS
BEGIN
    SELECT c.nome AS movie_name
    FROM conteudo c
    INNER JOIN diretor d ON c.content_id = d.content_id
    INNER JOIN pessoa p ON d.num_cc = p.num_cc
    WHERE p.nome = @directorName;
END