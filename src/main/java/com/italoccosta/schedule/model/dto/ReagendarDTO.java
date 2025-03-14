package com.italoccosta.schedule.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record ReagendarDTO(

    @JsonFormat(pattern = "dd/MM/yy")
    LocalDate novaData,

    @JsonFormat(pattern = "HH:mm")
    LocalTime novaHora

) {

}
