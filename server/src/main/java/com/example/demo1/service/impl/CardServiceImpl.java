package com.example.demo1.service.impl;

import com.example.demo1.model.Card;
import com.example.demo1.model.Joke;
import com.example.demo1.repository.CardRepository;
import com.example.demo1.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteById(int id) {
        cardRepository.deleteById(id);
    }

    /**
     * 修改
     * @param id
     * @param card
     */
    @Override
    public void upateJokeById(int id, Card card) {
      cardRepository.findById(id).get();

       cardRepository.save(card);

    }


    /**
     * 根据ID查询Card
     * @param id
     * @return
     */
    @Override
    public Card findById(int id) {

        return cardRepository.findById(id).get();
    }
    /**
     * 保存
     * @param card
     * @return
     */
    @Override
    public Card save(Card card) {

        return cardRepository.save(card);
    }

    /**
     * 查询
     * @return
     */
    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    /**
     * 根据jokeid获取cards
     * @param jokeId
     * @return
     */
    @Override
    public List<Card> findCardsByJokeId(int jokeId) {
        return cardRepository.findCardsByJokeId(jokeId);
    }
}
