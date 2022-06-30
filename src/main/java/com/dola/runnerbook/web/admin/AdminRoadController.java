package com.dola.runnerbook.web.admin;

import com.dola.runnerbook.domain.genre.GenreService;
import com.dola.runnerbook.domain.genre.dto.GenreDTO;
import com.dola.runnerbook.domain.road.RoadService;
import com.dola.runnerbook.domain.road.dto.RoadDTO;
import com.dola.runnerbook.domain.road.dto.RoadSaveDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AdminRoadController {

    private final RoadService roadService;
    private final GenreService genreService;

    public AdminRoadController(RoadService roadService, GenreService genreService) {
        this.roadService = roadService;
        this.genreService = genreService;
    }

    @GetMapping("/admin/add-road")
    public String addMovieForm(Model model) {
        List<GenreDTO> allGenres = genreService.findAllGenres();
        model.addAttribute("genres", allGenres);
        RoadSaveDTO road = new RoadSaveDTO();
        model.addAttribute("road", road);
        return "admin/road-form";
    }

    @PostMapping("/admin/add-road")
    public String addMovie(RoadSaveDTO roadSaveDTO, RedirectAttributes redirectAttributes) {
        roadService.addRoad(roadSaveDTO);
        redirectAttributes.addFlashAttribute(
                AdminController.NOTIFICATION_ATTRIBUTE,
                "Road %s was saved".formatted(roadSaveDTO.getName()));
        return "redirect:/admin";
    }
}
