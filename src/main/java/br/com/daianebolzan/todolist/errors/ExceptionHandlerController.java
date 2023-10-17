package br.com.daianebolzan.todolist.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

  
    @ExceptionHandler(HttpMessageNotReadableException.class )
    public ResponseEntity <String> handleHttpMessageNotReadableException(handleHttpMessageNotReadableException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(((Throwable) e.getMostSpecificCause()).getMessage());

    }
}
