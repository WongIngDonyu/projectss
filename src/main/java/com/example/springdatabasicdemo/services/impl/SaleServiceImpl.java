package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.SaleDto;
import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.models.Sale;
import com.example.springdatabasicdemo.models.Toy;
import com.example.springdatabasicdemo.repositories.ClientRepository;
import com.example.springdatabasicdemo.repositories.ReviewRepository;
import com.example.springdatabasicdemo.repositories.SaleRepository;
import com.example.springdatabasicdemo.repositories.ToyRepository;
import com.example.springdatabasicdemo.services.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public SaleDto register(SaleDto sale) {
        Sale sa = modelMapper.map(sale, Sale.class);
        if (sale.getClient().getId() != 0) {
            Client c = clientRepository.findById(sale.getClient().getId()).get();
            sa.setClient((List<Client>) c);
        }
        if (sale.getToy().getId() != 0) {
            Toy t = toyRepository.findById(sale.getToy().getId()).get();
            sa.setToy((List<Toy>) t);
        }
        return modelMapper.map(saleRepository.save(sa), SaleDto.class);
    }

    @Override
    public List<SaleDto> findSaleByGroup(String client) {
        return null;
    }
    @Override
    public List<SaleDto> findSaleByGroup(String client, String toy) {
        Client clientObject = clientRepository.findByClientName(client);
        Toy toyObject = toyRepository.findByToyName(toy);
        return saleRepository.findAllByClientAndToy(clientObject, toyObject)
                .stream()
                .map(sa -> modelMapper.map(sa, SaleDto.class))
                .collect(Collectors.toList());
    }
}
