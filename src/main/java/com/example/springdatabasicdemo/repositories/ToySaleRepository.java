package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.ToySale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToySaleRepository extends JpaRepository<ToySale, Long> {

}
