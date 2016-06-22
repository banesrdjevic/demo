package com.example.Controller;

import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TransitMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestController {

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DistanceMatrix testItOut() throws Exception{
        GeoApiContext context = new GeoApiContext().setApiKey(System.getenv("GOOGLE_MAPS_API_KEY"));


        DistanceMatrixApiRequest distanceMatrixApiRequest = new DistanceMatrixApiRequest(context);


        distanceMatrixApiRequest.origins("Linden Station, Wilmette, IL 60091");
        distanceMatrixApiRequest.destinations("30 E Huron Street Chicago, IL 60611");
        distanceMatrixApiRequest.transitModes(TransitMode.BUS, TransitMode.RAIL, TransitMode.SUBWAY, TransitMode.TRAIN, TransitMode.TRAM);
//        distanceMatrixApiRequest.mode(TravelMode.BICYCLING);
        return distanceMatrixApiRequest.await();
//        return results;

    }
}
