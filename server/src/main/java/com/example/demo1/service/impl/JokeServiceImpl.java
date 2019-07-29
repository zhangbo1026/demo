package com.example.demo1.service.impl;

import com.example.demo1.exception.JokeNotFoundExcpetion;
import com.example.demo1.model.Joke;
import com.example.demo1.repository.JokeRepository;
import com.example.demo1.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JokeServiceImpl implements JokeService {
    @Autowired
    private JokeRepository jokeRepository;

    /**
     * 查询所有的jokes
     * @return
     */
    @Override
    public List<Joke> findAll() {
        return jokeRepository.findAll();
    }

    /**
     * 保存joke
     * @param joke
     * @return
     */
    @Override
    public Joke save(Joke joke) {
        return jokeRepository.save(joke);
    }

    /**
     * 根据ID查询joke
     * @param id
     * @return
     */
    @Override
    public Joke findById(int id){
       /* if (jokeRepository.findById(id).isPresent())

        return jokeRepository.findById(id).get();
        else throw new JokeNotFoundExcpetion("找不到");*/
        return jokeRepository.findById(id).orElseThrow(() -> new JokeNotFoundExcpetion("找不到"));
    }

    /**
     * 修改
     * @param id
     * @param joke
     */
    @Override
    public Joke upateJokeById(int id, Joke joke) {

        Joke joke1 = jokeRepository.findById(id).get();
        joke1.setContent(joke.getContent());
        joke1.setTitle(joke.getTitle());
        return jokeRepository.save(joke1);

    }

    @Override
    public void deleteById(int id) {
        jokeRepository.deleteById(id);

    }


}