package com.bemfis.algafoodapi.domain.repository;

import com.bemfis.algafoodapi.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {
    List<Estado> todos();
    Estado porId(Long id);
    Estado salvar(Estado estado);
    void remover(Estado estado);
}
