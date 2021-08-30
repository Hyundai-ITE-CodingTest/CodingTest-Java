-- 코드를 입력하세요
SELECT name, datetime
    from ANIMAL_INS 
    where ANIMAL_ID NOT IN (select ANIMAL_ID FROM ANIMAL_OUTS )
    and rownum <=3
    order by datetime;