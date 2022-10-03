create table customer
(
    id BIGSERIAL PRIMARY KEY,
    user_name VARCHAR(128) NOT NULL UNIQUE ,
    first_name VARCHAR(128) NOT NULL ,
    last_name VARCHAR(128) NOT NULL ,
    e_mail VARCHAR(128) NOT NULL ,
    password VARCHAR(128) NOT NULL ,
    phone_number VARCHAR(128) NOT NULL
);
drop table customer;

create table product
(
    id BIGSERIAL PRIMARY KEY,
    product_name VARCHAR(64) NOT NULL ,
    description TEXT NOT NULL ,
    price DECIMAL(8, 2) NOT NULL ,
    product_quantity INT,
    category_id BIGINT REFERENCES category (id)
);

drop table product;

create table orders
(
    id BIGSERIAL PRIMARY KEY,
    open_order DATE,
    close_order DATE,
    order_status VARCHAR,
    name VARCHAR(64),
    count INT,
    customer_id BIGINT REFERENCES customer(id),
    product_id BIGINT REFERENCES product(id)

);

drop table orders;

create table category
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL
);

drop table category;

create table basket
(
    id BIGSERIAL PRIMARY KEY,
    quantity INT,
    product_id BIGINT REFERENCES product(id),
    orders_id BIGINT REFERENCES orders(id)
);

drop table basket;