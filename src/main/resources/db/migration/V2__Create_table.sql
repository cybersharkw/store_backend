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

INSERT INTO wine (name, country, region, info, grape, liter, alcohol, price) VALUES ('Chateau Lafite Rothschild', 'Frankreich', 'Bordeaux', 'Ein sehr feiner Wein', 'Cabernet Sauvignon', 1, 13.5, 500.00);

INSERT INTO wine (name, country, region, info, grape, liter, alcohol, price) VALUES ('Barolo', 'Italien', 'Piemont', 'Reich und vollmundig', 'Nebbiolo', 1, 14.0, 120.00);

INSERT INTO wine (name, country, region, info, grape, liter, alcohol, price) VALUES ('Napa Valley Chardonnay', 'USA', 'Kalifornien', 'Frisch und fruchtig', 'Chardonnay', 1, 13.0, 80.00);

INSERT INTO wine (name, country, region, info, grape, liter, alcohol, price) VALUES ('Rioja Reserva', 'Spanien', 'Rioja', 'Klassisch und elegant', 'Tempranillo', 1, 13.5, 60.00);

INSERT INTO wine (name, country, region, info, grape, liter, alcohol, price) VALUES ('Sancerre', 'Frankreich', 'Loiretal', 'Krisp und mineralisch', 'Sauvignon Blanc', 1, 12.5, 45.00);

INSERT INTO wine (name, country, region, info, grape, liter, alcohol, price) VALUES ('Shiraz Barossa Valley', 'Australien', 'Barossa Valley', 'Würzig und kraftvoll', 'Shiraz', 1, 14.5, 110.00);

INSERT INTO wine (name, country, region, info, grape, liter, alcohol, price) VALUES ('Amarone della Valpolicella', 'Italien', 'Venetien', 'Intensiv und komplex', 'Corvina', 1, 15.0, 150.00);

INSERT INTO wine (name, country, region, info, grape, liter, alcohol, price) VALUES ('Puligny-Montrachet', 'Frankreich', 'Burgund', 'Elegant und raffiniert', 'Chardonnay', 1, 13.0, 200.00);

INSERT INTO wine (name, country, region, info, grape, liter, alcohol, price) VALUES ('Stellenbosch Cabernet', 'Südafrika', 'Stellenbosch', 'Reichhaltig und strukturiert', 'Cabernet Sauvignon', 1, 14.0, 95.00);

INSERT INTO wine (name, country, region, info, grape, liter, alcohol, price) VALUES ('Pomerol', 'Frankreich', 'Bordeaux', 'Samtig und üppig', 'Merlot', 1, 13.5, 180.00);

