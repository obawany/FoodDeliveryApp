package org.fooddeliveryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
public class FoodDeliveryAppBackend {
    public static void main(String[] args) {
        SpringApplication.run(FoodDeliveryAppBackend.class, args);
    }
}