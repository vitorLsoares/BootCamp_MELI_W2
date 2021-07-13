package br.com.meli.link.tracker.exception;

import java.io.IOException;

public class ConectionException extends IOException {
    public ConectionException(String mensagem) {
        super(mensagem);
    }
}
