CREATE TABLE IF NOT EXISTS report (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    device_name VARCHAR(255) NOT NULL,
    device_brand VARCHAR(255) NOT NULL,
    power_consumption DOUBLE NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    device_id BIGINT,
    FOREIGN KEY (device_id) REFERENCES devices(id)
);