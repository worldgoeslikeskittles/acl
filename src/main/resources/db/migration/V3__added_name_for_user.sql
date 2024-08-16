ALTER TABLE user_
    ADD name VARCHAR(255);

ALTER TABLE user_role
    ADD user_id BIGINT;

ALTER TABLE user_role
    ADD CONSTRAINT FK_USER_ROLE_ON_USER FOREIGN KEY (user_id) REFERENCES user_ (id);

ALTER TABLE user_user_roles
DROP
CONSTRAINT fk_useuserol_on_user;

ALTER TABLE user_user_roles
DROP
CONSTRAINT fk_useuserol_on_user_role;

DROP TABLE user_user_roles CASCADE;