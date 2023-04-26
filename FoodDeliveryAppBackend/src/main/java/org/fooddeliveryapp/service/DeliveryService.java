package org.fooddeliveryapp.service;

import org.fooddeliveryapp.model.Delivery;

public interface DeliveryService {

    public Delivery save(Delivery delivery);

    public Delivery findById(Long deliveryId);

    public Delivery finish(Delivery delivery);

    public Delivery pick(Delivery delivery);

}
