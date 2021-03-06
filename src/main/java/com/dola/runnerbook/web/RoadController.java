package com.dola.runnerbook.web;

import com.dola.runnerbook.domain.rating.RatingService;
import com.dola.runnerbook.domain.road.RoadService;
import com.dola.runnerbook.domain.road.dto.RoadDTO;
import net.bytebuddy.implementation.bind.annotation.DefaultMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
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
    public String getRoad(@PathVariable long id, Model model, Authentication authentication, HttpServletRequest hsr) {
        RoadDTO road = roadService.findRoadById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        String distanceMapQuery = roadService.createDistanceMapQuery(road, hsr);
        model.addAttribute("road", road);

        model.addAttribute("distance", distanceMapQuery);
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


    @GetMapping("/top10")
    public String findTop10(Model model) {
        List<RoadDTO> top10Roads = roadService.findTopRoads(10);
        model.addAttribute("heading", "Roads TOP10");
        model.addAttribute("description", "Roads most willingly rated by Users");
        model.addAttribute("roads", top10Roads);
        return "road-listing";
    }
}
