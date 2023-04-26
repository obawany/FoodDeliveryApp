package org.fooddeliveryapp.repositories;

import org.fooddeliveryapp.model.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {

}
