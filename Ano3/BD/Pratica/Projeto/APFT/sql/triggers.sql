CREATE TRIGGER trg_insert_default_review
ON avalia
AFTER INSERT
AS
BEGIN
    INSERT INTO avalia (user_id, content_id, review)
    SELECT user_id, content_id, 'No review provided'
    FROM inserted
    WHERE review IS NULL;
END



CREATE TRIGGER trg_update_rating_on_episode
ON episodio
AFTER INSERT
AS
BEGIN
    UPDATE serie_televisiva
    SET rating = (
        SELECT AVG(rating)
        FROM episodio   
        WHERE season_id IN (SELECT season_id FROM inserted)
    )
    WHERE content_id IN (SELECT content_id FROM inserted);
END


CREATE TRIGGER trg_update_num_filmes
ON conteudo
AFTER INSERT
AS
BEGIN
    UPDATE realizador
    SET num_filmes = num_filmes + 1
    WHERE num_cc IN (SELECT num_cc FROM inserted);
END