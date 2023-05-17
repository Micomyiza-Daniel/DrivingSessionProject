package com.bus.controller;

import com.bus.model.UserModel;
import com.bus.service.implementation.UserImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserImplementation userService;

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new UserModel());
        return "signUp";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new UserModel());
        return "signin";
    }


    @GetMapping("/registerAccount")
    public String getAccountPage(Model model) {
        model.addAttribute("AccountRequest", new UserModel());
        return "register_page";
    }



    @PostMapping("/register")
    public String register(@ModelAttribute UserModel userModel) {
        System.out.println("register request: " + userModel);
        UserModel registerUser = userService.createUser(userModel);
        return registerUser == null ? "error_page" : "redirect:/login";
    }

//    @PostMapping("/registerAccount")
//    public String accountRegister(@ModelAttribute UserModel userModel) {
//        System.out.println("account request: " + userModel);
//        //        UserModel user = userService.retrieveUser(userModel.getEmail());
//
//        UserModel accountUser = userService.retrieveUser(userModel.getEmail());
//        UserModel user = userService.UpdateUser(userModel.getEmail());
//        return user == null ? "error_page" : "redirect:/login";
//    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, Model model) {
        System.out.println("login request: " + userModel);
        UserModel authenticate = userService.getUser(userModel);

        if (authenticate != null) {
            model.addAttribute("userLogin", authenticate.getEmail());
            return "register_page";
        } else {
            return "error_page";
        }
    }


//    @PostMapping("/registerAccount")
//    public String updateUser( UserModel userModel, Model model) {

//        UserModel user = userService.retrieveUser(userModel.getEmail());
//        model.addAttribute("update", user);
//        userService.UpdateUser(userModel);
//        UserModel user = new UserModel(userModel.getEmail());
//        UserModel getUser = userService.UpdateUser(userModel);


//        UserModel user = new UserModel(userModel.getEmail());

//        UserModel users = userService.getUser(use.getEmail());
//        users.setEmail(use.getEmail());
//        userService.UpdateUser(users);
//        return "error_page";
//
//
//    }

}

