package com.italoccosta.schedule.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.italoccosta.schedule.model.entities.Agendamento;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

}
