# `spring-boot-playground`

This is a simple project to demonstrate usage of:
  - Java 21 (LTS)
  - Spring Boot
  - React (single-page application)

![](./doc/Spring%20playground.jpg)

# Getting Started

``` zsh
mvn spring-boot:run
mvn spring-boot:start
mvn spring-boot:stop
```

# Docker dependency services

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

See [docker-compose.yml](./docker-compose.yml) for all services.

# Observability

We use Spring Boot actuator to gather several metrics. It is exposed here: http://localhost:8080/actuator.

Now on your machine different services are available:

- Swagger UI: http://localhost:3001
- Grafana: http://localhost:3000
- Prometheus: http://localhost:9090

![](./doc/OpenAPI.png)

Grafana dashboards:
- https://grafana.com/grafana/dashboards/6756-spring-boot-statistics/
- Ideally there would be a standard dashboard for endpoints and another for database connections.

![](./doc/Grafana.png)

# Load Simulation

A load simulation is described using the Java DSL. You can run it with Gatling:

``` zsh
mvn gatling:test
```

Of course it doesn't have a lot of meaning to run such simulation a local computer with a lot of different possible perturbation. An isolated, network-optimised environment in AWS is more repeatable. Still, it can give a rough, uneducated hint at the performance. Keep in mind that your local machine may have a limitation on the number of open file descriptors (`ulimit`), which further degrades the ability to simulate high load.

![](./doc/Gatling.png)

A note on AWS resources: instances should be in the same availability zone (ha ha), and Elastic Fabric Adapter network interface should help make the CPU and memory the limiting factors, not the network IO.

# Reference Documentation

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

