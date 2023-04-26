package org.fooddeliveryapp.controller;

import org.fooddeliveryapp.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.fooddeliveryapp.service.DeliveryService;

@RestController
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    // DELIVERY MAN should use PUT/UPDATE to that delivery
    // SHOULDN't call save, should call update and calculate commission
    // CHECK for this driver id there isn't a row with end time null
    @PutMapping(path = "/finish-delivery")
    public ResponseEntity<Delivery> finishDelivery(@RequestBody Delivery delivery) {
        return ResponseEntity.ok(deliveryService.finish(delivery));
    }

    @PutMapping(path = "/pick-delivery")
    public ResponseEntity<Delivery> pickDelivery(@RequestBody Delivery delivery) {
        return ResponseEntity.ok(deliveryService.pick(delivery));
    }

    @PostMapping(path ="/create-delivery")
    public ResponseEntity<Delivery> createNewDelivery(@RequestBody Delivery delivery) {
        return ResponseEntity.ok(deliveryService.save(delivery));
    }

    @GetMapping(path = "/delivery/{delivery-id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable(name="delivery-id",required=true)Long deliveryId){
        Delivery delivery = deliveryService.findById(deliveryId);
        if (delivery !=null)
            return ResponseEntity.ok(delivery);
        return ResponseEntity.notFound().build();
    }
}
