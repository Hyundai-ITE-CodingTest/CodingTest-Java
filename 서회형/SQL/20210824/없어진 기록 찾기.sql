-- 코드를 입력하세요
SELECT outs.ANIMAL_ID, outs.NAME
FROM ANIMAL_OUTS outs LEFT OUTER JOIN ANIMAL_INS ins
ON ins.ANIMAL_ID = outs.ANIMAL_ID
WHERE ins.ANIMAL_ID is NULL
ORDER BY outs.ANIMAL_ID;
-- LEFT JOIN을 어디에서부터 하느냐에 따라 값이 달라진다.