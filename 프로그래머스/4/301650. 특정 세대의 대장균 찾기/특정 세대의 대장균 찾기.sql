SELECT ID
FROM ECOLI_DATA ed2 JOIN (
    SELECT ed.ID edID, t.ID tID, t.PARENT_ID tPARENT_ID
    FROM ECOLI_DATA ed JOIN ECOLI_DATA t ON ed.PARENT_ID = t.ID
) t2 ON ed2.PARENT_ID = t2.edID
WHERE tPARENT_ID IS NULL
ORDER BY ID