package com.br.lucassilvamartines.exceptions;

public class BadRequest extends RuntimeException{
    public BadRequest(String message) {
        super(message);
    }
}
