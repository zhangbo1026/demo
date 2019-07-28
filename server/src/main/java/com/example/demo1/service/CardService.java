package com.example.demo1.service;

import com.example.demo1.model.Card;


import java.util.List;

public interface CardService {
    void deleteById(int id);

    void upateJokeById(int id, Card card);

    Card save(Card card);

    List<Card> findAll();

    List<Card> findCardsByJokeId(int jokeId);

    Card findById(int id);
}
