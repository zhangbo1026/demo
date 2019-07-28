package com.example.demo1.controller;

import com.example.demo1.model.Card;
import com.example.demo1.model.Joke;
import com.example.demo1.service.impl.CardServiceImpl;
import com.example.demo1.service.impl.JokeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {
    @Autowired
    private CardServiceImpl cardService;

    /**
     * 获取所有的cards
     * @return
     */
    @GetMapping("/api/cards")
    public List<Card> getAllCards(){
        List<Card> cards = cardService.findAll();
        return  cards;

    }

    @GetMapping("/api/cards/{id}")
    public Card getCardById(@PathVariable(value = "id") int id){
        return cardService.findById(id);
    }


    /**
     * 保存
     * @param card
     * @return
     */
    @PostMapping("/api/card")
    public Card newCard(@RequestBody Card  card){

        return cardService.save(card);

    }

    /**
     * 修改
     * @param id
     * @param card
     */
    @PutMapping("/api/cards/{id}")
    public void upateCardById(@PathVariable(value="id")int id,@RequestBody Card card){
        cardService.upateJokeById(id,card);

    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping("/api/cards/{id}")
    public void deleteCardById(@PathVariable(value="id")int id){
        cardService.deleteById(id);

    }

    /**
     * 根据jokeID获取card
     * @param jokeId
     * @return
     */
    @GetMapping("/api/cards/{jokeId}")
    public List<Card> getAllCardByJokeId(@PathVariable(value="jokeId")int jokeId){
        List<Card> cards = cardService.findCardsByJokeId(jokeId);
        return  cards;

    }
}
