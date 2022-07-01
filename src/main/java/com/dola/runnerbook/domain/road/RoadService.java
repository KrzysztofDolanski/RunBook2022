package com.dola.runnerbook.domain.road;

import com.dola.runnerbook.domain.genre.GenreRepository;
import com.dola.runnerbook.domain.road.dto.RoadDTO;
import com.dola.runnerbook.domain.road.dto.RoadSaveDTO;
import com.dola.runnerbook.data_warehouse.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoadService {

    private final RoadRepository roadRepository;
    private final GenreRepository genreRepository;
    private final FileService fileStorageService;

    @Autowired
    public RoadService(RoadRepository roadRepository
            , GenreRepository genreRepository
            , FileService fileStorageService) {
        this.roadRepository = roadRepository;
        this.genreRepository = genreRepository;
        this.fileStorageService = fileStorageService;
    }

    public List<RoadDTO> findAllPromotedRoads() {
        return roadRepository.findAllByPromotedIsTrue().stream()
                .map(RoadDtoMapper::mapToDTO)
                .toList();
    }

    public Optional<RoadDTO> findRoadById(long id) {
        return roadRepository.findById(id).map(RoadDtoMapper::mapToDTO);
    }

    public List<RoadDTO> findRoadsByGenreName(String name) {
        return roadRepository.findAllByGenre_NameIgnoreCase(name)
                .stream()
                .map(RoadDtoMapper::mapToDTO)
                .toList();
    }

    public void addRoad(RoadSaveDTO roadDTO) {
        Road road = new Road();

        road.setName(roadDTO.getName());
        road.setCity(roadDTO.getCity());
        road.setLength(roadDTO.getLength());
        road.setPromoted(roadDTO.isPromoted());
        road.setGenre(genreRepository.findByNameIgnoreCase(roadDTO.getGenre()).orElseThrow());
        if (roadDTO.getPoster() != null) {
            String savedFileName = fileStorageService.saveImage(roadDTO.getPoster());
            road.setPoster(savedFileName);
        }
        road.setDescription(roadDTO.getDescription());
        roadRepository.save(road);
    }
}

