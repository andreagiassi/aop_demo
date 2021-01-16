# Java Spring Boot Aspect Oriented Programming - AOP Demo

#### Overview
>The need to track some metrics on a Java web application is frequent. 
>Goal of this project is to offer a demo using the AOP to track some metrics on REST apis or inner service logics.

If you're using this software or a part of it, please support this open source with a small donation here:

<a href="https://www.buymeacoffee.com/andreag" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/default-orange.png" alt="Buy Me A Coffee" height="41" width="174"></a>

## Quick Start
The web application is exposing two different endpoints. One to send back the given message
 string, echo service, and another that is performing the sum of two numbers.

Thanks to the AOP has been defined two annotations.
The first one, @LogExecutionTime, is tracking on the log the time spent from the method where this annotation is applied.
The other one, @LogStatistics, is tracking the name of the executed method and the time spent into
a specific statistics table on a relational database.

This will open many future possibility in order to calculate the average time spent of a specific method
for example, or the number of usages.

On the @LogStatistics annotation there's also an additional parameter "metric".
The metric string value is to aggregate the collected tracks by macro features.

## What is Aspect Oriented Programming?
AOP stands for Aspect Oriented Programming. Thanks to the concept of aspects is possible to code and enrich some parts of the software in a transveral way.

Aspects enable the modularization of concerns such as transaction management, logging, security aspects or every features that are crosscutting.

To learn more about it just refer to the Aspect Oriented Programming with Spring: [AOP with Spring](https://docs.spring.io/spring-framework/docs/4.3.15.RELEASE/spring-framework-reference/html/aop.html).

### Setup and test
To setup this project you could use a Docker image of mysql or your existing setup.

Before to run the web application you need to create once the database schema called "statistics" and set
correctly the necessary username and password into the application.properties file.

The project is designed to use two containers:
* one Java 8 microservice
* one MySql database

### Run and test the tracking data
The project is using swagger in order to expose a simple user interface to use the REST apis.
Open a browser and explore the REST apis:

    http://localhost:8090/swagger-ui.html

You can start so to test the endpoints and check the tracked metrics in the MySql database.

Everything should be up and running :)

#### Author
This project has been created in January 2021 by Andrea Giassi.

Andrea he's an italian Agile professional and Software Engineer actives in web systems and services.
Since 2002, Andrea is working in the IT market for several different companies and start ups and it has contributed
 to the success of several solutions and products.

About me:
https://www.linkedin.com/in/andreagiassi/


Please support this open source with a small donation here:

<a href="https://www.buymeacoffee.com/andreag" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/default-orange.png" alt="Buy Me A Coffee" height="41" width="174"></a>

