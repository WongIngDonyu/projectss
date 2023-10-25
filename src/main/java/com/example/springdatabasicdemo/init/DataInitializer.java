package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.models.Model;
import com.example.springdatabasicdemo.models.Offer;
import com.example.springdatabasicdemo.models.UserRole;
import com.example.springdatabasicdemo.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BrandService brandService;

    private final ModelService modelService;

    private final UserRoleService userRoleService;

    private final UserService userService;

    private final OfferService offerService;

    public DataInitializer(BrandService brandService, ModelService modelService, UserRoleService userRoleService, UserService userService, OfferService offerService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.userRoleService = userRoleService;
        this.userService = userService;
        this.offerService = offerService;
    }


    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() throws IOException {
        BrandDto b1 = new BrandDto(UUID.randomUUID(),"Zoo",null, null);
        BrandDto sb1 = brandService.add(b1);
        sb1.setName("LOX");
        brandService.update(sb1);
        ModelDto m1 = new ModelDto(UUID.randomUUID(),"Zoo1", Model.Category.Motorcycle, "SomeUrl", 2023, 2054,null, null);
        ModelDto modelDto = modelService.add(m1, sb1);
        modelDto.setName("alallala");
        modelService.update(modelDto);
        UserRoleDto userRoleDto = new UserRoleDto(UUID.randomUUID(), UserRole.Role.User);
        UserRoleDto userRoleDto1 = userRoleService.add(userRoleDto);
        userRoleDto1.setRole(UserRole.Role.Admin);
        userRoleService.update(userRoleDto1);
        UserDto userDto = new UserDto(UUID.randomUUID(), "azazLO","1488","Egor", "Ananasiy", true, "someUrl",null, null);
        UserDto userDro1 = userService.add(userDto, userRoleDto1);
        userDro1.setActive(false);
        userService.update(userDro1);
        OfferDto offerDto = new OfferDto(UUID.randomUUID(),"somekool", Offer.Engine.DIESEL, "someUrl", 100, 100000, Offer.Transmission.AUTOMATIC, 2003, null, null);
        OfferDto offerDto1 = offerService.add(offerDto, modelDto, userDro1);
        offerDto1.setPrice(10);
        offerService.update(offerDto1);
    }
}

    /*BrandDto b1 = new BrandDto(UUID.randomUUID(),"Zoo");
    BrandDto sb1 = brandService.add(b1);
    BrandDto b2 = new BrandDto(UUID.randomUUID(),"zzzzzz");
    BrandDto sb2 = brandService.add(b2);

    ModelDto m1 = new ModelDto(UUID.randomUUID(),"Zoo1", Category.Truck, "SomeUrl", 2023, 2054, sb1);
    ModelDto modelDto1=modelService.add(m1);
    ModelDto modelDto = new ModelDto(UUID.randomUUID(),"sadasd", Category.Car, "123213", 2023, 2054, sb2);
    //modelService.update(m1.getId(), modelDto);
    //brandService.delete(1);

    BrandDto b3 = new BrandDto(UUID.randomUUID(),"22222");
    //brandService.update(2, b3);
    UserRoleDto u1 = new UserRoleDto(UUID.randomUUID(), Role.User);
    UserRoleDto userRoleDto = userRoleService.add(u1);
    UserDto userDto = new UserDto(UUID.randomUUID(), "azazLO","1488","Egor", "Ananasiy", true, "someUrl",userRoleDto);
    UserDto userDto1 = userService.add(userDto);
    OfferDto offerDto = new OfferDto(UUID.randomUUID(),"somekool", Engine.DIESEL, "someUrl", 100, 100000, Transmission.AUTOMATIC, 2003, modelDto1, userDto1);
        offerService.add(offerDto);*/
