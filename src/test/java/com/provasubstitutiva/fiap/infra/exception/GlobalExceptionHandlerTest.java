package com.provasubstitutiva.fiap.infra.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void testHandleNotFound() {
        NoSuchElementException exception = new NoSuchElementException("Recurso não encontrado");
        ResponseEntity<String> response = handler.handleNotFound(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Recurso não encontrado", response.getBody());
    }

    @Test
    void testHandleConflict() {
        IllegalStateException exception = new IllegalStateException("Conflito de estado");
        ResponseEntity<String> response = handler.handleConflict(exception);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals("Conflito de estado", response.getBody());
    }
}
