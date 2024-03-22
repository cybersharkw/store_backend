# store_backend

Dies ist eine Beispiel Applikation von einem Backend, welche Produkte verwaltet. Diese können mit hibernate Search gesucht werden. 

## Running the application in dev mode

Erstellung Docker Image (Datenbank):
```shell script
docker network create store_n
```

```shell script
 docker run --name store-mysql -p 3306:3306 --network store-nw -e MYSQL_ROOT_PASSWORD=vs4tw -e MYSQL_USER=dbuser -e MYSQL_PASSWORD=dbuser -e MYSQL_DATABASE=storedb -d mysql:8.0
```
Applikation starten:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.



