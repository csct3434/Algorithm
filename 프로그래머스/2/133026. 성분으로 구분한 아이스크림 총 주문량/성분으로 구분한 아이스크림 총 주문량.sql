SELECT
    t1.INGREDIENT_TYPE,
    SUM(t2.TOTAL_ORDER) AS TOTAL_ORDER
FROM
    ICECREAM_INFO t1
JOIN
    FIRST_HALF t2
USING
    (FLAVOR)
GROUP BY
    t1.INGREDIENT_TYPE
ORDER BY
    TOTAL_ORDER;
    