package com.example.complaints.exceptions;


import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Map;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class ComplaintException extends ResponseEntityExceptionHandler{
    
    
    @ExceptionHandler(ComplaintNotFoundException.class)
    public ResponseEntity<ExceptionResponse> ProfileNotFoundException(ComplaintNotFoundException ex){
        ExceptionResponse res = new ExceptionResponse();
        res.setErrorCode("NOT_FOUND");
        res.setErrorMessage(ex.getMessage());
        res.setTimestamp(LocalDateTime.now());
        
        return new ResponseEntity<ExceptionResponse>(res, HttpStatus.NOT_FOUND);
    }
    
    
    
    
//    @ExceptionHandler(DoctorAlreadyExistException.class)
protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
             HttpHeaders header,HttpStatus status,WebRequest request){
         Map<String,String> errors=new HashMap<>();
         ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName=((FieldError) error).getField();
            String messsage=error.getDefaultMessage();
            errors.put(fieldName, messsage);
         });
         return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
         
     }
     
     



}