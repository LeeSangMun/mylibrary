SELECT COUNT(FISH_NAME) FISH_COUNT, FISH_NAME
FROM FISH_INFO fi JOIN FISH_NAME_INFO fni ON fi.FISH_TYPE = fni.FISH_TYPE
GROUP BY FISH_NAME
ORDER BY FISH_COUNT DESC