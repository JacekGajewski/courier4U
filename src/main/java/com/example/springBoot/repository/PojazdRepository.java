package com.example.springBoot.repository;

import com.example.springBoot.entity.Pojazd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "cars")
public interface PojazdRepository extends JpaRepository<Pojazd, Integer> {


}
