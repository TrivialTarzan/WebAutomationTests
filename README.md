<h1 align="center">WebAutomationTests</h1>
<h2 align="center">Java/Selenium/Gherkin/Cucumber/JUnit</h2>


The project involved creating automated test scripts for three websites: greenkart.com, olx.pl and saucedemo.com, using Gherkin, Cucumber, Selenium and JUnit. My primary goal of this project was to improve my skills in writing test scripts.

It turned out that OLX uses Captcha to prevent automated scripts from bypassing them. I decided to respect it and to stop trying to get what's not mine. However, I uploaded the unfinished code- primarily to demonstrate my thought process. 
I continued working on saucedemo.com and the other website as they were both created with the intention of helping people improve their skills in writing automated test scripts.

- Gherkin was used as the specification language to write test scenarios
- Cucumber was used as the framework for executing these scenarios 
- Selenium was utilized as the automation tool to interact with the websites' elements, perform actions, and validate expected results 
- JUnit was used to perform assertions to validate expected behavior

I implemented the Page Object Pattern, to follow the good practices and to keep everything nice and organized, and Page Factory, to simplify the initialization of web elements and make the code more readable.

## Directory Tree

- WebAutomationTests
  - src
    - Cucumber
      - Features
  - src
    - test
      - java
        - github
          - TrivialTarzan
  - target
    - test-classes
      - github
        - TrivialTarzan
  - pom.xml
  - README.txt
  - sample_img.png



| File | Description |
| ------ | ------ |
| scr/Cucumber/Features/ | Contains all the test scenarios |
| src/test/| Includes page objects, classes executing scenario steps, and the `AllTests` file for running tests |

## Tests execution

Each sceanrio has its own fixtures, e.g.:

```
@successful-purchase
```
```
@saucedemo
```

To run specific scenario, you have to change the value of 'tags' component in the @CucumberOptions annotation

```
@CucumberOptions(features = "src/Cucumber/Features/",'
        'plugin = {"pretty","html:out"}, tags = "@successful-purchase")
```
