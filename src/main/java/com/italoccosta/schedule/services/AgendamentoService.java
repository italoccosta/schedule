package com.italoccosta.schedule.services;



import com.italoccosta.schedule.model.dto.AgendamentoDTO;
import com.italoccosta.schedule.model.dto.ReagendarDTO;
import com.italoccosta.schedule.model.entities.Agendamento;

public interface AgendamentoService {

     AgendamentoDTO novoAgendamento(Agendamento novo, Long clienteId);
     void cancelarAgendamento(Long id);
     void reAgendar(Long id, ReagendarDTO novaDataEHora);
     Iterable<Agendamento> exibirTodos();

}
