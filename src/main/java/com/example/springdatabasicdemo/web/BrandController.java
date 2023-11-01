package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.models.Brand;
import com.example.springdatabasicdemo.services.BrandService;
import com.example.springdatabasicdemo.services.dtos.BrandDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/brand")
public class BrandController {
    private final BrandService brandService;
    private final ModelMapper modelMapper;

    public BrandController(BrandService brandService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.modelMapper = modelMapper;
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
        return "redirect:/brand/all";
    }

    @GetMapping("/create")
    public String addNewBrand(){
        return "addNewBrand";
    }

    @PostMapping("/create")
    public String addNewBrand(@RequestBody BrandDto brandDto){
        brandService.add(brandDto);
        return "redirect:/brand/all";
    }

    @GetMapping("/change/{id}")
    public String changeBrand(Model model, @PathVariable("id") UUID uuid){
        Optional<Brand> dbBrand = brandService.findBrand(uuid);
        if (dbBrand.isPresent()) {
            BrandDto brandDto = modelMapper.map(dbBrand.get(), BrandDto.class);
            model.addAttribute("brand", brandDto);
            return "editBrand";
        } else {
            return "brandNotFound";
        }
    }
    @PostMapping("/change/{id}")
    public String saveChangeBrand(@PathVariable("id") UUID uuid, @RequestBody BrandDto brandDto) {
        Optional<Brand> dbBrand = brandService.findBrand(uuid);
        if (dbBrand.isPresent()) {
            brandService.update(brandDto);
            return "redirect:/brand/all";
        } else {
            return "brandNotFound";
        }
    }
}
