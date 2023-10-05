-- SQL script goes here
(select pub_name as publisher, stor_name as store
from publishers, stores
group by pub_name, stor_name
)
except
(select pub_name, stor_name
from publishers join titles on publishers.pub_id=titles.pub_id
join sales on titles.title_id=sales.title_id
join stores on stores.stor_id=sales.stor_id
group by pub_name, stor_name
)