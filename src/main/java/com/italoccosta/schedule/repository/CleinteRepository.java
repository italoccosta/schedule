package com.italoccosta.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.italoccosta.schedule.entities.Cliente;


public interface CleinteRepository extends JpaRepository<Long, Cliente> {


}
