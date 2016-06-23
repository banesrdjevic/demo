package com.example.domain;

/**
 * Created by banesrdjevic on 6/23/16.
 */
public class DrivingObject {
    private final String priceHumanReadable;
    private final String priceValue;
    private final String durationHumanReadable;
    private final Long durationValue;

    public DrivingObject(String priceHumanReadable, String priceValue, String durationHumanReadable, Long durationValue) {
        this.priceHumanReadable = priceHumanReadable;
        this.priceValue = priceValue;
        this.durationHumanReadable = durationHumanReadable;
        this.durationValue = durationValue;
    }

    public String getPriceHumanReadable() {
        return priceHumanReadable;
    }

    public String getPriceValue() {
        return priceValue;
    }

    public String getDurationHumanReadable() {
        return durationHumanReadable;
    }

    public Long getDurationValue() {
        return durationValue;
    }
}
