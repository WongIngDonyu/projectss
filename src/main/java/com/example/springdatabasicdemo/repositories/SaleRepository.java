package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByClientClientNameAndToysToyName(String clientName, String toyName);
}


