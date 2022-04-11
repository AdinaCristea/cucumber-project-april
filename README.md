# Cucumber test framework - UI and REST

## Requirements

- Java 8 or higher
- Intellij Idea version->2020.1
- Latest version of Cucumber for Java and Gherkin plugins

## Run Cucumber tests with Maven

This project has the maven-compiler-plugin added in POM that is used to compile the sources of the project.

_To run tests with maven use the below command_

```bash
mvn clean verify 
```

# Run Cucumber tests with Docker

Depending on your needs, follow the instruction below:

To start the tests in a docker container run the following command.

```bash
docker-compose up -d
```

__Selenium Grid__

__To be able to run the UI tests the Selenium Grid needs to be started beforehand using Docker__:

```bash
docker-compose up selenium-hub firefox -d
```

Additionally, you can manually start tests with a docker container afterwards using the command

```bash
docker-compose run --rm maven

```

For clean up run the following command

```
docker-compose down --remove-orphans
```

## Cucumber report

Reporting is done using Cucumber Reports service. After tests are run the link for report is generated

## Surefire plugin

Surefire plugin is used to generate reports in .txt and .xml format.

_Soon will be implemented also for html format_

## Tags

- @ui (run UI tests/run only for UI tests)
- @rest (run REST tests)

## Test layers

- test steps (logic implementation)
- test launch (test runner)
- test data (feature files)
- page (webpages and elements)