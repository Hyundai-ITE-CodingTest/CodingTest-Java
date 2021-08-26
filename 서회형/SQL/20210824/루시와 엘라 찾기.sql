-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM   ANIMAL_INS
WHERE name IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty');
-- name = ""로 찾을수도있지만 값이 많으면 IN이 좋음