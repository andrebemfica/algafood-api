package com.bemfis.algafoodapi.domain.service;

import com.bemfis.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.bemfis.algafoodapi.domain.model.Cozinha;
import com.bemfis.algafoodapi.domain.model.Restaurante;
import com.bemfis.algafoodapi.domain.repository.CozinhaRepository;
import com.bemfis.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroRestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;
    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        Cozinha cozinha = cozinhaRepository.buscar(restaurante.getCozinha().getId());
        if (cozinha == null) {
            throw new EntidadeNaoEncontradaException(String.format(
                    "Não existe um cadastro de cozinha com o código %d", restaurante.getCozinha().getId()));
        }
        restaurante.setCozinha(cozinha);
        return restauranteRepository.salvar(restaurante);
    }

    public void excluir(Long restauranteId){
        try{
           restauranteRepository.remover(restauranteId);
        } catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de restaurante com o código %d", restauranteId));
        }
    }
}
