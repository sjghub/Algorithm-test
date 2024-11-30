-- 코드를 입력하세요
SELECT i.INGREDIENT_TYPE, sum(TOTAL_ORDER) as total_order
from FIRST_HALF f join ICECREAM_INFO i
on f.flavor = i.flavor
group by i.INGREDIENT_TYPE
order by total_order 