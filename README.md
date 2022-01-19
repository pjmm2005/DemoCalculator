# Calculator implementation


## Purpose

The objective of this application is to implement a microservice that represents a calculator and is therefore capable of performing a series of operations from two operands.

This calculator in each implementation that we are going to use can be created with a series of operations, which can be added through existing operations or new operations.

Later this calculator will be used through a REST api and therefore we will use SpringBoot to be able to make the corresponding requests and for the calculator to execute the corresponding operations.

## Available operations

As mentioned above, depending on the implementation of the calculator that is going to be used, it will have a series of operations or others, to be able to know at any time what operations we have, we can consult them in the url:

```shell script
calculator/availableOps
```

## Reason for selection type of operand and result

Due to the fact that in the definition of the test the criticality is not indicated in terms of the precision of the operands and the result of the operations, it has been decided to define them of type Double, in case of requiring greater precision it would be convenient to define them as BigDecimal.

# Validating the application

In order to validate the application, the first thing we will do is compile the application:

```shell script
mvn clean install
```

if we do not want the tests to be executed when the application is built

```shell script
mvn clean install -DskipTests
```

and later we can run the microservice locally with the command

```shell script
mvn spring-boot:run
```

# Testing the application

The application contains both unit and integration tests, all of them can be executed with the command

```shell script
mvn clean verify
```

# API documentation

We can consult both the available operations and the possible responses through open-api with swagger:

```shell script
http://localhost:8080/swagger-ui.html
```

# Logging the application

The application has a tracing system through the 'tracer' library, leaving traces on the console.

