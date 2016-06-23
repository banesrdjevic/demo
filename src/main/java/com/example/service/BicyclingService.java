package com.example.service;

import com.example.domain.BicyclingObject;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrixElement;

/**
 * Created by banesrdjevic on 6/23/16.
 */
public interface BicyclingService {
    BicyclingObject createBicyclingObject(DistanceMatrixApiRequest request) throws Exception;

    BicyclingObject mapBicyclingObjectFromElements(DistanceMatrixElement[] elements);
}
