# spring-cloud-contract-consumer-example

This project provides an example of how Consumer Driven Contracts work.

## Pre-requisites

Clone and install Spring Boot Example project in your .m2 repository.

This project contains the producer contract stubs and will act as the backend for our example.

```
git clone https://github.com/HarshadRanganathan/spring-boot-example.git
mvn clean install
```

## Consumer-Producer

`spring-cloud-contract-consumer-example` acts as a consumer which will send a REST request to the endpoint served by `spring-boot-example` which acts as a producer.

All we require to quickly stand up the producer is it's contract stubs.

We can access the stubs in multiple ways:
- REMOTE
- CLASSPATH
- LOCAL

Here we have used the classpath approach by defining the `spring-boot-example` artifact in the POM file.

```
<dependency>
    groupId>com.springboot.example</groupId>
    <artifactId>spring-boot-example</artifactId>
    <version>${producer.version}</version>
    <classifier>stubs</classifier>
    <scope>test</scope>
</dependency>
```

Here, we are using the classifier `stubs` to download only the stub artifact jar to the classpath.

Typical, the artifact would get downloaded from nexus or public maven.

I haven't hosted the artifact in any public repositories. Hence, initially we had run the ``mvn install`` command to download the producer stubs to our local repo.

## Consumer Test

`BackendServiceTest` uses `AutoConfigureStubRunner` to start a stub server based on the contracts defined in `spring-boot-example` project.

When we make our call to the backend, the request is sent to the stub server which checks to see if there are any matchers and sends stub response.

No mocking or need to have a real microservice up and running.

Spring Cloud Contract Verifier helps to:

- ensure that HTTP / Messaging stubs (used when developing the client) are doing exactly what actual server-side implementation will do

- promote acceptance test driven development method and Microservices architectural style

- to provide a way to publish changes in contracts that are immediately visible on both sides of the communication

- to generate boilerplate test code used on the server side
