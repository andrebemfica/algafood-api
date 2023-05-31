package com.bemfis.algafoodapi.domain.service;

import com.bemfis.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.bemfis.algafoodapi.domain.model.Cozinha;
import com.bemfis.algafoodapi.domain.model.Restaurante;
import com.bemfis.algafoodapi.domain.repository.CozinhaRepository;
import com.bemfis.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroRestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;
    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        Optional<Cozinha> cozinhaOpt = cozinhaRepository.findById(restaurante.getCozinha().getId());

        if (cozinhaOpt.isEmpty()) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cozinha com o código %d", restaurante.getCozinha().getId()));
        }

        restaurante.setCozinha(cozinhaOpt.get());
        return restauranteRepository.save(restaurante);
    }

    public void remover(Long restauranteId) {
        Optional<Restaurante> restauranteOpt = restauranteRepository.findById(restauranteId);

        if (restauranteOpt.isEmpty()) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de restaurante com o código %d", restauranteId));
        }

        restauranteRepository.deleteById(restauranteId);

    }
}
