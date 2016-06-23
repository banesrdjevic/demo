package com.example.service;

import com.example.domain.*;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;

/**
 * Created by banesrdjevic on 6/23/16.
 */
public interface TravelResponseService {
    TravelResponse createTravelResponse(GeoApiContext context) throws Exception;
}
