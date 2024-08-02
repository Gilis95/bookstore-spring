CREATE DATABASE bookstore;
USE bookstore;
CREATE TABLE author(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), birth_date DATE);
CREATE TABLE book(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, title VARCHAR(100), description VARCHAR(255), release_date DATE, author_id INT, FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE CASCADE);

insert into author(name,birth_date) values('Dimityr Kalburov', '1987-07/01');
insert into book(title,description,release_date,author_id) values('От другата страна', 'Животът на патологичния лъжец Мартин се преобръща на сто и осемдесет градуса, когато всичко рязко му е отнето от родителите му. Той ще направи и невъзможното да си възвърне досегашния статут.', '2022-04-01', 1);
