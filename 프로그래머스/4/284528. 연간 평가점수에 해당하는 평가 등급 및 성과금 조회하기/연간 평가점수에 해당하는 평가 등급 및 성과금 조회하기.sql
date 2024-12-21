SELECT
    e.EMP_NO,
    e.EMP_NAME,
    CASE
        WHEN g.SCORE >= 96 THEN 'S'
        WHEN g.SCORE >= 90 THEN 'A'
        WHEN g.SCORE >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE,
    (e.SAL * CASE
        WHEN g.SCORE >= 96 THEN 0.20
        WHEN g.SCORE >= 90 THEN 0.15
        WHEN g.SCORE >= 80 THEN 0.10
        ELSE 0
     END) AS BONUS
FROM
    HR_EMPLOYEES e
JOIN (
    SELECT
        EMP_NO, AVG(SCORE) AS SCORE
    FROM
        HR_GRADE
    GROUP BY
        EMP_NO
) AS g USING (EMP_NO)
ORDER BY
    e.EMP_NO ASC