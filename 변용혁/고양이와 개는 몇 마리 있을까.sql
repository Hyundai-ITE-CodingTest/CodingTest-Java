-- 코드를 입력하세요
SELECT distinct ANIMAL_TYPE, count(*) AS COUNT FROM ANIMAL_INS 
    GROUP BY ANIMAL_TYPE
    ORDER BY ANIMAL_TYPE;