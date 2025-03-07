package com.italoccosta.schedule.services;

import com.italoccosta.schedule.model.entities.Cliente;

public interface ClienteService {
    
    void cadastrarCleinte(Cliente cliente);
    void atualizarTelefone(Long id, String telefone);
    void excluirCadastro(Long id);
    Iterable<Cliente> exibirTodos();
}
