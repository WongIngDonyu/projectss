package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.services.BrandService;
import com.example.springdatabasicdemo.services.dtos.BrandDto;
import com.example.springdatabasicdemo.services.dtos.ModelDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/brand")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String viewAllBrands(Model model){
        model.addAttribute(brandService.getAll());
        return "allBrands";
    }

    @GetMapping("/find/{id}")
    public String findBrand(Model model, @PathVariable("id") UUID uuid){
        model.addAttribute(brandService.findBrand(uuid));
        return "findBrand";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBrand(@PathVariable("id") UUID uuid){
        brandService.delete(uuid);
        return "redirect:/all";
    }

    @GetMapping("/create")
    public String addNewBrand(){
        return "addNewBrand";
    }

    @PostMapping("/create")
    public String addNewBrand(@RequestBody BrandDto brandDto){
        brandService.add(brandDto);
        return "redirect:/all";
    }

    //остался добавить запрос на изменение тип гет запрос и пост
}
