package com.example.service.impl;

import com.example.domain.*;
import com.example.service.*;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by banesrdjevic on 6/23/16.
 */

@Service
public class TravelResponseServiceImpl implements TravelResponseService {
    private final BicyclingService bicyclingService;
    private final WalkingService walkingService;
    private final DrivingService drivingService;
    private final TransitService transitService;

    @Autowired
    public TravelResponseServiceImpl(BicyclingService bicyclingService, WalkingService walkingService, DrivingService drivingService, TransitService transitService) {
        this.bicyclingService = bicyclingService;
        this.walkingService = walkingService;
        this.drivingService = drivingService;
        this.transitService = transitService;
    }

    @Override
    public TravelResponse createTravelResponse(GeoApiContext context, String origin, String destination) throws Exception{
        BicyclingObject bicyclingObject = null;
        DrivingObject drivingObject = null;
        WalkingObject walkingObject = null;
        TransitObject transitObject = null;

        try {
            bicyclingObject = bicyclingService.createBicyclingObject(createNewRequest(context, origin, destination));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            drivingObject = drivingService.createDrivingObject(createNewRequest(context, origin, destination));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            walkingObject = walkingService.createWalkingObject(createNewRequest(context, origin, destination));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            transitObject = transitService.createTransitObject(createNewRequest(context, origin, destination));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return new TravelResponse(bicyclingObject, drivingObject, transitObject, walkingObject, origin, destination);
    }

    private DistanceMatrixApiRequest createNewRequest(GeoApiContext context, String origin, String destination){
        DistanceMatrixApiRequest distanceMatrixApiRequest = new DistanceMatrixApiRequest(context);
        distanceMatrixApiRequest.origins(origin);
        distanceMatrixApiRequest.destinations(destination);
        return distanceMatrixApiRequest;
    }
}
