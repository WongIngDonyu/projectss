package com.example.springdatabasicdemo;

import com.example.springdatabasicdemo.dtos.GroupDto;
import com.example.springdatabasicdemo.dtos.StudentDto;
import com.example.springdatabasicdemo.models.Group;
import com.example.springdatabasicdemo.models.Student;
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

        return modelMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataBasicDemoApplication.class, args);
    }

}
