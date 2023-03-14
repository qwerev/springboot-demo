# Dummy Springboot project

## Prerequisites
* Maven >= 3.8.5
* OpenJDK = 17
* Docker >= 20.10
* Docker-compose >= v2.15.1 (optional)

## Build steps

### Build Springboot project
```
mvn package clean
```

### Starting the demo service

```
docker run -p 8080:8080 --rm qwerev/springboot-demo:latest
```
or
```
docker-compose up
```


