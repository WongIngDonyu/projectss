package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.*;
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
    private SaleService saleService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ClientService clientService;
    @Autowired
    private ToyService toyService;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() throws IOException {
        //Добавление в БД записей

        ClientDto c1 = new ClientDto(0, "Egor", "+11111111111", "Egor@gmail.com");
        ClientDto sc1 = clientService.add(c1);

        ClientDto c2 = new ClientDto(0, "Alah", "+11111111111", "Alah@gmail.com");
        ClientDto sc2 = clientService.add(c2);

        ToyDto t1 = new ToyDto(0, "Mishka ", "Mishka Fredy", "Страшилка", "228", "10000");
        ToyDto st1 = toyService.add(t1);

        ToyDto t2 = new ToyDto(0, "alalallalal ", "Chika", "Страшилка", "1233", "10000");
        ToyDto st2 = toyService.add(t2);

        ToyDto t3 = new ToyDto(0, "Mamut Rahal", "Mamut Rahal ", "Страшилка", "1488", "10000");
        ToyDto st3 = toyService.add(t3);

        List<ToyDto> toysList = new ArrayList<>();
        toysList.add(st1);
        toysList.add(st3);

        SaleDto sa1 = new SaleDto(0, LocalDate.of(2022,11,21), "1991", sc1, toysList);

        SaleDto sa2 = new SaleDto(0, LocalDate.of(2022,11,21), "2003", sc2, toysList);

        ReviewDto r1 = new ReviewDto(0, 5, "Нормас пивас", sc1, st1);

        saleService.register(sa1);
        saleService.register(sa2);
        reviewService.register(r1);


    }
}
