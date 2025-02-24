package com.italoccosta.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.italoccosta.schedule.entities.Agendamento;


public interface AgendamentoRepository extends JpaRepository<Long, Agendamento>{

}
