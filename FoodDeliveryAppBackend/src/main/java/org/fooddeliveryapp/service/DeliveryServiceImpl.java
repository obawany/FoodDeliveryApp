package org.fooddeliveryapp.service;

import java.time.Instant;
import java.time.LocalTime;
import java.util.Optional;

import org.fooddeliveryapp.repositories.DeliveryRepository;
import org.fooddeliveryapp.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements org.fooddeliveryapp.service.DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    public Delivery save(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }


    public Delivery findById(Long deliveryId) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);
        if (optionalDelivery.isPresent()) {
            return optionalDelivery.get();
        }else return null;
    }

    // implement the update
    // first findById, then after calculation of commission update delivery model and save
    @Override
    public Delivery finish(Delivery delivery) {
        // check if this delivery exists, an order has been placed by customers
        delivery.setEndTime(Instant.now());
        Double comission = (delivery.getPrice() * 0.05 + delivery.getDistance() * 0.5);
        delivery.setComission(Double.doubleToLongBits(comission));
        return deliveryRepository.save(delivery); // TODO: check if this is updating
    }

    @Override
    public Delivery pick(Delivery delivery) {
        // TODO: check if the driver is eligible to pick this delivery (i.e. isn't carrying an order)
        delivery.setDeliveryMan(delivery.getDeliveryMan());
        return deliveryRepository.save(delivery);
    }
}
