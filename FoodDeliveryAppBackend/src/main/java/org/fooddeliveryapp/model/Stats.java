package org.fooddeliveryapp.model;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

public class Stats {
    @NotNull
    Instant startInterval;
    @NotNull
    Instant endInterval;
    List<Person> top3DeliveryMen;
    Long averageComission;

    public Instant getStartInterval() {
        return startInterval;
    }

    public void setStartInterval(Instant startInterval) {
        this.startInterval = startInterval;
    }

    public Instant getEndInterval() {
        return endInterval;
    }

    public void setEndInterval(Instant endInterval) {
        this.endInterval = endInterval;
    }

    public List<Person> getTop3DeliveryMen() {
        return top3DeliveryMen;
    }

    public void setTop3DeliveryMen(List<Person> top3DeliveryMen) {
        this.top3DeliveryMen = top3DeliveryMen;
    }

    public Long getAverageComission() {
        return averageComission;
    }

    public void setAverageComission(Long averageComission) {
        this.averageComission = averageComission;
    }
}

