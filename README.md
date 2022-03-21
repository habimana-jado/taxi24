# Taxi-24 Fleet Management btn driver and rider

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [How to run](#how-to-run)

## General Info

This project is a coding challenge application that allows registration/view/initialization and completion of driver/rider and trip.
  
## Technologies
This project is created with:
* Java 8 - Spring boot V 2.5.2
* Hibernate 4.3.1
* Maven V 3.6.2

## How to run
Project is implemented in Java 8 Spring boot V 2.5.2 with maven V 3.6.2

To start: 
1. Install Jdk 1.8 and above
2. Install maven
3. Install Postgres Database and adjust application.properties located in resources(Db username, Db password and create Database taxi24_db)
4. Run command "mvn clean install -DskipTests" at root directory to install required dependencies
5. Run Java Main class 'Taxi24Rest' or run command "mvn spring-boot:run" at root directory to start the application

Note: The application is running on port 8080. You can change it by changing server.port in application.properties

After starting the application, use Curl or postman to make requests.

Key endpoints exposed include:

  POST  http://localhost:8080/register-driver           For registering new Driver
  GET   http://localhost:8080/available-drivers         For Viewing registered Drivers
  GET   http://localhost:8080/get-driver/{nationalId}   For Viewing one Driver based on nationalId
  
  POST  http://localhost:8080/register-rider            For registering new Rider
  GET   http://localhost:8080/get-all-riders            For Viewing registered Riders
  GET   http://localhost:8080/get-rider/{nationalId}    For Viewing one Rider based on nationalId
  
  POST  http://localhost:8080/register-trip             For registering new Trip
  GET   http://localhost:8080/get-active-trips          For Viewing Active trips
  GET   http://localhost:8080/complete-trip/{tripId}    For Completing a Ride based on tripId

Register Driver Sample Object
{
    "driverNames":"Kalisa Landry",
    "phoneNumber":"0788888",
    "nationalId":"1199680023157215"
}

RegisterRider Sample Object
{
    "riderNames":"Keza Ange",
    "phoneNumber":"0788888",
    "nationalId":"1199680023157211"
}

Register Trip Sample Object
{
    "departure":"Kimihurura",
    "destination":"Kabeza",
    "charge":5000,
    "riderNationalId":"1199680023157211",
    "driverNationalId":"1199680023157215"
}
