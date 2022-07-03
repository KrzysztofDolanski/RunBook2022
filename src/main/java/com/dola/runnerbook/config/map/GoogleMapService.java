package com.dola.runnerbook.config.map;

import com.dola.runnerbook.domain.road.NoRoadException;
import com.dola.runnerbook.domain.road.RoadService;
import com.dola.runnerbook.domain.road.dto.RoadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoogleMapService {

    private static final String API_URL = "https://www.google.com/maps/embed/v1/place?key=";
    private static final String QUERY = "&q=";
    private final GoogleMapsClientProperties googleMapsClientProperties;
    private final RoadService roadService;

    private String GOOGLE_MAPS_QUERRY = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=";
    private String GOOGLE_MAPS_DESTINATION = "&destinations=";
    private String GOOGLE_MAPS_KEY = "&key=";

    @Autowired
    public GoogleMapService(GoogleMapsClientProperties googleMapsClientProperties, RoadService roadService) {
        this.googleMapsClientProperties = googleMapsClientProperties;
        this.roadService = roadService;
    }


    public String createGoogleMapQuery(Long id) throws NoRoadException{
        RoadDTO roadDTO = roadService.findRoadById(id).stream().findFirst().orElseThrow();
        if (roadDTO.getCityStart() != null) {
            return GOOGLE_MAPS_QUERRY+roadDTO.getCityStart() + GOOGLE_MAPS_DESTINATION + roadDTO.getCityStop() + GOOGLE_MAPS_KEY + googleMapsClientProperties.getToken();
//            return API_URL + googleMapsClientProperties.getToken() + QUERY + roadDTO.getCityStart() + "," + byUsername.getStreet() + byUsername.getStreetNo();
        } else throw new NoRoadException("No road: " + String.valueOf(id) + " found");
    }
}
