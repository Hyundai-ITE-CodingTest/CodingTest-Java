-- �ڵ带 �Է��ϼ���
SELECT outs.ANIMAL_ID, outs.NAME
FROM ANIMAL_OUTS outs LEFT OUTER JOIN ANIMAL_INS ins
ON ins.ANIMAL_ID = outs.ANIMAL_ID
WHERE ins.ANIMAL_ID is NULL
ORDER BY outs.ANIMAL_ID;
-- LEFT JOIN�� ��𿡼����� �ϴ��Ŀ� ���� ���� �޶�����.