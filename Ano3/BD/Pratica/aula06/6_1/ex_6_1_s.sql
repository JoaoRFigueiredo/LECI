-- SQL script goes here
select title
from titles
except
select distinct title from titles 
join sales on sales.title_id = titles.title_id
join stores on stores.stor_id = sales.stor_id
where stor_name="Bookbeat"