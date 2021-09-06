-- 코드를 입력하세요
-- 답 봄
-- 다시 풀어도...
SELECT a.HOUR, NVL(b.COUNT, 0) AS "COUNT" 
FROM (
    SELECT LEVEL-1 AS "HOUR"
    FROM dual CONNECT BY LEVEL < 25
) a, (
    SELECT TO_CHAR(datetime, 'HH24') AS "HOUR", COUNT(*) AS "COUNT" 
    FROM animal_outs 
    GROUP BY TO_CHAR(datetime, 'HH24')
) b
WHERE a.HOUR = b.HOUR(+)
ORDER BY a.HOUR;
