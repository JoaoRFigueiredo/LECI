-- SQL script goes here
select stor_name
from stores join sales on stores.stor_id = sales.stor_id
join titles on titles.title_id=sales.title_id
group by stor_name
having count(title) = (select count(title_id) from titles)