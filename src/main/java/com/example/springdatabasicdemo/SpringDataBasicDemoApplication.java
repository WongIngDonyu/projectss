package com.example.springdatabasicdemo;

import com.example.springdatabasicdemo.models.Offer;
import com.example.springdatabasicdemo.services.dtos.OfferDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataBasicDemoApplication {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        modelMapper.createTypeMap(Offer.class, OfferDto.class)
                .addMapping(src -> src.getUser().getUsername(), OfferDto::setUsername);

        return modelMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataBasicDemoApplication.class, args);
    }

}
