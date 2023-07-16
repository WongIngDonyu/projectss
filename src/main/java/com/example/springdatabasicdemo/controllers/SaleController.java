package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.SaleDto;
import com.example.springdatabasicdemo.dtos.StudentDto;
import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.services.SaleService;
import com.example.springdatabasicdemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping("/sales")
    Iterable<SaleDto> all() {
        return saleService.getAll();
    }

    @GetMapping("/sales/{id}")
    SaleDto one(@PathVariable Integer id) throws Throwable {

        return (SaleDto) saleService.findSale(id)
                .orElseThrow(() -> new SaleNotFoundExeption(id));
    }

    @PostMapping("/sales")
    SaleDto newSale(@RequestBody SaleDto newSale){
        return saleService.register(newSale);
    }

    @DeleteMapping("/sales/{id}")
    void deleteSale(@PathVariable Integer id) {
        saleService.expel(id);
    }
    @GetMapping("/sales/clientsBySaleDate/{date}")
    public List<String> clientsByDateSale(@PathVariable LocalDate date){
        return saleService.findClientsBySaleDate(date);
    }
    @GetMapping("/sales/toysBySale/{saleId}")
    public List<String> toysBySale(@PathVariable Long saleId){
        return saleService.findToyNamesBySaleId(saleId);
    }
}
