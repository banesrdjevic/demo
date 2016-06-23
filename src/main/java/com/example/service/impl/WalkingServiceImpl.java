package com.example.service.impl;

import com.example.domain.WalkingObject;
import com.example.service.WalkingService;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.TravelMode;
import org.springframework.stereotype.Service;

/**
 * Created by banesrdjevic on 6/23/16.
 */

@Service
public class WalkingServiceImpl implements WalkingService{

    @Override
    public WalkingObject createWalkingObject(DistanceMatrixApiRequest request) throws Exception{
        DistanceMatrix distanceMatrix = request.mode(TravelMode.WALKING).await();
        DistanceMatrixRow distanceMatrixRow = distanceMatrix.rows[0];
        DistanceMatrixElement[] elements = distanceMatrixRow.elements;
        return mapWalkingObjectFromElements(elements);
    };

    @Override
    public WalkingObject mapWalkingObjectFromElements(DistanceMatrixElement[] elements){
        String priceValue = elements[0].fare == null ? "Free" : elements[0].fare.value.toString();
        String priceHumanReadable = elements[0].fare == null ? "Free" : elements[0].fare.currency.toString();
        Long durationValue = elements[0].duration.inSeconds;
        String durationHumanReadable = elements[0].duration.humanReadable;
        return new WalkingObject(priceHumanReadable, priceValue, durationHumanReadable, durationValue);
    };
}
