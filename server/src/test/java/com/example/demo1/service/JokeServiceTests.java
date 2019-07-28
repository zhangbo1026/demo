package com.example.demo1.service;

import com.example.demo1.model.Joke;
import com.example.demo1.repository.JokeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest

public class JokeServiceTests {
    @Autowired
    JokeService jokeService;
    @MockBean
    JokeRepository jokeRepository;
    @Before
    public void setUp() {
        /*Joke joke = new Joke("Joke1");
        joke.setId(11);
        Joke joke1 = new Joke("Joke2");
        joke1.setId(22);
        List<Joke> allJokes = Arrays.asList(joke, joke1);

        Mockito.when(repository.findById(joke.getId())).thenReturn(Optional.of(joke));
        Mockito.when(repository.findById(joke1.getId())).thenReturn(Optional.of(joke1));

        Mockito.when(repository.findById(0)).thenReturn(null);

        Mockito.when(repository.save(new Joke("Joke2"))).thenReturn(joke1);

        Mockito.when(repository.findAll()).thenReturn(allJokes);*/
        Joke joke = new Joke("测试");
        joke.setId(1);
        Joke joke1 = new Joke("测试2");
        joke1.setId(2);
        List<Joke> allJokes = Arrays.asList(joke,joke1);
        Mockito.when(jokeRepository.findById(joke.getId())).thenReturn(Optional.of(joke));
        Mockito.when(jokeRepository.findById(joke1.getId())).thenReturn(Optional.of(joke1));
        Mockito.when(jokeRepository.findById(0)).thenReturn(null);
        Mockito.when(jokeRepository.save(new Joke("测试2"))).thenReturn(joke1);
        Mockito.when(jokeRepository.findAll()).thenReturn(allJokes);

    }
    @Test
    public void given2Jokes_when_getAllJokes_thenReturn2Records() {
        Joke joke = new Joke("测试");
        joke.setId(1);
        Joke joke2 = new Joke("测试2");
        joke.setId(2);
        List<Joke> allJokes =jokeService.findAll();
        assertThat(allJokes).hasSize(2).extracting(Joke::getContent).
                contains(joke.getContent(),joke2.getContent());
    }


    @Test
    public void givenRightJokeId_thenReturnJoke() {
        Joke joke = this.jokeService.findById(1);
        assertThat(joke).extracting("content").
                contains("测试");
    }


}
