# 🎯 Event Management – Selenium Test Automation Framework

This repository contains the automated test suite for the **Event Management System** web application. The focus is on automating regression tests for two key areas: the **Booking Form** and the **Contact Us Form**.

The framework follows BDD principles using **Cucumber**, with a **Page Object Model** structure to keep the codebase clean and maintainable.

---

## 🛠️ Tech Stack

- **Automation**: Selenium WebDriver  
- **Language**: Java  
- **Build Tool**: Maven  
- **Test Runner**: TestNG  
- **BDD Framework**: Cucumber  
- **Logging**: Log4j2  
- **Data-Driven Testing**: Apache POI (Excel)

---

## 📦 Project Structure
├── src
│   └── test
│       ├── java
│       │   ├── hooks/            # Setup & teardown (e.g., browser init, screenshots)
│       │   ├── pages/            # Page Object classes for Booking & Contact forms
│       │   ├── runner/           # Cucumber TestNG runner
│       │   ├── stepDefinitions/  # Gherkin step implementations
│       │   └── utils/            # Config reader, Excel data reader
│       └── resources
│           ├── config/
│           │   └── config.properties
│           ├── features/
│           │   ├── Booking.feature
│           │   └── ContactUs.feature
│           ├── screenshots*/     # Captured screenshots (on failure)
│           ├── testData/
│           │   └── TestData.xlsx
│           └── log4j2.xml        # Logging configuration
│
├── pom.xml                     # Maven dependencies & build settings
├── testng.xml                  # TestNG suite config
└── README.md                   # Project documentation

---

## 🔄 How It Works

- **Hooks**: Sets up WebDriver before each scenario and closes it afterward. Captures screenshots on failure.
- **Page Objects**: Encapsulates locators and actions for each form.
- **Step Definitions**: Connects Gherkin steps to Java methods.
- **ExcelReader**: Pulls input data from `TestData.xlsx` for data-driven scenarios.
- **Cucumber + TestNG**: Executes feature files and generates reports.

---

## 🚀 How to Run the Tests

### ✅ Prerequisites
- Java (JDK 1.8+)
- Apache Maven
- Chrome or Firefox browser

### ▶️ To Execute:
Run the TestRunner.java file using TestNG suite and include the tags of the scenarios you want to run.
