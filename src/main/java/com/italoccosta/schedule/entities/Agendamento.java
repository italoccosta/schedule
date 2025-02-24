package com.italoccosta.schedule.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.italoccosta.schedule.enums.StatusAgendamento;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataAtendimento;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;
    private LocalDateTime criadoEm;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;


    public Agendamento(Cliente cliente, LocalDate dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
        this.cliente = cliente;
        status = StatusAgendamento.AGENDADO;
        criadoEm = LocalDateTime.now();
    }

    
    Boolean podeAlterarOuCancelar() {
        return LocalDate.now().isBefore(dataAtendimento.minusDays(3));
    }
    
    public Long getId() {
        return id;
    }

    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDate dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }
}
