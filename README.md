# FoodDeliveryApp

API backend server code for a food delivery mobile application to call

FoodDelivery is a delivery startup which allows its users to register as delivery men or customers.
Customer gives an order from the online shop and delivery man picks the order and drives it to the customer.
At the end of delivery, delivery man sends a request to the server with his/her id, customer id, order id, the distance in km and the start and end time of delivery.

Users are using the mobile app, and the API is only consumed by mobile app
User can not be both customer and delivery man at the same time. Only one must be chosen at registration
The delivery man earns commission for each order.

The delivery man is not allowed to deliver multiple orders at the same time

Development Environment:

GIT for version control
Gradle
Java 8
Postgresql
Liquibase


To run existing project with Docker

Application is already dockerized. You can run following command in root folder for setting up Postgres database.


docker compose up


Run application from Gradle or ide.