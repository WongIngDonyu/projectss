package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.dtos.ToyDto;
import com.example.springdatabasicdemo.models.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToyRepository extends JpaRepository<Toy, Integer> {
}
