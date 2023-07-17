package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Query("select distinct s.client.clientName from Sale s where s.sale_date = :date")
    List<String> findClientNamesBySaleDate(LocalDate date);
    /*@Query("select distinct t.toyName from Sale s join s.toys t where s.id = :saleId")
    List<String> findToyNamesBySaleId(Long saleId);*/
}


