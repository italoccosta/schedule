package com.italoccosta.schedule.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italoccosta.schedule.exceptions.ClienteNaoCadastradoException;
import com.italoccosta.schedule.model.entities.Cliente;
import com.italoccosta.schedule.model.repository.CleinteRepository;
import com.italoccosta.schedule.services.ClienteService;


@Service
public class CleinteServiceImpl implements ClienteService {

    @Autowired
    private CleinteRepository clRepository;


    @Override
    public void cadastrarCleinte(Cliente cliente) {
        clRepository.save(cliente);
    }

    @Override
    public void atualizarTelefone(Long id, String telefone) {
        Cliente temp = clRepository.findById(id)
        .orElseThrow(() -> new ClienteNaoCadastradoException("Cliente não encontrado!"));

            temp.setTelefone(telefone);
            clRepository.save(temp);
    }

    @Override
    public void excluirCadastro(Long id) {
        Cliente temp = clRepository.findById(id)
        .orElseThrow(() -> new ClienteNaoCadastradoException("Cliente não encontrado!"));
            
        clRepository.delete(temp);
    }

    @Override
    public Iterable<Cliente> exibirTodos() {
        return clRepository.findAll();
    }
}
