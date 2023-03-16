package com.example.MantenedorTareas.exceptions;


import com.example.MantenedorTareas.MantenedorTareasApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value= {ToDoExceptions.class})

    protected ResponseEntity<Object> handleConflict(ToDoExceptions excep, WebRequest request){
        String bodyOfResponse =excep.getMessage();




        return handleExceptionInternal  (excep, bodyOfResponse ,new HttpHeaders(), excep.getHttpStatus(), request);
    }
}
