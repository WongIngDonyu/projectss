package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.services.OfferService;
import com.example.springdatabasicdemo.services.dtos.BrandDto;
import com.example.springdatabasicdemo.services.dtos.OfferDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/offer")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/all")
    public String viewAllOffers(Model model){
        model.addAttribute(offerService.getAll());
        return "allOffers";
    }

    @GetMapping("/find/{id}")
    public String findOffer(Model model, @PathVariable("id") UUID uuid){
        model.addAttribute(offerService.findOffer(uuid));
        return "findOffer";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOffer(@PathVariable("id") UUID uuid){
        offerService.delete(uuid);
        return "redirect:/all";
    }

    @GetMapping("/create")
    public String addNewOffer(){
        return "addNewOffer";
    }

    @PostMapping("/create")
    public String addNewOffer(@RequestBody OfferDto offerDto){
        offerService.add(offerDto);
        return "redirect:/all";
    }
}
