SET @dateStart  = '2012-01-01';            
SET @dateEnd    = '2012-01-02';

SELECT open_date, count(1) as bugs_opened
  FROM bugs
 WHERE open_date >= @dateStart
   AND open_date <= @dateEnd
   AND close_date <= @dateEnd
 GROUP BY open_date;