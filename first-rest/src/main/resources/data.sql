insert into user_details(id, birth_date, name)
values(1001,'1978-10-12' ,'John');
insert into user_details(id, birth_date, name)
values(1002,'1972-4-2', 'Kate');
insert into user_details(id, birth_date, name)
values(1003,'1988-11-07', 'Mary');
insert into user_details(id, birth_date, name)
values(1004,'1992-3-12', 'Smith');

insert into post(id, description, user_id)
values(2001, 'learn MSFT', 1001);

insert into post(id, description, user_id)
values(2051, 'learn Java', 1001);
insert into post(id, description, user_id)
values(2101, 'learn Unix', 1002);
insert into post(id, description, user_id)
values(2061, 'learn C', 1003);
insert into post(id, description, user_id)
values(2011, 'learn Oracle', 1003);
insert into post(id, description, user_id)
values(2021, 'learn Spring', 1004);