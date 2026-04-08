
# Payroll Management System 

##  Overview

This project is a Java-based Payroll Management System** that demonstrates key Object-Oriented Programming (OOP) concepts such as:

* Abstraction
* Inheritance (Hierarchical & Multilevel)
* Method Overriding
* Polymorphism

The system calculates the **Cost to Company (CTC)** for different types of employees.

---

##  Class Structure

### 1. Abstract Class: `Employee`

* Acts as the base class for all employees.
* Contains common attributes:

  * `name`, `PANNo`, `joiningDate`, `designation`, `empId`
* Defines:

  * `abstract double calcCTC()` → Must be implemented by subclasses
  * `display()` → Prints employee details

---

###  2. FullTimeEmployee (Hierarchical Inheritance)

* Inherits from `Employee`
* Additional attributes:

  * `baseSalary`, `perfBonus`, `role`
* CTC Calculation:

  * SWE / HR → `baseSalary + perfBonus`
  * Others → `baseSalary`

---

### 3. ContractEmployee (Hierarchical Inheritance)

* Inherits from `Employee`
* Additional attributes:

  * `noOfHrs`, `hourlyRate`
* CTC Calculation:

  * `noOfHrs × hourlyRate`

---

###  4. Manager (Multilevel Inheritance)

* Inherits from `FullTimeEmployee`
* Additional attributes:

  * `TA` (Travel Allowance), `eduAllowance`
* CTC Calculation:

  * `baseSalary + perfBonus + TA + eduAllowance`

---

## Features

* Handles multiple employee types
* Uses abstraction for flexible design
* Demonstrates real-world payroll logic
* Clean and modular code structure

---

##  How to Run

### Step 1: Compile

```bash
javac PayrollSystem.java
```

### Step 2: Run

```bash
java PayrollSystem
```

---

##  Sample Output

```
------ Full Time Employee ------
Employee ID: 101
Name: Rahul Sharma
Designation: Software Engineer
PAN No: ABCDE1234F
Joining Date: 01-01-2022
CTC: 60000.0

------ Contract Employee ------
Employee ID: 102
Name: Priya Verma
Designation: Contract Developer
PAN No: PQRSX5678L
Joining Date: 05-02-2023
CTC: 48000.0

------ Manager ------
Employee ID: 103
Name: Amit Singh
Designation: Project Manager
PAN No: LMNOP9876Z
Joining Date: 15-03-2021
CTC: 93000.0
```

---

## OOP Concepts Used

| Concept      | Implementation                        |
| ------------ | ------------------------------------- |
| Abstraction  | `Employee` abstract class             |
| Inheritance  | FullTimeEmployee, ContractEmployee    |
| Multilevel   | Manager → FullTimeEmployee → Employee |
| Polymorphism | `calcCTC()` method overriding         |

---

##  Future Enhancements

- Add database integration (MySQL)
- GUI using Java Swing / JavaFX
- Add tax deductions and payslip generation
- Employee search & update functionality

---

##  Author

Akshita Mishra**

---


