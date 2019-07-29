package com.example.demo1.controller;

import com.example.demo1.exception.JokeNotFoundExcpetion;
import com.example.demo1.exception.ResourceNotFoundException;
import com.example.demo1.model.Joke;
import com.example.demo1.repository.JokeRepository;
import com.example.demo1.service.impl.JokeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
public class JokeController {
    @Autowired
    private JokeServiceImpl jokeService;

    /**
     * 获取所有的jokes
     * @return
     */
    @GetMapping("/api/jokes")
    public List<Joke> getAllJokes(){
        List<Joke> jokes = jokeService.findAll();
        return  jokes;

    }

    /**
     * 获取一个joke
     * @param id
     * @return
     */
    @GetMapping("/api/jokes/{id}")
    public Joke getJokeById(@PathVariable(value = "id") int id){
        try{
            return jokeService.findById(id);
        }catch (JokeNotFoundExcpetion e){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"not found！！",e);

        }

    }

    /**
     * 保存
     * @param joke
     * @return
     */
    @PostMapping("/api/jokes")
    public  List<Joke>  newJoke(@Valid @RequestBody Joke joke){
        jokeService.save(joke);

        return jokeService.findAll();

    }

    /**
     * 修改
     * @param id
     * @param joke
     */
    @PutMapping("/api/jokes/{id}")
    public Joke upateJokeById(@PathVariable(value="id")int id,@RequestBody Joke joke){
       return jokeService.upateJokeById(id,joke);

    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping("/api/jokes/{id}")
    public List<Joke> deleteJokeById(@PathVariable(value="id")int id){
        jokeService.deleteById(id);
        return jokeService.findAll();

    }

    @GetMapping("/api/notfund")
    public String notException(){
        throw  new EntityNotFoundException();
    }
    @GetMapping("/api/run")
    public String runException(){
        throw  new RuntimeException();
    }


}
