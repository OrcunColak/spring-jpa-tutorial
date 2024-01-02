-- Add an author with books
INSERT INTO author (id,name) VALUES (1,'author-1');
INSERT INTO book (id,title,author_id) VALUES (1,'book-1',1);
INSERT INTO book (id,title,author_id) VALUES (2,'book-2',1);

-- Add an author without books
INSERT INTO author (id,name) VALUES (2,'author-2');