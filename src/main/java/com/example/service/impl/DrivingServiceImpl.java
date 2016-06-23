package com.example.service.impl;

import com.example.domain.DrivingObject;
import com.example.service.DrivingService;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.TravelMode;
import org.springframework.stereotype.Service;

@Service
public class DrivingServiceImpl implements DrivingService {

    @Override
    public DrivingObject createDrivingObject(DistanceMatrixApiRequest request) throws Exception{
        DistanceMatrix distanceMatrix = request.mode(TravelMode.DRIVING).await();
        DistanceMatrixRow distanceMatrixRow = distanceMatrix.rows[0];
        DistanceMatrixElement[] elements = distanceMatrixRow.elements;
        return mapDrivingObjectFromElements(elements);
    };

    @Override
    public DrivingObject mapDrivingObjectFromElements(DistanceMatrixElement[] elements){
        String priceValue = elements[0].fare == null ? "Free" : elements[0].fare.value.toString();
        String priceHumanReadable = elements[0].fare == null ? "Free" : elements[0].fare.currency.toString();
        Long durationValue = elements[0].duration.inSeconds;
        String durationHumanReadable = elements[0].duration.humanReadable;
        return new DrivingObject(priceHumanReadable, priceValue, durationHumanReadable, durationValue);
    };
}
