# `springbootplayground`

This is a simple project to demonstrate usage of:
  - Java 21 (LTS)
  - Spring Boot
  - React (single-page application)
  - PostgreSQL

# Getting Started

``` zsh
mvn spring-boot:run
mvn spring-boot:start
mvn spring-boot:stop
```

Observability root path: http://localhost:8080/actuator.

Clean local Docker environments:

``` zsh
echo y | docker rm --force $(docker ps --all --quiet --filter status=exited)
echo y | docker volume prune
```

Start Docker environment containing local services:

``` zsh
docker compose up
# or, alternatively:
docker compose up --force-recreate --renew-anon-volumes
```

Now on your machine different services are available:

- Grafana: http://localhost:3000
- Prometheus: http://localhost:9090

See [docker-compose.yml](./docker-compose.yml) for all services.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

