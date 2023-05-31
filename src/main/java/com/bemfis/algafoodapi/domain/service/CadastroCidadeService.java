package com.bemfis.algafoodapi.domain.service;

import com.bemfis.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.bemfis.algafoodapi.domain.model.Cidade;
import com.bemfis.algafoodapi.domain.model.Estado;
import com.bemfis.algafoodapi.domain.repository.CidadeRepository;
import com.bemfis.algafoodapi.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroCidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade) {
        Optional<Estado> estadoOpt = estadoRepository.findById(cidade.getEstado().getId());
        if (estadoOpt.isEmpty()) {
            throw new EntidadeNaoEncontradaException(String.format(
                    "Não existe um cadastro de estado com o código %d", cidade.getEstado().getId()));
        }
        cidade.setEstado(estadoOpt.get());
        return cidadeRepository.save(cidade);
    }

    public void remover(Long cidadeId) {
        Optional<Cidade> cidadeOpt = cidadeRepository.findById(cidadeId);

        if (cidadeOpt.isEmpty()) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cidade com o código: %d", cidadeId));
        }
        cidadeRepository.deleteById(cidadeId);
    }
}
