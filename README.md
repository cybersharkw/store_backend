# store_backend

Dies ist eine Beispiel Applikation von einem Backend, welche Produkte verwaltet. Diese können mit hibernate Search gesucht werden. 


## Running the application in dev mode

Erstellung Docker Image (Datenbank):
```shell script
docker run --name QuarkusStoreDb -e POSTGRES_DB=storeBackend -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=1234 -p 5432:5432 -d postgres:13
```
Applikation starten:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application


