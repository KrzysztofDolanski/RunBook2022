package com.dola.runnerbook.config.map;

import com.dola.runnerbook.domain.road.NoRoadException;
import com.dola.runnerbook.domain.road.dto.RoadDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

@Service
public class OpenStreetMapService {

    public String createGoogleMapQuery(RoadDTO roadDTO) throws NoRoadException {

        var props = new Properties();
        try {
            props.load(getClass().getClassLoader().getResourceAsStream("openrouteservice.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String mapQuery = props.getProperty("page");
        String key = props.getProperty("key");

        if (roadDTO.getCityStart() != null) {
            return mapQuery;
        } else throw new NoRoadException("No road: " + roadDTO + " found");
    }

}
