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


CREATE TRIGGER PreventDuplicateUserName
ON utilizador
AFTER INSERT
AS
BEGIN
    IF EXISTS (SELECT 1 FROM inserted i
               WHERE EXISTS (SELECT 1 FROM utilizador u
                             WHERE u.nome = i.nome))
    BEGIN
        RAISERROR ('A user with the same name already exists.', 16, 1)
        ROLLBACK TRANSACTION;
        RETURN;
    END;
END;
