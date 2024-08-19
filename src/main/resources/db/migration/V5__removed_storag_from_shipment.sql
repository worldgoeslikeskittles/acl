ALTER TABLE shipment
DROP
CONSTRAINT fk_shipment_on_storage;

ALTER TABLE shipment
DROP
COLUMN storage_id;