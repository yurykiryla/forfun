# https://leetcode.com/problems/rising-temperature/description/
# 

# Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared 
# to its previous (yesterday's) dates. 
 

SELECT W.Id 
	FROM Weather W 
	WHERE W.Temperature > (
		SELECT C.Temperature 
			FROM Weather C
			WHERE C.RecordDate = DATE_SUB(W.RecordDate, INTERVAL 1 DAY)
	);
	
SELECT
    Weather.Id AS 'Id'
FROM
    Weather
        JOIN
    Weather w ON DATEDIFF(Weather.RecordDate, W.RecordDate) = 1
        AND Weather.Temperature > w.Temperature
;