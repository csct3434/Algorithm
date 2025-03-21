SELECT
    g3.ID
FROM
    ECOLI_DATA g1
JOIN
    ECOLI_DATA g2
    ON g1.ID = g2.PARENT_ID
JOIN
    ECOLI_DATA g3
    ON g2.ID = g3.PARENT_ID
WHERE
    g1.PARENT_ID IS NULL
ORDER BY
    g3.ID ASC