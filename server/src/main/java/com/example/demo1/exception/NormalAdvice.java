package com.example.demo1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class NormalAdvice {
    /**
     * 404 not found
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String entityNotFoundHandler(EntityNotFoundException e){
        return e.getMessage()+"你好异常！";

    }
    /***
     * 500 internal error
     */
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private String internalServerErrorHandler(RuntimeException e){
        return e.getMessage()+"异常处理";

    }
}
