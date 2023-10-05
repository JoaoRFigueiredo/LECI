-- SQL script goes here
select title, au_fname, au_lname, ytd_sales*price*royalty/100 as profit
from titles join titleauthor on titleauthor.title_id=titles.title_id
join authors on authors.au_id=titleauthor.au_id
GROUP BY title, price, au_fname, au_lname, ytd_sales, royalty