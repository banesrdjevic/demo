package com.example.service.impl;

import com.example.domain.BicyclingObject;
import com.example.service.BicyclingService;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.TravelMode;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class BicyclingServiceImpl implements BicyclingService {

    @Override
    public BicyclingObject createBicyclingObject(DistanceMatrixApiRequest request) throws Exception{
        DistanceMatrix distanceMatrix = request.mode(TravelMode.BICYCLING).await();
        DistanceMatrixRow distanceMatrixRow = distanceMatrix.rows[0];
        DistanceMatrixElement[] elements = distanceMatrixRow.elements;
        return mapBicyclingObjectFromElements(elements);
    };

    @Override
    public BicyclingObject mapBicyclingObjectFromElements(DistanceMatrixElement[] elements){
        String priceValue = elements[0].fare == null ? "Free" : elements[0].fare.value.toString();
        String priceHumanReadable = elements[0].fare == null ? "Free" : elements[0].fare.currency.toString();
        Long durationValue = elements[0].duration.inSeconds;
        String durationHumanReadable = elements[0].duration.humanReadable;
        return new BicyclingObject(priceHumanReadable, priceValue, durationHumanReadable, durationValue);
    };
}
