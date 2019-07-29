package com.example.demo1.repository;

import com.example.demo1.model.Card;
import com.example.demo1.model.Joke;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
    @Query(value = "select * from card where jokeId= :jokeId ",nativeQuery = true)
    public List<Card> findCardsByJokeId(@Param("jokeId") Integer jokeId);
}
