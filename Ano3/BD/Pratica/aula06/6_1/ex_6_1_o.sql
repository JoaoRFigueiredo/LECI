-- SQL script goes here
select title, ytd_sales, ytd_sales*price as facturacao, 
ytd_sales*price*royalty/100 as author_revenue,
ytd_sales*price -ytd_sales*price*royalty/100 as publisher_revenue
from titles