package com.dola.runnerbook.web;

import com.dola.runnerbook.domain.user.UserService;
import com.dola.runnerbook.domain.user.dto.UserRegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registrationForm(Model model) {
        UserRegistrationDTO userRegistration = new UserRegistrationDTO();
        model.addAttribute("user", userRegistration);
        return "registration-form";
    }

    @PostMapping("/register")
    public String register(UserRegistrationDTO userRegistration) {
        userService.registerUserWithDefaultRole(userRegistration);
        return "redirect:/";
    }
}
