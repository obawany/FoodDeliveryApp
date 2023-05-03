package org.fooddeliveryapp.jobs;

import org.fooddeliveryapp.repositories.DeliveryRepository;
import org.fooddeliveryapp.model.Delivery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Component
public class DelayedDeliveryNotifier {

    private static final Logger LOG = LoggerFactory.getLogger(DelayedDeliveryNotifier.class);

    @Autowired
    DeliveryRepository deliveryRepository;

    @Scheduled(fixedDelay = 30000)
    public void checkDelayedDeliveries() {
        List<Delivery> deliveryList = new ArrayList<>();
        deliveryRepository.findAll().forEach(deliveryList::add);

        for (Delivery d:deliveryList) {
            if (d.getEndTime() == null && (Instant.now().minusSeconds(2700).isAfter(d.getStartTime()))) {
                // delivery has this delivery man set as the driver and if end time is not set than
                // delivery hasn't finished and driver isn't eligible to pick this delivery - error
                notifyCustomerSupport(d);
            }
        }
    }

    @Async
    public void notifyCustomerSupport(Delivery delivery) {
        LOG.info("Customer support team is notified!" + delivery);
    } // CompletableFuture Async task would be needed
}