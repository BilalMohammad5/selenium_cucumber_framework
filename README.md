
This project is built using the selenium java framework.
All the dependencies are managed via MAVEN.

Sample test cases are listed under : main/src/test/java/features
Features are written using the Gherkin language and have a .feature extension.

Step definitions for these features are availble under : main/src/test/java/step_definitions/launch
Step definition is written using JAVA

To execute the test run the cucumber.xml file located in the root directory.

Once the execution complete interactable reports are generated and stored under: main/reports/result.html



Install Chrome driver  chromedriver_win32.zip, extract the .exe file and run. Once you run successfully. 
Note the location of the driver, this location needs to be provided in the automation suite
clone the test automation project file and open it using any IDE. (Preferably Intellij)
go to the root folder -  current workspace\src\main\java\step_definitions\BaseClass.java
in the  BaseClass.java go to line number 32 and update  driver location as per the current workspace
System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe"); -this driver location needs to be updated.
then run the cucumber.xml located in the root folder
