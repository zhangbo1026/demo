package com.example.demo1.repository;

import com.example.demo1.model.Joke;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JokeRepositoryTests {
    @Autowired
    JokeRepository jokeRepository;
    Joke joke1,joke2;
    @Before
    public void setUp(){
        this.jokeRepository.deleteAll();
        joke1 = new Joke();
        joke1.setContent("nihao");
        joke1.setTitle("title");
        joke1.setCreateAt(new Date());
        joke1.setUpdatedAt(new Date());
        jokeRepository.save(joke1);
        joke2 = new Joke();
        joke2.setContent("nihao2");
        joke2.setTitle("title2");
        joke2.setCreateAt(new Date());
        joke2.setUpdatedAt(new Date());
        jokeRepository.save(joke2);



    }
    @Test
    public void getJokeList_Then_ReturnJokeList(){
        List<Joke> jokeList = jokeRepository.findAll();
        assertThat(jokeList.size()).isEqualTo(2);
        Joke joke = jokeList.get(0);
        assertThat(joke.getTitle()).isNotNull();
    }

   /* @After
    public void cleanJokes(){
        jokeRepository.deleteAll();

    }*/
}
