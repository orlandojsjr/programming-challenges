DROP TABLE IF EXISTS votes;
CREATE TABLE votes(NAME VARCHAR(10), VOTES INT);
INSERT INTO votes VALUES('Smith', 10), ('Jones', 15), ('White', 20), ('Black', 40), ('Green', 50), ('Brown', 20);

SET @rank=0;
SELECT @rank:=@rank+1 AS rank, v.name, v.votes
FROM votes as v
ORDER BY v.votes DESC;