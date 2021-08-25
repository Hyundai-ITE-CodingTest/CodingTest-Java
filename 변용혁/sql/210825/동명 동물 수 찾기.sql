-- 코드를 입력하세요
SELECT NAME, COUNT(*) "COUNT"
    from ANIMAL_INS
    where name is not null
    group by name
    having COUNT(*) > 1    
    order by name;