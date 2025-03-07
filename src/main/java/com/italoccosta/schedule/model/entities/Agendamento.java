package com.italoccosta.schedule.model.entities;

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
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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

    
    public boolean podeAlterarOuCancelar() {
        return LocalDate.now().isBefore(this.dataAtendimento.minusDays(3));
    }
}
