SELECT 
    child.ITEM_ID, 
    child.ITEM_NAME, 
    child.RARITY
FROM ITEM_TREE it
JOIN ITEM_INFO parent 
    ON it.PARENT_ITEM_ID = parent.ITEM_ID AND parent.RARITY = 'RARE'
JOIN ITEM_INFO child
    ON it.ITEM_ID = child.ITEM_ID
ORDER BY child.ITEM_ID DESC;