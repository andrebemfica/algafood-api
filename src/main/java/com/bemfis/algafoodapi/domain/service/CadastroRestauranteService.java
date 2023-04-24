package com.bemfis.algafoodapi.domain.service;

import com.bemfis.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.bemfis.algafoodapi.domain.model.Cozinha;
import com.bemfis.algafoodapi.domain.model.Restaurante;
import com.bemfis.algafoodapi.domain.repository.CozinhaRepository;
import com.bemfis.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroRestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;
    @Autowired
    private CozinhaRepository cozinhaRepository;

    public List<Restaurante> listar() {
        return restauranteRepository.listar();
    }

    public Restaurante buscar(Long restauranteId) {
        return restauranteRepository.buscar(restauranteId);
    }

    public Restaurante salvar(Restaurante restaurante) {
        Cozinha cozinha = cozinhaRepository.buscar(restaurante.getCozinha().getId());
        if (cozinha == null) {
            throw new EntidadeNaoEncontradaException(String.format(
                    "Não existe um cadastro de cozinha com o código %d", restaurante.getCozinha().getId()));
        }
        return restauranteRepository.salvar(restaurante);
    }
}
