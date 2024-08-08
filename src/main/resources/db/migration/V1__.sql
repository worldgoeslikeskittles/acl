CREATE SEQUENCE IF NOT EXISTS customer_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS department_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS order_item_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS order_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS payment_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS product_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS shipment_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS storage_item_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS storage_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS user_credentials_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS user_role_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS user_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE customer
(
    id      BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE department
(
    id         BIGINT NOT NULL,
    manager_id BIGINT NOT NULL,
    CONSTRAINT pk_department PRIMARY KEY (id)
);

CREATE TABLE order_
(
    id          BIGINT NOT NULL,
    customer_id BIGINT,
    payment_id  BIGINT,
    CONSTRAINT pk_order_ PRIMARY KEY (id)
);

CREATE TABLE order_item
(
    id         BIGINT NOT NULL,
    order_id   BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    count      BIGINT NOT NULL,
    CONSTRAINT pk_order_item PRIMARY KEY (id)
);

CREATE TABLE payment
(
    id             BIGINT         NOT NULL,
    cost           DECIMAL(19, 2) NOT NULL,
    payment_status VARCHAR(255)   NOT NULL,
    CONSTRAINT pk_payment PRIMARY KEY (id)
);

CREATE TABLE product
(
    id          BIGINT       NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description OID,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE shipment
(
    id               BIGINT       NOT NULL,
    order_id         BIGINT       NOT NULL,
    storage_id       BIGINT       NOT NULL,
    delivery_address VARCHAR(255) NOT NULL,
    shipment_status  VARCHAR(255) NOT NULL,
    CONSTRAINT pk_shipment PRIMARY KEY (id)
);

CREATE TABLE storage
(
    id             BIGINT       NOT NULL,
    storage_number VARCHAR(255) NOT NULL,
    CONSTRAINT pk_storage PRIMARY KEY (id)
);

CREATE TABLE storage_item
(
    id         BIGINT NOT NULL,
    storage_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    CONSTRAINT pk_storage_item PRIMARY KEY (id)
);

CREATE TABLE user_
(
    id            BIGINT NOT NULL,
    department_id BIGINT,
    CONSTRAINT pk_user_ PRIMARY KEY (id)
);

CREATE TABLE user_credentials
(
    id       BIGINT       NOT NULL,
    user_id  BIGINT,
    login    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    CONSTRAINT pk_user_credentials PRIMARY KEY (id)
);

CREATE TABLE user_role
(
    id   BIGINT       NOT NULL,
    role VARCHAR(255) NOT NULL,
    CONSTRAINT pk_user_role PRIMARY KEY (id)
);

CREATE TABLE user_user_roles
(
    user_roles_id BIGINT NOT NULL,
    user_id       BIGINT NOT NULL,
    CONSTRAINT pk_user_userroles PRIMARY KEY (user_roles_id, user_id)
);

ALTER TABLE customer
    ADD CONSTRAINT FK_CUSTOMER_ON_USER FOREIGN KEY (user_id) REFERENCES user_ (id);

ALTER TABLE department
    ADD CONSTRAINT FK_DEPARTMENT_ON_MANAGER FOREIGN KEY (manager_id) REFERENCES user_ (id);

ALTER TABLE order_item
    ADD CONSTRAINT FK_ORDER_ITEM_ON_ORDER FOREIGN KEY (order_id) REFERENCES order_ (id);

ALTER TABLE order_item
    ADD CONSTRAINT FK_ORDER_ITEM_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE order_
    ADD CONSTRAINT FK_ORDER__ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE order_
    ADD CONSTRAINT FK_ORDER__ON_PAYMENT FOREIGN KEY (payment_id) REFERENCES payment (id);

ALTER TABLE shipment
    ADD CONSTRAINT FK_SHIPMENT_ON_ORDER FOREIGN KEY (order_id) REFERENCES order_ (id);

ALTER TABLE shipment
    ADD CONSTRAINT FK_SHIPMENT_ON_STORAGE FOREIGN KEY (storage_id) REFERENCES storage (id);

ALTER TABLE storage_item
    ADD CONSTRAINT FK_STORAGE_ITEM_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE storage_item
    ADD CONSTRAINT FK_STORAGE_ITEM_ON_STORAGE FOREIGN KEY (storage_id) REFERENCES storage (id);

ALTER TABLE user_credentials
    ADD CONSTRAINT FK_USER_CREDENTIALS_ON_USER FOREIGN KEY (user_id) REFERENCES user_ (id);

ALTER TABLE user_
    ADD CONSTRAINT FK_USER__ON_DEPARTMENT FOREIGN KEY (department_id) REFERENCES department (id);

ALTER TABLE user_user_roles
    ADD CONSTRAINT fk_useuserol_on_user FOREIGN KEY (user_id) REFERENCES user_ (id);

ALTER TABLE user_user_roles
    ADD CONSTRAINT fk_useuserol_on_user_role FOREIGN KEY (user_roles_id) REFERENCES user_role (id);