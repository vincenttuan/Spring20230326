# Spring20230326
Spring20230326
JDBCTemplate :
<pre>
-- 建立 Emp 資料表
create table if not exists emp(
    eid int not null auto_increment, -- 主鍵 (自行產生序號: 1, 2, 3, ...)
    ename varchar(50) not null unique, -- 員工姓名
    age int, -- 員工年齡
    createtime timestamp default current_timestamp, -- 建檔時間
    primary key(eid)
);

-- 建立 Emp 範例資料
insert into emp(ename, age) values('john', 28);
insert into emp(ename, age) values('mary', 30);
insert into emp(ename, age) values('bobo', 29);

-- 查詢 Emp 資料
select eid, ename, age, createtime from emp;
</pre>

建立 MySQL 交易資料表
<pre>
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
</pre>
MySQL 預設隔離級別
<pre>
查詢
SELECT @@transaction_ISOLATION;
修改
SET SESSION transaction_isolation='SERIALIZABLE';
</pre>
