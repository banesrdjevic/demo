package com.example.domain;

/**
 * Created by banesrdjevic on 6/23/16.
 */
public class TravelResponse {
    private final BicyclingObject bicyclingObject;
    private final DrivingObject drivingObject;
    private final TransitObject transitObject;
    private final WalkingObject walkingObject;

    public TravelResponse(BicyclingObject bicyclingObject, DrivingObject drivingObject, TransitObject transitObject, WalkingObject walkingObject){
        this.bicyclingObject = bicyclingObject;
        this.walkingObject = walkingObject;
        this.transitObject = transitObject;
        this.drivingObject = drivingObject;
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
}
