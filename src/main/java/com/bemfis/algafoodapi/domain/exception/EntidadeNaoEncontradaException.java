package com.bemfis.algafoodapi.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{
    private static final Long serialVersionUID = 1l;
    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}
