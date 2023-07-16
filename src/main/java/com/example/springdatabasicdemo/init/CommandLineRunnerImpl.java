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
import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

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
    /*
    private void printAllToyandClientsOnSaleandReview(String groupName, String clientName, String toyName) {
        studentService
                .findStudentsByGroup(groupName)
                .forEach(System.out::println);

        List<Sale> sales = saleService.findSaleByGroup(clientName, toyName);
        for (Sale sale : sales) {
            System.out.println("Sale ID: " + sale.getId());
            System.out.println("Sale Price: " + sale.getSale_price());
            System.out.println("Sale Date: " + sale.getSale_date());
            System.out.println("Clients:");
            for (Client client : sale.getClient()) {
                System.out.println("- Client ID: " + client.getId());
                System.out.println("  Client Name: " + client.getClientName());
                System.out.println("  Client Phone Number: " + client.getClientPhoneNumber());
                System.out.println("  Client Email: " + client.getClientEmail());
            }
            System.out.println("Toys:");
            for (Toy toy : sale.getToy()) {
                System.out.println("- Toy ID: " + toy.getId());
                System.out.println("  Toy Typename: " + toy.getToyTypename());
                System.out.println("  Toy Name: " + toy.getToyName());
                System.out.println("  Toy Description: " + toy.getToyDescription());
                System.out.println("  Toy Price: " + toy.getToyPrice());
                System.out.println("  Toy Quantity: " + toy.getToyQuantity());
            }
            System.out.println();
        }
    }*/

    private void seedData() throws IOException {
        //Добавление в БД записей

        ClientDto c1 = new ClientDto(0, "Egor", "+11111111111", "Egor@gmail.com");
        ClientDto sc1 = clientService.add(c1);

        ClientDto c2 = new ClientDto(0, "Alah", "+11111111111", "Alah@gmail.com");
        ClientDto sc2 = clientService.add(c2);

        ToyDto t1 = new ToyDto(0, "Mishka ", "Mishka Fredy", "Страшилка", "1488", "10000");
        ToyDto st1 = toyService.add(t1);

        ToyDto t2 = new ToyDto(0, "alalallalal ", "Mishka Fredy", "Страшилка", "1488", "10000");
        ToyDto st2 = toyService.add(t2);

        ToyDto t3 = new ToyDto(0, "Mamut Rahal", "Mamut Rahal ", "Страшилка", "1488", "10000");
        ToyDto st3 = toyService.add(t3);

        List<ToyDto> toysList = new ArrayList<>();
        toysList.add(st1);
        toysList.add(st3);

        SaleDto sa1 = new SaleDto(0, LocalDate.of(2022,11,21), "1488", sc1, toysList);

        SaleDto sa2 = new SaleDto(0, LocalDate.of(2022,11,21), "1488", sc2, toysList);

        ReviewDto r1 = new ReviewDto(0, 5, "Нормас пивас", sc1, st1);

        saleService.register(sa1);
        saleService.register(sa2);
        reviewService.register(r1);


    }
}
