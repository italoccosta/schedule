package com.italoccosta.schedule.exceptions.globalHandler;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.italoccosta.schedule.exceptions.AgendamentoNaoEncontradoException;
import com.italoccosta.schedule.exceptions.ClienteNaoCadastradoException;
import com.italoccosta.schedule.exceptions.DataInvalidaException;



@ControllerAdvice
public class TratamentoHandlerException extends ResponseEntityExceptionHandler{

    @ExceptionHandler(AgendamentoNaoEncontradoException.class)
    private ResponseEntity<String> agendamentoNaoEncontradoHandler (AgendamentoNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }


    @ExceptionHandler(ClienteNaoCadastradoException.class)
    private ResponseEntity<String> clienteNaoCadastradoHandler (ClienteNaoCadastradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(DataInvalidaException.class)
    private ResponseEntity<String> dataInvalidaHandler (DataInvalidaException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    private ResponseEntity<String> entradaDuplicadaHandler(SQLIntegrityConstraintViolationException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Entrada Duplicada");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private ResponseEntity<String> globalExceptionHandler(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado");
    }
}
