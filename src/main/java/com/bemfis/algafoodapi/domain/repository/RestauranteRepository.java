package com.bemfis.algafoodapi.domain.repository;

import com.bemfis.algafoodapi.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {
    List<Restaurante> todos();
    Restaurante porId(Long id);
    Restaurante salvar(Restaurante restaurante);
    void remover(Restaurante restaurante);
}
