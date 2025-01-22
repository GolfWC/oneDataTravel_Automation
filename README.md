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
