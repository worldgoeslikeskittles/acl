ALTER TABLE payment
    ADD order_id BIGINT;

ALTER TABLE payment
    ADD CONSTRAINT FK_PAYMENT_ON_ORDER FOREIGN KEY (order_id) REFERENCES order_ (id);

ALTER TABLE order_
DROP
CONSTRAINT fk_order__on_payment;

ALTER TABLE order_
DROP
CONSTRAINT fk_order__on_shipment;

ALTER TABLE order_
DROP
COLUMN payment_id;

ALTER TABLE order_
DROP
COLUMN shipment_id;