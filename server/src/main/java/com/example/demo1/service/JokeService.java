package com.example.demo1.service;

import com.example.demo1.model.Joke;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface JokeService {
    public List<Joke> findAll();
    public  Joke save(Joke joke);
    public Joke findById(int id);
    public Joke upateJokeById(int id,Joke joke);
    public void deleteById(int id);

}
