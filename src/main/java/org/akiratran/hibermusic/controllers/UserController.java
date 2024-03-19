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

/**
 * Controls the different url endpoints, each endpoint returns a different view
 * depending on the logic.
 */

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * When accessing the /home end point will redirect to the home view
     * @return {String} - returns the home string to view the thymeleaf home page
     */
    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    /**
     * When accessing the /login end point will redirect to the login view
     * @return {String} - returns the login string to view the thymeleaf login page
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * When accessing the /profile endpoint will redirect to the profile view
     * @return {String} - returns the profile string to view the thymeleaf profile page
     */
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    /**
     * Takes the input from the signup page and stores it in the model object
     * @param model - the input from the signup page
     * @return - returns the signup string to view the thymeleaf signup view
     */
    @GetMapping("/signup")
    public String signupPage(Model model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "signup";
    }

    /**
     * Creates a new user checking to make sure the user does not exist and redirects to a success url if
     * user does not exist and returns back to the signup if user does exist.
     * @param newUser {Object} - User object holds information about the new user signing up
     * @param result {Object} -  Result object contains information about the results of the query reject or non reject
     * @param model {Object} - Model object contains the search results of the newUser.
     * @return {String} - Returns to the success signup if newUser was able to be created or back to just signup
     */
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
