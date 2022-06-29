package com.dola.runnerbook.web;

import com.dola.runnerbook.domain.road.RoadService;
import com.dola.runnerbook.domain.road.dto.RoadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {


    private final RoadService roadService;

    @Autowired
    public HomeController(RoadService roadService) {
        this.roadService = roadService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<RoadDTO> promotedMovies = roadService.findAllPromotedRoads();
        model.addAttribute("heading", "Promoted roads");
        model.addAttribute("description", "Roads required by our team");
        model.addAttribute("roads", promotedMovies);
        return "road-listing";
    }
}
