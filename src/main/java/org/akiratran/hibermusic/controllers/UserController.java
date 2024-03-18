package org.akiratran.hibermusic.controllers;

import jakarta.validation.Valid;
import org.akiratran.hibermusic.model.User;
import org.akiratran.hibermusic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "signup";
    }

    @PostMapping("/signup/save")
    public String createUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model) {
        User existingUser = userService.findByUserEmail(newUser.getEmail());
        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            System.out.println("user exist"); //help debug statement
            result.rejectValue("email", "null", "There is already an account with the given email");
        }
        if(result.hasErrors()) {
            System.out.println("error happened"); //debug statement
            model.addAttribute("newUser", newUser);
            return "/signup";
        }
        userService.saveUser(newUser);
        return "redirect:/signup?success";
    }

}
