package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.services.BrandService;
import com.example.springdatabasicdemo.services.UserRoleService;
import com.example.springdatabasicdemo.services.dtos.BrandDto;
import com.example.springdatabasicdemo.services.dtos.UserRoleDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@Controller
@RequestMapping("/role")
public class UserRoleController {
    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping("/all")
    public String viewAllUserRoles(Model model){
        model.addAttribute(userRoleService.getAll());
        return "allUserRoles";
    }

    @GetMapping("/find/{id}")
    public String findUserRole(Model model, @PathVariable("id") UUID uuid){
        model.addAttribute(userRoleService.findUserRole(uuid));
        return "findUserRole";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserRole(@PathVariable("id") UUID uuid){
        userRoleService.delete(uuid);
        return "redirect:/all";
    }

    @GetMapping("/create")
    public String addNewUserRole(){
        return "addNewRole";
    }

    @PostMapping("/create")
    public String addNewUserRole(@RequestBody UserRoleDto userRoleDto){
        userRoleService.add(userRoleDto);
        return "redirect:/all";
    }
}
