package com.example.service;

import com.example.domain.DrivingObject;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrixElement;

/**
 * Created by banesrdjevic on 6/23/16.
 */
public interface DrivingService {
    DrivingObject createDrivingObject(DistanceMatrixApiRequest request) throws Exception;

    DrivingObject mapDrivingObjectFromElements(DistanceMatrixElement[] elements);
}
