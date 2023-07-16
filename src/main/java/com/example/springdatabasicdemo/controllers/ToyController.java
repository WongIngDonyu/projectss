package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.ToyDto;
import com.example.springdatabasicdemo.services.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToyController {
    @Autowired
    private ToyService toyService;

    @GetMapping("/toys")
    Iterable<ToyDto> all() {
        return toyService.getAll();
    }

    @GetMapping("/toys/{id}")
    ToyDto one(@PathVariable Integer id) throws Throwable {
        return (ToyDto) toyService.findToy(id)
                .orElseThrow(() -> new ToyNotFoundException(id));
    }

    @PostMapping("/toys")
        ToyDto newClient(@RequestBody ToyDto newToy){
            return toyService.register(newToy);
        }

    @DeleteMapping("/toys/{id}")
    void deleteToy(@PathVariable Integer id) {toyService.expel(id);}
}
