
# Selenium -Cucumber Custom Framework 

This is a Meaven project built using Selenium -JAVA, It is integrated with cucumber for writing feature files and execution of test cases


## Test Execution Flow
Framework mainly has 2 folder

* src/main/java - Holds all the configuration files 

* /config - driver and browser management

* src/test/java - contains test scripting and execution files 

* /features - contains all the features files written in the gherkin language

* /Helper  - contains reusable methods to perform repeated actions

* /hooks - Contains @Before @After etc annotations to modify test execution Flow

* /stepdefinitions contains actual steps for features



## Initiating Selenium driver
The compatible chrome driver is placed in/driver folder located in the project directory

* chromedriver.exe must be executed in the command line and be made sure that the selenium server is up and running.
* This driver will  work for Chrome 
Version 110.0.5481.178 (Official Build) (64-bit)

* You will be able to see the below message in the terminal.

* Starting ChromeDriver 110.0.5481.77 
* ChromeDriver was started successfully.


## Test Execution
Open the project using any IDE - Intellij Preferred. 

* Test Execution using the runner file --------------
Tests can be triggered by running the test runner files located at src/main/java/testRunner/Runner

* This will run all the tests and generate html reports along with screenshots upon test failure

* Execute using the cucumber.xml file located in the root folder.
## Test Reporting

Post test execution framework generates html files under /reports   folder located in current directory.

* Reports can be opened using any browser.
* Screenshots attacted to reports upon failure
* current director/archive_reports conatins some of the previous execution reports for reference 


## Dependency_management 

As this project is built using Maven,
dependencies are managed using the pom.xml file
## git branches

There are 2 brnaches in this repo.
* Main
* Feature
* Most of the development done in feature branch and later merged with main
* .git ignore file -  As  good practice heavier files must be exceluded but intentionally /driver / reports are not excluded

## Author
* Name - Bilal Mohammad
* Linkedin - https://www.linkedin.com/in/bilal-mohammad-552b0b159/

* Email - BILALROSHAN5@GMAIL.COM

* Please reach out to me by email if you have any queries related to this project.

                             -- Good Day.
