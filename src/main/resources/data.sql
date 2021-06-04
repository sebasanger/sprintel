--USESRS--
-- Contraseña: Admin1
insert into users (id, full_name, email, username, password, avatar, created_at, last_password_change_at,enabled) 
values (1, 'Sebastian Sangermano', 'seba.sanger88@gmail.com','seba.sanger88@gmail.com','$2a$10$DBJhFdEGTeAqoLLsGfXwYObYXpt/amU0wpsRtKQtwJdC5n.MOXgxC','',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,true);

insert into user_entity_roles (user_entity_id, roles) values (1,'USER');
insert into user_entity_roles (user_entity_id, roles) values (1,'ADMIN');

-- Contraseña: admin
insert into users (id, full_name, email, username, password, avatar, created_at, last_password_change_at,enabled) 
values (2, 'Admin', 'admin@hotmail.com','admin@hotmail.com','$2a$04$4X2.gX.iYZpqyJGliIDP.evdubunBFAOebikWxGcJp74QMeVX1UTC','',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,true);

insert into user_entity_roles (user_entity_id, roles) values (2,'ADMIN');
insert into user_entity_roles (user_entity_id, roles) values (2,'USER');

-- Contraseña: user
insert into users (id, full_name, email, username, password, avatar, created_at, last_password_change_at,enabled) 
values (3, 'User', 'user@hotmail.com','user@hotmail.com','$2a$04$xwhhMoyJDNiOxhnnbATDO.YZAAElNcSIf.y7G8.cBhH8IHSlaOgsG','',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,true);

insert into user_entity_roles (user_entity_id, roles) values (3,'USER');

-- Contraseña: admin
insert into users (id, full_name, email, username, password, avatar, created_at, last_password_change_at,enabled) 
values (4, 'Admin', 'admin@gmail.com','admin@gmail.com','$2a$04$4X2.gX.iYZpqyJGliIDP.evdubunBFAOebikWxGcJp74QMeVX1UTC','',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,true);

insert into user_entity_roles (user_entity_id, roles) values (4,'ADMIN');
insert into user_entity_roles (user_entity_id, roles) values (4,'USER');

-- Contraseña: user
insert into users (id, full_name, email, username, password, avatar, created_at, last_password_change_at,enabled) 
values (5, 'User', 'user@gmail.com','user@gmail.com','$2a$04$xwhhMoyJDNiOxhnnbATDO.YZAAElNcSIf.y7G8.cBhH8IHSlaOgsG','',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,true);

insert into user_entity_roles (user_entity_id, roles) values (5,'USER');

-- Contraseña: disabled
insert into users (id, full_name, email, username, password, avatar, created_at, last_password_change_at,enabled) 
values (6, 'Disabled', 'disabled@hotmail.com','disabled@hotmail.com','$2a$04$BaWG9mf4n7RLl6NXkPSBNeDAgpeFMjcptCI3Xdxzo4/mLkurpUxeK','',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,false);

insert into user_entity_roles (user_entity_id, roles) values (6,'USER');

-- Contraseña: Angelmartinez1
insert into users (id, full_name, email, username, password, avatar, created_at, last_password_change_at,enabled) 
values (7, 'Gabriel Perez', 'gper@hotmail.com','gabper','$2a$10$9joAo0/q0z2vYgdKUYQ7kuahy7xRBRZF9GNkmOsd6hbCvqFmH6Ueu','',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,true);

insert into user_entity_roles (user_entity_id, roles) values (7,'USER');
insert into user_entity_roles (user_entity_id, roles) values (7,'ADMIN');

-- Contraseña: Angelmartinez1
insert into users (id, full_name, email, username, password, avatar, created_at, last_password_change_at,enabled) 
values (9, 'Carlos Lopez', 'carlopez@hotmail.com','clop','$2a$10$9joAo0/q0z2vYgdKUYQ7kuahy7xRBRZF9GNkmOsd6hbCvqFmH6Ueu','',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,true);

insert into user_entity_roles (user_entity_id, roles) values (9,'USER');

insert into users (id, full_name, email, username, password, avatar, created_at, last_password_change_at,enabled) 
values (10, 'Gabriel Sangermano', 'seba@hotmail.com','seba@hotmail.com','$2a$10$DBJhFdEGTeAqoLLsGfXwYObYXpt/amU0wpsRtKQtwJdC5n.MOXgxC','',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,true);
      
insert into user_entity_roles (user_entity_id, roles) values (10,'USER');

insert into users (id, full_name, email, username, password, avatar, created_at, last_password_change_at,enabled) 
values (11, 'Ricardo Marin', 'riki@hotmail.com','riki@hotmail.com','$2a$10$DBJhFdEGTeAqoLLsGfXwYObYXpt/amU0wpsRtKQtwJdC5n.MOXgxC','',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,true);
      
insert into user_entity_roles (user_entity_id, roles) values (11,'USER');

insert into users (id, full_name, email, username, password, avatar, created_at, last_password_change_at,enabled) 
values (12, 'Oscar Lopez', 'oscar@hotmail.com','oscar@hotmail.com','$2a$10$DBJhFdEGTeAqoLLsGfXwYObYXpt/amU0wpsRtKQtwJdC5n.MOXgxC','',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,true);
      
insert into user_entity_roles (user_entity_id, roles) values (12,'USER');

insert into users (id, full_name, email, username, password, avatar, created_at, last_password_change_at,enabled) 
values (13, 'Pedro Rodriguez', 'pedro@hotmail.com','pedro@hotmail.com','$2a$10$DBJhFdEGTeAqoLLsGfXwYObYXpt/amU0wpsRtKQtwJdC5n.MOXgxC','',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,true);
      
insert into user_entity_roles (user_entity_id, roles) values (13,'USER');

insert into users (id, full_name, email, username, password, avatar, created_at, last_password_change_at,enabled) 
values (14, 'Alberto Caseres', 'albert@hotmail.com','albert@hotmail.com','$2a$10$DBJhFdEGTeAqoLLsGfXwYObYXpt/amU0wpsRtKQtwJdC5n.MOXgxC','',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,true);
      
insert into user_entity_roles (user_entity_id, roles) values (14,'USER');

insert into users (id, full_name, email, username, password, avatar, created_at, last_password_change_at,enabled) 
values (15, 'Manuel kito', 'manukit@hotmail.com','manukit@hotmail.com','$2a$10$DBJhFdEGTeAqoLLsGfXwYObYXpt/amU0wpsRtKQtwJdC5n.MOXgxC','',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,true);
      
insert into user_entity_roles (user_entity_id, roles) values (15,'USER');
-- USESRS --


-- ROOM PRICES --

insert into room_prices (id, price ,description, created_at, updated_at) 
values (1, 1200, "Habitacion single",CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);

insert into room_prices (id, price ,description, created_at, updated_at) 
values (2, 2000, "Habitacion doble",CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);

insert into room_prices (id, price ,description, created_at, updated_at) 
values (3, 2800, "Habitacion triple",CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);

insert into room_prices (id, price ,description, created_at, updated_at) 
values (4, 3500, "Habitacion cuadruple",CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);

insert into room_prices (id, price ,description, created_at, updated_at) 
values (5, 1000, "Habitacion single viajante",CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);

insert into room_prices (id, price ,description, created_at, updated_at) 
values (6, 1700, "Habitacion doble viajante",CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);

insert into room_prices (id, price ,description, created_at, updated_at) 
values (7, 2500, "Habitacion triple viajante",CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);

insert into room_prices (id, price ,description, created_at, updated_at) 
values (8, 3000, "Habitacion cuadruple viajante",CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);

-- ROOM PRICES --

-- INVOICE TYPES --

insert into invoice_types (id, type) 
values (1, "Factura A");

insert into invoice_types (id, type) 
values (2, "Factura B");

insert into invoice_types (id, type) 
values (3, "Factura C");

-- INVOICE TYPES --

-- BRANDS --

insert into brands (id, brand) 
values (1, "Cocacola");

insert into brands (id, brand) 
values (2, "Pepsi");

insert into brands (id, brand) 
values (3, "Manaos");

insert into brands (id, brand) 
values (4, "Sindor");

insert into brands (id, brand) 
values (5, "Dolca");

insert into brands (id, brand) 
values (6, "Elaboracion propia");

-- BRANDS --

-- CATEGORIES --

insert into categories (id, category) 
values (1, "Bebidas");

insert into categories (id, category) 
values (2, "Comidas");

insert into categories (id, category) 
values (3, "Miselaneos");

-- CATEGORIES --

-- PRODUCTS --

insert into products (id, name, price, code, stock, category_id, brand_id, created_at, updated_at) 
values (1, "Cocacola 1L", 80, "bzx852", 5, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into products (id, name, price, code, stock, category_id, brand_id, created_at, updated_at) 
values (2, "Cocacola 2L", 120, "kjkszpj", 3, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into products (id, name, price, code, stock, category_id, brand_id, created_at, updated_at) 
values (3, "Pepsi 1L", 75, "aezakmi", 4, 1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into products (id, name, price, code, stock, category_id, brand_id, created_at, updated_at) 
values (4, "Pepsi 2L", 110, "fullclip", 2, 1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into products (id, name, price, code, stock, category_id, brand_id, created_at, updated_at) 
values (5, "Chocolatada", 70, "rocketman", 4, 1, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into products (id, name, price, code, stock, category_id, brand_id, created_at, updated_at) 
values (6, "Sadnwich completo", 90, "naturaltalent", 2,  2, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into products (id, name, price, code, stock, category_id, brand_id, created_at, updated_at) 
values (7, "LLavero", 150, "hesoiam", 20,  3, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- PRODUCTS --

-- ENTRY PRODUCTS --

insert into entry_products (id, product_id, amount, buy_price, user_id, created_at, updated_at) 
values (1, 1, 3, 50, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into entry_products (id, product_id, amount, buy_price, user_id, created_at, updated_at) 
values (2, 2, 5, 90, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into entry_products (id, product_id, amount, buy_price, user_id, created_at, updated_at) 
values (3, 4, 1, 45, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into entry_products (id, product_id, amount, buy_price, user_id, created_at, updated_at) 
values (4, 3, 3, 70, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into entry_products (id, product_id, amount, buy_price, user_id, created_at, updated_at) 
values (5, 1, 6, 56, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into entry_products (id, product_id, amount, buy_price, user_id, created_at, updated_at) 
values (6, 1, 2, 54, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- ENTRY PRODUCTS --


-- PAYMENT METHODS --

insert into payment_methods (id, method, amount_of_payments, description, created_at, updated_at) 
values (1, "Efectivo", 1, "Pago en efectivo", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into payment_methods (id, method, amount_of_payments, description, created_at, updated_at) 
values (2, "Tarjeta de debito", 1, "Pago con tarjeta de debito", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into payment_methods (id, method, amount_of_payments, description, created_at, updated_at) 
values (3, "Tarjeta de credito", 1, "Pago con tarjeta de credito a una cuouta con interes del 15%", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into payment_methods (id, method, amount_of_payments, description, created_at, updated_at) 
values (4, "Tarjeta de credito", 3, "Pago con tarjeta de credito a tres cuoutas con interes del 20%", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into payment_methods (id, method, amount_of_payments, description, created_at, updated_at) 
values (5, "Tarjeta de credito", 6, "Pago con tarjeta de credito a seis cuoutas con interes del 20%", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- PAYMENT METHODS --



-- REASONS --

insert into reasons (id, reason) 
values (1, "Viaje de negocios");

insert into reasons (id, reason) 
values (2, "Fiesta del inmigrante");

insert into reasons (id, reason) 
values (3, "Tour");

insert into reasons (id, reason) 
values (4, "Turismo");

insert into reasons (id, reason) 
values (5, "Otros");

-- REASONS --

-- CUSTOMERS --
insert into customers (id, name, surname, birthday,dni, email, phone, celphone, cuil, cuit, created_at, updated_at, invoice_type_id) 
values (1, 'sebastian', 'sangermano', '1999-02-09', '41616608','seba_sanger@hotmail.com','402641','3755309633','20416166081', '' ,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,1);

insert into customers (id, name, surname, birthday,dni, email, phone, celphone, cuil, cuit, created_at, updated_at) 
values (2, 'gabriel', 'ramirez', '1997-10-10', '405080','Ramirez@hotmail.com','868686','3755309633','123123123', '1231231231' ,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into customers (id, name, surname, birthday,dni, email, phone, celphone, cuil, cuit, created_at, updated_at) 
values (3, 'raul', 'ramirez', '1880-09-12', '404050','raul@hotmail.com','5656456','3755309633','12312323', '' ,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into customers (id, name, surname, birthday,dni, email, phone, celphone, cuil, cuit, created_at, updated_at, invoice_type_id) 
values (4, 'carlos', 'suarez', '1990-08-23', '201045','carlos@hotmail.com','456456456','123123123','20416166081', '' ,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,3);

insert into customers (id, name, surname, birthday,dni, email, phone, celphone, cuil, cuit, created_at, updated_at) 
values (5, 'antonio', 'roman', '1960-07-11', '201010','antonio@hotmail.com','45678642','456456456','20416166081', '123123123' ,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into customers (id, name, surname, birthday,dni, email, phone, celphone, cuil, cuit, created_at, updated_at) 
values (6, 'rodrigo', 'graziosetti', '1996-06-17', '506070','rodrigo@hotmail.com','456456678','456456456','20416166081', '543453453' ,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into customers (id, name, surname, birthday,dni, email, phone, celphone, cuil, cuit, created_at, updated_at) 
values (7, 'alberto', 'torresetti', '1989-05-18', '124578','alberto@hotmail.com','456456456','456456456','20416166081', '' ,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into customers (id, name, surname, birthday,dni, email, phone, celphone, cuil, cuit, created_at, updated_at, invoice_type_id) 
values (8, 'ramiro', 'montenegro', '1989-04-23', '123653','ramiro@hotmail.com','78978456','456456456','20416166081', '' ,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,2);

insert into customers (id, name, surname, birthday,dni, email, phone, celphone, cuil, cuit, created_at, updated_at) 
values (9, 'juan', 'valdez', '1999-06-24', '859621','juan@hotmail.com','45645646','86786786','20416166081', '453453453' ,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into customers (id, name, surname, birthday,dni, email, phone, celphone, cuil, cuit, created_at, updated_at) 
values (10, 'manuel', 'lopez', '1978-08-16', '535655','manuel@hotmail.com','78678676','786786786','20416166081', '' ,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into customers (id, name, surname, birthday,dni, email, phone, celphone, cuil, cuit, created_at, updated_at) 
values (11, 'paco', 'antunez', '1987-04-25', '8545735','paco@hotmail.com','456456546','8767867867','20416166081', '' ,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
-- CUSTOMERS --

-- ROOMS --
insert into rooms (id, number ,capacity, floor, single_bed,double_bed, enabled, available, created_at, updated_at, deleted) 
values (1, '101', 1, 1, 1, 0, true, true ,CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP, false);

insert into rooms (id, number ,capacity, floor, single_bed,double_bed, enabled, available, created_at, updated_at, deleted) 
values (2, '102', 2, 1, 2, 0, true, true ,CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP, false);

insert into rooms (id, number ,capacity, floor, single_bed,double_bed, enabled, available, created_at, updated_at, deleted) 
values (3, '103', 3, 1, 1, 1, false, true ,CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP, false);

insert into rooms (id, number ,capacity, floor, single_bed,double_bed, enabled, available, created_at, updated_at, deleted) 
values (4, '104', 4, 1, 2, 1, true, false ,CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP, false);

insert into rooms (id, number ,capacity, floor, single_bed,double_bed, enabled, available, created_at, updated_at, deleted) 
values (5, '105', 1, 1, 1, 0, false, true ,CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP, false);

insert into rooms (id, number ,capacity, floor, single_bed,double_bed, enabled, available, created_at, updated_at, deleted) 
values (6, '201', 1, 2, 1, 0, true, true ,CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP, false);

insert into rooms (id, number ,capacity, floor, single_bed,double_bed, enabled, available, created_at, updated_at, deleted) 
values (7, '202', 2, 2, 0, 1, true, false ,CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP, false);

insert into rooms (id, number ,capacity, floor, single_bed,double_bed, enabled, available, created_at, updated_at, deleted) 
values (8, '203', 3, 2, 1, 1, true, true ,CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP, false);

insert into rooms (id, number ,capacity, floor, single_bed,double_bed, enabled, available, created_at, updated_at, deleted) 
values (9, '204', 4, 2, 0, 2, false, false ,CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP, false);

insert into rooms (id, number ,capacity, floor, single_bed,double_bed, enabled, available, created_at, updated_at, deleted) 
values (10, '205', 2, 2, 2, 0, false, true ,CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP, false);

insert into images (id ,path, type, size, title) 
values (1, 'http://localhost:8080/files/asd.jpeg', "jpeg", 200, "Vista de afuera");

insert into images (id ,path, type, size, title) 
values (2, 'http://localhost:8080/files/pasda.png', "png", 250, "Cama principal");


insert into rooms_images (room_id ,image_id) 
values (1, 1);

insert into rooms_images (room_id ,image_id) 
values (1, 2);



-- ROOMS --

-- REGISTERS --
insert into registers (id, user_id, open_mount, balance, close_time, active, created_at, updated_at, close_mount) 
values (1, 1, 5000, 7000 , CURRENT_TIMESTAMP, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 800);

insert into registers (id, user_id, open_mount, balance, close_time, active, created_at, updated_at, close_mount) 
values (2, 3, 8000, 5000 , CURRENT_TIMESTAMP, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1200);

insert into registers (id, user_id, open_mount, balance, close_time, active, created_at, updated_at, close_mount) 
values (3, 5, 200, 600 , CURRENT_TIMESTAMP, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2000);

insert into registers (id, user_id, open_mount, balance, close_time, active, created_at, updated_at, close_mount) 
values (4, 2, 10000, 18000 , CURRENT_TIMESTAMP, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2800);

insert into registers (id, user_id, open_mount, balance, close_time, active, created_at, updated_at, close_mount) 
values (5, 3, 15000, 12000 , CURRENT_TIMESTAMP, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 900);

insert into registers (id, user_id, open_mount, balance, close_time, active, created_at, updated_at) 
values (6, 1, 2500, 4500 , CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- REGISTERS --


-- STAYS --
--1
insert into stays (id, room_id, reason_id, room_price_id, active, entry_date, out_date, check_in, check_out, paid, price_per_day, total_to_pay ,total_guest, created_at, updated_at) 
values (1, 1, 1, 1, false,'2021-05-27', '2021-05-28', '2021-05-27', '2021-05-28', 2400, 1200 , 2400 , 1 ,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into customers_stays (stay_id, customer_id) 
values (1, 2);

--2

insert into stays (id, room_id, reason_id, room_price_id, active, entry_date, out_date, check_in, check_out, paid, price_per_day, total_to_pay ,total_guest, created_at, updated_at) 
values (2, 2, 2, 2,false,'2021-05-26', '2021-05-28', '2021-05-26', '2021-05-28', 6000, 2000 , 6000 , 2,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into customers_stays (stay_id, customer_id) 
values (2, 2);
insert into customers_stays (stay_id, customer_id) 
values (2, 3);

--3

insert into stays (id, room_id, reason_id, room_price_id, active, entry_date, out_date, check_in, paid, price_per_day, total_to_pay ,total_guest, created_at, updated_at) 
values (3, 3, 1, 3, true,'2021-05-27', '2021-05-29', '2021-05-27', 7500, 2500, 8000 , 5 ,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into customers_stays (stay_id, customer_id) 
values (3, 4);
insert into customers_stays (stay_id, customer_id) 
values (3, 5);
insert into customers_stays (stay_id, customer_id) 
values (3, 6);
insert into customers_stays (stay_id, customer_id) 
values (3, 1);
insert into customers_stays (stay_id, customer_id) 
values (3, 2);


--4

insert into stays (id, room_id, reason_id, room_price_id, active, entry_date, out_date, check_in, check_out, paid, price_per_day, total_to_pay ,total_guest, created_at, updated_at) 
values (4, 6, 3, 4, false,'2021-05-25', '2021-05-27', '2021-05-25', '2021-05-27', 3000, 1500 , 4500 , 1,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into customers_stays (stay_id, customer_id) 
values (4, 8);

--5

insert into stays (id, room_id, reason_id, room_price_id, active, entry_date, out_date, check_in, paid, price_per_day, total_to_pay ,total_guest, created_at, updated_at) 
values (5, 7, 2, 2, true,'2021-05-28', '2021-05-29', '2021-05-28' , 4000, 2000 , 4000 , 2 ,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into customers_stays (stay_id, customer_id) 
values (5, 9);
insert into customers_stays (stay_id, customer_id) 
values (5, 10);
-- STAYS --

-- PAYMENT STAYS --

insert into payments (id, stay_id ,amount , payment_method_id, created_at, updated_at, user_id, register_id) 
values (1, 1, 2400, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,1,1);

insert into payments (id, stay_id ,amount , payment_method_id, created_at, updated_at, user_id, register_id) 
values (2, 2, 3000, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,2,1);

insert into payments (id, stay_id ,amount , payment_method_id, created_at, updated_at, user_id, register_id) 
values (3, 2, 3000, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,3,2);

insert into payments (id, stay_id ,amount , payment_method_id, created_at, updated_at, user_id, register_id) 
values (4, 3, 7000, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,3,2);

insert into payments (id, stay_id ,amount , payment_method_id, created_at, updated_at, user_id, register_id) 
values (5, 3, 500, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,2,2);

insert into payments (id, stay_id ,amount , payment_method_id, created_at, updated_at, user_id, register_id) 
values (6, 4, 1000, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,1,3);

insert into payments (id, stay_id ,amount , payment_method_id, created_at, updated_at, user_id, register_id) 
values (7, 4, 1000, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,1,3);

insert into payments (id, stay_id ,amount , payment_method_id, created_at, updated_at, user_id, register_id) 
values (8, 4, 1000, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,1,4);

insert into payments (id, stay_id ,amount , payment_method_id, created_at, updated_at, user_id, register_id) 
values (9, 5, 4000, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,3,5);

-- PAYMENT STAYS --


-- CONSUMPTIONS --
insert into consumptions (id, product_id, stay_id, register_id, user_id, amount, price,paid, created_at, updated_at) 
values (1, 1, 1, 1, 1, 2, 70, true, CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);

insert into consumptions (id, product_id, stay_id, register_id, user_id, amount, price,paid, created_at, updated_at) 
values (2, 4, 1, 2, 2, 3, 110, true, CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);

insert into consumptions (id, product_id, stay_id, register_id, user_id, amount, price,paid, created_at, updated_at) 
values (3, 2, 2, 2, 2, 1, 120,true, CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);

insert into consumptions (id, product_id, stay_id, register_id, user_id, amount, price,paid, created_at, updated_at) 
values (4, 3, 4, 3, 1, 1, 75, true, CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);

insert into consumptions (id, product_id, stay_id, register_id, user_id, amount, price,paid, created_at, updated_at) 
values (5, 4, 4, 3, 2, 3, 100, false, CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);

insert into consumptions (id, product_id, stay_id, register_id, user_id, amount, price,paid, created_at, updated_at) 
values (6, 4, 5, 5, 1, 1, 110, true, CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);

insert into consumptions (id, product_id, stay_id, register_id, user_id, amount, price,paid, created_at, updated_at) 
values (7, 5, 5, 5, 1, 2, 70, true, CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);

insert into consumptions (id, product_id, stay_id, register_id, user_id, amount, price,paid, created_at, updated_at) 
values (8, 6, 5, 5, 1, 1, 90, true, CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);

-- CONSUMPTIONS --