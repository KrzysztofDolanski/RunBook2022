package com.dola.runnerbook.web;

import com.dola.runnerbook.domain.genre.dto.GenreDTO;
import com.dola.runnerbook.domain.genre.GenreService;
import com.dola.runnerbook.domain.road.RoadService;
import com.dola.runnerbook.domain.road.dto.RoadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class GenreController {

    private final GenreService genreService;
    private final RoadService roadService;

    @Autowired
    public GenreController(GenreService genreService, RoadService roadService) {
        this.genreService = genreService;
        this.roadService = roadService;
    }

    @GetMapping("/genre/{name}")
    public String getGenre(@PathVariable String name, Model model) {
        GenreDTO genre = genreService.findGenreByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<RoadDTO> roads = roadService.findRoadsByGenreName(name);
        model.addAttribute("heading", genre.getName());
        model.addAttribute("description", genre.getDescription());
        model.addAttribute("roads", roads);
        return "road-listing";
    }


    @GetMapping("/road-genre")
    public String getGenreList(Model model) {
        List<GenreDTO> genres = genreService.findAllGenres();
        model.addAttribute("genres", genres);
        return "genre-listing";
    }

}
