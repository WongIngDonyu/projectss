package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.models.Sale;
import com.example.springdatabasicdemo.models.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Query("select distinct s.client.clientName from Sale s where s.sale_date = :date")
    List<String> findClientNamesBySaleDate(LocalDate date);
    @Query("select s.id from Sale s join s.toySales ts where s.sale_price > :sale_price and ts.toy.id = :toyId")
    List<Long> findSaleIdsByAmountAndToyId(String sale_price,Long toyId);
    @Query("select ts.toy from ToySale ts where ts.sale.id = :saleId")
    List<Toy> findToysBySaleId(Long saleId);
}


