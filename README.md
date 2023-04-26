# FoodDeliveryApp
API backend server code for a food delivery mobile application to call

This is a delivery startup which allows its users to register as delivery men or customers.
Customer gives an order from the online shop and delivery man picks the order and drives it to the customer.
At the end of delivery, delivery man sends a request to the server with his/her id, customer id, order id, the distance in km and the start and end time of delivery.

A few details:

- Users are using the mobile app, and the API is consumed by that mobile app
- User can not be both customer and delivery man at the same time. Only one must be chosen at registration
- The delivery man earns commission for each order. 
- The delivery man is not allowed to deliver multiple orders at the same time

Future Enhancements:

- Creating a new API endpoint to display top 3 delivery men who earn the most commission in given time interval, and average commission as well.
- Notifying Customer support team when a delivery is not done in 45 minutes. With a scheduled task to check and notify CS team asynchronously. (print a message at least)

# Development Environment:

Github for source/version control
Gradle as the build too
Java 8
Postgresql for database
Liquibase
Using Inellij locally for development/debugging 
