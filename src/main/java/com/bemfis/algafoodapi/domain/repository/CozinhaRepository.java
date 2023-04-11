package com.bemfis.algafoodapi.domain.repository;

import com.bemfis.algafoodapi.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {
    List<Cozinha> todas();
    Cozinha porId(Long id);
    Cozinha salvar(Cozinha cozinha);
    void remover(Cozinha cozinha);
}
