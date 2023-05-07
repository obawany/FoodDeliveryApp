# FoodDeliveryApp

The FoodDeliveryApp is designed to facilitate a delivery service through a mobile application. 

- Users can register as either delivery men or customers. 
- Customers can place orders from online shops, and delivery men are responsible for picking up the orders and delivering them to the customers. 
- After completing a delivery, the delivery man sends a request to the server containing their ID, the customer's ID, the order ID, the distance traveled in kilometers, and the start and end times of the delivery.

Here are some important points to note:

- The mobile app is used by the users, and it consumes the API provided by the backend server.
- A user cannot simultaneously be a customer and a delivery man. They must choose one role during the registration process.
- The delivery men earn a commission for each order they deliver.
- Delivery men are not allowed to handle multiple orders simultaneously.

Features:

- An API endpoint that displays the top three delivery men who have earned the highest commissions within a given time interval, along with the average commission.
- A notification system to alert the Customer Support team when a delivery is not completed within 45 minutes. This has been achieved through a scheduled task that asynchronously checks and prints a message.

Tried to follow this: https://www.javaguides.net/2018/06/restful-api-design-best-practices.html
and https://auth0.com/blog/spring-boot-java-tutorial-build-a-crud-api/. Accepted answer is helpful on this one: https://stackoverflow.com/questions/52235902/should-i-use-model-classes-or-payload-classes-to-serialize-a-json-response

# Development Environment:

- Github for source/version control
- Gradle as the build too
- Java 8
- Postgresql for database
- Liquibase
- Using Inellij locally for development/debugging 
Liquibase


To run existing project with Docker

Application is already dockerized. You can run following command in root folder for setting up Postgres database.

`docker compose up`

Run application from Gradle or ide.