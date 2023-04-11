package com.bemfis.algafoodapi.infrastructure.repository;

import com.bemfis.algafoodapi.domain.model.Permissao;
import com.bemfis.algafoodapi.domain.repository.PermissaoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {
    @PersistenceContext //injeta EntityManager
    private EntityManager manager;
    //gerencia o contexto de persistencia, intermediação dos comandos em tradução para sql.
    //com esse EntityManager podemos salvar um objeto no banco, fazer consultas, etc.

    @Override
    public List<Permissao> todas() {
        //createQuery cria uma consulta, tem como argumento uma String (consulta JPQL) e o tipo do retorno da consulta.
        //createQuery retorna uma consulta tipada de cozinha (TypedQuery).
        //getResultList retorna uma lista de cozinha.
        return manager.createQuery("from Permissao", Permissao.class).getResultList();
    }
    @Override
    public Permissao porId(Long id) {
        //faz um select from Cozinha where id é igual ao id recebido.
        return manager.find(Permissao.class, id);
    }

    //quando fazemos uma modificação no nosso banco de dados precisamos de uma transação
    //método adicionar foi alterado para salvar, já que serve para adicionar e atualizar
    @Override
    @Transactional //esse método será executado dentro de uma transação
    public Permissao salvar(Permissao permissao) {
        return manager.merge(permissao);
    }

    @Override
    @Transactional
    public void remover(Permissao permissao) {
        //we need to change from transient state to managed state for the JPA to be able to manage.
        permissao = porId(permissao.getId());
        manager.remove(permissao);
    }
}
