package com.example.controller;

import com.example.domain.BicyclingObject;
import com.example.domain.TravelResponse;
import com.example.service.BicyclingService;
import com.example.service.TravelResponseService;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestController {
    private final TravelResponseService travelResponseService;

    @Autowired
    public TestController(TravelResponseService travelResponseService) {
        this.travelResponseService = travelResponseService;
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public TravelResponse testItOut() throws Exception{
        GeoApiContext context = new GeoApiContext().setApiKey(System.getenv("GOOGLE_MAPS_API_KEY"));

        return travelResponseService.createTravelResponse(context);
//        return results;

    }
}
