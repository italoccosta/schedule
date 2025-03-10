package com.italoccosta.schedule.services;

import java.time.LocalDate;

import com.italoccosta.schedule.model.entities.Agendamento;

public interface AgendamentoService {

     void novoAgendamento(Agendamento novo, Long clienteId);
     void cancelarAgendamento(Long id);
     void reAgendar(Long id, LocalDate novaData);
     Iterable<Agendamento> exibirTodos();

}
