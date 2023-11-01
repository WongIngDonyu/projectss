package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.services.BrandService;
import com.example.springdatabasicdemo.services.UserService;
import com.example.springdatabasicdemo.services.dtos.BrandDto;
import com.example.springdatabasicdemo.services.dtos.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String viewAllUsers(Model model){
        model.addAttribute(userService.getAll());
        return "allUsers";
    }

    @GetMapping("/find/{id}")
    public String findUser(Model model, @PathVariable("id") UUID uuid){
        model.addAttribute(userService.findUser(uuid));
        return "findUser";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") UUID uuid){
        userService.delete(uuid);
        return "redirect:/all";
    }

    @GetMapping("/create")
    public String addNewUser(){
        return "addNewUser";
    }

    @PostMapping("/create")
    public String addNewUser(@RequestBody UserDto userDto){
        userService.add(userDto);
        return "redirect:/all";
    }
}
