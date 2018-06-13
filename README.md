# Package

##Architecture

The application is built by modules using dependency injection, this leads the code to be modular and testable 

It has 3 big modules
* Input: this module loads all the information that the apps needs to start
* Mapper: this module makes necessary data transformation
* Organizer: this module is the core API in charge of solving package problem

Patterns used:
* Singleton
* Builder 
* Factories

###Build
The App is packaged with Gradle


### Dependency Injection Framework

This is a standalone small app, so I decided to use a lightweight dependency injection framework  

Guice https://github.com/google/guice

###Logs

Logs are ready for production, they are configure with log4J

###Utilities

I used this libraries to improve code quality and maintainability

* Lombok
* SLF4
* Guava 
* VAVR
* AssertJ