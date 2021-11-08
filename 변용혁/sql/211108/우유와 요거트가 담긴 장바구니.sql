SELECT CART_ID from CART_PRODUCTS
    where NAME in ('Milk')
INTERSECT
SELECT CART_ID from CART_PRODUCTS
    where NAME in ('Yogurt')
