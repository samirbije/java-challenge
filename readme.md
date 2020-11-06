### How to use this spring-boot project

- Install packages with `mvn package`
- Run `mvn spring-boot:run` for starting the application (or use your IDE)

Application (with the embedded H2 database) is ready to be used ! You can access the url below for testing it :

- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console

> Don't forget to set the `JDBC URL` value as `jdbc:h2:mem:testdb` for H2 UI.



### Instructions

- download the zip file of this project
- create a repository in your own github named 'java-challenge'
- clone your repository in a folder on your machine
- extract the zip file in this folder
- commit and push

- Enhance the code in any ways you can see, you are free! Some possibilities:
  - Add tests
  - Change syntax
  - Protect controller end points
  - Add caching logic for database calls
  - Improve doc and comments
  - Fix any bug you might find
- Edit readme.md and add any comments. It can be about what you did, what you would have done if you had more time, etc.
- Send us the link of your repository.

#### Restrictions
- use java 8


#### What we will look for
- Readability of your code
- Documentation
- Comments in your code 
- Appropriate usage of spring boot
- Appropriate usage of packages
- Is the application running as expected
- No performance issues

#### Samir updates
setup database setting in property file for embeded h2 database
Fixed the broken POST, return created data in response
Fixed the PUT API to updated and not create new, return the updated data in response
Added global exception handler and custrom exception for EmployeeNotFound
Throw EmployeeNotFound if invalid employeeID sent on Update, GetByID and DeleteByID features
Add unit test for EmployeeService (validDataTest and InvalidDataTest)
Added comments on all important functions

#### Samir TODO (if more time)
seperate property files based on enviroment
Define logback.xml with seperate setting for development and production
Data validation checks
lombok plugin setup with ide
adding of more unit tests
set up integration test helpers and add tests
