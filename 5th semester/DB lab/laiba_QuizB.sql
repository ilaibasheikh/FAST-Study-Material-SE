create table Books ( book_id int primary key, title varchar(100) not null, author varchar(100)  not null, publication_year int ,
genre varchar(50));

create table Borrowing ( borrow_id int primary key, book_id int, borrower_name varchar(100) not null, borrow_date date default current_date,
 return_date date, foreign key (book_id) references BOOKS(book_id));
 
insert into Books (book_id, title, author, publication_year, genre) values
(101, 'Dune', 'Frank Herbert', 1965, 'Science Fiction');
insert into Books (book_id, title, author, publication_year, genre) values
(102, 'The Hobbit', 'J.R.R. Tolkien', 1937, 'Fantasy');
insert into Books (book_id, title, author, publication_year, genre) values
(103, 'The Da Vinci Code', 'Dan Brown', 2003, 'Mystery');
insert into Books (book_id, title, author, publication_year, genre) values
(104, 'Sapiens', 'Yuval Noah Harari', 2011, 'Historical');
insert into Books (book_id, title, author, publication_year, genre) values
(105, 'Neuromancer', 'William Gibson', 1984, 'Science Fiction');

insert into Borrowing (borrow_id, book_id, borrower_name, borrow_date, return_date) values 
(201, 101, 'Alice Smith', To_date('2024-08-01', 'YYYY-MM-DD'), null);
insert into Borrowing (borrow_id, book_id, borrower_name, borrow_date, return_date) values 
(202, 102, 'Bob Johnson',  To_date('2024-08-05', 'YYYY-MM-DD'), To_date('2024-08-15', 'YYYY-MM-DD'));
insert into Borrowing (borrow_id, book_id, borrower_name, borrow_date, return_date) values 
(203, 103, 'Carol White',  To_date('2024-08-07', 'YYYY-MM-DD'),  To_date('2024-08-20', 'YYYY-MM-DD'));
insert into Borrowing (borrow_id, book_id, borrower_name, borrow_date, return_date) values 
(204, 104, 'David Brown',  To_date('2024-08-12', 'YYYY-MM-DD'), null);
insert into Borrowing (borrow_id, book_id, borrower_name, borrow_date, return_date) values 
(205, 105, 'Eve Davis',  To_date('2024-08-15', 'YYYY-MM-DD'),  To_date('2024-08-25', 'YYYY-MM-DD'));

select title, publication_year from BOOKS where genre = 'Science Fiction' order by publication_year asc;

update Books set genre = 'Fantasy' where book_id = 101 and publication_year < 2000;

insert into Borrowing (borrow_id, book_id, borrower_name, borrow_date) select 206, 202, 'John Doe', current_date from Books 
where book_id = 202;


delete from Borrowing where return_date is null;

select title from Books where book_id in ( select book_id  from Borrowing  group by book_id  having count(distinct borrower_name) > 2);

select genre, avg(publication_year) as avg_pub_year from Books where genre = 'Historical' and publication_year > 1900 group by genre;

alter table Books add constraint chk_publication_year check (publication_year >= 1900);







