CREATE FUNCTION count_reviews(@content_id int)
RETURNS int
AS
BEGIN
    DECLARE @review_count int;
    SELECT @review_count = COUNT(*) FROM avalia WHERE content_id = @content_id;
    RETURN @review_count;
END;