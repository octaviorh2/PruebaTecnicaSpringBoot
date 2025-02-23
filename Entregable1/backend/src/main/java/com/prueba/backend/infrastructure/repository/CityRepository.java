package com.prueba.backend.infrastructure.repository;


import com.prueba.backend.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City , Long> {
}
