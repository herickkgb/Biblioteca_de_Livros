package com.herick.book.exceptions;

import javax.servlet.ServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionsHandler {

    @ExceptionHandler(ObjectNotFoundExceptions.class)
    public ResponseEntity<StandartError> objectNotFoundExceptions(ObjectNotFoundExceptions e, ServletRequest request) {
        StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
                e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<StandartError> emptyResultDataAccessException(EmptyResultDataAccessException ex,
            ServletRequest request) {
        StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
                "Recurso não encontrado ou já foi removido.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandartError> dataIntegrityViolationException(DataIntegrityViolationException ex,
            ServletRequest request) {
        StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.CONFLICT.value(),
                "Violação de integridade de dados. Detalhes: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> methodArgumentNotValidException(MethodArgumentNotValidException ex,
            ServletRequest request) {
        ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                "Erro na validação dos campos");

        for (FieldError x : ex.getBindingResult().getFieldErrors()) {
            error.addErrors(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
