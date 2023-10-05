-- SQL script goes here
select type, pub_id, avg(price) as avg_price, sum(qty) as num_of_sales
from titles join sales on titles.title_id=sales.title_id
group by type, pub_id