package com.bemfis.algafoodapi.domain.repository;

import com.bemfis.algafoodapi.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {
    List<Cidade> todas();
    Cidade porId(Long id);
    Cidade salvar(Cidade cidade);
    void remover(Cidade cidade);
}
