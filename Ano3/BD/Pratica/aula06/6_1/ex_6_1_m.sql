-- SQL script goes here
select type, max(advance) as max_advance, avg(advance) as average_advance
from titles
group by type
having max(advance) > 1.5*avg(advance)