# SRM

## Student Record Management System

### Description

Student record management is an application which connects and interfaces with a secure database to safely and securely store, view and update records.

### Scenario

Consider a scenario of a where lecturers, admin staff, and authorities need to go through the records of 
students for various purposes like searching for a particular student’s details. Manually going through 
records is a tedious job and time-consuming. Hence, it is better to have a software that allows users to 
insert, update, search, or delete records automatically. Hence, your team have been tasked with designing 
a Java program of a student record management system for CPUT faculty of engineering and the built 
environment. The design should enable the creation of new student records, store the personal and 
academic records of each student, allow all student records to be accessed by authorizes, but restrict 
access to lectures and admins (e.g., registration, courses enrollment). 

### Components

1.  Record management

    a.  Add/Remove/View personal info

    b.  Academic Records attached to profile

2.  Access Control

    a.  Login Page (user control)
        
       1. Once logged in, able to change password

    b.  Different access levels 

### Minimum Requirements

SRM uses a MySQL database to store and manage records

- Use the connector to connect to database

    > https://dev.mysql.com/downloads/connector/j/

SRM needs JAVA and JAVA Development Kit 23

- JAVA Development Kit 23 can be found @

    > https://www.oracle.com/za/java/technologies/downloads/#jdk23-windows


- JAVA can be found @

    > https://www.java.com/en/download/

### Application in action

#### Login Page

![Image](/img/Login%20screen.jpg)

#### Change password screen

![Image](/img/ChangePassword%20screen.jpg)

#### SRM

![Image](/img/SRM.jpg)

#### Records

![Image](/img/Record.jpg)

#### Database

- Database view from inside Apache Netbeans

![Image](/img/Database%20structure.jpg)

- Database view from linux server

![image](/img/MobaXtren.jpg)