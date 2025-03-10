package com.italoccosta.schedule.services.implementation;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italoccosta.schedule.enums.StatusAgendamento;
import com.italoccosta.schedule.exceptions.AgendamentoNaoEncontradoException;
import com.italoccosta.schedule.exceptions.DataInvalidaException;
import com.italoccosta.schedule.model.entities.Agendamento;
import com.italoccosta.schedule.model.entities.Cliente;
import com.italoccosta.schedule.model.repository.AgendamentoRepository;
import com.italoccosta.schedule.model.repository.CleinteRepository;
import com.italoccosta.schedule.services.AgendamentoService;


@Service
public class AgendamentoServiceImpl implements AgendamentoService {

    @Autowired
    private AgendamentoRepository agRepository;

    @Autowired
    private CleinteRepository clRepository;

    @Override
    public void novoAgendamento(Agendamento novo, Long clienteId) {
        Cliente cliente = clRepository.findById(clienteId).orElseThrow(null);
        if (novo.getDataAtendimento().isAfter(LocalDate.now())){
            novo.setCliente(cliente);
            agRepository.save(novo);
        }else{
            throw new DataInvalidaException("A data do atendimento precisa ser futura!");
        }
    }
    
    @Override
    public void cancelarAgendamento(Long id) {
        Agendamento temp = encontrarAgendamento(id);

            if (temp.podeAlterarOuCancelar()) {
                temp.setStatus(StatusAgendamento.CANCELADO);
                agRepository.save(temp);
            }else {
                throw new DataInvalidaException("Prazo indisponível! O atendimento será realizado em menos de 72h");
            }
    }

    
    @Override
    public void reAgendar(Long id, LocalDate novaData) {
        Agendamento temp = encontrarAgendamento(id);
        
        if (temp.podeAlterarOuCancelar()) {
            temp.setDataAtendimento(novaData);
            agRepository.save(temp);
        }else {
            throw new DataInvalidaException("Prazo indisponível! O atendimento será realizado em menos de 72h");
        }
    }
    
    @Override
    public Iterable<Agendamento> exibirTodos() {
        return agRepository.findAll();
    }
    
    private Agendamento encontrarAgendamento(Long id) {
        Agendamento temp = agRepository.findById(id)
        .orElseThrow(() -> new AgendamentoNaoEncontradoException("Atendimento não encontrado!"));
        return temp;
    }
}
