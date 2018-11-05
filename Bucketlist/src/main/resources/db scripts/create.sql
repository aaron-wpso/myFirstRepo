DROP DATABASE IF EXISTS bucket;

CREATE DATABASE bucket;
USE bucket;

DROP TABLE IF EXISTS goal;
CREATE TABLE goal
(
	id int auto_increment,
    title text,
    done boolean,
	importance int,
    
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS category;
CREATE TABLE category
(
	id int auto_increment,
    cate_name text,
    
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS goal_category;
CREATE TABLE goal_category
(
	goal_id int,
    cate_id int,
    
    PRIMARY KEY(goal_id, cate_id)
);

ALTER TABLE goal_category
ADD FOREIGN KEY(goal_id) REFERENCES goal(id),
ADD FOREIGN KEY(cate_id) REFERENCES category(id);

DROP TABLE IF EXISTS step;
CREATE TABLE step
(
	id int auto_increment,
    instruction text,
    done boolean,
    goal_id int,
    
    PRIMARY KEY(id)
);
ALTER TABLE step
ADD FOREIGN KEY(goal_id) REFERENCES goal(id);

DROP TABLE IF EXISTS photo;
CREATE TABLE photo
(
	id int auto_increment,
    path text,
    goal_id int,
    
    PRIMARY KEY(id)
);

ALTER TABLE photo
ADD FOREIGN KEY(goal_id) REFERENCES goal(id);


DROP TABLE IF EXISTS journal;
CREATE TABLE journal
(
	id int auto_increment,
    title text,
    content text,
    day_written date,
    goal_id int,
    
    PRIMARY KEY(id)
);

ALTER TABLE journal
ADD FOREIGN KEY(goal_id) REFERENCES goal(id);
