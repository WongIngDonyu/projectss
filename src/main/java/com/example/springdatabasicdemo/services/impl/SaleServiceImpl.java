package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.SaleDto;
import com.example.springdatabasicdemo.dtos.ToyDto;
import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.models.Sale;
import com.example.springdatabasicdemo.models.Toy;
import com.example.springdatabasicdemo.repositories.ClientRepository;
import com.example.springdatabasicdemo.repositories.ReviewRepository;
import com.example.springdatabasicdemo.repositories.SaleRepository;
import com.example.springdatabasicdemo.repositories.ToyRepository;
import com.example.springdatabasicdemo.services.SaleService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService<Integer> {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ToyRepository toyRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    @Override
    public SaleDto register(SaleDto sale) {
        Sale sa = modelMapper.map(sale, Sale.class);
        if (sale.getClient().getId() != 0) {
            Client c = clientRepository.findById(sale.getClient().getId()).get();
            sa.setClient((Client) c);
        }
        List<Toy> toys = new ArrayList<>();
        for (ToyDto toyDto : sale.getToys()){
                Toy toy = modelMapper.map(toyDto, Toy.class);
                toys.add(toy);
        }
        sa.setToys(toys);
        return modelMapper.map(saleRepository.save(sa), SaleDto.class);
    }

    /*@Override
    public List<SaleDto> findSaleByGroup(String client, String toy) {
        Client clientObject = clientRepository.findByClientName(client);
        Toy toyObject = toyRepository.findByToyName(toy);
        return saleRepository.findAllByClientAndToy(clientObject, toyObject)
                .stream()
                .map(sa -> modelMapper.map(sa, SaleDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public SaleDto register(SaleDto sale) {
        Sale sa = modelMapper.map(sale, Sale.class);
        if (sale.getClient().getId() != 0) {
            Client c = clientRepository.findById(sale.getClient().getId()).get();
            sa.setClient((Client) c);
        }
        List<Toy> toys = new ArrayList<>();
        for (ToyDto toyDto : sale.getToys()){
            if (toyDto.getId() != 0) {
                Toy t = toyRepository.findById(toyDto.getId()).orElse(null);
                if (t != null) {
                    toys.add(t);
                } else {
                    // Обработайте ситуацию, если игрушки с таким ID нет в базе данных
                    // Можете бросить исключение или выполнить другие действия
                }
            }
        }
        sa.setToys(toys);
        return modelMapper.map(saleRepository.save(sa), SaleDto.class);
    }
    */
}
