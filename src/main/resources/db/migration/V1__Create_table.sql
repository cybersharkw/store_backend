CREATE TABLE Producer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    country VARCHAR(255),
    region VARCHAR(255),
    info TEXT
);
INSERT INTO producer (name, country, region, info) VALUES ('Weingut Müller', 'Deutschland', 'Mosel', 'Bekannt für exquisite Rieslinge.');
INSERT INTO producer (name, country, region, info) VALUES ('Domaine Leroy', 'Frankreich', 'Burgund', 'Erzeugt einige der weltbesten Pinot Noirs.');
INSERT INTO producer (name, country, region, info) VALUES ('Antinori', 'Italien', 'Toskana', 'Historisches Weingut mit innovativem Geist.');
INSERT INTO producer (name, country, region, info) VALUES ('Bodega Catena Zapata', 'Argentinien', 'Mendoza', 'Vorreiter der hochwertigen Malbec-Produktion.');
INSERT INTO producer (name, country, region, info) VALUES ('Penfolds', 'Australien', 'South Australia', 'Bekannt für den legendären Grange.');
INSERT INTO producer (name, country, region, info) VALUES ('Robert Mondavi Winery', 'USA', 'Kalifornien', 'Pionier des modernen Weinbaus in Napa Valley.');
INSERT INTO producer (name, country, region, info) VALUES ('Vega Sicilia', 'Spanien', 'Ribera del Duero', 'Erzeugt den prestigeträchtigen Único.');
INSERT INTO producer (name, country, region, info) VALUES ('Quinta do Noval', 'Portugal', 'Douro', 'Berühmt für seinen herausragenden Portwein.');