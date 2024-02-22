SELECT *
FROM (
    WITH a AS (
        SELECT CODE
        FROM SKILLCODES 
        WHERE CATEGORY = 'Front End'
    ), b AS (
        SELECT CODE
        FROM SKILLCODES 
        WHERE NAME = 'C#'
    ), c AS (
        SELECT CODE
        FROM SKILLCODES 
        WHERE CATEGORY = 'Front End'
    ), p AS (
        SELECT CODE
        FROM SKILLCODES 
        WHERE NAME = 'Python'
    )
    SELECT MIN(CASE WHEN SKILL_CODE & a.CODE = a.CODE AND SKILL_CODE & p.CODE = p.CODE THEN 'A'
                WHEN SKILL_CODE & b.CODE = b.CODE THEN 'B'
                WHEN SKILL_CODE & c.CODE = c.CODE THEN 'C'
            END) GRADE, ID, EMAIL
    FROM DEVELOPERS, a, b, c, p
    GROUP BY ID, EMAIL
) t
WHERE GRADE IS NOT NULL
ORDER BY GRADE, ID