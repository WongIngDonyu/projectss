package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository  extends JpaRepository<UserRole, Integer> {
}
