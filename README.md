# store_backend

Dies ist eine Beispiel Applikation von einem Backend, welche Produkte verwaltet. Diese können mit hibernate Search gesucht werden. 

## Running the application in dev mode

Erstellung Docker Image (Datenbank):
```shell script
docker network create store_nw
```

```shell script
 docker run --name store-mysql -p 3306:3306 --network store_nw -e MYSQL_ROOT_PASSWORD=vs4tw -e MYSQL_USER=dbuser -e MYSQL_PASSWORD=dbuser -e MYSQL_DATABASE=storedb -d mysql:8.0
```

Applikation starten:
```shell script
./mvnw compile quarkus:dev
```

> ## Gelerntes und wichtigste Informationen

Ich hatte sehr Mühe dies ausfindig zu machen. Die Dokumentation ist sehr kompliziert beschrieben.

- @Indexes = Deklaration für die Klasse damit Suche funktioniert
- @Fulltextfield = Deklaration des Attributes welches aufgesucht werden kann. Wird nur bei Strings verwendet! ENUM deklaration welche Strings sind, benötigen auch keine Annotation.
- In der Resource Klasse gibt es verschiedene Suchdeklerationen:
    - .bool() Kombinieren von Konditionen
    - .should() Es braucht nur einen Match
    - .match() Full-Text Match
    - .where(f -> f.range().field("price").between(priceFrom, priceTill)) Suche von bis
    - .fetchHits() wird für Pagination benutzt und setzt ein Limit
    - .fetchTotalHitCount(); Zählt die Anzahl der Suchresultate

#### Quellenangabe

- [Quarkus - Hibernate Search ORM mit Elasticsearch](https://quarkus.io/guides/hibernate-search-orm-elasticsearch) für Annotationen
- [Hibernate Search Dokumentation](https://docs.jboss.org/hibernate/search/6.1/reference/en-US/html_single/#preface) für Informationen zu Funktionen
- ChatGPT, hauptsächlich bei Problemen und Misstverständisse um Klarheit zu schaffen

#### Hilfe von Drittpersonen

Ich hatte Probleme mit der DB und habe dafür Tipps von Simeon Liniger erhalten.

