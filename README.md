# Cucumber test framework - UI and REST

## Requirements

- Java 8 or higher
- Intellij Idea version->2020.1
- Latest version of Cucumber for Java and Gherkin plugins

## Run Cucumber tests with Maven

This project has the maven-compiler-plugin added in POM used to compile the sources of the project.

_To run tests with maven use the below Command_

```bash
mvn clean verify 
```

# Docker

[//]: # (##Run Cucumber tests with Docker)

Docker-compose contains two profiles, selenium and all, which allows you to start the containers depending on the needs.

---
To start the tests in a docker container run the following command.

```bash
docker-compose --profile all up -d
```

__Selenium Grid__

To run the UI test with Maven, you need to run the following command.

```bash
docker-compose --profile selenium up -d
```

Additionally, you can manually start tests with a docker container afterwards with the below command

```bash
docker-compose run --rm maven

```

For clean up run the following

```
docker-compose down --remove-orphans
```

## Tags

- @ui (run UI tests/run only for UI tests)
- @rest (run REST tests)

## Test layers

- test steps (logic implementation)
- test launch (test runner)
- test data (feature files)
- page (webpages and elements)