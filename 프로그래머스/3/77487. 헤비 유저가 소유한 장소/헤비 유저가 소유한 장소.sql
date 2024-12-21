SELECT
    p1.ID,
    p1.NAME,
    p1.HOST_ID
FROM
    PLACES p1
JOIN (
    SELECT
        HOST_ID
    FROM
        PLACES
    GROUP BY
        HOST_ID
    HAVING
        COUNT(*) >= 2
) p2 USING (HOST_ID)
ORDER BY
    p1.ID