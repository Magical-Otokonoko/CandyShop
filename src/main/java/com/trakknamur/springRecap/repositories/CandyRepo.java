package com.trakknamur.springRecap.repositories;

import com.trakknamur.springRecap.models.entities.Candy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandyRepo extends JpaRepository<Candy, Long> {
    Optional<Candy> findByLabel(String label);
}

