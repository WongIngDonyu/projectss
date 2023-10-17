package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.models.enums.Category;
import com.example.springdatabasicdemo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DataInitializer implements CommandLineRunner {
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
        BrandDto b2 = new BrandDto(0,"zzzzzz");
        BrandDto sb2 = brandService.add(b2);

        ModelDto m1 = new ModelDto(0,"Zoo1", Category.Truck, "SomeUrl", 2023, 2054, sb1);
        modelService.add(m1);
        ModelDto modelDto = new ModelDto(0,"sadasd", Category.Car, "SomeUrl", 2023, 2054, sb2);
        modelService.update(1, modelDto);
    }
}
