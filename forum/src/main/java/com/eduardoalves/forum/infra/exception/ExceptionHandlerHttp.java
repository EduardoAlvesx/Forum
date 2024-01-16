package com.eduardoalves.forum.infra.exception;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ExceptionHandlerHttp {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException exception) {
        var erros = exception.getFieldErrors();

        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro500(EntityNotFoundException exception) {
        var erros = exception.getMessage();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entidade não encontrada");
    }
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity tratarDuplicates(SQLIntegrityConstraintViolationException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Elemento já existe");
    }
}
