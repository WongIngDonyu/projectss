package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.services.ModelService;
import com.example.springdatabasicdemo.services.dtos.BrandDto;
import com.example.springdatabasicdemo.services.dtos.ModelDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/model")
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/all")
    public String viewAllModels(Model model){
        model.addAttribute(modelService.getAll());
        return "allModels";
    }

    @GetMapping("/find/{id}")
    public String findModel(Model model, @PathVariable("id") UUID uuid){
        model.addAttribute(modelService.findModel(uuid));
        return "findModel";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteModel(@PathVariable("id") UUID uuid){
        modelService.delete(uuid);
        return "redirect:/all";
    }

    @GetMapping("/create")
    public String addNewModel(){
        return "addNewModel";
    }

    @PostMapping("/create")
    public String addNewModel(@RequestBody ModelDto modelDto){
        modelService.add(modelDto);
        return "redirect:/all";
    }
}
