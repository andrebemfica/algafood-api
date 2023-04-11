package com.bemfis.algafoodapi.domain.repository;

import com.bemfis.algafoodapi.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {
    List<Permissao> todas();
    Permissao porId(Long id);
    Permissao salvar(Permissao permissao);
    void remover(Permissao permissao);
}
