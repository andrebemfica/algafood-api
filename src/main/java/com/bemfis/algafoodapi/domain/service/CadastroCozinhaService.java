package com.bemfis.algafoodapi.domain.service;

import com.bemfis.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.bemfis.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.bemfis.algafoodapi.domain.model.Cozinha;
import com.bemfis.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroCozinhaService {
    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }
    public void remover(Long cozinhaId) {
        Optional<Cozinha> cozinhaOpt = cozinhaRepository.findById(cozinhaId);

        if(cozinhaOpt.isEmpty()){
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cozinha com o código %d", cozinhaId));
        }

        try {
            cozinhaRepository.deleteById(cozinhaId);

        } catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                    String.format("Cozinha de código %d não pode ser removida, pois está em uso.", cozinhaId));
        }
    }
}
