package com.bruno.feliciano.desafio_votacao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VotoInvalidoException extends RuntimeException {
    public VotoInvalidoException(String message) {
        super(message);
    }
}
