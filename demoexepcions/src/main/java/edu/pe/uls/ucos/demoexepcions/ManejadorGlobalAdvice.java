package edu.pe.uls.ucos.demoexepcions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class ManejadorGlobalAdvice {
    @ExceptionHandler (ProductoInvalidoException.class)
    public ResponseEntity<String> manejarProductoInvalido(ProductoInvalidoException ex) {
        return ResponseEntity .status(HttpStatus.BAD_REQUEST) .body(ex.getMessage());
    }
    @ExceptionHandler (Exception.class)
    public ResponseEntity<String> manejarProductoRepetidp(Exception ex) {
        return ResponseEntity .status(HttpStatus.INTERNAL_SERVER_ERROR) .body(ex.getMessage());
    }
    @ExceptionHandler (ProductoRepetidoException.class)
    public ResponseEntity<String> manejarProductoRepetidp(ProductoRepetidoException ex) {
        return ResponseEntity .status(HttpStatus.BAD_REQUEST) .body(ex.getMessage());
    }
}

