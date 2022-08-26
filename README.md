# openweatherapi-springboot

Springboot application with OpenWeatherMap API 

## Introduction

This application will return:

* Average of daily (06:00 – 18:00) and nightly (18:00 – 06:00) temperatures in Celsius for the next 3 days from today’s date.

* Average of pressure for the next 3 days from today’s date data from OpenWeatherMap.org, based on a city chosen by the user.

**Source of Data**

Weather data is read from http://openweathermap.org/ using API http://api.openweathermap.org/data/2.5/forcast?q={city}&appid={apiKey}

**Pre-requisite**

To use this app, you need to register an API Key on http://openweathermap.org/ service. 
Update API url and key in `src/main/resources/application-prod.properties`

**How to run**

This app has embedded tomcat server. In order to run this website execute below maven command 

```
mvn spring-boot:run
```

Navigate to the 'release' folder inside the project

```
run 'java -jar weather-0.0.1-SNAPSHOT'
```

After successful startup:

It will start the embedded tomcat server on default port 8080

**How to Use**

* Access the website using http://localhost:8080/v1/city/Ahmadabad  
* Enter the City Name
* Hit Submit button

## Technologies used
* Spring Core
* RestTemplate
* Spring Boot
* Maven
* Mockito
* Junit
* Embedded Tomcat Server

