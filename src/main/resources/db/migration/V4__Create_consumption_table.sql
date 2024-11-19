CREATE TABLE consumption (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    amount DOUBLE NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    device_id BIGINT NOT NULL,
    FOREIGN KEY (device_id) REFERENCES device(id)
);
