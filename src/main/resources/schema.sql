DROP TABLE IF EXISTS book;
CREATE TABLE book(
    book_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(100),
    condition INTEGER
);