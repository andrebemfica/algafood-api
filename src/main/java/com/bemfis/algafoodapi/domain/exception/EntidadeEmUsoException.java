package com.bemfis.algafoodapi.domain.exception;

public class EntidadeEmUsoException extends RuntimeException{
    private static final Long serialVersionUID = 1l;
    public EntidadeEmUsoException(String message) {
        super(message);
    }
}
