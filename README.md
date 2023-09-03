# Job-Board-BackEnd

## Description

The Job Board  is a RESTful backend service that provides functionalities for managing job listings, companies, applicants, candidates, and employees. It follows  practices in RESTful architecture and  Spring Boot, Spring Data JPA.

## Technologies Used

- Java
- Spring Boot
- Gradle
- Hibernate
- MariaDB
- Hibernate Validator
- JPA repository

## Features

- Job: Create, update, retrieve, and delete job listings.
- Company: Manage information about companies posting job listings.
- Applicant: Handle applicant profiles and registrations.
- Candidate: Manage candidate applications for specific jobs.
- Employee: Keep track of company employees and their roles.

## Getting Started

### Prerequisites

- Java JDK (latest preferably)
- Gradle (latest preferably)
- MariaDB (latest preferably)

### Installation

1. Clone this repository: `git clone https://github.com/Hwkz0/Job-Board-BackEnd`
2. Navigate to the project directory: `cd Job-Board-BackEnd`
3. Build the project: `gradle build`

### Usage

- Create job listings using /api/job-board/jobs endpoints.
- Register companies using /api/job-board/companies.
- Applicants can register using /api/job-board/applicants and submit applications for jobs.
- Candidates can apply for jobs using /api/job-board/candidates.
- Manage employees and roles with /api/job-board/employees.


## Dependencies

- Spring Boot
- Spring Data JPA
- Spring Web
- Hibernate Core
- Hibernate Validator
- MariaDB Java Client

## Contributing

Contributions are welcome! Feel free to report issues, suggest enhancements, or submit pull requests.

## License


This project is licensed under the [MIT License](LICENSE).

## Contact

For any inquiries or feedback, please contact me at eduardddrimus@gmail.com

