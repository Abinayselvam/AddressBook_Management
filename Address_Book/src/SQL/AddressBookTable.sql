-- UC1 Create database
create database addressbook_service;
use addressbook_service;


-- UC2 create addressbook table
create table address_book
(
    id INT PRIMARY KEY IDENTITY(1,1),
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    address VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    zip VARCHAR(20),
    phone_number VARCHAR(15),
    email VARCHAR(100)
);

-- UC3 Inser contacts

insert into address_book(first_name,last_name,address,city,state,zip,phone_number,email)
values
    ('user1','user1.last','user1 address','cuddalore','karnataka','405669','1234567890','user1@gamil.com'),
    ('user2','user2.last','user2 address','mowli','delhi','342445','1234567890','user2@gmail.com');

-- UC4 EDIT CONTACT
update address_book
set city = 'coimbatore'
where first_name ='user1';

-- UC5 Delete contact

delete address_book
where first_name = 'user2';

-- UC6 Retrive by city and state

select * from address_book
where city = 'coimbatore';

select * from address_book
where state ='karnataka';

-- UC7 count by city and state
select city,
       count(*)
from address_book
group by city;

select state,
       count(*)
from address_book
group by state;

-- UC8 Sort by name for the given city
select * from address_book
where city = 'coimbatore'
order by first_name;

-- UC9 address book name and type
alter table address_book
    add book_name varchar(100);

alter table address_book
    add book_type varchar(50);

update address_book
set book_name = 'Subconcious mind',
    book_type = 'psycological book'
where first_name = 'user1';

-- UC10  count by type
select book_type,
       count(*)
from address_book
group by book_type;

-- UC11 add person to both family and friend
create table person_type
(
    person_id int,
    type_name varchar(50),
    foreign key(person_id)
        references address_book(id)
);

INSERT INTO person_type
VALUES(1,'Friend');

INSERT INTO person_type
VALUES(1,'Family');

SELECT *
FROM person_type;