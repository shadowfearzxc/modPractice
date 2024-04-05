package com.example.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.webservice.model.security.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
