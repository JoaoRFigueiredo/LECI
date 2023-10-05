-- SQL script goes here
select stor_name
from stores join sales on stores.stor_id = sales.stor_id
join titles on sales.title_id=titles.title_id
group by stor_name
having sum(sales.qty) > (select SUM(sales.qty)/COUNT(stor_id) from sales)