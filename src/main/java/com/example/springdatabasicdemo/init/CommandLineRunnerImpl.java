package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.models.enums.Category;
import com.example.springdatabasicdemo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Autowired
    private BrandService brandService;
    @Autowired
    private ModelService modelService;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() throws IOException {
        BrandDto b1 = new BrandDto(0,"Zoo");
        BrandDto sb1 = brandService.add(b1);

        ModelDto m1 = new ModelDto("Zoo1", Category.Truck, "SomeUrl", 2023, 2054, sb1);
        modelService.add(m1);
    }
}
