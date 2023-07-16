package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.models.*;
import com.example.springdatabasicdemo.repositories.ClientRepository;
import com.example.springdatabasicdemo.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private SaleService saleService;

    @Autowired
    private ReviewService reviewService;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() throws IOException {
        //Добавление в БД записей

        ClientDto c1 = new ClientDto(0, "Egor", "+11111111111", "Egor@gmail.com");

        ToyDto t1 = new ToyDto(0, "Mishka ", "Mishka Fredy", "Страшилка", "1488", "1337");

        SaleDto sa1 = new SaleDto(0, LocalDate.of(2022,11,21), "1488", c1, t1);

        ReviewDto r1 = new ReviewDto(0, 5, "Нормас пивас", c1, t1);

        saleService.register(sa1);
        reviewService.register(r1);
    }
}
