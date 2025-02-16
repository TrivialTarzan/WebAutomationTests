<h1 align="center">WebAutomationTests</h1>
<h2 align="center">Java/Selenium/Gherkin/Cucumber/JUnit</h2>


The project involved creating automated test scripts for three websites: greenkart.com and saucedemo.com, using Gherkin, Cucumber, Selenium and JUnit.

- Gherkin- the specification language to write test scenarios
- Cucumber- the framework for executing these scenarios 
- Selenium- the automation tool to interact with the websites' elements and perform actions 
- JUnit was used to validate expected results

I implemented the Page Object Pattern, to follow the good practices and to keep everything nice and organized, and Page Factory, to simplify the initialization of web elements.

## Directory Tree

- WebAutomationTests
  - src
    - Cucumber
      - Features
  - src
    - test
      - java/github/TrivialTarzan
  - target
    - test-classes/github/TrivialTarzan
  - pom.xml
  - README.txt



| File | Description |
| ------ | ------ |
| scr/Cucumber/Features/ | Contains the test scenarios |
| src/test/| Includes page objects, classes executing scenario steps, and the `AllTests` file for running tests |

## Tests execution

Each sceanrio has its own fixtures, e.g.:

```java
@successful-purchase
```
```java
@saucedemo
```

To run a specific scenario, you need to change the value of the 'tags' component in the @CucumberOptions annotation, in the ```src/test/java/github/TrivialTarzan/AllTests.java```:

```java
@CucumberOptions(features = "src/Cucumber/Features/",'
        'plugin = {"pretty","html:out"}, tags = "@successful-purchase")
```
