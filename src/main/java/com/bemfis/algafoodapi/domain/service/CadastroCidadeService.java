package com.bemfis.algafoodapi.domain.service;

import com.bemfis.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.bemfis.algafoodapi.domain.model.Cidade;
import com.bemfis.algafoodapi.domain.model.Estado;
import com.bemfis.algafoodapi.domain.repository.CidadeRepository;
import com.bemfis.algafoodapi.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade){
        Estado estado = estadoRepository.buscar(cidade.getEstado().getId());
        if(estado == null){
            throw new EntidadeNaoEncontradaException(String.format(
                    "Não existe um cadastro de estado com o código %d", cidade.getEstado().getId()));
        }
        cidade.setEstado(estado);
        System.out.println(cidade.getEstado().getNome());
        return cidadeRepository.salvar(cidade);
    }

    public void remover(Long cidadeId){
        try{
            cidadeRepository.remover(cidadeId);
        } catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cidade com o código: %d", cidadeId));
        }
    }
}
