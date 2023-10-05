-- SQL script goes here
select pub_name, sum(qty) from  publishers join titles on (publishers.pub_id=titles.pub_id) join sales on (titles.title_id=sales.title_id) group by pub_name