-- 코드를 입력하세요
SELECT i.ANIMAL_ID, i.NAME
    from ANIMAL_INS i, ANIMAL_OUTS o
    where i.ANIMAL_ID = o.ANIMAL_ID
    and i.DATETIME > o.DATETIME
    order by i.DATETIME;