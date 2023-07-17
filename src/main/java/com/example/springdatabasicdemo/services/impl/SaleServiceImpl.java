package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.SaleDto;
import com.example.springdatabasicdemo.dtos.ToyDto;
import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.models.Sale;
import com.example.springdatabasicdemo.models.Toy;
import com.example.springdatabasicdemo.models.ToySale;
import com.example.springdatabasicdemo.repositories.*;
import com.example.springdatabasicdemo.services.SaleService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService<Integer> {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ToySaleRepository toySaleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SaleDto register(SaleDto sale) {
        Sale sa = modelMapper.map(sale, Sale.class);
        if (sale.getClient().getId() != 0) {
            Client c = clientRepository.findById(sale.getClient().getId()).get();
            sa.setClient(c);
        }
        sa = saleRepository.save(sa);
        List<ToySale> toySales  = new ArrayList<>();
        for (ToyDto toyDto : sale.getToys()){
            Toy toy = modelMapper.map(toyDto, Toy.class);
            ToySale toySale = new ToySale();
            toySale.setSale(sa);
            toySale.setToy(toy);
            toySales.add(toySale);
        }
        toySaleRepository.saveAll(toySales);
        return modelMapper.map(sa, SaleDto.class);
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
    public Optional<SaleDto> findSale(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<String> findClientsBySaleDate(LocalDate date){
        return saleRepository.findClientNamesBySaleDate(date);
    }
    /*@Override
    public List<String> findToyNamesBySaleId (Long saleId){
        return saleRepository.findToyNamesBySaleId(saleId);
    }*/

}
