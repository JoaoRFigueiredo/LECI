-- SQL script goes here
select au_fname, au_lname
from authors join titleauthor on (authors.au_id = titleauthor.au_id)
join titles on (titleauthor.title_id=titles.title_id)
group by au_fname, au_lname
having count(distinct type) > 1