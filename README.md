# Enviro Waste Management API
## Project Overview
The Enviro Waste Management API is a Spring Boot application designed to manage waste categories, disposal guidelines, and recycling tips. This API allows users to perform CRUD (Create, Read, Update, Delete) operations on waste-related data. The application uses Spring Boot, Jakarta Validation, Spring Data JPA, and H2 Database for easy and efficient management of waste data.

#### Features:
- Create, read, update, and delete waste categories, disposal guidelines, and recycling tips.
- Input validation using Jakarta Validation annotations.
- Data stored in an in-memory H2 database for quick development and testing.
Returns responses in JSON format.

## Technologies Used
- **Spring Boot**: Framework for building the application.
- **Spring Data JPA**: For database interactions and CRUD operations.
- **Jakarta Validation**: For validating user inputs.
- **Hibernate Validator**: Implementation of Jakarta Validation.
- **H2 Database**: In-memory database for fast development and testing.
- **REST API**: Exposes CRUD endpoints.

## Project Setup
### Prerequisites
Before you start, make sure you have the following installed:

- **Java** 17 or later.
- **Maven**: For building and managing dependencies.
- **An IDE** like IntelliJ IDEA or Eclipse (optional, but recommended. I used VS code).

### Clone the Repository
To get started, clone the project from GitHub:

    git clone https://github.com/Nokwanda09/singabenkosimpungose.git


### Install Dependencies
Navigate to the project directory and run the following Maven command to download the dependencies:

    mvn clean install


### Run the project
To run the project, navigate to the main class and run it using run button.


## API Endpoints
### Base URLs
> - http://localhost:8080/wasteCategory
> - http://localhost:8080/quotes
> - http://localhost:8080/recyclingTip
> - http://localhost:8080/disposalGuideline

1. Get all items in the database
> **GET** /all

2. Get item by Id 
For waste category & sustainability qoutes
> **GET** /{id}

For disposal guidelines and recycling tip
> **GET** /id/{id}

3. Get item by waste category
Applies to only disposal guideline and recycling tip
> **GET** /wasteCategory/{wasteCategory}

4. Add a new item
> **POST** /add

5. Update item data
> **PUT** /update/{id}

6. Delete item
> **DELETE** /delete/{id}

## Testing
To test the API, you can use tools like:

- **Postman**: A tool for testing APIs.
- **Curl**: A command-line tool for making HTTP requests.

## Contact
For any questions or feedback, feel free to reach out to smpungose023@student.wethinkcoke.co.za

