ALTER TABLE device ADD COLUMN user_id BIGINT NOT NULL;
ALTER TABLE device ADD FOREIGN KEY (user_id) REFERENCES user(id);