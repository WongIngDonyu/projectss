package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.SaleDto;
import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.models.Sale;
import com.example.springdatabasicdemo.models.Toy;
import com.example.springdatabasicdemo.repositories.ClientRepository;
import com.example.springdatabasicdemo.repositories.SaleRepository;
import com.example.springdatabasicdemo.repositories.ToyRepository;
import com.example.springdatabasicdemo.services.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
            sa.setClient((Client) c);
        }
        if (sale.getToy().getId() != 0) {
            Toy t = toyRepository.findById(sale.getToy().getId()).get();
            sa.setToys((List<Toy>) t);
        }
        return modelMapper.map(saleRepository.save(sa), SaleDto.class);
    }

    @Override
    public void expel(Integer id) {
        saleRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public void expel(SaleDto sale) {
        saleRepository.deleteById((long) sale.getId());
    }


    @Override
    public List<SaleDto> getAll() {
        return saleRepository.findAll().stream().map((sa) -> modelMapper.map(sa, SaleDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<SaleDto> findSales(String client, String toy) {
        return saleRepository.findByClientClientNameAndToysToyName(client, toy)
                .stream()
                .map(sa -> modelMapper.map(sa, SaleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SaleDto> findSale(Integer id) {
        return Optional.empty();
    }
}
