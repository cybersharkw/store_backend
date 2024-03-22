CREATE TABLE Wine (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    info TEXT,
    price DECIMAL,
    inventory INT,
    country VARCHAR(255),
    region VARCHAR(255) NULL,
    gramm INT NULL,
    producer_id BIGINT NULL,
    grape VARCHAR(255),
    liter INT,
    alcohol DECIMAL,
    wineType VARCHAR(255) NULL,
    FOREIGN KEY (producer_id) REFERENCES Producer(id)
);


