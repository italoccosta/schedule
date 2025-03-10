package com.italoccosta.schedule.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.italoccosta.schedule.model.entities.Cliente;
import com.italoccosta.schedule.services.ClienteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/clientes")
public class ClienteController {


    @Autowired
    private ClienteService clService;


    @GetMapping
    ResponseEntity<Iterable<Cliente>> exibirClientes(){
        return ResponseEntity.ok(clService.exibirTodos());
    }

    @PostMapping
    ResponseEntity<Cliente> criarCadastro(@RequestBody Cliente cliente){
        clService.cadastrarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping("atualizar/{id}")
    ResponseEntity<Cliente> atualizarTelefone(@PathVariable Long id,@RequestBody String telefone){
        clService.atualizarTelefone(id, telefone);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/excluir/{id}")
    ResponseEntity<Void> excluirCadastro(@PathVariable Long id) {
        clService.excluirCadastro(id);
        return ResponseEntity.noContent().build();
    }


}
