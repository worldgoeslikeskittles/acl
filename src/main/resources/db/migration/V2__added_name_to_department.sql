ALTER TABLE department
    ADD name VARCHAR(255);

ALTER TABLE department
    ALTER COLUMN name SET NOT NULL;