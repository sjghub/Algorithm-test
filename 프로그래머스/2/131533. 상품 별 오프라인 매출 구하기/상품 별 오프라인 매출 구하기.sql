-- 코드를 입력하세요
SELECT p.product_code as product_code, sum(o.sales_amount*p.price) as sales
from offline_sale o join product p
on p.product_id = o.product_id
group by p.product_code
order by sales desc , product_code