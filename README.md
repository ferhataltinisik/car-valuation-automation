# Car Valuation Automation Framework

## 📖 Project Overview
This project is an **end-to-end automation framework** designed to validate vehicle details retrieved from a car valuation website against predefined data stored in files (`car_input.txt` and `car_output.txt`). The framework ensures the accuracy of vehicle make, model, year, and other key attributes.

---

## 🚀 Key Features
✅ Automated vehicle search based on registration numbers from `car_input.txt`  
✅ Data extraction and parsing from the website’s general information table  
✅ Data comparison against expected values from `car_output.txt`  
✅ Supports batch processing — handles multiple vehicles in one run  
✅ Detailed mismatch reporting for failed assertions  
✅ Flexible configuration via `ConfigManager`  
✅ Logging integrated for better traceability  
✅ Designed using **Page Object Model (POM)** for scalability and maintainability

---
## 📂 Project Structure

```text
src/
├── main/
│   ├── java/
│   │   ├── config/            // ConfigManager for reading properties
│   │   ├── model/              // VehicleDetails model class
│   │   ├── pages/               // Page Objects (HomePage, CarDetailsReportPage)
│   │   ├── utils/                // Utilities (FileReaderUtil, DataComparator, Log)
│   │   └── runner/              // Test runner class (TestNG Cucumber Runner)
│   └── resources/
│       └── application.properties  // Configuration properties (base URL, file paths, etc.)
├── test/
│   ├── java/
│   │   ├── stepdefinitions/    // Step Definitions for Cucumber Steps
│   │   ├── hooks/               // Hooks (if any)
│   │   └── runner/              // Test Runner for Cucumber-TestNG integration
│   └── resources/
│       ├── features/           // Cucumber Feature Files
│       └── testDataFiles/      // Input/Output Files (car_input.txt, car_output.txt)
```
---

## ⚙️ Technologies Used
| Tool/Library        | Purpose                                |
|--------------------|----------------------------------|
| Java 17               | Core programming language |
| Selenium 4.x          | Browser automation |
| Cucumber 7.x         | BDD support |
| TestNG                  | Test orchestration |
| Log4j2                    | Logging |
| Extent Reports 5.x  | HTML reporting |
| Apache Commons | File reading |
| Maven                   | Build and dependency management |

---

## 📥 Installation & Setup
1. Clone the repository:
    ```
    git clone https://github.com/ferhataltinisik/car-valuation-automation.git
    ```
2. Navigate to the project directory:
    ```
    cd car-valuation-automation
    ```
3. Ensure Java 17 and Maven are installed.
4. Install dependencies:
    ```
    mvn clean install
    ```

---

## 🏃‍♂️ How to Run Tests
1. Prepare `car_input.txt` and `car_output.txt` in `src/test/resources/testDataFiles/`.
2. Run tests using Maven:
    ```
    mvn test
    ```
3. Optionally, you can run tests via IDE by executing `TestRunner`.

---

## 📊 Reporting
Not Implemented (Time Constraint)
Note: Reporting functionality (such as Extent Reports, Allure, or Cucumber Reports) has not been implemented in this project due to limited time allocation for the task.
In a real-world scenario, a comprehensive reporting mechanism would be integrated to provide clear visibility into test execution status, detailed logs, screenshots on failure, and historical test trends.
If required, this can be added as an enhancement in future iterations.


---

## 📂 Input/Output File Format
### car_input.txt


VARIANT_REG<br> SG18 HTN<br> AD58 VNF


### car_output.txt

VARIANT_REG,MAKE,MODEL,YEAR<br>
SG18 HTN,VOLKSWAGEN,GOLF SE NAVIGATION TSI EVO,2018<br>
AD58 VNF,BMW,120D M SPORT,2008

---

## 🔗 Sample Feature File
```gherkin
Feature: Validate Car Details on Car Valuation Website

  Scenario: Validate all car registration details from input file
    Given I have a file named "car_input.txt" with vehicle registration numbers
    And I am on the home page
    When I search each vehicle registration on car valuation website
    Then I should see all vehicle details matched correctly
```

### 📄 Configuration - application.properties

base.url = https://car-checking.com/ <br>
input.file.path = src/test/resources/testDataFiles/car_input.txt<br>
output.file.path = src/test/resources/testDataFiles/car_output.txt



### ✨ Future Enhancements<br>
Parallel execution support <br>
Screenshots on failure in Extent Report<br>
Jenkins integration for CI/CD<br>
Multi-browser support (Chrome, Firefox, Edge)<br>


### 👨‍💻 Author<br>
Ferhat Altinisik<br>
Senior QA Automation Engineer<br>
