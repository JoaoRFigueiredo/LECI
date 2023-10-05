-- SQL script goes here
select pub_name,  title, sum(qty) as sales
 from  publishers join titles on (publishers.pub_id=titles.pub_id) join sales on (titles.title_id=sales.title_id)
  group by title, pub_name