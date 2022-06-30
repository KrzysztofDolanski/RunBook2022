package com.dola.runnerbook.domain.road;

import com.dola.runnerbook.domain.road.dto.RoadDTO;

class RoadDtoMapper {


    static RoadDTO mapToDTO(Road road){
        return new RoadDTO(road.getId(), road.getName(), road.getCity(), road.getLength(), road.getGenre(), road.isPromoted(), road.getPoster());
    }
}
