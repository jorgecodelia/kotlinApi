# Example kotlin Rest API

## Overview

This documentation outlines the endpoints available in the example REST API built with Spring Boot 3 and kotlin.

## Dependencies

The following report links work once the api is compiled in local

| Resource    | Documentation                           | Report                                                           |
|:------------|:----------------------------------------|:-----------------------------------------------------------------|
| kotlin      | https://kotlinlang.org/                 | No                                                               |
| Java        | https://openjdk.org/projects/jdk/17/    | No                                                               |
| Gradle      | https://gradle.org/                     | No                                                               |
| Spring Boot | https://spring.io/projects/spring-boot/ | No                                                               | 
| JUnit       | https://junit.org/junit5/               | [Report](/build/reports/tests/test/index.html)                   | 
| Pitest      | https://pitest.org/                     | [Report](/build/reports/pitest/index.html)                       | 
| ArchUnit    | https://www.archunit.org/               | Yes                                                              | 
| SpotsBugs   | https://github.com/spotbugs/spotbugs/   | Yes                                                              | 
| Checkstyle  | https://checkstyle.sourceforge.io/      | [Report](/build/reports/checkstyle/main.html)                    | 
| PMD         | https://pmd.github.io/                  | [Report](/build/reports/pmd/main.html)                           | 
| Open API    | https://springdoc.org/                  | [Report](http://localhost:8080/fabrik/api/swagger-ui/index.html) | 


## Project Structure

```sh
example-kotlin-api/
│
├── config                                              // api main config src
├── gradle/                                             // Gradle configurations file
├── src/
│   ├── main/
│   │   ├── kotlin/
│   │   │   └── com.exmple.kotlin.api/
│   │   │      ├── config/                              // General configurations
│   │   │      ├── controller/                          // REST API controllers
│   │   │      ├── entity/                              // Api general entities
│   │   │      ├── exception/                           // Global custom exceptions
│   │   │      └── repository                           // Repository interfaces
│   │   │      ├── service/                             // Service layer
│   │   │      └── Application.kt                       // Main class to run the application
│   │   │
│   │   └── resources/                                  // Project Resources
│   │
│   └── test/                                           // Project Test sources
│
├── .gitignore                                          // git ignore configuration file
├── build.gradle                                        // Gradle build configuration file
└── README.md                                           // Project MD documentation
```

## Base URL

The base URL for all endpoints is `http://localhost:8080/api/fabrik/v1`.

## API Endpoints
The following endpoints are available:

* GET /fabrik/api/v1/accounts: Retrieves all accounts.
```sh
curl --location 'http://localhost:8080/fabrik/api/v1/accounts' \
--header 'Content-Type: application/json'
```

## Endpoint Documentation 

The openApi URL documentation in local environment is `http://localhost:8080/api/swagger-ui/index.html`.

## Important gradle tasks
```sh
- `clean`  - clean build results
- `build`  - build public artifact
- `test`   - run unit tests and arch unit tests
- `pitest` - run pitest mutation test
```

## Build
```sh
./gradlew clean build test pitest
```

## Run

```sh
./gradlew bootRun -Dspring.profiles.active=local
```

## License
This Api is distributed under the terms of the MIT License. See the [license](license.md) for details.