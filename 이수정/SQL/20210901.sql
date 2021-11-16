--1) 여러 기준으로 정렬하기--------------------------------------------------
SELECT ANIMAL_ID, NAME, DATETIME
    FROM ANIMAL_INS
    ORDER BY NAME, DATETIME desc;
    
--2) 상위 n개 레코드------------------------------------------------------
SELECT NAME
    FROM (SELECT NAME, DATETIME FROM ANIMAL_INS ORDER BY DATETIME)
    WHERE ROWNUM =1;
-- SQL 개선사항 활용
SELECT NAME FROM ANIMAL_INS
ORDER BY DATETIME
FETCH FIRST 1 ROWS ONLY;

--3) 보호소에서 중성화한 동물------------------------------------------------
SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
    FROM (
        SELECT * 
            FROM ANIMAL_INS
            WHERE SEX_UPON_INTAKE IN ('Intact Male','Intact Female')) A
            LEFT JOIN ANIMAL_OUTS B
            ON A.ANIMAL_ID = B.ANIMAL_ID
            WHERE SEX_UPON_OUTCOME IN('Neutered Male','Spayed Female')
            ORDER BY A.ANIMAL_ID;

--4) 오랜 기간 보호한 동물(2)-----------------------------------------------
SELECT ANIMAL_ID, NAME
    FROM (
        SELECT A.ANIMAL_ID, A.NAME
        FROM ANIMAL_OUTS A JOIN ANIMAL_INS B
        ON A.ANIMAL_ID = B.ANIMAL_ID
        ORDER BY A.DATETIME - B.DATETIME desc)
    WHERE ROWNUM <=2;
