DELIMITER $$
CREATE FUNCTION CAPTILIZE (input VARCHAR(255))
RETURNS VARCHAR(255)
BEGIN
   DECLARE len INT DEFAULT 0;
	DECLARE i INT;

	SET len   = CHAR_LENGTH(input);
	SET input = LOWER(input);
	SET i = 0;

	WHILE (i < len) DO
		IF (MID(input,i,1) = ' ' OR i = 0) THEN
			IF (i < len) THEN
				SET input = CONCAT(
					LEFT(input,i),
					UPPER(MID(input,i + 1, 1)),
					RIGHT(input,len - i - 1)
				);
			END IF;
		END IF;
		SET i = i + 1;
	END WHILE;

	RETURN input;
END;

#TESTS
SELECT  CAPTILIZE('captilize teste all lower case');
SELECT  CAPTILIZE('cAPTILIZE tESTE fIRST lETTER lOWER');
SELECT  CAPTILIZE('CAPTILIZE TESTE ALL UPPER CASE');