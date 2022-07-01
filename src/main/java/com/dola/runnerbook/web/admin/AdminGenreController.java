package com.dola.runnerbook.web.admin;

import com.dola.runnerbook.domain.genre.GenreService;
import com.dola.runnerbook.domain.genre.dto.GenreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminGenreController {

    private final GenreService genreService;

    @Autowired
    public AdminGenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/admin/add-genre")
    public String addGenreForm(Model model) {
        GenreDTO genre = new GenreDTO();
        model.addAttribute("genre", genre);
        return "admin/genre-form";
    }

    @PostMapping("/admin/add-genre")
    public String addGenre(GenreDTO genre, RedirectAttributes redirectAttributes) {
        genreService.addGenre(genre);
        redirectAttributes.addFlashAttribute(
                AdminController.NOTIFICATION_ATTRIBUTE,
                "Genre %s successful saved".formatted(genre.getName()));
        return "redirect:/admin";
    }
}
