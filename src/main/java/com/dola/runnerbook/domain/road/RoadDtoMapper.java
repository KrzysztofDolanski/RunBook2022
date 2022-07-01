package com.dola.runnerbook.domain.road;

import com.dola.runnerbook.domain.rating.Rating;
import com.dola.runnerbook.domain.road.dto.RoadDTO;

class RoadDtoMapper {


    static RoadDTO mapToDTO(Road road){
            double avgRating = road.getRatings().stream()
                    .map(Rating::getRating)
                    .mapToDouble(val -> val)
                    .average().orElse(0);
            int ratingCount = road.getRatings().size();
        return new RoadDTO(
                road.getId(),
                road.getName(),
                road.getCity(),
                road.getLength(),
                road.getGenre(),
                road.isPromoted(),
                road.getPoster(),
                road.getDescription(),
                avgRating,
                ratingCount);

    }
}
