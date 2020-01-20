package com.example.springBoot.repository;

import com.example.springBoot.entity.Kurier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "couriers")
public interface KurierRepository extends JpaRepository<Kurier ,Integer> {

    List<Kurier> findAllByOrderByOcena();

}
