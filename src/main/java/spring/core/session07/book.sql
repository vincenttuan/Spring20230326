-- book(書籍)、stock(庫存)、wallet(錢包)
-- 刪除已存在資料表
drop table if exists book;
drop table if exists stock;
drop table if exists wallet;

-- 建立資料表
create table if not exists book ( -- book(書籍)
    book_id integer, -- 書號
    book_name varchar(50), -- 書名
    book_price integer -- 價格
);

create table if not exists stock ( -- stock(庫存)
    book_id integer, -- 書號
    book_amount integer -- 數量
);

create table if not exists wallet ( -- wallet(錢包)
    username varchar(50), -- 客戶名稱
    balance integer -- 餘額
);

-- 新增資料
insert into book(book_id, book_name, book_price) values(1, 'Java', 100);
insert into book(book_id, book_name, book_price) values(2, 'Python', 70);
insert into stock(book_id, book_amount) values(1, 10);
insert into stock(book_id, book_amount) values(2, 10);
insert into wallet(username, balance) values('John', 200);
insert into wallet(username, balance) values('Mary', 200);