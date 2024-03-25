package org.akiratran.hibermusic.controllers;

import jakarta.validation.Valid;
import org.akiratran.hibermusic.model.MusicInfo;
import org.akiratran.hibermusic.model.User;
import org.akiratran.hibermusic.services.MusicInfoService;
import org.akiratran.hibermusic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

/**
 * Controls the different url endpoints, each endpoint returns a different view
 * depending on the logic.
 */

@Controller
public class UserController {
    private UserService userService;
    private MusicInfoService musicInfoService;

    /**
     * Creates a new instance of the UserController
     * @param userService {Object} - contains methods use for User data manipulation
     * @param musicInfoService {Object} - contains methods use for MusicInfo data manipulation
     */
    @Autowired
    public UserController(UserService userService, MusicInfoService musicInfoService) {
        this.userService = userService;
        this.musicInfoService = musicInfoService;
    }

    /**
     * When accessing /home will redirect to the home view. In addition, stores
     * 2 list of music infos trending and likes to be displayed in home view
     * @param model {object} - model object contains the likes and trending musicinfos
     * @return {String} - returns the string home to view the thymeleaf home page
     */
    @GetMapping("/home")
    public String homePage(Model model) {
        List<MusicInfo> trending = musicInfoService.findTrendingSong();
        model.addAttribute("trending", trending);
        List<MusicInfo> likes = musicInfoService.findMostLikedSong();
        model.addAttribute("likes", likes);
        return "home";
    }

    /**
     * When accessing /about will redirect to the about view page
     * @return {String} - returns the string to about to view the thymeleaf view page
     */
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    /**
     * When a music card is clicked redirects to the musicinfopage
     * @param mid {Long} - The mid that belongs to the click music
     * @param model {Object} - model object contains the musicinfo of the clicked music
     * @return {String} - returns the musicinfopage string to view the thymeleaf musicinfopage
     */
    @PostMapping("/click/musicInfo")
    public String addToPlaylist(@RequestParam("mid") Long mid, Model model) {
        MusicInfo clickedMusicInfo = musicInfoService.findMusicInfoByMid(mid);
        model.addAttribute("clickedMusicInfo", clickedMusicInfo);
        return "/musicinfopage";
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

    @GetMapping("/delete")
    public String delete() {
        return "delete";
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

    /**
     * Deletes the account
     * @param principal {object} - The current authenticated user
     * @return {String} - returns the delete string to view the thymeleaf delete view
     */
    @PostMapping("/profile/deleted")
    public String deleteUser(Principal principal) {
        String email = principal.getName();
        userService.deleteUser(email);
        return "/delete";
    }
}
