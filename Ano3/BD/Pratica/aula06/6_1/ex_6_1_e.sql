-- SQL script goes here
select au_fname as first_name, au_lname as last_name, phone as telephone from authors  where au_lname != 'Ringer' and state = 'CA' order by first_name 