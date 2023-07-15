package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.models.Sale;
import com.example.springdatabasicdemo.models.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    Collection<Sale> findAllByClientAndToy(Client client, Toy toy);
}

