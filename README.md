### A professional Selenium-based Test Automation Framework designed for the IMS Assignment. This project follows the **Page Object Model (POM)** design pattern to ensure high maintainability and scalability.

# **Key Features**

### **Page Object Model (POM):** Decouples test logic from UI locators.
### **Data-Driven Testing:** Utilizes Apache POI to fetch test data from Excel.
### **Centralized Configuration:** Managed via a BaseClass and config.properties.
### **Robust Reporting:** Integrated with Extent Reports for interactive HTML results.
### **Automatic Screenshots:** Captures system screenshots automatically upon test failure.
### **Utility Library:** Includes reusable methods for Waits, Excel handling, and UI interactions.

# **Tech Stack**

* Language: Java
* Automation Tool: Selenium WebDriver
* Test Runner: TestNG
* Build Tool: Maven
* Reporting: Extent Reports 5.x
*Data Management: Apache POI (Excel)

IMS-Assignment
├── src/main/java
│   ├── constants        # Strores all the constants
│   ├── pages            # Page Objects and Locators
│   └── utils            # ExcelReader, ScreenshotUtil, ExtentReport,Page Utility, Wait Utiity
├── src/main/resources
│   └── config.property  # url
├── src/test/java
│   ├── automationcore   # Base
│   ├── dataprovider
│   ├── reportgeneration
│   ├── retry
│   └── testscript
├── src/test/resources
│   ├── Data.xlsx
├── crossbrowser.xml     # Execute testcase in different browser
├── grouping.xml         # Execute testcase using grouping
├── pom.xml              # Maven Dependencies
└── testng.xml           # Execute testcase 

#**How to Run the Tests**

-Prerequisites: Ensure you have Java 11+ and Maven installed.
-Clone the Repo: git clone https://github.com/jeena342/IMS-Assignment.git
-Run via Maven: Open terminal in project root and run: mvn clean test
-Run via TestNG: Right-click on testng.xml in Eclipse and select Run As > TestNG Suite.
