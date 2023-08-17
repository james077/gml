package com.gml.technicalproof.exception.handler;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class PokemonServiceExceptionHandler  {


  @ExceptionHandler(value = { NullPointerException.class})
  public final ResponseEntity handleConflict(RuntimeException ex) {
    if (ex instanceof NullPointerException) {
      log.error("Error con algun dato faltante", ex);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    } else {
      log.error("Error no controlado", ex);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

}
