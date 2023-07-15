<h1 align="center">WebAutomationTests</h1>
<h2 align="center">Java/Selenium/Gherkin/Cucumber/JUnit</h2>


The project involved creating automated test scripts for three websites: greenkart.com, olx.pl and saucedemo.com, using Gherkin, Cucumber, Selenium and JUnit.

It turned out that OLX uses Captcha to prevent automated scripts from bypassing them. I decided to respect it and to stop trying to get what's not mine. However, I uploaded the unfinished code- primarily to demonstrate my thought process. 
I continued working on GreenKart and the other website as they were both created with the intention of helping people improve their skills in writing automated test scripts.

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
| scr/Cucumber/Features/ | Contains all the test scenarios |
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
