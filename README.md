# CentimeT1
This repository contains a project which includes a small springboot application hosted on AWS.

## Description

This application consists of three modules - one main GreetingService module and two sub modules - HelloService and ConcatenateService.
HelloService is a simple service which returns 'hello' when called.
ConcatenateService accepts firstName and lastName as parameters and returns a concatenated response.
GreetingService is used to greet Persons by their name. It calls both HelloService and ConcatenateService and then combines the responses
of both the services and return it as a String.

## Getting Started

### Dependencies

* This module requires Windows OS and libraries like Mockito, Swagger, GSON, and basic springboot starter dependencies.

### Installing

* Clone this repository
* Navigate to the root level of the directory.
* Get started with the three micro services. 

### Executing program

* Please see the links below:
  * http://ec2-43-204-95-188.ap-south-1.compute.amazonaws.com:8080/swagger-ui.html
  * http://ec2-43-205-95-52.ap-south-1.compute.amazonaws.com:8081/api/hello
  * http://ec2-65-0-133-148.ap-south-1.compute.amazonaws.com:8082/swagger-ui.html

## Contact
Ayush Gupta - https://www.linkedin.com/in/ayush-gupta-20a34589/ - ayushgupta07@outlook.com

Project Link: https://github.com/AyushGupta07/CentimeT1.git
