ALTER TABLE order_
    ADD shipment_id BIGINT;

ALTER TABLE order_
    ADD CONSTRAINT FK_ORDER__ON_SHIPMENT FOREIGN KEY (shipment_id) REFERENCES shipment (id);