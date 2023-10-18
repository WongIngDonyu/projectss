package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.models.enums.Category;
import com.example.springdatabasicdemo.models.enums.Engine;
import com.example.springdatabasicdemo.models.enums.Role;
import com.example.springdatabasicdemo.models.enums.Transmission;
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
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserService userService;
    @Autowired
    private OfferService offerService;


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
        ModelDto modelDto1=modelService.add(m1);
        ModelDto modelDto = new ModelDto(0,"sadasd", Category.Car, "123213", 2023, 2054, sb2);
        modelService.update(1, modelDto);
        brandService.delete(1);

        BrandDto b3 = new BrandDto(0,"22222");
        brandService.update(2, b3);
        UserRoleDto u1 = new UserRoleDto(1, Role.User);
        UserRoleDto userRoleDto = userRoleService.add(u1);
        UserDto userDto = new UserDto(0, "azazLO","1488","Egor", "Ananasiy", true, "someUrl",userRoleDto);
        UserDto userDto1 = userService.add(userDto);
        OfferDto offerDto = new OfferDto(0,"somekool", Engine.DIESEL, "someUrl", 100, 100000, Transmission.AUTOMATIC, 2003, modelDto1, userDto1);
        offerService.add(offerDto);
    }
}
