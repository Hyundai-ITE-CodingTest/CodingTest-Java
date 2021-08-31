--------------------------------------
-- 어리 동물 찾기 --
SELECT ANIMAL_ID, NAME
    FROM ANIMAL_INS
    WHERE INTAKE_CONDITION <> 'Aged' 
    ORDER BY ANIMAL_ID;
    
---------------------------------------
-- 중복 제거하기 --
SELECT COUNT(DISTINCT NAME) as count 
    FROM ANIMAL_INS
    WHERE NAME IS NOT NULL;
---------------------------------------
-- 입양 시각 구하기(2) --
-- 해결 못함
---------------------------------------
