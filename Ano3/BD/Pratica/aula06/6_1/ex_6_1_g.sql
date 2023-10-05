-- SQL script goes here
 select pub_name from publishers join titles on (publishers.pub_id=titles.pub_id) where type = 'business'