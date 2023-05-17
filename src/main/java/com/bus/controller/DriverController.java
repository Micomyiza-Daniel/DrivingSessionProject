package com.bus.controller;

import com.bus.model.DriverModel;
import com.bus.repository.DriverRepository;
import com.bus.service.implementation.DriverImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class DriverController {
    @Autowired
    DriverRepository repo;

    private final DriverImplementation driverService;

    public DriverController(DriverImplementation driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/registerDriver")
    public String DriverPage(Model model){
        model.addAttribute("driverRequest", new DriverModel());
        return "register_page";
    }

    @GetMapping("/Users")
    public String UserList(Model model){
        List<DriverModel> ListOfUsers = driverService.userList();
        model.addAttribute("ListOfUsers", ListOfUsers);
        return "display";
    }


    @PostMapping("/registerDriver")
    public String register(@ModelAttribute DriverModel driver){
        System.out.println("register request: " + driver);

        DriverModel registerDriver = driverService.registerDriver(driver);

        return registerDriver == null ? "error_page" : "redirect:/Users";

    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Integer id, Model model){
        Optional<DriverModel> userData = repo.findFirstById(id);
        DriverModel driver = userData.get();
        model.addAttribute("driver",driver );

        return "updatePage";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        repo.deleteById(id);
        return "redirect:/Users";
    }
}
