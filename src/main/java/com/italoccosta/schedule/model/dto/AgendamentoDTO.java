package com.italoccosta.schedule.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record AgendamentoDTO(
        Long id,

        @JsonFormat(pattern = "dd/MM/yy")
        LocalDate dataAtendimento,
        
        @JsonFormat(pattern = "HH:mm")
        LocalTime hora,
        String status,

        @JsonFormat(pattern = "dd/MM/yy HH:mm")
        LocalDateTime criadoEm,
        String nomeCliente
) {}
