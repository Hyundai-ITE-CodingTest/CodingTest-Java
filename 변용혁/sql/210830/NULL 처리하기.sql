-- 코드를 입력하세요
SELECT ANIMAL_TYPE, nvl(NAME,'No name'), SEX_UPON_INTAKE
from ANIMAL_INS
order by ANIMAL_ID
