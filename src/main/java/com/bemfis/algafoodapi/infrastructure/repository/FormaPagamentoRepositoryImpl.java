package com.bemfis.algafoodapi.infrastructure.repository;

import com.bemfis.algafoodapi.domain.model.FormaPagamento;
import com.bemfis.algafoodapi.domain.repository.FormaPagamentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {
    @PersistenceContext //injeta EntityManager
    private EntityManager manager;
    //gerencia o contexto de persistencia, intermediação dos comandos em tradução para sql.
    //com esse EntityManager podemos salvar um objeto no banco, fazer consultas, etc.

    @Override
    public List<FormaPagamento> todas() {
        //createQuery cria uma consulta, tem como argumento uma String (consulta JPQL) e o tipo do retorno da consulta.
        //createQuery retorna uma consulta tipada de cozinha (TypedQuery).
        //getResultList retorna uma lista de cozinha.
        return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
    }
    @Override
    public FormaPagamento porId(Long id) {
        //faz um select from Cozinha where id é igual ao id recebido.
        return manager.find(FormaPagamento.class, id);
    }

    //quando fazemos uma modificação no nosso banco de dados precisamos de uma transação
    //método adicionar foi alterado para salvar, já que serve para adicionar e atualizar
    @Override
    @Transactional //esse método será executado dentro de uma transação
    public FormaPagamento salvar(FormaPagamento formaPagamento) {
        return manager.merge(formaPagamento);
    }

    @Override
    @Transactional
    public void remover(FormaPagamento formaPagamento) {
        //we need to change from transient state to managed state for the JPA to be able to manage.
        formaPagamento = porId(formaPagamento.getId());
        manager.remove(formaPagamento);
    }
}
