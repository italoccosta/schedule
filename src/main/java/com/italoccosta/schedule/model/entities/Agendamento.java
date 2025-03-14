package com.italoccosta.schedule.model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.italoccosta.schedule.enums.StatusAgendamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "agendamentos")
@Transactional
@Getter
@Setter
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yy")
    @Column(name = "data_atendimento")
    private LocalDate dataAtendimento;
    
    @JsonFormat(pattern = "HH:mm")
    private LocalTime hora;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status_agendamento", nullable = false)
    private StatusAgendamento status;
    
    @JsonFormat(pattern = "dd/MM/yy HH:mm")
    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Agendamento(){
        
    }

    
    public Agendamento(LocalDate dataAtendimento, LocalTime hora) {
        this.hora = hora;
        this.dataAtendimento = dataAtendimento;
    }

    
    public boolean podeAlterarOuCancelar() {
        return LocalDate.now().isBefore(this.dataAtendimento.minusDays(3));
    }

    @PrePersist
    public void setStatusEHoraCriacao(){
        this.status = StatusAgendamento.AGENDADO;
        this.criadoEm = LocalDateTime.now();
    }
}
