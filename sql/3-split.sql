DELIMITER $$
DROP TABLE IF EXISTS sometbl ;
CREATE TABLE sometbl(ID INT, NAME VARCHAR(50));
INSERT INTO sometbl VALUES (1, 'Smith'), (2, 'Julio|Jones|Falcons'), (3, 'White|Snow'), (4, 'PAint|It|Red'), (5, 'Green|Lantern'), (6, 'Brow|Bag');

DROP PROCEDURE IF EXISTS split_table $$
CREATE PROCEDURE split_table()
  BEGIN

    DECLARE id INT DEFAULT 0;
    DECLARE value TEXT;
    DECLARE occurance INT DEFAULT 0;
    DECLARE i INT DEFAULT 0;
    DECLARE splitted_value VARCHAR(255);
    DECLARE done INT DEFAULT 0;
    DECLARE delimiter VARCHAR(1) DEFAULT '|';
    DECLARE cur1 CURSOR FOR SELECT sometbl.id, sometbl.name FROM sometbl WHERE sometbl.name != '';
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    DROP TEMPORARY TABLE IF EXISTS sometbl2;
    CREATE TEMPORARY TABLE sometbl2(`id` INT NOT NULL, `name` VARCHAR(255) NOT NULL) ENGINE = Memory;

    OPEN cur1;
      read_loop: LOOP
        FETCH cur1 INTO id, value;
        IF done THEN
          LEAVE read_loop;
        END IF;

        SET occurance = (SELECT LENGTH(value) - LENGTH(REPLACE(value, delimiter, '')) + 1);
        SET i = 1;
        WHILE i <= occurance DO
          SET splitted_value = (SELECT REPLACE(SUBSTRING(SUBSTRING_INDEX(value, delimiter, i), LENGTH(SUBSTRING_INDEX(value, delimiter, i - 1)) + 1), delimiter, ''));
          INSERT INTO sometbl2 VALUES (id, splitted_value);
          SET i = i + 1;
        END WHILE;
      END LOOP;

      SELECT * FROM sometbl2;
    CLOSE cur1;
  END; $$
  
  call split_table;