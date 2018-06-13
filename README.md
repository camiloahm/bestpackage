# Package

The project is also available here https://github.com/camiloahm/bestpackage

## Architecture

The application is built by modules using dependency injection, this leads the code to be modular and testable 

It has 3 big modules
* Input: this module loads all the information that the apps needs to start
* Mapper: this module makes necessary data transformation
* Organizer: this module is the core API in charge of solving package problem

I try to keep all the variables immutable and responsibilities clear . I built every module using TDD then I started to assemble the app.

Patterns used:
* Singleton
* Builder 
* Factories
* Dependency Injection

### Build
The App is packaged with Gradle, to build this app you can execute 
```
$ ./gradlew build

```


### Dependency Injection Framework

This is a standalone small app, so I decided to use a lightweight dependency injection framework  

Guice https://github.com/google/guice

### Logs

Logs are ready for production, they are configure with log4J

### Utilities

I used this libraries to improve code quality and maintainability

* Lombok
* SLF4
* Guava 
* VAVR
* AssertJ