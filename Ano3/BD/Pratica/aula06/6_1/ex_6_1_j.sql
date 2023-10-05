-- SQL script goes here
select title
from titles join sales on (titles.title_id=sales.title_id) join stores on (sales.stor_id=stores.stor_id)
where stor_name = 'Bookbeat'