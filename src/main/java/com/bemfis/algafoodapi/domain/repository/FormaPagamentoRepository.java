package com.bemfis.algafoodapi.domain.repository;

import com.bemfis.algafoodapi.domain.model.FormaPagamento;

import java.util.List;

public interface FormaPagamentoRepository {
    List<FormaPagamento> todas();
    FormaPagamento porId(Long id);
    FormaPagamento salvar(FormaPagamento formaPagamento);
    void remover(FormaPagamento formaPagamento);
}
