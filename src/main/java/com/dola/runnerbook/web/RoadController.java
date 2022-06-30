package com.dola.runnerbook.web;

import com.dola.runnerbook.domain.road.RoadService;
import com.dola.runnerbook.domain.road.dto.RoadDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class RoadController {
    private final RoadService roadService;

    public RoadController(RoadService roadService) {
        this.roadService = roadService;
    }

    @GetMapping("/road/{id}")
    public String getRoad(@PathVariable long id, Model model) {
        Optional<RoadDTO> optionalMovie = roadService.findRoadById(id);
        optionalMovie.ifPresent(road -> model.addAttribute("road", road));
        return "road";
    }
}
