package com.example.service;

import com.example.domain.TransitObject;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.Distance;
import com.google.maps.model.DistanceMatrixElement;

/**
 * Created by banesrdjevic on 6/23/16.
 */
public interface TransitService {
    TransitObject createTransitObject(DistanceMatrixApiRequest request) throws Exception;

    TransitObject mapTransitObjectFromElements(DistanceMatrixElement[] elements);
}
