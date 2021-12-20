create table db_info
	(ID		varchar(25),
	 name		varchar(25),
	 street		varchar(25),
	 city		varchar(25),
	 province		varchar(25),
	 country		varchar(25),
	 postal_code		varchar(25),
	 primary key (ID)
	);
	
create table checkout_session
	(ID		varchar(25),
	 shipping_info		varchar(25),
	 billing_info		varchar(25),
	 primary key (ID),
	 foreign key (shipping_info) references db_info(ID),
	 foreign key (billing_info) references db_info(ID)
	);
	
create table publisher
	(ID		varchar(25),
	 company_info		varchar(25),
	 email		varchar(25),
	 phone_number		varchar(25),
	 bank_account		numeric(10,0),
	 primary key (ID),
	 foreign key (company_info) references db_info(ID)
	);
	
create table book
	(ISBN		varchar(10),
	 title		varchar(25),
	 author_name		varchar(25),
	 publisher		varchar(25),
	 genre		varchar(25),
	 num_pages		numeric(10),
	 price		numeric(8,2),
	 supplier_price		numeric(8,2),
	 profit_percentage		numeric(3,0),
	 stock		numeric(3,0),
	 primary key (ISBN),
	 foreign key (publisher) references publisher (ID)
	);
	
create table db_user
	(username		varchar(25),
	 password		varchar(25),
	 type			varchar(25),
	 shipping_info		varchar(25),
	 billing_info		varchar(25),
	 checkout_basket		varchar(25),
	 primary key (username),
	 foreign key (shipping_info) references db_info(ID),
	 foreign key (billing_info) references db_info(ID),
	 foreign key (checkout_basket) references checkout_session on delete cascade
	);

create table basketed_book
	(ID		varchar(25),
	 ISBN		varchar(10),
	 amount		varchar(25),
	 primary key (ID, ISBN),
	 foreign key (ID) references checkout_session,
	 foreign key (ISBN) references book
	);
	
create table db_order
	(order_number		varchar(25),
	 tracking_id		varchar(25),
	 shipping_info		varchar(25),
	 billing_info		varchar(25),
	 primary key (order_number),
	 foreign key (shipping_info) references db_info(ID),
	 foreign key (billing_info) references db_info(ID)
	);

create table ordered_book
	(order_number		varchar(25),
	 ISBN		varchar(10),
	 amount		varchar(25),
	 primary key (order_number, ISBN),
	 foreign key (order_number) references db_order,
	 foreign key (ISBN) references book
	);

create table sale
	(ID		varchar(25),
	 ISBN		varchar(10),
	 sale_date		date,
	 amount		numeric(2,0),
	 primary key (ID),
	 foreign key (ISBN) references book
	);

create table creates
	(order_number		varchar(25),
	 username		varchar(25),
	 primary key (order_number),
	 foreign key (order_number) references db_order,
	 foreign key (username) references db_user
	);

create table expenditure
	(ID		varchar(25),
	 ISBN		varchar(10),
	 expenditure_date		date,
	 amount		numeric(2,0),
	 primary key (ID),
	 foreign key (ISBN) references book
	);
