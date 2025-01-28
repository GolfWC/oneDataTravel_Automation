# UI Automation Framework with Selenium and Cucumber

This is a UI Automation Framework for Web and Desktop Application using Selenium and Cucumber

## Features
- Web Automation
- Desktop Automation
- Cross Browser Testing

## Tools
- Selenium
- Cucumber
- TestNG
- Maven
- Log4j
- Extent Report


## How to run the test
- Clone the repository
- Open the project in IntelliJ IDEA
- Run the test using the TestRunner class
- To run the test in different browser, change the browser name in the `config.properties` file
- To run the test in different environment, change the environment name in the `config.properties` file
- To run the test form Maven, use the following command
```
mvn test -DrunEnv=sauceLabs
```

## Report
- The report is generated using Extent Report
- The report is generated in the `target` folder
- The report is generated in the `html` format


## Pending Task

Integrate Jira with your automation framework and automatically generate test cases and test results in Jira, you can use the Jira REST API. Here is a step-by-step guide to achieve this:
Add Dependencies: Add the necessary dependencies to your pom.xml file for making HTTP requests and handling JSON.

```
    <dependency>
    <groupId>org.apache.httpcomponents</groupId>
    <artifactId>httpclient</artifactId>
    <version>4.5.13</version>
    </dependency>
    
    <dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.12.3</version>
    </dependency>
```












############################################################################################################


- Pending Screen Shot and VDO record. Integrate with saucelab.
- Page extension to display the report.
- Report not show much details
Optional: Check it out for PlayWrit
------------------------------------------------------------------
Create New Desktop Framework for Automation.


Need to go through 
- Azure Devops
- VS code
- Desktop automation framework
- Screen extension management

------------------------------------------------------------------

ChromeDriver Kill Task
Task kill /IM chromedriver.exe /F

-------------------------------------------------------------------
Path for WinAppDriver.exe
"C:\Program Files (x86)\Windows Application Driver\WinAppDriver.exe" 

--------------------------------------------------------------------
Dependency Needed
<!-- https://mvnrepository.com/artifact/io.appium/java-client -->
<dependency>
    <groupId>io.appium</groupId>
    <artifactId>java-client</artifactId>
    <version>9.3.0</version>
</dependency>

----------------------------------------------------------------------
Create Maven Project 
Use -> Quick Start Project

----------------------------------------------------------------------
implement cucumber structure on the desktop framework
Take screenshot require to implement with the framework

-------------------------------------------------------------------------
Pom.xml
line 54-72 add
line 94-101
---------------------------------------------------------
Added
log4j2.xml  under src/test/resources

------------------------------------------------------------
Test runner Added
"json:target/cucumber.json"
@tag

--------------------------------------------------------------

mvn command to run the test
mvn verify -DskipTests

--------------------------------------------------------------
Integrate with Jenkins
Integrate with SourceLab
--------------------------------------------------------------
```
mvn test -DrunEnv=sauceLabs
```
