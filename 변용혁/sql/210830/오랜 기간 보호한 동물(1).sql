-- 코드를 입력하세요
SELECT name, datetime
    from (select * from ANIMAL_INS order by datetime)
    where ANIMAL_ID NOT IN (select ANIMAL_ID FROM ANIMAL_OUTS )
    and rownum <=3;
