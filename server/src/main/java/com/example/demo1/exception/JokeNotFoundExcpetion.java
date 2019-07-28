package com.example.demo1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "jokeRequest Not found")
public class JokeNotFoundExcpetion extends RuntimeException {
    public JokeNotFoundExcpetion(String errorMsg){
        super(errorMsg);
    }
    @Override
    public String getMessage(){
        return super.getMessage();

    }
}
