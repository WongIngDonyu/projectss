package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.SaleDto;
import com.example.springdatabasicdemo.dtos.SaleShortDto;
import com.example.springdatabasicdemo.dtos.ToyDto;
import com.example.springdatabasicdemo.models.Sale;
import com.example.springdatabasicdemo.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping("/sales")
    Iterable<SaleShortDto> all() {
        return saleService.getAll();
    }

    @GetMapping("/sales/{id}")
    SaleShortDto one(@PathVariable Integer id) throws Throwable {

        return (SaleShortDto) saleService.findSale(id)
                .orElseThrow(() -> new SaleNotFoundException(id));
    }

    @PostMapping("/sales")
    SaleDto newSale(@RequestBody SaleDto newSale){
        return saleService.register(newSale);
    }

    @DeleteMapping("/sales/{id}")
    void deleteSale(@PathVariable Integer id) {
        saleService.delete(id);
    }

    @GetMapping("/sales/clientsBySaleDate/{date}")
    public List<String> clientsByDateSale(@PathVariable LocalDate date) {
        List<String> clients = saleService.findClientsBySaleDate(date);
        if (clients.isEmpty()) {
            throw new SaleNotFoundException(date);
        }
        return clients;
    }

   @GetMapping("/sales/{sale_price}/{toyId}")
   public List<Long> findSalesByAmountAndToyId(@PathVariable Long toyId, @PathVariable String sale_price) {
       List<Long> sales = saleService.findSaleIdsByAmountAndToyId(sale_price, toyId);
       return sales;
   }
    @GetMapping("/sales/{id}/toys")
    public List<ToyDto> getToysBySaleId(@PathVariable Long id) {
        return saleService.findToysBySaleId(id);
    }
}
