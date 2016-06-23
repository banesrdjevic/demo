package com.example.service;

import com.example.domain.WalkingObject;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;

public interface WalkingService {
    WalkingObject createWalkingObject(DistanceMatrixApiRequest request) throws Exception;

    WalkingObject mapWalkingObjectFromElements(DistanceMatrixElement[] elements);
}
