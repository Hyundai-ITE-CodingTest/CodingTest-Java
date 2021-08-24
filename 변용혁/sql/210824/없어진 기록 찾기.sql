-- 코드를 입력하세요
SELECT o.ANIMAL_ID, o.NAME
    FROM ANIMAL_INS i, ANIMAL_OUTS o
    where i.ANIMAL_ID(+) = o.ANIMAL_ID
    and i.DATETIME is null
    order by ANIMAL_ID;

--ANIMAL_INS 테이블에 비어있는 튜플도 검사를 해야하기 때문에 outer join