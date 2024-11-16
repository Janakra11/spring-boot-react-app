package com.codewithjanak.fullstack_backend.repository;

import com.codewithjanak.fullstack_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    public Optional<User> findById(Long id);

    public List<User> findAll();

}
