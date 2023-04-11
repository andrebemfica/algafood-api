package com.bemfis.algafoodapi.infrastructure.repository;

import com.bemfis.algafoodapi.domain.model.Estado;
import com.bemfis.algafoodapi.domain.repository.EstadoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
public class EstadoRepositoryImpl implements EstadoRepository {
    @PersistenceContext //injeta EntityManager
    private EntityManager manager;
    //gerencia o contexto de persistencia, intermediação dos comandos em tradução para sql.
    //com esse EntityManager podemos salvar um objeto no banco, fazer consultas, etc.

    @Override
    public List<Estado> todos() {
        //createQuery cria uma consulta, tem como argumento uma String (consulta JPQL) e o tipo do retorno da consulta.
        //createQuery retorna uma consulta tipada de cozinha (TypedQuery).
        //getResultList retorna uma lista de cozinha.
        return manager.createQuery("from Estado", Estado.class).getResultList();
    }
    @Override
    public Estado porId(Long id) {
        //faz um select from Cozinha where id é igual ao id recebido.
        return manager.find(Estado.class, id);
    }

    //quando fazemos uma modificação no nosso banco de dados precisamos de uma transação
    //método adicionar foi alterado para salvar, já que serve para adicionar e atualizar
    @Override
    @Transactional //esse método será executado dentro de uma transação
    public Estado salvar(Estado estado) {
        return manager.merge(estado);
    }

    @Override
    @Transactional
    public void remover(Estado estado) {
        //we need to change from transient state to managed state for the JPA to be able to manage.
        estado = porId(estado.getId());
        manager.remove(estado);
    }
}
