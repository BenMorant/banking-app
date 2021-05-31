/* Customer */
insert into customer(name, customer_identifier) values ('Paul Durand', 'A1234567');
insert into customer(name, customer_identifier) values ('Louis Balthus', 'B2345678');
insert into customer(name, customer_identifier) values ('Pablo Chorizo', 'C3456789');
insert into customer(name, customer_identifier) values ('Mario Bros', 'D4567890');

/* Account */

insert into account(balance, id_customer, overdraft, interest_rate) values (1000.0, 1, 10.0, 0);
insert into account(balance, id_customer, overdraft, interest_rate) values (500.0, 1, 0.0, 1.6);
insert into account(balance, id_customer, overdraft, interest_rate) values (2000.0, 2, 123.0, 0.5);
insert into account(balance, id_customer, overdraft, interest_rate) values (5000.0, 2, 0.0, 1.3);
insert into account(balance, id_customer, overdraft, interest_rate) values (10000.0, 3, 12.0, 0.7);
insert into account(balance, id_customer, overdraft, interest_rate) values (2500.0, 3, 10.0, 1.3);
insert into account(balance, id_customer, overdraft, interest_rate) values (10.0, 4, 2.0, 0.7);
insert into account(balance, id_customer, overdraft, interest_rate) values (25.0, 4, 1.0, 1.4);



/* BankOperation */
insert into bank_operation(operation_amount, operation_date, id_account, operation_type) values (40.5, '2019-06-07', 1, 'withdrawal');
insert into bank_operation(operation_amount, operation_date, id_account, operation_type) values (34.56, '2020-10-07', 2, 'deposit');
insert into bank_operation(operation_amount, operation_date, id_account, operation_type) values (93.42, '2020-11-23', 2, 'withdrawal');
insert into bank_operation(operation_amount, operation_date, id_account, operation_type) values (100.97, '2020-12-07', 2, 'deposit');
insert into bank_operation(operation_amount, operation_date, id_account, operation_type) values (400.5, '2018-06-07', 3, 'withdrawal');
insert into bank_operation(operation_amount, operation_date, id_account, operation_type) values (343.56, '2010-10-07', 3, 'deposit');
insert into bank_operation(operation_amount, operation_date, id_account, operation_type) values (938.42, '2009-08-23', 3, 'withdrawal');
insert into bank_operation(operation_amount, operation_date, id_account, operation_type) values (10.97, '2017-11-07', 4, 'deposit');
insert into bank_operation(operation_amount, operation_date, id_account, operation_type) values (340.5, '2020-06-07', 5, 'withdrawal');
insert into bank_operation(operation_amount, operation_date, id_account, operation_type) values (634.56, '2019-11-07', 6, 'deposit');
insert into bank_operation(operation_amount, operation_date, id_account, operation_type) values (793.42, '2018-11-24', 7, 'withdrawal');
insert into bank_operation(operation_amount, operation_date, id_account, operation_type) values (900.97, '2020-12-07', 8, 'deposit');
insert into bank_operation(operation_amount, operation_date, id_account, operation_type) values (10400.5, '2015-08-27', 4, 'withdrawal');
insert into bank_operation(operation_amount, operation_date, id_account, operation_type) values (341.56, '2010-10-16', 5, 'deposit');
insert into bank_operation(operation_amount, operation_date, id_account, operation_type) values (793.42, '2009-09-21', 6, 'withdrawal');
insert into bank_operation(operation_amount, operation_date, id_account, operation_type) values (1100.97, '2017-11-07', 7, 'deposit');