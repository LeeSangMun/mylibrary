SELECT ID, FISH_NAME, LENGTH
FROM FISH_INFO fi JOIN FISH_NAME_INFO fni ON fi.FISH_TYPE = fni.FISH_TYPE
WHERE (fi.FISH_TYPE, LENGTH) IN (
    SELECT FISH_TYPE, MAX(LENGTH)
    FROM FISH_INFO 
    GROUP BY FISH_TYPE
)
ORDER BY ID