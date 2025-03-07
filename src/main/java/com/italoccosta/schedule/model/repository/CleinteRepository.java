package com.italoccosta.schedule.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.italoccosta.schedule.model.entities.Cliente;


public interface CleinteRepository extends JpaRepository<Cliente, Long> {


}
