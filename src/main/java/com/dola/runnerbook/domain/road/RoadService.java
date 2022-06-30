package com.dola.runnerbook.domain.road;

import com.dola.runnerbook.domain.road.dto.RoadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoadService {

    private final RoadRepository roadRepository;

    @Autowired
    public RoadService(RoadRepository roadRepository) {
        this.roadRepository = roadRepository;
    }

    public List<RoadDTO> findAllPromotedRoads() {
        return roadRepository.findAllByPromotedIsTrue().stream()
                .map(RoadDtoMapper::mapToDTO)
                .toList();
    }

    public Optional<RoadDTO> findRoadById(long id) {
        return roadRepository.findById(id).map(RoadDtoMapper::mapToDTO);
    }

    public List<RoadDTO> findMoviesByGenreName(String genre) {
        return roadRepository.findAllByGenre_NameIgnoreCase(genre).stream()
                .map(RoadDtoMapper::mapToDTO)
                .toList();
    }

    public List<RoadDTO> findRoadsByGenreName(String name) {
        return roadRepository.findAllByGenre_NameIgnoreCase(name)
                .stream()
                .map(RoadDtoMapper::mapToDTO)
                .toList();
    }
}

