package com.example.api.repo;
import com.example.api.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<Users,Integer> {
    
    Users findByUsername(String username);
}
