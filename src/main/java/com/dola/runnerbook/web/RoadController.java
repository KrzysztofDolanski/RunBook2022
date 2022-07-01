package com.dola.runnerbook.web;

import com.dola.runnerbook.domain.rating.RatingService;
import com.dola.runnerbook.domain.road.RoadService;
import com.dola.runnerbook.domain.road.dto.RoadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
public class RoadController {
    private final RoadService roadService;
    private final RatingService ratingService;

    public RoadController(RoadService roadService, RatingService ratingService) {
        this.roadService = roadService;
        this.ratingService = ratingService;
    }

    @GetMapping("/road/{id}")
    public String getRoad(@PathVariable long id, Model model, Authentication authentication) {
        RoadDTO road = roadService.findRoadById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("road", road);
        //Jeżeli użytkownik jest zalogowany
        if (authentication != null) {
            String currentUserEmail = authentication.getName();
            //to wyszukujemy jego głos
            Integer rating = ratingService.getUserRatingForMovie(currentUserEmail, id).orElse(0);
            //i zapisujemy go w modelu
            model.addAttribute("userRating", rating);
        }
        return "road";
    }
}
