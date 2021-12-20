delete from db_user;
delete from checkout_session;
delete from basketed_book;
delete from ordered_book;
delete from db_order;
delete from db_info;
delete from publisher;
delete from sale;
delete from creates;
delete from book;


insert into db_info values ('103', 'Felix', '1 street', 'Ottawa', 'Ontario', 'Canada', 'K1K1K1');
insert into db_info values ('101', 'Jacob', '2 street', 'Winnipeg', 'Manitoba', 'Canada', 'M2M2M2');
insert into db_info values ('102', 'Rebecca', '3 street', 'Edmonton', 'Alberta', 'Canada', 'A1A1A1');
insert into db_info values ('104', 'book company', '3 street', 'Edmonton', 'Alberta', 'Canada', 'A1A1A1');

insert into checkout_session values ('22', '102', '102');

insert into publisher values ('yellow', '104', 'a@gmail.com', '613-777-7777', 23);
insert into publisher values ('red', '104', 'b@gmail.com', '613-666-6666', 23);
insert into publisher values ('blue', '104', 'c@gmail.com', '613-888-8888', 23);
insert into publisher values ('secret', '104', 'd@gmail.com', '613-999-9999', 23);

insert into book values ('0000000001', 'The first book', 'The first author', 'yellow', 'action', 300, 20.5, 10.5, 25, 30);
insert into book values ('0000000002', 'The second book', 'The first author', 'red', 'adventure', 220, 10.5, 5.2, 25, 25);
insert into book values ('0000000003', 'The third book', 'The first author', 'red', 'action', 300, 20.5, 7.8, 25, 30);
insert into book values ('0000000004', 'The fourth book', 'The first author', 'yellow', 'adventure', 220, 10.5, 4.4, 25, 15);
insert into book values ('0000000005', 'The fifth book', 'The first author', 'yellow', 'fantasy', 300, 30, 20.3, 50, 40);
insert into book values ('0000000006', 'The sixth book', 'The second author', 'red', 'action', 300, 20.5, 10.1, 25, 30);
insert into book values ('0000000007', 'The seventh book', 'The second author', 'yellow', 'adventure', 220, 10.5, 1.5, 25, 25);
insert into book values ('0000000008', 'The eight book', 'The second author', 'yellow', 'action', 300, 20.5, 10, 25, 30);
insert into book values ('0000000009', 'The ninth book', 'The second author', 'blue', 'adventure', 220, 10.5, 5, 25, 15);
insert into book values ('0000000010', 'The tenth book', 'The second author', 'blue', 'fantasy', 300, 30, 19.5, 50, 40);
insert into book values ('0000000011', 'Book number 194', 'secret author', 'secret', 'mystery', 2, 100, 50.5, 100, 2);

insert into db_user values ('admin', 'admin', 'admin', '101', '101', null);
insert into db_user values ('normal', 'normal', 'normal', '102', '102', '22');

insert into basketed_book values ('22', '0000000001', '3');
insert into basketed_book values ('22', '0000000004', '5');
insert into basketed_book values ('22', '0000000011', '1');

insert into db_order values ('1001', null, '103', '103');
insert into db_order values ('1002', null, '101', '101');
insert into db_order values ('1003', null, '102', '102');

insert into ordered_book values ('1001', '0000000002', '3');
insert into ordered_book values ('1001', '0000000004', '1');
insert into ordered_book values ('1001', '0000000009', '2');
insert into ordered_book values ('1001', '0000000007', '1');

insert into sale values ('3001','0000000002', '2021-01-01', 3);
insert into sale values ('3002','0000000002', '2021-01-01', 4);
insert into sale values ('3003','0000000002', '2021-01-01', 5);
insert into sale values ('3004','0000000004', '2021-02-01', 6);
insert into sale values ('3005','0000000009', '2021-03-01', 7);
insert into sale values ('3006','0000000009', '2021-03-01', 8);
insert into sale values ('3007','0000000007', '2021-04-01', 9);
insert into sale values ('3008','0000000001', '2021-05-01', 6);
insert into sale values ('3009','0000000003', '2021-06-01', 7);
insert into sale values ('3010','0000000005', '2021-07-01', 8);
insert into sale values ('3011','0000000006', '2021-08-01', 9);
insert into sale values ('3012','0000000008', '2021-09-01', 8);
insert into sale values ('3013','00000000010', '2021-10-01', 9);

insert into creates values ('1001', 'normal');
insert into creates values ('1002', 'normal');
insert into creates values ('1003', 'normal');

insert into expenditure values ('901','0000000002',  '2021-01-01', 10);
insert into expenditure values ('902','0000000002',  '2021-01-01', 5);
insert into expenditure values ('903','0000000002',  '2021-01-01', 10);
insert into expenditure values ('904','0000000004',  '2021-02-01', 5);
insert into expenditure values ('905','0000000009',  '2021-03-01', 5);
insert into expenditure values ('906','0000000009',  '2021-03-01', 10);
insert into expenditure values ('907','0000000007',  '2021-04-01', 10);

