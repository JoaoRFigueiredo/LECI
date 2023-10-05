-- SQL script goes here
select title, ytd_sales, au_fname +' '+ au_lname as author, 
ytd_sales*price*royalty/100 as author_revenue,
ytd_sales*price -ytd_sales*price*royalty/100 as publisher_revenue
from titles
join titleauthor on titleauthor.title_id = titles.title_id
join authors on authors.au_id=titleauthor.au_id
group by title, ytd_sales, au_fname, au_lname, price, royalty