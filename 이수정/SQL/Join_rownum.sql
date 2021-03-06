SELECT *
    FROM (SELECT L.NAME, L.DATETIME
         FROM ANIMAL_INS L LEFT JOIN ANIMAL_OUTS R
         ON L.ANIMAL_ID = R.ANIMAL_ID
         WHERE R.ANIMAL_ID is null
         ORDER BY L.DATETIME
        ) WHERE ROWNUM <= 3;
    
