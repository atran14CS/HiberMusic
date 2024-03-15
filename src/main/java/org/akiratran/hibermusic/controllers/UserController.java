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
    public String loginPage() {
        return "login";
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
            result.rejectValue("email", "null", "There is already an account with the given email");
        }
        if(result.hasErrors()) {
            model.addAttribute("newUser", newUser);
        }
        userService.saveUser(newUser);
        return "redirect:/signup?success";
    }

//    @PostMapping("/register/save")
//    public String registration(@Valid @ModelAttribute("student") StudentDto studentDto, BindingResult result,
//                               Model model) {
//        Student existingStudent = studentService.findStudentByEmail(studentDto.getEmail());
//
//        if (existingStudent != null && existingStudent.getEmail() != null && !existingStudent.getEmail().isEmpty()) {
//            result.rejectValue("email", null, "There is already an account registered with the same email");
//        }
//
//        if (result.hasErrors()) {
//            model.addAttribute("student", studentDto);
//
//            return "/register";
//        }
//
//        studentService.saveStudent(studentDto);
//        return "redirect:/register?success";
//
//    }

}
