package org.fooddeliveryapp.service;

import org.fooddeliveryapp.model.Stats;
import org.fooddeliveryapp.model.Delivery;
import org.fooddeliveryapp.model.Person;
import org.fooddeliveryapp.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatsServiceImpl implements StatsService{

    @Autowired
    DeliveryRepository deliveryRepository;

    @Override
    public Stats getStatistics(Stats stats/* you're passed start and end time*/) {
        Iterable<Delivery> allDeliveries = deliveryRepository.findAll();
        HashMap<Person, Long> deliveryManComission = new HashMap<Person, Long>();
        for (Delivery d:allDeliveries){
            // check for the interval in which we're looking for stats
            if (d.getStartTime().isAfter(stats.getStartInterval()) && d.getEndTime().isBefore(stats.getEndInterval())){
                Person deliveryMan = d.getDeliveryMan();
                Long comission = d.getComission();
                if (deliveryManComission.get(deliveryMan) != null){
                    deliveryManComission.put(deliveryMan,(deliveryManComission.get(deliveryMan) + comission));
                } else {
                    deliveryManComission.put(deliveryMan, comission);
                }
            }
        }
        // check the populated HashMap for top 3 deliveryMen
        List<Person> deliveryMenTop3 = deliveryManComission.entrySet().stream().sorted(Map.Entry.<Person,Long>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
        stats.setTop3DeliveryMen(deliveryMenTop3);

        // get the average from all deliveryMen in deliveryManComission hashMap
        long total = 0;
        int numberOfMen = 0;
        for (long comission : deliveryManComission.values()){
            total+=comission;
            numberOfMen++;
        }
        long average = total/numberOfMen;

        stats.setAverageComission(average);
        return stats;
    }
}
