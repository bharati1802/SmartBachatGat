# SmartBachatGat

SmartBachatGat is a simple Java-based application to manage a 5-year savings group (Bachat Gat) of 10 women.  
It helps track monthly deposits, distribute and manage loans, record repayments, and generate basic reports.

---

## Why I Built this Project

In many villages and towns women form small saving groups where they contribute a fixed amount every month,
 and sometimes takes loans from the group funds. Manging these records manully can be confusing and error-prone. 
 I wanted to solve this problem using JAVA and in the process practice Object-Oriented Programming, file structure,
 and coding discipline.

 
## Project Objective

This project aims to:
- Manage members of the savings group
- Track monthly deposits and total contributions
- Handle loan issuance and repayments
- Calculate interest and principal on loans
- Generate reports to monitor group progress

---

## Project Structure

<pre>
## Project Structure


SmartBachatGat/
├── README.md
├── Data/                    # To store saved files or reports
├── src/
│   ├── model/               # Entity classes (data models)
│   │   ├── Member.java
│   │   ├── Deposit.java
│   │   ├── Loan.java
│   │   ├── Repayment.java
│   │   └── BachatGat.java
│   ├── service/             # Business logic layer
│   │   ├── MemberService.java
│   │   ├── LoanService.java
│   │   └── ReportService.java
│   ├── util/                # Helper and utility functions
│   │   ├── FileHandler.java
│   │   └── Utils.java
│   └── main/                # Entry point
│       └── Main.java

</pre>
---

## Package Descriptions

### model/
Contains data model classes:
- Member.java: Stores member details and status
- Deposit.java: Tracks monthly contributions
- Loan.java: Contains information about issued loans
- Repayment.java: Records repayment transactions
- BachatGat.java: Represents the group as a whole

### service/
Contains business logic classes:
- MemberService.java: Manages member operations
- LoanService.java: Handles loan issuing and repayments
- ReportService.java: Generates reports for group data

### util/
Utility classes:
- FileHandler.java: Reads and writes data to files
- Utils.java: Common helper methods used across the app

### main/
- Main.java: Entry point of the application

### Data/
Contains saved files and generated reports

---

## How to Run the Project

1. Open the project in VS Code or any Java IDE.
2. Make sure JDK 8 or later is installed.
3. Compile all .java files:


javac -d out src\main\Main.java src\model\*.java src\service\*.java  

---

## Run the application using:

java cp src main.Main.

##  Key Features

- Register and manage members  
- Record monthly deposits  
- Distribute loans and calculate interest  
- Record repayments and update balances  
- Save and load data using text files (savings, loans, repayments)  
- Simple report generation (savings, loans, repayments)  

---

##  About Me

I am a fresher and MCA student currently learning Java.  
This project is part of my hands-on practice to understand *OOPs concepts, **file handling, and **application structure*.

---

##  Future Improvements

- Add validations and error handling  
- Build a menu-based or GUI interface  
- Replace file storage with JSON or database (MySQL)  
- Generate detailed financial reports