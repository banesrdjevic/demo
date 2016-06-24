package com.example.domain;

/**
 * Created by banesrdjevic on 6/23/16.
 */
public class TravelResponse {
    private final BicyclingObject bicyclingObject;
    private final DrivingObject drivingObject;
    private final TransitObject transitObject;
    private final WalkingObject walkingObject;
    private final String origin;
    private final String destination;

    public TravelResponse(BicyclingObject bicyclingObject, DrivingObject drivingObject, TransitObject transitObject, WalkingObject walkingObject, String origin, String destination) {

        this.bicyclingObject = bicyclingObject;
        this.drivingObject = drivingObject;
        this.transitObject = transitObject;
        this.walkingObject = walkingObject;
        this.origin = origin;
        this.destination = destination;
    }

    public BicyclingObject getBicyclingObject() {
        return bicyclingObject;
    }

    public DrivingObject getDrivingObject() {
        return drivingObject;
    }

    public TransitObject getTransitObject() {
        return transitObject;
    }

    public WalkingObject getWalkingObject() {
        return walkingObject;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }
}
