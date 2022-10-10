package com.example.demo.repo;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
