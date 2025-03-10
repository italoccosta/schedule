package com.italoccosta.schedule.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.italoccosta.schedule.model.dto.AgendamentoDTO;
import com.italoccosta.schedule.model.entities.Agendamento;
import com.italoccosta.schedule.services.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agService;

    @GetMapping
    ResponseEntity<Iterable<Agendamento>> exibirAgendamentos(){
        return ResponseEntity.ok(agService.exibirTodos());
    }

    @PostMapping("/{clienteId}")
    ResponseEntity<AgendamentoDTO> criarAgendamento(@RequestBody Agendamento novAgendamento, @PathVariable Long clienteId) {
        AgendamentoDTO novoDTO = agService.novoAgendamento(novAgendamento, clienteId);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(novoDTO);
    }

    @PutMapping("/reagendar/{id}")
    ResponseEntity<Void> reagendar(@PathVariable Long id,@RequestBody LocalDate novaData) {
        agService.reAgendar(id, novaData);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/cancelar/{id}")
    ResponseEntity<Void> cancelar(@PathVariable Long id) {
        agService.cancelarAgendamento(id);
        return ResponseEntity.ok().build();
    }

}
